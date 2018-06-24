package utils.internal;


/**
 * 字段监测工具，用于ID,播放类型，统计值检查
 * Created by jlgaoyuan on 2017/8/22.
 */
public class YuemeFieldsChkUtils {

    public static boolean isAreaID(String str) {
        return Chk4Str.isFormat(str,Regex.REGEX_INT)
                && str.length() == 6;
    }

    public static boolean isNodeID(String str) {
        return Chk4Str.isFormat(str,Regex.REGEX_INT)
                && str.length() == 4;
    }


    public static boolean isServerID(String str) {
        return Chk4Str.isFormat(str,Regex.REGEX_INT)
                && str.length() == 5;
    }

    public static boolean isPlayType(String str) {
        return str.equals("0")
                || str.equals("1")
                || str.equals("2")
                || str.equals("3")
                || str.equals("4")
                || str.equals("5")
                || str.equals("6")
                || str.equals("7")
                || str.equals("8")
                || str.equals("9");


    }

    public static boolean isValue(String str) { //值必须大于等于0
        if (Chk4Str.isNumeric(str)) {
            double value = Double.parseDouble(str);
            return value >= 0;
        } else {
            return false;
        }
    }

    public static boolean isSampleSize(String str) { //值必须大于等于0
        if (Chk4Str.isFormat(str,Regex.REGEX_INT)) {
            int value = Integer.parseInt(str);
            return value >= 0;
        } else {
            return false;
        }
    }
}
