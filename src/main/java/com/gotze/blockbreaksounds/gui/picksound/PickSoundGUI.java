package com.gotze.blockbreaksounds.gui.picksound;

import com.gotze.blockbreaksounds.model.CurrentSoundData;
import com.gotze.blockbreaksounds.model.SoundData;
import com.gotze.blockbreaksounds.util.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Map;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class PickSoundGUI implements InventoryHolder {

    private final Inventory gui;

    @Override
    public @NotNull Inventory getInventory() {
        return gui;
    }

    public PickSoundGUI(Player player) {
        this.gui = Bukkit.createInventory(this, 45, "Pick Sound");
        GUIUtils.setFrames(gui);
        gui.setItem(4, CurrentSoundData.CurrentSoundDisplayButton(player));
        gui.setItem(36, GUIUtils.RETURN_BUTTON);
        gui.setItem(40, GUIUtils.FAVORITE_SOUNDS_BUTTON);
        gui.setItem(44, PickFromAllSoundsButton);
        setPickSoundButtons();
        player.openInventory(gui);
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