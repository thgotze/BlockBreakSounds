package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.AllSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.soundlogic.AllSoundsRegistry;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundCategory;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class AllSoundsGUIListener implements Listener {

    public AllSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (clickedInventory == null || clickedInventory.equals(player.getInventory()))
            return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        String inventoryTitle = event.getView().getTitle();
        if (slot == 4) { // Current Sound
            GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
            return;
        }

        if (slot == 40) { // Favorite Sounds
            player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
            new FavoriteSoundsGUI(player);
            return;
        }

        String clickedItemTitle = ChatColor.stripColor(clickedInventory.getItem(slot).getItemMeta().getDisplayName());
        // TODO: Temp debug message
        player.sendMessage("Title of item at slot " + slot + " is " + clickedItemTitle);

        // TODO: Make it a method so it goes through the same code no matter if its child or grandchild
        for (SoundCategory soundCategory : AllSoundsRegistry.CATEGORIES) {
            if (soundCategory.getCategoryName().equals(clickedItemTitle)) {
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new AllSoundsGUI(player, soundCategory.getCategoryName());
            } else {
                for (Object child : soundCategory.getChildren()) {
                    if (child instanceof SoundCategory) {
                        if (((SoundCategory) child).getCategoryName().equals(clickedItemTitle)) {
                            player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                            new AllSoundsGUI(player, ((SoundCategory) child).getCategoryName());
                            return;
                        } else {
                            for (Object grandChild : ((SoundCategory) child).getChildren()) {
                                if (grandChild instanceof SoundCategory) {
                                    if (((SoundCategory) grandChild).getCategoryName().equals(clickedItemTitle)) {
                                        player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                                        new AllSoundsGUI(player, ((SoundCategory) grandChild).getCategoryName());
                                    }
                                }
                                else if (grandChild instanceof SoundData) {
                                    if ((((SoundData) grandChild).getSound().toString()).equals(clickedItemTitle)) {
                                        SoundData soundData = new SoundData(((SoundData) grandChild).getSound(), ((SoundData) grandChild).getDisplayMaterial());
                                        CurrentSoundData.setCurrentSound(player, soundData);
                                        GUIUtils.handlePickedLineSound(clickedInventory, slot);
                                        clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                                    }
                                }
                            }
                        }
                    } else if (child instanceof SoundData) {
                        if ((((SoundData) child).getSound().toString()).equals(clickedItemTitle)) {
                            SoundData soundData = new SoundData(((SoundData) child).getSound(), ((SoundData) child).getDisplayMaterial());
                            CurrentSoundData.setCurrentSound(player, soundData);
                            GUIUtils.handlePickedLineSound(clickedInventory, slot);
                            clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                        }
                    }
                }
            }
        }
    }
}
