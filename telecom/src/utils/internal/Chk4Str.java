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
        boolean isInt = isFormat(str,Regex.REGEX_INT);
        boolean isDouble = isFormat(str,Regex.REGEX_DOUBLE);
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
     * @param str 字符串
     * @param format 格式
     * @return boolean
     */
    public static boolean isFormat(String str, String format){
        return str.matches(format);
    }


    /**
     *判断是否为指定的数据类型
     * @param str  数据类型
     * @return boolean
     */
    public static boolean isDataType(String str) {
        if (Objects.equals("Char", str)) {
            return true;
        } else if (Objects.equals("String", str)) {
            return true;
        } else if (Objects.equals("Int", str)) {
            return true;
        } else if (Objects.equals("Double", str)) {
            return true;
        } else if (Objects.equals("IPV4", str)){
            return true;
        }else if (Objects.equals( "IPV6" , str)){
            return true;
        }else if (Objects.equals( "DateTime" , str)){
            return true;
        }else if (Objects.equals( "Mac" , str)){
            return true;
        }else if (Objects.equals( "Mail" , str)){
            return true;
        }else if (Objects.equals( "Url" , str)){
            return true;
        }
        else return false;
    }

}
