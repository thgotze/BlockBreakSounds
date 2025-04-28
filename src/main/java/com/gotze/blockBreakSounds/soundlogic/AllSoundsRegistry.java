package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;
import org.bukkit.Sound;

import java.util.ArrayList;
import java.util.List;

public class AllSoundsRegistry {

    public static final List<SoundCategory> CATEGORIES = new ArrayList<>();

    static {
        // -*-*-*- ENTITY SOUNDS -*-*-*-
        SoundCategory ENTITY_SOUNDS = new SoundCategory("Entity Sounds", Material.ENDER_PEARL, List.of(
                new SoundCategory("Passive Mobs", Material.SHEEP_SPAWN_EGG, List.of(
                        new SoundCategory("Chicken Sounds", Material.CHICKEN_SPAWN_EGG, List.of(
                                new SoundData(Sound.ENTITY_CHICKEN_AMBIENT, Material.CHICKEN_SPAWN_EGG),
                                new SoundData(Sound.ENTITY_CHICKEN_HURT, Material.CHICKEN)
                        )),
                        new SoundCategory("Villager Sounds", Material.VILLAGER_SPAWN_EGG, List.of(
                                new SoundData(Sound.ENTITY_VILLAGER_AMBIENT, Material.VILLAGER_SPAWN_EGG),
                                new SoundData(Sound.ENTITY_VILLAGER_CELEBRATE, Material.EMERALD)
                        ))
                )),
                new SoundCategory("Hostile Mobs", Material.ZOMBIE_HEAD, List.of(
                        new SoundCategory("Zombie Sounds", Material.ZOMBIE_SPAWN_EGG, List.of(
                                new SoundData(Sound.ENTITY_ZOMBIE_AMBIENT, Material.ZOMBIE_SPAWN_EGG),
                                new SoundData(Sound.ENTITY_ZOMBIE_DEATH, Material.ZOMBIE_SPAWN_EGG)
                        )),
                        new SoundCategory("Skeleton Sounds", Material.SKELETON_SPAWN_EGG, List.of(
                                new SoundData(Sound.ENTITY_SKELETON_AMBIENT, Material.SKELETON_SPAWN_EGG),
                                new SoundData(Sound.ENTITY_SKELETON_HURT, Material.SKELETON_SPAWN_EGG)
                        ))
                ))
        ));
        CATEGORIES.add(ENTITY_SOUNDS);
    }
}



