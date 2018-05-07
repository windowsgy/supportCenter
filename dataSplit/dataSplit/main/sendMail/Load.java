package main.sendMail;

import main.parm.BuildParm;
import main.parm.InitParm;
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

    public static void  run(){

        LogInfo.info("加载摘要文件表头");

        BuildParm.summaryFileHead = FileUtil.readFirstLine(BuildParm.SUMMARY_FILEPATH);

        LogInfo.info("加载摘要文件内容");

        BuildParm.summaryList = FileUtil.read2List(BuildParm.SUMMARY_FILEPATH,2);//第二行开始读

        LogInfo.info("加载摘要文件数组");

        BuildParm.summaryListArr = ListUtil.list2ListArray(BuildParm.summaryList, InitParm.SplitStr);

        LogInfo.info("加载摘要文件关联字段");

        BuildParm.summaryJoinField = ListUtil.listArrField(BuildParm.summaryListArr, InitParm.summaryJoinIndex);

        LogInfo.info("加载摘要文件邮件信息");

        BuildParm.summaryMailField = ListUtil.listArrField(BuildParm.summaryListArr, InitParm.detailMailIndex);

        LogInfo.info("加载拆分文件名称");

        List<String> splitFileList = FileUtil.getFileNameToList(BuildParm.SPLIT_SUBPATH);

        List<String []> splitFileListArray = ListUtil.list2ListArray(splitFileList,InitParm.FileNameSplitStr);

        BuildParm.SPLITFILELIST = ListUtil.listArrField(splitFileListArray,0);



    }
}
