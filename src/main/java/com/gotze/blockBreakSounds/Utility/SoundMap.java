package com.gotze.blockBreakSounds.Utility;

import org.bukkit.Material;
import org.bukkit.Sound;

import java.util.HashMap;
import java.util.Map;

public class SoundMap {

    public static final Map<String, Sound> soundNames = new HashMap<>();
    public static final Map<Sound, Material> soundToMaterial = new HashMap<>();

//    Sound Categories:
//    Mob Sounds, Animal Sounds, Player Sounds,
//    Ambient Sounds,  UI Sounds, Noteblocks, Music Discs,
//    Miscellaneous

//            Ambient Sounds
//            "ambient.basalt_deltas.additions",
//            "ambient.basalt_deltas.loop",
//            "ambient.basalt_deltas.mood",
//            "ambient.cave",
//            "ambient.crimson_forest.additions",
//            "ambient.crimson_forest.loop",
//            "ambient.crimson_forest.mood",
//            "ambient.nether_wastes.additions",
//            "ambient.nether_wastes.loop",
//            "ambient.nether_wastes.mood",
//            "ambient.soul_sand_valley.additions",
//            "ambient.soul_sand_valley.loop",
//            "ambient.soul_sand_valley.mood",
//            "ambient.underwater.enter",
//            "ambient.underwater.exit",
//            "ambient.underwater.loop",
//            "ambient.underwater.loop.additions",
//            "ambient.underwater.loop.additions.rare",
//            "ambient.underwater.loop.additions.ultra_rare",
//            "ambient.warped_forest.additions",
//            "ambient.warped_forest.loop",
//            "ambient.warped_forest.mood"


