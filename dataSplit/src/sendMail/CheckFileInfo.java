package sendMail;


import parm.BuildParm;
import utils.internal.ListUtil;
import utils.internal.LogInfo;
import utils.internal.SetContrastSet;


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

        LogInfo.info("Check Files Info ");

        if(BuildParm.summaryFileHead== null || BuildParm.summaryFileHead.length()<2){

            LogInfo.info("汇总文件表头信息不完整");

            return false;

        }  else if(BuildParm.summaryList == null || BuildParm.summaryList.size()<1){

            LogInfo.info("汇总文件信息为空");

            return false;

        }  else if (BuildParm.summaryJoinField.size()!= ListUtil.listToSet(BuildParm.summaryJoinField).size()){

            LogInfo.info("汇总文件关联字段不唯一");

            return false;

        }     else if (BuildParm.summaryJoinField.size()!= BuildParm.summaryMailField.size()){

            LogInfo.info("汇总文件的关联字段与邮件信息数量不一致");

            return false;


        }else if (BuildParm.summaryJoinField.size()!= BuildParm.SPLITFILELIST.size()){

            LogInfo.info("汇总文件关联字段信息与拆分文件数量不一致");

            return false;

        }   else if (!(SetContrastSet.isSetEqual(ListUtil.listToSet(BuildParm.summaryJoinField),ListUtil.listToSet(BuildParm.SPLITFILELIST)))) {

            LogInfo.info("汇总文件关联字段与拆分文件名称不一致");

            return false;

        }

        LogInfo.info("Check Files Info  Succeed");

        return true;


    }






}
