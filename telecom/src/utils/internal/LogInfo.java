package utils.internal;

import utils.external.DateTimeUtil;
import utils.fileutils.FileUtil;

/**
 * 日志记录类
 * Created by Telis on 17/7/12.
 */
public class LogInfo {

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String debug(String x) {
        String message = "[debug][" + DateTimeUtil.getCurTime(DATE_FORMAT) + "]" + x + "\r\n";
        System.out.print(message);
        return message;
    }

    public static String info(String x) {
        String message = "[info][" + DateTimeUtil.getCurTime(DATE_FORMAT) + "]" + x + "\r\n";
        System.out.print(message);
        return message;
    }

    public static String warn(String x) {
        String message = "[warn][" + DateTimeUtil.getCurTime(DATE_FORMAT) + "]" + x + "\r\n";
        System.out.print(message);
        return message;

    }

    public static String error(String x) {
        String message = "[error][" + DateTimeUtil.getCurTime(DATE_FORMAT) + "]" + x + "\r\n";
        System.out.print(message);
        return message;
    }

    public static String linel0() {
        String message = "######################################################################################################################" + "\r\n";
        System.out.print(message);
        return message;
    }

    public static String linel1() {
        String message = "==============================================================================================" + "\r\n";
        System.out.print(message);
        return message;
    }

    public static String linel2() {
        String message = "-----------------------------------------------------------------" + "\r\n";
        System.out.print(message);
        return message;
    }


    public static String linel3() {
        String message = "*******************************" + "\r\n";
        System.out.print(message);
        return message;
    }

    public static String linel4() {
        String message = "..........." + "\r\n";
        System.out.print(message);
        return message;
    }

    public static void logWrToFile(String logFilePath, String message) {
        if (logFilePath != null) {
            FileUtil.wrStrAddToFile(message, logFilePath);
        }
    }
}
