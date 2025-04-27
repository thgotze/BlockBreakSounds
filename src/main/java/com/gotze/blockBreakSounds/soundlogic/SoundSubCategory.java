package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;

import java.util.List;

public class SoundSubCategory {
    private final String name;
    private final Material displayMaterial;
    private final List<SoundData> soundData;

    public SoundSubCategory(String name, Material displayMaterial, List<SoundData> soundData) {
        this.name = name;
        this.displayMaterial = displayMaterial;
        this.soundData = soundData;
    }
}
