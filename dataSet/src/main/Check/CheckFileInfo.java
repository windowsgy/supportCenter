package main.Check;

import main.Init;
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

        if(Init.summaryFileHead== null || Init.summaryFileHead.length()<2){

            LogInfo.info("摘要文件头信息不完整");

            return false;

        }   else if(Init.detailFileHead== null || Init.detailFileHead.length()<2){

            LogInfo.info("明细文件头信息不完整");

            return false;

        }   else if(Init.summaryList == null || Init.summaryList.size()<1){

            LogInfo.info("摘要文件信息为空");

            return false;

        }   else if(Init.detailList == null || Init.detailList.size()<1){

            LogInfo.info("明细文件信息为空");

            return false;

        }   else if (Init.summaryJoinField.size()!= ListUtil.listToSet(Init.summaryJoinField).size()){

            LogInfo.info("摘要文件Join信息不唯一");

            return false;

        }   else if (Init.summaryJoinField.size()!= ListUtil.listToSet(Init.detailJoinField).size()){

            LogInfo.info("摘要文件Join信息与明细文件Join信息数量不一致");

            return false;

        }   else if (Init.detailDetailField.size()!= ListUtil.listToSet(Init.detailDetailField).size()){

            LogInfo.info("明细文件名字字段不唯一");

            return false;


        }   else if (ListUtil.listToSet(Init.detailDateField).size()>1){

            LogInfo.info("明细文件日期字段不唯一");

            return false;


        }   else if (!ListUtil.listToSet(Init.detailDateField).contains(Init.inputDate)){

            LogInfo.info("明细文件日期字段与输入日期不一致");

            return false;


        }   else if (!(ListUtil.listToSet(Init.summaryMailField).size()!= Init.summaryMailField.size())){

            LogInfo.info("邮件信息不唯一");

            return false;


        }   else if (Init.summaryJoinField.size()!= Init.summaryMailField.size()){

            LogInfo.info("邮件信息与关联信息数量不一致");

            return false;


        }


        return true;


    }






}
