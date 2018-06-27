package withjilincity.sendMail;


import withjilincity.parm.BuildParm;
import withjilincity.parm.InitParm;
import utils.base.FileUtils;
import utils.base.ListUtils;
import utils.base.LogInfo;

import java.util.List;


/**
 *
 * Created by jlgaoyuan on 2018/5/5.
 *
 */
public class Load {

    public static boolean  run(){
        LogInfo.info("Loading Files");
        BuildParm.summaryFileCode = FileUtils.codeString(BuildParm.SUMMARY_FILEPATH);
        LogInfo.info("Summary File Code :"+BuildParm.summaryFileCode);
        BuildParm.detailFileCode = FileUtils.codeString(BuildParm.DETAIL_FILEPATH);
        LogInfo.info("Detail File Code :"+BuildParm.detailFileCode);
        LogInfo.info("Load Summary File Head");
        BuildParm.summaryFileHead = FileUtils.readFirstLine(BuildParm.SUMMARY_FILEPATH,BuildParm.summaryFileCode);
        LogInfo.info("Load Summary File To List");
        BuildParm.summaryList = FileUtils.read2List(BuildParm.SUMMARY_FILEPATH,2,BuildParm.detailFileCode);//第二行开始读
        LogInfo.info("Load Summary File To ListArray");
        BuildParm.summaryListArr = ListUtils.list2ListArray(BuildParm.summaryList, InitParm.SplitStr);
        if(BuildParm.summaryListArr == null){
            LogInfo.info("Summary Field Inconformity");//每行字段数量不一致
            return false;
        }
        LogInfo.info("Load Summary Join Field ");
        BuildParm.summaryJoinField = ListUtils.listArrField(BuildParm.summaryListArr, InitParm.summaryJoinIndex);
        LogInfo.info("Load Summary Mail Field");
        BuildParm.summaryMailField = ListUtils.listArrField(BuildParm.summaryListArr, InitParm.detailMailIndex);
        LogInfo.info("Load SplitFiles Name");
        List<String> splitFileList = FileUtils.getFileNameToList(BuildParm.SPLIT_SUBPATH);
        List<String []> splitFileListArray = ListUtils.list2ListArray(splitFileList,InitParm.FileNameSplitStr);
        BuildParm.SPLITFILELIST = ListUtils.listArrField(splitFileListArray,0);
        LogInfo.info("Loading Files Succeed");
        return true;
    }
}
