package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;

public class SoundMap {

    public static final Map<ItemStack, Map<ItemStack, List<SoundData>>> ENTITY_SOUNDS = new LinkedHashMap<>(); // Ender pearl
    public static final Map<ItemStack, Map<ItemStack, Map<ItemStack, List<SoundData>>>> BLOCK_SOUNDS = new LinkedHashMap<>(); // Stone Block
    public static final Map<ItemStack, List<SoundData>> ITEM_SOUNDS = new LinkedHashMap<>(); // Diamond axe
    public static final Map<ItemStack, Map<ItemStack, Map<ItemStack, List<SoundData>>>> NOTEBLOCK_SOUNDS = new LinkedHashMap<>(); // Noteblock
    public static final Map<ItemStack, Map<ItemStack, Map<ItemStack, List<SoundData>>>> OTHER_SOUNDS = new LinkedHashMap<>(); // Pufferfish

    static { // Entity Sounds
        // Passive Mob Sounds
        ENTITY_SOUNDS.put(createItemStack(Material.SHEEP_SPAWN_EGG, "Passive Mob Sounds"), new LinkedHashMap<>() {{
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
            put(createItemStack(Material.SQUID_SPAWN_EGG, "Neutral Mob Sounds"), new LinkedHashMap<>() {{
                put(createItemStack(Material.CHICKEN_SPAWN_EGG, "Chicken Sounds"), List.of(
                        new SoundData(Sound.ENTITY_CHICKEN_AMBIENT, Material.FEATHER),
                        new SoundData(Sound.ENTITY_CHICKEN_HURT, Material.BONE),
                        new SoundData(Sound.ENTITY_CHICKEN_EGG, Material.EGG)
                ));
            }});
            // Hostile Mob Sounds
            put(createItemStack(Material.ZOMBIE_SPAWN_EGG, "Hostile Mob Sounds"), new LinkedHashMap<>() {{
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
            put(createItemStack(Material.PLAYER_HEAD, "Player Sounds"), new LinkedHashMap<>() {{
                put(createItemStack(Material.NOTE_BLOCK, ""), List.of(
                        new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK)
                ));


            }});
            // Projectile Sounds
            put(createItemStack(Material.ARROW, "Projectile Sounds"), new LinkedHashMap<>() {{
                put(createItemStack(Material.NOTE_BLOCK, ""), List.of(
                        new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK)
                ));


            }});
            // Other Entity Sounds
            put(createItemStack(Material.GLASS, "Other Entity Sounds"), new LinkedHashMap<>() {{
                put(createItemStack(Material.NOTE_BLOCK, ""), List.of(
                        new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK)
                ));
            }});
        }});
    }

