package main.sendMail;


import main.parm.InputParm;
import main.parm.SetupParms;
import utils.internal.LogInfo;


/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 *
 */
public class RunSendMail {

    public static void main( String [] args){

        LogInfo.info("Start Send Mail");

        if(!InputParm.run()){

         return;

        }

        SetupParms.run();

        if(!CheckFiles.run()){//文件检查

            return;

        }

        Load.run();

        if(!CheckFileInfo.run()){//文件信息检查

            return;

        }


        Load.run();//加载文件





        LogInfo.info("Send Mail End");



    }



}
