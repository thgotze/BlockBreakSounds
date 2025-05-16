package com.gotze.blockbreaksounds;

import com.gotze.blockbreaksounds.command.BlockBreakSoundsCommand;
import com.gotze.blockbreaksounds.gui.blockbreaksounds.BlockBreakSoundsGUIListener;
import com.gotze.blockbreaksounds.gui.favoritesounds.FavoriteSoundsGUIListener;
import com.gotze.blockbreaksounds.gui.picksound.PickSoundGUIListener;
import com.gotze.blockbreaksounds.gui.allsounds.AllSoundsGUIListener;
import com.gotze.blockbreaksounds.gui.settings.SettingsGUIListener;
import com.gotze.blockbreaksounds.listener.BlockBreakListener;
import com.gotze.blockbreaksounds.listener.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockBreakSoundsPlugin extends JavaPlugin {

    public static BlockBreakSoundsPlugin INSTANCE;

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

        // GUI Listeners
        getServer().getPluginManager().registerEvents(new BlockBreakSoundsGUIListener(), this);
        getServer().getPluginManager().registerEvents(new PickSoundGUIListener(), this);
        getServer().getPluginManager().registerEvents(new SettingsGUIListener(), this);
        getServer().getPluginManager().registerEvents(new FavoriteSoundsGUIListener(), this);
        getServer().getPluginManager().registerEvents(new AllSoundsGUIListener(), this);
    }

    private void registerCommands() {
        getCommand("blockbreaksounds").setExecutor(new BlockBreakSoundsCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Block Break Sounds Plugin has stopped");
    }
}