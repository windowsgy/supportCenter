package withjilincity.splitFiles;



import withjilincity.parm.InputParm;
import withjilincity.parm.SetupParms;
import utils.internal.LogInfo;

import java.util.List;
import java.util.Map;


/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 *
 */
public class RunSplitFile {

    /**
     *
     */
    public static void run(){
        LogInfo.info("Start Split Files");
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
        Map<String,List<String>> map =  SplitInfo.run();//拆分文件结构
        LogInfo.linel0();
        WrMap.run(map); ///拆分文件写入
        LogInfo.linel0();
        LogInfo.info("Split Files End");
    }
}
