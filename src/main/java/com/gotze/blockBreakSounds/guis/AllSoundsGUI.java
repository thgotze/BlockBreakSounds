package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.soundlogic.AllSoundsRegistry;
import com.gotze.blockBreakSounds.soundlogic.SoundCategory;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;

public class AllSoundsGUI {

    private final Inventory gui;
    private final String guiTitle;

    public AllSoundsGUI(Player player, String guiTitle) {
        this.gui = Bukkit.createInventory(null, 45, guiTitle);
        this.guiTitle = guiTitle;
        setFrames();
        setCategoryOrSoundButtons();
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(36, GUIUtils.ReturnButton());
        gui.setItem(40, favoriteSoundsButton);
        player.openInventory(gui);
    }

    private void setCategoryOrSoundButtons() {
        SoundCategory category;
        int slot = 9;

        if (guiTitle.equals("All Sounds")) {
            category = AllSoundsRegistry.ALL_SOUNDS;
            slot = 20;
        } else {
            category = findCategory(AllSoundsRegistry.ALL_SOUNDS);
        }
        if (category == null) return;

        for (Object child : category.getChildren()) {
            if (child instanceof SoundCategory) {
                gui.setItem(slot++, createItemStack(
                        ((SoundCategory) child).getDisplayMaterial(),
                        ChatColor.AQUA + "" + ChatColor.BOLD + ((SoundCategory) child).getCategoryName(),
                        null,
                        true,
                        true
                ));
            } else if (child instanceof SoundData) {
                gui.setItem(slot++, createItemStack(
                        ((SoundData) child).getDisplayMaterial(),
                        ChatColor.AQUA + "" + ChatColor.BOLD + StringUtils.getFormattedSoundName(((SoundData) child).getSound()),
                        Arrays.asList(
                                "",
                                ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ"),
                        true,
                        true
                ));
            }
        }
    }

    private SoundCategory findCategory(SoundCategory soundCategory) {
        for (Object child : soundCategory.getChildren()) {
            if (child instanceof SoundCategory childCategory) {
                if (childCategory.getCategoryName().equals(guiTitle)) {
                    return childCategory;
                } else {
                    SoundCategory result = findCategory(childCategory);
                    if (result != null) return result;
                }
            }
        }
        return null;
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
    }

    // Favorite Sounds Button (Nether Star)
    private final ItemStack favoriteSoundsButton = createItemStack(
            Material.NETHER_STAR,
            ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
            Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.GREEN + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ",
                    "",
                    ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ " + ChatColor.GREEN + "ꜰᴀᴠᴏʀɪᴛᴇ")
    );
}