package com.gotze.blockBreakSounds.PickSoundGUI;

import com.gotze.blockBreakSounds.BlockBreakSoundsGUI.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.FavoriteSoundsGUI.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.Utility.LineHandlers.FavoritedSoundLineHandler;
import com.gotze.blockBreakSounds.Utility.LineHandlers.PickedSoundLineHandler;
import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

import static com.gotze.blockBreakSounds.Utility.CurrentSoundDisplayButton.CurrentSoundDisplayButton;

public class PickSoundGUIListener implements Listener {

    private final Map<Player, Long> lastClickTime = new HashMap<>();
    private static final long CLICK_DELAY = 50; // 50 milliseconds

    public PickSoundGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();

        if (!event.getView().getTitle().equals("Pick Sound")) {
            return;
        }
        event.setCancelled(true);

        if (clickedInventory == player.getInventory() || clickedInventory == null) {
            return;
        }

        // Check for click delay to disallow spam clicking
        long currentTime = System.currentTimeMillis();

        if (lastClickTime.containsKey(player)) {
            long lastClick = lastClickTime.get(player);
            if ((currentTime - lastClick) < CLICK_DELAY) {
                return;
            }
        }
        lastClickTime.put(player, currentTime);

        ClickType clickType = event.getClick();
        int slot = event.getSlot();
        Sound selectedSound;
        CurrentSoundData soundData = CurrentSoundData.playerSounds.get(player.getUniqueId());

        switch (slot) {
            case 4: // Current Sound
                if (clickType == ClickType.DROP) {
                    CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
                    return;
                }
                if (clickType == ClickType.SHIFT_RIGHT) {
                    FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot);
                    return;
                }
                if (soundData != null && clickedInventory.getItem(slot).getType() != Material.BARRIER) {
                    player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
                    return;
                }
                return;

            case 9: // Cling!
                selectedSound = Sound.BLOCK_AMETHYST_BLOCK_BREAK;
                break;

            case 10: // Pickup!
                selectedSound = Sound.ENTITY_ITEM_PICKUP;
                break;

            case 11: // Ding!
                selectedSound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
                break;

            case 12: // Smack!
                selectedSound = Sound.ENTITY_ITEM_FRAME_REMOVE_ITEM;
                break;

            case 13: // Glimmer!
                selectedSound = Sound.ENTITY_PLAYER_LEVELUP;
                break;

            case 14: // Brushplop!
                selectedSound = Sound.ENTITY_ARMADILLO_BRUSH;
                break;

            case 15: // Clonk!
                selectedSound = Sound.BLOCK_DECORATED_POT_BREAK;
                break;

            case 16: // Pop!
                selectedSound = Sound.BLOCK_DECORATED_POT_INSERT;
                break;

            case 17: // Clatter!
                selectedSound = Sound.BLOCK_BONE_BLOCK_BREAK;
                break;

            case 18: // Bamboo!
                selectedSound = Sound.BLOCK_BAMBOO_BREAK;
                break;

            case 19: // Plop!
                selectedSound = Sound.BLOCK_BEEHIVE_EXIT;
                break;

            case 20: // Whoosh!
                selectedSound = Sound.ENTITY_ENDER_EYE_DEATH;
                break;

            case 21: // Blip!
                selectedSound = Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP;
                break;

            case 22: // Sizzle!
                selectedSound = Sound.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT;
                break;

            case 23: // Crumble!
                selectedSound = Sound.BLOCK_CALCITE_BREAK;
                break;

            case 24: // Snap!
                selectedSound = Sound.BLOCK_SCAFFOLDING_BREAK;
                break;

            case 25: // Whomp!
                selectedSound = Sound.BLOCK_END_PORTAL_FRAME_FILL;
                break;

            case 26: // Klink!
                selectedSound = Sound.BLOCK_COPPER_BULB_PLACE;
                break;

            case 27: // Creak!
                selectedSound = Sound.BLOCK_FUNGUS_BREAK;
                break;

            case 28: // Bloop!
                selectedSound = Sound.BLOCK_LAVA_POP;
                break;

            case 29: // Quink!
                selectedSound = Sound.BLOCK_LODESTONE_PLACE;
                break;

            case 30: // Chime!
                selectedSound = Sound.BLOCK_AMETHYST_BLOCK_CHIME;
                break;

            case 31: // Snow!
                selectedSound = Sound.BLOCK_SNOW_BREAK;
                break;

            case 32: // Grumble!
                selectedSound = Sound.BLOCK_DEEPSLATE_BREAK;
                break;

            case 33: // Pew!
                selectedSound = Sound.ENTITY_VEX_HURT;
                break;

            case 34: // Monch!
                selectedSound = Sound.ENTITY_SNIFFER_EAT;
                break;

            case 35: // Clank!
                selectedSound = Sound.BLOCK_NETHERITE_BLOCK_BREAK;
                break;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                BlockBreakSoundsGUI blockBreakSoundsGUI = new BlockBreakSoundsGUI(player);
                blockBreakSoundsGUI.openBlockBreakSoundsGUI(player);
                return;

            case 40: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                FavoriteSoundsGUI favoriteSoundsGUI = new FavoriteSoundsGUI();
                favoriteSoundsGUI.openFavoriteSoundsGUI(player);
                return;

            case 44: // Pick From All Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                AllSoundsGUI allSoundsGUI = new AllSoundsGUI();
                allSoundsGUI.openAllSoundsGUI(player);
                return;

            default:
                return;
        }

        // Check if Shift Right click is pressed (Favoriting)
        // Every other click picks the sound
        if (clickType == (ClickType.SHIFT_RIGHT)) {
            FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot);
        } else {
            PickedSoundLineHandler.handlePickedLineSound(clickedInventory, slot);

            float volume = 0.5f;
            float pitch = 1.0f;

            if (selectedSound == Sound.BLOCK_AMETHYST_BLOCK_BREAK) {
                pitch = 1.25f;
            } else if (selectedSound == Sound.ENTITY_VEX_HURT) {
                pitch = 1.5f;
            } else if (selectedSound == Sound.ENTITY_EXPERIENCE_ORB_PICKUP || selectedSound == Sound.ENTITY_PLAYER_LEVELUP) {
                pitch = 2.0f;
                volume = 0.1f;
            }

            if (soundData == null) {
                soundData = new CurrentSoundData(player, selectedSound, volume, pitch);
            } else {
                soundData.setSound(selectedSound);
                soundData.setVolume(volume);
                soundData.setPitch(pitch);
            }
            CurrentSoundData.playerSounds.put(player.getUniqueId(), soundData);
            player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
            clickedInventory.setItem(4, CurrentSoundDisplayButton(player));
        }
    }

    @EventHandler
    // Clean up when player closes the inventory
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        lastClickTime.remove(player);
    }
}

