package com.gotze.blockbreaksounds.gui.favoritesounds;

import com.gotze.blockbreaksounds.BlockBreakSoundsPlugin;
import com.gotze.blockbreaksounds.gui.blockbreaksounds.BlockBreakSoundsGUI;
import com.gotze.blockbreaksounds.model.FavoriteSoundData;
import com.gotze.blockbreaksounds.model.SoundData;
import com.gotze.blockbreaksounds.util.GUIUtils;
import com.gotze.blockbreaksounds.util.SoundUtils;
import com.gotze.blockbreaksounds.util.ValidClickChecker;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public final class FavoriteSoundsGUIListener implements Listener {

    public FavoriteSoundsGUIListener() {}

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof FavoriteSoundsGUI)) return;
        event.setCancelled(true);

        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (ValidClickChecker.hasClickCooldown(player)) return;
        if (clickedInventory == null) return;
        if (clickedInventory.equals(player.getInventory())) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        switch (slot) {
            case 4: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
                if (clickType == ClickType.SHIFT_RIGHT) {
                    ItemStack clickedItem = clickedInventory.getItem(slot);
                    if (clickedItem == null) return;
                    if (clickedItem.getType() != Material.GLASS_PANE) {
                        new FavoriteSoundsGUI(player);
                    }
                }
                return;

            case 36: // Return
                SoundUtils.playUIClickSound(player);
                new BlockBreakSoundsGUI(player);
                return;

            default: // Favorited Sounds
                if (slot >= 9 && slot < 36) {
                    ItemStack clickedItem = clickedInventory.getItem(slot);

                    if (clickedItem == null || clickedItem.getType() == Material.PAPER) return;

                    if (clickType == ClickType.DROP) { // Remove sound from favorites
                        if (clickedItem.getType() != Material.BARRIER) {
                            ItemStack confirmClearFavoriteSound = createItemStack(Material.BARRIER, ChatColor.RED + convertToSmallFont("drop again to unfavorite"));
                            clickedInventory.setItem(slot, confirmClearFavoriteSound);

                            new BukkitRunnable() {
                                @Override public void run() {
                                    ItemStack itemAfterDelay = clickedInventory.getItem(slot);
                                    if (itemAfterDelay == null) return;

                                    if (itemAfterDelay.getType() == confirmClearFavoriteSound.getType()) {
                                        clickedInventory.setItem(slot, clickedItem); // item == original item
                                    }
                                }
                            }.runTaskLater(BlockBreakSoundsPlugin.INSTANCE, 60L);
                        }

                        if (clickedItem.getType() == Material.BARRIER) {
                            FavoriteSoundData.removeSoundFromFavorites(player, slot - 9);
                            new FavoriteSoundsGUI(player);
                        }
                        return;
                    }

                    if (clickType != ClickType.DROP) { // Set as current sound
                        SoundData favoriteSoundData = FavoriteSoundData.favoriteSounds.get(player.getUniqueId()).get(slot - 9);
                        if (favoriteSoundData == null) return;

                        favoriteSoundData.playSoundData(player);
                        GUIUtils.handlePickedLineSound(clickedInventory, slot);
                        clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                    }
                }
        }
    }
}