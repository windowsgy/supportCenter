package sendMail;


import parm.BuildParm;
import parm.InitParm;
import utils.fileutils.FileUtil;
import utils.internal.ListUtil;
import utils.internal.LogInfo;

import java.util.List;


/**
 *
 * Created by jlgaoyuan on 2018/5/5.
 *
 */
public class Load {

    public static boolean  run(){

        LogInfo.info("Loading Files");

        BuildParm.summaryFileCode = FileUtil.codeString(BuildParm.SUMMARY_FILEPATH);

        LogInfo.info("SUMMARY FILE CODE :"+BuildParm.summaryFileCode);

        BuildParm.detailFileCode = FileUtil.codeString(BuildParm.DETAIL_FILEPATH);

        LogInfo.info("DETAIL FILE CODE :"+BuildParm.detailFileCode);


        LogInfo.info("加载汇总文件表头");

        BuildParm.summaryFileHead = FileUtil.readFirstLine(BuildParm.SUMMARY_FILEPATH,BuildParm.summaryFileCode);

        LogInfo.info("加载汇总文件内容");

        BuildParm.summaryList = FileUtil.read2List(BuildParm.SUMMARY_FILEPATH,2,BuildParm.detailFileCode);//第二行开始读

        LogInfo.info("加载汇总文件数组");

        BuildParm.summaryListArr = ListUtil.list2ListArray(BuildParm.summaryList, InitParm.SplitStr);

        if(BuildParm.summaryListArr == null){

            LogInfo.info("汇总文件字段数量不一致");

            return false;

        }


        LogInfo.info("加载汇总文件关联字段");

        BuildParm.summaryJoinField = ListUtil.listArrField(BuildParm.summaryListArr, InitParm.summaryJoinIndex);

        LogInfo.info("加载汇总文件邮件信息");

        BuildParm.summaryMailField = ListUtil.listArrField(BuildParm.summaryListArr, InitParm.detailMailIndex);

        LogInfo.info("加载拆分文件名称");

        List<String> splitFileList = FileUtil.getFileNameToList(BuildParm.SPLIT_SUBPATH);

        List<String []> splitFileListArray = ListUtil.list2ListArray(splitFileList,InitParm.FileNameSplitStr);

        BuildParm.SPLITFILELIST = ListUtil.listArrField(splitFileListArray,0);

        LogInfo.info("Loading Files Succeed");

        return true;

    }
}
