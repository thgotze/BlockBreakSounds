package com.gotze.blockBreakSounds.Utility.Listeners;

import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
import com.gotze.blockBreakSounds.Utility.SoundData.FavoriteSoundsData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        CurrentSoundData.loadCurrentSoundDataFromYAML(player);
        FavoriteSoundsData.loadFavoriteSoundsDataFromYAML(player);
    }
}