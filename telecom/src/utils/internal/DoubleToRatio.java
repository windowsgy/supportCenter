package utils.internal;

import java.text.NumberFormat;

/**
 * 小数转百分比
 * Created by jlgaoyuan on 2017/9/12.
 */
public class DoubleToRatio {

    public static String  run (Double str){
        NumberFormat nt = NumberFormat.getPercentInstance();
        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);
        return  nt.format(str);

    }

}
