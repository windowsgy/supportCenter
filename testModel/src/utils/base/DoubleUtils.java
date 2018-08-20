package utils.base;

import java.math.BigDecimal;
import java.text.NumberFormat;


public class DoubleUtils {

    /**
     * 小数转百分比
     * Created by jlgaoyuan on 2017/9/12.
     */
    public static String  toRatio (Double str){
        NumberFormat nt = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);
        return  nt.format(str);
    }


    /**
     * double 四舍五入取2位
     * @param double
     */

    public static double dot2(double value){
        BigDecimal valueBD = new BigDecimal(value);
        valueBD.setScale(4,BigDecimal.ROUND_UP);
        return  valueBD.doubleValue();
    }
}
