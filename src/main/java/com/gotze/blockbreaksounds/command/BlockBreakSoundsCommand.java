package com.gotze.blockbreaksounds.command;

import com.gotze.blockbreaksounds.gui.blockbreaksounds.BlockBreakSoundsGUI;
import com.gotze.blockbreaksounds.model.CurrentSoundData;
import com.gotze.blockbreaksounds.model.SoundData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public final class BlockBreakSoundsCommand implements CommandExecutor {

    public BlockBreakSoundsCommand() {}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player player)) return false;

        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());

        // If only typed /blockbreaksounds, then open the GUI as normal
        if (args.length == 0) {
            new BlockBreakSoundsGUI(player);
            if (currentSoundData != null) {
                player.playSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
            }
            return true;
        }

        // If the typed argument after /blockbreaksounds is info, message the player their sound, volume and pitch of current sound
        if (args[0].equalsIgnoreCase("info")) {
            if (currentSoundData == null) return false;

            String message = ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7"
                    + ChatColor.WHITE + convertToSmallFont("sound: ") + ChatColor.GRAY + convertToSmallFont(currentSoundData.getFormattedSoundName())
                    + ChatColor.WHITE + convertToSmallFont("volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", currentSoundData.getVolume() * 100))
                    + ChatColor.WHITE + convertToSmallFont("pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", currentSoundData.getPitch()));
            player.sendMessage(message);
            return true;
        }

        // If the typed argument after /blockbreaksounds is any cancelling key, then remove the sound
        final String[] cancelKeys = {"stop", "disable", "none", "off", "nosound", "0", "null"};
        for (String cancelKey : cancelKeys) {
            if (args[0].equalsIgnoreCase(cancelKey)) {
                CurrentSoundData.currentSound.remove(player.getUniqueId());
                return true;
            }
        }

        // If the player typed something that wasn't in the previous methods' parameters send a message saying how to use the command
        return false;
    }
}