package com.gotze.blockBreakSounds.Utility.SoundData;

import com.gotze.blockBreakSounds.FavoriteSoundsGUI.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.Main;
import com.gotze.blockBreakSounds.Utility.ButtonCreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class FavoriteSoundsData {
    private final Sound sound;
    private final float volume;
    private final float pitch;

    public static final Map<UUID, List<FavoriteSoundsData>> favoriteSounds = new HashMap<>();

    public FavoriteSoundsData(Sound sound, float volume, float pitch) {
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
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

    public static void saveFavoriteSoundsDataToYAML(Player player) {
        File playerFile = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);

        String currentSoundPath = "current-sound";
        if (CurrentSoundData.currentSound.get(player.getUniqueId()) == null) {
            yamlConfiguration.set(currentSoundPath, new HashMap<>());
        }

        String favoriteSoundsPath = "favorite-sounds";
        if (favoriteSounds.isEmpty()) {
            yamlConfiguration.set(favoriteSoundsPath, new ArrayList<>());
        } else {
            List<Map<String, Object>> soundList = new ArrayList<>();

            List<FavoriteSoundsData> favorites = favoriteSounds.getOrDefault(player.getUniqueId(), new ArrayList<>());

            for (FavoriteSoundsData data : favorites) {
                Map<String, Object> soundData = new HashMap<>();
                soundData.put("sound", data.getSound().toString());
                soundData.put("volume", data.getVolume());
                soundData.put("pitch", data.getPitch());
                soundList.add(soundData);
            }
            yamlConfiguration.set(favoriteSoundsPath, soundList);
        }

        try {
            yamlConfiguration.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFavoriteSoundsDataFromYAML(Player player) {
        File file = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        String path = "favorite-sounds";

        if (!yamlConfiguration.contains(path)) {
            return;
        }
        List<FavoriteSoundsData> favorites = new ArrayList<>();
        List<Map<?, ?>> soundList = yamlConfiguration.getMapList(path);

        for (Map<?, ?> soundData : soundList) {
            try {
                Sound sound = Sound.valueOf((String) soundData.get("sound"));
                float volume = ((Number) soundData.get("volume")).floatValue();
                float pitch = ((Number) soundData.get("pitch")).floatValue();
                favorites.add(new FavoriteSoundsData(sound, volume, pitch));
            } catch (Exception e) {
                System.out.println("Failed to load a favorite sound for " + player.getName());
            }
        }
        favoriteSounds.put(player.getUniqueId(), favorites);
    }


    public static void addFavoriteSound(Player player, Sound sound, float volume, float pitch) {
        List<FavoriteSoundsData> favorites = favoriteSounds.get(player.getUniqueId());

        if (favorites == null) {
            favorites = new ArrayList<>();
            favoriteSounds.put(player.getUniqueId(), favorites);
        }

        for (FavoriteSoundsData data : favorites) {
            if (data.getSound() == sound && data.getVolume() == volume && data.getPitch() == pitch) {
                return;
            }
        }
        if (favorites.size() < 27) { // You can only have 27 favorite sounds
            favorites.add(new FavoriteSoundsData(sound, volume, pitch));
            saveFavoriteSoundsDataToYAML(player);
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
            saveFavoriteSoundsDataToYAML(player);

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

        int index = slot - 9; // Adjust for zero-indexing (slot 9 maps to index 0)
        if (index < favorites.size()) {
            return favorites.get(index);
        }
        return null;
    }
}
