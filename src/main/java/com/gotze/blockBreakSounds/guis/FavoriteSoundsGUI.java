package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.utils.GUIUtils;
import com.gotze.blockBreakSounds.utils.ItemStackCreator;
import com.gotze.blockBreakSounds.utils.sounddata.FavoriteSoundsData;
import com.gotze.blockBreakSounds.utils.SoundMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockBreakSounds.utils.TextUtils.convertToSmallFont;

public class FavoriteSoundsGUI {

    private final Inventory gui;

    public FavoriteSoundsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "Favorite Sounds");
        setupGUI();
    }

    public void openFavoriteSoundsGUI(Player player) {
        player.openInventory(gui);
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(36, GUIUtils.ReturnButton());
        gui.setItem(40, FavoriteSoundsInfoButton());
        setFavoriteSoundsToGUI(player);
        if (gui.getItem(9) == null) {
            gui.setItem(22, NoSoundsFavoritedYetButton());
        }
    }

    private void setFavoriteSoundsToGUI(Player player) {
        Inventory inventory = player.getOpenInventory().getTopInventory();
        List<FavoriteSoundsData> favorites = FavoriteSoundsData.getFavorites(player);
        int slot = 9;
        for (int i = 0; i < favorites.size(); i++) {
            FavoriteSoundsData favoriteSoundButton = favorites.get(i);
            inventory.setItem(slot, createFavoriteSoundButton(favoriteSoundButton, i));
            slot++;
        }
        for (int i = favorites.size() + 9; i < 36; i ++) {
            inventory.setItem(i, null);
        }
    }

    private ItemStack createFavoriteSoundButton(FavoriteSoundsData favoriteSoundsData, int index) {
        return ItemStackCreator.createItemStack(
                SoundMap.getMaterialFromSound(favoriteSoundsData.getSound()),
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Favorite Sound " + (index + 1) + " ⭐",
                Arrays.asList(
                        ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(favoriteSoundsData.getSound().toString()),
                        ChatColor.WHITE + convertToSmallFont("Volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", favoriteSoundsData.getVolume() * 100)),
                        ChatColor.WHITE + convertToSmallFont("Pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", favoriteSoundsData.getPitch())),
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ",
                        "",
                        ChatColor.GREEN + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ꜰᴀᴠᴏʀɪᴛᴇᴅ! ⭐"),
                true,
                false,
                true
        );
    }

    private void setupGUI() {
        setFrames();
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
    }

    private ItemStack FavoriteSoundsInfoButton() {
        return ItemStackCreator.createItemStack(
                Material.NETHER_STAR,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(
                        ChatColor.WHITE + "ᴅʀᴏᴘ ѕᴏᴜɴᴅѕ ᴛᴏ " + ChatColor.RED + "ᴜɴꜰᴀᴠᴏʀɪᴛᴇ",
                        ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ " + ChatColor.YELLOW + "ꜰᴀᴠᴏʀɪᴛᴇ"
                )
        );
    }

    private ItemStack NoSoundsFavoritedYetButton() {
        return ItemStackCreator.createItemStack(
                Material.PAPER,
                ChatColor.WHITE + "ʏᴏᴜ ʜᴀᴠᴇ ɴᴏᴛ ꜰᴀᴠᴏʀɪᴛᴇᴅ ᴀɴʏ ѕᴏᴜɴᴅѕ ʏᴇᴛ!");
    }
}