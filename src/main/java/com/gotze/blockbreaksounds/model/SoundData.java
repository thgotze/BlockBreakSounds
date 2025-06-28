package com.gotze.blockbreaksounds.model;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundData {
    private final Sound sound;
    private float volume;
    private float pitch;
    private final Material displayMaterial;

    public SoundData(Sound sound, float volume, float pitch, Material displayMaterial) {
        this.sound = sound;
        this.volume = Math.max(0.0f, Math.min(volume, 1.0f));
        this.pitch = Math.max(0.5f, Math.min(pitch, 2.0f));
        this.displayMaterial = displayMaterial;
    }

    public SoundData(Sound sound, Material displayMaterial) {
        this.sound = sound;
        this.volume = 0.5f;
        this.pitch = 1.0f;
        this.displayMaterial = displayMaterial;
    }

    public Sound getSound() {
        return sound;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = Math.max(0.0f, Math.min(volume, 1.0f));
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = Math.max(0.5f, Math.min(pitch, 2.0f));
    }

    public Material getDisplayMaterial() {
        return displayMaterial;
    }

    public void playSoundData(Player player) {
        player.playSound(player, sound, volume, pitch);
    }

    // Converts name of a Sound object into a formatted String
    // Input: ENTITY_PLAYER_LEVELUP (Sound) -> Output: "Entity Player Levelup" (String)
    public String getFormattedSoundName() {
        // Step 1: Convert the Sound to a String
        String soundString = sound.toString();

        // Step 2: Replace underscores and dots with spaces and convert to lowercase
        String withSpaces = soundString.replace("_", " ").replace(".", " ").toLowerCase();

        // Step 3: Capitalize each word and combine them into a single string
        StringBuilder capitalized = new StringBuilder();
        for (String word : withSpaces.split(" ")) {
            capitalized.append(Character.toUpperCase(word.charAt(0))) // First letter uppercase
                    .append(word.substring(1))             // Rest of the word
                    .append(" ");                                     // Add space between words
        }

        // Step 4: Trim trailing space and return the formatted result
        return capitalized.toString().trim();
    }
}