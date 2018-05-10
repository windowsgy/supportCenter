package sendMail;

import parm.MailStru;
import utils.internal.LogInfo;
import utils.mail.SendMailUtil;

import java.util.Map;

/**
 *
 * Created by jlgaoyuan on 2018/5/7.
 *
 */
public class SendMail {

    public static void run(Map<String,MailStru> map) {

        for (String key : map.keySet()) {

            MailStru stru = map.get(key);

            SendMailUtil sm = new SendMailUtil();

            LogInfo.info("Sending Mail...");

            // 发送邮件

            if (sm.sendMail(stru)) {

                LogInfo.info("send succeed!");

            } else {

                LogInfo.info("send fail!");

            }

        }

    }

}
