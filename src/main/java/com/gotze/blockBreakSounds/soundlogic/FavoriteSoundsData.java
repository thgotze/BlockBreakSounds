package com.gotze.blockBreakSounds.soundlogic;

import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.Main;
import com.gotze.blockBreakSounds.utility.ItemStackCreator;
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
        String path = "favorite-sounds";
        player.sendMessage("GGG");
        List<Map<String, Object>> favoriteSoundsList = new ArrayList<>();

        List<FavoriteSoundsData> favorites = favoriteSounds.getOrDefault(player.getUniqueId(), new ArrayList<>());

        for (FavoriteSoundsData favoriteSoundData : favorites) {
            Map<String, Object> soundData = new LinkedHashMap<>();
            soundData.put("sound", favoriteSoundData.getSound().toString());
            soundData.put("volume", favoriteSoundData.getVolume());
            soundData.put("pitch", favoriteSoundData.getPitch());
            favoriteSoundsList.add(soundData);
        }
        player.sendMessage("HHH");
        yamlConfiguration.set(path, favoriteSoundsList);

        try {
            yamlConfiguration.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFavoriteSoundsDataFromFile(Player player) {
        File file = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        String path = "favorite-sounds";

        List<Map<?, ?>> favoriteSoundsList = yamlConfiguration.getMapList(path);

        if (favoriteSoundsList.isEmpty()) {
            return;
        }
        List<FavoriteSoundsData> favoriteSoundsDataList = new ArrayList<>();

        for (Map<?, ?> soundData : favoriteSoundsList) {
            try {
                Sound sound = Sound.valueOf((String) soundData.get("sound"));
                float volume = ((Number) soundData.get("volume")).floatValue();
                float pitch = ((Number) soundData.get("pitch")).floatValue();
                favoriteSoundsDataList.add(new FavoriteSoundsData(sound, volume, pitch));
            } catch (Exception e) {
                System.out.println("Failed to load a favorite sound for " + player.getName());
            }
        }
        favoriteSounds.put(player.getUniqueId(), favoriteSoundsDataList);
    }


    public static void addFavoriteSound(Player player, Sound sound, float volume, float pitch) {
        List<FavoriteSoundsData> favorites = favoriteSounds.get(player.getUniqueId());
        player.sendMessage("RRRRR");
        for (FavoriteSoundsData data : favorites) {
            player.sendMessage("CCC");
            if (data.getSound() == sound && data.getVolume() == volume && data.getPitch() == pitch) {
                player.sendMessage("sfdasgf");
                return;
            }
        }

        player.sendMessage("DDD");

        if (favorites.size() < 27) { // You can only have 27 favorite sounds
            player.sendMessage("SDADADA");
            favorites.add(new FavoriteSoundsData(sound, volume, pitch));
            player.sendMessage("EEE");
        }


        player.sendMessage("poooloo");
        favoriteSounds.put(player.getUniqueId(), favorites);
        saveFavoriteSoundsDataToYAML(player);
    }

    public static void removeFavoriteSound(Inventory inventory, Player player, int slot) {
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
            favoriteSounds.put(player.getUniqueId(), favorites);

            new FavoriteSoundsGUI().setupAndOpenGUI(player);
            saveFavoriteSoundsDataToYAML(player);
            return;
        }

        ItemStack confirmClearFavoriteSound = ItemStackCreator.createItemStack(Material.BARRIER, ChatColor.RED + "ᴅʀᴏᴘ ᴀɢᴀɪɴ ᴛᴏ ᴜɴꜰᴀᴠᴏʀɪᴛᴇ");
        inventory.setItem(slot, confirmClearFavoriteSound);

        new BukkitRunnable() {
            @Override
            public void run() {
                ItemStack itemAfterDelay = inventory.getItem(slot);
                if (itemAfterDelay == null) {
                    return;
                }
                if (itemAfterDelay.getType() == confirmClearFavoriteSound.getType()) {
                    inventory.setItem(slot, originalSlotItem);
                }
            }
        }.runTaskLater(Main.INSTANCE, 60L);
    }
}