package main;

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

        LogInfo.info("加载摘要文件头");

        Init.summaryFileHead = FileUtil.readFirstLine(Init.SUMMARY_FILEPATH);

        LogInfo.info("加载明细文件头");

        Init.detailFileHead = FileUtil.readFirstLine(Init.DETAIL_FILEPATH);

        LogInfo.info("加载摘要文件内容");

        Init.summaryList = FileUtil.read2List(Init.SUMMARY_FILEPATH,2);

        LogInfo.info("加载明细文件内容");

        Init.detailList = FileUtil.read2List(Init.DETAIL_FILEPATH,2);

        LogInfo.info("加载摘要文件数组");

        Init.summaryListArr = ListUtil.list2ListArray(Init.summaryList,Parm.SplitStr);

        LogInfo.info("加载摘要文件关联字段");

        Init.summaryJoinField = ListUtil.listArrField(Init.summaryListArr,Parm.summaryJoinIndex);

        LogInfo.info("加载摘要文件邮件信息");

        Init.summaryMailField = ListUtil.listArrField(Init.summaryListArr,Parm.detailMailIndex);

        LogInfo.info("加载明细文件数组");

        Init.detailListArr =  ListUtil.list2ListArray(Init.detailList,Parm.SplitStr);

        LogInfo.info("加载明细文件关联字段");

        Init.detailJoinField = ListUtil.listArrField(Init.detailListArr,Parm.detailJoinIndex);

        LogInfo.info("加载明细文件ID信息");

        Init.detailDetailField = ListUtil.listArrField(Init.detailListArr,Parm.detailIdIndex);

        LogInfo.info("加载明细文件日期信息");

        Init.detailDateField = ListUtil.listArrField(Init.detailListArr,Parm.detailDateIndex);




    }
}
