package com.gotze.blockbreaksounds.listener;

import com.gotze.blockbreaksounds.Main;
import com.gotze.blockbreaksounds.model.CurrentSoundData;
import com.gotze.blockbreaksounds.model.FavoriteSoundData;
import com.gotze.blockbreaksounds.model.SoundData;
import org.bukkit.Material;
import org.bukkit.Registry;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        File playerFile = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);

        if (!playerFile.exists()) {
            initializePlayerDataFile(player, playerFile, yamlConfiguration);
        } else {
            loadCurrentSoundDataFromFile(player, yamlConfiguration);
            loadFavoriteSoundsDataFromFile(player, yamlConfiguration);
        }
    }

    private void initializePlayerDataFile(Player player, File playerFile, YamlConfiguration yamlConfiguration) {
        yamlConfiguration.set("current-sound", new HashMap<>());
        yamlConfiguration.set("favorite-sounds", new ArrayList<>());

        try {
            yamlConfiguration.save(playerFile);
        } catch (IOException e) {
            Main.INSTANCE.getLogger().severe("Failed to create player data file for " + player.getName());
            e.printStackTrace();
        }
    }

    private void loadCurrentSoundDataFromFile(Player player, YamlConfiguration yamlConfiguration) {
        final String path = "current-sound";

        String soundName = yamlConfiguration.getString(path + ".sound");
        if (soundName == null) return;
        Sound sound = Registry.SOUNDS.match(soundName);
        if (sound == null) return;

        float volume = (float) yamlConfiguration.getDouble(path + ".volume");

        float pitch = (float) yamlConfiguration.getDouble(path + ".pitch");

        String materialName = yamlConfiguration.getString(path + ".material");
        if (materialName == null) return;
        Material material = Material.getMaterial(materialName);
        if (material == null) return;

        CurrentSoundData.currentSound.put(player.getUniqueId(), new SoundData(sound, volume, pitch, material));
    }

    private void loadFavoriteSoundsDataFromFile(Player player, YamlConfiguration yamlConfiguration) {
        final String path = "favorite-sounds";

        List<Map<?, ?>> favoriteSoundsList = yamlConfiguration.getMapList(path);
        if (favoriteSoundsList.isEmpty()) return;

        List<SoundData> favoriteSoundsDataList = new ArrayList<>();

        for (Map<?, ?> soundData : favoriteSoundsList) {
            Sound sound = Registry.SOUNDS.match((String) soundData.get("sound"));
            float volume = (float) (double) soundData.get("volume");
            float pitch = (float) (double) soundData.get("pitch");
            Material material = Material.valueOf((String) soundData.get("material"));

            favoriteSoundsDataList.add(new SoundData(sound, volume, pitch, material));
        }
        FavoriteSoundData.favoriteSounds.put(player.getUniqueId(), favoriteSoundsDataList);
    }
}