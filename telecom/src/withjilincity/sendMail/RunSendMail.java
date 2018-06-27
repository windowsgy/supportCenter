package withjilincity.sendMail;



import withjilincity.parm.InputParm;
import utils.stru.StruMail;
import withjilincity.parm.SetupParms;
import utils.base.LogInfo;
import java.util.Map;


/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 *
 */
public class RunSendMail {

    /**
     *
     */
    public static void run(){
        LogInfo.info("Send Mail Start");
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
        Map<String, StruMail> map = MailInfo.run();
        LogInfo.linel0();
        LogInfo.info("Mail Count:"+map.size());
        LogInfo.linel0();
        SendMail.run(map);
        LogInfo.info("Send Mail End");
    }
}
