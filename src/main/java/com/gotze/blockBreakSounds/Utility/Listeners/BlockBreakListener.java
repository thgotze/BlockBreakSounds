package com.gotze.blockBreakSounds.Utility.Listeners;

import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.Random;

public class BlockBreakListener implements Listener {

    private static final float[] pitchVariations = {-0.05f, -0.025f, 0.0f, 0.025f, 0.05f};
    private static final Random random = new Random();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        CurrentSoundData soundData = CurrentSoundData.currentSound.get(player.getUniqueId());

        if (soundData == null) {
            return;
        }

        float randomPitchVariation = pitchVariations[random.nextInt(pitchVariations.length)];
        float finalPitch = soundData.getPitch() + randomPitchVariation;

        player.playSound(player, soundData.getSound(), soundData.getVolume(), finalPitch);
    }
}