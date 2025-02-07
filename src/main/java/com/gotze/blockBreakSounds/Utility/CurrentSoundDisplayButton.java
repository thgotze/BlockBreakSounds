package com.gotze.blockBreakSounds.Utility;

import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.Utility.ButtonCreator.createButton;
import static com.gotze.blockBreakSounds.Utility.SmallFontConverter.convertToSmallFont;
import static com.gotze.blockBreakSounds.Utility.SmallFontConverter.removeSpecialCharacters;

public class CurrentSoundDisplayButton {

    public static ItemStack CurrentSoundDisplayButton(Player player) {

        CurrentSoundData soundData = CurrentSoundData.playerSounds.get(player.getUniqueId());

        if (soundData == null) {
            return createButton(
                    Material.GLASS_PANE,
                    ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    Arrays.asList(
                            ChatColor.WHITE + "ɴᴏ ѕᴏᴜɴᴅ ѕᴇᴛ"
                    )
            );
        }

        Material material = SoundMap.getMaterialFromSound(soundData.getSound());

        return createButton(
                material,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                Arrays.asList(
                        ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont(removeSpecialCharacters(soundData.getSound().name())),
                        ChatColor.WHITE + convertToSmallFont("Volume: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont(String.format("%.0f%%", soundData.getVolume() * 100)),
                        ChatColor.WHITE + convertToSmallFont("Pitch: ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont(String.format("%.2f", soundData.getPitch())),
                        "",
                        ChatColor.GRAY + "ᴄʟɪᴄᴋ ᴛᴏ ᴘʟᴀʏᴛᴇѕᴛ ѕᴏᴜɴᴅ",
                        ChatColor.GRAY + "ᴅʀᴏᴘ ɪᴛᴇᴍ ᴛᴏ ᴄʟᴇᴀʀ ѕᴏᴜɴᴅ",
                        ChatColor.GRAY + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ ꜰᴀᴠᴏʀɪᴛᴇ"
                ),
                true,
                false,
                true
        );
    }
}