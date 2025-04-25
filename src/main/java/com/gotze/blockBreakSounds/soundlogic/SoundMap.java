package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;

public class SoundMap {

    // Entity Sounds
    public static final Map<ItemStack, Map<ItemStack, List<SoundData>>> ENTITY_SOUNDS = new LinkedHashMap<>();
    static {
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
        ENTITY_SOUNDS.put(createItemStack(Material.SQUID_SPAWN_EGG, "Neutral Mob Sounds"), new LinkedHashMap<>() {{
            put(createItemStack(Material.CHICKEN_SPAWN_EGG, "Chicken Sounds"), List.of(
                    new SoundData(Sound.ENTITY_CHICKEN_AMBIENT, Material.FEATHER),
                    new SoundData(Sound.ENTITY_CHICKEN_HURT, Material.BONE),
                    new SoundData(Sound.ENTITY_CHICKEN_EGG, Material.EGG)
            ));
        }});
        // Hostile Mob Sounds
        ENTITY_SOUNDS.put(createItemStack(Material.ZOMBIE_SPAWN_EGG, "Hostile Mob Sounds"), new LinkedHashMap<>() {{
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
        ENTITY_SOUNDS.put(createItemStack(Material.PLAYER_HEAD, "Player Sounds"), new LinkedHashMap<>() {{
            put(createItemStack(Material.NOTE_BLOCK, ""), List.of(
                    new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK)
            ));
        }});
        // Projectile Sounds
        ENTITY_SOUNDS.put(createItemStack(Material.ARROW, "Projectile Sounds"), new LinkedHashMap<>() {{
            put(createItemStack(Material.NOTE_BLOCK, ""), List.of(
                    new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK)
            ));
        }});
        // Other Entity Sounds
        ENTITY_SOUNDS.put(createItemStack(Material.GLASS, "Other Entity Sounds"), new LinkedHashMap<>() {{
            put(createItemStack(Material.NOTE_BLOCK, ""), List.of(
                    new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK)
            ));
        }});
    }

    // Block Sounds
    public static final Map<ItemStack, Map<ItemStack, Map<ItemStack, List<SoundData>>>> BLOCK_SOUNDS = new LinkedHashMap<>();
    static {

    }

