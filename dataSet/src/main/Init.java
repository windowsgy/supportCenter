package main;

import utils.external.DateTime;

/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 */
public class Init {

    private static final String DATE_FORMAT = "yyyy-MM";

    public static String dateMonth = DateTime.getCurTime(DATE_FORMAT);

    public static final String MAIN_PATH = "";//主目录
    public static final String CUR_PATHNAME = "";//当前文件路径
    public static final String HIS_PATHNAME = "";//历史文件路径
    public static final String INPUT_PATHNAME = "";//输入目录
    public static final String SPLIT_PATHNAME = "";//拆分文件路径
    public static final String LOGS_PATHNAME = "";//拆分文件路径


    public static final String CUR_INPUT_PATH = MAIN_PATH+CUR_PATHNAME+INPUT_PATHNAME;//当前输入文件路径
    public static final String HIS_INPUT_PATH = MAIN_PATH+HIS_PATHNAME+INPUT_PATHNAME;//历史输入文件路径

  /*  public static final String CUR_SPLIT_PATH = MAINPATH+CURPATH+SPLITPATH;//当前拆分文件路径
    public static final String HIS_SPLIT_PATH = MAINPATH+HISPATH+SPLITPATH;//历史拆分文件路径*/

    public static final String SUMMARYFILENAME = ""; //当前摘要文件名

    public static final String DETAILFILENAME = "";  //当前汇总文件名

    public static final String CURSPLITDIRPATH = "";//当前拆分文件路径

    public static final String LOGSATH = "";//日志目录

    public static final String logFileName = "";//日志文件名

   /* public static String summaryFilePath = mainPath+curPath+summaryFileName;

    public static String datailFilePath = mainPath+curPath+detailFileName;*/


}
