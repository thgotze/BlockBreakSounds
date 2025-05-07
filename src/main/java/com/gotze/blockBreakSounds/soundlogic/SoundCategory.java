package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;

import java.util.List;

public class SoundCategory {
    private final String categoryName;
    private final Material displayMaterial;
    private final List<Object> children;  // Holds either SoundCategories or SoundData

    public SoundCategory(String name, Material displayMaterial, List<Object> children) {
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

    public List<Object> getChildren() {
        return children;
    }
}