package com.gotze.blockbreaksounds.model;

import com.gotze.blockbreaksounds.BlockBreakSoundsPlugin;
import com.gotze.blockbreaksounds.util.SoundUtils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CurrentSoundData extends SoundData {

    public static final Map<UUID, SoundData> currentSound = new HashMap<>();

    private CurrentSoundData(Sound sound, float volume, float pitch, Material displayMaterial) {
        super(sound, volume, pitch, displayMaterial);
    }

    public static void increaseVolume(Player player) {
        SoundData currentSoundData = currentSound.get(player.getUniqueId());
        if (currentSoundData == null) {
            SoundUtils.playErrorSound(player);
            return;
        }

        currentSoundData.setVolume(Math.round((currentSoundData.getVolume() + 0.05f) * 100f) / 100f);
        currentSoundData.playSoundData(player);
        currentSound.put(player.getUniqueId(), currentSoundData);
        saveCurrentSoundDataToYAML(player);
    }

    public static void decreaseVolume(Player player) {
        SoundData currentSoundData = currentSound.get(player.getUniqueId());
        if (currentSoundData == null || currentSoundData.getVolume() == 0.00f) {
            SoundUtils.playErrorSound(player);
            return;
        }

        if (currentSoundData.getVolume() == 0.05f ) {
            SoundUtils.playErrorSound(player);
        }

        currentSoundData.setVolume(Math.round((currentSoundData.getVolume() - 0.05f) * 100f) / 100f);
        currentSoundData.playSoundData(player);
        currentSound.put(player.getUniqueId(), currentSoundData);
        saveCurrentSoundDataToYAML(player);
    }

    public static void increasePitch(Player player) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) {
            SoundUtils.playErrorSound(player);
            return;
        }

        currentSoundData.setVolume(Math.round((currentSoundData.getPitch() + 0.05f) * 100f) / 100f);
        currentSoundData.playSoundData(player);
        currentSound.put(player.getUniqueId(), currentSoundData);
        saveCurrentSoundDataToYAML(player);
    }

    public static void decreasePitch(Player player) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null || currentSoundData.getPitch() == 0.50f) {
            SoundUtils.playErrorSound(player);
            return;
        }

        currentSoundData.setVolume(Math.round((currentSoundData.getPitch() - 0.05f) * 100f) / 100f);
        currentSoundData.playSoundData(player);
        currentSound.put(player.getUniqueId(), currentSoundData);
        saveCurrentSoundDataToYAML(player);
    }

    public static void saveCurrentSoundDataToYAML(Player player) {
        File playerFile = new File(BlockBreakSoundsPlugin.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);
        String path = "current-sound";

        SoundData playerCurrentSound = currentSound.get(player.getUniqueId());

        if (playerCurrentSound == null) {
            yamlConfiguration.set(path + ".sound", null);
            yamlConfiguration.set(path + ".volume", null);
            yamlConfiguration.set(path + ".pitch", null);
            yamlConfiguration.set(path + ".material", null);
        } else {
            yamlConfiguration.set(path + ".sound", playerCurrentSound.getSound().toString());
            yamlConfiguration.set(path + ".volume", playerCurrentSound.getVolume());
            yamlConfiguration.set(path + ".pitch", playerCurrentSound.getPitch());
            yamlConfiguration.set(path + ".material", playerCurrentSound.getDisplayMaterial().toString());
        }

        try {
            yamlConfiguration.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}