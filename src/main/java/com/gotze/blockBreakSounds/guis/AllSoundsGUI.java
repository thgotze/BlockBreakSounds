package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundMap;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;

public class AllSoundsGUI {

    private final Inventory gui;
    private final String guiTitle;

    public AllSoundsGUI(String guiTitle) {
        this.gui = Bukkit.createInventory(null, 45, guiTitle);
        this.guiTitle = guiTitle;
        setFrames();
        gui.setItem(36, GUIUtils.ReturnButton());
        gui.setItem(40, FavoriteSoundsButton());
    }

    public void setupAndOpenGUI(Player player) {
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        setCategoryOrSoundButtons();
        player.openInventory(gui);
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
    }

    private void setCategoryOrSoundButtons() {
        int slot = 9; // Starting slot where to put buttons

        switch (guiTitle) {
            case "All Sounds":
                gui.setItem(20, EntitySoundsButton());
                gui.setItem(21, BlockSoundsButton());
                gui.setItem(22, ItemSoundsButton());
                gui.setItem(23, NoteblockSoundsButton());
                gui.setItem(24, OtherSoundsButton());
                return;

            case "Entity Sounds":
                for (Map.Entry<ItemStack, Map<ItemStack, List<SoundData>>> subEntry : SoundMap.ENTITY_SOUNDS.entrySet()) {
                    gui.setItem(slot++, subEntry.getKey());
                }
                return;

            case "Block Sounds":
                return;

            case "Item Sounds":
                for (Map.Entry<ItemStack, List<SoundData>> subEntry : SoundMap.ITEM_SOUNDS.entrySet()) {
                    gui.setItem(slot++, subEntry.getKey());
                }
                return;

            case "Noteblock Sounds":
                for (SoundData soundData : SoundMap.NOTEBLOCK_SOUNDS) {
                    gui.setItem(slot++, createItemStack(soundData.getMaterial()));
                }
                return;

            case "Other Sounds":
                for (Map.Entry<ItemStack, List<SoundData>> subEntry : SoundMap.OTHER_SOUNDS.entrySet()) {
                    gui.setItem(slot++, subEntry.getKey());
                }
                return;

            default: // any subcategory like "Trident Sounds", "Goat Horn Sounds", etc.
                for (Map.Entry<ItemStack, List<SoundData>> subEntry : SoundMap.ITEM_SOUNDS.entrySet()) {
                    String displayName = subEntry.getKey().getItemMeta().getDisplayName();
                    if (displayName.equals(guiTitle)) { // if the item's name matches the guiTitle (example: "Trident Sounds")
                        for (SoundData soundData : subEntry.getValue()) {
                            gui.setItem(slot++, createItemStack(soundData.getMaterial()));
                        }
                        return;
                    }
                }
                return;
        }
    }

    // Entity Sounds Button (Ender Pearl)
    private ItemStack EntitySoundsButton() {
        return createItemStack(
                Material.ENDER_PEARL,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Entity Sounds"
        );
    }

    // Block Sounds Button (Grass Block)
    private ItemStack BlockSoundsButton() {
        return createItemStack(
                Material.GRASS_BLOCK,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Block Sounds"
        );
    }

    // Item Sounds Button (Diamond Pickaxe)
    private ItemStack ItemSoundsButton() {
        return createItemStack(
                Material.DIAMOND_AXE,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Item Sounds",
                null,
                true,
                true
        );
    }

    // Noteblock Sounds Button (Note Block)
    private ItemStack NoteblockSoundsButton() {
        return createItemStack(
                Material.NOTE_BLOCK,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Noteblock Sounds"
        );
    }

    // Other Sounds Button (Pufferfish)
    private ItemStack OtherSoundsButton() {
        return createItemStack(
                Material.PUFFERFISH,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Other Sounds"
        );
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