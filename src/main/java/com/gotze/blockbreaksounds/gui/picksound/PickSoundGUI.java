package com.gotze.blockbreaksounds.gui.picksound;

import com.gotze.blockbreaksounds.model.SoundData;
import com.gotze.blockbreaksounds.util.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Map;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class PickSoundGUI {

    private final Inventory gui;

    public PickSoundGUI(Player player) {
        this.gui = Bukkit.createInventory(null, 45, "Pick Sound");
        setFrames();
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(36, GUIUtils.returnButton);
        gui.setItem(40, GUIUtils.favoriteSoundsButton);
        gui.setItem(44, PickFromAllSoundsButton);
        setPickSoundButtons();
        player.openInventory(gui);
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.frame);
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.frame);
        }
    }

    private final ItemStack PickFromAllSoundsButton = createItemStack(
            Material.JUKEBOX,
            ChatColor.AQUA + "" + ChatColor.BOLD + "Pick From All Sounds",
            Arrays.asList(
                    ChatColor.WHITE + convertToSmallFont("pick a sound from all sounds"),
                    ChatColor.WHITE + convertToSmallFont("available in minecraft!"),
                    "",
                    ChatColor.DARK_GRAY + convertToSmallFont("... even the weird ones ...")
            )
    );

    private void setPickSoundButtons() {
        for (Map.Entry<Integer, SoundData> entry : PickSoundsRegistry. PICK_SOUND_MAP.entrySet()) {
            SoundData soundData = entry.getValue();

            gui.setItem(entry.getKey(), createItemStack(
                    soundData.getDisplayMaterial(),
                    ChatColor.AQUA + "" + ChatColor.BOLD + PickSoundsRegistry.SOUND_NICKNAMES.get(soundData.getSound()),
                    Arrays.asList(
                            ChatColor.WHITE + convertToSmallFont("sound: ") + ChatColor.GRAY + convertToSmallFont(soundData.getFormattedSoundName()),
                            ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", soundData.getVolume())),
                            ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", soundData.getPitch())),
                            "",
                            ChatColor.YELLOW + convertToSmallFont("click to pick sound")
                    ),
                    true,
                    true
            ));
        }
    }
}