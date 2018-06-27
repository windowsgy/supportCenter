package utils.telnet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by jlgaoyuan on 2018/5/15.
 *
 */
public class TelnetEnd {

    public static List<String> beforeLoginList(){
        List<String> list = new ArrayList<>();
        list.add("Login:");
        list.add("ame:");
        return list;
    }

    public static List<String> LogingList(){
        List<String> list = new ArrayList<>();
        list.add("ord:");
        return list;
    }

    public static List<String> behindLoginList(){
        List<String> list = new ArrayList<>();
        list.add(">");
        list.add("#");
        return list;
    }

    public static List<String> commandEndList(){
        List<String> list = new ArrayList<>();
        list.add("exit");
        return list;
    }

    public static  boolean error(String str) {
        String str1 = "closed";
        String str2 = "Read timed out";
        String str3 = "reset";
        String str4 = "Login password has not been set";
        String str5 = "Error";
        return !(str.equals(str1) || str.equals(str2) || str.equals(str3)
                || str.equals(str4) || str.equals(str5));
    }
}
