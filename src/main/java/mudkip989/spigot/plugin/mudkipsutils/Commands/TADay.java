package mudkip989.spigot.plugin.mudkipsutils.Commands;

import org.bukkit.command.*;

import java.util.*;

public class TADay implements TabCompleter {
    @Override
    public List<String> onTabComplete (CommandSender sender, Command cmd, String label, String[] args){
        List<String> completions = new ArrayList<>();
        if(args.length == 1) {
            completions.add("set");
            completions.add("help");
        }
        if(args.length == 2){
            switch (args[0]){
                case "set":
                    completions.add("format");
                    break;
                case "help":
                    completions.add("formatting");
                    break;
                default:

                    break;

            }
        }

        if(args.length == 3){
            switch (args[1]){
                case "format":
                    completions.add("Title");
                    completions.add("SubTitle");
                    completions.add("Actionbar");
                    completions.add("Chat");
                    break;
                default:

                    break;

            }
        }

        if(args.length == 4){
            switch (args[2]){
                case "Title":
                case "SubTitle":
                case "Actionbar":
                case "Chat":
                    completions.add("<text with formatting>");
                    completions.add("<text without formatting>");
                    break;
                default:

                    break;

            }
        }

        if(completions.size() == 0) {
            return Collections.emptyList();
        }else{
            return completions;
        }
    }

}
