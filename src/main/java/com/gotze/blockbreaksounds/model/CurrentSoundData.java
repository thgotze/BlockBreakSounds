package com.gotze.blockbreaksounds.model;

import com.gotze.blockbreaksounds.Main;
import com.gotze.blockbreaksounds.util.SoundUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class CurrentSoundData extends SoundData {

    public static final Map<UUID, SoundData> currentSound = new HashMap<>();

    private CurrentSoundData(Sound sound, float volume, float pitch, Material displayMaterial) {
        super(sound, volume, pitch, displayMaterial);
    }

    public static void setCurrentSound(Player player, SoundData soundData) {
        soundData.playSoundData(player);
        currentSound.put(player.getUniqueId(), soundData);
        saveCurrentSoundDataToYAML(player);
    }

    private static void clearCurrentSound(ItemStack clickedItem, Inventory gui, Player player, int slot) {
        Material materialOfCurrentSound = clickedItem.getType();

        switch (materialOfCurrentSound) {
            case GLASS_PANE:
                SoundUtils.playErrorSound(player);
                return;

            case BARRIER:
                SoundUtils.playErrorSound(player);
                CurrentSoundData.currentSound.remove(player.getUniqueId());
                gui.setItem(slot, createCurrentSoundButton(player));
                CurrentSoundData.saveCurrentSoundDataToYAML(player);
                return;

            default:
                final ItemStack confirmClearCurrentSoundItem = createItemStack(
                        Material.BARRIER,
                        ChatColor.RED + convertToSmallFont("drop again to clear")
                );
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
                }.runTaskLater(Main.INSTANCE, 60L);
        }
    }

    public static ItemStack createCurrentSoundButton(Player player) {
        SoundData playerCurrentSound = currentSound.get(player.getUniqueId());
        if (playerCurrentSound == null) {
            return createItemStack(
                    Material.GLASS_PANE,
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    List.of(
                            ChatColor.WHITE + convertToSmallFont("no sound set")
                    )
            );
        } else {
            return createItemStack(
                    (playerCurrentSound.getDisplayMaterial()),
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    Arrays.asList(
                            ChatColor.WHITE + convertToSmallFont("sound: ") + ChatColor.GRAY + convertToSmallFont(playerCurrentSound.getFormattedSoundName()),
                            ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", playerCurrentSound.getVolume() * 100)),
                            ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", playerCurrentSound.getPitch())),
                            "",
                            ChatColor.WHITE + convertToSmallFont("click to ") + ChatColor.YELLOW + ChatColor.BOLD + convertToSmallFont("playtest"),
                            ChatColor.WHITE + convertToSmallFont("drop item to ") + ChatColor.RED + ChatColor.BOLD + convertToSmallFont("clear"),
                            ChatColor.WHITE + convertToSmallFont("shift right click to ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorite")
                    ),
                    true,
                    true,
                    false
            );
        }
    }

    public static void currentSoundButtonHandler(Inventory clickedInventory, ClickType clickType, Player player, int slot) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) return;

        ItemStack clickedItem = clickedInventory.getItem(slot);
        if (clickedItem == null) return;

        if (clickType == ClickType.DROP) {
            clearCurrentSound(clickedItem, clickedInventory, player, slot);
            return;
        }

        if (clickType == ClickType.SHIFT_RIGHT) {
            FavoriteSoundData.addSoundToFavorites(player, currentSoundData);
            FavoriteSoundData.handleFavoritedLineSound(clickedInventory, slot, player);
            return;
        }

        if (clickedItem.getType() == Material.BARRIER) return;

        currentSoundData.playSoundData(player);
    }

    public static void increaseVolume(Player player) {
        SoundData currentSoundData = currentSound.get(player.getUniqueId());
        if (currentSoundData == null) {
            SoundUtils.playErrorSound(player);
            return;
        }
        currentSoundData.setVolume(Math.round((currentSoundData.getVolume() + 0.05f) * 100f) / 100f);
        currentSoundData.playSoundData(player);
        currentSound.put(player.getUniqueId(), currentSoundData);
        saveCurrentSoundDataToYAML(player);
    }

    public static void decreaseVolume(Player player) {
        SoundData currentSoundData = currentSound.get(player.getUniqueId());
        if (currentSoundData == null || currentSoundData.getVolume() == 0.00f) {
            SoundUtils.playErrorSound(player);
            return;
        }

        if (currentSoundData.getVolume() == 0.05f ) {
            SoundUtils.playErrorSound(player);
        }

        currentSoundData.setVolume(Math.round((currentSoundData.getVolume() - 0.05f) * 100f) / 100f);
        currentSoundData.playSoundData(player);
        currentSound.put(player.getUniqueId(), currentSoundData);
        saveCurrentSoundDataToYAML(player);
    }

    public static void increasePitch(Player player) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) {
            SoundUtils.playErrorSound(player);
            return;
        }

        currentSoundData.setPitch(Math.round((currentSoundData.getPitch() + 0.05f) * 100f) / 100f);
        currentSoundData.playSoundData(player);
        currentSound.put(player.getUniqueId(), currentSoundData);
        saveCurrentSoundDataToYAML(player);
    }

    public static void decreasePitch(Player player) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null || currentSoundData.getPitch() == 0.50f) {
            SoundUtils.playErrorSound(player);
            return;
        }

        currentSoundData.setPitch(Math.round((currentSoundData.getPitch() - 0.05f) * 100f) / 100f);
        currentSoundData.playSoundData(player);
        currentSound.put(player.getUniqueId(), currentSoundData);
        saveCurrentSoundDataToYAML(player);
    }

    private static void saveCurrentSoundDataToYAML(Player player) {
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
            yamlConfiguration.set(path + ".material", playerCurrentSound.getDisplayMaterial().toString());
        }

        try {
            yamlConfiguration.save(playerFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}