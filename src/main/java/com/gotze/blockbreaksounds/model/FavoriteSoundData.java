package com.gotze.blockbreaksounds.model;

import com.gotze.blockbreaksounds.Main;
import com.gotze.blockbreaksounds.util.SoundUtils;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class FavoriteSoundData extends SoundData {

    public static final Map<UUID, List<SoundData>> favoriteSounds = new HashMap<>();

    public FavoriteSoundData(Sound sound, float volume, float pitch, Material displayMaterial) {
        super(sound, volume, pitch, displayMaterial);
    }

    public static void addSoundToFavorites(Player player, SoundData soundData) {
        List<SoundData> playerFavorites = favoriteSounds.getOrDefault(player.getUniqueId(), new ArrayList<>());

        if (playerFavorites.size() >= 27) return;

        for (SoundData favoriteSoundsData : playerFavorites) {
            if (favoriteSoundsData.getSound() == soundData.getSound()
                    && favoriteSoundsData.getVolume() == soundData.getVolume()
                    && favoriteSoundsData.getPitch() == soundData.getPitch()) {
                return;
            }
        }
        playerFavorites.add(soundData.copy());
        favoriteSounds.put(player.getUniqueId(), playerFavorites);
        saveFavoriteSoundsDataToYAML(player);
    }

    public static void removeSoundFromFavorites(Player player, int favoriteSoundNumber) {
        List<SoundData> playerFavorites = favoriteSounds.get(player.getUniqueId());
        SoundUtils.playErrorSound(player);
        playerFavorites.remove(favoriteSoundNumber);
        favoriteSounds.put(player.getUniqueId(), playerFavorites);
        saveFavoriteSoundsDataToYAML(player);
    }

    public static void handleFavoritedLineSound(Inventory clickedInventory, int slot, Player player) {
        final String SOUND_FAVORITED = ChatColor.GREEN + "" + ChatColor.BOLD + convertToSmallFont("sound favorited! ⭐");
        final String MAX_FAVORITED = ChatColor.RED + "" + ChatColor.BOLD + convertToSmallFont("max favorites reached!");

        ItemStack clickedItem = clickedInventory.getItem(slot);
        if (clickedItem == null || clickedItem.getType() == Material.GLASS_PANE) return;

        ItemMeta itemMeta = clickedItem.getItemMeta();
        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();
        if (lore == null) return;

        if (lore.contains(MAX_FAVORITED)) {
            SoundUtils.playErrorSound(player);

        } else if (FavoriteSoundData.favoriteSounds.get(player.getUniqueId()).size() >= 27) {
            lore.add(MAX_FAVORITED);
            SoundUtils.playErrorSound(player);

        } else if (!lore.contains(SOUND_FAVORITED)) {
            lore.add(SOUND_FAVORITED);
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5f, 1.5f);

        } else {
            return;
        }

        itemMeta.setLore(lore);
        clickedItem.setItemMeta(itemMeta);
        clickedInventory.setItem(slot, clickedItem);
    }

    private static void saveFavoriteSoundsDataToYAML(Player player) {
        File playerFile = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);
        String path = "favorite-sounds";

        List<Map<String, Object>> favoriteSoundsList = new ArrayList<>();

        List<SoundData> playerFavorites = favoriteSounds.getOrDefault(player.getUniqueId(), new ArrayList<>());

        for (SoundData favoriteSoundData : playerFavorites) {
            Map<String, Object> soundData = new LinkedHashMap<>();
            soundData.put("sound", favoriteSoundData.getSound().toString());
            soundData.put("volume", favoriteSoundData.getVolume());
            soundData.put("pitch", favoriteSoundData.getPitch());
            soundData.put("material", favoriteSoundData.getDisplayMaterial().toString());
            favoriteSoundsList.add(soundData);
        }
        yamlConfiguration.set(path, favoriteSoundsList);

        try {
            yamlConfiguration.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}