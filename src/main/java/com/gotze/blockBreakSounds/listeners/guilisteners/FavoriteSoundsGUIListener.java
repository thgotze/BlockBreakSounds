package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.Main;
import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;

public class FavoriteSoundsGUIListener implements Listener {

    public FavoriteSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("Favorite Sounds")) return;
        event.setCancelled(true);

        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (clickedInventory == null || clickedInventory.equals(player.getInventory())) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        switch (slot) {
            case 4: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
                if (clickType == ClickType.SHIFT_RIGHT && clickedInventory.getItem(slot).getType() != Material.GLASS_PANE) {
                    new FavoriteSoundsGUI(player);
                }
                return;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new BlockBreakSoundsGUI(player);
                return;

            default: // Favorited Sounds
                if (slot >= 9 && slot < 36) {
                    ItemStack item = clickedInventory.getItem(slot);

                    if (item == null || item.getType() == Material.PAPER) return;

                    if (clickType == ClickType.DROP) { // Remove sound from favorites
                        if (item.getType() != Material.BARRIER) {
                            ItemStack confirmClearFavoriteSound = createItemStack(Material.BARRIER, ChatColor.RED + "ᴅʀᴏᴘ ᴀɢᴀɪɴ ᴛᴏ ᴜɴꜰᴀᴠᴏʀɪᴛᴇ");
                            clickedInventory.setItem(slot, confirmClearFavoriteSound);

                            new BukkitRunnable() {
                                @Override public void run() {
                                    ItemStack itemAfterDelay = clickedInventory.getItem(slot);
                                    if (itemAfterDelay == null) return;

                                    if (itemAfterDelay.getType() == confirmClearFavoriteSound.getType()) {
                                        clickedInventory.setItem(slot, item); // item == original item
                                    }
                                }
                            }.runTaskLater(Main.INSTANCE, 60L);
                        }

                        if (item.getType() == Material.BARRIER) {
                            FavoriteSoundData.removeSoundFromFavorites(player, slot - 9);
                            new FavoriteSoundsGUI(player);
                        }
                        return;
                    }

                    if (clickType != ClickType.DROP) { // Set as current sound
                        SoundData favoriteSoundData = FavoriteSoundData.favoriteSounds.get(player.getUniqueId()).get(slot - 9);
                        if (favoriteSoundData == null) return;

                        CurrentSoundData.setCurrentSound(player, favoriteSoundData);
                        GUIUtils.handlePickedLineSound(clickedInventory, slot);
                        clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                    }
                }
        }
    }
}