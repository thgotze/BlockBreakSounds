package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.guis.PickSoundGUI;
import com.gotze.blockBreakSounds.guis.SettingsGUI;
import com.gotze.blockBreakSounds.utility.ClickDelayChecker;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.FavoritedSoundLoreHandler;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundsData;
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

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;
import static com.gotze.blockBreakSounds.utility.GUIUtils.Frame;
import static com.gotze.blockBreakSounds.utility.TextUtils.convertToSmallFont;
import static com.gotze.blockBreakSounds.soundlogic.CurrentSoundData.currentSound;

public class BlockBreakSoundsGUIListener implements Listener {

    private static final String GUI_TITLE = "Block Break Sounds";

    private static final List<Float> VOLUME_LEVELS = Arrays.asList( // 21 levels
            0.00f, 0.05f, 0.10f, 0.15f, 0.20f, 0.25f, 0.30f, 0.35f, 0.40f, 0.45f, 0.50f,
            0.55f, 0.60f, 0.65f, 0.70f, 0.75f, 0.80f, 0.85f, 0.90f, 0.95f, 1.00f
    );
    private static final List<Float> PITCH_LEVELS = Arrays.asList( // 31 levels
            0.50f, 0.55f, 0.60f, 0.65f, 0.70f, 0.75f, 0.80f, 0.85f, 0.90f, 0.95f, 1.00f,
            1.05f, 1.10f, 1.15f, 1.20f, 1.25f, 1.30f, 1.35f, 1.40f, 1.45f, 1.50f, 1.55f,
            1.60f, 1.65f, 1.70f, 1.75f, 1.80f, 1.85f, 1.90f, 1.95f, 2.00f
    );

    public BlockBreakSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();
        event.setCancelled(true);

        if (clickedInventory == null || clickedInventory == player.getInventory() || !event.getView().getTitle().equals(GUI_TITLE)) {
            return;
        }

        if (ClickDelayChecker.shouldIgnoreClick(player)) {
            return;
        }

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        CurrentSoundData currentSoundData = currentSound.get(player.getUniqueId());

        switch (slot) {
            case 11: // Increase Volume
                increaseVolume(player, currentSoundData);
                updateVolumeSlider(clickedInventory, currentSoundData);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 13: // Current Sound
                if (clickType == ClickType.DROP) {
                    CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
                    return;
                }
                if (clickType == ClickType.SHIFT_RIGHT) {
                    FavoriteSoundsData.addFavoriteSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    FavoritedSoundLoreHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);
                    return;
                }
                if (currentSoundData != null && clickedInventory.getItem(slot).getType() != Material.BARRIER) {
                    player.playSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    updateVolumeSlider(clickedInventory, currentSoundData);
                    updatePitchSlider(clickedInventory, currentSoundData);
                    return;
                }
                return;

            case 15: // Increase Pitch
                increasePitch(player, currentSoundData);
                updatePitchSlider(clickedInventory, currentSoundData);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 20: // Tweak Volume
                if (clickType.isLeftClick()) {
                    increaseVolume(player, currentSoundData);
                }
                else if (clickType.isRightClick()) {
                    decreaseVolume(player, currentSoundData);
                }
                updateVolumeSlider(clickedInventory, currentSoundData);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 22: // Pick Sound
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new PickSoundGUI().setupAndOpenGUI(player);
                return;

            case 24: // Tweak Pitch
                if (clickType.isLeftClick()) {
                    increasePitch(player, currentSoundData);
                } else if (clickType.isRightClick()) {
                    decreasePitch(player, currentSoundData);
                }
                updatePitchSlider(clickedInventory, currentSoundData);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 26: // Settings
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new SettingsGUI().setupAndOpenGUI(player);
                return;

            case 29: // Decrease Volume
                decreaseVolume(player, currentSoundData);
                updateVolumeSlider(clickedInventory, currentSoundData);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 31: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new FavoriteSoundsGUI().setupAndOpenGUI(player);
                return;

