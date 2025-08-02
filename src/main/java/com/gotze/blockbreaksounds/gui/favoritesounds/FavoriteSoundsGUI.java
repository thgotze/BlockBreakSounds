package com.gotze.blockbreaksounds.gui.favoritesounds;

import com.gotze.blockbreaksounds.model.FavoriteSoundData;
import com.gotze.blockbreaksounds.model.SoundData;
import com.gotze.blockbreaksounds.util.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public final class FavoriteSoundsGUI implements InventoryHolder {

    private final Inventory gui;

    @Override
    public @NotNull Inventory getInventory() {
        return gui;
    }

    public FavoriteSoundsGUI(Player player) {
        this.gui = Bukkit.createInventory(this, 45, "Favorite Sounds");
        setFrames();
        setFavoriteSoundsToGUI(player);
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(36, GUIUtils.RETURN_BUTTON);
        gui.setItem(40, FavoriteSoundsButton);
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

    private void setFavoriteSoundsToGUI(Player player) {
        List<SoundData> playerFavorites = FavoriteSoundData.favoriteSounds.computeIfAbsent(player.getUniqueId(), k -> new ArrayList<>());
        int slot = 9;
        for (int i = 0; i < playerFavorites.size(); i++) {
            SoundData favoriteSoundData = playerFavorites.get(i);
            gui.setItem(slot, createFavoriteSoundButton(favoriteSoundData, i + 1));
            slot++;
        }
        for (int i = playerFavorites.size() + 9; i < 36; i++) {
            gui.clear(i);
        }
        if (gui.getItem(9) == null) {
            gui.setItem(22, NoSoundsFavoritedYetButton);
        }
    }

    private ItemStack createFavoriteSoundButton(SoundData soundData, int soundNumber) {
        return createItemStack(
                soundData.getDisplayMaterial(),
                ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sound " + soundNumber + " ⭐",
                Arrays.asList(
                        ChatColor.WHITE + convertToSmallFont("sound: ") + ChatColor.GRAY + convertToSmallFont(soundData.getFormattedSoundName()),
                        ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", soundData.getVolume() * 100)),
                        ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", soundData.getPitch())),
                        "",
                        ChatColor.YELLOW + convertToSmallFont("click to pick sound"),
                        ChatColor.GREEN + "" + ChatColor.BOLD + convertToSmallFont("sound favorited! ⭐")),
                true,
                true,
                false
        );
    }

    private final ItemStack NoSoundsFavoritedYetButton = createItemStack(
            Material.PAPER,
            ChatColor.WHITE + convertToSmallFont("You have not favorited any sounds yet!")
    );

    // Favorite Sounds Button (Nether Star)
    private final ItemStack FavoriteSoundsButton = createItemStack(
            Material.NETHER_STAR,
            ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("pick from your ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorited ") + ChatColor.WHITE + convertToSmallFont("sounds"),
                    "",
                    ChatColor.WHITE + convertToSmallFont("drop sounds to ") + ChatColor.RED + ChatColor.BOLD + convertToSmallFont("unfavorite"),
                    ChatColor.WHITE + convertToSmallFont("shift right click sounds to ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorite")
            )
    );
}