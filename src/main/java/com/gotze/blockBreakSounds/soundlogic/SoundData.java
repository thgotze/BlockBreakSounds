package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;
import org.bukkit.Sound;

public class SoundData {
    private Sound sound;
    private float volume;
    private float pitch;
    private Material material;

    public SoundData(Sound sound, float volume, float pitch, Material material) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
        this.material = material;
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
        this.volume = volume;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}