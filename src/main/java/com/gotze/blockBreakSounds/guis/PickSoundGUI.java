package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.soundlogic.PickSoundsRegistry;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Map;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;

public class PickSoundGUI {

    private final Inventory gui;

    public PickSoundGUI(Player player) {
        this.gui = Bukkit.createInventory(null, 45, "Pick Sound");
        setFrames();
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(36, GUIUtils.ReturnButton());
        gui.setItem(40, FavoriteSoundsButton);
        gui.setItem(44, PickFromAllSoundsButton);
        setPickSoundButtons();
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

    private final ItemStack PickFromAllSoundsButton = createItemStack(
            Material.JUKEBOX,
            ChatColor.AQUA + "" + ChatColor.BOLD + "Pick From All Sounds",
            Arrays.asList(
                    ChatColor.WHITE + "ᴘɪᴄᴋ ᴀ ѕᴏᴜɴᴅ ꜰʀᴏᴍ ᴀʟʟ ѕᴏᴜɴᴅѕ",
                    ChatColor.WHITE + "ᴀᴠᴀɪʟᴀʙʟᴇ ɪɴ ᴍɪɴᴇᴄʀᴀꜰᴛ!",
                    "",
                    ChatColor.DARK_GRAY + "... ᴇᴠᴇɴ ᴛʜᴇ ᴡᴇɪʀᴅ ᴏɴᴇѕ ...")
    );

    private final ItemStack FavoriteSoundsButton = createItemStack(
            Material.NETHER_STAR,
            ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
            Arrays.asList(
                    ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.GREEN + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ",
                    "",
                    ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ " + ChatColor.GREEN + "ꜰᴀᴠᴏʀɪᴛᴇ")
    );

    private void setPickSoundButtons() {
        for (Map.Entry<Integer, SoundData> entry : PickSoundsRegistry.PICK_SOUND_MAP.entrySet()) {
            SoundData soundData = entry.getValue();

            gui.setItem(entry.getKey(), createItemStack(
                    soundData.getDisplayMaterial(),
                    ChatColor.AQUA + "" + ChatColor.BOLD + PickSoundsRegistry.SOUND_NICKNAMES.get(soundData.getSound()),
                    Arrays.asList(
                            ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + StringUtils.convertToSmallFont(soundData.getFormattedSoundName()),
                            ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + StringUtils.convertToSmallFont(String.format("%.2f", soundData.getVolume())),
                            ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + StringUtils.convertToSmallFont(String.format("%.2f", soundData.getPitch())),
                            "",
                            ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ"
                    )
            ));
        }
    }
}