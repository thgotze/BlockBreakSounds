package com.gotze.blockbreaksounds.model;

import com.gotze.blockbreaksounds.BlockBreakSoundsPlugin;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FavoriteSoundData extends SoundData {

    public static final Map<UUID, List<SoundData>> favoriteSounds = new HashMap<>();

    public FavoriteSoundData(Sound sound, float volume, float pitch, Material material) {
        super(sound, volume, pitch, material);
    }

    public static void addSoundToFavorites(Player player, SoundData soundData) {
        List<SoundData> playerFavorites = favoriteSounds.computeIfAbsent(player.getUniqueId(), k -> new ArrayList<>());

        if (playerFavorites.size() >= 27) return;

        for (SoundData favoriteSoundsData : playerFavorites) {
            if (favoriteSoundsData.getSound() == soundData.getSound()
                    && favoriteSoundsData.getVolume() == soundData.getVolume()
                    && favoriteSoundsData.getPitch() == soundData.getPitch()) {
                return;
            }
        }

        player.playSound(player, Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5f, 1.5f);
        playerFavorites.add(soundData);
        favoriteSounds.put(player.getUniqueId(), playerFavorites);
        saveFavoriteSoundsDataToYAML(player);
    }

    public static void removeSoundFromFavorites(Player player, int favoriteSoundNumber) {
        List<SoundData> playerFavorites = favoriteSounds.get(player.getUniqueId());
        player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
        playerFavorites.remove(favoriteSoundNumber);
        favoriteSounds.put(player.getUniqueId(), playerFavorites);
        saveFavoriteSoundsDataToYAML(player);
    }

    public static void saveFavoriteSoundsDataToYAML(Player player) {
        File playerFile = new File(BlockBreakSoundsPlugin.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);
        String path = "favorite-sounds";

        List<Map<String, Object>> favoriteSoundsList = new ArrayList<>();

        List<SoundData> playerFavorites = favoriteSounds.getOrDefault(player.getUniqueId(), new ArrayList<>());

        for (SoundData favoriteSoundData : playerFavorites) {
            Map<String, Object> soundData = new LinkedHashMap<>();
            soundData.put("sound", favoriteSoundData.getSound().toString());
            soundData.put("volume", favoriteSoundData.getVolume());
            soundData.put("pitch", favoriteSoundData.getPitch());
            soundData.put("material", favoriteSoundData.getDisplayMaterial().toString());
            favoriteSoundsList.add(soundData);
        }
        yamlConfiguration.set(path, favoriteSoundsList);

        try {
            yamlConfiguration.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}