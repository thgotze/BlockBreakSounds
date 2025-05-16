package com.gotze.blockbreaksounds.gui.blockbreaksounds;

import com.gotze.blockbreaksounds.gui.favoritesounds.FavoriteSoundsGUI;
import com.gotze.blockbreaksounds.gui.picksound.PickSoundGUI;
import com.gotze.blockbreaksounds.model.CurrentSoundData;
import com.gotze.blockbreaksounds.model.SoundData;
import com.gotze.blockbreaksounds.util.GUIUtils;
import com.gotze.blockbreaksounds.util.ValidClickChecker;
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

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class BlockBreakSoundsGUIListener implements Listener {

    public BlockBreakSoundsGUIListener() {}

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("Block Break Sounds")) return;
        event.setCancelled(true);

        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (ValidClickChecker.hasClickCooldown(player)) return;
        if (clickedInventory == null) return;
        if (clickedInventory.equals(player.getInventory())) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        switch (slot) {
            case 11: // Increase Volume
                increaseVolume(player);
                updateVolumeSlider(player, clickedInventory);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 13: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);

                ItemStack clickedItem = clickedInventory.getItem(slot);
                if (clickedItem != null) {
                    if (clickedItem.getType() == Material.GLASS_PANE) {
                        updateVolumeSlider(player, clickedInventory);
                        updatePitchSlider(player, clickedInventory);
                    }
                }
                return;

            case 15: // Increase Pitch
                increasePitch(player);
                updatePitchSlider(player, clickedInventory);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 20: // Tweak Volume
                if (clickType.isLeftClick()) {
                    increaseVolume(player);
                }
                else if (clickType.isRightClick()) {
                    decreaseVolume(player);
                }
                updateVolumeSlider(player, clickedInventory);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 22: // Pick Sound
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new PickSoundGUI(player);
                return;

            case 24: // Tweak Pitch
                if (clickType.isLeftClick()) {
                    increasePitch(player);
                } else if (clickType.isRightClick()) {
                    decreasePitch(player);
                }
                updatePitchSlider(player, clickedInventory);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

                // TODO: Settings GUI is currently not implemented
            // case 26: // Settings
            // player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
            // new SettingsGUI(player);
            // return;

            case 29: // Decrease Volume
                decreaseVolume(player);
                updateVolumeSlider(player, clickedInventory);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            case 31: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new FavoriteSoundsGUI(player);
                return;

            case 33: // Decrease Pitch
                decreasePitch(player);
                updatePitchSlider(player, clickedInventory);
                clickedInventory.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
                return;

            default:

        }
    }

    private void updateVolumeSlider(Player player, Inventory inventory) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) return;

        float currentVolume = currentSoundData.getVolume();

        float[] volumeThresholds = {0.05f, 0.15f, 0.25f, 0.35f, 0.50f, 0.65f, 0.80f, 0.90f};

        // Calculates how filled the volume slider should be depending on the values for volume thresholds
        // Checks if current volume is greater than the thresholds, if so then add a pane for the slider
        int paneAmount = 0;
        for (int i = 0; i < volumeThresholds.length; i++) {
            if (currentVolume < volumeThresholds[i]) {
                break;
            }
            paneAmount = i;
        }

        String volumeSliderDisplayText = ChatColor.WHITE + convertToSmallFont("volume: ") +
                ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont((int) (currentVolume * 100) + "%");
        ItemStack limePane = createItemStack(Material.LIME_STAINED_GLASS_PANE, volumeSliderDisplayText);
        ItemStack yellowPane = createItemStack(Material.YELLOW_STAINED_GLASS_PANE, volumeSliderDisplayText);
        ItemStack redPane = createItemStack(Material.RED_STAINED_GLASS_PANE, volumeSliderDisplayText);

        int[] volumeSliderSlots = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        // If volume is 0.00f all panes are red to indicate volume disabled
        // Else if volume is 1.00f all panes are yellow to indicate volume maxed out
        // Otherwise the panes are lime except the last one which is yellow to indicate current volume level
        // Panes beyond the current volume level are blank
        for (int i = 0; i < volumeSliderSlots.length; i++) {
            if (currentVolume == 0.00f) {
                inventory.setItem(volumeSliderSlots[i], redPane);
            } else if (currentVolume == 1.00f) {
                inventory.setItem(volumeSliderSlots[i], yellowPane);
            } else if (i < paneAmount) {
                inventory.setItem(volumeSliderSlots[i], limePane);
            } else if (i == paneAmount) {
                inventory.setItem(volumeSliderSlots[i], yellowPane);
            } else if (i > paneAmount) {
                inventory.setItem(volumeSliderSlots[i], GUIUtils.Frame());
            }
        }
    }

    private void updatePitchSlider(Player player, Inventory inventory) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) return;

        float currentPitch = currentSoundData.getPitch();

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
        ItemStack limePane = createItemStack(Material.LIME_STAINED_GLASS_PANE, pitchSliderDisplayText);
        ItemStack yellowPane = createItemStack(Material.YELLOW_STAINED_GLASS_PANE, pitchSliderDisplayText);

        int[] pitchSliderSlots = {36, 37, 38, 39, 40, 41, 42, 43, 44};

        // If pitch is max (2.00f) all panes are yellow to indicate that pitch is maxed out
        // Otherwise the panes are lime except the last one which is yellow to indicate current pitch level
        // Panes beyond the current pitch level are blank
        for (int i = 0; i < pitchSliderSlots.length; i++) {
            if (currentPitch == 2.00f) {
                inventory.setItem(pitchSliderSlots[i], yellowPane);
            } else if (i < paneAmount) {
                inventory.setItem(pitchSliderSlots[i], limePane);
            } else if (i == paneAmount) {
                inventory.setItem(pitchSliderSlots[i], yellowPane);
            } else if (i > paneAmount) {
                inventory.setItem(pitchSliderSlots[i], GUIUtils.Frame());
            }
        }
    }

    private void increaseVolume(Player player) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }

        SoundData newCurrentSound = new SoundData(currentSoundData.getSound(), (Math.round((currentSoundData.getVolume() + 0.05f) * 100f) / 100f),
                currentSoundData.getPitch(), currentSoundData.getDisplayMaterial());
        CurrentSoundData.setCurrentSound(player, newCurrentSound);
    }

    private void decreaseVolume(Player player) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null || currentSoundData.getVolume() == 0.00f) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }

        if (currentSoundData.getVolume() == 0.05f ) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
        }

        SoundData newCurrentSound = new SoundData(currentSoundData.getSound(), (Math.round((currentSoundData.getVolume() - 0.05f) * 100f) / 100f),
                currentSoundData.getPitch(), currentSoundData.getDisplayMaterial());
        CurrentSoundData.setCurrentSound(player, newCurrentSound);
    }

    private void increasePitch(Player player) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }

        SoundData newCurrentSound = new SoundData(currentSoundData.getSound(), currentSoundData.getVolume(),
                (Math.round((currentSoundData.getPitch() + 0.05f) * 100f) / 100f), currentSoundData.getDisplayMaterial());
        CurrentSoundData.setCurrentSound(player, newCurrentSound);
    }

    private void decreasePitch(Player player) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null || currentSoundData.getPitch() == 0.50f) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }
        SoundData newCurrentSound = new SoundData(currentSoundData.getSound(), currentSoundData.getVolume(),
                (Math.round((currentSoundData.getPitch() - 0.05f) * 100f) / 100f), currentSoundData.getDisplayMaterial());
        CurrentSoundData.setCurrentSound(player, newCurrentSound);
    }
}