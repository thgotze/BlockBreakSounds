package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;
import org.bukkit.Sound;

public class SoundData {
    private Sound sound;
    private float volume;
    private float pitch;
    private Material displayMaterial;

    public SoundData(Sound sound, float volume, float pitch, Material displayMaterial) {
        this.sound = sound;
        setVolume(volume);
        setPitch(pitch);
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

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        if (volume < 0.0f) {
            this.volume = 0.0f;
        } else {
            this.volume = Math.min(volume, 1.0f);
        }
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        if (pitch < 0.5f) {
            this.pitch = 0.5f;
        } else {
            this.pitch = Math.min(pitch, 2.0f);
        }
    }

    public Material getDisplayMaterial() {
        return displayMaterial;
    }

    public void setDisplayMaterial(Material displayMaterial) {
        this.displayMaterial = displayMaterial;
    }
}