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

public class GUIUtils {

    // Frame (Black Stained Glass Pane)
    public static ItemStack Frame() {
        return createButton(
                Material.BLACK_STAINED_GLASS_PANE,
                null,
                null,
                false,
                true
        );
    }

    public static ItemStack CurrentSoundDisplayButton(Player player) {

        CurrentSoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());

        if (currentSoundData == null) {
            return createButton(
                    Material.GLASS_PANE,
                    ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    Arrays.asList(
                            ChatColor.WHITE + "ɴᴏ ѕᴏᴜɴᴅ ѕᴇᴛ"
                    )
            );
        }

        return createButton(
                SoundMap.getMaterialFromSound(currentSoundData.getSound()),
                ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                Arrays.asList(
                        ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(removeSpecialCharacters(currentSoundData.getSound().name())),
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
