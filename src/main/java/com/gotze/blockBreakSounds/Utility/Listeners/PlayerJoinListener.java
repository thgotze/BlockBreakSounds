package com.gotze.blockBreakSounds.Utility.Listeners;

import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        CurrentSoundData currentSoundData = CurrentSoundData.loadFromYAML(player);
        CurrentSoundData.currentSound.put(player.getUniqueId(), currentSoundData);
    }
}

//        PersistentDataContainer playerPersistentDataContainer = player.getPersistentDataContainer();
//        if (!(playerPersistentDataContainer.has(new NamespacedKey(Main.INSTANCE, "sound")))) {
//            return;
//        }
//        soundData.setSound(Sound.valueOf(playerPersistentDataContainer.get(new NamespacedKey(Main.INSTANCE, "sound"), PersistentDataType.STRING)));
//        soundData.setVolume(playerPersistentDataContainer.get(new NamespacedKey(Main.INSTANCE, "volume"), PersistentDataType.FLOAT));
//        soundData.setPitch(playerPersistentDataContainer.get(new NamespacedKey(Main.INSTANCE, "pitch"), PersistentDataType.FLOAT));
