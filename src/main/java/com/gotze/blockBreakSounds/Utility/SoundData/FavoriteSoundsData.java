package com.gotze.blockBreakSounds.Utility.SoundData;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

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
                player.sendMessage("Sound already favorited!!!");
                return;
            }
        }
        if (favorites.size() < 27) {
            favorites.add(new FavoriteSoundsData(sound, volume, pitch));
            player.sendMessage("You have added " + sound.name() + " to your favorites!");
        } else {
            player.sendMessage("You have reached the maximum of 27 favorite sounds!");
        }
    }

    public static void removeFavoriteSound(Player player, int slot) {
        List<FavoriteSoundsData> favorites = favoriteSounds.get(player.getUniqueId());
        int listIndex = slot - 9;

        if (favorites != null && listIndex >= 0 && listIndex < favorites.size()) {
            favorites.remove(listIndex);
            player.sendMessage("You have removed a favorite sound from your list.");
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
