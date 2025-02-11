package com.gotze.blockBreakSounds.Utility.SoundData;

import com.gotze.blockBreakSounds.FavoriteSoundsGUI.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.Main;
import com.gotze.blockBreakSounds.Utility.ButtonCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class FavoriteSoundsData {

    private Sound sound;
    private float volume;
    private float pitch;
    private boolean favorited;

    public static final Map<UUID, List<FavoriteSoundsData>> favoriteSounds = new HashMap<>();

    public FavoriteSoundsData(Sound sound, float volume, float pitch) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
        this.favorited = true;
    }

    public Sound getSound() {
        return sound;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void toggleFavorite() {
        this.favorited = !this.favorited;
    }

    public static void addFavoriteSound(Player player, Sound sound, float volume, float pitch) {
        List<FavoriteSoundsData> favorites = favoriteSounds.computeIfAbsent(player.getUniqueId(), k -> new ArrayList<>());

        for (FavoriteSoundsData data : favorites) {
            if (data.getSound() == sound && data.getVolume() == volume && data.getPitch() == pitch) {
                return;
            }
        }
        if (favorites.size() < 27) {
            favorites.add(new FavoriteSoundsData(sound, volume, pitch));
        } else {
            return;
        }
    }

    public static void clearFavoriteSound(Inventory inventory, Player player, int slot) {
        ItemStack originalSlotItem = inventory.getItem(slot);

        if (originalSlotItem == null) {
            return;
        }

        if (originalSlotItem.getType() == Material.BARRIER) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            inventory.setItem(slot, null);

            List<FavoriteSoundsData> favorites = favoriteSounds.get(player.getUniqueId());
            int listIndex = slot - 9;
            favorites.remove(listIndex);

            FavoriteSoundsGUI favoriteSoundsGUI = new FavoriteSoundsGUI();
            favoriteSoundsGUI.setFavoriteSoundsToGUI(player);

        } else {
            ItemStack confirmClearFavoriteSound = ButtonCreator.createButton(Material.BARRIER,  ChatColor.RED + "ᴅʀᴏᴘ ᴀɢᴀɪɴ ᴛᴏ ᴜɴꜰᴀᴠᴏʀɪᴛᴇ");

            inventory.setItem(slot, confirmClearFavoriteSound);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (inventory.getItem(slot).getType() == confirmClearFavoriteSound.getType()) {
                        inventory.setItem(slot, originalSlotItem);
                    }
                }
            }.runTaskLater(Main.INSTANCE, 60L);
        }
    }

    public static List<FavoriteSoundsData> getFavorites(Player player) {
        return favoriteSounds.getOrDefault(player.getUniqueId(), new ArrayList<>());
    }

    public static FavoriteSoundsData getFavoriteSoundFromSlot(Player player, int slot) {
        List<FavoriteSoundsData> favorites = favoriteSounds.get(player.getUniqueId());

        if (favorites != null && slot >= 9 && slot <= 35) {
            int index = slot - 9; // Adjust for zero-indexing (slot 9 maps to index 0)

            if (index < favorites.size()) {
                return favorites.get(index);
            }
        }
        return null;
    }
}
