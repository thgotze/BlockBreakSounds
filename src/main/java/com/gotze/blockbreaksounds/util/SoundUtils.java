package com.gotze.blockbreaksounds.util;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundUtils {

    public static void playErrorSound(Player player) {
        player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
    }

    public static void playUIClickSound(Player player) {
        player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
    }
}