    static { // Item Sounds
        // Trident Sounds
        ITEM_SOUNDS.put(createItemStack(Material.TRIDENT, "Trident Sounds"), List.of(
                new SoundData(Sound.ITEM_TRIDENT_HIT, Material.TRIDENT),
                new SoundData(Sound.ITEM_TRIDENT_HIT_GROUND, Material.TRIDENT),
                new SoundData(Sound.ITEM_TRIDENT_RETURN, Material.TRIDENT),
                new SoundData(Sound.ITEM_TRIDENT_RIPTIDE_1, Material.TRIDENT),
                new SoundData(Sound.ITEM_TRIDENT_RIPTIDE_2, Material.TRIDENT),
                new SoundData(Sound.ITEM_TRIDENT_RIPTIDE_3, Material.TRIDENT),
                new SoundData(Sound.ITEM_TRIDENT_THROW, Material.TRIDENT),
                new SoundData(Sound.ITEM_TRIDENT_THUNDER, Material.TRIDENT)
        ));
        // Goat Horn Sounds
        ITEM_SOUNDS.put(createItemStack(Material.GOAT_HORN, "Goat Horn Sounds"), List.of(
                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_0, Material.GOAT_HORN),
                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_1, Material.GOAT_HORN),
                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_2, Material.GOAT_HORN),
                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_3, Material.GOAT_HORN),
                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_4, Material.GOAT_HORN),
                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_5, Material.GOAT_HORN),
                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_6, Material.GOAT_HORN),
                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_7, Material.GOAT_HORN)
        ));
        // Player Armor Sounds
        ITEM_SOUNDS.put(createItemStack(Material.IRON_CHESTPLATE, "Player Armor Sounds"), List.of(
                new SoundData(Sound.ITEM_ARMOR_EQUIP_LEATHER, Material.LEATHER_CHESTPLATE),
                new SoundData(Sound.ITEM_ARMOR_EQUIP_CHAIN, Material.CHAINMAIL_CHESTPLATE),
                new SoundData(Sound.ITEM_ARMOR_EQUIP_GOLD, Material.GOLDEN_CHESTPLATE),
                new SoundData(Sound.ITEM_ARMOR_EQUIP_IRON, Material.IRON_CHESTPLATE),
                new SoundData(Sound.ITEM_ARMOR_EQUIP_DIAMOND, Material.DIAMOND_CHESTPLATE),
                new SoundData(Sound.ITEM_ARMOR_EQUIP_NETHERITE, Material.NETHERITE_CHESTPLATE),
                new SoundData(Sound.ITEM_ARMOR_EQUIP_ELYTRA, Material.ELYTRA),
                new SoundData(Sound.ITEM_ARMOR_EQUIP_GENERIC, Material.LEATHER_BOOTS)
        ));
        // Axe Sounds
        ITEM_SOUNDS.put(createItemStack(Material.IRON_AXE, "Axe Sounds"), List.of(
                new SoundData(Sound.ITEM_AXE_SCRAPE, Material.IRON_AXE),
                new SoundData(Sound.ITEM_AXE_STRIP, Material.OAK_LOG),
                new SoundData(Sound.ITEM_AXE_WAX_OFF, Material.HONEYCOMB)
        ));
        // Crossbow Sounds
        ITEM_SOUNDS.put(createItemStack(Material.CROSSBOW, "Crossbow Sounds"), List.of(
                new SoundData(Sound.ITEM_CROSSBOW_LOADING_END, Material.CROSSBOW),
                new SoundData(Sound.ITEM_CROSSBOW_LOADING_MIDDLE, Material.CROSSBOW),
                new SoundData(Sound.ITEM_CROSSBOW_LOADING_START, Material.CROSSBOW),
                new SoundData(Sound.ITEM_CROSSBOW_QUICK_CHARGE_1, Material.CROSSBOW),
                new SoundData(Sound.ITEM_CROSSBOW_QUICK_CHARGE_2, Material.CROSSBOW),
                new SoundData(Sound.ITEM_CROSSBOW_QUICK_CHARGE_3, Material.CROSSBOW),
                new SoundData(Sound.ITEM_CROSSBOW_SHOOT, Material.CROSSBOW)
        ));
        // Bucket Sounds
        ITEM_SOUNDS.put(createItemStack(Material.BUCKET, "Bucket Sounds"), List.of(
                new SoundData(Sound.ITEM_BUCKET_EMPTY, Material.BUCKET),
                new SoundData(Sound.ITEM_BUCKET_EMPTY_AXOLOTL, Material.AXOLOTL_BUCKET),
                new SoundData(Sound.ITEM_BUCKET_EMPTY_FISH, Material.WATER_BUCKET),
                new SoundData(Sound.ITEM_BUCKET_EMPTY_LAVA, Material.LAVA_BUCKET),
                new SoundData(Sound.ITEM_BUCKET_EMPTY_POWDER_SNOW, Material.POWDER_SNOW_BUCKET),
                new SoundData(Sound.ITEM_BUCKET_EMPTY_TADPOLE, Material.TADPOLE_BUCKET),
                new SoundData(Sound.ITEM_BUCKET_FILL, Material.BUCKET),
                new SoundData(Sound.ITEM_BUCKET_FILL_AXOLOTL, Material.AXOLOTL_BUCKET),
                new SoundData(Sound.ITEM_BUCKET_FILL_FISH, Material.WATER_BUCKET),
                new SoundData(Sound.ITEM_BUCKET_FILL_LAVA, Material.LAVA_BUCKET),
                new SoundData(Sound.ITEM_BUCKET_FILL_POWDER_SNOW, Material.POWDER_SNOW_BUCKET),
                new SoundData(Sound.ITEM_BUCKET_FILL_TADPOLE, Material.TADPOLE_BUCKET)
        ));
        // Brush Sounds
        ITEM_SOUNDS.put(createItemStack(Material.BRUSH, "Brush Sounds"), List.of(
                new SoundData(Sound.ITEM_BRUSH_BRUSHING_GENERIC, Material.BRUSH),
                new SoundData(Sound.ITEM_BRUSH_BRUSHING_GRAVEL, Material.SUSPICIOUS_GRAVEL),
                new SoundData(Sound.ITEM_BRUSH_BRUSHING_GRAVEL_COMPLETE, Material.SUSPICIOUS_GRAVEL),
                new SoundData(Sound.ITEM_BRUSH_BRUSHING_SAND, Material.SUSPICIOUS_SAND),
                new SoundData(Sound.ITEM_BRUSH_BRUSHING_SAND_COMPLETE, Material.SUSPICIOUS_SAND)
        ));
        // Bundle Sounds
        ITEM_SOUNDS.put(createItemStack(Material.BUNDLE, "Bundle Sounds"), List.of(
                new SoundData(Sound.ITEM_BUNDLE_DROP_CONTENTS, Material.RED_BUNDLE),
                new SoundData(Sound.ITEM_BUNDLE_INSERT, Material.BLUE_BUNDLE),
                new SoundData(Sound.ITEM_BUNDLE_INSERT_FAIL, Material.ORANGE_BUNDLE),
                new SoundData(Sound.ITEM_BUNDLE_REMOVE_ONE, Material.PURPLE_BUNDLE)
        ));
        // Bottle Sounds
        ITEM_SOUNDS.put(createItemStack(Material.GLASS_BOTTLE, "Bottle Sounds"), List.of(
                new SoundData(Sound.ITEM_BOTTLE_EMPTY, Material.GLASS_BOTTLE),
                new SoundData(Sound.ITEM_BOTTLE_FILL, Material.POTION),
                new SoundData(Sound.ITEM_BOTTLE_FILL_DRAGONBREATH, Material.DRAGON_BREATH)
        ));
        // Wolf Armor Sounds
        ITEM_SOUNDS.put(createItemStack(Material.WOLF_ARMOR, "Wolf Armor Sounds"), List.of(
                new SoundData(Sound.ITEM_ARMOR_EQUIP_WOLF, Material.WOLF_ARMOR),
                new SoundData(Sound.ITEM_ARMOR_UNEQUIP_WOLF, Material.WOLF_ARMOR),
                new SoundData(Sound.ITEM_WOLF_ARMOR_BREAK, Material.WOLF_ARMOR),
                new SoundData(Sound.ITEM_WOLF_ARMOR_CRACK, Material.WOLF_ARMOR),
                new SoundData(Sound.ITEM_WOLF_ARMOR_DAMAGE, Material.WOLF_ARMOR),
                new SoundData(Sound.ITEM_WOLF_ARMOR_REPAIR, Material.WOLF_ARMOR)
        ));
        // Mace Sounds
        ITEM_SOUNDS.put(createItemStack(Material.MACE, "Mace Sounds"), List.of(
                new SoundData(Sound.ITEM_MACE_SMASH_AIR, Material.MACE),
                new SoundData(Sound.ITEM_MACE_SMASH_GROUND, Material.MACE),
                new SoundData(Sound.ITEM_MACE_SMASH_GROUND_HEAVY, Material.MACE)
        ));
        // Other Sounds
        ITEM_SOUNDS.put(createItemStack(Material.PUFFERFISH, "Other Sounds"), List.of(
                new SoundData(Sound.ITEM_BONE_MEAL_USE, Material.BONE_MEAL),
                new SoundData(Sound.ITEM_BOOK_PAGE_TURN, Material.BOOK),
                new SoundData(Sound.ITEM_BOOK_PUT, Material.BOOKSHELF),
                new SoundData(Sound.ITEM_ARMOR_EQUIP_TURTLE, Material.TURTLE_HELMET),
                new SoundData(Sound.ITEM_CHORUS_FRUIT_TELEPORT, Material.CHORUS_FRUIT),
                new SoundData(Sound.ITEM_CROP_PLANT, Material.WHEAT_SEEDS),
                new SoundData(Sound.ITEM_DYE_USE, Material.LIME_DYE),
                new SoundData(Sound.ITEM_ELYTRA_FLYING, Material.ELYTRA),
                new SoundData(Sound.ITEM_FIRECHARGE_USE, Material.FIRE_CHARGE),
                new SoundData(Sound.ITEM_FLINTANDSTEEL_USE, Material.FLINT_AND_STEEL),
                new SoundData(Sound.ITEM_GLOW_INK_SAC_USE, Material.GLOW_INK_SAC),
                new SoundData(Sound.ITEM_HOE_TILL, Material.IRON_HOE),
                new SoundData(Sound.ITEM_HONEYCOMB_WAX_ON, Material.HONEYCOMB),
                new SoundData(Sound.ITEM_HONEY_BOTTLE_DRINK, Material.HONEY_BOTTLE),
                new SoundData(Sound.ITEM_INK_SAC_USE, Material.INK_SAC),
                new SoundData(Sound.ITEM_LODESTONE_COMPASS_LOCK, Material.COMPASS),
                new SoundData(Sound.ITEM_NETHER_WART_PLANT, Material.NETHER_WART),
                new SoundData(Sound.ITEM_OMINOUS_BOTTLE_DISPOSE, Material.DRAGON_BREATH),
                new SoundData(Sound.ITEM_SHIELD_BLOCK, Material.SHIELD),
                new SoundData(Sound.ITEM_SHIELD_BREAK, Material.SHIELD),
                new SoundData(Sound.ITEM_SHOVEL_FLATTEN, Material.IRON_SHOVEL),
                new SoundData(Sound.ITEM_SPYGLASS_STOP_USING, Material.SPYGLASS),
                new SoundData(Sound.ITEM_SPYGLASS_USE, Material.SPYGLASS),
                new SoundData(Sound.ITEM_TOTEM_USE, Material.TOTEM_OF_UNDYING)
        ));
    }
}