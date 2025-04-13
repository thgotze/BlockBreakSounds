package com.gotze.blockBreakSounds.soundlogic;

import com.gotze.blockBreakSounds.Main;
import com.gotze.blockBreakSounds.utility.GUIUtils;
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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CurrentSoundData extends SoundData {

    public static final Map<UUID, SoundData> currentSound = new HashMap<>();

    public CurrentSoundData(Sound sound, float volume, float pitch, Material material) {
        super(sound, volume, pitch, material);
    }

    public static void saveCurrentSoundDataToYAML(Player player) {
        File playerFile = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
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
            yamlConfiguration.set(path + ".material", playerCurrentSound.getMaterial());
        }

        try {
            yamlConfiguration.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadCurrentSoundDataFromFile(Player player) {
        File playerFile = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);
        String path = "current-sound";

        String soundString = yamlConfiguration.getString(path + ".sound");
        if (soundString == null) {
            return;
        }

        Sound sound = Sound.valueOf(soundString);
        float volume = (float) yamlConfiguration.getDouble(path + ".volume");
        float pitch = (float) yamlConfiguration.getDouble(path + ".pitch");
        Material material = (Material) yamlConfiguration.get(path + ".material");

        currentSound.put(player.getUniqueId(), new SoundData(sound, volume, pitch, material));
    }

    public static void clearCurrentSound(Inventory gui, Player player, int slot) {
        ItemStack clickedItem = gui.getItem(slot);
        if (clickedItem == null) {
            return;
        }

        Material materialOfSound = clickedItem.getType();

        if (materialOfSound == Material.GLASS_PANE) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }

        if (materialOfSound != Material.BARRIER) {
            ItemStack confirmClearCurrentSoundItem = ItemStackCreator.createItemStack(Material.BARRIER, ChatColor.RED + "ᴅʀᴏᴘ ᴀɢᴀɪɴ ᴛᴏ ᴄʟᴇᴀʀ");
            gui.setItem(slot, confirmClearCurrentSoundItem);

            new BukkitRunnable() {
                @Override
                public void run() {
                    ItemStack itemStackAfterDelay = gui.getItem(slot);
                    if (itemStackAfterDelay == null) {
                        return;
                    }
                    if (itemStackAfterDelay.getType().equals(Material.BARRIER)) {
                        gui.setItem(slot, clickedItem);
                    }
                }
            }.runTaskLater(Main.INSTANCE, 60L);
            return;
        }

        if (materialOfSound == Material.BARRIER) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            currentSound.remove(player.getUniqueId());

            gui.setItem(slot, GUIUtils.CurrentSoundDisplayButton(player));
            saveCurrentSoundDataToYAML(player);
        }
    }
}