    static {
        // Sound Names - Sound File
        soundNames.put("Chime!", Sound.BLOCK_AMETHYST_BLOCK_CHIME);
        soundNames.put("Monch!", Sound.ENTITY_SNIFFER_EAT);
        soundNames.put("Bamboo!", Sound.BLOCK_BAMBOO_BREAK);
        soundNames.put("Blip!", Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP);
        soundNames.put("Bloop!", Sound.BLOCK_LAVA_POP);
        soundNames.put("Brick!", Sound.BLOCK_DECORATED_POT_BREAK);
        soundNames.put("Clank!", Sound.BLOCK_NETHERITE_BLOCK_BREAK);
        soundNames.put("Clatter!", Sound.BLOCK_BONE_BLOCK_BREAK);
        soundNames.put("Cling!", Sound.BLOCK_AMETHYST_BLOCK_BREAK);
        soundNames.put("Clonk!", Sound.BLOCK_DECORATED_POT_INSERT_FAIL);
        soundNames.put("Creak!", Sound.BLOCK_FUNGUS_BREAK);
        soundNames.put("Cronch!", Sound.BLOCK_BASALT_HIT);
        soundNames.put("Ding!", Sound.ENTITY_EXPERIENCE_ORB_PICKUP);
        soundNames.put("Dink!", Sound.BLOCK_COPPER_GRATE_BREAK);
        soundNames.put("Glimmer!", Sound.ENTITY_PLAYER_LEVELUP);
        soundNames.put("Klink!", Sound.BLOCK_COPPER_BULB_PLACE);
        soundNames.put("Pickup!", Sound.ENTITY_ITEM_PICKUP);
        soundNames.put("Plop!", Sound.BLOCK_BEEHIVE_EXIT);
        soundNames.put("Pop!", Sound.BLOCK_DECORATED_POT_INSERT);
        soundNames.put("Quink!", Sound.BLOCK_LODESTONE_PLACE);
        soundNames.put("Crumble!", Sound.BLOCK_CALCITE_BREAK);
        soundNames.put("Sizzle!", Sound.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT);
        soundNames.put("Smack!", Sound.ENTITY_ITEM_FRAME_REMOVE_ITEM);
        soundNames.put("Snap!", Sound.BLOCK_SCAFFOLDING_BREAK);
        soundNames.put("Snow!", Sound.BLOCK_SNOW_BREAK);
        soundNames.put("Tink!", Sound.BLOCK_COPPER_BREAK);
        soundNames.put("Placeholder1", Sound.BLOCK_DEEPSLATE_BREAK);
        soundNames.put("Pew!", Sound.ENTITY_VEX_HURT);

        // Sound File - Sound Material
        soundToMaterial.put(Sound.BLOCK_AMETHYST_BLOCK_BREAK, Material.AMETHYST_BLOCK);
        soundToMaterial.put(Sound.BLOCK_AMETHYST_BLOCK_CHIME, Material.PINK_PETALS);
        soundToMaterial.put(Sound.BLOCK_ANCIENT_DEBRIS_HIT, Material.ANCIENT_DEBRIS);
        soundToMaterial.put(Sound.BLOCK_BAMBOO_BREAK, Material.BAMBOO);
        soundToMaterial.put(Sound.BLOCK_BEEHIVE_ENTER, Material.BEEHIVE);
        soundToMaterial.put(Sound.BLOCK_BEEHIVE_EXIT, Material.BEE_NEST);
        soundToMaterial.put(Sound.BLOCK_BONE_BLOCK_BREAK, Material.BONE_BLOCK);
        soundToMaterial.put(Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, Material.GLASS_BOTTLE);
        soundToMaterial.put(Sound.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT, Material.CAULDRON);
        soundToMaterial.put(Sound.BLOCK_CALCITE_BREAK, Material.CALCITE);
        soundToMaterial.put(Sound.BLOCK_COPPER_BULB_PLACE, Material.COPPER_BULB);
        soundToMaterial.put(Sound.BLOCK_DECORATED_POT_BREAK, Material.DECORATED_POT);
        soundToMaterial.put(Sound.BLOCK_DECORATED_POT_INSERT, Material.HOPPER);
        soundToMaterial.put(Sound.BLOCK_END_PORTAL_FRAME_FILL, Material.END_PORTAL_FRAME);
        soundToMaterial.put(Sound.BLOCK_FUNGUS_BREAK, Material.OAK_PLANKS);
        soundToMaterial.put(Sound.BLOCK_LAVA_POP, Material.LAVA_BUCKET);
        soundToMaterial.put(Sound.BLOCK_LODESTONE_PLACE, Material.LODESTONE);
        soundToMaterial.put(Sound.BLOCK_NETHERITE_BLOCK_BREAK, Material.NETHERITE_BLOCK);
        soundToMaterial.put(Sound.BLOCK_SCAFFOLDING_BREAK, Material.SCAFFOLDING);
        soundToMaterial.put(Sound.BLOCK_SNOW_BREAK, Material.SNOW_BLOCK);
        soundToMaterial.put(Sound.ENTITY_ARMADILLO_BRUSH, Material.BRUSH);
        soundToMaterial.put(Sound.ENTITY_ENDER_EYE_DEATH, Material.ENDER_EYE);
        soundToMaterial.put(Sound.ENTITY_EXPERIENCE_ORB_PICKUP, Material.EXPERIENCE_BOTTLE);
        soundToMaterial.put(Sound.ENTITY_ITEM_FRAME_REMOVE_ITEM, Material.ITEM_FRAME);
        soundToMaterial.put(Sound.ENTITY_ITEM_PICKUP, Material.PUFFERFISH);
        soundToMaterial.put(Sound.ENTITY_PLAYER_LEVELUP, Material.SUNFLOWER);
        soundToMaterial.put(Sound.ENTITY_SNIFFER_EAT, Material.COOKED_BEEF);
        soundToMaterial.put(Sound.ENTITY_VEX_HURT, Material.SPECTRAL_ARROW);
        soundToMaterial.put(Sound.BLOCK_DEEPSLATE_BREAK, Material.COBBLED_DEEPSLATE);
    }

    public static Material getMaterialFromSound(Sound sound) {
        // return the material of the 27 pre-selected sounds, if it can't find sound the default is note block
        return soundToMaterial.getOrDefault(sound, Material.NOTE_BLOCK);
    }
}
