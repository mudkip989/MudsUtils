package mudkip989.spigot.plugin.mudkipsutils.Commands;

import mudkip989.spigot.plugin.mudkipsutils.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import java.util.*;

import static mudkip989.spigot.plugin.mudkipsutils.MudkipsUtils.log;
import static org.bukkit.Bukkit.getPlayer;

public class CommandDay implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0 ) {
                log.info("Ran Player Command with no args.");
                Funcs.ShowDate(player);

            }else if(Objects.equals(args[0], "set")){
                if(Objects.equals(args[1], "format")){
                    FileManager file = new FileManager(MudkipsUtils.getInstance(), "Data.yml");
                    String text = "";
                    int i = 0;
                    for(String arg : args){
                        if(i>2){
                            text += " " + arg;
                        }
                        i++;
                    }
                    switch(args[2]){
                        case "Title":
                            if(args.length>3) {
                                file.getConfig().set(player.getUniqueId() + ".DateFormat.Title", text);
                            }else {
                                file.getConfig().set(player.getUniqueId() + ".DateFormat.Title", "");
                            }
                            break;
                        case "SubTitle":
                            if(args.length>3) {
                                file.getConfig().set(player.getUniqueId() + ".DateFormat.SubTitle", text);
                            }else {
                                file.getConfig().set(player.getUniqueId() + ".DateFormat.SubTitle", "");
                            }
                            break;
                        case "Actionbar":
                            if(args.length>3) {
                                file.getConfig().set(player.getUniqueId() + ".DateFormat.Actionbar", text);
                            }else {
                                file.getConfig().set(player.getUniqueId() + ".DateFosmat.Actionbar", "");
                            }
                            break;
                        case "Chat":
                            if(args.length>3) {
                                file.getConfig().set(player.getUniqueId() + ".DateFormat.Chat", text);
                            }else {
                                file.getConfig().set(player.getUniqueId() + ".DateFormat.Chat", "");
                            }
                            break;
                        default:

                            break;

                    }
                file.saveConfig();

                } else {
                    player.sendMessage("Oh come on! Just use the Tab Autocompletor. This should have been easy.");
                    return false;
                }
            }else if(Objects.equals(args[0], "help")){
                if(Objects.equals(args[1], "formatting")){
                    player.sendMessage("The following are available placeholders in your formatting.");
                    player.sendMessage("|d| - Day Count");
                    player.sendMessage("|dd| - Day of Month");
                    player.sendMessage("|D| - Day of Week");
                    player.sendMessage("|m| - Month Number");
                    player.sendMessage("|M| - Month Name");
                    player.sendMessage("|y| - Year");
                }
            }

        }else{
            log.info( "Current day is Day " + MudkipsUtils.getInstance().day);
        }
        return true;
    }
}
