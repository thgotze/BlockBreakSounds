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
        gui.setItem(40, FavoriteSoundsButton());
        player.openInventory(gui);
    }

    private void setCategoryOrSoundButtons() {
        int slot = 20; // Starting slot to set items
        if (guiTitle.equals("All Sounds")) {
            for (SoundCategory soundCategory : AllSoundsRegistry.CATEGORIES) {
                gui.setItem(slot++, createItemStack(soundCategory.getDisplayMaterial(), soundCategory.getCategoryName()));
            }
            return;
        }

        // TODO: Make it a method so it goes through the same code no matter if its child or grandchild
        slot = 9; // Starting slot to set items
        for (SoundCategory soundCategory : AllSoundsRegistry.CATEGORIES) {
            if (soundCategory.getCategoryName().equals(guiTitle)) {
                for (Object child : soundCategory.getChildren()) {
                    if (child instanceof SoundCategory) {
                        gui.setItem(slot++, createItemStack(
                                ((SoundCategory) child).getDisplayMaterial(),
                                ChatColor.AQUA + "" + ChatColor.BOLD + ((SoundCategory) child).getCategoryName()));
                        // TODO: Add lore "click to go down a category?"
                    } else if (child instanceof SoundData) {
                        gui.setItem(slot++, createItemStack(
                                ((SoundData) child).getDisplayMaterial(),
                                ChatColor.AQUA + "" + ChatColor.BOLD + StringUtils.getFormattedSoundName(((SoundData) child).getSound()),
                                Arrays.asList(
                                        "",
                                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
                        ));
                    }
                }
                return;
            } else {
                for (Object grandChild : soundCategory.getChildren()) {
                    if (grandChild instanceof SoundCategory) {
                        if (((SoundCategory) grandChild).getCategoryName().equals(guiTitle)) {
                            for (Object grandGrandChild : ((SoundCategory) grandChild).getChildren()) {
                                if (grandGrandChild instanceof SoundCategory) {
                                    gui.setItem(slot++, createItemStack(
                                            ((SoundCategory) grandGrandChild).getDisplayMaterial(),
                                            ChatColor.AQUA + "" + ChatColor.BOLD + ((SoundCategory) grandGrandChild).getCategoryName()));
                                } else if (grandGrandChild instanceof SoundData) {
                                    gui.setItem(slot++, createItemStack(
                                            ((SoundData) grandGrandChild).getDisplayMaterial(),
                                            ChatColor.AQUA + "" + ChatColor.BOLD + StringUtils.getFormattedSoundName(((SoundData) grandGrandChild).getSound()),
                                            Arrays.asList(
                                                    "",
                                                    ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
                                    ));
                                }
                            }
                        }
                    }
                }
            }
        }
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
    private ItemStack FavoriteSoundsButton() {
        return createItemStack(
                Material.NETHER_STAR,
                ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.GREEN + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ",
                        "",
                        ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ " + ChatColor.GREEN + "ꜰᴀᴠᴏʀɪᴛᴇ")
        );
    }
}