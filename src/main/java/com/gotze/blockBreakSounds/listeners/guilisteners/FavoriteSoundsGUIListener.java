package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.Main;
import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.ItemStackCreator;
import com.gotze.blockBreakSounds.utility.ValidClickChecker;
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

public class FavoriteSoundsGUIListener implements Listener {

    private static final String GUI_TITLE = "Favorite Sounds";

    public FavoriteSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (ValidClickChecker.shouldCancelClick(GUI_TITLE, event, clickedInventory, player)) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        switch (slot) {
            case 4: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
                return;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new BlockBreakSoundsGUI().setupAndOpenGUI(player);
                return;

            default: // Favorited Sounds
                if (slot >= 9 && slot < 36) {
                    ItemStack item = clickedInventory.getItem(slot);

                    if (item == null || item.getType() == Material.PAPER) return;

                    if (clickType == ClickType.DROP) { // Remove sound from favorites
                        if (item.getType() != Material.BARRIER) {
                            ItemStack confirmClearFavoriteSound = ItemStackCreator.createItemStack(Material.BARRIER, ChatColor.RED + "ᴅʀᴏᴘ ᴀɢᴀɪɴ ᴛᴏ ᴜɴꜰᴀᴠᴏʀɪᴛᴇ");
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
                            new FavoriteSoundsGUI().setupAndOpenGUI(player);
                        }
                        return;
                    }

                    if (clickType != ClickType.DROP) { // Set as current sound
                        System.out.println("handlePickedLineSound running for slot " + slot);
                        SoundData favoriteSoundData = FavoriteSoundData.favoriteSounds.get(player.getUniqueId()).get(slot - 9);
                        if (favoriteSoundData == null) {
                            System.out.println("unable to get favorite sound data");
                            return;
                        }
                        CurrentSoundData.setCurrentSound(player, favoriteSoundData);
                        System.out.println("sound has been set");
                        System.out.println("trying to handlepickededline");
                        GUIUtils.handlePickedLineSound(clickedInventory, slot);
                        clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                    }
                }
        }
    }
}