package mudkip989.spigot.plugin.mudkipsutils.Commands;

import mudkip989.spigot.plugin.mudkipsutils.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

import java.util.*;

import static mudkip989.spigot.plugin.mudkipsutils.MudsUtils.log;
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
                if(Objects.equals(args[1], "display")){
                    FileManager file = new FileManager(MudsUtils.getInstance(), "Data.yml");
                    file.getConfig().set(player.getUniqueId() +".DateLocate", args[2]);
                    file.saveConfig();

                } else {
                    player.sendMessage("Oh come on! Just use the Tab Autocompletor. This should have been easy.");
                    return false;
                }
            }

        }else{
            log.info( "Current day is Day " + MudsUtils.getInstance().day);
        }
        return true;
    }
}
