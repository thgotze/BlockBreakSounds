package com.gotze.blockbreaksounds.model;

import org.bukkit.Material;

import java.util.List;

public class SoundCategory {
    private final String categoryTitle;
    private final Material displayMaterial;
    private final List<Object> children;  // Holds either SoundCategories or SoundData

    public SoundCategory(String categoryTitle, Material displayMaterial, List<Object> children) {
        this.categoryTitle = categoryTitle;
        this.displayMaterial = displayMaterial;
        this.children = children;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public Material getDisplayMaterial() {
        return displayMaterial;
    }

    public List<Object> getChildren() {
        return children;
    }
}