package mudkip989.spigot.plugin.mudkipsutils;

import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class Events implements Listener {

    @EventHandler
    public void OnJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        FileManager file = new FileManager(MudsUtils.getInstance(), "Data.yml");
        if(file.getConfig().get(player.getUniqueId().toString()) == null){
            String TitleText = "Day |d|";
            String SubTitleText = "|D|, |M| |dd|, |y|";
            String ActionbarText = "";
            String ChatText = "";
            file.getConfig().set(player.getUniqueId() + ".DateFormat.Title", TitleText);
            file.getConfig().set(player.getUniqueId() + ".DateFormat.SubTitle", SubTitleText);
            file.getConfig().set(player.getUniqueId() + ".DateFormat.Actionbar", ActionbarText);
            file.getConfig().set(player.getUniqueId() + ".DateFormat.Chat", ChatText);
        }
        Funcs.ShowDate(player);



    }


}
