package com.gotze.blockbreaksounds.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class ItemStackCreator {

    private ItemStackCreator() {}

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

    // Overloaded methods in descending order of parameters provided
    public static ItemStack createItemStack(Material material, String displayName, List<String> lore, boolean hideAdditionalTooltip, boolean hideAttributes) {
        return createItemStack(material, displayName, lore, hideAdditionalTooltip, hideAttributes, false);
    }

    public static ItemStack createItemStack(Material material, String displayName, List<String> lore, boolean hideAdditionalTooltip) {
        return createItemStack(material, displayName, lore, hideAdditionalTooltip, false, false);
    }

    public static ItemStack createItemStack(Material material, String displayName, List<String> lore) {
        return createItemStack(material, displayName, lore, false, false, false);
    }

    public static ItemStack createItemStack(Material material, String displayName) {
        return createItemStack(material, displayName, null, false, false, false);
    }

    public static ItemStack createItemStack(Material material) {
        return createItemStack(material, null, null, false, false, false);
    }
}