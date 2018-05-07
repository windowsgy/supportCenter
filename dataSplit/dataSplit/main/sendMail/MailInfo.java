package main.sendMail;

import main.parm.BuildParm;
import main.parm.InitParm;
import main.parm.MailStru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 *
 */
public class MailInfo {

    public static  Map<String,MailStru> run (){

        Map<String,MailStru> map = new HashMap<>();

        for(int i = 0; i < BuildParm.summaryListArr.size(); i++){
            MailStru stru = new MailStru();

            stru.setFrom(InitParm.mailFrom);// 设置发件人的邮箱
            stru.setUsername(InitParm.mailUsername); // 设置发件人邮箱的用户名
            stru.setPassword(InitParm.mailPassword); // 设置发件人邮箱的密码
            stru.setHost(InitParm.mailHost);//设置SMTP主机

            stru.setTo("");// 设置收件人的邮箱
            stru.setSubject("");// 设置邮件的主题
            stru.setContent(""); // 设置邮件的正文
            stru.setFilename(""); // 设置附件文件名
            stru.attachFile("");//设置附件文件路径




        }

        return map;

    }



}
