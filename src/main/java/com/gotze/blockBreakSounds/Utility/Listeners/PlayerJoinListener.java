package com.gotze.blockBreakSounds.Utility.Listeners;

import com.gotze.blockBreakSounds.Main;
import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PersistentDataContainer container = player.getPersistentDataContainer();

        if (!(container.has(new NamespacedKey(Main.INSTANCE, "sound")))) {
            return;
        }
        CurrentSoundData soundData = CurrentSoundData.playerSounds.get(player.getUniqueId());

        if (soundData == null) {
            return;
        }
        soundData.setSound(Sound.valueOf(container.get(new NamespacedKey(Main.INSTANCE, "sound"), PersistentDataType.STRING)));
        soundData.setVolume(container.get(new NamespacedKey(Main.INSTANCE, "volume"), PersistentDataType.FLOAT));
        soundData.setPitch(container.get(new NamespacedKey(Main.INSTANCE, "pitch"), PersistentDataType.FLOAT));

        CurrentSoundData.playerSounds.put(player.getUniqueId(), soundData);
    }
}