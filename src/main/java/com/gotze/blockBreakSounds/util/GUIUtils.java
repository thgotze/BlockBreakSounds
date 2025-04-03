package com.gotze.blockBreakSounds.util;

import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundMap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockBreakSounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockBreakSounds.util.TextUtils.convertToSmallFont;

public class GUIUtils {

    public static ItemStack Frame() {
        return createItemStack(
                Material.BLACK_STAINED_GLASS_PANE,
                null,
                null,
                false,
                true
        );
    }

    public static ItemStack ReturnButton() {
        return ItemStackCreator.createItemStack(
                Material.ARROW,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "← ʀᴇᴛᴜʀɴ"
        );
    }

    public static ItemStack CurrentSoundDisplayButton(Player player) {
        CurrentSoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) {
            return ItemStackCreator.createItemStack(
                    Material.GLASS_PANE,
                    ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    List.of(
                            ChatColor.WHITE + "ɴᴏ ѕᴏᴜɴᴅ ѕᴇᴛ"
                    )
            );
        } else {
            return ItemStackCreator.createItemStack(
                    SoundMap.getMaterialFromSound(currentSoundData.getSound()),
                    ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    Arrays.asList(
                            ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(currentSoundData.getSound().toString()),
                            ChatColor.WHITE + convertToSmallFont("Volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", currentSoundData.getVolume() * 100)),
                            ChatColor.WHITE + convertToSmallFont("Pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", currentSoundData.getPitch())),
                            "",
                            ChatColor.WHITE + "ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.AQUA + "ᴘʟᴀʏᴛᴇѕᴛ " + ChatColor.WHITE + "ѕᴏᴜɴᴅ",
                            ChatColor.WHITE + "ᴅʀᴏᴘ ɪᴛᴇᴍ ᴛᴏ " + ChatColor.RED + "ᴄʟᴇᴀʀ " + ChatColor.WHITE + "ѕᴏᴜɴᴅ",
                            ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.YELLOW + "ꜰᴀᴠᴏʀɪᴛᴇ " + ChatColor.WHITE + "ѕᴏᴜɴᴅ"
                    ),
                    true,
                    false,
                    true
            );
        }
    }
}