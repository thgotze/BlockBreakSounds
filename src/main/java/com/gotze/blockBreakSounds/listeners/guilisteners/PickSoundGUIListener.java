package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.AllSoundsGUI;
import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.utils.GUIUtils;
import com.gotze.blockBreakSounds.utils.linehandlers.FavoritedSoundLineHandler;
import com.gotze.blockBreakSounds.utils.linehandlers.PickedSoundLineHandler;
import com.gotze.blockBreakSounds.utils.sounddata.CurrentSoundData;
import com.gotze.blockBreakSounds.utils.sounddata.FavoriteSoundsData;
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
        CurrentSoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());

        // Default volume and pitch levels
        float volume = 0.50f;
        float pitch = 1.00f;

        switch (slot) {
            case 4: // Current Sound
                if (clickType == ClickType.DROP) {
                    CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
                    return;
                }
                if (clickType == ClickType.SHIFT_RIGHT) {
                    FavoriteSoundsData.addFavoriteSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);
                    return;
                }
                if (currentSoundData != null && clickedInventory.getItem(slot).getType() != Material.BARRIER) {
                    player.playSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    return;
                }
                return;

            case 9: // Cling!
                selectedSound = Sound.BLOCK_AMETHYST_BLOCK_BREAK;
                pitch = 1.25f;
                break;

            case 10: // Pickup!
                selectedSound = Sound.ENTITY_ITEM_PICKUP;
                break;

            case 11: // Ding!
                selectedSound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
                volume = 0.10f;
                pitch = 2.00f;
                break;

            case 12: // Smack!
                selectedSound = Sound.ENTITY_ITEM_FRAME_REMOVE_ITEM;
                break;

            case 13: // Glimmer!
                selectedSound = Sound.ENTITY_PLAYER_LEVELUP;
                volume = 0.10f;
                pitch = 2.00f;
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
                pitch = 1.50f;
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
                new FavoriteSoundsGUI().openFavoriteSoundsGUI(player);
                return;

            case 44: // Pick From All Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new AllSoundsGUI().openAllSoundsGUI(player);
                return;

            default:
                return;
        }

        if (clickType == (ClickType.SHIFT_RIGHT)) { // Favorite Sound
            FavoriteSoundsData.addFavoriteSound(player, selectedSound, volume, pitch);
            FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);
        } else { // Pick Sound
            PickedSoundLineHandler.handlePickedLineSound(clickedInventory, slot);

            if (currentSoundData == null) {
                currentSoundData = new CurrentSoundData(player, selectedSound, volume, pitch);
            } else {
                currentSoundData.setSound(selectedSound);
                currentSoundData.setVolume(volume);
                currentSoundData.setPitch(pitch);
            }
            CurrentSoundData.currentSound.put(player.getUniqueId(), currentSoundData);
            player.playSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
            clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        }
    }

    @EventHandler
    // Clean up when player closes the inventory
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        lastClickTime.remove(player);
    }
}