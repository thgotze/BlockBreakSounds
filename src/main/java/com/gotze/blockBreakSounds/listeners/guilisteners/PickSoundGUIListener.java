package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.AllSoundsGUI;
import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class PickSoundGUIListener implements Listener {

    public PickSoundGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("Pick Sound")) return;
        event.setCancelled(true);

        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (clickedInventory == null || clickedInventory.equals(player.getInventory())) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        Sound sound;
        float volume = 0.50f;
        float pitch = 1.00f;

        // TODO: Condense the cases together
        switch (slot) {
            case 4: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
                return;

            case 9: // Cling!
                sound = Sound.BLOCK_AMETHYST_BLOCK_BREAK;
                pitch = 1.25f;
                break;

            case 10: // Pickup!
                sound = Sound.ENTITY_ITEM_PICKUP;
                break;

            case 11: // Ding!
                sound = Sound.ENTITY_EXPERIENCE_ORB_PICKUP;
                volume = 0.10f;
                pitch = 2.00f;
                break;

            case 12: // Rattle!
                sound = Sound.ITEM_SPYGLASS_USE;
                break;

            case 13: // Glimmer!
                sound = Sound.ENTITY_PLAYER_LEVELUP;
                volume = 0.10f;
                pitch = 2.00f;
                break;

            case 14: // Brushplop!
                sound = Sound.ENTITY_ARMADILLO_BRUSH;
                break;

            case 15: // Clonk!
                sound = Sound.BLOCK_DECORATED_POT_BREAK;
                break;

            case 16: // Pop!
                sound = Sound.BLOCK_DECORATED_POT_INSERT;
                break;

            case 17: // Clatter!
                sound = Sound.BLOCK_BONE_BLOCK_BREAK;
                break;

            case 18: // Bamboo!
                sound = Sound.BLOCK_BAMBOO_BREAK;
                break;

            case 19: // Plop!
                sound = Sound.BLOCK_BEEHIVE_EXIT;
                break;

            case 20: // Whoosh!
                sound = Sound.ENTITY_ENDER_EYE_DEATH;
                break;

            case 21: // Blip!
                sound = Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP;
                break;

            case 22: // Sizzle!
                sound = Sound.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT;
                break;

            case 23: // Crumble!
                sound = Sound.BLOCK_CALCITE_BREAK;
                break;

            case 24: // Snap!
                sound = Sound.BLOCK_SCAFFOLDING_BREAK;
                break;

            case 25: // Whomp!
                sound = Sound.BLOCK_END_PORTAL_FRAME_FILL;
                break;

            case 26: // Klink!
                sound = Sound.BLOCK_COPPER_BULB_PLACE;
                break;

            case 27: // Creak!
                sound = Sound.BLOCK_FUNGUS_BREAK;
                break;

            case 28: // Bloop!
                sound = Sound.BLOCK_LAVA_POP;
                break;

            case 29: // Quink!
                sound = Sound.BLOCK_LODESTONE_PLACE;
                break;

            case 30: // Chime!
                sound = Sound.BLOCK_AMETHYST_BLOCK_CHIME;
                break;

            case 31: // Snow!
                sound = Sound.BLOCK_SNOW_BREAK;
                break;

            case 32: // Grumble!
                sound = Sound.BLOCK_DEEPSLATE_BREAK;
                break;

            case 33: // Pew!
                sound = Sound.ENTITY_VEX_HURT;
                pitch = 1.50f;
                break;

            case 34: // Monch!
                sound = Sound.ENTITY_SNIFFER_EAT;
                break;

            case 35: // Clank!
                sound = Sound.BLOCK_NETHERITE_BLOCK_BREAK;
                break;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new BlockBreakSoundsGUI(player);
                return;

            case 40: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new FavoriteSoundsGUI(player);
                return;

            case 44: // Pick From All Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new AllSoundsGUI(player, "All Sounds");
                return;

            default:
                return;
        }

        SoundData soundData = new SoundData(sound, volume, pitch, clickedInventory.getItem(slot).getType());

        if (clickType == ClickType.SHIFT_RIGHT) { // Favorite Sound
            FavoriteSoundData.addSoundToFavorites(player, soundData);
            GUIUtils.handleFavoritedLineSound(clickedInventory, slot);
            return;
        }

        if (clickType != ClickType.SHIFT_RIGHT) { // Pick Sound
            CurrentSoundData.setCurrentSound(player, soundData);
            GUIUtils.handlePickedLineSound(clickedInventory, slot);
            clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
            return;
        }
    }
}