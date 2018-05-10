package splitFiles;

import parm.BuildParm;
import parm.InitParm;
import utils.fileutils.FileUtil;
import utils.internal.ListUtil;
import utils.internal.LogInfo;


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

        LogInfo.info("加载明细文件表头");

        BuildParm.detailFileHead = FileUtil.readFirstLine(BuildParm.DETAIL_FILEPATH,BuildParm.detailFileCode);

        LogInfo.info("加载汇总文件内容");

        BuildParm.summaryList = FileUtil.read2List(BuildParm.SUMMARY_FILEPATH,2,BuildParm.summaryFileCode);//第二行开始读

        LogInfo.info("加载明细文件内容");

        BuildParm.detailList = FileUtil.read2List(BuildParm.DETAIL_FILEPATH,2,BuildParm.detailFileCode);//第二行开始读

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

        LogInfo.info("加载明细文件数组");

        BuildParm.detailListArr =  ListUtil.list2ListArray(BuildParm.detailList, InitParm.SplitStr);

        if(BuildParm.detailListArr == null){

            LogInfo.info("明细文件字段数量不一致");

            return false;

        }

        LogInfo.info("加载明细文件关联字段");

        BuildParm.detailJoinField = ListUtil.listArrField(BuildParm.detailListArr, InitParm.detailJoinIndex);

        LogInfo.info("加载明细文件ID信息");

        BuildParm.detailDetailField = ListUtil.listArrField(BuildParm.detailListArr, InitParm.detailIdIndex);

        LogInfo.info("加载明细文件日期信息");

        BuildParm.detailDateField = ListUtil.listArrField(BuildParm.detailListArr, InitParm.detailDateIndex);


        LogInfo.info("Loading Files Succeed");

        return true;

    }
}
