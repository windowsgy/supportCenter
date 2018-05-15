package sendMail;



import parm.BuildParm;
import parm.InitParm;
import utils.mail.MailStru;
import utils.internal.LogInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 *
 */
public class MailInfo {

    public static  Map<String, MailStru> run (){

        LogInfo.info("Build Mail Stru");

        List<String[]> listArr = BuildParm.summaryListArr;

        Map<String,MailStru> map = new HashMap<>();

        for(int i = 0; i < listArr.size(); i++){

            String [] arr = listArr.get(i);

            MailStru stru = new MailStru();

            stru.setFrom(InitParm.mailFrom);// 设置发件人的邮箱
            stru.setUsername(InitParm.mailUsername); // 设置发件人邮箱的用户名
            stru.setPassword(InitParm.mailPassword); // 设置发件人邮箱的密码
            stru.setHost(InitParm.mailHost);//设置SMTP主机

            stru.setTo(arr[6]);// 设置收件人的邮箱
            stru.setSubject(InitParm.mailSubject);// 设置邮件的主题
            stru.setContent(InitParm.mailContent); // 设置邮件的正文
            stru.setFilename(arr[0]); // 设置附件文件名
            stru.attachFile(BuildParm.SPLIT_SUBPATH+arr[0]+".csv");//设置附件文件路径


            map.put(arr[0],stru);

        }

        return map;

    }



}