    // Item Sounds
    public static final Map<ItemStack, List<SoundData>> ITEM_SOUNDS = new LinkedHashMap<>();
    static {
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

    // Noteblock Sounds
    public static final List<SoundData> NOTEBLOCK_SOUNDS = List.of(
            new SoundData(Sound.BLOCK_NOTE_BLOCK_BANJO, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_BASEDRUM, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_BASS, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_BELL, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_BIT, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_CHIME, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_COW_BELL, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_FLUTE, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_GUITAR, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_HARP, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_HAT, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_IMITATE_CREEPER, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_IMITATE_ENDER_DRAGON, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_IMITATE_PIGLIN, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_IMITATE_SKELETON, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_IMITATE_WITHER_SKELETON, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_IMITATE_ZOMBIE, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_PLING, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_SNARE, Material.NOTE_BLOCK),
            new SoundData(Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, Material.NOTE_BLOCK)
    );

    // Other Sounds
    public static final Map<ItemStack, List<SoundData>> OTHER_SOUNDS = new LinkedHashMap<>();
    static {
        // Music Discs
        OTHER_SOUNDS.put(createItemStack(Material.MUSIC_DISC_CAT, "Music Disc Sounds"), List.of(
                new SoundData(Sound.MUSIC_DISC_11, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_13, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_5, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_BLOCKS, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_CAT, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_CHIRP, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_CREATOR, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_CREATOR_MUSIC_BOX, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_FAR, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_MALL, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_MELLOHI, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_OTHERSIDE, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_PIGSTEP, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_PRECIPICE, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_RELIC, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_STAL, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_STRAD, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_WAIT, Material.MUSIC_DISC_CAT),
                new SoundData(Sound.MUSIC_DISC_WARD, Material.MUSIC_DISC_CAT)
        ));

        // Biome Ambience
        OTHER_SOUNDS.put(createItemStack(Material.OAK_SAPLING, "Biome Ambience Sounds"), List.of(
                new SoundData(Sound.AMBIENT_BASALT_DELTAS_ADDITIONS, Material.BASALT),
                new SoundData(Sound.AMBIENT_BASALT_DELTAS_LOOP, Material.BASALT),
                new SoundData(Sound.AMBIENT_BASALT_DELTAS_MOOD, Material.BASALT),
                new SoundData(Sound.AMBIENT_CAVE, Material.STONE),
                new SoundData(Sound.AMBIENT_CRIMSON_FOREST_ADDITIONS, Material.CRIMSON_STEM),
                new SoundData(Sound.AMBIENT_CRIMSON_FOREST_LOOP, Material.CRIMSON_STEM),
                new SoundData(Sound.AMBIENT_CRIMSON_FOREST_MOOD, Material.CRIMSON_STEM),
                new SoundData(Sound.AMBIENT_NETHER_WASTES_ADDITIONS, Material.SOUL_SOIL),
                new SoundData(Sound.AMBIENT_NETHER_WASTES_LOOP, Material.SOUL_SOIL),
                new SoundData(Sound.AMBIENT_NETHER_WASTES_MOOD, Material.SOUL_SOIL),
                new SoundData(Sound.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, Material.SOUL_SAND),
                new SoundData(Sound.AMBIENT_SOUL_SAND_VALLEY_LOOP, Material.SOUL_SAND),
                new SoundData(Sound.AMBIENT_SOUL_SAND_VALLEY_MOOD, Material.SOUL_SAND),
                new SoundData(Sound.AMBIENT_UNDERWATER_ENTER, Material.WATER_BUCKET),
                new SoundData(Sound.AMBIENT_UNDERWATER_EXIT, Material.WATER_BUCKET),
                new SoundData(Sound.AMBIENT_UNDERWATER_LOOP, Material.WATER_BUCKET),
                new SoundData(Sound.AMBIENT_UNDERWATER_LOOP_ADDITIONS, Material.WATER_BUCKET),
                new SoundData(Sound.AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE, Material.WATER_BUCKET),
                new SoundData(Sound.AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE, Material.WATER_BUCKET),
                new SoundData(Sound.AMBIENT_WARPED_FOREST_ADDITIONS, Material.WARPED_HYPHAE),
                new SoundData(Sound.AMBIENT_WARPED_FOREST_LOOP, Material.WARPED_HYPHAE),
                new SoundData(Sound.AMBIENT_WARPED_FOREST_MOOD, Material.WARPED_HYPHAE)
        ));

        // Music Sounds
        OTHER_SOUNDS.put(createItemStack(Material.JUKEBOX), List.of(
                new SoundData(Sound.MUSIC_CREATIVE, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_CREDITS, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_DRAGON, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_END, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_GAME, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_MENU, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_UNDER_WATER, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_NETHER_BASALT_DELTAS, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_NETHER_CRIMSON_FOREST, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_NETHER_NETHER_WASTES, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_NETHER_SOUL_SAND_VALLEY, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_NETHER_WARPED_FOREST, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_BADLANDS, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_BAMBOO_JUNGLE, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_CHERRY_GROVE, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_DEEP_DARK, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_DESERT, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_DRIPSTONE_CAVES, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_FLOWER_FOREST, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_FOREST, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_FROZEN_PEAKS, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_GROVE, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_JAGGED_PEAKS, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_JUNGLE, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_LUSH_CAVES, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_MEADOW, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_OLD_GROWTH_TAIGA, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_SNOWY_SLOPES, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_SPARSE_JUNGLE, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_STONY_PEAKS, Material.JUKEBOX),
                new SoundData(Sound.MUSIC_OVERWORLD_SWAMP, Material.JUKEBOX)
        ));

        // Weather Sounds
        OTHER_SOUNDS.put(createItemStack(Material.LIGHTNING_ROD), List.of(
                new SoundData(Sound.WEATHER_RAIN, Material.WATER_BUCKET),
                new SoundData(Sound.WEATHER_RAIN_ABOVE, Material.WATER_BUCKET)
        ));

        // Event Sounds
        OTHER_SOUNDS.put(createItemStack(Material.TOTEM_OF_UNDYING), List.of(
                new SoundData(Sound.EVENT_MOB_EFFECT_BAD_OMEN, Material.TOTEM_OF_UNDYING),
                new SoundData(Sound.EVENT_MOB_EFFECT_RAID_OMEN, Material.TOTEM_OF_UNDYING),
                new SoundData(Sound.EVENT_MOB_EFFECT_TRIAL_OMEN, Material.TOTEM_OF_UNDYING),
                new SoundData(Sound.EVENT_RAID_HORN, Material.GOAT_HORN)
        ));

        // UI Sounds
        OTHER_SOUNDS.put(createItemStack(Material.STONE_BUTTON), List.of(
                new SoundData(Sound.UI_BUTTON_CLICK, Material.STONE_BUTTON),
                new SoundData(Sound.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, Material.CARTOGRAPHY_TABLE),
                new SoundData(Sound.UI_HUD_BUBBLE_POP, Material.PUFFERFISH),
                new SoundData(Sound.UI_LOOM_SELECT_PATTERN, Material.LOOM),
                new SoundData(Sound.UI_LOOM_TAKE_RESULT, Material.LOOM),
                new SoundData(Sound.UI_STONECUTTER_SELECT_RECIPE, Material.STONECUTTER),
                new SoundData(Sound.UI_STONECUTTER_TAKE_RESULT, Material.STONECUTTER),
                new SoundData(Sound.UI_TOAST_CHALLENGE_COMPLETE, Material.DIAMOND_BLOCK),
                new SoundData(Sound.UI_TOAST_IN, Material.OAK_BUTTON),
                new SoundData(Sound.UI_TOAST_OUT, Material.OAK_BUTTON)
        ));

        // Uncategorized
        OTHER_SOUNDS.put(createItemStack(Material.GLASS), List.of(
                new SoundData(Sound.PARTICLE_SOUL_ESCAPE, Material.SOUL_SAND),
                new SoundData(Sound.ENCHANT_THORNS_HIT, Material.CACTUS)
        ));
    }
}