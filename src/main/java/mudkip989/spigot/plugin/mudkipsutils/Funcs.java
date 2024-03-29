package mudkip989.spigot.plugin.mudkipsutils;

import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class Funcs {


    public static void ShowDate(Player p){
        FileManager file = new FileManager(MudkipsUtils.getInstance(), "Data.yml");
        Long day = MudkipsUtils.getInstance().day;

        //|d| |dd| |D| |m| |M| |y|
        //String TitleText = "Day |d|";
        //String SubTitleText = "|D|, |M| |dd|, |y|";
        //String ActionbarText = "";
        //String ChatText = "";
        String TitleText = file.getConfig().getString(p.getUniqueId() + ".DateFormat.Title");
        String SubTitleText = file.getConfig().getString(p.getUniqueId() + ".DateFormat.SubTitle");
        String ActionbarText = file.getConfig().getString(p.getUniqueId() + ".DateFormat.Actionbar");
        String ChatText = file.getConfig().getString(p.getUniqueId() + ".DateFormat.Chat");
        if(!(TitleText == "" && SubTitleText == "")){

            p.sendTitle(formatDate(TitleText), formatDate(SubTitleText), 20, 60, 40);
        }
        if(ActionbarText != ""){
            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(formatDate(ActionbarText)));
        }
        if(ChatText != ""){
            p.sendMessage(formatDate(ChatText));
        }

        return;
    }

    public static String formatDate(String format) {
        String result = format;
        long days = MudkipsUtils.getInstance().day;
        LocalDate start = LocalDate.ofYearDay(0, 1);
        LocalDate date = start.plusDays(days);
        result = result.replace("|d|", MudkipsUtils.getInstance().day.toString());
        result = result.replace("|dd|", String.valueOf(date.getDayOfMonth()));
        result = result.replace("|D|", date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        result = result.replace("|m|", String.valueOf(date.getMonthValue()));
        result = result.replace("|M|", date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        result = result.replace("|y|", String.valueOf(date.getYear()));
        return result;
    }

}
