package withjilincity.splitFiles;

import withjilincity.parm.BuildParm;
import utils.base.ListUtils;
import utils.base.LogInfo;
import utils.base.SetUtils;


/**
 * Created by jlgaoyuan on 2018/5/5.
 *
 */
public class CheckFileInfo {


    /**
     * 文件信息检查
     *
     * @return boolean
     */
    public static boolean run() {
        LogInfo.info("Check Files Info");
        if (BuildParm.summaryFileHead == null || BuildParm.summaryFileHead.length() < 2) {
            LogInfo.info("汇总文件表头信息不完整");
            return false;
        } else if (BuildParm.detailFileHead == null || BuildParm.detailFileHead.length() < 2) {
            LogInfo.info("明细文件表头信息不完整");
            return false;
        } else if (BuildParm.summaryList == null || BuildParm.summaryList.size() < 1) {
            LogInfo.info("汇总文件信息为空");
            return false;
        } else if (BuildParm.detailList == null || BuildParm.detailList.size() < 1) {
            LogInfo.info("明细文件信息为空");
            return false;
        } else if (BuildParm.summaryJoinField.size() != ListUtils.listToSet(BuildParm.summaryJoinField).size()) {
            LogInfo.info("汇总文件关联字段不唯一");
            return false;
        } else if (BuildParm.summaryJoinField.size() != ListUtils.listToSet(BuildParm.detailJoinField).size()) {
            LogInfo.info("汇总文件与明细文件关联字段数量不一致");
            return false;
        } else if (!(SetUtils.isSetEqual(ListUtils.listToSet(BuildParm.summaryJoinField), ListUtils.listToSet(BuildParm.detailJoinField)))) {
            LogInfo.info("汇总文件与明细文件关联字段不一致");
            return false;
        } else if (!(BuildParm.detailDetailField.size() != ListUtils.listToSet(BuildParm.detailDetailField).size())) {
            LogInfo.info("明细文件名字字段不唯一");
            return false;
        } else if (ListUtils.listToSet(BuildParm.detailDateField).size() > 1) {
            LogInfo.info("明细文件日期字段不唯一");
            return false;
        } else if (!(ListUtils.listToSet(BuildParm.detailDateField).contains(BuildParm.inputDate))) {
            LogInfo.info("明细文件日期字段与输入日期不一致");
            return false;
        } else if (BuildParm.summaryJoinField.size() != BuildParm.summaryMailField.size()) {
            LogInfo.info("汇总文件的关联字段与邮件信息数量不一致");
            return false;
        }
        LogInfo.info("Check Files Info  Succeed");
        return true;
    }
}
