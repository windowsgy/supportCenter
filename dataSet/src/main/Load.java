package main;

import main.Parm.BuildParm;
import main.Parm.InitParm;
import utils.fileutils.FileUtil;
import utils.internal.ListUtil;
import utils.internal.LogInfo;


/**
 *
 * Created by jlgaoyuan on 2018/5/5.
 *
 */
public class Load {

    public static void  run(){

        LogInfo.info("加载摘要文件表头");

        BuildParm.summaryFileHead = FileUtil.readFirstLine(BuildParm.SUMMARY_FILEPATH);

        LogInfo.info("加载明细文件表头");

        BuildParm.detailFileHead = FileUtil.readFirstLine(BuildParm.DETAIL_FILEPATH);

        LogInfo.info("加载摘要文件内容");

        BuildParm.summaryList = FileUtil.read2List(BuildParm.SUMMARY_FILEPATH,2);//第二行开始读

        LogInfo.info("加载明细文件内容");

        BuildParm.detailList = FileUtil.read2List(BuildParm.DETAIL_FILEPATH,2);//第二行开始读

        LogInfo.info("加载摘要文件数组");

        BuildParm.summaryListArr = ListUtil.list2ListArray(BuildParm.summaryList, InitParm.SplitStr);

        LogInfo.info("加载摘要文件关联字段");

        BuildParm.summaryJoinField = ListUtil.listArrField(BuildParm.summaryListArr, InitParm.summaryJoinIndex);

        LogInfo.info("加载摘要文件邮件信息");

        BuildParm.summaryMailField = ListUtil.listArrField(BuildParm.summaryListArr, InitParm.detailMailIndex);

        LogInfo.info("加载明细文件数组");

        BuildParm.detailListArr =  ListUtil.list2ListArray(BuildParm.detailList, InitParm.SplitStr);

        LogInfo.info("加载明细文件关联字段");

        BuildParm.detailJoinField = ListUtil.listArrField(BuildParm.detailListArr, InitParm.detailJoinIndex);

        LogInfo.info("加载明细文件ID信息");

        BuildParm.detailDetailField = ListUtil.listArrField(BuildParm.detailListArr, InitParm.detailIdIndex);

        LogInfo.info("加载明细文件日期信息");

        BuildParm.detailDateField = ListUtil.listArrField(BuildParm.detailListArr, InitParm.detailDateIndex);




    }
}
