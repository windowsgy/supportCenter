package utils.internal;

/**
 * 数值类型判断 ，输入字符串判断是否为数值类型
 * Created by
 * jlgaoyuan on 2017/9/1.
 */
class IsNumber {

    /**
     * 判断是否为int类型
     * @param str string
     * @return boolean
     */
    static boolean isInt(String str) {// 判断整型
        return str.matches("^\\d+$$");
    }

    /**
     * 判断是否为double 类型
     * @param str string
     * @return boolean
     */
    private static boolean isDouble(String str) {// 判断小数，与判断整型的区别在与d后面的小数点
        return str.matches("\\d+\\.\\d+$");
    }

    /**
     * 判断是否为数字
     * @param str string
     * @return boolean
     */
    static boolean isNumeric(String str) {
        boolean isInt = isInt(str);
        boolean isDouble = isDouble(str);
        return isInt || isDouble;
    }

}
