package main;


import utils.internal.DTUtils;
import utils.internal.LogInfo;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 *
 */
public class Run {

    public static void run(){

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

        Map<String,List<String>> map =  SplitInfo.run();//拆分文件

        WrMap.run(map);

    }



}
