package main.sendMail;


import main.parm.InputParm;
import main.parm.SetupParms;
import sun.rmi.runtime.Log;
import utils.internal.LogInfo;


/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 *
 */
public class RunSendMail {

    public static void run(){

        LogInfo.info("Start Send Mail");

        LogInfo.linel0();

        if(!InputParm.run()){

         return;

        }

        LogInfo.linel0();
        SetupParms.run();
        LogInfo.linel0();

        if(!CheckFiles.run()){//文件检查

            return;

        }

        LogInfo.linel0();

        if(!Load.run()){//加载文件

            return;

        }

        LogInfo.linel0();

        if(!CheckFileInfo.run()){//文件信息检查

            return;

        }

        LogInfo.linel0();

        Load.run();//加载文件

        LogInfo.linel0();

        LogInfo.info("Send Mail End");



    }



}
