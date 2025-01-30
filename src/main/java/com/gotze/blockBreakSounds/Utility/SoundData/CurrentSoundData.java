package com.gotze.blockBreakSounds.Utility.SoundData;

import com.gotze.blockBreakSounds.Main;
import com.gotze.blockBreakSounds.Utility.ButtonCreator;
import com.gotze.blockBreakSounds.Utility.CurrentSoundDisplayButton;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.gotze.blockBreakSounds.Utility.GUIUtils.Frame;

public class CurrentSoundData {
    private Sound sound;
    private float volume;
    private float pitch;
    private Player player;

    public static final Map<UUID, CurrentSoundData> playerSounds = new HashMap<>();

    public CurrentSoundData(Player player, Sound sound, float volume, float pitch) {
        this.player = player;
        this.sound = sound;
        this.volume = volume;
        this.pitch = pitch;

        player.getPersistentDataContainer().set(new NamespacedKey(Main.INSTANCE, "sound"), PersistentDataType.STRING, sound.toString());
        player.getPersistentDataContainer().set(new NamespacedKey(Main.INSTANCE, "volume"), PersistentDataType.FLOAT, volume);
        player.getPersistentDataContainer().set(new NamespacedKey(Main.INSTANCE, "pitch"), PersistentDataType.FLOAT, pitch);
    }

    public Sound getSound() {
        return sound;
    }
    public void setSound(Sound sound) {
        this.sound = sound;
        player.getPersistentDataContainer().set(new NamespacedKey(Main.INSTANCE, "sound"), PersistentDataType.STRING, sound.toString());
    }

    public float getVolume() {
        return volume;
    }
    public void setVolume(float volume) {
        this.volume = volume;
        player.getPersistentDataContainer().set(new NamespacedKey(Main.INSTANCE, "volume"), PersistentDataType.FLOAT, volume);
    }

    public float getPitch() {
        return pitch;
    }
    public void setPitch(float pitch) {
        this.pitch = pitch;
        player.getPersistentDataContainer().set(new NamespacedKey(Main.INSTANCE, "pitch"), PersistentDataType.FLOAT, pitch);
    }

    public static void clearCurrentSound(Inventory clickedInventory, Player player, int slot) {

        ItemStack originalSlot = clickedInventory.getItem(slot);

        ItemStack currentSoundDisplayButton = CurrentSoundDisplayButton.CurrentSoundDisplayButton(player);
        clickedInventory.setItem(slot, currentSoundDisplayButton);

        if (originalSlot.getType() == Material.BARRIER) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
            CurrentSoundData.playerSounds.remove(player.getUniqueId());
            clickedInventory.setItem(slot, CurrentSoundDisplayButton.CurrentSoundDisplayButton(player));

            if (slot == 13) {
                for (int i = 0; i < 9; i++) {
                    clickedInventory.setItem(i, Frame());
                    clickedInventory.setItem(36 + i, Frame());
                }
                clickedInventory.setItem(9, null);
                clickedInventory.setItem(17, null);
                clickedInventory.setItem(27, null);
                clickedInventory.setItem(35, null);
            }

        } else if (originalSlot.getType() == Material.GLASS_PANE) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_BASS, 0.5f, 0.5f);
        } else {
            ItemStack confirmClearSound = ButtonCreator.createButton(Material.BARRIER, ChatColor.RED + "ᴅʀᴏᴘ ᴀɢᴀɪɴ ᴛᴏ ᴄᴏɴꜰɪʀᴍ");
            clickedInventory.setItem(slot, confirmClearSound);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (clickedInventory.getItem(slot).getType() == Material.BARRIER) {
                        clickedInventory.setItem(slot, originalSlot);
                    }
                }
            }.runTaskLater(Main.INSTANCE, 60L);
        }
    }
}
