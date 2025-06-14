package com.gotze.blockbreaksounds.listener;

import com.gotze.blockbreaksounds.BlockBreakSoundsPlugin;
import com.gotze.blockbreaksounds.model.CurrentSoundData;
import com.gotze.blockbreaksounds.model.FavoriteSoundData;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PlayerJoinListener implements Listener {

    public PlayerJoinListener() {}

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        initializePlayerDataFile(player);
        CurrentSoundData.loadCurrentSoundDataFromFile(player);
        FavoriteSoundData.loadFavoriteSoundsDataFromFile(player);
    }

    private void initializePlayerDataFile(Player player) {
        File playerFile = new File(BlockBreakSoundsPlugin.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");

        if (!playerFile.exists()) {
            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);

            if (!yamlConfiguration.contains("current-sound")) {
                yamlConfiguration.set("current-sound", new HashMap<>());
            }
            if (!yamlConfiguration.contains("favorite-sounds")) {
                yamlConfiguration.set("favorite-sounds", new ArrayList<>());
            }

            try {
                yamlConfiguration.save(playerFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}