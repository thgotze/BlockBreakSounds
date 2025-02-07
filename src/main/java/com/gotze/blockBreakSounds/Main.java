package com.gotze.blockBreakSounds;

import com.gotze.blockBreakSounds.BlockBreakSoundsGUI.BlockBreakSoundsGUIListener;
import com.gotze.blockBreakSounds.Command.BlockBreakSoundsExecutor;
import com.gotze.blockBreakSounds.Command.BlockBreakSoundsTabCompleter;
import com.gotze.blockBreakSounds.FavoriteSoundsGUI.FavoriteSoundsGUIListener;
import com.gotze.blockBreakSounds.PickSoundGUI.AllSoundsGUIListener;
import com.gotze.blockBreakSounds.PickSoundGUI.PickSoundGUIListener;
import com.gotze.blockBreakSounds.SettingsGUI.SettingsGUIListener;
import com.gotze.blockBreakSounds.Utility.Listeners.BlockBreakListener;
import com.gotze.blockBreakSounds.Utility.Listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        getLogger().info("Block Break Sounds Plugin enabled successfully");
        getLogger().info("Player Sound Info loaded");

        registerListeners();
        registerCommands();
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);

        getServer().getPluginManager().registerEvents(new BlockBreakSoundsGUIListener(), this);
        getServer().getPluginManager().registerEvents(new PickSoundGUIListener(), this);
        getServer().getPluginManager().registerEvents(new SettingsGUIListener(), this);
        getServer().getPluginManager().registerEvents(new FavoriteSoundsGUIListener(), this);
        getServer().getPluginManager().registerEvents(new AllSoundsGUIListener(), this);

    }

    private void registerCommands() {
        getCommand("blockbreaksounds").setExecutor(new BlockBreakSoundsExecutor());
        getCommand("blockbreaksounds").setTabCompleter(new BlockBreakSoundsTabCompleter());
    }

    @Override
    public void onDisable() {
        getLogger().info("Block Break Sounds Plugin has stopped");
        getLogger().info("Player Sound Info saved");
    }
}