            case 33: // Decrease Pitch
                decreasePitch(player, currentSoundData);
                updatePitchSlider(clickedInventory, currentSoundData);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            default:
        }
    }

    private void updateVolumeSlider(Inventory inventory, CurrentSoundData soundData) {
        if (soundData == null) {
            return;
        }

        // Retrieve the current volume and its index
        float currentVolume = soundData.getVolume();
        int currentIndex = VOLUME_LEVELS.indexOf(currentVolume);

        // Clear all volume slider slots with placeholder frames
        final List<Integer> volumeSliderSlots = Arrays.asList(9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 17);
        for (Integer volumeSliderSlot : volumeSliderSlots) {
            inventory.setItem(volumeSliderSlot, Frame());
        }

        // Dynamically set panes for the volume slider
        for (int i = 0; i <= currentIndex; i++) {
            Material material = i == currentIndex ? Material.YELLOW_STAINED_GLASS_PANE : Material.LIME_STAINED_GLASS_PANE; // Highlight current index

            // Consistent text style for all panes: white text with bold yellow for volume percentage
            String displayText = ChatColor.WHITE + convertToSmallFont("volume: ") +
                    ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont((int) (VOLUME_LEVELS.get(i) * 100) + "%");

            // Set the colored pane in the respective volume slider slot
            inventory.setItem(volumeSliderSlots.get(i), createItemStack(material, displayText));
        }
    }

    private void updatePitchSlider(Inventory inventory, CurrentSoundData soundData) {
        if (soundData == null) {
            return;
        }

        float currentPitch = soundData.getPitch();

        final List<Integer> pitchSliderSlots = Arrays.asList(27, 36, 37, 38, 39, 40, 41, 42, 43, 44, 35);

        // Clear all slots with the frame
        for (Integer slot : pitchSliderSlots) {
            inventory.setItem(slot, Frame());
        }

        String displayText = ChatColor.WHITE + convertToSmallFont("pitch: ") +
                ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont(String.format("%.2f", currentPitch));

        // If the pitch is at the max value, set all slots to yellow
        if (currentPitch == 2.00f) {
            ItemStack yellowPane = createItemStack(Material.YELLOW_STAINED_GLASS_PANE, displayText);
            for (Integer slot : pitchSliderSlots) {
                inventory.setItem(slot, yellowPane);
            }
            return; // No need to continue if it's max
        }

        // Loop through each slot and determine the color for the pane
        for (int i = 0; i < pitchSliderSlots.size(); i++) {
            Integer slot = pitchSliderSlots.get(i);

            Material paneMaterial = Material.LIME_STAINED_GLASS_PANE; // Default is LIME
            if (i == PITCH_LEVELS.indexOf(currentPitch)) {
                // If it's the exact pitch level, set it to yellow
                paneMaterial = Material.YELLOW_STAINED_GLASS_PANE;
            }

            // Create a new item stack for each slot
            ItemStack itemStack = createItemStack(paneMaterial, displayText);

            // Set the item in the inventory
            inventory.setItem(slot, itemStack);
        }
    }


    private void decreaseVolume(Player player, CurrentSoundData soundData) {
        if (soundData == null) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }
        float currentVolume = soundData.getVolume();
        int currentIndex = VOLUME_LEVELS.indexOf(currentVolume);

        if (currentIndex == 0 || currentIndex == 1) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }

        float newVolume = VOLUME_LEVELS.get(currentIndex - 1);
        soundData.setVolume(newVolume);

        player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
    }

    private void increaseVolume(Player player, CurrentSoundData soundData) {
        if (soundData == null) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }
        float currentVolume = soundData.getVolume();
        int currentIndex = VOLUME_LEVELS.indexOf(currentVolume);

        if (currentIndex != VOLUME_LEVELS.size() - 1) {
           float newVolume = VOLUME_LEVELS.get(currentIndex + 1);
           soundData.setVolume(newVolume);
        }

        player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
    }

    private void decreasePitch(Player player, CurrentSoundData soundData) {
        if (soundData == null) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }
        float currentVolume = soundData.getVolume();
        float currentPitch = soundData.getPitch();

        int currentIndex = PITCH_LEVELS.indexOf(currentPitch);

        if (currentIndex == 0 || currentVolume == 0.0f)  {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
        } else {
            float newPitch = PITCH_LEVELS.get(currentIndex - 1);
            soundData.setPitch(newPitch);
        }
        player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
    }

    private void increasePitch(Player player, CurrentSoundData soundData) {
        if (soundData == null) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }
        float currentPitch = soundData.getPitch();
        int currentIndex = PITCH_LEVELS.indexOf(currentPitch);

        if (currentIndex != PITCH_LEVELS.size() -1) {
            float newPitch = PITCH_LEVELS.get(currentIndex + 1);
            soundData.setPitch(newPitch);
        }

        player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
    }
}