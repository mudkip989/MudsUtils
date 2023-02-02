package mudkip989.spigot.plugin.mudkipsutils;

import mudkip989.spigot.plugin.mudkipsutils.Commands.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.*;

import java.util.*;
import java.util.logging.*;

import static java.lang.Math.floor;

public final class MudkipsUtils extends JavaPlugin {
    private static MudkipsUtils instance;
    public static Long day;
    public static Logger log = Logger.getLogger("MudkipsUtils");
    @Override

    public void onEnable() {
        // Plugin startup logic

        instance = this;
        FileManager file = new FileManager(getInstance(), "Data.yml");

        log.info( "Getting config...");
        System.out.println("Triggering console lol.");
        World world = Bukkit.getWorld("world");
        try{
            day = (long)file.getConfig().getInt("day");
            log.info( "Successfully loaded config.");
        } catch (Exception e) {
            day = (long)floor(world.getFullTime()/24000);
            file.getConfig().set("day", day);
            file.saveConfig();
            log.info( "Created new config.");
        }
        (new BukkitRunnable() {
            public void run() {
                FileManager file = new FileManager(getInstance(), "Data.yml");
                if(day != (long)floor(world.getFullTime()/24000)){
                    day = (long)floor(world.getFullTime()/24000);
                    file.getConfig().set("day", day);
                    file.saveConfig();
                    List<Player> players = world.getPlayers();
                    for (Player player: players) {
                        Funcs.ShowDate(player);
                    }
                }
            }
        }).runTaskTimerAsynchronously(getInstance(), 0L, 20L);

        this.getCommand("day").setExecutor(new CommandDay());
        this.getCommand("day").setTabCompleter(new TADay());
        this.registerEvents();

    }

    void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Events(), this);
    }
    public static MudkipsUtils getInstance() {
        return instance;
    }
}
