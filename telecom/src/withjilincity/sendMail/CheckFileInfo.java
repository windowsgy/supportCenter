package withjilincity.sendMail;


import withjilincity.parm.BuildParm;
import utils.base.ListUtils;
import utils.base.LogInfo;
import utils.base.Regex;
import utils.base.SetUtils;


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
        }  else if (BuildParm.summaryJoinField.size()!= ListUtils.listToSet(BuildParm.summaryJoinField).size()){
            LogInfo.info("汇总文件关联字段不唯一");
            return false;
        }     else if (BuildParm.summaryMailField.size()!= ListUtils.listFilter(BuildParm.summaryMailField, Regex.REGEX_EMAIL).size()){
            LogInfo.info("E-Mail 地址格式存在错误 ");
            return false;
        } else if (BuildParm.summaryJoinField.size()!= BuildParm.summaryMailField.size()){
            LogInfo.info("汇总文件的关联字段与邮件信息数量不一致");
            return false;
        }
        else if (BuildParm.summaryJoinField.size()!= BuildParm.SPLITFILELIST.size()){
            LogInfo.info("汇总文件关联字段信息与拆分文件数量不一致");
            return false;
        }   else if (!(SetUtils.isSetEqual(ListUtils.listToSet(BuildParm.summaryJoinField), ListUtils.listToSet(BuildParm.SPLITFILELIST)))) {
            LogInfo.info("汇总文件关联字段与拆分文件名称不一致");
            return false;
        }
        LogInfo.info("Check Files Info  Succeed");
        return true;
    }
}
