package com.gotze.blockBreakSounds.Command;

import com.gotze.blockBreakSounds.Utility.SoundMap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class BlockBreakSoundsTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.addAll(SoundMap.soundNames.keySet().stream()
                    .filter(option -> option.toLowerCase().startsWith(args[0].toLowerCase()))
                    .toList());
            }
        return completions;
    }
}
