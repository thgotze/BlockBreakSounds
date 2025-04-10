package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.AllSoundsGUI;
import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.utility.ClickDelayChecker;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.FavoritedSoundLoreHandler;
import com.gotze.blockBreakSounds.utility.PickedSoundLoreHandler;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundsData;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import static com.gotze.blockBreakSounds.soundlogic.CurrentSoundData.currentSound;

public class PickSoundGUIListener implements Listener {

    private static final String GUI_TITLE = "Pick Sound";

    public PickSoundGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();
        event.setCancelled(true);

        if (clickedInventory == null || clickedInventory == player.getInventory() || !event.getView().getTitle().equals(GUI_TITLE)) {
            return;
        }

        if (ClickDelayChecker.shouldIgnoreClick(player)) {
            return;
        }

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        CurrentSoundData currentSoundData = currentSound.get(player.getUniqueId());

        // Default volume and pitch levels
        Sound selectedSound;
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
                    FavoritedSoundLoreHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);
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
                new BlockBreakSoundsGUI().setupAndOpenGUI(player);
                return;

            case 40: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new FavoriteSoundsGUI().setupAndOpenGUI(player);
                return;

            case 44: // Pick From All Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new AllSoundsGUI().setupAndOpenGUI(player);
                return;

            default:
                return;
        }
        if (clickType == (ClickType.SHIFT_RIGHT)) { // Favorite Sound
            FavoriteSoundsData.addFavoriteSound(player, selectedSound, volume, pitch);
            FavoritedSoundLoreHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);
        } else { // Pick Sound
            currentSound.put(player.getUniqueId(), new CurrentSoundData(player, selectedSound, volume, pitch));
            player.playSound(player, selectedSound, volume, pitch);

            PickedSoundLoreHandler.handlePickedLineSound(clickedInventory, slot);
            clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        }
    }
}