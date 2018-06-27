package utils.internal;

import java.util.Objects;

/**
 * 数值类型判断 ，输入字符串判断是否为数值类型
 * Created by
 * jlgaoyuan on 2017/9/1.
 */
public class Chk4Str {

    /**
     * 判断是否为数字
     *
     * @param str string
     * @return boolean
     */
    static boolean isNumeric(String str) {
        boolean isInt = isFormat(str, Regex.REGEX_INT);
        boolean isDouble = isFormat(str, Regex.REGEX_DOUBLE);
        return isInt || isDouble;
    }

    /**
     * 判断字符串是不是null或无字符（trim后）
     *
     * @param str str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * 正则表达式规则匹配
     *
     * @param str    字符串
     * @param format 格式
     * @return boolean
     */
    public static boolean isFormat(String str, String format) {
        return str.matches(format);
    }


    /**
     * 判断是否为指定的数据类型
     *
     * @param str 数据类型
     * @return boolean
     */
    public static boolean isDataType(String str) {
        return Objects.equals("Char", str)
                || Objects.equals("String", str)
                || Objects.equals("Int", str)
                || Objects.equals("Long", str)
                || Objects.equals("Double", str)
                || Objects.equals("IPV4", str)
                || Objects.equals("IPV6", str)
                || Objects.equals("DateTime", str)
                || Objects.equals("Mac", str)
                || Objects.equals("Mail", str)
                || Objects.equals("Url", str);
    }


    /**
     * 判断数值是否在范围内
     *
     * @param start  起始数值
     * @param end    结束数值
     * @param number 数值
     * @return boolean
     */
    public static boolean numberScope(long start, long end, long number) {
        return number > start && number < end;
    }


    /**
     * 判断数值是否在范围内
     *
     * @param start  起始数值
     * @param end    结束数值
     * @param number 数值
     * @return boolean
     */
    public static boolean numberScope(double start, double end, double number) {
        return number >= start && number <= end;
    }

    /**
     * 统计指定字符在字符串中的数量
     *
     * @param str String
     * @return 字符在字符串中的数量
     */
    public static int includeCharCount(String str) {
        char ch[] = str.toCharArray();
        int count = 0;
        for (char aCh : ch) {
            if (';' == aCh) {
                count++;
            }
        }
        return count;
    }
}
