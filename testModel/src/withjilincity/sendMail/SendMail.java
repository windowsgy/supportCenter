package withjilincity.sendMail;

import utils.stru.StruMail;
import utils.base.LogInfo;
import utils.mail.SendMailUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by jlgaoyuan on 2018/5/7.
 *
 */
public class SendMail {

    public static void run(Map<String,StruMail> map) {
        LogInfo.info("Send Mail");
        int succeedCount = 0;
        int failCount = 0 ;
        List<String> failList = new ArrayList<>();
        for (String key : map.keySet()) {
            StruMail stru = map.get(key);
            SendMailUtil sm = new SendMailUtil();
            LogInfo.info("From :"+stru.getFrom()+" To :"+ stru.getTo());
            // 发送邮件
            if(sm.sendMail(stru)){
                succeedCount++;
            }else{
                failList.add(key);
                failCount++;
            }
        }
        LogInfo.linel1();
        LogInfo.info("Send Mail Count:"+map.size());
        LogInfo.info("Send Mail Succeed Count:"+succeedCount);
        LogInfo.info("Send Mail Fail Count:"+failCount);
        for (String aFailList : failList) {
            LogInfo.info(aFailList);
        }
        LogInfo.linel1();
    }
}
