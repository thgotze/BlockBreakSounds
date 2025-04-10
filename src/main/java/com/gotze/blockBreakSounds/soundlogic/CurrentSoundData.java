package com.gotze.blockBreakSounds.soundlogic;

import com.gotze.blockBreakSounds.Main;
import com.gotze.blockBreakSounds.utility.ItemStackCreator;
import com.gotze.blockBreakSounds.utility.GUIUtils;
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

public class CurrentSoundData {
    private final Player player;
    private Sound sound;
    private float volume;
    private float pitch;

    public static final Map<UUID, CurrentSoundData> currentSound = new HashMap<>();

    public CurrentSoundData(Player player, Sound sound, float volume, float pitch) {
        this.player = player;
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;
        saveCurrentSoundDataToYAML(player);
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
        saveCurrentSoundDataToYAML(player);
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
        saveCurrentSoundDataToYAML(player);
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
        saveCurrentSoundDataToYAML(player);
    }

    public void saveCurrentSoundDataToYAML(Player player) {
        File playerFile = new File(Main.INSTANCE.getDataFolder() + "/playerdata", player.getUniqueId() + ".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(playerFile);
        String path = "current-sound";

        if (sound == null) {
            yamlConfiguration.set(path + ".sound", null);
            yamlConfiguration.set(path + ".volume", null);
            yamlConfiguration.set(path + ".pitch", null);
        } else {
            yamlConfiguration.set(path + ".sound", sound.toString());
            yamlConfiguration.set(path + ".volume", volume);
            yamlConfiguration.set(path + ".pitch", pitch);
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

        currentSound.put(player.getUniqueId(), new CurrentSoundData(player, sound, volume, pitch));
    }

    public static void clearCurrentSound(Inventory clickedInventory, Player player, int slot) {
        ItemStack originalSlotItem = clickedInventory.getItem(slot);

        if (originalSlotItem == null) {
            return;
        }

        if (originalSlotItem.getType() == Material.GLASS_PANE) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            return;
        }

        if (originalSlotItem.getType() == Material.BARRIER) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);

            currentSound.remove(player.getUniqueId());
            CurrentSoundData currentSoundData = new CurrentSoundData(player, null, 0.0f, 0.0f);
            currentSoundData.saveCurrentSoundDataToYAML(player);

            clickedInventory.setItem(slot, GUIUtils.CurrentSoundDisplayButton(player));

            if (slot == 13) {
                for (int i = 0; i < 9; i++) {
                    clickedInventory.setItem(36 + i, GUIUtils.Frame());
                }
                clickedInventory.setItem(9, null);
                clickedInventory.setItem(17, null);
                clickedInventory.setItem(27, null);
                clickedInventory.setItem(35, null);
            }
            return;
        }

        ItemStack confirmClearCurrentSound = ItemStackCreator.createItemStack(Material.BARRIER, ChatColor.RED + "ᴅʀᴏᴘ ᴀɢᴀɪɴ ᴛᴏ ᴄʟᴇᴀʀ");
        clickedInventory.setItem(slot, confirmClearCurrentSound);

        new BukkitRunnable() {
            @Override
            public void run() {
                ItemStack itemAfterDelay = clickedInventory.getItem(slot);
                if (itemAfterDelay == null) {
                    return;
                }
                if (itemAfterDelay.getType() == confirmClearCurrentSound.getType()) {
                    clickedInventory.setItem(slot, originalSlotItem);
                }
            }
        }.runTaskLater(Main.INSTANCE, 60L);
    }
}