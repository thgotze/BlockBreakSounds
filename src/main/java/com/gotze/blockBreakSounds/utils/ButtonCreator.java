package com.gotze.blockBreakSounds.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ButtonCreator {

    // 1st: Providing a material i.e. the block the button itself is. Mandatory!!!
    // With the methods underneath you can optionally provide:
    // 2nd: Display name
    // 3rd: Lore text (Text underneath the display name)
    // 4th: A flag that hides additional tooltips (Like seen on music discs, goat horns etc.)
    // 5th: A flag that hides the tooltip box entirely (The box that appears when you hover over an item)
    // 6th: A flag to hide attributes (Such as tools showing damage, armor pieces showing armor)

    // Method 1 : Material
    public static ItemStack createButton(Material material) {
        return createButton(material, null, null, false, false, false);
    }

    // Method 2 : Material, Name
    public static ItemStack createButton(Material material, String displayName) {
        return createButton(material, displayName, null, false, false, false);
    }

    // Method 3 : Material, Name, Lore
    public static ItemStack createButton(Material material, String displayName, List<String> lore) {
        return createButton(material, displayName, lore, false, false, false);
    }

    // Method 4 : Material, Name, Lore, Hide Additional Tooltip
    public static ItemStack createButton(Material material, String displayName, List<String> lore, boolean hideAdditionalTooltip) {
        return createButton(material, displayName, lore, hideAdditionalTooltip, false, false);
    }

    // Method 5 : Material, Name, Lore, Hide Additional Tooltip, Hide Tooltip Flag
    public static ItemStack createButton(Material material, String displayName, List<String> lore, boolean hideAdditionalToolTip, boolean hideTooltipBox) {
        return createButton(material, displayName, lore, hideAdditionalToolTip, hideTooltipBox,false );
    }

    // Method 6 : Material, Name, Lore, Hide Additional Tooltip, Hide Tooltip Flag
    public static ItemStack createButton(Material material, String displayName, List<String> lore, boolean hideAdditionalTooltip, boolean hideTooltipBox, boolean hideAttributes) {

        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();

        if (itemMeta != null) {
            itemMeta.setDisplayName(displayName);

            if (lore != null) {
                itemMeta.setLore(lore);
            }
            if (hideAdditionalTooltip) {
                itemMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
            }
            if (hideTooltipBox) {
                itemMeta.setHideTooltip(true);
            }
            if (hideAttributes) {
                itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            }
            item.setItemMeta(itemMeta);
        }
        return item;
    }
}