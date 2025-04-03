package com.gotze.blockBreakSounds;

import com.gotze.blockBreakSounds.listeners.guilisteners.BlockBreakSoundsGUIListener;
import com.gotze.blockBreakSounds.command.BlockBreakSoundsCommand;
import com.gotze.blockBreakSounds.command.CommandTabCompleter;
import com.gotze.blockBreakSounds.listeners.guilisteners.FavoriteSoundsGUIListener;
import com.gotze.blockBreakSounds.listeners.guilisteners.AllSoundsGUIListener;
import com.gotze.blockBreakSounds.listeners.guilisteners.PickSoundGUIListener;
import com.gotze.blockBreakSounds.listeners.guilisteners.SettingsGUIListener;
import com.gotze.blockBreakSounds.listeners.BlockBreakListener;
import com.gotze.blockBreakSounds.listeners.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        registerListeners();
        registerCommands();

        getLogger().info("Block Break Sounds Plugin enabled successfully");
        getLogger().info("Player Sound Info loaded");
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
        getCommand("blockbreaksounds").setExecutor(new BlockBreakSoundsCommand());
        getCommand("blockbreaksounds").setTabCompleter(new CommandTabCompleter());
    }

    @Override
    public void onDisable() {
        getLogger().info("Block Break Sounds Plugin has stopped");
        getLogger().info("Player Sound Info saved");
    }
}