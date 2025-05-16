package com.gotze.blockbreaksounds.gui.settings;

import com.gotze.blockbreaksounds.util.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;

public class SettingsGUI { // TODO: Settings GUI is currently not implemented

    private final Inventory gui;

    public SettingsGUI(Player player) {
        this.gui = Bukkit.createInventory(null, 45, "Settings");
        setFrames();
        gui.setItem(20, PitchVariance);
        gui.setItem(21, ToolSpecificSoundsButton);
        gui.setItem(22, MultiSoundsButton);
        gui.setItem(23, CombinedSoundsButton);
        gui.setItem(24, SoundFilterButton);
        gui.setItem(36, GUIUtils.ReturnButton());
        player.openInventory(gui);
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
    }

    private final ItemStack ToolSpecificSoundsButton = createItemStack(
            Material.GOLDEN_SHOVEL,
            ChatColor.RED + "" + ChatColor.BOLD + "Tool Specific Sounds",
            Arrays.asList(ChatColor.WHITE + "ᴄʜᴏᴏѕᴇ ѕᴘᴇᴄɪꜰɪᴄ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋ ѕᴏᴜɴᴅѕ",
                    ChatColor.WHITE + "ʙᴀѕᴇᴅ ᴏɴ ᴡʜᴀᴛ ᴛᴏᴏʟ ᴡᴀѕ ᴜѕᴇᴅ",
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
            true,
            true,
            false
    );

    private final ItemStack CombinedSoundsButton = createItemStack(
            Material.MUSIC_DISC_PRECIPICE,
            ChatColor.RED + "" + ChatColor.BOLD + "Combined Sounds",
            Arrays.asList(ChatColor.WHITE + "ᴄʜᴏᴏѕᴇ ᴍᴜʟᴛɪᴘʟᴇ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋ ѕᴏᴜɴᴅѕ ᴛᴏ ᴘʟᴀʏ ѕɪᴍᴜʟᴛᴀɴᴇᴏᴜѕʟʏ",
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
            true,
            true,
            false
    );

    private final ItemStack SoundFilterButton = createItemStack(
            Material.GUSTER_BANNER_PATTERN,
            ChatColor.RED + "" + ChatColor.BOLD + "Sound Filter",
            Arrays.asList(ChatColor.WHITE + "ꜰɪʟᴛᴇʀ ʙʟᴏᴄᴋѕ ꜰʀᴏᴍ ᴘʟᴀʏɪɴɢ ѕᴏᴜɴᴅѕ ᴡʜᴇɴ ʙʀᴏᴋᴇɴ",
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
            true,
            true,
            false
    );

    private final ItemStack MultiSoundsButton = createItemStack(
            Material.TNT,
            ChatColor.RED + "" + ChatColor.BOLD + "Multi Sound",
            Arrays.asList(ChatColor.WHITE + "ᴛᴏɢɢʟᴇ ᴡʜᴇᴛʜᴇʀ ᴛᴏ ᴘʟᴀʏ ѕᴏᴜɴᴅ ᴍᴜʟᴛɪᴘʟᴇ ᴛɪᴍᴇѕ",
                    ChatColor.WHITE + "ɪꜰ ᴍᴜʟᴛɪᴘʟᴇ ʙʟᴏᴄᴋѕ ᴀʀᴇ ʙʀᴏᴋᴇɴ ᴀᴛ ᴏɴᴄᴇ",
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET")
    );

    private final ItemStack PitchVariance = createItemStack(
            Material.REPEATER,
            ChatColor.RED + "" + ChatColor.BOLD + "Pitch Variance",
            Arrays.asList(ChatColor.WHITE + "ᴛᴏɢɢʟᴇ ᴘɪᴛᴄʜ ᴠᴀʀɪᴀɴᴄᴇ",
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET")
    );
}