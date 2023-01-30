package mudkip989.spigot.plugin.mudkipsutils;

import org.bukkit.entity.*;

public class Funcs {


    public static void ShowDate(Player p){
        FileManager file = new FileManager(MudsUtils.getInstance(), "Data.yml");
        Long day = MudsUtils.getInstance().day;
        String textLocation = "Title";
        try {
            textLocation = file.getConfig().getString(p.getUniqueId() + ".DateLocate");
        } catch (Exception e){
            textLocation = "Title";
        }
        if (textLocation == null){
            textLocation = "Title";
        }
        switch(textLocation) {
            case "Title":
                p.sendTitle("Day " + day, "",20, 20, 20);
                break;
            case "Message":
                p.sendMessage("A new Day has arrived! Today is Day " + day);
                break;
            default:
                p.sendTitle("Day " + day, "",20, 20, 20);
                break;
        }

        return;
    }
}
