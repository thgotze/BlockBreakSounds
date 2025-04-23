package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.guis.PickSoundGUI;
import com.gotze.blockBreakSounds.guis.SettingsGUI;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.ClickDelayChecker;
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

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockBreakSounds.soundlogic.CurrentSoundData.currentSound;
import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;
import static com.gotze.blockBreakSounds.utility.TextUtils.convertToSmallFont;

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

        if (clickedInventory == null
                || clickedInventory == player.getInventory()
                || !event.getView().getTitle().equals(GUI_TITLE)) {
            return;
        }

        if (ClickDelayChecker.shouldIgnoreClick(player)) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        SoundData playerCurrentSound = currentSound.get(player.getUniqueId());

        switch (slot) {
            case 11: // Increase Volume
                increaseVolume(player, playerCurrentSound);
                updateVolumeSlider(clickedInventory, playerCurrentSound);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 13: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
                return;

            case 15: // Increase Pitch
                increasePitch(player, playerCurrentSound);
                updatePitchSlider(clickedInventory, playerCurrentSound);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 20: // Tweak Volume
                if (clickType.isLeftClick()) {
                    increaseVolume(player, playerCurrentSound);
                }
                else if (clickType.isRightClick()) {
                    decreaseVolume(player, playerCurrentSound);
                }
                updateVolumeSlider(clickedInventory, playerCurrentSound);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 22: // Pick Sound
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new PickSoundGUI().setupAndOpenGUI(player);
                return;

            case 24: // Tweak Pitch
                if (clickType.isLeftClick()) {
                    increasePitch(player, playerCurrentSound);
                } else if (clickType.isRightClick()) {
                    decreasePitch(player, playerCurrentSound);
                }
                updatePitchSlider(clickedInventory, playerCurrentSound);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 26: // Settings
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new SettingsGUI().setupAndOpenGUI(player);
                return;

            case 29: // Decrease Volume
                decreaseVolume(player, playerCurrentSound);
                updateVolumeSlider(clickedInventory, playerCurrentSound);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 31: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new FavoriteSoundsGUI().setupAndOpenGUI(player);
                return;

            case 33: // Decrease Pitch
                decreasePitch(player, playerCurrentSound);
                updatePitchSlider(clickedInventory, playerCurrentSound);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            default:
        }
    }

    private void updateVolumeSlider(Inventory inventory, SoundData soundData) {
        if (soundData == null) return;

        float currentVolume = soundData.getVolume();

        float[] volumeThresholds = {0.05f, 0.15f, 0.25f, 0.35f, 0.50f, 0.65f, 0.80f, 0.90f};

//        0 0;
//        1 5 10;
//        2 15 20;
//        3 25 30;
//        4 35 40 45;
//        5 50 55 60;
//        6 65 75;
//        7 80 85;
//        8 90 95;
//        9 100;

        int paneAmount = 0;
        for (int i = 0; i < volumeThresholds.length; i++) {
            if (currentVolume < volumeThresholds[i]) {
                break;
            }
            paneAmount = i;
        }

        String volumeSliderDisplayText = ChatColor.WHITE + convertToSmallFont("volume: ") +
                ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont((int) (currentVolume * 100) + "%");
        ItemStack greenPane = createItemStack(Material.GREEN_STAINED_GLASS_PANE, volumeSliderDisplayText);
        ItemStack yellowPane = createItemStack(Material.YELLOW_STAINED_GLASS_PANE, volumeSliderDisplayText);
        ItemStack redPane = createItemStack(Material.RED_STAINED_GLASS_PANE, volumeSliderDisplayText);

        int[] volumeSliderSlots = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        for (int i = 0; i < volumeSliderSlots.length; i++) {
            if (currentVolume == 0.00f) {
                inventory.setItem(volumeSliderSlots[i], redPane);
            } else if (currentVolume == 1.00f) {
                inventory.setItem(volumeSliderSlots[i], yellowPane);
            } else if (i < paneAmount) {
                inventory.setItem(volumeSliderSlots[i], greenPane);
            } else if (i == paneAmount) {
                inventory.setItem(volumeSliderSlots[i], yellowPane);
            } else if (i > paneAmount) {
                inventory.setItem(volumeSliderSlots[i], GUIUtils.Frame());
            }
        }
    }

    private void updatePitchSlider(Inventory inventory, SoundData soundData) {
        if (soundData == null) return;

        float currentPitch = soundData.getPitch();

        float[] pitchThresholds = {0.50f, 0.65f, 0.80f, 1.00f, 1.20f, 1.40f, 1.60f, 1.75f};

        // Calculates how filled the pitch slider should be depending on the values for pitch thresholds
        // Checks if current pitch is greater than the thresholds, if so then add a pane for the slider
        int paneAmount = 0;
        for (int i = 0; i < pitchThresholds.length; i++) {
            if (currentPitch < pitchThresholds[i]) {
                break;
            }
            paneAmount = i;
        }

        String pitchSliderDisplayText = ChatColor.WHITE + convertToSmallFont("pitch: ") +
                ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont(String.format("%.2f", currentPitch));
        ItemStack greenPane = createItemStack(Material.GREEN_STAINED_GLASS_PANE, pitchSliderDisplayText);
        ItemStack yellowPane = createItemStack(Material.YELLOW_STAINED_GLASS_PANE, pitchSliderDisplayText);

        int[] pitchSliderSlots = {36, 37, 38, 39, 40, 41, 42, 43, 44};

        // If pitch is max (2.00f) all panes are yellow to indicate that pitch is maxed out
        // Otherwise the panes are green except the last one which is yellow to indicate current pitch level
        // Panes beyond the current pitch level are black to indicate blank
        for (int i = 0; i < pitchSliderSlots.length; i++) {
            if (currentPitch == 2.00f) {
                inventory.setItem(pitchSliderSlots[i], yellowPane);
            } else if (i < paneAmount) {
                inventory.setItem(pitchSliderSlots[i], greenPane);
            } else if (i == paneAmount) {
                inventory.setItem(pitchSliderSlots[i], yellowPane);
            } else if (i > paneAmount) {
                inventory.setItem(pitchSliderSlots[i], GUIUtils.Frame());
            }
        }
    }

    private void increaseVolume(Player player, SoundData soundData) {
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

    private void decreaseVolume(Player player, SoundData soundData) {
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

    private void increasePitch(Player player, SoundData soundData) {
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

    private void decreasePitch(Player player, SoundData soundData) {
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
}