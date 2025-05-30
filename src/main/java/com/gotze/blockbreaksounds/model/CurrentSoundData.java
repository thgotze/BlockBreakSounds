package com.gotze.blockbreaksounds.model;

import com.gotze.blockbreaksounds.BlockBreakSoundsPlugin;
import com.gotze.blockbreaksounds.util.GUIUtils;
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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;

public class CurrentSoundData extends SoundData {

    public static final Map<UUID, SoundData> currentSound = new HashMap<>();

    public CurrentSoundData(Sound sound, float volume, float pitch, Material material) {
        super(sound, volume, pitch, material);
    }

    public static void setCurrentSound(Player player, SoundData soundData) {
        player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
        currentSound.put(player.getUniqueId(), soundData);
        saveCurrentSoundDataToYAML(player);
    }

    public static void clearCurrentSound(Inventory gui, Player player, int slot) {
        ItemStack clickedItem = gui.getItem(slot);
        if (clickedItem == null) return;

        Material materialOfSound = clickedItem.getType();

        if (materialOfSound == Material.GLASS_PANE) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }

        if (materialOfSound != Material.BARRIER) {
            ItemStack confirmClearCurrentSoundItem = createItemStack(Material.BARRIER, ChatColor.RED + "ᴅʀᴏᴘ ᴀɢᴀɪɴ ᴛᴏ ᴄʟᴇᴀʀ");
            gui.setItem(slot, confirmClearCurrentSoundItem);

            new BukkitRunnable() {
                @Override
                public void run() {
                    ItemStack itemStackAfterDelay = gui.getItem(slot);
                    if (itemStackAfterDelay == null) return;

                    if (itemStackAfterDelay.getType().equals(Material.BARRIER)) {
                        gui.setItem(slot, clickedItem);
                    }
                }
            }.runTaskLater(BlockBreakSoundsPlugin.INSTANCE, 60L);
            return;
        }

        if (materialOfSound == Material.BARRIER) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            currentSound.remove(player.getUniqueId());
            gui.setItem(slot, GUIUtils.CurrentSoundDisplayButton(player));
            saveCurrentSoundDataToYAML(player);
        }
    }

    public static void saveCurrentSoundDataToYAML(Player player) {
        File playerFile = new File(BlockBreakSoundsPlugin.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);
        String path = "current-sound";

        SoundData playerCurrentSound = currentSound.get(player.getUniqueId());

        if (playerCurrentSound == null) {
            yamlConfiguration.set(path + ".sound", null);
            yamlConfiguration.set(path + ".volume", null);
            yamlConfiguration.set(path + ".pitch", null);
            yamlConfiguration.set(path + ".material", null);
        } else {
            yamlConfiguration.set(path + ".sound", playerCurrentSound.getSound().toString());
            yamlConfiguration.set(path + ".volume", playerCurrentSound.getVolume());
            yamlConfiguration.set(path + ".pitch", playerCurrentSound.getPitch());
            yamlConfiguration.set(path + ".material", playerCurrentSound.getDisplayMaterial().toString());
        }

        try {
            yamlConfiguration.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadCurrentSoundDataFromFile(Player player) {
        File playerFile = new File(BlockBreakSoundsPlugin.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);
        String path = "current-sound";

        try {
            Sound sound = Sound.valueOf(yamlConfiguration.getString(path + ".sound"));
            float volume = (float) yamlConfiguration.getDouble(path + ".volume");
            float pitch = (float) yamlConfiguration.getDouble(path + ".pitch");
            Material material = Material.valueOf(yamlConfiguration.getString(path + ".material"));

            currentSound.put(player.getUniqueId(), new SoundData(sound, volume, pitch, material));
        } catch (Exception e) {
            System.out.println("Failed to load current sound for " + player.getName() + e.getMessage());
        }
    }
}