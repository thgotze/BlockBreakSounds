package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.guis.PickSoundGUI;
import com.gotze.blockBreakSounds.guis.SettingsGUI;
import com.gotze.blockBreakSounds.utils.GUIUtils;
import com.gotze.blockBreakSounds.utils.linehandlers.FavoritedSoundLineHandler;
import com.gotze.blockBreakSounds.utils.sounddata.CurrentSoundData;
import com.gotze.blockBreakSounds.utils.sounddata.FavoriteSoundsData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gotze.blockBreakSounds.utils.ItemStackCreator.createItemStack;
import static com.gotze.blockBreakSounds.utils.GUIUtils.Frame;
import static com.gotze.blockBreakSounds.utils.TextUtils.convertToSmallFont;
import static com.gotze.blockBreakSounds.utils.sounddata.CurrentSoundData.currentSound;

public class BlockBreakSoundsGUIListener implements Listener {

    private final Map<Player, Long> lastClickTime = new HashMap<>();
    private static final long CLICK_DELAY = 50; // 50 milliseconds

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

        if (!event.getView().getTitle().equals("Block Break Sounds")) {
            return;
        }

        event.setCancelled(true);

        if (clickedInventory == player.getInventory() || clickedInventory == null) {
            return;
        }

        // Check for click delay to disallow spam clicking
        long currentTime = System.currentTimeMillis();
        if (lastClickTime.containsKey(player)) {
            long lastClick = lastClickTime.get(player);
            if ((currentTime - lastClick) < CLICK_DELAY) {
                return;
            }
        }
        lastClickTime.put(player, currentTime);

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
                    FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);
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
                PickSoundGUI pickSoundGUI = new PickSoundGUI(player);
                pickSoundGUI.openPickSoundGUI(player);
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
                SettingsGUI settingsGUI = new SettingsGUI();
                settingsGUI.openSettingsGUI(player);
                return;

            case 29: // Decrease Volume
                decreaseVolume(player, currentSoundData);
                updateVolumeSlider(clickedInventory, currentSoundData);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 31: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                FavoriteSoundsGUI favoriteSoundsGUI = new FavoriteSoundsGUI();
                favoriteSoundsGUI.openFavoriteSoundsGUI(player);
                return;

            case 33: // Decrease Pitch
                decreasePitch(player, currentSoundData);
                updatePitchSlider(clickedInventory, currentSoundData);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            default:
                return;
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

        // Retrieve the current pitch value and its index
        float currentPitch = soundData.getPitch();
        int currentIndex = PITCH_LEVELS.indexOf(currentPitch);

        // Clear all pitch slider slots with placeholder frames
        final List<Integer> pitchSliderSlots = Arrays.asList(27, 36, 37, 38, 39, 40, 41, 42, 43, 44, 35);
        for (Integer pitchSliderSlot : pitchSliderSlots) {
            inventory.setItem(pitchSliderSlot, Frame());
        }

        // Dynamically set panes for the pitch slider
        for (int i = 0; i <= currentIndex; i++) {
            Material material = (i == currentIndex) ? Material.YELLOW_STAINED_GLASS_PANE : Material.LIME_STAINED_GLASS_PANE;

            // Consistent text style for all panes: white text with bold yellow for pitch level
            String displayText = ChatColor.WHITE + convertToSmallFont("pitch: ") +
                    ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont(String.format("%.2f", PITCH_LEVELS.get(i)));

            // Set the colored pane in the respective pitch slider slot
            inventory.setItem(pitchSliderSlots.get(i), createItemStack(material, displayText));
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

    @EventHandler
    // Clean up when player closes the inventory
    private void onInventoryClose (InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        lastClickTime.remove(player);
    }
}