package com.gotze.blockBreakSounds.soundlogic;

import com.gotze.blockBreakSounds.Main;
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

        if (playerFavorites.size() >= 27) {
            System.out.println("you have " + playerFavorites.size() + " sounds favorited");
            return;
        }

        System.out.println("you have " + playerFavorites.size() + " sounds favorited");

        for (SoundData favoriteSoundsData : playerFavorites) {
            if (favoriteSoundsData.getSound() == soundData.getSound()
                    && favoriteSoundsData.getVolume() == soundData.getVolume()
                    && favoriteSoundsData.getPitch() == soundData.getPitch()) {
                System.out.println(favoriteSoundsData.getSound().toString() + " is the same as " + soundData.getSound().toString());
                return;
            }
        }
        System.out.println("no identical sounddata found in favorites... adding to favorites");

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
        System.out.println("saving to yaml");
        File playerFile = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);
        String path = "favorite-sounds";

        List<Map<String, Object>> favoriteSoundsList = new ArrayList<>();

        List<SoundData> playerFavorites = favoriteSounds.getOrDefault(player.getUniqueId(), new ArrayList<>());

        for (SoundData favoriteSoundData : playerFavorites) {
            Map<String, Object> soundData = new LinkedHashMap<>();
            soundData.put("sound", favoriteSoundData.getSound().toString());
            soundData.put("volume", favoriteSoundData.getVolume());
            soundData.put("pitch", favoriteSoundData.getPitch());
            soundData.put("material", favoriteSoundData.getMaterial().toString());
            favoriteSoundsList.add(soundData);
            System.out.println("added a favorite sound data to playerfavorites");

        }
        yamlConfiguration.set(path, favoriteSoundsList);
        System.out.println("finished setting to yaml configuration");

        try {
            yamlConfiguration.save(playerFile);
            System.out.println("successfully saved to yaml");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed saving to yaml");

        }
    }

    public static void loadFavoriteSoundsDataFromFile(Player player) {
        File file = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        String path = "favorite-sounds";

        List<Map<?, ?>> favoriteSoundsList = yamlConfiguration.getMapList(path);

        if (favoriteSoundsList.isEmpty()) return;

        List<SoundData> favoriteSoundsDataList = new ArrayList<>();

        for (Map<?, ?> soundData : favoriteSoundsList) {
            try {
                Sound sound = Sound.valueOf((String) soundData.get("sound"));
                float volume = ((Number) soundData.get("volume")).floatValue();
                float pitch = ((Number) soundData.get("pitch")).floatValue();
                Material material = Material.valueOf((String) soundData.get("material"));
                favoriteSoundsDataList.add(new SoundData(sound, volume, pitch, material));
            } catch (Exception e) {
                System.out.println("Failed to load a favorite sound for " + player.getName());
            }
        }
        favoriteSounds.put(player.getUniqueId(), favoriteSoundsDataList);
    }
}