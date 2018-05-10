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

        LogInfo.info("Summary File Code :"+BuildParm.summaryFileCode);

        BuildParm.detailFileCode = FileUtil.codeString(BuildParm.DETAIL_FILEPATH);

        LogInfo.info("Detail File Code :"+BuildParm.detailFileCode);

        LogInfo.info("Load Summary File Head");

        BuildParm.summaryFileHead = FileUtil.readFirstLine(BuildParm.SUMMARY_FILEPATH,BuildParm.summaryFileCode);

        LogInfo.info("Load Detail File Head");

        BuildParm.detailFileHead = FileUtil.readFirstLine(BuildParm.DETAIL_FILEPATH,BuildParm.detailFileCode);

        LogInfo.info("Load Summary File To List");

        BuildParm.summaryList = FileUtil.read2List(BuildParm.SUMMARY_FILEPATH,2,BuildParm.summaryFileCode);//第二行开始读

        LogInfo.info("Load Detail File To List");

        BuildParm.detailList = FileUtil.read2List(BuildParm.DETAIL_FILEPATH,2,BuildParm.detailFileCode);//第二行开始读

        LogInfo.info("Load Summary File ListArray");

        BuildParm.summaryListArr = ListUtil.list2ListArray(BuildParm.summaryList, InitParm.SplitStr);

        if(BuildParm.summaryListArr == null){

            LogInfo.info("Summary Field Inconformity");//每行字段数量不一致

            return false;

        }

        LogInfo.info("Load Summary File Join Field");

        BuildParm.summaryJoinField = ListUtil.listArrField(BuildParm.summaryListArr, InitParm.summaryJoinIndex);

        LogInfo.info("Load Mail Field");

        BuildParm.summaryMailField = ListUtil.listArrField(BuildParm.summaryListArr, InitParm.detailMailIndex);

        LogInfo.info("Load Detail File ListArray");

        BuildParm.detailListArr =  ListUtil.list2ListArray(BuildParm.detailList, InitParm.SplitStr);

        if(BuildParm.detailListArr == null){

            LogInfo.info("Detail Field Inconformity");//每行字段数量不一致

            return false;

        }

        LogInfo.info("Load Detail File Join Field");

        BuildParm.detailJoinField = ListUtil.listArrField(BuildParm.detailListArr, InitParm.detailJoinIndex);

        LogInfo.info("Load Detail File Id Field");

        BuildParm.detailDetailField = ListUtil.listArrField(BuildParm.detailListArr, InitParm.detailIdIndex);

        LogInfo.info("Load Detail Date Field");

        BuildParm.detailDateField = ListUtil.listArrField(BuildParm.detailListArr, InitParm.detailDateIndex);


        LogInfo.info("Loading Files Succeed");

        return true;

    }
}
