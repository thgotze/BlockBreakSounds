package com.gotze.blockBreakSounds.command;

import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.gotze.blockBreakSounds.utility.StringUtils.convertToSmallFont;

public final class BlockBreakSoundsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // Check if sender of command is player
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage(ChatColor.RED + "This command can only be executed by a player");
            return true;
        }

        // If only typed /blockbreaksounds, then open the GUI as normal
        if (args.length == 0) {
            new BlockBreakSoundsGUI(player);
            SoundData soundData = CurrentSoundData.currentSound.get(player.getUniqueId());
            if (soundData != null) {
                player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
            }
            return true;
        }

        // If the typed argument after /blockbreaksounds is any cancelling key, then remove the sound
        if (args[0].equalsIgnoreCase("stop")
                || args[0].equalsIgnoreCase("disable")
                || args[0].equalsIgnoreCase("none")
                || args[0].equalsIgnoreCase("off")
                || args[0].equalsIgnoreCase("nosound")
                || args[0].equalsIgnoreCase("0")
                || args[0].equalsIgnoreCase("null")) {
            CurrentSoundData.currentSound.remove(player.getUniqueId());
            return true;
        }

        // If the typed argument after /blockbreaksounds is info, message the player their sound, volume and pitch of current sound
        if (args[0].equalsIgnoreCase("info")) {
            SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
            if (currentSoundData == null) {
                return false;
            } else {

                String message = ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7"
                        + ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(currentSoundData.getFormattedSoundName())
                        + ChatColor.WHITE + convertToSmallFont("Volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", currentSoundData.getVolume() * 100))
                        + ChatColor.WHITE + convertToSmallFont("Pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", currentSoundData.getPitch()));
                player.sendMessage(message);
                return true;
            }
        }

        // If the player typed something that wasn't in the previous methods' parameters send a message saying how to use the command
        else {
            player.sendMessage(ChatColor.RED + "Use command: /blockbreaksound");
            return false;
        }
    }
}