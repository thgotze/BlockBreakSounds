package com.gotze.blockbreaksounds.gui.allsounds;

import com.gotze.blockbreaksounds.model.CurrentSoundData;
import com.gotze.blockbreaksounds.model.SoundCategory;
import com.gotze.blockbreaksounds.model.SoundData;
import com.gotze.blockbreaksounds.util.GUIUtils;
import com.gotze.blockbreaksounds.util.ItemStackCreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class AllSoundsGUI implements InventoryHolder {

    private final Inventory gui;
    private final String guiTitle;

    @Override
    public @NotNull Inventory getInventory() {
        return gui;
    }

    public AllSoundsGUI(Player player, String guiTitle) {
        this.gui = Bukkit.createInventory(this, 45, guiTitle);
        this.guiTitle = guiTitle;
        setFrames();
        setCategoryOrSoundButtons();
        gui.setItem(4, CurrentSoundData.CurrentSoundDisplayButton(player));
        gui.setItem(36, GUIUtils.RETURN_BUTTON);
        gui.setItem(40, GUIUtils.FAVORITE_SOUNDS_BUTTON);
        player.openInventory(gui);
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.FRAME);
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.FRAME);
        }
    }

    private void setCategoryOrSoundButtons() {
        SoundCategory category = AllSoundsRegistry.CATEGORY_MAP.get(guiTitle);
        if (category == null) return;

        int slot = category.getCategoryTitle().equals("All Sounds") ? 20 : 9;

        for (Object child : category.getChildren()) {
            if (child instanceof SoundCategory soundCategory) {
                gui.setItem(slot++, ItemStackCreator.createItemStack(
                        soundCategory.getDisplayMaterial(),
                        ChatColor.AQUA + "" + ChatColor.BOLD + soundCategory.getCategoryTitle(),
                        null,
                        true,
                        true
                ));
            } else if (child instanceof SoundData soundData) {
                gui.setItem(slot++, ItemStackCreator.createItemStack(
                        soundData.getDisplayMaterial(),
                        ChatColor.AQUA + "" + ChatColor.BOLD + (soundData.getFormattedSoundName()),
                        Arrays.asList(
                                "",
                                ChatColor.YELLOW + convertToSmallFont("click to pick sound")
                        ),
                        true,
                        true
                ));
            }
        }
    }
}