package com.gotze.blockbreaksounds.gui.allsounds;

import com.gotze.blockbreaksounds.model.SoundCategory;
import com.gotze.blockbreaksounds.model.SoundData;
import org.bukkit.Material;
import org.bukkit.Sound;

import java.util.*;

public final class AllSoundsRegistry {

    // What is this class' purpose?
    // This class serves as a registry of all Minecraft sounds, neatly organized and categorized.
    // It is used by the "All Sounds" GUI, allowing users to easily navigate through categories to find specific sounds.

    // How are the categories meant to be understood?
    // There are five primary categories: Entity, Block, Item, Noteblock, and Other.
    // Each primary category contains subcategories, which group together sounds with similar characteristics.
    // For example, the "Entity" category includes subcategories which are all tied to entities, such as "Passive Mobs".
    // The "Passive Mobs" subcategory, in turn, includes specific groups of sounds tied to a passive mob, such as "Cat Sounds".
    // Finally, the sound group "Cat Sounds" contains the actual sounds of a cat, such as "ENTITY_CAT_PURR".

    public static final Map<String, SoundCategory> CATEGORY_MAP = new HashMap<>();
    public static final Map<String, SoundData> SOUND_MAP = new HashMap<>();

    static {
        SoundCategory ALL_SOUNDS = new SoundCategory("All Sounds", null, List.of(
                // 1st SoundCategory
                // ENTITY SOUNDS:
                // 1. Passive Mob Sounds 2. Neutral Mob Sounds 3. Hostile Mob Sounds
                // 4. Player Sounds 5. Projectile Sounds 3. Other Entity Sounds
                new SoundCategory("Entity Sounds", Material.COW_SPAWN_EGG, List.of(
                        // **************************
                        // *** AQUATIC MOB SOUNDS ***
                        // **************************
                        new SoundCategory("Aquatic Mob Sounds", Material.PUFFERFISH_SPAWN_EGG, List.of(
                                new SoundData(Sound.ENTITY_FISH_SWIM, Material.COD),
                                // --- Salmon Sounds ---
                                new SoundCategory("Salmon Sounds", Material.SALMON_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SALMON_AMBIENT, Material.SALMON_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SALMON_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SALMON_FLOP, Material.SALMON_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SALMON_HURT, Material.RED_DYE)
                                )),
                                // --- Puffer Fish Sounds ---
                                new SoundCategory("Puffer Fish Sounds", Material.PUFFERFISH_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_PUFFER_FISH_AMBIENT, Material.PUFFERFISH_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PUFFER_FISH_BLOW_OUT, Material.PUFFERFISH_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PUFFER_FISH_BLOW_UP, Material.PUFFERFISH_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PUFFER_FISH_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_PUFFER_FISH_FLOP, Material.PUFFERFISH_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PUFFER_FISH_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_PUFFER_FISH_STING, Material.PUFFERFISH_SPAWN_EGG)
                                )),
                                // --- Cod Sounds ---
                                new SoundCategory("Cod Sounds", Material.COD_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_COD_AMBIENT, Material.COD_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_COD_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_COD_FLOP, Material.COD_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_COD_HURT, Material.RED_DYE)
                                )),
                                // --- Dolphin Sounds ---
                                new SoundCategory("Dolphin Sounds", Material.DOLPHIN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_DOLPHIN_AMBIENT, Material.DOLPHIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DOLPHIN_AMBIENT_WATER, Material.DOLPHIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DOLPHIN_ATTACK, Material.DOLPHIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DOLPHIN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_DOLPHIN_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_DOLPHIN_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_DOLPHIN_JUMP, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_DOLPHIN_PLAY, Material.DOLPHIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DOLPHIN_SPLASH, Material.DOLPHIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DOLPHIN_SWIM, Material.DOLPHIN_SPAWN_EGG)
                                )),
                                // --- Glow Squid Sounds ---
                                new SoundCategory("Glow Squid Sounds", Material.GLOW_SQUID_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_GLOW_SQUID_AMBIENT, Material.GLOW_SQUID_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GLOW_SQUID_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_GLOW_SQUID_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_GLOW_SQUID_SQUIRT, Material.GLOW_SQUID_SPAWN_EGG)
                                )),
                                // --- Guardian Sounds ---
                                new SoundCategory("Guardian Sounds", Material.GUARDIAN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_GUARDIAN_AMBIENT, Material.GUARDIAN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GUARDIAN_AMBIENT_LAND, Material.GUARDIAN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GUARDIAN_ATTACK, Material.GUARDIAN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GUARDIAN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_GUARDIAN_DEATH_LAND, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_GUARDIAN_FLOP, Material.GUARDIAN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GUARDIAN_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_GUARDIAN_HURT_LAND, Material.RED_DYE)
                                )),
                                // --- Elder Guardian Sounds ---
                                new SoundCategory("Elder Guardian Sounds", Material.ELDER_GUARDIAN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ELDER_GUARDIAN_AMBIENT, Material.ELDER_GUARDIAN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ELDER_GUARDIAN_AMBIENT_LAND, Material.SAND),
                                        new SoundData(Sound.ENTITY_ELDER_GUARDIAN_CURSE, Material.PRISMARINE_CRYSTALS),
                                        new SoundData(Sound.ENTITY_ELDER_GUARDIAN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ELDER_GUARDIAN_DEATH_LAND, Material.RED_TERRACOTTA),
                                        new SoundData(Sound.ENTITY_ELDER_GUARDIAN_FLOP, Material.SLIME_BLOCK),
                                        new SoundData(Sound.ENTITY_ELDER_GUARDIAN_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ELDER_GUARDIAN_HURT_LAND, Material.BRICKS)
                                )),
                                // --- Strider Sounds ---
                                new SoundCategory("Strider Sounds", Material.STRIDER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_STRIDER_AMBIENT, Material.STRIDER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_STRIDER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_STRIDER_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_STRIDER_HAPPY, Material.SUNFLOWER),
                                        new SoundData(Sound.ENTITY_STRIDER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_STRIDER_RETREAT, Material.OAK_DOOR),
                                        new SoundData(Sound.ENTITY_STRIDER_SADDLE, Material.SADDLE),
                                        new SoundData(Sound.ENTITY_STRIDER_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_STRIDER_STEP_LAVA, Material.LAVA_BUCKET)
                                )),
                                // --- Squid Sounds ---
                                new SoundCategory("Squid Sounds", Material.SQUID_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SQUID_AMBIENT, Material.SQUID_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SQUID_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SQUID_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SQUID_SQUIRT, Material.INK_SAC)
                                )),
                                // --- Tropical Fish Sounds ---
                                new SoundCategory("Tropical Fish Sounds", Material.TROPICAL_FISH_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_TROPICAL_FISH_AMBIENT, Material.TROPICAL_FISH_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TROPICAL_FISH_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_TROPICAL_FISH_FLOP, Material.TROPICAL_FISH_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TROPICAL_FISH_HURT, Material.RED_DYE)
                                )),
                                // --- Turtle Sounds ---
                                new SoundCategory("Turtle Sounds", Material.TURTLE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_TURTLE_AMBIENT_LAND, Material.TURTLE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TURTLE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_TURTLE_DEATH_BABY, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_TURTLE_EGG_BREAK, Material.TURTLE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TURTLE_EGG_CRACK, Material.TURTLE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TURTLE_EGG_HATCH, Material.TURTLE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TURTLE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_TURTLE_HURT_BABY, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_TURTLE_LAY_EGG, Material.TURTLE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TURTLE_SHAMBLE, Material.TURTLE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TURTLE_SHAMBLE_BABY, Material.TURTLE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TURTLE_SWIM, Material.TURTLE_SPAWN_EGG)
                                )),
                                // --- Tadpole Sounds ---
                                new SoundCategory("Tadpole Sounds", Material.TADPOLE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_TADPOLE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_TADPOLE_FLOP, Material.TADPOLE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TADPOLE_GROW_UP, Material.TADPOLE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_TADPOLE_HURT, Material.RED_DYE)
                                )),
                                // --- Axolotl Sounds ---
                                new SoundCategory("Axolotl Sounds", Material.AXOLOTL_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_AXOLOTL_ATTACK, Material.AXOLOTL_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_AXOLOTL_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_AXOLOTL_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_AXOLOTL_IDLE_AIR, Material.AXOLOTL_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_AXOLOTL_IDLE_WATER, Material.AXOLOTL_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_AXOLOTL_SPLASH, Material.AXOLOTL_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_AXOLOTL_SWIM, Material.AXOLOTL_SPAWN_EGG),
                                        new SoundData(Sound.ITEM_BUCKET_FILL_AXOLOTL, Material.AXOLOTL_SPAWN_EGG)
                                ))

                        )),
                        // ****************************
                        // *** ARTHROPOD MOB SOUNDS ***
                        // ****************************
                        new SoundCategory("Arthropod Sounds", Material.SPIDER_SPAWN_EGG, List.of(
                                // --- Endermite Sounds ---
                                new SoundCategory("Endermite Sounds", Material.ENDERMITE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ENDERMITE_AMBIENT, Material.ENDERMITE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ENDERMITE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ENDERMITE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ENDERMITE_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Silverfish Sounds ---
                                new SoundCategory("Silverfish Sounds", Material.SILVERFISH_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SILVERFISH_AMBIENT, Material.SILVERFISH_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SILVERFISH_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SILVERFISH_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SILVERFISH_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Bee Sounds ---
                                new SoundCategory("Bee Sounds", Material.BEE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_BEE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_BEE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_BEE_LOOP, Material.BEE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BEE_LOOP_AGGRESSIVE, Material.BEE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BEE_POLLINATE, Material.BEE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BEE_STING, Material.BEE_SPAWN_EGG)
                                )),
                                // --- Spider Sounds ---
                                new SoundCategory("Spider Sounds", Material.SPIDER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SPIDER_AMBIENT, Material.SPIDER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SPIDER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SPIDER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SPIDER_STEP, Material.LEATHER_BOOTS)
                                ))
                        )),
                        // **************************
                        // *** ILLAGER MOB SOUNDS ***
                        // **************************
                        new SoundCategory("Illager Sounds", Material.PILLAGER_SPAWN_EGG, List.of(
                                // --- Illusioner Sounds ---
                                new SoundCategory("Illusioner Sounds", Material.PILLAGER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ILLUSIONER_AMBIENT, Material.PILLAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ILLUSIONER_CAST_SPELL, Material.PILLAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ILLUSIONER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_PILLAGER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, Material.PILLAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ILLUSIONER_PREPARE_BLINDNESS, Material.PILLAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ILLUSIONER_PREPARE_MIRROR, Material.PILLAGER_SPAWN_EGG)
                                )),
                                // --- Pillager Sounds ---
                                new SoundCategory("Pillager Sounds", Material.PILLAGER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_PILLAGER_AMBIENT, Material.PILLAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PILLAGER_CELEBRATE, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_PILLAGER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_PILLAGER_HURT, Material.RED_DYE)
                                )),
                                // --- Evoker Sounds ---
                                new SoundCategory("Evoker Sounds", Material.EVOKER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_EVOKER_AMBIENT, Material.EVOKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_EVOKER_CELEBRATE, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_EVOKER_CAST_SPELL, Material.EVOKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_EVOKER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_EVOKER_FANGS_ATTACK, Material.EVOKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_EVOKER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_EVOKER_PREPARE_ATTACK, Material.EVOKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_EVOKER_PREPARE_SUMMON, Material.EVOKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_EVOKER_PREPARE_WOLOLO, Material.EVOKER_SPAWN_EGG)
                                )),
                                // --- Vindicator Sounds ---
                                new SoundCategory("Vindicator Sounds", Material.VINDICATOR_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_VINDICATOR_AMBIENT, Material.VINDICATOR_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_VINDICATOR_CELEBRATE, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_VINDICATOR_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_VINDICATOR_HURT, Material.RED_DYE)
                                ))
                        )),
                        // *************************
                        // *** UNDEAD MOB SOUNDS ***
                        // *************************
                        new SoundCategory("Undead Mob Sounds", Material.ZOMBIE_SPAWN_EGG, List.of(
                                // --- Skeleton Sounds ---
                                new SoundCategory("Skeleton Sounds", Material.SKELETON_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SKELETON_AMBIENT, Material.SKELETON_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SKELETON_CONVERTED_TO_STRAY, Material.STRAY_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SKELETON_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SKELETON_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SKELETON_SHOOT, Material.BOW),
                                        new SoundData(Sound.ENTITY_SKELETON_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Skeleton Horse Sounds ---
                                new SoundCategory("Skeleton Horse Sounds", Material.SKELETON_HORSE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SKELETON_HORSE_AMBIENT, Material.SKELETON_HORSE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SKELETON_HORSE_AMBIENT_WATER, Material.SKELETON_HORSE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SKELETON_HORSE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SKELETON_HORSE_GALLOP_WATER, Material.SKELETON_HORSE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SKELETON_HORSE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SKELETON_HORSE_JUMP_WATER, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_SKELETON_HORSE_STEP_WATER, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_SKELETON_HORSE_SWIM, Material.SKELETON_HORSE_SPAWN_EGG)
                                )),
                                // --- Husk Sounds ---
                                new SoundCategory("Husk Sounds", Material.HUSK_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_HUSK_AMBIENT, Material.HUSK_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HUSK_CONVERTED_TO_ZOMBIE, Material.ZOMBIE_HEAD),
                                        new SoundData(Sound.ENTITY_HUSK_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_HUSK_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_HUSK_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Bogged Sounds ---
                                new SoundCategory("Bogged Sounds", Material.BOGGED_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_BOGGED_AMBIENT, Material.BOGGED_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BOGGED_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_BOGGED_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_BOGGED_SHEAR, Material.SHEARS),
                                        new SoundData(Sound.ENTITY_BOGGED_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Drowned Sounds ---
                                new SoundCategory("Drowned Sounds", Material.DROWNED_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_DROWNED_AMBIENT, Material.DROWNED_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DROWNED_AMBIENT_WATER, Material.DROWNED_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DROWNED_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_DROWNED_DEATH_WATER, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_DROWNED_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_DROWNED_HURT_WATER, Material.DROWNED_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DROWNED_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_DROWNED_SHOOT, Material.DROWNED_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DROWNED_SWIM, Material.DROWNED_SPAWN_EGG)
                                )),
                                // --- Wither Sounds ---
                                new SoundCategory("Wither Sounds", Material.WITHER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_WITHER_AMBIENT, Material.WITHER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WITHER_BREAK_BLOCK, Material.WITHER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WITHER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_WITHER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_WITHER_SHOOT, Material.WITHER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WITHER_SPAWN, Material.WITHER_SPAWN_EGG)
                                )),
                                // --- Wither Skeleton Sounds ---
                                new SoundCategory("Wither Skeleton Sounds", Material.WITHER_SKELETON_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_WITHER_SKELETON_AMBIENT, Material.WITHER_SKELETON_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WITHER_SKELETON_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_WITHER_SKELETON_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_WITHER_SKELETON_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Zoglin Sounds ---
                                new SoundCategory("Zoglin Sounds", Material.ZOGLIN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ZOGLIN_AMBIENT, Material.ZOGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ZOGLIN_ANGRY, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ZOGLIN_ATTACK, Material.ZOGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ZOGLIN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ZOGLIN_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ZOGLIN_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Zombie Sounds ---
                                new SoundCategory("Zombie Sounds", Material.ZOMBIE_HEAD, List.of(
                                        new SoundData(Sound.ENTITY_ZOMBIE_AMBIENT, Material.ZOMBIE_HEAD),
                                        new SoundData(Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, Material.IRON_DOOR),
                                        new SoundData(Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, Material.OAK_DOOR),
                                        new SoundData(Sound.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, Material.OAK_DOOR),
                                        new SoundData(Sound.ENTITY_ZOMBIE_CONVERTED_TO_DROWNED, Material.DROWNED_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ZOMBIE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ZOMBIE_DESTROY_EGG, Material.ZOMBIE_HEAD),
                                        new SoundData(Sound.ENTITY_ZOMBIE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ZOMBIE_INFECT, Material.ZOMBIE_HEAD),
                                        new SoundData(Sound.ENTITY_ZOMBIE_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Zombie Horse Sounds ---
                                new SoundCategory("Zombie Horse Sounds", Material.ZOMBIE_HORSE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ZOMBIE_HORSE_AMBIENT, Material.ZOMBIE_HORSE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ZOMBIE_HORSE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ZOMBIE_HORSE_HURT, Material.RED_DYE)
                                )),
                                // --- Zombie Villager Sounds ---
                                new SoundCategory("Zombie Villager Sounds", Material.ZOMBIE_VILLAGER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ZOMBIE_VILLAGER_AMBIENT, Material.ZOMBIE_VILLAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, Material.ZOMBIE_VILLAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ZOMBIE_VILLAGER_CURE, Material.GOLDEN_APPLE),
                                        new SoundData(Sound.ENTITY_ZOMBIE_VILLAGER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ZOMBIE_VILLAGER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ZOMBIE_VILLAGER_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Zombified Piglin Sounds ---
                                new SoundCategory("Zombified Piglin Sounds", Material.ZOMBIFIED_PIGLIN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ZOMBIFIED_PIGLIN_AMBIENT, Material.ZOMBIFIED_PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ZOMBIFIED_PIGLIN_ANGRY, Material.ZOMBIFIED_PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ZOMBIFIED_PIGLIN_HURT, Material.RED_DYE)
                                )),
                                // --- Stray Sounds ---
                                new SoundCategory("Stray Sounds", Material.STRAY_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_STRAY_AMBIENT, Material.STRAY_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_STRAY_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_STRAY_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_STRAY_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Phantom Sounds ---
                                new SoundCategory("Phantom Sounds", Material.PHANTOM_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_PHANTOM_AMBIENT, Material.PHANTOM_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PHANTOM_BITE, Material.PHANTOM_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PHANTOM_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_PHANTOM_FLAP, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_PHANTOM_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_PHANTOM_SWOOP, Material.PHANTOM_SPAWN_EGG)
                                ))
                        )),
                        // **************************
                        // *** Passive Mob Sounds ***
                        // **************************
                        new SoundCategory("Passive Mob Sounds", Material.COW_SPAWN_EGG, List.of(
                                // --- Villager Sounds ---
                                new SoundCategory("Villager Sounds", Material.VILLAGER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_VILLAGER_AMBIENT, Material.VILLAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_VILLAGER_CELEBRATE, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_VILLAGER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_VILLAGER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_VILLAGER_NO, Material.RED_CONCRETE),
                                        new SoundData(Sound.ENTITY_VILLAGER_TRADE, Material.EMERALD),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_ARMORER, Material.BLAST_FURNACE),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_BUTCHER, Material.SMOKER),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_CARTOGRAPHER, Material.CARTOGRAPHY_TABLE),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_CLERIC, Material.BREWING_STAND),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_FARMER, Material.COMPOSTER),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_FISHERMAN, Material.BARREL),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_FLETCHER, Material.FLETCHING_TABLE),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_LEATHERWORKER, Material.CAULDRON),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_LIBRARIAN, Material.LECTERN),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_MASON, Material.STONECUTTER),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_SHEPHERD, Material.LOOM),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_TOOLSMITH, Material.SMITHING_TABLE),
                                        new SoundData(Sound.ENTITY_VILLAGER_WORK_WEAPONSMITH, Material.GRINDSTONE),
                                        new SoundData(Sound.ENTITY_VILLAGER_YES, Material.GREEN_CONCRETE)
                                )),
                                // --- Wandering Trader Sounds ---
                                new SoundCategory("Wandering Trader Sounds", Material.WANDERING_TRADER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_AMBIENT, Material.WANDERING_TRADER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_DISAPPEARED, Material.LEVER),
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_DRINK_MILK, Material.MILK_BUCKET),
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_DRINK_POTION, Material.POTION),
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_NO, Material.RED_CONCRETE),
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_REAPPEARED, Material.TORCH),
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_TRADE, Material.EMERALD),
                                        new SoundData(Sound.ENTITY_WANDERING_TRADER_YES, Material.GREEN_CONCRETE)
                                )),
                                // --- Sheep Sounds ---
                                new SoundCategory("Sheep Sounds", Material.SHEEP_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SHEEP_AMBIENT, Material.SHEEP_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SHEEP_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SHEEP_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SHEEP_SHEAR, Material.SHEARS),
                                        new SoundData(Sound.ENTITY_SHEEP_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Sniffer Sounds ---
                                new SoundCategory("Sniffer Sounds", Material.SNIFFER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SNIFFER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SNIFFER_DIGGING, Material.WOODEN_SHOVEL),
                                        new SoundData(Sound.ENTITY_SNIFFER_DIGGING_STOP, Material.WOODEN_SHOVEL),
                                        new SoundData(Sound.ENTITY_SNIFFER_DROP_SEED, Material.WHEAT_SEEDS),
                                        new SoundData(Sound.ENTITY_SNIFFER_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_SNIFFER_HAPPY, Material.SUNFLOWER),
                                        new SoundData(Sound.ENTITY_SNIFFER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SNIFFER_IDLE, Material.SNIFFER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SNIFFER_SCENTING, Material.POPPY),
                                        new SoundData(Sound.ENTITY_SNIFFER_SEARCHING, Material.SPYGLASS),
                                        new SoundData(Sound.ENTITY_SNIFFER_SNIFFING, Material.POPPY),
                                        new SoundData(Sound.ENTITY_SNIFFER_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Snow Golem Sounds ---
                                new SoundCategory("Snow Golem Sounds", Material.SNOW_GOLEM_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SNOW_GOLEM_AMBIENT, Material.SNOW_GOLEM_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SNOW_GOLEM_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SNOW_GOLEM_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SNOW_GOLEM_SHEAR, Material.SHEARS),
                                        new SoundData(Sound.ENTITY_SNOW_GOLEM_SHOOT, Material.SNOWBALL)
                                )),
                                // --- Pig Sounds ---
                                new SoundCategory("Pig Sounds", Material.PIG_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_PIG_AMBIENT, Material.PIG_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PIG_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_PIG_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_PIG_SADDLE, Material.SADDLE),
                                        new SoundData(Sound.ENTITY_PIG_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Polar Bear Sounds ---
                                new SoundCategory("Polar Bear Sounds", Material.POLAR_BEAR_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_POLAR_BEAR_AMBIENT, Material.POLAR_BEAR_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_POLAR_BEAR_AMBIENT_BABY, Material.POLAR_BEAR_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_POLAR_BEAR_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_POLAR_BEAR_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_POLAR_BEAR_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_POLAR_BEAR_WARNING, Material.POLAR_BEAR_SPAWN_EGG)
                                )),
                                // --- Rabbit Sounds ---
                                new SoundCategory("Rabbit Sounds", Material.RABBIT_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_RABBIT_ATTACK, Material.RABBIT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_RABBIT_AMBIENT, Material.RABBIT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_RABBIT_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_RABBIT_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_RABBIT_JUMP, Material.FEATHER)
                                )),
                                // --- Mooshroom Sounds ---
                                new SoundCategory("Mooshroom Sounds", Material.MOOSHROOM_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_MOOSHROOM_CONVERT, Material.MOOSHROOM_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_MOOSHROOM_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_MOOSHROOM_MILK, Material.MILK_BUCKET),
                                        new SoundData(Sound.ENTITY_MOOSHROOM_SHEAR, Material.SHEARS),
                                        new SoundData(Sound.ENTITY_MOOSHROOM_SUSPICIOUS_MILK, Material.SUSPICIOUS_STEW)
                                )),
                                // --- Mule Sounds ---
                                new SoundCategory("Mule Sounds", Material.MULE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_MULE_AMBIENT, Material.MULE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_MULE_ANGRY, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_MULE_CHEST, Material.CHEST),
                                        new SoundData(Sound.ENTITY_MULE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_MULE_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_MULE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_MULE_JUMP, Material.FEATHER)
                                )),
                                // --- Ocelot Sounds ---
                                new SoundCategory("Ocelot Sounds", Material.OCELOT_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_OCELOT_AMBIENT, Material.OCELOT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_OCELOT_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_OCELOT_HURT, Material.RED_DYE)
                                )),
                                // --- Parrot Sounds ---
                                new SoundCategory("Parrot Sounds", Material.PARROT_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_PARROT_AMBIENT, Material.PARROT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PARROT_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_PARROT_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_PARROT_FLY, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_PARROT_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_PARROT_STEP, Material.LEATHER_BOOTS),
                                        // --- Parrot Imitation Sounds --- (Subsection)
                                        new SoundCategory("Parrot Imitation Sounds", Material.PARROT_SPAWN_EGG, List.of(
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_BLAZE, Material.BLAZE_POWDER),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_BOGGED, Material.PODZOL),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_BREEZE, Material.BREEZE_ROD),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_CREAKING, Material.CREAKING_HEART),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_CREEPER, Material.CREEPER_HEAD),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_DROWNED, Material.TRIDENT),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_ELDER_GUARDIAN, Material.DARK_PRISMARINE),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_ENDERMITE, Material.END_STONE_BRICK_SLAB),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_ENDER_DRAGON, Material.DRAGON_HEAD),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_EVOKER, Material.EVOKER_SPAWN_EGG),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_GHAST, Material.GHAST_TEAR),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_GUARDIAN, Material.PRISMARINE),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_HOGLIN, Material.HOGLIN_SPAWN_EGG),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_HUSK, Material.HUSK_SPAWN_EGG),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_ILLUSIONER, Material.ENCHANTED_BOOK),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_MAGMA_CUBE, Material.MAGMA_CREAM),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_PHANTOM, Material.PHANTOM_MEMBRANE),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_PIGLIN, Material.PIGLIN_HEAD),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_PIGLIN_BRUTE, Material.NETHERITE_INGOT),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_PILLAGER, Material.CROSSBOW),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_RAVAGER, Material.SADDLE),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_SHULKER, Material.SHULKER_SHELL),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_SILVERFISH, Material.SILVERFISH_SPAWN_EGG),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_SKELETON, Material.BONE),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_SLIME, Material.SLIME_BALL),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_SPIDER, Material.STRING),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_STRAY, Material.SNOWBALL),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_VEX, Material.IRON_SWORD),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_VINDICATOR, Material.IRON_AXE),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_WARDEN, Material.WARDEN_SPAWN_EGG),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_WITCH, Material.GLOWSTONE),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_WITHER, Material.WITHER_ROSE),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_WITHER_SKELETON, Material.WITHER_SKELETON_SKULL),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_ZOGLIN, Material.ROTTEN_FLESH),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_ZOMBIE, Material.ZOMBIE_HEAD),
                                                new SoundData(Sound.ENTITY_PARROT_IMITATE_ZOMBIE_VILLAGER, Material.ROTTEN_FLESH)
                                        ))
                                )),
                                // --- Goat Sounds ---
                                new SoundCategory("Goat Sounds", Material.GOAT_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_GOAT_AMBIENT, Material.GOAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GOAT_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_GOAT_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_GOAT_HORN_BREAK, Material.GOAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GOAT_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_GOAT_LONG_JUMP, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_GOAT_MILK, Material.MILK_BUCKET),
                                        new SoundData(Sound.ENTITY_GOAT_PREPARE_RAM, Material.PISTON),
                                        new SoundData(Sound.ENTITY_GOAT_RAM_IMPACT, Material.IRON_BLOCK),
                                        new SoundData(Sound.ENTITY_GOAT_SCREAMING_AMBIENT, Material.GOAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GOAT_SCREAMING_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_GOAT_SCREAMING_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_GOAT_SCREAMING_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_GOAT_SCREAMING_LONG_JUMP, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_GOAT_SCREAMING_MILK, Material.MILK_BUCKET),
                                        new SoundData(Sound.ENTITY_GOAT_SCREAMING_PREPARE_RAM, Material.PISTON),
                                        new SoundData(Sound.ENTITY_GOAT_SCREAMING_RAM_IMPACT, Material.IRON_BLOCK),
                                        new SoundData(Sound.ENTITY_GOAT_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Horse Sounds ---
                                new SoundCategory("Horse Sounds", Material.HORSE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_HORSE_AMBIENT, Material.HORSE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HORSE_ANGRY, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_HORSE_ARMOR, Material.HORSE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HORSE_BREATHE, Material.HORSE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HORSE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_HORSE_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_HORSE_GALLOP, Material.HORSE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HORSE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_HORSE_JUMP, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_HORSE_LAND, Material.HORSE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HORSE_SADDLE, Material.SADDLE),
                                        new SoundData(Sound.ENTITY_HORSE_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_HORSE_STEP_WOOD, Material.OAK_PLANKS)
                                )),
                                // --- Fox Sounds ---
                                new SoundCategory("Fox Sounds", Material.FOX_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_FOX_AMBIENT, Material.FOX_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_FOX_AGGRO, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_FOX_BITE, Material.CHICKEN),
                                        new SoundData(Sound.ENTITY_FOX_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_FOX_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_FOX_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_FOX_SCREECH, Material.FOX_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_FOX_SLEEP, Material.RED_BED),
                                        new SoundData(Sound.ENTITY_FOX_SNIFF, Material.FOX_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_FOX_SPIT, Material.FOX_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_FOX_TELEPORT, Material.ENDER_PEARL)
                                )),
                                // --- Frog Sounds ---
                                new SoundCategory("Frog Sounds", Material.FROG_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_FROG_AMBIENT, Material.FROG_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_FROG_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_FROG_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_FROG_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_FROG_LAY_SPAWN, Material.FROG_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_FROG_LONG_JUMP, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_FROG_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_FROG_TONGUE, Material.FROG_SPAWN_EGG)
                                )),
                                // --- Allay Sounds ---
                                new SoundCategory("Allay Sounds", Material.ALLAY_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM, Material.ALLAY_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ALLAY_AMBIENT_WITH_ITEM, Material.ALLAY_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ALLAY_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ALLAY_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ALLAY_ITEM_GIVEN, Material.ALLAY_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ALLAY_ITEM_TAKEN, Material.ALLAY_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ALLAY_ITEM_THROWN, Material.ALLAY_SPAWN_EGG)
                                )),

                                // --- Bat Sounds ---
                                new SoundCategory("Bat Sounds", Material.BAT_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_BAT_AMBIENT, Material.BAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BAT_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_BAT_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_BAT_LOOP, Material.BAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BAT_TAKEOFF, Material.BAT_SPAWN_EGG)
                                )),
                                // --- Camel Sounds ---
                                new SoundCategory("Camel Sounds", Material.CAMEL_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_CAMEL_AMBIENT, Material.CAMEL_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAMEL_DASH, Material.CAMEL_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAMEL_DASH_READY, Material.CAMEL_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAMEL_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_CAMEL_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_CAMEL_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_CAMEL_SADDLE, Material.SADDLE),
                                        new SoundData(Sound.ENTITY_CAMEL_SIT, Material.CAMEL_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAMEL_STAND, Material.CAMEL_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAMEL_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_CAMEL_STEP_SAND, Material.LEATHER_BOOTS)
                                )),
                                // --- Cat Sounds ---
                                new SoundCategory("Cat Sounds", Material.CAT_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_CAT_AMBIENT, Material.CAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAT_BEG_FOR_FOOD, Material.CAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAT_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_CAT_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_CAT_HISS, Material.CAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAT_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_CAT_PURR, Material.CAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAT_PURREOW, Material.CAT_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CAT_STRAY_AMBIENT, Material.CAT_SPAWN_EGG)
                                )),
                                // --- Chicken Sounds ---
                                new SoundCategory("Chicken Sounds", Material.CHICKEN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_CHICKEN_AMBIENT, Material.CHICKEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CHICKEN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_CHICKEN_EGG, Material.EGG),
                                        new SoundData(Sound.ENTITY_CHICKEN_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_CHICKEN_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Cow Sounds ---
                                new SoundCategory("Cow Sounds", Material.COW_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_COW_AMBIENT, Material.COW_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_COW_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_COW_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_COW_MILK, Material.MILK_BUCKET),
                                        new SoundData(Sound.ENTITY_COW_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Donkey Sounds ---
                                new SoundCategory("Donkey Sounds", Material.DONKEY_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_DONKEY_AMBIENT, Material.DONKEY_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DONKEY_ANGRY, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_DONKEY_CHEST, Material.DONKEY_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_DONKEY_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_DONKEY_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_DONKEY_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_DONKEY_JUMP, Material.FEATHER)
                                ))
                        )),
                        // **************************
                        // *** NEUTRAL MOB SOUNDS ***
                        // **************************
                        new SoundCategory("Neutral Mob Sounds", Material.PANDA_SPAWN_EGG, List.of(
                                // --- Wolf Sounds ---
                                new SoundCategory("Wolf Sounds", Material.WOLF_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_WOLF_AMBIENT, Material.WOLF_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WOLF_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_WOLF_GROWL, Material.BONE),
                                        new SoundData(Sound.ENTITY_WOLF_HOWL, Material.WOLF_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WOLF_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_WOLF_PANT, Material.WOLF_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WOLF_SHAKE, Material.WOLF_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WOLF_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_WOLF_WHINE, Material.WOLF_SPAWN_EGG),
                                        new SoundData(Sound.ITEM_ARMOR_EQUIP_WOLF, Material.WOLF_ARMOR),
                                        new SoundData(Sound.ITEM_ARMOR_UNEQUIP_WOLF, Material.WOLF_ARMOR),
                                        new SoundData(Sound.ITEM_WOLF_ARMOR_BREAK, Material.WOLF_ARMOR),
                                        new SoundData(Sound.ITEM_WOLF_ARMOR_CRACK, Material.WOLF_ARMOR),
                                        new SoundData(Sound.ITEM_WOLF_ARMOR_DAMAGE, Material.WOLF_ARMOR),
                                        new SoundData(Sound.ITEM_WOLF_ARMOR_REPAIR, Material.WOLF_ARMOR)
                                )),
                                // --- Panda Sounds ---
                                new SoundCategory("Panda Sounds", Material.PANDA_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_PANDA_AGGRESSIVE_AMBIENT, Material.PANDA_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PANDA_AMBIENT, Material.PANDA_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PANDA_BITE, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_PANDA_CANT_BREED, Material.PANDA_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PANDA_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_PANDA_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_PANDA_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_PANDA_PRE_SNEEZE, Material.PANDA_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PANDA_SNEEZE, Material.PANDA_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PANDA_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_PANDA_WORRIED_AMBIENT, Material.PANDA_SPAWN_EGG)
                                )),
                                // --- Enderman Sounds ---
                                new SoundCategory("Enderman Sounds", Material.ENDERMAN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ENDERMAN_AMBIENT, Material.ENDERMAN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ENDERMAN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ENDERMAN_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ENDERMAN_SCREAM, Material.ENDERMAN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ENDERMAN_STARE, Material.ENDERMAN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ENDERMAN_TELEPORT, Material.ENDERMAN_SPAWN_EGG)
                                )),
                                // --- Iron Golem Sounds ---
                                new SoundCategory("Iron Golem Sounds", Material.IRON_GOLEM_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_IRON_GOLEM_ATTACK, Material.IRON_GOLEM_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_IRON_GOLEM_DAMAGE, Material.IRON_GOLEM_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_IRON_GOLEM_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_IRON_GOLEM_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_IRON_GOLEM_REPAIR, Material.IRON_GOLEM_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_IRON_GOLEM_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Llama Sounds ---
                                new SoundCategory("Llama Sounds", Material.LLAMA_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_LLAMA_AMBIENT, Material.LLAMA_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_LLAMA_ANGRY, Material.LLAMA_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_LLAMA_CHEST, Material.LLAMA_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_LLAMA_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_LLAMA_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_LLAMA_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_LLAMA_SPIT, Material.LLAMA_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_LLAMA_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_LLAMA_SWAG, Material.CAMPFIRE)
                                )),
                                // --- Armadillo Sounds ---
                                new SoundCategory("Armadillo Sounds", Material.ARMADILLO_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_ARMADILLO_AMBIENT, Material.ARMADILLO_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ARMADILLO_BRUSH, Material.ARMADILLO_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ARMADILLO_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_ARMADILLO_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_ARMADILLO_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ARMADILLO_HURT_REDUCED, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_ARMADILLO_LAND, Material.ARMADILLO_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ARMADILLO_PEEK, Material.SPYGLASS),
                                        new SoundData(Sound.ENTITY_ARMADILLO_ROLL, Material.SLIME_BLOCK),
                                        new SoundData(Sound.ENTITY_ARMADILLO_SCUTE_DROP, Material.ARMADILLO_SCUTE),
                                        new SoundData(Sound.ENTITY_ARMADILLO_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_ARMADILLO_UNROLL_FINISH, Material.ARMADILLO_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_ARMADILLO_UNROLL_START, Material.ARMADILLO_SPAWN_EGG)
                                ))
                        )),
                        // **************************
                        // *** HOSTILE MOB SOUNDS ***
                        // **************************
                        new SoundCategory("Hostile Mob Sounds", Material.ZOMBIE_SPAWN_EGG, List.of(
                                // --- Warden Sounds ---
                                new SoundCategory("Warden Sounds", Material.WARDEN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_WARDEN_AGITATED, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_AMBIENT, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_ANGRY, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_ATTACK_IMPACT, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_WARDEN_DIG, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_EMERGE, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_HEARTBEAT, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_WARDEN_LISTENING, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_LISTENING_ANGRY, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_NEARBY_CLOSE, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_NEARBY_CLOSER, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_NEARBY_CLOSEST, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_ROAR, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_SNIFF, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_SONIC_BOOM, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_SONIC_CHARGE, Material.WARDEN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WARDEN_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_WARDEN_TENDRIL_CLICKS, Material.WARDEN_SPAWN_EGG)
                                )),
                                // --- Witch Sounds ---
                                new SoundCategory("Witch Sounds", Material.WITCH_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_WITCH_AMBIENT, Material.WITCH_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WITCH_CELEBRATE, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_WITCH_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_WITCH_DRINK, Material.WITCH_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_WITCH_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_WITCH_THROW, Material.WITCH_SPAWN_EGG)
                                )),
                                // --- Vex Sounds ---
                                new SoundCategory("Vex Sounds", Material.VEX_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_VEX_AMBIENT, Material.VEX_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_VEX_CHARGE, Material.VEX_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_VEX_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_VEX_HURT, Material.RED_DYE)
                                )),
                                // --- Shulker Sounds ---
                                new SoundCategory("Shulker Sounds", Material.SHULKER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SHULKER_AMBIENT, Material.SHULKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SHULKER_BULLET_HIT, Material.SHULKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SHULKER_BULLET_HURT, Material.SHULKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SHULKER_CLOSE, Material.SHULKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SHULKER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SHULKER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SHULKER_HURT_CLOSED, Material.SHULKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SHULKER_OPEN, Material.SHULKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SHULKER_SHOOT, Material.SHULKER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SHULKER_TELEPORT, Material.SHULKER_SPAWN_EGG)
                                )),
                                // --- Slime Sounds ---
                                new SoundCategory("Slime Sounds", Material.SLIME_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_SLIME_ATTACK, Material.SLIME_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SLIME_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SLIME_DEATH_SMALL, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_SLIME_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SLIME_HURT_SMALL, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_SLIME_JUMP, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_SLIME_JUMP_SMALL, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_SLIME_SQUISH, Material.SLIME_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_SLIME_SQUISH_SMALL, Material.SLIME_SPAWN_EGG)
                                )),
                                // --- Piglin Sounds ---
                                new SoundCategory("Piglin Sounds", Material.PIGLIN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_PIGLIN_ADMIRING_ITEM, Material.PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PIGLIN_AMBIENT, Material.PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PIGLIN_ANGRY, Material.PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PIGLIN_CELEBRATE, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_PIGLIN_CONVERTED_TO_ZOMBIFIED, Material.ZOMBIFIED_PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PIGLIN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_PIGLIN_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_PIGLIN_JEALOUS, Material.PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PIGLIN_RETREAT, Material.PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PIGLIN_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Piglin Brute Sounds ---
                                new SoundCategory("Piglin Brute Sounds", Material.PIGLIN_BRUTE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_PIGLIN_BRUTE_AMBIENT, Material.PIGLIN_BRUTE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PIGLIN_BRUTE_ANGRY, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_PIGLIN_BRUTE_CONVERTED_TO_ZOMBIFIED, Material.ZOMBIFIED_PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_PIGLIN_BRUTE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_PIGLIN_BRUTE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_PIGLIN_BRUTE_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Ravager Sounds ---
                                new SoundCategory("Ravager Sounds", Material.RAVAGER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_RAVAGER_AMBIENT, Material.RAVAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_RAVAGER_ATTACK, Material.RAVAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_RAVAGER_CELEBRATE, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_RAVAGER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_RAVAGER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_RAVAGER_ROAR, Material.RAVAGER_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_RAVAGER_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_RAVAGER_STUNNED, Material.RAVAGER_SPAWN_EGG)
                                )),
                                // --- Hoglin Sounds ---
                                new SoundCategory("Hoglin Sounds", Material.HOGLIN_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_HOGLIN_AMBIENT, Material.HOGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HOGLIN_ANGRY, Material.HOGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HOGLIN_ATTACK, Material.HOGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HOGLIN_CONVERTED_TO_ZOMBIFIED, Material.ZOMBIFIED_PIGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HOGLIN_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_HOGLIN_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_HOGLIN_RETREAT, Material.HOGLIN_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_HOGLIN_STEP, Material.LEATHER_BOOTS)
                                )),
                                // --- Ghast Sounds ---
                                new SoundCategory("Ghast Sounds", Material.GHAST_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_GHAST_AMBIENT, Material.GHAST_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GHAST_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_GHAST_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_GHAST_SCREAM, Material.GHAST_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GHAST_SHOOT, Material.GHAST_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_GHAST_WARN, Material.GHAST_SPAWN_EGG)
                                )),
                                // --- Blaze Sounds ---
                                new SoundCategory("Blaze Sounds", Material.BLAZE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_BLAZE_AMBIENT, Material.BLAZE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BLAZE_BURN, Material.BLAZE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BLAZE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_BLAZE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_BLAZE_SHOOT, Material.BLAZE_SPAWN_EGG)
                                )),
                                // --- Breeze Sounds ---
                                new SoundCategory("Breeze Sounds", Material.BREEZE_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_BREEZE_CHARGE, Material.BREEZE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BREEZE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_BREEZE_DEFLECT, Material.BREEZE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BREEZE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_BREEZE_IDLE_AIR, Material.BREEZE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BREEZE_IDLE_GROUND, Material.BREEZE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BREEZE_INHALE, Material.BREEZE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BREEZE_JUMP, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_BREEZE_LAND, Material.BREEZE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BREEZE_SHOOT, Material.BREEZE_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_BREEZE_SLIDE, Material.BREEZE_SPAWN_EGG)
                                )),
                                // --- Creeper Sounds ---
                                new SoundCategory("Creeper Sounds", Material.CREEPER_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_CREEPER_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_CREEPER_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_CREEPER_PRIMED, Material.CREEPER_SPAWN_EGG)
                                )),
                                // --- Creaking Sounds ---
                                new SoundCategory("Creaking Sounds", Material.CREAKING_SPAWN_EGG, List.of(
                                        new SoundData(Sound.ENTITY_CREAKING_ACTIVATE, Material.CREAKING_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CREAKING_AMBIENT, Material.CREAKING_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CREAKING_ATTACK, Material.CREAKING_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CREAKING_DEACTIVATE, Material.CREAKING_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CREAKING_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_CREAKING_FREEZE, Material.CREAKING_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CREAKING_SPAWN, Material.CREAKING_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CREAKING_STEP, Material.LEATHER_BOOTS),
                                        new SoundData(Sound.ENTITY_CREAKING_SWAY, Material.CREAKING_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CREAKING_TWITCH, Material.CREAKING_SPAWN_EGG),
                                        new SoundData(Sound.ENTITY_CREAKING_UNFREEZE, Material.CREAKING_SPAWN_EGG)
                                ))
                        )),
                        // *************************
                        // *** PROJECTILE SOUNDS ***
                        // *************************
                        new SoundCategory("Projectile Sounds", Material.ARROW, List.of(
                                new SoundData(Sound.ENTITY_WIND_CHARGE_THROW, Material.WIND_CHARGE),
                                new SoundData(Sound.ENTITY_WIND_CHARGE_WIND_BURST, Material.WIND_CHARGE),
                                new SoundData(Sound.ENTITY_ARROW_HIT, Material.ARROW),
                                new SoundData(Sound.ENTITY_ARROW_HIT_PLAYER, Material.ARROW),
                                new SoundData(Sound.ENTITY_ARROW_SHOOT, Material.ARROW),
                                new SoundData(Sound.ENTITY_FISHING_BOBBER_THROW, Material.FISHING_ROD),
                                new SoundData(Sound.ENTITY_FISHING_BOBBER_RETRIEVE, Material.FISHING_ROD),
                                new SoundData(Sound.ENTITY_FISHING_BOBBER_SPLASH, Material.FISHING_ROD),
                                new SoundData(Sound.ENTITY_ENDER_EYE_LAUNCH, Material.ENDER_EYE),
                                new SoundData(Sound.ENTITY_ENDER_EYE_DEATH, Material.ENDER_EYE),
                                new SoundData(Sound.ENTITY_ENDER_PEARL_THROW, Material.ENDER_PEARL),
                                new SoundData(Sound.ENTITY_SHULKER_BULLET_HIT, Material.SHULKER_BOX),
                                new SoundData(Sound.ENTITY_SHULKER_BULLET_HURT, Material.SHULKER_BOX),
                                new SoundData(Sound.ENTITY_SPLASH_POTION_BREAK, Material.SPLASH_POTION),
                                new SoundData(Sound.ENTITY_SPLASH_POTION_THROW, Material.SPLASH_POTION),
                                new SoundData(Sound.ENTITY_LINGERING_POTION_THROW, Material.LINGERING_POTION),
                                new SoundData(Sound.ENTITY_WANDERING_TRADER_DRINK_POTION, Material.WANDERING_TRADER_SPAWN_EGG),
                                new SoundData(Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, Material.EXPERIENCE_BOTTLE),
                                new SoundData(Sound.ENTITY_EGG_THROW, Material.EGG),
                                new SoundData(Sound.ENTITY_SNOWBALL_THROW, Material.SNOWBALL),
                                new SoundData(Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, Material.FIRE_CHARGE),
                                // --- Firework Sounds ---
                                new SoundCategory("Firework Sounds", Material.FIREWORK_ROCKET, List.of(
                                        new SoundData(Sound.ENTITY_FIREWORK_ROCKET_SHOOT, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_FIREWORK_ROCKET_BLAST, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_FIREWORK_ROCKET_TWINKLE, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_FIREWORK_ROCKET_BLAST_FAR, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR, Material.FIREWORK_ROCKET),
                                        new SoundData(Sound.ENTITY_FIREWORK_ROCKET_TWINKLE_FAR, Material.FIREWORK_ROCKET)
                                ))
                        )),
                        // *********************
                        // *** PLAYER SOUNDS ***
                        // *********************
                        new SoundCategory("Player Sounds", Material.PLAYER_HEAD, List.of(
                                new SoundData(Sound.ENTITY_PLAYER_ATTACK_CRIT, Material.GOLDEN_SWORD),
                                new SoundData(Sound.ENTITY_PLAYER_ATTACK_KNOCKBACK, Material.PISTON),
                                new SoundData(Sound.ENTITY_PLAYER_ATTACK_NODAMAGE, Material.STICK),
                                new SoundData(Sound.ENTITY_PLAYER_ATTACK_STRONG, Material.DIAMOND_SWORD),
                                new SoundData(Sound.ENTITY_PLAYER_ATTACK_SWEEP, Material.IRON_SWORD),
                                new SoundData(Sound.ENTITY_PLAYER_ATTACK_WEAK, Material.WOODEN_SWORD),
                                new SoundData(Sound.ENTITY_PLAYER_HURT, Material.RED_DYE),
                                new SoundData(Sound.ENTITY_PLAYER_HURT_DROWN, Material.WATER_BUCKET),
                                new SoundData(Sound.ENTITY_PLAYER_HURT_FREEZE, Material.ICE),
                                new SoundData(Sound.ENTITY_PLAYER_HURT_ON_FIRE, Material.BLAZE_POWDER),
                                new SoundData(Sound.ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH, Material.SWEET_BERRIES),
                                new SoundData(Sound.ENTITY_PLAYER_BIG_FALL, Material.ANVIL),
                                new SoundData(Sound.ENTITY_PLAYER_SMALL_FALL, Material.FEATHER),
                                new SoundData(Sound.ENTITY_PLAYER_SPLASH, Material.WATER_BUCKET),
                                new SoundData(Sound.ENTITY_PLAYER_SPLASH_HIGH_SPEED, Material.WATER_BUCKET),
                                new SoundData(Sound.ENTITY_PLAYER_BREATH, Material.PLAYER_HEAD),
                                new SoundData(Sound.ENTITY_PLAYER_BURP, Material.COOKED_BEEF),
                                new SoundData(Sound.ENTITY_PLAYER_DEATH, Material.SKELETON_SKULL),
                                new SoundData(Sound.ENTITY_PLAYER_LEVELUP, Material.EXPERIENCE_BOTTLE),
                                new SoundData(Sound.ENTITY_PLAYER_SWIM, Material.WATER_BUCKET),
                                new SoundData(Sound.ENTITY_PLAYER_TELEPORT, Material.ENDER_PEARL)
                        )),
                        // ***************************
                        // *** OTHER ENTITY SOUNDS ***
                        // ***************************
                        new SoundCategory("Other Entity Sounds", Material.OAK_BOAT, List.of(
                                new SoundData(Sound.ENTITY_BOAT_PADDLE_LAND, Material.OAK_BOAT),
                                new SoundData(Sound.ENTITY_BOAT_PADDLE_WATER, Material.OAK_BOAT),
                                new SoundData(Sound.ENTITY_LEASH_KNOT_BREAK, Material.LEAD),
                                new SoundData(Sound.ENTITY_LEASH_KNOT_PLACE, Material.LEAD),
                                new SoundData(Sound.ENTITY_ITEM_BREAK, Material.IRON_PICKAXE),
                                new SoundData(Sound.ENTITY_ITEM_PICKUP, Material.HOPPER),
                                new SoundData(Sound.ENTITY_EXPERIENCE_ORB_PICKUP, Material.EXPERIENCE_BOTTLE),
                                new SoundData(Sound.ENTITY_MINECART_INSIDE, Material.MINECART),
                                new SoundData(Sound.ENTITY_MINECART_INSIDE_UNDERWATER, Material.MINECART),
                                new SoundData(Sound.ENTITY_MINECART_RIDING, Material.MINECART),
                                new SoundData(Sound.ENTITY_LIGHTNING_BOLT_IMPACT, Material.LIGHTNING_ROD),
                                new SoundData(Sound.ENTITY_LIGHTNING_BOLT_THUNDER, Material.LIGHTNING_ROD),
                                new SoundData(Sound.ENTITY_PAINTING_BREAK, Material.PAINTING),
                                new SoundData(Sound.ENTITY_PAINTING_PLACE, Material.PAINTING),
                                new SoundData(Sound.ENTITY_GENERIC_EXPLODE, Material.TNT),
                                new SoundData(Sound.ENTITY_CREEPER_PRIMED, Material.CREEPER_HEAD),
                                new SoundData(Sound.ENTITY_TNT_PRIMED, Material.TNT),
                                new SoundData(Sound.ENTITY_ARMOR_STAND_BREAK, Material.ARMOR_STAND),
                                new SoundData(Sound.ENTITY_ARMOR_STAND_FALL, Material.ARMOR_STAND),
                                new SoundData(Sound.ENTITY_ARMOR_STAND_HIT, Material.ARMOR_STAND),
                                new SoundData(Sound.ENTITY_ARMOR_STAND_PLACE, Material.ARMOR_STAND),
                                // --- Generic Sounds ---
                                new SoundCategory("Generic Sounds", Material.PLAYER_HEAD, List.of(
                                        new SoundData(Sound.ENTITY_GENERIC_BIG_FALL, Material.ANVIL),
                                        new SoundData(Sound.ENTITY_GENERIC_BURN, Material.BLAZE_POWDER),
                                        new SoundData(Sound.ENTITY_GENERIC_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_GENERIC_DRINK, Material.POTION),
                                        new SoundData(Sound.ENTITY_GENERIC_EAT, Material.COOKED_BEEF),
                                        new SoundData(Sound.ENTITY_GENERIC_EXTINGUISH_FIRE, Material.PLAYER_HEAD),
                                        new SoundData(Sound.ENTITY_GENERIC_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_GENERIC_SMALL_FALL, Material.ANVIL),
                                        new SoundData(Sound.ENTITY_GENERIC_SPLASH, Material.WATER_BUCKET),
                                        new SoundData(Sound.ENTITY_GENERIC_SWIM, Material.WATER_BUCKET)
                                )),
                                // --- Hostile Generic Sounds ---
                                new SoundCategory("Hostile Generic Sounds", Material.ZOMBIE_HEAD, List.of(
                                        new SoundData(Sound.ENTITY_HOSTILE_BIG_FALL, Material.ANVIL),
                                        new SoundData(Sound.ENTITY_HOSTILE_DEATH, Material.SKELETON_SKULL),
                                        new SoundData(Sound.ENTITY_HOSTILE_HURT, Material.RED_DYE),
                                        new SoundData(Sound.ENTITY_HOSTILE_SMALL_FALL, Material.FEATHER),
                                        new SoundData(Sound.ENTITY_HOSTILE_SPLASH, Material.WATER_BUCKET),
                                        new SoundData(Sound.ENTITY_HOSTILE_SWIM, Material.WATER_BUCKET)
                                )),
                                // --- Glow Item Frame Sounds ---
                                new SoundCategory("Glow Item Frame Sounds", Material.GLOW_ITEM_FRAME, List.of(
                                        new SoundData(Sound.ENTITY_GLOW_ITEM_FRAME_ADD_ITEM, Material.GLOW_ITEM_FRAME),
                                        new SoundData(Sound.ENTITY_GLOW_ITEM_FRAME_BREAK, Material.GLOW_ITEM_FRAME),
                                        new SoundData(Sound.ENTITY_GLOW_ITEM_FRAME_PLACE, Material.GLOW_ITEM_FRAME),
                                        new SoundData(Sound.ENTITY_GLOW_ITEM_FRAME_REMOVE_ITEM, Material.GLOW_ITEM_FRAME),
                                        new SoundData(Sound.ENTITY_GLOW_ITEM_FRAME_ROTATE_ITEM, Material.GLOW_ITEM_FRAME)
                                )),
                                // --- Item Frame Sounds ---
                                new SoundCategory("Item Frame Sounds", Material.ITEM_FRAME, List.of(
                                        new SoundData(Sound.ENTITY_ITEM_FRAME_ADD_ITEM, Material.ITEM_FRAME),
                                        new SoundData(Sound.ENTITY_ITEM_FRAME_BREAK, Material.ITEM_FRAME),
                                        new SoundData(Sound.ENTITY_ITEM_FRAME_PLACE, Material.ITEM_FRAME),
                                        new SoundData(Sound.ENTITY_ITEM_FRAME_REMOVE_ITEM, Material.ITEM_FRAME),
                                        new SoundData(Sound.ENTITY_ITEM_FRAME_ROTATE_ITEM, Material.ITEM_FRAME)
                                ))
                        ))
                )),
                new SoundCategory("Block Sounds", Material.GRASS_BLOCK, List.of(
                        // ****************************
                        // *** COMMON BLOCKS SOUNDS ***
                        // ****************************
                        new SoundCategory("Common Blocks Sounds", Material.GRASS_BLOCK, List.of(
                                // --- Wood Sounds ---
                                new SoundCategory("Wood Sounds", Material.OAK_PLANKS, List.of(
                                        new SoundData(Sound.BLOCK_WOOD_BREAK, Material.OAK_PLANKS),
                                        new SoundData(Sound.BLOCK_WOOD_FALL, Material.OAK_PLANKS),
                                        new SoundData(Sound.BLOCK_WOOD_HIT, Material.OAK_PLANKS),
                                        new SoundData(Sound.BLOCK_WOOD_PLACE, Material.OAK_PLANKS),
                                        new SoundData(Sound.BLOCK_WOOD_STEP, Material.OAK_PLANKS)
                                )),
                                // --- Wool Sounds ---
                                new SoundCategory("Wool Sounds", Material.WHITE_WOOL, List.of(
                                        new SoundData(Sound.BLOCK_WOOL_BREAK, Material.WHITE_WOOL),
                                        new SoundData(Sound.BLOCK_WOOL_FALL, Material.WHITE_WOOL),
                                        new SoundData(Sound.BLOCK_WOOL_HIT, Material.WHITE_WOOL),
                                        new SoundData(Sound.BLOCK_WOOL_PLACE, Material.WHITE_WOOL),
                                        new SoundData(Sound.BLOCK_WOOL_STEP, Material.WHITE_WOOL)
                                )),
                                // --- Sand Sounds ---
                                new SoundCategory("Sand Sounds", Material.SAND, List.of(
                                        new SoundData(Sound.BLOCK_SAND_BREAK, Material.SAND),
                                        new SoundData(Sound.BLOCK_SAND_FALL, Material.SAND),
                                        new SoundData(Sound.BLOCK_SAND_HIT, Material.SAND),
                                        new SoundData(Sound.BLOCK_SAND_PLACE, Material.SAND),
                                        new SoundData(Sound.BLOCK_SAND_STEP, Material.SAND)
                                )),
                                // --- Gravel Sounds ---
                                new SoundCategory("Gravel Sounds", Material.GRAVEL, List.of(
                                        new SoundData(Sound.BLOCK_GRAVEL_BREAK, Material.GRAVEL),
                                        new SoundData(Sound.BLOCK_GRAVEL_FALL, Material.GRAVEL),
                                        new SoundData(Sound.BLOCK_GRAVEL_HIT, Material.GRAVEL),
                                        new SoundData(Sound.BLOCK_GRAVEL_PLACE, Material.GRAVEL),
                                        new SoundData(Sound.BLOCK_GRAVEL_STEP, Material.GRAVEL)
                                )),
                                // --- Grass Sounds ---
                                new SoundCategory("Grass Sounds", Material.GRASS_BLOCK, List.of(
                                        new SoundData(Sound.BLOCK_GRASS_BREAK, Material.GRASS_BLOCK),
                                        new SoundData(Sound.BLOCK_GRASS_FALL, Material.GRASS_BLOCK),
                                        new SoundData(Sound.BLOCK_GRASS_HIT, Material.GRASS_BLOCK),
                                        new SoundData(Sound.BLOCK_GRASS_PLACE, Material.GRASS_BLOCK),
                                        new SoundData(Sound.BLOCK_GRASS_STEP, Material.GRASS_BLOCK)
                                )),
                                // --- Glass Sounds ---
                                new SoundCategory("Glass Sounds", Material.GLASS, List.of(
                                        new SoundData(Sound.BLOCK_GLASS_BREAK, Material.GLASS),
                                        new SoundData(Sound.BLOCK_GLASS_FALL, Material.GLASS),
                                        new SoundData(Sound.BLOCK_GLASS_HIT, Material.GLASS),
                                        new SoundData(Sound.BLOCK_GLASS_PLACE, Material.GLASS),
                                        new SoundData(Sound.BLOCK_GLASS_STEP, Material.GLASS)
                                ))
                        )),
                        // ***************************
                        // *** STONE BLOCKS SOUNDS ***
                        // ***************************
                        new SoundCategory("Stone Blocks Sounds", Material.STONE, List.of(
                                // --- Stone Sounds ---
                                new SoundCategory("Stone Sounds", Material.STONE, List.of(
                                        new SoundData(Sound.BLOCK_STONE_BREAK, Material.STONE),
                                        new SoundData(Sound.BLOCK_STONE_FALL, Material.STONE),
                                        new SoundData(Sound.BLOCK_STONE_HIT, Material.STONE),
                                        new SoundData(Sound.BLOCK_STONE_PLACE, Material.STONE),
                                        new SoundData(Sound.BLOCK_STONE_STEP, Material.STONE)
                                )),
                                // --- Polished Deepslate Sounds ---
                                new SoundCategory("Polished Deepslate Sounds", Material.POLISHED_DEEPSLATE, List.of(
                                        new SoundData(Sound.BLOCK_POLISHED_DEEPSLATE_BREAK, Material.POLISHED_DEEPSLATE),
                                        new SoundData(Sound.BLOCK_POLISHED_DEEPSLATE_FALL, Material.POLISHED_DEEPSLATE),
                                        new SoundData(Sound.BLOCK_POLISHED_DEEPSLATE_HIT, Material.POLISHED_DEEPSLATE),
                                        new SoundData(Sound.BLOCK_POLISHED_DEEPSLATE_PLACE, Material.POLISHED_DEEPSLATE),
                                        new SoundData(Sound.BLOCK_POLISHED_DEEPSLATE_STEP, Material.POLISHED_DEEPSLATE)
                                )),
                                // --- Polished Tuff Sounds ---
                                new SoundCategory("Polished Tuff Sounds", Material.TUFF, List.of(
                                        new SoundData(Sound.BLOCK_POLISHED_TUFF_BREAK, Material.TUFF),
                                        new SoundData(Sound.BLOCK_POLISHED_TUFF_FALL, Material.TUFF),
                                        new SoundData(Sound.BLOCK_POLISHED_TUFF_HIT, Material.TUFF),
                                        new SoundData(Sound.BLOCK_POLISHED_TUFF_PLACE, Material.TUFF),
                                        new SoundData(Sound.BLOCK_POLISHED_TUFF_STEP, Material.TUFF)
                                )),
                                // --- Dripstone Block Sounds ---
                                new SoundCategory("Dripstone Block Sounds", Material.DRIPSTONE_BLOCK, List.of(
                                        new SoundData(Sound.BLOCK_DRIPSTONE_BLOCK_BREAK, Material.DRIPSTONE_BLOCK),
                                        new SoundData(Sound.BLOCK_DRIPSTONE_BLOCK_FALL, Material.DRIPSTONE_BLOCK),
                                        new SoundData(Sound.BLOCK_DRIPSTONE_BLOCK_HIT, Material.DRIPSTONE_BLOCK),
                                        new SoundData(Sound.BLOCK_DRIPSTONE_BLOCK_PLACE, Material.DRIPSTONE_BLOCK),
                                        new SoundData(Sound.BLOCK_DRIPSTONE_BLOCK_STEP, Material.DRIPSTONE_BLOCK)
                                )),
                                // --- Deepslate Bricks Sounds ---
                                new SoundCategory("Deepslate Bricks Sounds", Material.DEEPSLATE_BRICKS, List.of(
                                        new SoundData(Sound.BLOCK_DEEPSLATE_BRICKS_BREAK, Material.DEEPSLATE_BRICKS),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_BRICKS_FALL, Material.DEEPSLATE_BRICKS),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_BRICKS_HIT, Material.DEEPSLATE_BRICKS),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_BRICKS_PLACE, Material.DEEPSLATE_BRICKS),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_BRICKS_STEP, Material.DEEPSLATE_BRICKS)
                                )),
                                // --- Tuff Sounds ---
                                new SoundCategory("Tuff Sounds", Material.TUFF, List.of(
                                        new SoundData(Sound.BLOCK_TUFF_BREAK, Material.TUFF),
                                        new SoundData(Sound.BLOCK_TUFF_FALL, Material.TUFF),
                                        new SoundData(Sound.BLOCK_TUFF_HIT, Material.TUFF),
                                        new SoundData(Sound.BLOCK_TUFF_PLACE, Material.TUFF),
                                        new SoundData(Sound.BLOCK_TUFF_STEP, Material.TUFF)
                                )),
                                // --- Tuff Bricks Sounds ---
                                new SoundCategory("Tuff Bricks Sounds", Material.TUFF, List.of(
                                        new SoundData(Sound.BLOCK_TUFF_BRICKS_BREAK, Material.TUFF),
                                        new SoundData(Sound.BLOCK_TUFF_BRICKS_FALL, Material.TUFF),
                                        new SoundData(Sound.BLOCK_TUFF_BRICKS_HIT, Material.TUFF),
                                        new SoundData(Sound.BLOCK_TUFF_BRICKS_PLACE, Material.TUFF),
                                        new SoundData(Sound.BLOCK_TUFF_BRICKS_STEP, Material.TUFF)
                                )),
                                // --- Deepslate Tiles Sounds ---
                                new SoundCategory("Deepslate Tiles Sounds", Material.DEEPSLATE_TILES, List.of(
                                        new SoundData(Sound.BLOCK_DEEPSLATE_TILES_BREAK, Material.DEEPSLATE_TILES),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_TILES_FALL, Material.DEEPSLATE_TILES),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_TILES_HIT, Material.DEEPSLATE_TILES),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_TILES_PLACE, Material.DEEPSLATE_TILES),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_TILES_STEP, Material.DEEPSLATE_TILES)
                                )),
                                // --- Gilded Blackstone Sounds ---
                                new SoundCategory("Gilded Blackstone Sounds", Material.GILDED_BLACKSTONE, List.of(
                                        new SoundData(Sound.BLOCK_GILDED_BLACKSTONE_BREAK, Material.GILDED_BLACKSTONE),
                                        new SoundData(Sound.BLOCK_GILDED_BLACKSTONE_FALL, Material.GILDED_BLACKSTONE),
                                        new SoundData(Sound.BLOCK_GILDED_BLACKSTONE_HIT, Material.GILDED_BLACKSTONE),
                                        new SoundData(Sound.BLOCK_GILDED_BLACKSTONE_PLACE, Material.GILDED_BLACKSTONE),
                                        new SoundData(Sound.BLOCK_GILDED_BLACKSTONE_STEP, Material.GILDED_BLACKSTONE)
                                )),
                                // --- Deepslate Sounds ---
                                new SoundCategory("Deepslate Sounds", Material.DEEPSLATE, List.of(
                                        new SoundData(Sound.BLOCK_DEEPSLATE_BREAK, Material.DEEPSLATE),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_FALL, Material.DEEPSLATE),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_HIT, Material.DEEPSLATE),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_PLACE, Material.DEEPSLATE),
                                        new SoundData(Sound.BLOCK_DEEPSLATE_STEP, Material.DEEPSLATE)
                                )),
                                // --- Calcite Sounds ---
                                new SoundCategory("Calcite Sounds", Material.CALCITE, List.of(
                                        new SoundData(Sound.BLOCK_CALCITE_BREAK, Material.CALCITE),
                                        new SoundData(Sound.BLOCK_CALCITE_FALL, Material.CALCITE),
                                        new SoundData(Sound.BLOCK_CALCITE_HIT, Material.CALCITE),
                                        new SoundData(Sound.BLOCK_CALCITE_PLACE, Material.CALCITE),
                                        new SoundData(Sound.BLOCK_CALCITE_STEP, Material.CALCITE)
                                )),
                                // --- Ancient Debris Sounds ---
                                new SoundCategory("Ancient Debris Sounds", Material.ANCIENT_DEBRIS, List.of(
                                        new SoundData(Sound.BLOCK_ANCIENT_DEBRIS_BREAK, Material.ANCIENT_DEBRIS),
                                        new SoundData(Sound.BLOCK_ANCIENT_DEBRIS_FALL, Material.ANCIENT_DEBRIS),
                                        new SoundData(Sound.BLOCK_ANCIENT_DEBRIS_HIT, Material.ANCIENT_DEBRIS),
                                        new SoundData(Sound.BLOCK_ANCIENT_DEBRIS_PLACE, Material.ANCIENT_DEBRIS),
                                        new SoundData(Sound.BLOCK_ANCIENT_DEBRIS_STEP, Material.ANCIENT_DEBRIS)
                                )),
                                // --- Basalt Sounds ---
                                new SoundCategory("Basalt Sounds", Material.BASALT, List.of(
                                        new SoundData(Sound.BLOCK_BASALT_BREAK, Material.BASALT),
                                        new SoundData(Sound.BLOCK_BASALT_FALL, Material.BASALT),
                                        new SoundData(Sound.BLOCK_BASALT_HIT, Material.BASALT),
                                        new SoundData(Sound.BLOCK_BASALT_PLACE, Material.BASALT),
                                        new SoundData(Sound.BLOCK_BASALT_STEP, Material.BASALT)
                                ))
                        )),
                        // **************************
                        // *** WOOD BLOCKS SOUNDS ***
                        // **************************
                        new SoundCategory("Wood Blocks Sounds", Material.OAK_LOG, List.of(
                                // --- Cherry Wood Sounds ---
                                new SoundCategory("Cherry Wood Sounds", Material.CHERRY_PLANKS, List.of(
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_BREAK, Material.CHERRY_PLANKS),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_FALL, Material.CHERRY_PLANKS),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_HIT, Material.CHERRY_PLANKS),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_PLACE, Material.CHERRY_PLANKS),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_STEP, Material.CHERRY_PLANKS)
                                )),
                                // --- Cherry Wood Button Sounds ---
                                new SoundCategory("Cherry Wood Button Sounds", Material.CHERRY_BUTTON, List.of(
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_BUTTON_CLICK_OFF, Material.CHERRY_BUTTON),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_BUTTON_CLICK_ON, Material.CHERRY_BUTTON)
                                )),
                                // --- Cherry Wood Door Sounds ---
                                new SoundCategory("Cherry Wood Door Sounds", Material.CHERRY_DOOR, List.of(
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_DOOR_CLOSE, Material.CHERRY_DOOR),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_DOOR_OPEN, Material.CHERRY_DOOR)
                                )),
                                // --- Cherry Wood Fence Gate Sounds ---
                                new SoundCategory("Cherry Wood Fence Gate Sounds", Material.CHERRY_FENCE_GATE, List.of(
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_FENCE_GATE_CLOSE, Material.CHERRY_FENCE_GATE),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_FENCE_GATE_OPEN, Material.CHERRY_FENCE_GATE)
                                )),
                                // --- Cherry Wood Hanging Sign Sounds ---
                                new SoundCategory("Cherry Wood Hanging Sign Sounds", Material.CHERRY_HANGING_SIGN, List.of(
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_HANGING_SIGN_BREAK, Material.CHERRY_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_HANGING_SIGN_FALL, Material.CHERRY_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_HANGING_SIGN_HIT, Material.CHERRY_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_HANGING_SIGN_PLACE, Material.CHERRY_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_HANGING_SIGN_STEP, Material.CHERRY_HANGING_SIGN)
                                )),
                                // --- Cherry Wood Pressure Plate Sounds ---
                                new SoundCategory("Cherry Wood Pressure Plate Sounds", Material.CHERRY_PRESSURE_PLATE, List.of(
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_OFF, Material.CHERRY_PRESSURE_PLATE),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_PRESSURE_PLATE_CLICK_ON, Material.CHERRY_PRESSURE_PLATE)
                                )),
                                // --- Cherry Wood Trapdoor Sounds ---
                                new SoundCategory("Cherry Wood Trapdoor Sounds", Material.CHERRY_TRAPDOOR, List.of(
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_TRAPDOOR_CLOSE, Material.CHERRY_TRAPDOOR),
                                        new SoundData(Sound.BLOCK_CHERRY_WOOD_TRAPDOOR_OPEN, Material.CHERRY_TRAPDOOR)
                                )),
                                // --- Bamboo Wood Sounds ---
                                new SoundCategory("Bamboo Wood Sounds", Material.BAMBOO_BLOCK, List.of(
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_BREAK, Material.BAMBOO_BLOCK),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_FALL, Material.BAMBOO_BLOCK),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_HIT, Material.BAMBOO_BLOCK),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_PLACE, Material.BAMBOO_BLOCK),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_STEP, Material.BAMBOO_BLOCK)
                                )),
                                // --- Bamboo Wood Button Sounds ---
                                new SoundCategory("Bamboo Wood Button Sounds", Material.BAMBOO_BUTTON, List.of(
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_OFF, Material.BAMBOO_BUTTON),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_BUTTON_CLICK_ON, Material.BAMBOO_BUTTON)
                                )),
                                // --- Bamboo Wood Door Sounds ---
                                new SoundCategory("Bamboo Wood Door Sounds", Material.BAMBOO_DOOR, List.of(
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_DOOR_CLOSE, Material.BAMBOO_DOOR),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_DOOR_OPEN, Material.BAMBOO_DOOR)
                                )),
                                // --- Bamboo Wood Fence Gate Sounds ---
                                new SoundCategory("Bamboo Wood Fence Gate Sounds", Material.BAMBOO_FENCE_GATE, List.of(
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_FENCE_GATE_CLOSE, Material.BAMBOO_FENCE_GATE),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_FENCE_GATE_OPEN, Material.BAMBOO_FENCE_GATE)
                                )),
                                // --- Bamboo Wood Hanging Sign Sounds ---
                                new SoundCategory("Bamboo Wood Hanging Sign Sounds", Material.BAMBOO_HANGING_SIGN, List.of(
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_HANGING_SIGN_BREAK, Material.BAMBOO_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_HANGING_SIGN_FALL, Material.BAMBOO_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_HANGING_SIGN_HIT, Material.BAMBOO_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_HANGING_SIGN_PLACE, Material.BAMBOO_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_HANGING_SIGN_STEP, Material.BAMBOO_HANGING_SIGN)
                                )),
                                // --- Bamboo Wood Pressure Plate Sounds ---
                                new SoundCategory("Bamboo Wood Pressure Plate Sounds", Material.BAMBOO_PRESSURE_PLATE, List.of(
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_PRESSURE_PLATE_CLICK_OFF, Material.BAMBOO_PRESSURE_PLATE),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_PRESSURE_PLATE_CLICK_ON, Material.BAMBOO_PRESSURE_PLATE)
                                )),
                                // --- Bamboo Wood Trapdoor Sounds ---
                                new SoundCategory("Bamboo Wood Trapdoor Sounds", Material.BAMBOO_TRAPDOOR, List.of(
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_TRAPDOOR_CLOSE, Material.BAMBOO_TRAPDOOR),
                                        new SoundData(Sound.BLOCK_BAMBOO_WOOD_TRAPDOOR_OPEN, Material.BAMBOO_TRAPDOOR)
                                ))
                        )),
                        // ***************************
                        // *** PLANT BLOCKS SOUNDS ***
                        // ***************************
                        new SoundCategory("Plant Blocks Sounds", Material.OAK_SAPLING, List.of(
                                // --- Flowering Azalea Sounds ---
                                new SoundCategory("Flowering Azalea Sounds", Material.FLOWERING_AZALEA, List.of(
                                        new SoundData(Sound.BLOCK_FLOWERING_AZALEA_BREAK, Material.FLOWERING_AZALEA),
                                        new SoundData(Sound.BLOCK_FLOWERING_AZALEA_FALL, Material.FLOWERING_AZALEA),
                                        new SoundData(Sound.BLOCK_FLOWERING_AZALEA_HIT, Material.FLOWERING_AZALEA),
                                        new SoundData(Sound.BLOCK_FLOWERING_AZALEA_PLACE, Material.FLOWERING_AZALEA),
                                        new SoundData(Sound.BLOCK_FLOWERING_AZALEA_STEP, Material.FLOWERING_AZALEA)
                                )),
                                // --- Eyeblossom Sounds ---
                                new SoundCategory("Eyeblossom Sounds", Material.OPEN_EYEBLOSSOM, List.of(
                                        new SoundData(Sound.BLOCK_EYEBLOSSOM_CLOSE, Material.CLOSED_EYEBLOSSOM),
                                        new SoundData(Sound.BLOCK_EYEBLOSSOM_CLOSE_LONG, Material.CLOSED_EYEBLOSSOM),
                                        new SoundData(Sound.BLOCK_EYEBLOSSOM_IDLE, Material.OPEN_EYEBLOSSOM),
                                        new SoundData(Sound.BLOCK_EYEBLOSSOM_OPEN, Material.OPEN_EYEBLOSSOM),
                                        new SoundData(Sound.BLOCK_EYEBLOSSOM_OPEN_LONG, Material.OPEN_EYEBLOSSOM)
                                )),
                                // --- Coral Block Sounds ---
                                new SoundCategory("Coral Block Sounds", Material.BRAIN_CORAL_BLOCK, List.of(
                                        new SoundData(Sound.BLOCK_CORAL_BLOCK_BREAK, Material.BRAIN_CORAL_BLOCK),
                                        new SoundData(Sound.BLOCK_CORAL_BLOCK_FALL, Material.BRAIN_CORAL_BLOCK),
                                        new SoundData(Sound.BLOCK_CORAL_BLOCK_HIT, Material.BRAIN_CORAL_BLOCK),
                                        new SoundData(Sound.BLOCK_CORAL_BLOCK_PLACE, Material.BRAIN_CORAL_BLOCK),
                                        new SoundData(Sound.BLOCK_CORAL_BLOCK_STEP, Material.BRAIN_CORAL_BLOCK)
                                )),
                                // --- Chorus Flower Sounds ---
                                new SoundCategory("Chorus Flower Sounds", Material.CHORUS_FLOWER, List.of(
                                        new SoundData(Sound.BLOCK_CHORUS_FLOWER_DEATH, Material.CHORUS_FLOWER),
                                        new SoundData(Sound.BLOCK_CHORUS_FLOWER_GROW, Material.CHORUS_FLOWER)
                                )),
                                // --- Cherry Leaves Sounds ---
                                new SoundCategory("Cherry Leaves Sounds", Material.CHERRY_LEAVES, List.of(
                                        new SoundData(Sound.BLOCK_CHERRY_LEAVES_BREAK, Material.CHERRY_LEAVES),
                                        new SoundData(Sound.BLOCK_CHERRY_LEAVES_FALL, Material.CHERRY_LEAVES),
                                        new SoundData(Sound.BLOCK_CHERRY_LEAVES_HIT, Material.CHERRY_LEAVES),
                                        new SoundData(Sound.BLOCK_CHERRY_LEAVES_PLACE, Material.CHERRY_LEAVES),
                                        new SoundData(Sound.BLOCK_CHERRY_LEAVES_STEP, Material.CHERRY_LEAVES)
                                )),
                                // --- Mangrove Roots Sounds ---
                                new SoundCategory("Mangrove Roots Sounds", Material.MANGROVE_ROOTS, List.of(
                                        new SoundData(Sound.BLOCK_MANGROVE_ROOTS_BREAK, Material.MANGROVE_ROOTS),
                                        new SoundData(Sound.BLOCK_MANGROVE_ROOTS_FALL, Material.MANGROVE_ROOTS),
                                        new SoundData(Sound.BLOCK_MANGROVE_ROOTS_HIT, Material.MANGROVE_ROOTS),
                                        new SoundData(Sound.BLOCK_MANGROVE_ROOTS_PLACE, Material.MANGROVE_ROOTS),
                                        new SoundData(Sound.BLOCK_MANGROVE_ROOTS_STEP, Material.MANGROVE_ROOTS)
                                )),
                                // --- Cherry Sapling Sounds ---
                                new SoundCategory("Cherry Sapling Sounds", Material.CHERRY_SAPLING, List.of(
                                        new SoundData(Sound.BLOCK_CHERRY_SAPLING_BREAK, Material.CHERRY_SAPLING),
                                        new SoundData(Sound.BLOCK_CHERRY_SAPLING_FALL, Material.CHERRY_SAPLING),
                                        new SoundData(Sound.BLOCK_CHERRY_SAPLING_HIT, Material.CHERRY_SAPLING),
                                        new SoundData(Sound.BLOCK_CHERRY_SAPLING_PLACE, Material.CHERRY_SAPLING),
                                        new SoundData(Sound.BLOCK_CHERRY_SAPLING_STEP, Material.CHERRY_SAPLING)
                                )),
                                // --- Cave Vines Sounds ---
                                new SoundCategory("Cave Vines Sounds", Material.GLOW_BERRIES, List.of(
                                        new SoundData(Sound.BLOCK_CAVE_VINES_BREAK, Material.GLOW_BERRIES),
                                        new SoundData(Sound.BLOCK_CAVE_VINES_FALL, Material.GLOW_BERRIES),
                                        new SoundData(Sound.BLOCK_CAVE_VINES_HIT, Material.GLOW_BERRIES),
                                        new SoundData(Sound.BLOCK_CAVE_VINES_PICK_BERRIES, Material.GLOW_BERRIES),
                                        new SoundData(Sound.BLOCK_CAVE_VINES_PLACE, Material.GLOW_BERRIES),
                                        new SoundData(Sound.BLOCK_CAVE_VINES_STEP, Material.GLOW_BERRIES)
                                )),
                                // --- Rooted Dirt Sounds ---
                                new SoundCategory("Rooted Dirt Sounds", Material.ROOTED_DIRT, List.of(
                                        new SoundData(Sound.BLOCK_ROOTED_DIRT_BREAK, Material.ROOTED_DIRT),
                                        new SoundData(Sound.BLOCK_ROOTED_DIRT_FALL, Material.ROOTED_DIRT),
                                        new SoundData(Sound.BLOCK_ROOTED_DIRT_HIT, Material.ROOTED_DIRT),
                                        new SoundData(Sound.BLOCK_ROOTED_DIRT_PLACE, Material.ROOTED_DIRT),
                                        new SoundData(Sound.BLOCK_ROOTED_DIRT_STEP, Material.ROOTED_DIRT)
                                )),
                                // --- Azalea Sounds ---
                                new SoundCategory("Azalea Sounds", Material.AZALEA, List.of(
                                        new SoundData(Sound.BLOCK_AZALEA_BREAK, Material.AZALEA),
                                        new SoundData(Sound.BLOCK_AZALEA_FALL, Material.AZALEA),
                                        new SoundData(Sound.BLOCK_AZALEA_HIT, Material.AZALEA),
                                        new SoundData(Sound.BLOCK_AZALEA_PLACE, Material.AZALEA),
                                        new SoundData(Sound.BLOCK_AZALEA_STEP, Material.AZALEA)
                                )),
                                // --- Hanging Roots Sounds ---
                                new SoundCategory("Hanging Roots Sounds", Material.HANGING_ROOTS, List.of(
                                        new SoundData(Sound.BLOCK_HANGING_ROOTS_BREAK, Material.HANGING_ROOTS),
                                        new SoundData(Sound.BLOCK_HANGING_ROOTS_FALL, Material.HANGING_ROOTS),
                                        new SoundData(Sound.BLOCK_HANGING_ROOTS_HIT, Material.HANGING_ROOTS),
                                        new SoundData(Sound.BLOCK_HANGING_ROOTS_PLACE, Material.HANGING_ROOTS),
                                        new SoundData(Sound.BLOCK_HANGING_ROOTS_STEP, Material.HANGING_ROOTS)
                                )),
                                // --- Growing Plant Sounds ---
                                new SoundCategory("Growing Plant Sounds", Material.WHEAT, List.of(
                                        new SoundData(Sound.BLOCK_GROWING_PLANT_CROP, Material.WHEAT)
                                )),
                                // --- Sweet Berry Bush Sounds ---
                                new SoundCategory("Sweet Berry Bush Sounds", Material.SWEET_BERRIES, List.of(
                                        new SoundData(Sound.BLOCK_SWEET_BERRY_BUSH_BREAK, Material.SWEET_BERRIES),
                                        new SoundData(Sound.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, Material.SWEET_BERRIES),
                                        new SoundData(Sound.BLOCK_SWEET_BERRY_BUSH_PLACE, Material.SWEET_BERRIES)
                                )),
                                // --- Spore Blossom Sounds ---
                                new SoundCategory("Spore Blossom Sounds", Material.SPORE_BLOSSOM, List.of(
                                        new SoundData(Sound.BLOCK_SPORE_BLOSSOM_BREAK, Material.SPORE_BLOSSOM),
                                        new SoundData(Sound.BLOCK_SPORE_BLOSSOM_FALL, Material.SPORE_BLOSSOM),
                                        new SoundData(Sound.BLOCK_SPORE_BLOSSOM_HIT, Material.SPORE_BLOSSOM),
                                        new SoundData(Sound.BLOCK_SPORE_BLOSSOM_PLACE, Material.SPORE_BLOSSOM),
                                        new SoundData(Sound.BLOCK_SPORE_BLOSSOM_STEP, Material.SPORE_BLOSSOM)
                                )),
                                // --- Wet Grass Sounds ---
                                new SoundCategory("Wet Grass Sounds", Material.SEAGRASS, List.of(
                                        new SoundData(Sound.BLOCK_WET_GRASS_BREAK, Material.SEAGRASS),
                                        new SoundData(Sound.BLOCK_WET_GRASS_FALL, Material.SEAGRASS),
                                        new SoundData(Sound.BLOCK_WET_GRASS_HIT, Material.SEAGRASS),
                                        new SoundData(Sound.BLOCK_WET_GRASS_PLACE, Material.SEAGRASS),
                                        new SoundData(Sound.BLOCK_WET_GRASS_STEP, Material.SEAGRASS)
                                )),
                                // --- Vine Sounds ---
                                new SoundCategory("Vine Sounds", Material.VINE, List.of(
                                        new SoundData(Sound.BLOCK_VINE_BREAK, Material.VINE),
                                        new SoundData(Sound.BLOCK_VINE_FALL, Material.VINE),
                                        new SoundData(Sound.BLOCK_VINE_HIT, Material.VINE),
                                        new SoundData(Sound.BLOCK_VINE_PLACE, Material.VINE),
                                        new SoundData(Sound.BLOCK_VINE_STEP, Material.VINE)
                                )),
                                // --- Moss Sounds ---
                                new SoundCategory("Moss Sounds", Material.MOSS_BLOCK, List.of(
                                        new SoundData(Sound.BLOCK_MOSS_BREAK, Material.MOSS_BLOCK),
                                        new SoundData(Sound.BLOCK_MOSS_FALL, Material.MOSS_BLOCK),
                                        new SoundData(Sound.BLOCK_MOSS_HIT, Material.MOSS_BLOCK),
                                        new SoundData(Sound.BLOCK_MOSS_PLACE, Material.MOSS_BLOCK),
                                        new SoundData(Sound.BLOCK_MOSS_STEP, Material.MOSS_BLOCK)
                                )),
                                // --- Moss Carpet Sounds ---
                                new SoundCategory("Moss Carpet Sounds", Material.MOSS_CARPET, List.of(
                                        new SoundData(Sound.BLOCK_MOSS_CARPET_BREAK, Material.MOSS_CARPET),
                                        new SoundData(Sound.BLOCK_MOSS_CARPET_FALL, Material.MOSS_CARPET),
                                        new SoundData(Sound.BLOCK_MOSS_CARPET_HIT, Material.MOSS_CARPET),
                                        new SoundData(Sound.BLOCK_MOSS_CARPET_PLACE, Material.MOSS_CARPET),
                                        new SoundData(Sound.BLOCK_MOSS_CARPET_STEP, Material.MOSS_CARPET)
                                )),
                                // --- Pale Hanging Moss Sounds ---
                                new SoundCategory("Pale Hanging Moss Sounds", Material.PALE_HANGING_MOSS, List.of(
                                        new SoundData(Sound.BLOCK_PALE_HANGING_MOSS_IDLE, Material.PALE_HANGING_MOSS)
                                )),
                                // --- Pink Petals Sounds ---
                                new SoundCategory("Pink Petals Sounds", Material.PINK_PETALS, List.of(
                                        new SoundData(Sound.BLOCK_PINK_PETALS_BREAK, Material.PINK_PETALS),
                                        new SoundData(Sound.BLOCK_PINK_PETALS_FALL, Material.PINK_PETALS),
                                        new SoundData(Sound.BLOCK_PINK_PETALS_HIT, Material.PINK_PETALS),
                                        new SoundData(Sound.BLOCK_PINK_PETALS_PLACE, Material.PINK_PETALS),
                                        new SoundData(Sound.BLOCK_PINK_PETALS_STEP, Material.PINK_PETALS)
                                )),
                                // --- Muddy Mangrove Roots Sounds ---
                                new SoundCategory("Muddy Mangrove Roots Sounds", Material.MUDDY_MANGROVE_ROOTS, List.of(
                                        new SoundData(Sound.BLOCK_MUDDY_MANGROVE_ROOTS_BREAK, Material.MUDDY_MANGROVE_ROOTS),
                                        new SoundData(Sound.BLOCK_MUDDY_MANGROVE_ROOTS_FALL, Material.MUDDY_MANGROVE_ROOTS),
                                        new SoundData(Sound.BLOCK_MUDDY_MANGROVE_ROOTS_HIT, Material.MUDDY_MANGROVE_ROOTS),
                                        new SoundData(Sound.BLOCK_MUDDY_MANGROVE_ROOTS_PLACE, Material.MUDDY_MANGROVE_ROOTS),
                                        new SoundData(Sound.BLOCK_MUDDY_MANGROVE_ROOTS_STEP, Material.MUDDY_MANGROVE_ROOTS)
                                )),
                                // --- Azalea Leaves Sounds ---
                                new SoundCategory("Azalea Leaves Sounds", Material.AZALEA_LEAVES, List.of(
                                        new SoundData(Sound.BLOCK_AZALEA_LEAVES_BREAK, Material.AZALEA_LEAVES),
                                        new SoundData(Sound.BLOCK_AZALEA_LEAVES_FALL, Material.AZALEA_LEAVES),
                                        new SoundData(Sound.BLOCK_AZALEA_LEAVES_HIT, Material.AZALEA_LEAVES),
                                        new SoundData(Sound.BLOCK_AZALEA_LEAVES_PLACE, Material.AZALEA_LEAVES),
                                        new SoundData(Sound.BLOCK_AZALEA_LEAVES_STEP, Material.AZALEA_LEAVES)
                                )),
                                // --- Small Dripleaf Sounds ---
                                new SoundCategory("Small Dripleaf Sounds", Material.SMALL_DRIPLEAF, List.of(
                                        new SoundData(Sound.BLOCK_SMALL_DRIPLEAF_BREAK, Material.SMALL_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_SMALL_DRIPLEAF_FALL, Material.SMALL_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_SMALL_DRIPLEAF_HIT, Material.SMALL_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_SMALL_DRIPLEAF_PLACE, Material.SMALL_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_SMALL_DRIPLEAF_STEP, Material.SMALL_DRIPLEAF)
                                )),
                                // --- Lily Pad Sounds ---
                                new SoundCategory("Lily Pad Sounds", Material.LILY_PAD, List.of(
                                        new SoundData(Sound.BLOCK_LILY_PAD_PLACE, Material.LILY_PAD)
                                )),
                                // --- Big Dripleaf Sounds ---
                                new SoundCategory("Big Dripleaf Sounds", Material.BIG_DRIPLEAF, List.of(
                                        new SoundData(Sound.BLOCK_BIG_DRIPLEAF_BREAK, Material.BIG_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_BIG_DRIPLEAF_FALL, Material.BIG_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_BIG_DRIPLEAF_HIT, Material.BIG_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_BIG_DRIPLEAF_PLACE, Material.BIG_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_BIG_DRIPLEAF_STEP, Material.BIG_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_BIG_DRIPLEAF_TILT_DOWN, Material.BIG_DRIPLEAF),
                                        new SoundData(Sound.BLOCK_BIG_DRIPLEAF_TILT_UP, Material.BIG_DRIPLEAF)
                                )),
                                // --- Bamboo Sapling Sounds ---
                                new SoundCategory("Bamboo Sapling Sounds", Material.BAMBOO, List.of(
                                        new SoundData(Sound.BLOCK_BAMBOO_SAPLING_BREAK, Material.BAMBOO),
                                        new SoundData(Sound.BLOCK_BAMBOO_SAPLING_HIT, Material.BAMBOO),
                                        new SoundData(Sound.BLOCK_BAMBOO_SAPLING_PLACE, Material.BAMBOO)
                                ))

                        )),
                        // ***************************
                        // *** METAL BLOCKS SOUNDS ***
                        // ***************************
                        new SoundCategory("Metal Blocks Sounds", Material.IRON_BLOCK, List.of(
                                // --- Metal Sounds ---
                                new SoundCategory("Metal Sounds", Material.IRON_BLOCK, List.of(
                                        new SoundData(Sound.BLOCK_METAL_BREAK, Material.IRON_BLOCK),
                                        new SoundData(Sound.BLOCK_METAL_FALL, Material.IRON_BLOCK),
                                        new SoundData(Sound.BLOCK_METAL_HIT, Material.IRON_BLOCK),
                                        new SoundData(Sound.BLOCK_METAL_PLACE, Material.IRON_BLOCK),
                                        new SoundData(Sound.BLOCK_METAL_STEP, Material.IRON_BLOCK)
                                )),
                                // --- Metal Pressure Plate Sounds ---
                                new SoundCategory("Metal Pressure Plate Sounds", Material.HEAVY_WEIGHTED_PRESSURE_PLATE, List.of(
                                        new SoundData(Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_OFF, Material.HEAVY_WEIGHTED_PRESSURE_PLATE),
                                        new SoundData(Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON, Material.HEAVY_WEIGHTED_PRESSURE_PLATE)
                                )),
                                // --- Copper Door Sounds ---
                                new SoundCategory("Copper Door Sounds", Material.COPPER_DOOR, List.of(
                                        new SoundData(Sound.BLOCK_COPPER_DOOR_CLOSE, Material.COPPER_DOOR),
                                        new SoundData(Sound.BLOCK_COPPER_DOOR_OPEN, Material.COPPER_DOOR)
                                )),
                                // --- Copper Grate Sounds ---
                                new SoundCategory("Copper Grate Sounds", Material.COPPER_GRATE, List.of(
                                        new SoundData(Sound.BLOCK_COPPER_GRATE_BREAK, Material.COPPER_GRATE),
                                        new SoundData(Sound.BLOCK_COPPER_GRATE_FALL, Material.COPPER_GRATE),
                                        new SoundData(Sound.BLOCK_COPPER_GRATE_HIT, Material.COPPER_GRATE),
                                        new SoundData(Sound.BLOCK_COPPER_GRATE_PLACE, Material.COPPER_GRATE),
                                        new SoundData(Sound.BLOCK_COPPER_GRATE_STEP, Material.COPPER_GRATE)
                                )),
                                // --- Copper Trapdoor Sounds ---
                                new SoundCategory("Copper Trapdoor Sounds", Material.COPPER_TRAPDOOR, List.of(
                                        new SoundData(Sound.BLOCK_COPPER_TRAPDOOR_CLOSE, Material.COPPER_TRAPDOOR),
                                        new SoundData(Sound.BLOCK_COPPER_TRAPDOOR_OPEN, Material.COPPER_TRAPDOOR)
                                )),
                                // --- Copper Bulb Sounds ---
                                new SoundCategory("Copper Bulb Sounds", Material.COPPER_BULB, List.of(
                                        new SoundData(Sound.BLOCK_COPPER_BULB_BREAK, Material.COPPER_BULB),
                                        new SoundData(Sound.BLOCK_COPPER_BULB_FALL, Material.COPPER_BULB),
                                        new SoundData(Sound.BLOCK_COPPER_BULB_HIT, Material.COPPER_BULB),
                                        new SoundData(Sound.BLOCK_COPPER_BULB_PLACE, Material.COPPER_BULB),
                                        new SoundData(Sound.BLOCK_COPPER_BULB_STEP, Material.COPPER_BULB),
                                        new SoundData(Sound.BLOCK_COPPER_BULB_TURN_OFF, Material.COPPER_BULB),
                                        new SoundData(Sound.BLOCK_COPPER_BULB_TURN_ON, Material.COPPER_BULB)
                                )),
                                // --- Copper Sounds ---
                                new SoundCategory("Copper Sounds", Material.COPPER_BLOCK, List.of(
                                        new SoundData(Sound.BLOCK_COPPER_BREAK, Material.COPPER_BLOCK),
                                        new SoundData(Sound.BLOCK_COPPER_FALL, Material.COPPER_BLOCK),
                                        new SoundData(Sound.BLOCK_COPPER_HIT, Material.COPPER_BLOCK),
                                        new SoundData(Sound.BLOCK_COPPER_PLACE, Material.COPPER_BLOCK),
                                        new SoundData(Sound.BLOCK_COPPER_STEP, Material.COPPER_BLOCK)
                                )),
                                // --- Chain Sounds ---
                                new SoundCategory("Chain Sounds", Material.CHAIN, List.of(
                                        new SoundData(Sound.BLOCK_CHAIN_BREAK, Material.CHAIN),
                                        new SoundData(Sound.BLOCK_CHAIN_FALL, Material.CHAIN),
                                        new SoundData(Sound.BLOCK_CHAIN_HIT, Material.CHAIN),
                                        new SoundData(Sound.BLOCK_CHAIN_PLACE, Material.CHAIN),
                                        new SoundData(Sound.BLOCK_CHAIN_STEP, Material.CHAIN)
                                )),
                                // --- Iron Door Sounds ---
                                new SoundCategory("Iron Door Sounds", Material.IRON_DOOR, List.of(
                                        new SoundData(Sound.BLOCK_IRON_DOOR_CLOSE, Material.IRON_DOOR),
                                        new SoundData(Sound.BLOCK_IRON_DOOR_OPEN, Material.IRON_DOOR)
                                )),
                                // --- Iron Trapdoor Sounds ---
                                new SoundCategory("Iron Trapdoor Sounds", Material.IRON_TRAPDOOR, List.of(
                                        new SoundData(Sound.BLOCK_IRON_TRAPDOOR_CLOSE, Material.IRON_TRAPDOOR),
                                        new SoundData(Sound.BLOCK_IRON_TRAPDOOR_OPEN, Material.IRON_TRAPDOOR)
                                )),
                                // --- Anvil Block Sounds ---
                                new SoundCategory("Anvil Block Sounds", Material.ANVIL, List.of(
                                        new SoundData(Sound.BLOCK_ANVIL_BREAK, Material.ANVIL),
                                        new SoundData(Sound.BLOCK_ANVIL_DESTROY, Material.ANVIL),
                                        new SoundData(Sound.BLOCK_ANVIL_FALL, Material.ANVIL),
                                        new SoundData(Sound.BLOCK_ANVIL_HIT, Material.ANVIL),
                                        new SoundData(Sound.BLOCK_ANVIL_LAND, Material.ANVIL),
                                        new SoundData(Sound.BLOCK_ANVIL_PLACE, Material.ANVIL),
                                        new SoundData(Sound.BLOCK_ANVIL_STEP, Material.ANVIL),
                                        new SoundData(Sound.BLOCK_ANVIL_USE, Material.ANVIL)
                                ))
                        )),
                        // ***************************
                        // *** NETHER BLOCK SOUNDS ***
                        // ***************************
                        new SoundCategory("Nether Block Sounds", Material.NETHERRACK, List.of(
                                // --- Netherrack Sounds ---
                                new SoundCategory("Netherrack Sounds", Material.NETHERRACK, List.of(
                                        new SoundData(Sound.BLOCK_NETHERRACK_BREAK, Material.NETHERRACK),
                                        new SoundData(Sound.BLOCK_NETHERRACK_FALL, Material.NETHERRACK),
                                        new SoundData(Sound.BLOCK_NETHERRACK_HIT, Material.NETHERRACK),
                                        new SoundData(Sound.BLOCK_NETHERRACK_PLACE, Material.NETHERRACK),
                                        new SoundData(Sound.BLOCK_NETHERRACK_STEP, Material.NETHERRACK)
                                )),
                                // --- Nether Bricks Sounds ---
                                new SoundCategory("Nether Bricks Sounds", Material.NETHER_BRICKS, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_BRICKS_BREAK, Material.NETHER_BRICKS),
                                        new SoundData(Sound.BLOCK_NETHER_BRICKS_FALL, Material.NETHER_BRICKS),
                                        new SoundData(Sound.BLOCK_NETHER_BRICKS_HIT, Material.NETHER_BRICKS),
                                        new SoundData(Sound.BLOCK_NETHER_BRICKS_PLACE, Material.NETHER_BRICKS),
                                        new SoundData(Sound.BLOCK_NETHER_BRICKS_STEP, Material.NETHER_BRICKS)
                                )),
                                // --- Nether Gold Ore Sounds ---
                                new SoundCategory("Nether Gold Ore Sounds", Material.NETHER_GOLD_ORE, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_GOLD_ORE_BREAK, Material.NETHER_GOLD_ORE),
                                        new SoundData(Sound.BLOCK_NETHER_GOLD_ORE_FALL, Material.NETHER_GOLD_ORE),
                                        new SoundData(Sound.BLOCK_NETHER_GOLD_ORE_HIT, Material.NETHER_GOLD_ORE),
                                        new SoundData(Sound.BLOCK_NETHER_GOLD_ORE_PLACE, Material.NETHER_GOLD_ORE),
                                        new SoundData(Sound.BLOCK_NETHER_GOLD_ORE_STEP, Material.NETHER_GOLD_ORE)
                                )),
                                // --- Nether Ore Sounds ---
                                new SoundCategory("Nether Ore Sounds", Material.NETHER_QUARTZ_ORE, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_ORE_BREAK, Material.NETHER_QUARTZ_ORE),
                                        new SoundData(Sound.BLOCK_NETHER_ORE_FALL, Material.NETHER_QUARTZ_ORE),
                                        new SoundData(Sound.BLOCK_NETHER_ORE_HIT, Material.NETHER_QUARTZ_ORE),
                                        new SoundData(Sound.BLOCK_NETHER_ORE_PLACE, Material.NETHER_QUARTZ_ORE),
                                        new SoundData(Sound.BLOCK_NETHER_ORE_STEP, Material.NETHER_QUARTZ_ORE)
                                )),
                                // --- Nether Sprouts Sounds ---
                                new SoundCategory("Nether Sprouts Sounds", Material.NETHER_SPROUTS, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_SPROUTS_BREAK, Material.NETHER_SPROUTS),
                                        new SoundData(Sound.BLOCK_NETHER_SPROUTS_FALL, Material.NETHER_SPROUTS),
                                        new SoundData(Sound.BLOCK_NETHER_SPROUTS_HIT, Material.NETHER_SPROUTS),
                                        new SoundData(Sound.BLOCK_NETHER_SPROUTS_PLACE, Material.NETHER_SPROUTS),
                                        new SoundData(Sound.BLOCK_NETHER_SPROUTS_STEP, Material.NETHER_SPROUTS)
                                )),
                                // --- Nether Wart Sounds ---
                                new SoundCategory("Nether Wart Sounds", Material.NETHER_WART, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_WART_BREAK, Material.NETHER_WART),
                                        new SoundData(Sound.ITEM_NETHER_WART_PLANT, Material.NETHER_WART)
                                )),
                                // --- Nether Wood Sounds ---
                                new SoundCategory("Nether Wood Sounds", Material.CRIMSON_PLANKS, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_BREAK, Material.CRIMSON_PLANKS),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_FALL, Material.CRIMSON_PLANKS),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_HIT, Material.CRIMSON_PLANKS),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_PLACE, Material.CRIMSON_PLANKS),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_STEP, Material.CRIMSON_PLANKS)
                                )),
                                // --- Nether Wood Hanging Sign Sounds ---
                                new SoundCategory("Nether Wood Hanging Sign Sounds", Material.CRIMSON_HANGING_SIGN, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_HANGING_SIGN_BREAK, Material.CRIMSON_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_HANGING_SIGN_FALL, Material.CRIMSON_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_HANGING_SIGN_HIT, Material.CRIMSON_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_HANGING_SIGN_PLACE, Material.CRIMSON_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_HANGING_SIGN_STEP, Material.CRIMSON_HANGING_SIGN)
                                )),
                                // --- Nether Wood Door Sounds ---
                                new SoundCategory("Nether Wood Door Sounds", Material.CRIMSON_DOOR, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_DOOR_CLOSE, Material.CRIMSON_DOOR),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_DOOR_OPEN, Material.CRIMSON_DOOR)
                                )),
                                // --- Nether Wood Button Sounds ---
                                new SoundCategory("Nether Wood Button Sounds", Material.CRIMSON_BUTTON, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_BUTTON_CLICK_OFF, Material.CRIMSON_BUTTON),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_BUTTON_CLICK_ON, Material.CRIMSON_BUTTON)
                                )),
                                // --- Soul Sand Sounds ---
                                new SoundCategory("Soul Sand Sounds", Material.SOUL_SAND, List.of(
                                        new SoundData(Sound.BLOCK_SOUL_SAND_BREAK, Material.SOUL_SAND),
                                        new SoundData(Sound.BLOCK_SOUL_SAND_FALL, Material.SOUL_SAND),
                                        new SoundData(Sound.BLOCK_SOUL_SAND_HIT, Material.SOUL_SAND),
                                        new SoundData(Sound.BLOCK_SOUL_SAND_PLACE, Material.SOUL_SAND),
                                        new SoundData(Sound.BLOCK_SOUL_SAND_STEP, Material.SOUL_SAND)
                                )),
                                // --- Soul Soil Sounds ---
                                new SoundCategory("Soul Soil Sounds", Material.SOUL_SOIL, List.of(
                                        new SoundData(Sound.BLOCK_SOUL_SOIL_BREAK, Material.SOUL_SOIL),
                                        new SoundData(Sound.BLOCK_SOUL_SOIL_FALL, Material.SOUL_SOIL),
                                        new SoundData(Sound.BLOCK_SOUL_SOIL_HIT, Material.SOUL_SOIL),
                                        new SoundData(Sound.BLOCK_SOUL_SOIL_PLACE, Material.SOUL_SOIL),
                                        new SoundData(Sound.BLOCK_SOUL_SOIL_STEP, Material.SOUL_SOIL)
                                )),
                                // --- Wart Block Sounds ---
                                new SoundCategory("Wart Block Sounds", Material.NETHER_WART_BLOCK, List.of(
                                        new SoundData(Sound.BLOCK_WART_BLOCK_BREAK, Material.NETHER_WART_BLOCK),
                                        new SoundData(Sound.BLOCK_WART_BLOCK_FALL, Material.NETHER_WART_BLOCK),
                                        new SoundData(Sound.BLOCK_WART_BLOCK_HIT, Material.NETHER_WART_BLOCK),
                                        new SoundData(Sound.BLOCK_WART_BLOCK_PLACE, Material.NETHER_WART_BLOCK),
                                        new SoundData(Sound.BLOCK_WART_BLOCK_STEP, Material.NETHER_WART_BLOCK)
                                )),
                                // --- Nether Wood Fence Gate Sounds ---
                                new SoundCategory("Nether Wood Fence Gate Sounds", Material.CRIMSON_FENCE_GATE, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_FENCE_GATE_CLOSE, Material.CRIMSON_FENCE_GATE),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_FENCE_GATE_OPEN, Material.CRIMSON_FENCE_GATE)
                                )),
                                // --- Nether Wood Pressure Plate Sounds ---
                                new SoundCategory("Nether Wood Pressure Plate Sounds", Material.CRIMSON_PRESSURE_PLATE, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF, Material.CRIMSON_PRESSURE_PLATE),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_PRESSURE_PLATE_CLICK_ON, Material.CRIMSON_PRESSURE_PLATE)
                                )),
                                // --- Nether Wood Trapdoor Sounds ---
                                new SoundCategory("Nether Wood Trapdoor Sounds", Material.CRIMSON_TRAPDOOR, List.of(
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_TRAPDOOR_CLOSE, Material.CRIMSON_TRAPDOOR),
                                        new SoundData(Sound.BLOCK_NETHER_WOOD_TRAPDOOR_OPEN, Material.CRIMSON_TRAPDOOR)
                                )),
                                // --- Fungus Sounds ---
                                new SoundCategory("Fungus Sounds", Material.CRIMSON_FUNGUS, List.of(
                                        new SoundData(Sound.BLOCK_FUNGUS_BREAK, Material.CRIMSON_FUNGUS),
                                        // new SoundData(Sound.BLOCK_FUNGUS_FALL, Material.CRIMSON_FUNGUS), plays no sound
                                        // new SoundData(Sound.BLOCK_FUNGUS_HIT, Material.CRIMSON_FUNGUS), plays no sound
                                        new SoundData(Sound.BLOCK_FUNGUS_PLACE, Material.CRIMSON_FUNGUS),
                                        new SoundData(Sound.BLOCK_FUNGUS_STEP, Material.CRIMSON_FUNGUS)
                                )),
                                // --- Roots Sounds ---
                                new SoundCategory("Roots Sounds", Material.CRIMSON_ROOTS, List.of(
                                        new SoundData(Sound.BLOCK_ROOTS_BREAK, Material.CRIMSON_ROOTS),
                                        new SoundData(Sound.BLOCK_ROOTS_FALL, Material.CRIMSON_ROOTS),
                                        new SoundData(Sound.BLOCK_ROOTS_HIT, Material.CRIMSON_ROOTS),
                                        new SoundData(Sound.BLOCK_ROOTS_PLACE, Material.CRIMSON_ROOTS),
                                        new SoundData(Sound.BLOCK_ROOTS_STEP, Material.CRIMSON_ROOTS)
                                )),
                                // --- Stem Sounds ---
                                new SoundCategory("Stem Sounds", Material.WARPED_STEM, List.of(
                                        new SoundData(Sound.BLOCK_STEM_BREAK, Material.WARPED_STEM),
                                        new SoundData(Sound.BLOCK_STEM_FALL, Material.WARPED_STEM),
                                        new SoundData(Sound.BLOCK_STEM_HIT, Material.WARPED_STEM),
                                        new SoundData(Sound.BLOCK_STEM_PLACE, Material.WARPED_STEM),
                                        new SoundData(Sound.BLOCK_STEM_STEP, Material.WARPED_STEM)
                                )),
                                // --- Weeping Vines Sounds ---
                                new SoundCategory("Weeping Vines Sounds", Material.WEEPING_VINES, List.of(
                                        new SoundData(Sound.BLOCK_WEEPING_VINES_BREAK, Material.WEEPING_VINES),
                                        new SoundData(Sound.BLOCK_WEEPING_VINES_FALL, Material.WEEPING_VINES),
                                        new SoundData(Sound.BLOCK_WEEPING_VINES_HIT, Material.WEEPING_VINES),
                                        new SoundData(Sound.BLOCK_WEEPING_VINES_PLACE, Material.WEEPING_VINES),
                                        new SoundData(Sound.BLOCK_WEEPING_VINES_STEP, Material.WEEPING_VINES)
                                ))
                        )),
                        // ********************************
                        // *** FUNCTIONAL BLOCKS SOUNDS ***
                        // ********************************
                        new SoundCategory("Functional Blocks Sounds", Material.FURNACE, List.of(
                                // --- Stone Button Sounds ---
                                new SoundCategory("Stone Button Sounds", Material.STONE_BUTTON, List.of(
                                        new SoundData(Sound.BLOCK_STONE_BUTTON_CLICK_OFF, Material.STONE_BUTTON),
                                        new SoundData(Sound.BLOCK_STONE_BUTTON_CLICK_ON, Material.STONE_BUTTON)
                                )),
                                // --- Stone Pressure Plate Sounds ---
                                new SoundCategory("Stone Pressure Plate Sounds", Material.STONE_PRESSURE_PLATE, List.of(
                                        new SoundData(Sound.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, Material.STONE_PRESSURE_PLATE),
                                        new SoundData(Sound.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON, Material.STONE_PRESSURE_PLATE)
                                )),
                                // --- Scaffolding Sounds ---
                                new SoundCategory("Scaffolding Sounds", Material.SCAFFOLDING, List.of(
                                        new SoundData(Sound.BLOCK_SCAFFOLDING_BREAK, Material.SCAFFOLDING),
                                        new SoundData(Sound.BLOCK_SCAFFOLDING_FALL, Material.SCAFFOLDING),
                                        new SoundData(Sound.BLOCK_SCAFFOLDING_HIT, Material.SCAFFOLDING),
                                        new SoundData(Sound.BLOCK_SCAFFOLDING_PLACE, Material.SCAFFOLDING),
                                        new SoundData(Sound.BLOCK_SCAFFOLDING_STEP, Material.SCAFFOLDING)
                                )),
                                // --- Tripwire Sounds ---
                                new SoundCategory("Tripwire Sounds", Material.TRIPWIRE_HOOK, List.of(
                                        new SoundData(Sound.BLOCK_TRIPWIRE_ATTACH, Material.TRIPWIRE_HOOK),
                                        new SoundData(Sound.BLOCK_TRIPWIRE_CLICK_OFF, Material.TRIPWIRE_HOOK),
                                        new SoundData(Sound.BLOCK_TRIPWIRE_CLICK_ON, Material.TRIPWIRE_HOOK),
                                        new SoundData(Sound.BLOCK_TRIPWIRE_DETACH, Material.TRIPWIRE_HOOK)
                                )),
                                // --- Smithing Table Sound ---
                                new SoundCategory("Smithing Table Sounds", Material.SMITHING_TABLE, List.of(
                                        new SoundData(Sound.BLOCK_SMITHING_TABLE_USE, Material.SMITHING_TABLE)
                                )),
                                // --- Smoker Sounds ---
                                new SoundCategory("Smoker Sounds", Material.SMOKER, List.of(
                                        new SoundData(Sound.BLOCK_SMOKER_SMOKE, Material.SMOKER)
                                )),
                                // --- Sniffer Egg Sounds ---
                                new SoundCategory("Sniffer Egg Sounds", Material.SNIFFER_EGG, List.of(
                                        new SoundData(Sound.BLOCK_SNIFFER_EGG_CRACK, Material.SNIFFER_EGG),
                                        new SoundData(Sound.BLOCK_SNIFFER_EGG_HATCH, Material.SNIFFER_EGG),
                                        new SoundData(Sound.BLOCK_SNIFFER_EGG_PLOP, Material.SNIFFER_EGG)
                                )),
                                // --- Sculk Sounds ---
                                new SoundCategory("Sculk Sounds", Material.SCULK, List.of(
                                        new SoundData(Sound.BLOCK_SCULK_BREAK, Material.SCULK),
                                        new SoundData(Sound.BLOCK_SCULK_CHARGE, Material.SCULK),
                                        new SoundData(Sound.BLOCK_SCULK_FALL, Material.SCULK),
                                        new SoundData(Sound.BLOCK_SCULK_HIT, Material.SCULK),
                                        new SoundData(Sound.BLOCK_SCULK_PLACE, Material.SCULK),
                                        new SoundData(Sound.BLOCK_SCULK_SPREAD, Material.SCULK),
                                        new SoundData(Sound.BLOCK_SCULK_STEP, Material.SCULK)
                                )),
                                // --- Sculk Catalyst Sounds ---
                                new SoundCategory("Sculk Catalyst Sounds", Material.SCULK_CATALYST, List.of(
                                        new SoundData(Sound.BLOCK_SCULK_CATALYST_BLOOM, Material.SCULK_CATALYST),
                                        new SoundData(Sound.BLOCK_SCULK_CATALYST_BREAK, Material.SCULK_CATALYST),
                                        new SoundData(Sound.BLOCK_SCULK_CATALYST_FALL, Material.SCULK_CATALYST),
                                        new SoundData(Sound.BLOCK_SCULK_CATALYST_HIT, Material.SCULK_CATALYST),
                                        new SoundData(Sound.BLOCK_SCULK_CATALYST_PLACE, Material.SCULK_CATALYST),
                                        new SoundData(Sound.BLOCK_SCULK_CATALYST_STEP, Material.SCULK_CATALYST)
                                )),
                                // --- Sculk Sensor Sounds ---
                                new SoundCategory("Sculk Sensor Sounds", Material.SCULK_SENSOR, List.of(
                                        new SoundData(Sound.BLOCK_SCULK_SENSOR_BREAK, Material.SCULK_SENSOR),
                                        new SoundData(Sound.BLOCK_SCULK_SENSOR_CLICKING, Material.SCULK_SENSOR),
                                        new SoundData(Sound.BLOCK_SCULK_SENSOR_CLICKING_STOP, Material.SCULK_SENSOR),
                                        new SoundData(Sound.BLOCK_SCULK_SENSOR_FALL, Material.SCULK_SENSOR),
                                        new SoundData(Sound.BLOCK_SCULK_SENSOR_HIT, Material.SCULK_SENSOR),
                                        new SoundData(Sound.BLOCK_SCULK_SENSOR_PLACE, Material.SCULK_SENSOR),
                                        new SoundData(Sound.BLOCK_SCULK_SENSOR_STEP, Material.SCULK_SENSOR)
                                )),
                                // --- Sculk Shrieker Sounds ---
                                new SoundCategory("Sculk Shrieker Sounds", Material.SCULK_SHRIEKER, List.of(
                                        new SoundData(Sound.BLOCK_SCULK_SHRIEKER_BREAK, Material.SCULK_SHRIEKER),
                                        new SoundData(Sound.BLOCK_SCULK_SHRIEKER_FALL, Material.SCULK_SHRIEKER),
                                        new SoundData(Sound.BLOCK_SCULK_SHRIEKER_HIT, Material.SCULK_SHRIEKER),
                                        new SoundData(Sound.BLOCK_SCULK_SHRIEKER_PLACE, Material.SCULK_SHRIEKER),
                                        new SoundData(Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, Material.SCULK_SHRIEKER),
                                        new SoundData(Sound.BLOCK_SCULK_SHRIEKER_STEP, Material.SCULK_SHRIEKER)
                                )),
                                // --- Sculk Vein Sounds ---
                                new SoundCategory("Sculk Vein Sounds", Material.SCULK_VEIN, List.of(
                                        new SoundData(Sound.BLOCK_SCULK_VEIN_BREAK, Material.SCULK_VEIN),
                                        new SoundData(Sound.BLOCK_SCULK_VEIN_FALL, Material.SCULK_VEIN),
                                        new SoundData(Sound.BLOCK_SCULK_VEIN_HIT, Material.SCULK_VEIN),
                                        new SoundData(Sound.BLOCK_SCULK_VEIN_PLACE, Material.SCULK_VEIN),
                                        new SoundData(Sound.BLOCK_SCULK_VEIN_STEP, Material.SCULK_VEIN)
                                )),
                                // --- Shroomlight Sounds ---
                                new SoundCategory("Shroomlight Sounds", Material.SHROOMLIGHT, List.of(
                                        new SoundData(Sound.BLOCK_SHROOMLIGHT_BREAK, Material.SHROOMLIGHT),
                                        new SoundData(Sound.BLOCK_SHROOMLIGHT_FALL, Material.SHROOMLIGHT),
                                        new SoundData(Sound.BLOCK_SHROOMLIGHT_HIT, Material.SHROOMLIGHT),
                                        new SoundData(Sound.BLOCK_SHROOMLIGHT_PLACE, Material.SHROOMLIGHT),
                                        new SoundData(Sound.BLOCK_SHROOMLIGHT_STEP, Material.SHROOMLIGHT)
                                )),
                                // --- Shulker Box Sounds ---
                                new SoundCategory("Shulker Box Sounds", Material.SHULKER_BOX, List.of(
                                        new SoundData(Sound.BLOCK_SHULKER_BOX_CLOSE, Material.SHULKER_BOX),
                                        new SoundData(Sound.BLOCK_SHULKER_BOX_OPEN, Material.SHULKER_BOX)
                                )),
                                // --- Piston Sounds ---
                                new SoundCategory("Piston Sounds", Material.PISTON, List.of(
                                        new SoundData(Sound.BLOCK_PISTON_CONTRACT, Material.PISTON),
                                        new SoundData(Sound.BLOCK_PISTON_EXTEND, Material.PISTON)
                                )),
                                // --- Lodestone Sounds ---
                                new SoundCategory("Lodestone Sounds", Material.LODESTONE, List.of(
                                        new SoundData(Sound.BLOCK_LODESTONE_BREAK, Material.LODESTONE),
                                        new SoundData(Sound.BLOCK_LODESTONE_FALL, Material.LODESTONE),
                                        new SoundData(Sound.BLOCK_LODESTONE_HIT, Material.LODESTONE),
                                        new SoundData(Sound.BLOCK_LODESTONE_PLACE, Material.LODESTONE),
                                        new SoundData(Sound.BLOCK_LODESTONE_STEP, Material.LODESTONE)
                                )),
                                // --- Hanging Sign Sounds ---
                                new SoundCategory("Hanging Sign Sounds", Material.OAK_HANGING_SIGN, List.of(
                                        new SoundData(Sound.BLOCK_HANGING_SIGN_BREAK, Material.OAK_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_HANGING_SIGN_FALL, Material.OAK_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_HANGING_SIGN_HIT, Material.OAK_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_HANGING_SIGN_PLACE, Material.OAK_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_HANGING_SIGN_STEP, Material.OAK_HANGING_SIGN),
                                        new SoundData(Sound.BLOCK_HANGING_SIGN_WAXED_INTERACT_FAIL, Material.OAK_HANGING_SIGN)
                                )),
                                // --- Grindstone Sounds ---
                                new SoundCategory("Grindstone Sounds", Material.GRINDSTONE, List.of(
                                        new SoundData(Sound.BLOCK_GRINDSTONE_USE, Material.GRINDSTONE)
                                )),
                                // --- Fence Gate Sounds ---
                                new SoundCategory("Fence Gate Sounds", Material.OAK_FENCE_GATE, List.of(
                                        new SoundData(Sound.BLOCK_FENCE_GATE_CLOSE, Material.OAK_FENCE_GATE),
                                        new SoundData(Sound.BLOCK_FENCE_GATE_OPEN, Material.OAK_FENCE_GATE)
                                )),
                                // --- Ender Chest Sounds ---
                                new SoundCategory("Ender Chest Sounds", Material.ENDER_CHEST, List.of(
                                        new SoundData(Sound.BLOCK_ENDER_CHEST_CLOSE, Material.ENDER_CHEST),
                                        new SoundData(Sound.BLOCK_ENDER_CHEST_OPEN, Material.ENDER_CHEST)
                                )),
                                // --- Enchantment Table Sounds ---
                                new SoundCategory("Enchantment Table Sounds", Material.ENCHANTING_TABLE, List.of(
                                        new SoundData(Sound.BLOCK_ENCHANTMENT_TABLE_USE, Material.ENCHANTING_TABLE)
                                )),
                                // --- Dispenser Sounds ---
                                new SoundCategory("Dispenser Sounds", Material.DISPENSER, List.of(
                                        new SoundData(Sound.BLOCK_DISPENSER_DISPENSE, Material.DISPENSER),
                                        new SoundData(Sound.BLOCK_DISPENSER_FAIL, Material.DISPENSER),
                                        new SoundData(Sound.BLOCK_DISPENSER_LAUNCH, Material.DISPENSER)
                                )),
                                // --- Crafter Sounds ---
                                new SoundCategory("Crafter Sounds", Material.CRAFTER, List.of(
                                        new SoundData(Sound.BLOCK_CRAFTER_CRAFT, Material.CRAFTER),
                                        new SoundData(Sound.BLOCK_CRAFTER_FAIL, Material.CRAFTER)
                                )),
                                // --- Composter Sounds ---
                                new SoundCategory("Composter Sounds", Material.COMPOSTER, List.of(
                                        new SoundData(Sound.BLOCK_COMPOSTER_EMPTY, Material.COMPOSTER),
                                        new SoundData(Sound.BLOCK_COMPOSTER_FILL, Material.COMPOSTER),
                                        new SoundData(Sound.BLOCK_COMPOSTER_FILL_SUCCESS, Material.COMPOSTER),
                                        new SoundData(Sound.BLOCK_COMPOSTER_READY, Material.COMPOSTER)
                                )),
                                // --- Conduit Sounds ---
                                new SoundCategory("Conduit Sounds", Material.CONDUIT, List.of(
                                        new SoundData(Sound.BLOCK_CONDUIT_ACTIVATE, Material.CONDUIT),
                                        new SoundData(Sound.BLOCK_CONDUIT_AMBIENT, Material.CONDUIT),
                                        new SoundData(Sound.BLOCK_CONDUIT_AMBIENT_SHORT, Material.CONDUIT),
                                        new SoundData(Sound.BLOCK_CONDUIT_ATTACK_TARGET, Material.CONDUIT),
                                        new SoundData(Sound.BLOCK_CONDUIT_DEACTIVATE, Material.CONDUIT)
                                )),
                                // --- Comparator Sounds ---
                                new SoundCategory("Comparator Sounds", Material.COMPARATOR, List.of(
                                        new SoundData(Sound.BLOCK_COMPARATOR_CLICK, Material.COMPARATOR)
                                )),
                                // --- Chiseled Bookshelf Sounds ---
                                new SoundCategory("Chiseled Bookshelf Sounds", Material.CHISELED_BOOKSHELF, List.of(
                                        new SoundData(Sound.BLOCK_CHISELED_BOOKSHELF_BREAK, Material.CHISELED_BOOKSHELF),
                                        new SoundData(Sound.BLOCK_CHISELED_BOOKSHELF_FALL, Material.CHISELED_BOOKSHELF),
                                        new SoundData(Sound.BLOCK_CHISELED_BOOKSHELF_HIT, Material.CHISELED_BOOKSHELF),
                                        new SoundData(Sound.BLOCK_CHISELED_BOOKSHELF_INSERT, Material.CHISELED_BOOKSHELF),
                                        new SoundData(Sound.BLOCK_CHISELED_BOOKSHELF_INSERT_ENCHANTED, Material.CHISELED_BOOKSHELF),
                                        new SoundData(Sound.BLOCK_CHISELED_BOOKSHELF_PICKUP, Material.CHISELED_BOOKSHELF),
                                        new SoundData(Sound.BLOCK_CHISELED_BOOKSHELF_PICKUP_ENCHANTED, Material.CHISELED_BOOKSHELF),
                                        new SoundData(Sound.BLOCK_CHISELED_BOOKSHELF_PLACE, Material.CHISELED_BOOKSHELF),
                                        new SoundData(Sound.BLOCK_CHISELED_BOOKSHELF_STEP, Material.CHISELED_BOOKSHELF)
                                ))
                        ))
                )),
                // 3rd SoundCategory
                // ITEM SOUNDS:
                // 1. Trident Sounds 2. Goat Horn Sounds 3. Crossbow Sounds
                // 4. Bucket Sounds 5. Bottle Sounds 6. Wolf Armor Sounds
                // 7. Player Armor Sounds 8. Axe Sounds 9. Brush Sounds
                // 10. Bundle Sounds 11. Mace Sounds 12. Other Item Sounds
                new SoundCategory("Item Sounds", Material.DIAMOND_AXE, List.of(
                        // --- Trident Sounds ---
                        new SoundCategory("Trident Sounds", Material.TRIDENT, List.of(
                                new SoundData(Sound.ITEM_TRIDENT_HIT, Material.TRIDENT),
                                new SoundData(Sound.ITEM_TRIDENT_HIT_GROUND, Material.TRIDENT),
                                new SoundData(Sound.ITEM_TRIDENT_RETURN, Material.TRIDENT),
                                new SoundData(Sound.ITEM_TRIDENT_RIPTIDE_1, Material.TRIDENT),
                                new SoundData(Sound.ITEM_TRIDENT_RIPTIDE_2, Material.TRIDENT),
                                new SoundData(Sound.ITEM_TRIDENT_RIPTIDE_3, Material.TRIDENT),
                                new SoundData(Sound.ITEM_TRIDENT_THROW, Material.TRIDENT),
                                new SoundData(Sound.ITEM_TRIDENT_THUNDER, Material.TRIDENT)
                        )),
                        // --- Goat Horn Sounds ---
                        new SoundCategory("Goat Horn Sounds", Material.GOAT_HORN, List.of(
                                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_0, Material.GOAT_HORN),
                                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_1, Material.GOAT_HORN),
                                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_2, Material.GOAT_HORN),
                                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_3, Material.GOAT_HORN),
                                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_4, Material.GOAT_HORN),
                                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_5, Material.GOAT_HORN),
                                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_6, Material.GOAT_HORN),
                                new SoundData(Sound.ITEM_GOAT_HORN_SOUND_7, Material.GOAT_HORN)
                        )),
                        // --- Crossbow Sounds ---
                        new SoundCategory("Crossbow Sounds", Material.CROSSBOW, List.of(
                                new SoundData(Sound.ITEM_CROSSBOW_HIT, Material.CROSSBOW),
                                new SoundData(Sound.ITEM_CROSSBOW_LOADING_END, Material.CROSSBOW),
                                new SoundData(Sound.ITEM_CROSSBOW_LOADING_MIDDLE, Material.CROSSBOW),
                                new SoundData(Sound.ITEM_CROSSBOW_LOADING_START, Material.CROSSBOW),
                                new SoundData(Sound.ITEM_CROSSBOW_QUICK_CHARGE_1, Material.CROSSBOW),
                                new SoundData(Sound.ITEM_CROSSBOW_QUICK_CHARGE_2, Material.CROSSBOW),
                                new SoundData(Sound.ITEM_CROSSBOW_QUICK_CHARGE_3, Material.CROSSBOW),
                                new SoundData(Sound.ITEM_CROSSBOW_SHOOT, Material.CROSSBOW)
                        )),
                        // --- Bucket Sounds ---
                        new SoundCategory("Bucket Sounds", Material.BUCKET, List.of(
                                new SoundData(Sound.ITEM_BUCKET_EMPTY, Material.BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_EMPTY_AXOLOTL, Material.AXOLOTL_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_EMPTY_FISH, Material.COD_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_EMPTY_LAVA, Material.LAVA_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_EMPTY_POWDER_SNOW, Material.POWDER_SNOW_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_EMPTY_TADPOLE, Material.TADPOLE_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_FILL, Material.WATER_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_FILL_AXOLOTL, Material.AXOLOTL_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_FILL_FISH, Material.COD_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_FILL_LAVA, Material.LAVA_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_FILL_POWDER_SNOW, Material.POWDER_SNOW_BUCKET),
                                new SoundData(Sound.ITEM_BUCKET_FILL_TADPOLE, Material.TADPOLE_BUCKET)
                        )),
                        // --- Bottle Sounds ---
                        new SoundCategory("Bottle Sounds", Material.GLASS_BOTTLE, List.of(
                                new SoundData(Sound.ITEM_BOTTLE_EMPTY, Material.GLASS_BOTTLE),
                                new SoundData(Sound.ITEM_BOTTLE_FILL, Material.POTION),
                                new SoundData(Sound.ITEM_BOTTLE_FILL_DRAGONBREATH, Material.DRAGON_BREATH),
                                new SoundData(Sound.ITEM_HONEY_BOTTLE_DRINK, Material.POTION),
                                new SoundData(Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, Material.EXPERIENCE_BOTTLE)
                        )),
                        // --- Wolf Armor Sounds ---
                        new SoundCategory("Wolf Armor Sounds", Material.WOLF_ARMOR, List.of(
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_WOLF, Material.WOLF_ARMOR),
                                new SoundData(Sound.ITEM_ARMOR_UNEQUIP_WOLF, Material.WOLF_ARMOR),
                                new SoundData(Sound.ITEM_WOLF_ARMOR_BREAK, Material.WOLF_ARMOR),
                                new SoundData(Sound.ITEM_WOLF_ARMOR_CRACK, Material.WOLF_ARMOR),
                                new SoundData(Sound.ITEM_WOLF_ARMOR_DAMAGE, Material.WOLF_ARMOR),
                                new SoundData(Sound.ITEM_WOLF_ARMOR_REPAIR, Material.WOLF_ARMOR)
                        )),
                        // --- Player Armor Sounds ---
                        new SoundCategory("Player Armor Sounds", Material.IRON_CHESTPLATE, List.of(
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_CHAIN, Material.CHAINMAIL_CHESTPLATE),
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_DIAMOND, Material.DIAMOND_CHESTPLATE),
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_ELYTRA, Material.ELYTRA),
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_GENERIC, Material.LEATHER_CHESTPLATE),
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_GOLD, Material.GOLDEN_CHESTPLATE),
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_IRON, Material.IRON_CHESTPLATE),
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_LEATHER, Material.LEATHER_CHESTPLATE),
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_NETHERITE, Material.NETHERITE_CHESTPLATE),
                                new SoundData(Sound.ITEM_ARMOR_EQUIP_TURTLE, Material.TURTLE_HELMET)
                        )),
                        // --- Axe Sounds ---
                        new SoundCategory("Axe Sounds", Material.IRON_AXE, List.of(
                                new SoundData(Sound.ITEM_AXE_SCRAPE, Material.IRON_AXE),
                                new SoundData(Sound.ITEM_AXE_STRIP, Material.IRON_AXE),
                                new SoundData(Sound.ITEM_AXE_WAX_OFF, Material.IRON_AXE)
                        )),
                        // --- Brush Sounds ---
                        new SoundCategory("Brush Sounds", Material.BRUSH, List.of(
                                new SoundData(Sound.ITEM_BRUSH_BRUSHING_GENERIC, Material.BRUSH),
                                new SoundData(Sound.ITEM_BRUSH_BRUSHING_GRAVEL, Material.BRUSH),
                                new SoundData(Sound.ITEM_BRUSH_BRUSHING_GRAVEL_COMPLETE, Material.BRUSH),
                                new SoundData(Sound.ITEM_BRUSH_BRUSHING_SAND, Material.BRUSH),
                                new SoundData(Sound.ITEM_BRUSH_BRUSHING_SAND_COMPLETE, Material.BRUSH)
                        )),
                        // --- Bundle Sounds ---
                        new SoundCategory("Bundle Sounds", Material.BUNDLE, List.of(
                                new SoundData(Sound.ITEM_BUNDLE_DROP_CONTENTS, Material.ORANGE_BUNDLE),
                                new SoundData(Sound.ITEM_BUNDLE_INSERT, Material.BLUE_BUNDLE),
                                new SoundData(Sound.ITEM_BUNDLE_INSERT_FAIL, Material.RED_BUNDLE),
                                new SoundData(Sound.ITEM_BUNDLE_REMOVE_ONE, Material.YELLOW_BUNDLE)
                        )),
                        // --- Mace Sounds ---
                        new SoundCategory("Mace Sounds", Material.MACE, List.of(
                                new SoundData(Sound.ITEM_MACE_SMASH_AIR, Material.MACE),
                                new SoundData(Sound.ITEM_MACE_SMASH_GROUND, Material.MACE),
                                new SoundData(Sound.ITEM_MACE_SMASH_GROUND_HEAVY, Material.MACE)
                        )),
                        // --- Spyglass Sounds ---
                        new SoundCategory("Spyglass Sounds", Material.SPYGLASS, List.of(
                                new SoundData(Sound.ITEM_SPYGLASS_USE, Material.SPYGLASS),
                                new SoundData(Sound.ITEM_SPYGLASS_STOP_USING, Material.SPYGLASS)
                        )),
                        // --- Book Sounds ---
                        new SoundCategory("Book Sounds", Material.BOOK, List.of(
                                new SoundData(Sound.ITEM_BOOK_PAGE_TURN, Material.BOOK),
                                new SoundData(Sound.ITEM_BOOK_PUT, Material.BOOK)
                        )),
                        // --- Shield Sounds ---
                        new SoundCategory("Shield Sounds", Material.SHIELD, List.of(
                                new SoundData(Sound.ITEM_SHIELD_BLOCK, Material.SHIELD),
                                new SoundData(Sound.ITEM_SHIELD_BREAK, Material.SHIELD)
                        )),
                        // --- Other Item Sounds ---
                        new SoundCategory("Other Item Sounds", Material.BONE_MEAL, List.of(
                                new SoundData(Sound.ITEM_BONE_MEAL_USE, Material.BONE_MEAL),
                                new SoundData(Sound.ITEM_CROP_PLANT, Material.WHEAT_SEEDS),
                                new SoundData(Sound.ITEM_NETHER_WART_PLANT, Material.NETHER_WART),
                                new SoundData(Sound.ITEM_ELYTRA_FLYING, Material.ELYTRA),
                                new SoundData(Sound.ITEM_DYE_USE, Material.GREEN_DYE),
                                new SoundData(Sound.ITEM_GLOW_INK_SAC_USE, Material.GLOW_INK_SAC),
                                new SoundData(Sound.ITEM_INK_SAC_USE, Material.INK_SAC),
                                new SoundData(Sound.ITEM_HOE_TILL, Material.IRON_HOE),
                                new SoundData(Sound.ITEM_SHOVEL_FLATTEN, Material.IRON_SHOVEL),
                                new SoundData(Sound.ITEM_LODESTONE_COMPASS_LOCK, Material.RECOVERY_COMPASS),
                                new SoundData(Sound.ITEM_FIRECHARGE_USE, Material.FIRE_CHARGE),
                                new SoundData(Sound.ITEM_FLINTANDSTEEL_USE, Material.FLINT_AND_STEEL),
                                new SoundData(Sound.ITEM_HONEYCOMB_WAX_ON, Material.HONEYCOMB),
                                new SoundData(Sound.ITEM_TOTEM_USE, Material.TOTEM_OF_UNDYING),
                                new SoundData(Sound.ITEM_CHORUS_FRUIT_TELEPORT, Material.CHORUS_FRUIT),
                                new SoundData(Sound.ITEM_OMINOUS_BOTTLE_DISPOSE, Material.OMINOUS_BOTTLE)
                        ))
                )),

                // 4th SoundCategory
                // NOTEBLOCK SOUNDS:
                // Noteblock Sounds
                new SoundCategory("Noteblock Sounds", Material.NOTE_BLOCK, List.of(
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
                        new SoundCategory("Noteblock Imititation Sounds", Material.JUKEBOX, List.of(
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
                        ))
                )),
                // 5th SoundCategory
                // OTHER SOUNDS:
                // 1. Music Disc Tracks 2. Biome Ambience Sounds 3. Weather Sounds
                // 4. Music Sounds 5. UI Sounds 6. Uncategorized Sounds
                new SoundCategory("Other Sounds", Material.NETHER_STAR, List.of(
                        // --- Music Disc Tracks ---
                        new SoundCategory("Music Disc Tracks", Material.MUSIC_DISC_13, List.of(
                                new SoundData(Sound.MUSIC_DISC_11, Material.MUSIC_DISC_11),
                                new SoundData(Sound.MUSIC_DISC_13, Material.MUSIC_DISC_13),
                                new SoundData(Sound.MUSIC_DISC_5, Material.MUSIC_DISC_5),
                                new SoundData(Sound.MUSIC_DISC_BLOCKS, Material.MUSIC_DISC_BLOCKS),
                                new SoundData(Sound.MUSIC_DISC_CAT, Material.MUSIC_DISC_CAT),
                                new SoundData(Sound.MUSIC_DISC_CHIRP, Material.MUSIC_DISC_CHIRP),
                                new SoundData(Sound.MUSIC_DISC_CREATOR, Material.MUSIC_DISC_CREATOR),
                                new SoundData(Sound.MUSIC_DISC_CREATOR_MUSIC_BOX, Material.MUSIC_DISC_CREATOR_MUSIC_BOX),
                                new SoundData(Sound.MUSIC_DISC_FAR, Material.MUSIC_DISC_FAR),
                                new SoundData(Sound.MUSIC_DISC_MALL, Material.MUSIC_DISC_MALL),
                                new SoundData(Sound.MUSIC_DISC_MELLOHI, Material.MUSIC_DISC_MELLOHI),
                                new SoundData(Sound.MUSIC_DISC_OTHERSIDE, Material.MUSIC_DISC_OTHERSIDE),
                                new SoundData(Sound.MUSIC_DISC_PIGSTEP, Material.MUSIC_DISC_PIGSTEP),
                                new SoundData(Sound.MUSIC_DISC_PRECIPICE, Material.MUSIC_DISC_PRECIPICE),
                                new SoundData(Sound.MUSIC_DISC_RELIC, Material.MUSIC_DISC_RELIC),
                                new SoundData(Sound.MUSIC_DISC_STAL, Material.MUSIC_DISC_STAL),
                                new SoundData(Sound.MUSIC_DISC_STRAD, Material.MUSIC_DISC_STRAD),
                                new SoundData(Sound.MUSIC_DISC_WAIT, Material.MUSIC_DISC_WAIT),
                                new SoundData(Sound.MUSIC_DISC_WARD, Material.MUSIC_DISC_WARD)
                        )),
                        // --- Biome Ambience Sounds ---
                        new SoundCategory("Ambient Sounds", Material.PINK_PETALS, List.of(
                                new SoundData(Sound.AMBIENT_BASALT_DELTAS_ADDITIONS, Material.SMOOTH_BASALT),
                                new SoundData(Sound.AMBIENT_BASALT_DELTAS_LOOP, Material.SMOOTH_BASALT),
                                new SoundData(Sound.AMBIENT_BASALT_DELTAS_MOOD, Material.SMOOTH_BASALT),
                                new SoundData(Sound.AMBIENT_CAVE, Material.STONE),
                                new SoundData(Sound.AMBIENT_CRIMSON_FOREST_ADDITIONS, Material.CRIMSON_NYLIUM),
                                new SoundData(Sound.AMBIENT_CRIMSON_FOREST_LOOP, Material.CRIMSON_NYLIUM),
                                new SoundData(Sound.AMBIENT_CRIMSON_FOREST_MOOD, Material.CRIMSON_NYLIUM),
                                new SoundData(Sound.AMBIENT_NETHER_WASTES_ADDITIONS, Material.NETHERRACK),
                                new SoundData(Sound.AMBIENT_NETHER_WASTES_LOOP, Material.NETHERRACK),
                                new SoundData(Sound.AMBIENT_NETHER_WASTES_MOOD, Material.NETHERRACK),
                                new SoundData(Sound.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, Material.SOUL_SAND),
                                new SoundData(Sound.AMBIENT_SOUL_SAND_VALLEY_LOOP, Material.SOUL_SAND),
                                new SoundData(Sound.AMBIENT_SOUL_SAND_VALLEY_MOOD, Material.SOUL_SAND),
                                new SoundData(Sound.AMBIENT_UNDERWATER_ENTER, Material.WATER_BUCKET),
                                new SoundData(Sound.AMBIENT_UNDERWATER_EXIT, Material.WATER_BUCKET),
                                new SoundData(Sound.AMBIENT_UNDERWATER_LOOP, Material.WATER_BUCKET),
                                new SoundData(Sound.AMBIENT_UNDERWATER_LOOP_ADDITIONS, Material.WATER_BUCKET),
                                new SoundData(Sound.AMBIENT_UNDERWATER_LOOP_ADDITIONS_RARE, Material.WATER_BUCKET),
                                new SoundData(Sound.AMBIENT_UNDERWATER_LOOP_ADDITIONS_ULTRA_RARE, Material.WATER_BUCKET),
                                new SoundData(Sound.AMBIENT_WARPED_FOREST_ADDITIONS, Material.WARPED_NYLIUM),
                                new SoundData(Sound.AMBIENT_WARPED_FOREST_LOOP, Material.WARPED_NYLIUM),
                                new SoundData(Sound.AMBIENT_WARPED_FOREST_MOOD, Material.WARPED_NYLIUM)
                        )),
                        // --- Music Sounds ---
                        new SoundCategory("Music Sounds", Material.JUKEBOX, List.of(
                                new SoundData(Sound.MUSIC_CREATIVE, Material.WRITTEN_BOOK),
                                new SoundData(Sound.MUSIC_CREDITS, Material.MOJANG_BANNER_PATTERN),
                                new SoundData(Sound.MUSIC_DRAGON, Material.DRAGON_HEAD),
                                new SoundData(Sound.MUSIC_END, Material.END_PORTAL_FRAME),
                                new SoundData(Sound.MUSIC_GAME, Material.GRASS_BLOCK),
                                new SoundData(Sound.MUSIC_MENU, Material.REDSTONE),
                                new SoundData(Sound.MUSIC_UNDER_WATER, Material.WATER_BUCKET),
                                new SoundData(Sound.MUSIC_NETHER_BASALT_DELTAS, Material.BASALT),
                                new SoundData(Sound.MUSIC_NETHER_CRIMSON_FOREST, Material.CRIMSON_NYLIUM),
                                new SoundData(Sound.MUSIC_NETHER_NETHER_WASTES, Material.NETHERRACK),
                                new SoundData(Sound.MUSIC_NETHER_SOUL_SAND_VALLEY, Material.SOUL_SAND),
                                new SoundData(Sound.MUSIC_NETHER_WARPED_FOREST, Material.WARPED_NYLIUM),
                                new SoundData(Sound.MUSIC_OVERWORLD_BADLANDS, Material.RED_SAND),
                                new SoundData(Sound.MUSIC_OVERWORLD_BAMBOO_JUNGLE, Material.BAMBOO),
                                new SoundData(Sound.MUSIC_OVERWORLD_CHERRY_GROVE, Material.CHERRY_SAPLING),
                                new SoundData(Sound.MUSIC_OVERWORLD_DEEP_DARK, Material.SCULK),
                                new SoundData(Sound.MUSIC_OVERWORLD_DESERT, Material.SAND),
                                new SoundData(Sound.MUSIC_OVERWORLD_DRIPSTONE_CAVES, Material.DRIPSTONE_BLOCK),
                                new SoundData(Sound.MUSIC_OVERWORLD_FLOWER_FOREST, Material.PINK_TULIP),
                                new SoundData(Sound.MUSIC_OVERWORLD_FOREST, Material.OAK_SAPLING),
                                new SoundData(Sound.MUSIC_OVERWORLD_FROZEN_PEAKS, Material.PACKED_ICE),
                                new SoundData(Sound.MUSIC_OVERWORLD_GROVE, Material.SPRUCE_SAPLING),
                                new SoundData(Sound.MUSIC_OVERWORLD_JAGGED_PEAKS, Material.STONE),
                                new SoundData(Sound.MUSIC_OVERWORLD_JUNGLE, Material.JUNGLE_SAPLING),
                                new SoundData(Sound.MUSIC_OVERWORLD_LUSH_CAVES, Material.MOSS_BLOCK),
                                new SoundData(Sound.MUSIC_OVERWORLD_MEADOW, Material.DANDELION),
                                new SoundData(Sound.MUSIC_OVERWORLD_OLD_GROWTH_TAIGA, Material.SPRUCE_SAPLING),
                                new SoundData(Sound.MUSIC_OVERWORLD_SNOWY_SLOPES, Material.SNOW_BLOCK),
                                new SoundData(Sound.MUSIC_OVERWORLD_SPARSE_JUNGLE, Material.JUNGLE_SAPLING),
                                new SoundData(Sound.MUSIC_OVERWORLD_STONY_PEAKS, Material.STONE),
                                new SoundData(Sound.MUSIC_OVERWORLD_SWAMP, Material.SLIME_BALL)
                        )),
                        // --- Weather Sounds ---
                        new SoundCategory("Weather Sounds", Material.WATER_BUCKET, List.of(
                                new SoundData(Sound.WEATHER_RAIN, Material.WATER_BUCKET),
                                new SoundData(Sound.WEATHER_RAIN_ABOVE, Material.WATER_BUCKET)
                        )),
                        // --- Event Sounds ---
                        new SoundCategory("Event Sounds", Material.BELL, List.of(
                                new SoundData(Sound.EVENT_MOB_EFFECT_BAD_OMEN, Material.OMINOUS_BOTTLE),
                                new SoundData(Sound.EVENT_MOB_EFFECT_RAID_OMEN, Material.CROSSBOW),
                                new SoundData(Sound.EVENT_MOB_EFFECT_TRIAL_OMEN, Material.OMINOUS_TRIAL_KEY),
                                new SoundData(Sound.EVENT_RAID_HORN, Material.GOAT_HORN)
                        )),
                        // --- UI Sounds ---
                        new SoundCategory("UI Sounds", Material.PAPER, List.of(
                                new SoundData(Sound.UI_BUTTON_CLICK, Material.STONE_BUTTON),
                                new SoundData(Sound.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, Material.CARTOGRAPHY_TABLE),
                                new SoundData(Sound.UI_HUD_BUBBLE_POP, Material.PUFFERFISH),
                                new SoundData(Sound.UI_LOOM_SELECT_PATTERN, Material.LOOM),
                                new SoundData(Sound.UI_LOOM_TAKE_RESULT, Material.LOOM),
                                new SoundData(Sound.UI_STONECUTTER_SELECT_RECIPE, Material.STONECUTTER),
                                new SoundData(Sound.UI_STONECUTTER_TAKE_RESULT, Material.STONECUTTER),
                                new SoundData(Sound.UI_TOAST_CHALLENGE_COMPLETE, Material.DIAMOND),
                                new SoundData(Sound.UI_TOAST_IN, Material.BREAD),
                                new SoundData(Sound.UI_TOAST_OUT, Material.BREAD)
                        )),
                        // --- Uncategorized Sounds ---
                        new SoundCategory("Uncategorized Sounds", Material.SOUL_LANTERN, List.of(
                                new SoundData(Sound.PARTICLE_SOUL_ESCAPE, Material.SOUL_LANTERN),
                                new SoundData(Sound.ENCHANT_THORNS_HIT, Material.CACTUS)
                        ))
                ))
        ));
        populateMaps(ALL_SOUNDS);
    }

    // Adds categories to both the map of categories and valid all sounds GUI titles
    private static void populateMaps(SoundCategory category) {
        CATEGORY_MAP.put(category.getCategoryTitle(), category);

        for (Object child : category.getChildren()) {
            if (child instanceof SoundCategory childCategory) {
                populateMaps(childCategory);
            } else if (child instanceof SoundData soundData) {
                SOUND_MAP.put(soundData.getFormattedSoundName(), soundData);
            }
        }
    }
}