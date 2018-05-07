package main.Check;


import main.Init;
import main.Parm;
import utils.internal.DTUtils;
import utils.internal.LogInfo;

/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 */
public class CheckParm {

    /**
     * 参数检测
     * @return boolean
     */


    public static boolean run(){

        if(Init.inputDate.length()!=7){

            LogInfo.error("输入时间格式错误");

            return false;

        }else if(!DTUtils.dateFormatCheak(Init.inputDate, Parm.DATE_FORMAT)){

            LogInfo.error("输入时间格式错误");

            return false;

        }else {

            Init.SPLIT_SUBPATH = Init.SPLIT_SUBPATH+Init.inputDate;

            return true;

        }




    }





}
