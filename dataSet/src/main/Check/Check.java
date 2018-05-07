package main.Check;

import utils.internal.LogInfo;



/**
 * Created by jlgaoyuan on 2018/5/5.
 *
 */
public class Check {


    public static boolean run(){

        LogInfo.info("Check");

        if(!CheckParm.run()){ //参数检测

            return false;

        }else if(!CheckFiles.run()){ //文件检测

            return false;

        }else if (!CheckFileInfo.run()){//文件内容检测

            return false;

        }else {

            LogInfo.info("Check Succeed");

            return true ;}




    }

}
