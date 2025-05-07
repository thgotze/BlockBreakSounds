package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.AllSoundsGUI;
import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.soundlogic.*;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static com.gotze.blockBreakSounds.soundlogic.AllSoundsRegistry.VALID_ALL_SOUNDS_GUI_TITLES;

public class AllSoundsGUIListener implements Listener {

    public AllSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        String inventoryTitle = event.getView().getTitle();
        if (!VALID_ALL_SOUNDS_GUI_TITLES.contains(inventoryTitle)) return;
        event.setCancelled(true);
        
        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (clickedInventory == null) return;

        if (clickedInventory.equals(player.getInventory())) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        switch (slot) {
            case 4: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
                return;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);

                if (inventoryTitle.equals("All Sounds")) {
                    new BlockBreakSoundsGUI(player);
                } else {
                    SoundCategory parentCategory = getParentCategory(AllSoundsRegistry.ALL_SOUNDS, inventoryTitle);
                    if (parentCategory == null) return;
                    new AllSoundsGUI(player, parentCategory.getCategoryTitle());
                }
                return;

            case 40: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new FavoriteSoundsGUI(player);
                return;

            default: // Soundcategories and/or Sounds
                if (slot >= 9 && slot < 36) {
                    ItemStack clickedItem = clickedInventory.getItem(slot);
                    if (clickedItem == null) return;
                    ItemMeta clickedItemMeta = clickedItem.getItemMeta();
                    if (clickedItemMeta == null) return;

                    String clickedItemTitle = ChatColor.stripColor(clickedItemMeta.getDisplayName());

                    Object object = getCategoryOrSoundDataOfClickedItem(AllSoundsRegistry.ALL_SOUNDS, clickedItemTitle);

                    if (object instanceof SoundCategory soundCategory) {
                        player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                        new AllSoundsGUI(player, soundCategory.getCategoryTitle());
                        return;

                    } else if (object instanceof SoundData soundData) {
                        if (clickType == ClickType.SHIFT_RIGHT) { // Favorite Sound
                            FavoriteSoundData.addSoundToFavorites(player, soundData);
                            GUIUtils.handleFavoritedLineSound(clickedInventory, slot);
                            return;

                        } else if (clickType != ClickType.SHIFT_RIGHT) { // Pick Sound
                            CurrentSoundData.setCurrentSound(player, soundData);
                            GUIUtils.handlePickedLineSound(clickedInventory, slot);
                            clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                            return;
                        }
                    }
                }
        }
    }

    private SoundCategory getParentCategory(SoundCategory soundCategory, String inventoryTitle) {
        for (Object child : soundCategory.getChildren()) {
            if (child instanceof SoundCategory childCategory) {
                if (childCategory.getCategoryTitle().equals(inventoryTitle)) {
                    return soundCategory;
                } else {
                    SoundCategory parentCategory = getParentCategory(childCategory, inventoryTitle);
                    if (parentCategory != null) {
                        return parentCategory;
                    }
                }
            }
        }
        return null;
    }

    private Object getCategoryOrSoundDataOfClickedItem(SoundCategory soundCategory, String clickedItemTitle) {
        for (Object child : soundCategory.getChildren()) {
            if (child instanceof SoundCategory childCategory) {
                if (childCategory.getCategoryTitle().equals(clickedItemTitle)) {
                    return childCategory;
                } else {
                    Object object = getCategoryOrSoundDataOfClickedItem(childCategory, clickedItemTitle);
                    if (object != null) {
                        return object;
                    }
                }

            } else if (child instanceof SoundData soundData) {
                if (StringUtils.getFormattedSoundName(soundData.getSound()).equals(clickedItemTitle)) {
                    return soundData;
                }
            }
        }
        return null;
    }
}