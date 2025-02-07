package com.gotze.blockBreakSounds.BlockBreakSoundsGUI;

import com.gotze.blockBreakSounds.FavoriteSoundsGUI.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.PickSoundGUI.PickSoundGUI;
import com.gotze.blockBreakSounds.SettingsGUI.SettingsGUI;
import com.gotze.blockBreakSounds.Utility.CurrentSoundDisplayButton;
import com.gotze.blockBreakSounds.Utility.LineHandlers.FavoritedSoundLineHandler;
import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
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

import static com.gotze.blockBreakSounds.Utility.ButtonCreator.createButton;
import static com.gotze.blockBreakSounds.Utility.GUIUtils.Frame;
import static com.gotze.blockBreakSounds.Utility.SmallFontConverter.convertToSmallFont;

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
        CurrentSoundData soundData = CurrentSoundData.playerSounds.get(player.getUniqueId());

        switch (slot) {
            case 11: // Increase Volume
                increaseVolume(player, soundData);
                updateVolumeSlider(clickedInventory, soundData);

                clickedInventory.getItem(11).getItemMeta().setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "[" + ChatColor.YELLOW + "+" + ChatColor.GREEN + "] ɪɴᴄʀᴇᴀѕᴇ ᴠᴏʟᴜᴍᴇ");


                clickedInventory.setItem(13, CurrentSoundDisplayButton.CurrentSoundDisplayButton(player));
                return;

            case 13: // Current Sound
                if (clickType == ClickType.DROP) {
                    CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
                    return;
                }
                if (clickType == ClickType.SHIFT_RIGHT) {
                    FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot);
                    return;
                }
                if (soundData != null && clickedInventory.getItem(slot).getType() != Material.BARRIER) {
                    player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
                    updateVolumeSlider(clickedInventory, soundData);
                    updatePitchSlider(clickedInventory, soundData);
                    return;
                }
                return;

            case 15: // Increase Pitch
                increasePitch(player, soundData);
                updatePitchSlider(clickedInventory, soundData);
                clickedInventory.setItem(13, CurrentSoundDisplayButton.CurrentSoundDisplayButton(player));
                return;

            case 20: // Tweak Volume
                if (clickType.isLeftClick()) {
                    increaseVolume(player, soundData);
                }
                else if (clickType.isRightClick()) {
                    decreaseVolume(player, soundData);
                }
                updateVolumeSlider(clickedInventory, soundData);
                clickedInventory.setItem(13, CurrentSoundDisplayButton.CurrentSoundDisplayButton(player));
                return;

            case 22: // Pick Sound
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                PickSoundGUI pickSoundGUI = new PickSoundGUI(player);
                pickSoundGUI.openPickSoundGUI(player);
                return;

            case 24: // Tweak Pitch
                if (clickType.isLeftClick()) {
                    increasePitch(player, soundData);
                } else if (clickType.isRightClick()) {
                    decreasePitch(player, soundData);
                }
                updatePitchSlider(clickedInventory, soundData);
                clickedInventory.setItem(13, CurrentSoundDisplayButton.CurrentSoundDisplayButton(player));
                return;

            case 26: // Settings
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                SettingsGUI settingsGUI = new SettingsGUI();
                settingsGUI.openSettingsGUI(player);
                return;

            case 29: // Decrease Volume
                decreaseVolume(player, soundData);
                updateVolumeSlider(clickedInventory, soundData);
                clickedInventory.setItem(13, CurrentSoundDisplayButton.CurrentSoundDisplayButton(player));
                return;

            case 31: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                FavoriteSoundsGUI favoriteSoundsGUI = new FavoriteSoundsGUI();
                favoriteSoundsGUI.openFavoriteSoundsGUI(player);
                return;

            case 33: // Decrease Pitch
                decreasePitch(player, soundData);
                updatePitchSlider(clickedInventory, soundData);
                clickedInventory.setItem(13, CurrentSoundDisplayButton.CurrentSoundDisplayButton(player));
                return;

            default:
                return;
        }
    }

    private void updateVolumeSlider(Inventory inventory, CurrentSoundData soundData) {
        if (soundData == null) {
            return;
        }

        float currentVolume = soundData.getVolume();
        int currentIndex = VOLUME_LEVELS.indexOf(currentVolume);
        final List<Integer> volumeSliderSlots = Arrays.asList(9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 17);

        for (int i = 0; i < 11; i++) {
            inventory.setItem(volumeSliderSlots.get(i), Frame());
        }

        //  Index Numbers of VOLUME_LEVELS (currentIndex)
        //  0 0.00f, 1 0.05f, 2 0.10f, 3 0.15f, 4 0.20f, 5 0.25f, 6 0.30f, 7 0.35f, 8 0.40f, 9 0.45f, 10 0.50f,
        //  11 0.55f, 12 0.60f, 13 0.65f, 14 0.70f, 15 0.75f, 16 0.80f, 17 0.85f, 18 0.90f, 19 0.95f, 20 1.00f

        switch (currentIndex) {
            case 0: // 0% volume (min)
                for (int i = 0; i < 11; i++) {
                    inventory.setItem(volumeSliderSlots.get(i), createButton(Material.RED_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.RED + ChatColor.BOLD + convertToSmallFont("0%")));
                }
                return;

            case 1: // 5% volume
                inventory.setItem(9, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("5%")));
                return;

            case 2: // 10% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("10%")));
                inventory.setItem(0, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("10%")));
                return;

            case 3: // 15% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("15%")));
                inventory.setItem(0, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("15%")));
                return;

            case 4: // 20% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("20%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("20%")));
                inventory.setItem(1, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("20%")));
                return;

            case 5: // 25% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("25%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("25%")));
                inventory.setItem(1, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("25%")));
                return;

            case 6: // 30% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("30%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("30%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("30%")));
                inventory.setItem(2, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("30%")));
                return;

            case 7: // 35% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("35%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("35%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("35%")));
                inventory.setItem(2, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("35%")));
                return;

            case 8: // 40% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("40%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("40%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("40%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("40%")));
                inventory.setItem(3, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("40%")));
                return;

            case 9: // 45% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("45%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("45%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("45%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("45%")));
                inventory.setItem(3, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("45%")));
                return;

            case 10: // 50% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("50%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("50%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("50%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("50%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("50%")));
                inventory.setItem(4, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("50%")));
                return;

            case 11: // 55% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("55%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("55%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("55%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("55%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("55%")));
                inventory.setItem(4, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("55%")));
                return;

            case 12: // 60% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("60%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("60%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("60%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("60%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("60%")));
                inventory.setItem(4, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("60%")));
                inventory.setItem(5, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("60%")));
                return;

            case 13: // 65% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("65%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("65%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("65%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("65%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("65%")));
                inventory.setItem(4, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("65%")));
                inventory.setItem(5, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("65%")));
                return;

            case 14: // 70% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("70%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("70%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("70%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("70%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("70%")));
                inventory.setItem(4, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("70%")));
                inventory.setItem(5, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("70%")));
                inventory.setItem(6, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("70%")));
                return;

            case 15: // 75% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("75%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("75%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("75%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("75%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("75%")));
                inventory.setItem(4, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("75%")));
                inventory.setItem(5, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("75%")));
                inventory.setItem(6, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("75%")));
                return;

            case 16: // 80% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("80%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("80%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("80%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("80%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("80%")));
                inventory.setItem(4, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("80%")));
                inventory.setItem(5, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("80%")));
                inventory.setItem(6, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("80%")));
                inventory.setItem(7, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("80%")));
                return;

            case 17: // 85% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("85%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("85%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("85%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("85%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("85%")));
                inventory.setItem(4, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("85%")));
                inventory.setItem(5, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("85%")));
                inventory.setItem(6, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("85%")));
                inventory.setItem(7, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("85%")));
                return;

            case 18: // 90% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                inventory.setItem(4, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                inventory.setItem(5, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                inventory.setItem(6, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                inventory.setItem(7, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                inventory.setItem(8, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("90%")));
                return;

            case 19: // 95% volume
                inventory.setItem(9, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                inventory.setItem(0, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                inventory.setItem(1, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                inventory.setItem(2, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                inventory.setItem(3, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                inventory.setItem(4, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                inventory.setItem(5, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                inventory.setItem(6, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                inventory.setItem(7, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                inventory.setItem(8, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("95%")));
                return;

            case 20: // 100% volume (max)
                for (int i = 0; i < 11; i++) {
                    inventory.setItem(volumeSliderSlots.get(i), createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("100%")));
                }
        }
    }

    private void updatePitchSlider(Inventory inventory, CurrentSoundData soundData) {
        if (soundData == null) {
            return;
        }
        List<Integer> pitchSliderSlots = Arrays.asList(27, 36, 37, 38, 39, 40, 41, 42, 43, 44, 35);
        float currentPitch = soundData.getPitch();
        int currentIndex = PITCH_LEVELS.indexOf(currentPitch);

        for (int i = 0; i < 11; i++) {
            inventory.setItem(pitchSliderSlots.get(i), Frame());
        }

        // Index Numbers of PITCH_LEVELS (currentIndex)
        // 0 0.50f, 1 0.55f, 2 0.60f, 3 0.65f, 4 0.70f, 5 0.75f, 6 0.80f, 7 0.85f, 8 0.90f, 9 0.95f 10 1.00f,
        // 11 1.05f, 12 1.10f, 13 1.15f, 14 1.20f, 15 1.25f, 16 1.30f, 17 1.35f, 18 1.40f, 19 1.45f, 20 1.50f,
        // 21 1.55f, 22 1.60f, 23 1.65f, 24 1.70f, 25 1.75f, 26 1.80f, 27 1.85f, 28 1.90f, 29 1.95f, 30 2.00f

        switch (currentIndex) {
            case 0: // 0.50 pitch (min)
                inventory.setItem(27, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.50")));
                return;

            case 1: // 0.55 pitch
                inventory.setItem(27, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.55")));
                return;

            case 2: // 0.60 pitch
                inventory.setItem(27, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.60")));
                return;

            case 3: // 0.65 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.65")));
                inventory.setItem(36, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.65")));
                return;

            case 4: // 0.70 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.70")));
                inventory.setItem(36, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.70")));
                return;

            case 5: // 0.75 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.75")));
                inventory.setItem(36, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.75")));
                return;

            case 6: // 0.80 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.80")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.80")));
                inventory.setItem(37, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.80")));
                return;

            case 7: // 0.85 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.85")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.85")));
                inventory.setItem(37, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.85")));
                return;

            case 8: // 0.90 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.90")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.90")));
                inventory.setItem(37, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.90")));
                return;

            case 9: // 0.95 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.95")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.95")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.95")));
                inventory.setItem(38, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("0.95")));
                return;

            case 10: // 1.00 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.00")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.00")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.05")));
                inventory.setItem(38, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.00")));
                return;

            case 11: // 1.05 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.05")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.05")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.05")));
                inventory.setItem(38, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.05")));
                return;

            case 12: // 1.10 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.10")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.10")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.10")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.10")));
                inventory.setItem(39, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.10")));
                return;

            case 13: // 1.15 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.15")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.15")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.15")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.15")));
                inventory.setItem(39, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.15")));
                return;

            case 14: // 1.20 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.20")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.20")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.20")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.20")));
                inventory.setItem(39, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.20")));
                return;

            case 15: // 1.25 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.25")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.25")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.25")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.25")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.25")));
                inventory.setItem(40, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.25")));
                return;

            case 16: // 1.30 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.30")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.30")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.30")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.30")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.30")));
                inventory.setItem(40, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.30")));
                return;

            case 17: // 1.35 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.35")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.35")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.35")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.35")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.35")));
                inventory.setItem(40, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.35")));
                return;

            case 18: // 1.40 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.40")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.40")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.40")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.40")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.40")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.40")));
                inventory.setItem(41, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.40")));
                return;

            case 19: // 1.45 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.45")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.45")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.45")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.45")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.45")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.45")));
                inventory.setItem(41, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.45")));
                return;

            case 20: // 1.50 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.50")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.50")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.50")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.50")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.50")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.50")));
                inventory.setItem(41, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.50")));
                return;

            case 21: // 1.55 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.55")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.55")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.55")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.55")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.55")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.55")));
                inventory.setItem(41, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.55")));
                inventory.setItem(42, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.55")));
                return;

            case 22: // 1.60 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.60")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.60")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.60")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.60")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.60")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.60")));
                inventory.setItem(41, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.60")));
                inventory.setItem(42, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.60")));
                return;

            case 23: // 1.65 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.65")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.65")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.65")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.65")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.65")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.65")));
                inventory.setItem(41, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.65")));
                inventory.setItem(42, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.65")));
                return;

            case 24: // 1.70 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.70")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.70")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.70")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.70")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.70")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.70")));
                inventory.setItem(41, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.70")));
                inventory.setItem(42, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.70")));
                inventory.setItem(43, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.70")));
                return;

            case 25: // 1.75 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.75")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.75")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.75")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.75")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.75")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.75")));
                inventory.setItem(41, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.75")));
                inventory.setItem(42, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.75")));
                inventory.setItem(43, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.75")));
                return;

            case 26: // 1.80 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.80")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.80")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.80")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.80")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.80")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.80")));
                inventory.setItem(41, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.80")));
                inventory.setItem(42, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.80")));
                inventory.setItem(43, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.80")));
                return;

            case 27: // 1.85 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                inventory.setItem(41, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                inventory.setItem(42, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                inventory.setItem(43, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                inventory.setItem(44, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.85")));
                return;

            case 28: // 1.90 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                inventory.setItem(41, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                inventory.setItem(42, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                inventory.setItem(43, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                inventory.setItem(44, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.90")));
                return;

            case 29: // 1.95 pitch
                inventory.setItem(27, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                inventory.setItem(36, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                inventory.setItem(37, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                inventory.setItem(38, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                inventory.setItem(39, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                inventory.setItem(40, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                inventory.setItem(41, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                inventory.setItem(42, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                inventory.setItem(43, createButton(Material.LIME_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                inventory.setItem(44, createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("1.95")));
                return;

            case 30: // 2.00 pitch (max)
                for (int i = 0; i < 11; i++) {
                    inventory.setItem(pitchSliderSlots.get(i), createButton(Material.YELLOW_STAINED_GLASS_PANE, ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("2.00")));
                }
        }
    }

    private void decreaseVolume(Player player, CurrentSoundData soundData) {
        if (soundData == null) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }
        float currentVolume = soundData.getVolume();
        int currentIndex = VOLUME_LEVELS.indexOf(currentVolume);

        if (currentIndex == 0) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        } else if (currentIndex == 1) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
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
        float currentPitch = soundData.getPitch();
        int currentIndex = PITCH_LEVELS.indexOf(currentPitch);

        if (currentIndex == 0) {
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

        float newPitch = PITCH_LEVELS.get(currentIndex + 1);
        soundData.setPitch(newPitch);

        player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
    }


    @EventHandler
    // Clean up when player closes the inventory
    public void onInventoryClose (InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        lastClickTime.remove(player);
    }
}





