package com.gotze.blockbreaksounds.gui.picksound;

import com.gotze.blockbreaksounds.model.SoundData;
import org.bukkit.Material;
import org.bukkit.Sound;

import java.util.Map;

import static org.bukkit.Sound.ENTITY_ITEM_PICKUP;

public final class PickSoundsRegistry {
    public static final Map<Integer, SoundData> PICK_SOUND_MAP = Map.ofEntries(
            Map.entry(9, new SoundData(Sound.BLOCK_AMETHYST_BLOCK_BREAK, 0.5f, 1.25f, Material.AMETHYST_BLOCK)),
            Map.entry(10, new SoundData(ENTITY_ITEM_PICKUP, Material.PUFFERFISH)),
            Map.entry(11, new SoundData(Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0.10f, 2.00f, Material.EXPERIENCE_BOTTLE)),
            Map.entry(12, new SoundData(Sound.ITEM_SPYGLASS_USE, Material.SPYGLASS)),
            Map.entry(13, new SoundData(Sound.ENTITY_PLAYER_LEVELUP, 0.10f, 2.00f, Material.SUNFLOWER)),
            Map.entry(14, new SoundData(Sound.ENTITY_ARMADILLO_BRUSH, Material.BRUSH)),
            Map.entry(15, new SoundData(Sound.BLOCK_DECORATED_POT_BREAK, Material.DECORATED_POT)),
            Map.entry(16, new SoundData(Sound.BLOCK_DECORATED_POT_INSERT, Material.HOPPER)),
            Map.entry(17, new SoundData(Sound.BLOCK_BONE_BLOCK_BREAK, Material.BONE_BLOCK)),
            Map.entry(18, new SoundData(Sound.BLOCK_BAMBOO_BREAK, Material.BAMBOO)),
            Map.entry(19, new SoundData(Sound.BLOCK_BEEHIVE_EXIT, Material.BEEHIVE)),
            Map.entry(20, new SoundData(Sound.ENTITY_ENDER_EYE_DEATH, Material.ENDER_EYE)),
            Map.entry(21, new SoundData(Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, Material.GLASS_BOTTLE)),
            Map.entry(22, new SoundData(Sound.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT, Material.CAULDRON)),
            Map.entry(23, new SoundData(Sound.BLOCK_CALCITE_BREAK, Material.CALCITE)),
            Map.entry(24, new SoundData(Sound.BLOCK_SCAFFOLDING_BREAK, Material.SCAFFOLDING)),
            Map.entry(25, new SoundData(Sound.BLOCK_END_PORTAL_FRAME_FILL, Material.END_PORTAL_FRAME)),
            Map.entry(26, new SoundData(Sound.BLOCK_COPPER_BULB_PLACE, Material.COPPER_BULB)),
            Map.entry(27, new SoundData(Sound.BLOCK_FUNGUS_BREAK, Material.OAK_PLANKS)),
            Map.entry(28, new SoundData(Sound.BLOCK_LAVA_POP, Material.LAVA_BUCKET)),
            Map.entry(29, new SoundData(Sound.BLOCK_LODESTONE_PLACE, Material.LODESTONE)),
            Map.entry(30, new SoundData(Sound.BLOCK_AMETHYST_BLOCK_CHIME, Material.PINK_PETALS)),
            Map.entry(31, new SoundData(Sound.BLOCK_SNOW_BREAK, Material.SNOW_BLOCK)),
            Map.entry(32, new SoundData(Sound.BLOCK_DEEPSLATE_BREAK, Material.DEEPSLATE)),
            Map.entry(33, new SoundData(Sound.ENTITY_VEX_HURT, 0.5f, 1.50f, Material.SPECTRAL_ARROW)),
            Map.entry(34, new SoundData(Sound.ENTITY_SNIFFER_EAT, Material.COOKED_BEEF)),
            Map.entry(35, new SoundData(Sound.BLOCK_NETHERITE_BLOCK_BREAK, Material.NETHERITE_BLOCK))
    );

    public static final Map<Sound, String> SOUND_NICKNAMES = Map.ofEntries(
            Map.entry(Sound.BLOCK_AMETHYST_BLOCK_BREAK, "Cling!"),
            Map.entry(Sound.ENTITY_ITEM_PICKUP, "Pickup!"),
            Map.entry(Sound.ENTITY_EXPERIENCE_ORB_PICKUP, "Ding!"),
            Map.entry(Sound.ITEM_SPYGLASS_USE, "Rattle!"),
            Map.entry(Sound.ENTITY_PLAYER_LEVELUP, "Glimmer!"),
            Map.entry(Sound.ENTITY_ARMADILLO_BRUSH, "Brushplop!"),
            Map.entry(Sound.BLOCK_DECORATED_POT_BREAK, "Clonk!"),
            Map.entry(Sound.BLOCK_DECORATED_POT_INSERT, "Pop!"),
            Map.entry(Sound.BLOCK_BONE_BLOCK_BREAK, "Clatter!"),
            Map.entry(Sound.BLOCK_BAMBOO_BREAK, "Bamboo!"),
            Map.entry(Sound.BLOCK_BEEHIVE_EXIT, "Plop!"),
            Map.entry(Sound.ENTITY_ENDER_EYE_DEATH, "Whoosh!"),
            Map.entry(Sound.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, "Blip!"),
            Map.entry(Sound.BLOCK_BUBBLE_COLUMN_UPWARDS_AMBIENT, "Sizzle!"),
            Map.entry(Sound.BLOCK_CALCITE_BREAK, "Crumble!"),
            Map.entry(Sound.BLOCK_SCAFFOLDING_BREAK, "Snap!"),
            Map.entry(Sound.BLOCK_END_PORTAL_FRAME_FILL, "Whomp!"),
            Map.entry(Sound.BLOCK_COPPER_BULB_PLACE, "Klink!"),
            Map.entry(Sound.BLOCK_FUNGUS_BREAK, "Creak!"),
            Map.entry(Sound.BLOCK_LAVA_POP, "Bloop!"),
            Map.entry(Sound.BLOCK_LODESTONE_PLACE, "Quink!"),
            Map.entry(Sound.BLOCK_AMETHYST_BLOCK_CHIME, "Chime!"),
            Map.entry(Sound.BLOCK_SNOW_BREAK, "Snow!"),
            Map.entry(Sound.BLOCK_DEEPSLATE_BREAK, "Grumble!"),
            Map.entry(Sound.ENTITY_VEX_HURT, "Pew!"),
            Map.entry(Sound.ENTITY_SNIFFER_EAT, "Monch!"),
            Map.entry(Sound.BLOCK_NETHERITE_BLOCK_BREAK, "Clank!")
    );
}