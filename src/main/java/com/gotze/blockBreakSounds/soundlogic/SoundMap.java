package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;

public class SoundMap {

    public static final Map<ItemStack, Map<ItemStack, Map<ItemStack, List<SoundData>>>> ENTITY_SOUNDS = new HashMap<>(); // Ender pearl
    public static final Map<ItemStack, Map<ItemStack, Map<ItemStack, List<SoundData>>>> BLOCK_SOUNDS = new HashMap<>(); // Stone Block
    public static final Map<ItemStack, Map<ItemStack, Map<ItemStack, List<SoundData>>>> ITEM_SOUNDS = new HashMap<>(); // Diamond axe
    public static final Map<ItemStack, Map<ItemStack, Map<ItemStack, List<SoundData>>>> NOTEBLOCK_SOUNDS = new HashMap<>(); // Noteblock
    public static final Map<ItemStack, Map<ItemStack, Map<ItemStack, List<SoundData>>>> OTHER_SOUNDS = new HashMap<>(); // Jukebox

    static {
        ENTITY_SOUNDS.put(createItemStack(Material.ENDER_PEARL, "Entity Sounds"), new HashMap<>() {{
            // Passive Mob Sounds
            put(createItemStack(Material.SHEEP_SPAWN_EGG, "Passive Mob Sounds"), new HashMap<>() {{
                put(createItemStack(Material.CHICKEN_SPAWN_EGG, "Chicken Sounds"), List.of(
                        new SoundData(Sound.ENTITY_CHICKEN_AMBIENT, Material.FEATHER),
                        new SoundData(Sound.ENTITY_CHICKEN_HURT, Material.BONE),
                        new SoundData(Sound.ENTITY_CHICKEN_EGG, Material.EGG)
                ));
                put(createItemStack(Material.VILLAGER_SPAWN_EGG, "Villager Sounds"), List.of(
                        new SoundData(Sound.ENTITY_VILLAGER_TRADE, Material.EMERALD),
                        new SoundData(Sound.ENTITY_VILLAGER_YES, Material.LIME_DYE),
                        new SoundData(Sound.ENTITY_VILLAGER_NO, Material.RED_DYE)
                ));
            }});
            // Neutral Mob Sounds
            put(createItemStack(Material.SQUID_SPAWN_EGG, "Neutral Mob Sounds"), new HashMap<>() {{
                put(createItemStack(Material.CHICKEN_SPAWN_EGG, "Chicken Sounds"), List.of(
                        new SoundData(Sound.ENTITY_CHICKEN_AMBIENT, Material.FEATHER),
                        new SoundData(Sound.ENTITY_CHICKEN_HURT, Material.BONE),
                        new SoundData(Sound.ENTITY_CHICKEN_EGG, Material.EGG)
                ));
            }});
            // Hostile Mob Sounds
            put(createItemStack(Material.ZOMBIE_SPAWN_EGG, "Hostile Mob Sounds"), new HashMap<>() {{
                put(createItemStack(Material.ZOMBIE_HEAD, "Zombie Sounds"), List.of(
                        new SoundData(Sound.ENTITY_ZOMBIE_AMBIENT, Material.ROTTEN_FLESH),
                        new SoundData(Sound.ENTITY_ZOMBIE_HURT, Material.BONE),
                        new SoundData(Sound.ENTITY_ZOMBIE_DEATH, Material.REDSTONE)
                ));
                put(createItemStack(Material.SKELETON_SKULL, "Skeleton Sounds"), List.of(
                        new SoundData(Sound.ENTITY_SKELETON_AMBIENT, Material.BONE),
                        new SoundData(Sound.ENTITY_SKELETON_HURT, Material.ARROW),
                        new SoundData(Sound.ENTITY_SKELETON_DEATH, Material.BONE_MEAL)
                ));
            }});
            // Player Sounds
            put(createItemStack(Material.PLAYER_HEAD, "Player Sounds"), new HashMap<>() {{
                put(createItemStack(Material.NOTE_BLOCK, ""), List.of(
                        new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK)
                ));


            }});
            // Projectile Sounds
            put(createItemStack(Material.ARROW, "Projectile Sounds"), new HashMap<>() {{
                put(createItemStack(Material.NOTE_BLOCK, ""), List.of(
                        new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK)
                ));


            }});
            // Other Entity Sounds
            put(createItemStack(Material.GLASS, "Other Entity Sounds"), new HashMap<>() {{
                put(createItemStack(Material.NOTE_BLOCK, ""), List.of(
                        new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK)
                ));
            }});
        }});
    }
}