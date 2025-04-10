package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.ItemStackCreator;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundsData;
import com.gotze.blockBreakSounds.soundlogic.SoundMap;
import com.gotze.blockBreakSounds.utility.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gotze.blockBreakSounds.utility.TextUtils.convertToSmallFont;

public class FavoriteSoundsGUI {

    private final Inventory gui;

    public FavoriteSoundsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "Favorite Sounds");
        setFrames();
        gui.setItem(36, GUIUtils.ReturnButton());
        gui.setItem(40, FavoriteSoundsInfoButton());
    }

    public void setupAndOpenGUI(Player player) {
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        setFavoriteSoundsToGUI(player);
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

    private ItemStack FavoriteSoundsInfoButton() {
        return ItemStackCreator.createItemStack(
                Material.NETHER_STAR,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(
                        ChatColor.WHITE + "ᴅʀᴏᴘ ѕᴏᴜɴᴅѕ ᴛᴏ " + ChatColor.RED + "ᴜɴꜰᴀᴠᴏʀɪᴛᴇ",
                        ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ " + ChatColor.GREEN + "ꜰᴀᴠᴏʀɪᴛᴇ"
                )
        );
    }

    private void setFavoriteSoundsToGUI(Player player) {
        List<FavoriteSoundsData> favorites = FavoriteSoundsData.favoriteSounds.computeIfAbsent(player.getUniqueId(), k -> new ArrayList<>());
        player.sendMessage("hghfaaaaaaaaafdaf");
        int slot = 9;
        for (int i = 0; i < favorites.size(); i++) {
            FavoriteSoundsData favoriteSoundsData = favorites.get(i);
            player.sendMessage("dsgfagfdsagsagdgaggg");
            gui.setItem(slot, createFavoriteSoundButton(favoriteSoundsData, i));
            slot++;
        }
        player.sendMessage("76767");
        for (int i = favorites.size() + 9; i < 36; i ++) {
            gui.clear(i);
            player.sendMessage("1231321321");
        }
        if (gui.getItem(9) == null) {
            player.sendMessage("khkhkhkhkh");
            gui.setItem(22, NoSoundsFavoritedYetButton());
        }
    }

    private ItemStack createFavoriteSoundButton(FavoriteSoundsData favoriteSoundsData, int index) {
        return ItemStackCreator.createItemStack(
                SoundMap.getMaterialFromSound(favoriteSoundsData.getSound()),
                ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sound " + (index + 1) + " ⭐",
                Arrays.asList(
                        ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(TextUtils.getFormattedSoundName(favoriteSoundsData.getSound())),
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

    private ItemStack NoSoundsFavoritedYetButton() {
        return ItemStackCreator.createItemStack(
                Material.PAPER,
                ChatColor.WHITE + "ʏᴏᴜ ʜᴀᴠᴇ ɴᴏᴛ ꜰᴀᴠᴏʀɪᴛᴇᴅ ᴀɴʏ ѕᴏᴜɴᴅѕ ʏᴇᴛ!");
    }
}