package com.gotze.blockbreaksounds.gui.blockbreaksounds;

import com.gotze.blockbreaksounds.model.CurrentSoundData;
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
import java.util.List;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class BlockBreakSoundsGUI implements InventoryHolder {

    @Override
    public @NotNull Inventory getInventory() {
        return gui;
    }

    private final Inventory gui;

    public BlockBreakSoundsGUI(Player player) {
        gui = Bukkit.createInventory(this, 45, "Block Break Sounds");
        GUIUtils.setFrames(gui);
        gui.setItem(11, INCREASE_VOLUME_BUTTON);
        gui.setItem(13, CurrentSoundData.createCurrentSoundButton(player));
        gui.setItem(15, INCREASE_PITCH_BUTTON);
        gui.setItem(20, VOLUME_BUTTON);
        gui.setItem(22, PICK_SOUND_BUTTON);
        gui.setItem(24, PITCH_BUTTON);
        gui.setItem(26, SETTINGS_BUTTON);
        gui.setItem(29, DECREASE_VOLUME_BUTTON);
        gui.setItem(31, FAVORITE_SOUNDS_BUTTON);
        gui.setItem(33, DECREASE_PITCH_BUTTON);
        player.openInventory(gui);
    }

    private static final ItemStack SETTINGS_BUTTON = createItemStack(
            Material.COMMAND_BLOCK,
            ChatColor.RED + "" + ChatColor.BOLD + "Settings \uD83D\uDD27",
            List.of(
                    ChatColor.WHITE + convertToSmallFont("modify additional settings")),
            true,
            true,
            false
    );

    private static final ItemStack FAVORITE_SOUNDS_BUTTON = createItemStack(
            Material.NETHER_STAR,
            ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
            List.of(ChatColor.WHITE + convertToSmallFont("pick from your ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorited ") + ChatColor.WHITE + convertToSmallFont("sounds"))
    );

    private static final ItemStack PICK_SOUND_BUTTON = createItemStack(
            Material.NOTE_BLOCK,
            ChatColor.AQUA + "" + ChatColor.BOLD + "Pick Sound ♪",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("pick a sound to play"),
                    ChatColor.WHITE + convertToSmallFont("when you break blocks")
            )
    );

    private static final ItemStack VOLUME_BUTTON = createItemStack(
            Material.GOAT_HORN,
            ChatColor.YELLOW + "" + ChatColor.BOLD + "Tweak Volume \uD83D\uDD0A",
            Arrays.asList(
                    ChatColor.WHITE + convertToSmallFont("left click to ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("increase ") + ChatColor.WHITE + convertToSmallFont("volume"),
                    ChatColor.WHITE + convertToSmallFont("right click to ") + ChatColor.RED + ChatColor.BOLD + convertToSmallFont("decrease ") + ChatColor.WHITE + convertToSmallFont("volume"),
                    ChatColor.WHITE + "",
                    ChatColor.GRAY + convertToSmallFont("volume can be set between 0 and 100")),
            true
    );

    private static final ItemStack INCREASE_VOLUME_BUTTON = createItemStack(
            Material.MANGROVE_BUTTON,
            ChatColor.GREEN + "" + ChatColor.BOLD + "[+] " + ChatColor.BOLD + convertToSmallFont("increase volume")
    );

    private static final ItemStack DECREASE_VOLUME_BUTTON = createItemStack(
            Material.MANGROVE_BUTTON,
            ChatColor.RED + "" + ChatColor.BOLD + "[-] " + ChatColor.BOLD + convertToSmallFont("decrease volume")
    );

    private static final ItemStack PITCH_BUTTON = createItemStack(
            Material.BELL,
            ChatColor.YELLOW + "" + ChatColor.BOLD + "Tweak Pitch \uD83D\uDD14",
            Arrays.asList(
                    ChatColor.WHITE + convertToSmallFont("left click to ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("increase ") + ChatColor.WHITE + convertToSmallFont("pitch"),
                    ChatColor.WHITE + convertToSmallFont("right click to ") + ChatColor.RED + ChatColor.BOLD + convertToSmallFont("decrease ") + ChatColor.WHITE + convertToSmallFont("pitch"),
                    ChatColor.WHITE + "",
                    ChatColor.GRAY + convertToSmallFont("pitch can be set between 0.50 and 2.00"))
    );

    private static final ItemStack INCREASE_PITCH_BUTTON = createItemStack(
            Material.MANGROVE_BUTTON,
            ChatColor.GREEN + "" + ChatColor.BOLD + "[+] " + ChatColor.BOLD + convertToSmallFont("increase pitch")
    );

    private static final ItemStack DECREASE_PITCH_BUTTON = createItemStack(
            Material.MANGROVE_BUTTON,
            ChatColor.RED + "" + ChatColor.BOLD + "[-] " + ChatColor.BOLD + convertToSmallFont("decrease pitch")
    );
}