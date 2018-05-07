package main;

import main.Parm.BuildParm;
import utils.internal.ListUtil;
import utils.internal.LogInfo;


/**
 *
 * Created by jlgaoyuan on 2018/5/5.
 */
public class CheckFileInfo {


    /**
     * 文件信息检查
     * @return boolean
     */

    public static boolean run(){

        if(BuildParm.summaryFileHead== null || BuildParm.summaryFileHead.length()<2){

            LogInfo.info("摘要文件表头信息不完整");

            return false;

        }   else if(BuildParm.detailFileHead== null || BuildParm.detailFileHead.length()<2){

            LogInfo.info("明细文件表头信息不完整");

            return false;

        }   else if(BuildParm.summaryList == null || BuildParm.summaryList.size()<1){

            LogInfo.info("摘要文件信息为空");

            return false;

        }   else if(BuildParm.detailList == null || BuildParm.detailList.size()<1){

            LogInfo.info("明细文件信息为空");

            return false;

        }   else if (BuildParm.summaryJoinField.size()!= ListUtil.listToSet(BuildParm.summaryJoinField).size()){

            LogInfo.info("摘要文件Join信息不唯一");

            return false;

        }   else if (BuildParm.summaryJoinField.size()!= ListUtil.listToSet(BuildParm.detailJoinField).size()){

            LogInfo.info("摘要文件Join信息与明细文件Join信息数量不一致");

            return false;

        }   else if (BuildParm.detailDetailField.size()!= ListUtil.listToSet(BuildParm.detailDetailField).size()){

            LogInfo.info("明细文件名字字段不唯一");

            return false;


        }   else if (ListUtil.listToSet(BuildParm.detailDateField).size()>1){

            LogInfo.info("明细文件日期字段不唯一");

            return false;


        }   else if (!ListUtil.listToSet(BuildParm.detailDateField).contains(BuildParm.inputDate)){

            LogInfo.info("明细文件日期字段与输入日期不一致");

            return false;


        }   else if (!(ListUtil.listToSet(BuildParm.summaryMailField).size()!= BuildParm.summaryMailField.size())){

            LogInfo.info("邮件信息不唯一");

            return false;


        }   else if (BuildParm.summaryJoinField.size()!= BuildParm.summaryMailField.size()){

            LogInfo.info("邮件信息与关联信息数量不一致");

            return false;


        }


        return true;


    }






}