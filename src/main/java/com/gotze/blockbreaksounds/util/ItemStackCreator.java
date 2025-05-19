package com.gotze.blockbreaksounds.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class ItemStackCreator {

    // Creates an ItemStack with customizable display name, lore, and flags.

    // @param material The material type for the ItemStack (e.g. Material.STONE_BLOCK).
    // @param displayName The display name of the ItemStack (null if not desired).
    // @param lore The lore of the ItemStack (null if not desired).
    // @param hideAdditionalTooltip Flag to hide additional tooltips (e.g., music discs).
    // @param hideAttributes Flag to hide item attributes (e.g., damage, armor values).
    // @param hideTooltipBox Flag to hide the tooltip box when hovering over the item.
    // @return A fully customized ItemStack.

    public static ItemStack createItemStack(Material material, String displayName, List<String> lore, boolean hideAdditionalTooltip, boolean hideAttributes, boolean hideTooltipBox) {

        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta == null) return item;

        if (displayName != null) itemMeta.setDisplayName(displayName);
        if (lore != null) itemMeta.setLore(lore);
        if (hideAdditionalTooltip) itemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
        if (hideAttributes) itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        if (hideTooltipBox) itemMeta.setHideTooltip(true);

        item.setItemMeta(itemMeta);

        return item;
    }

    // Constants for default parameter values
    private static final String DEFAULT_DISPLAY_NAME = null;
    private static final List<String> DEFAULT_LORE = null;
    private static final boolean DEFAULT_HIDE_ADDITIONAL_TOOLTIP = false;
    private static final boolean DEFAULT_HIDE_ATTRIBUTES = false;
    private static final boolean DEFAULT_HIDE_TOOLTIP_BOX = false;

    // Overloaded methods in descending order of parameters
    public static ItemStack createItemStack(Material material, String displayName, List<String> lore, boolean hideAdditionalTooltip, boolean hideAttributes) {
        return createItemStack(material, displayName, lore, hideAdditionalTooltip, hideAttributes, DEFAULT_HIDE_TOOLTIP_BOX);
    }

    public static ItemStack createItemStack(Material material, String displayName, List<String> lore, boolean hideAdditionalTooltip) {
        return createItemStack(material, displayName, lore, hideAdditionalTooltip, DEFAULT_HIDE_ATTRIBUTES, DEFAULT_HIDE_TOOLTIP_BOX);
    }

    public static ItemStack createItemStack(Material material, String displayName, List<String> lore) {
        return createItemStack(material, displayName, lore, DEFAULT_HIDE_ADDITIONAL_TOOLTIP, DEFAULT_HIDE_ATTRIBUTES, DEFAULT_HIDE_TOOLTIP_BOX);
    }

    public static ItemStack createItemStack(Material material, String displayName) {
        return createItemStack(material, displayName, DEFAULT_LORE, DEFAULT_HIDE_ADDITIONAL_TOOLTIP, DEFAULT_HIDE_ATTRIBUTES, DEFAULT_HIDE_TOOLTIP_BOX);
    }

    public static ItemStack createItemStack(Material material) {
        return createItemStack(material, DEFAULT_DISPLAY_NAME, DEFAULT_LORE, DEFAULT_HIDE_ADDITIONAL_TOOLTIP, DEFAULT_HIDE_ATTRIBUTES, DEFAULT_HIDE_TOOLTIP_BOX);
    }
}