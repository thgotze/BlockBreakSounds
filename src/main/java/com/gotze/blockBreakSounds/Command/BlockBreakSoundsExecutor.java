package com.gotze.blockBreakSounds.Command;

import com.gotze.blockBreakSounds.BlockBreakSoundsGUI.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
import com.gotze.blockBreakSounds.Utility.SoundMap;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.gotze.blockBreakSounds.Utility.SmallFontConverter.convertToSmallFont;
import static com.gotze.blockBreakSounds.Utility.SmallFontConverter.removeSpecialCharacters;
import static com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData.currentSound;

public class BlockBreakSoundsExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // Check if sender of command is player
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage(ChatColor.RED + "This command can only be executed by a player");
            return true;
        }

        // If only typed /blockbreaksounds, then open the GUI as normal
        if (args.length == 0) {
            BlockBreakSoundsGUI blockBreakSoundsGUI = new BlockBreakSoundsGUI(player);
            blockBreakSoundsGUI.openBlockBreakSoundsGUI(player);
            return true;
        }

        // If the typed argument after /blockbreaksounds is a valid key, then set the sound to that sound
        else if (args.length == 1 && SoundMap.soundNames.containsKey(args[0])) {
            Sound selectedSound = SoundMap.soundNames.get(args[0]);
            currentSound.put(player.getUniqueId(), new CurrentSoundData(player, selectedSound, 0.5f, 0.5f));

            player.playSound(player, selectedSound, 0.5f, 1.0f);
            player.sendMessage("Block break sound set to: " + ChatColor.AQUA + args[0]);
            return true;
        }

        // If the typed argument after /blockbreaksounds is any cancelling key, then remove the sound
        else if (args.length == 1 && (
                args[0].equalsIgnoreCase("stop") ||
                        args[0].equalsIgnoreCase("disable") ||
                        args[0].equalsIgnoreCase("none") ||
                        args[0].equalsIgnoreCase("off") ||
                        args[0].equalsIgnoreCase("nosound") ||
                        args[0].equalsIgnoreCase("0") ||
                        args[0].equalsIgnoreCase("null"))) {
            currentSound.remove(player.getUniqueId());
            return true;
        }

        // If the typed argument after /blockbreaksounds is info, message the player their sound, volume and pitch of current sound
        else if (args[0].equalsIgnoreCase("info")) { // TODO: FIX info command formatting
            CurrentSoundData currentSoundData = currentSound.get(player.getUniqueId());
            if (currentSoundData == null) {
                return false;
            } else {
                String message = ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7\n" +
                        ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(removeSpecialCharacters(currentSoundData.getSound().name())) +
                        ChatColor.WHITE + convertToSmallFont("Volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", currentSoundData.getVolume() * 100)) +
                        ChatColor.WHITE + convertToSmallFont("Pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", currentSoundData.getPitch()));
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
