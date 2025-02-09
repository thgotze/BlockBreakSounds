package com.gotze.blockBreakSounds.FavoriteSoundsGUI;

import com.gotze.blockBreakSounds.Utility.SoundData.FavoriteSoundsData;
import com.gotze.blockBreakSounds.Utility.SoundMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockBreakSounds.Utility.ButtonCreator.createButton;
import static com.gotze.blockBreakSounds.Utility.CurrentSoundDisplayButton.CurrentSoundDisplayButton;
import static com.gotze.blockBreakSounds.Utility.GUIUtils.Frame;
import static com.gotze.blockBreakSounds.Utility.SmallFontConverter.convertToSmallFont;
import static com.gotze.blockBreakSounds.Utility.SmallFontConverter.removeSpecialCharacters;

public class FavoriteSoundsGUI {

    private final Inventory gui;

    public FavoriteSoundsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "Favorite Sounds");
        setupGUI();
    }

    public void openFavoriteSoundsGUI(Player player) {
        player.openInventory(gui);
        gui.setItem(4, CurrentSoundDisplayButton(player));
        gui.setItem(36, ReturnButton());
        gui.setItem(40, FavoriteSoundsInfoButton());
        addFavoriteSoundsToGUI(player);
        if (gui.getItem(9) == null) {
            gui.setItem(22, NoSoundsFavoritedYetButton());
        }
    }

    private void addFavoriteSoundsToGUI(Player player) {
        List<FavoriteSoundsData> favorites = FavoriteSoundsData.getFavorites(player);
        int slot = 9;

        for (int i = 0; i < favorites.size(); i++) {
            if (slot >= 36) break;
            FavoriteSoundsData favoriteSoundButton = favorites.get(i);
            gui.setItem(slot, createFavoriteSoundButton(favoriteSoundButton, i));
            slot++;
        }
    }

    public static ItemStack createFavoriteSoundButton(FavoriteSoundsData favoriteSoundsData, int index) {
        return createButton(
                SoundMap.getMaterialFromSound(favoriteSoundsData.getSound()),
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Favorite Sound " + (index + 1) + " ⭐",
                Arrays.asList(
                        ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(removeSpecialCharacters(favoriteSoundsData.getSound().name())),
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
            gui.setItem(i, Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, Frame());
        }
    }

    public static ItemStack FavoriteSoundsInfoButton() {
        return createButton(
                Material.NETHER_STAR,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.YELLOW + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ",
                        "",
                        ChatColor.GRAY + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ ꜰᴀᴠᴏʀɪᴛᴇ"
                )
        );
    }

    public static ItemStack ReturnButton() {
        return createButton(
                Material.ARROW,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "← ʀᴇᴛᴜʀɴ"
        );
    }

    public static ItemStack NoSoundsFavoritedYetButton() {
        return createButton(
                Material.PAPER,
                ChatColor.WHITE + "You have not favorited any sounds yet!");
    }

}
