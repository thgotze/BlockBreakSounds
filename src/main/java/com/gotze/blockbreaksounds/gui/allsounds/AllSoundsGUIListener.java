package com.gotze.blockbreaksounds.gui.allsounds;

import com.gotze.blockbreaksounds.model.CurrentSoundData;
import com.gotze.blockbreaksounds.model.FavoriteSoundData;
import com.gotze.blockbreaksounds.gui.favoritesounds.FavoriteSoundsGUI;
import com.gotze.blockbreaksounds.gui.picksound.PickSoundGUI;
import com.gotze.blockbreaksounds.model.*;
import com.gotze.blockbreaksounds.util.GUIUtils;
import com.gotze.blockbreaksounds.util.ValidClickChecker;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Map;

public class AllSoundsGUIListener implements Listener {

    public AllSoundsGUIListener() {}

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        String inventoryTitle = event.getView().getTitle();
        if (!AllSoundsRegistry.CATEGORY_MAP.containsKey(inventoryTitle)) return;
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
                return;

            case 36: // Return
                if (inventoryTitle.equals("All Sounds")) {
                    new PickSoundGUI(player);
                } else {
                    SoundCategory currentCategory = AllSoundsRegistry.CATEGORY_MAP.get(inventoryTitle);
                    for (Map.Entry<String, SoundCategory> entry : AllSoundsRegistry.CATEGORY_MAP.entrySet()) {
                        if (entry.getValue().getChildren().contains(currentCategory)) {
                            new AllSoundsGUI(player, entry.getKey());
                            break;
                        }
                    }
                }
                player.stopAllSounds();
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                return;

            case 40: // Favorite Sounds
                new FavoriteSoundsGUI(player);
                player.stopAllSounds();
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                return;

            default: // Soundcategories and/or Sounds
                if (slot >= 9 && slot < 36) {
                    ItemStack clickedItem = clickedInventory.getItem(slot);
                    if (clickedItem == null) return;
                    ItemMeta clickedItemMeta = clickedItem.getItemMeta();
                    if (clickedItemMeta == null) return;

                    String clickedItemTitle = ChatColor.stripColor(clickedItemMeta.getDisplayName());

                    if (AllSoundsRegistry.CATEGORY_MAP.containsKey(clickedItemTitle)) {
                        new AllSoundsGUI(player, clickedItemTitle);
                        player.stopAllSounds();
                        player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);

                    } else {
                        SoundData soundData = AllSoundsRegistry.SOUND_MAP.get(clickedItemTitle);
                        if (soundData != null) {
                            if (clickType == ClickType.SHIFT_RIGHT) {
                                FavoriteSoundData.addSoundToFavorites(player, soundData);
                                GUIUtils.handleFavoritedLineSound(clickedInventory, slot, player);
                            } else {
                                CurrentSoundData.setCurrentSound(player, soundData);
                                GUIUtils.handlePickedLineSound(clickedInventory, slot);
                                clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                            }
                        }
                    }
                }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        String inventoryTitle = event.getView().getTitle();
        Player player = (Player) event.getPlayer();

        if (AllSoundsRegistry.CATEGORY_MAP.containsKey(inventoryTitle)) {
            player.stopAllSounds();
        }
    }
}