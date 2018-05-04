package utils.internal;

/**
 *
 * Created by jlgaoyuan on 2017/9/1.
 */
public class IsNumber {

    public static boolean isInt(String str) {// 判断整型
        return str.matches("^\\d+$$");
    }

    public static boolean isDouble(String str) {// 判断小数，与判断整型的区别在与d后面的小数点
        return str.matches("\\d+\\.\\d+$");
    }

    public static boolean isNumeric(String str){

        boolean isInt = isInt(str);

        boolean isDouble = isDouble(str);

        if(isInt||isDouble){

            return true;

        }else return false;

    }

}
