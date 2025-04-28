package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;

import java.util.List;

public class SoundCategory {
    private final String categoryName;
    private final Material displayMaterial;
    private final List<?> children;  // Holds either SoundCategory or SoundData, but never both

    public SoundCategory(String name, Material displayMaterial, List<?> children) {
        this.categoryName = name;
        this.displayMaterial = displayMaterial;
        this.children = children;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Material getDisplayMaterial() {
        return displayMaterial;
    }

    public List<?> getChildren() {
        return children;
    }
}