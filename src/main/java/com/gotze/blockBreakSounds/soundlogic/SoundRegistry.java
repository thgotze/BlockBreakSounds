package com.gotze.blockBreakSounds.soundlogic;

import org.bukkit.Material;
import org.bukkit.Sound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoundRegistry {
    public static final List<SoundCategory> CATEGORIES = new ArrayList<>();

    static {
        SoundCategory entitySounds = new SoundCategory(
                "Entity Sounds",
                Material.ENDER_PEARL,
                Arrays.asList(
                        new SoundSubCategory("Passive Mobs", Material.SHEEP_SPAWN_EGG, List.of(
                                new SoundData(Sound.ENTITY_COW_AMBIENT, Material.COW),
                                new SoundData(Sound.ENTITY_SHEEP_AMBIENT, Material.SHEEP)
                        )),
                        new SoundSubCategory("Hostile Mobs", Material.ZOMBIE_SPAWN_EGG, List.of(
                                new SoundData(Sound.ENTITY_ZOMBIE_AMBIENT, Material.ZOMBIE_HEAD)
                        ))
                )
        );

        // Repeat for Block Sounds, Item Sounds, etc.
        CATEGORIES.add(entitySounds);
    }
}
