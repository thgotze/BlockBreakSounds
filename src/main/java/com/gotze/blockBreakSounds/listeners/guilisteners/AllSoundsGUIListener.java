package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.AllSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.soundlogic.AllSoundsRegistry;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundCategory;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
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

import javax.xml.crypto.Data;

public class AllSoundsGUIListener implements Listener {

    public AllSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (clickedInventory == null) return;

        ItemStack itemInSlot44 = clickedInventory.getItem(44);
        if (itemInSlot44 == null) return;
        ItemMeta itemMeta = itemInSlot44.getItemMeta();
        if (itemMeta == null) return;
        String displayName = itemMeta.getDisplayName();
        if (!displayName.equals("Testing")) return;

        event.setCancelled(true);

        if (clickedInventory.equals(player.getInventory())) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        if (slot == 4) { // Current Sound
            GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
        } else if (slot == 40) { // Favorite Sounds
            player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
            new FavoriteSoundsGUI(player);
        } else {
            ItemStack clickedItem = clickedInventory.getItem(slot);
            if (clickedItem == null) return;
            ItemMeta clickedItemMeta = clickedItem.getItemMeta();
            if (clickedItemMeta == null) return;
            String clickedItemTitle = ChatColor.stripColor(clickedItemMeta.getDisplayName());
            System.out.println("Title of clicked item: " + clickedItemTitle);

            findCategoryAndHandleClick(AllSoundsRegistry.ALL_SOUNDS, player, clickedItemTitle, clickedInventory, slot);
        }
    }

    private void findCategoryAndHandleClick(SoundCategory soundCategory, Player player, String clickedItemTitle, Inventory clickedInventory, int slot) {
        for (Object child : soundCategory.getChildren()) {
            if (child instanceof SoundCategory childCategory) {
                if (childCategory.getCategoryName().equals(clickedItemTitle)) {
                    player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                    new AllSoundsGUI(player, childCategory.getCategoryName());
                    return;
                }

                findCategoryAndHandleClick(childCategory, player, clickedItemTitle, clickedInventory, slot);

            } else if (child instanceof SoundData soundData) {
                if (StringUtils.getFormattedSoundName(soundData.getSound()).equals(clickedItemTitle)) {
                    Sound<Data updatedSoundData = new SoundData(soundData.getSound(), soundData.getDisplayMaterial());
                    CurrentSoundData.setCurrentSound(player, updatedSoundData);
                    GUIUtils.handlePickedLineSound(clickedInventory, slot);
                    clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                    return;
                }
            }
        }
    }
}