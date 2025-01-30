package com.gotze.blockBreakSounds.Utility;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static com.gotze.blockBreakSounds.Utility.ButtonCreator.createButton;

public class GUIUtils {

    // Frame (Black Stained Glass Pane)
    public static ItemStack Frame() {
        return createButton(
                Material.BLACK_STAINED_GLASS_PANE,
                null,
                null,
                false,
                true
        );
    }
}
