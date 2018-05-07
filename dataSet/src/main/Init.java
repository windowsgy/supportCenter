package main;



import java.util.ArrayList;
import java.util.List;


/**
 *
 * Created by jlgaoyuan on 2018/5/5.
 *
 */
public class Init {

    public static String inputDate = "";

    private static final String INPUT_PATH = Parm.MAIN_PATH+Parm.INPUT_PATHNAME;//输入路径
    public static final String SPLIT_PATH = Parm.MAIN_PATH+Parm.SPLIT_PATHNAME;//拆分路径
    public static  String SPLIT_SUBPATH = "";//拆分文件子路径
    private static final String LOG_PATH = Parm.MAIN_PATH+Parm.LOGS_PATHNAME;//日志路径

    public static final String SUMMARY_FILEPATH = INPUT_PATH+Parm.SUMMARY_FILENAME;//输入文件路径
    public static final String DETAIL_FILEPATH = INPUT_PATH+Parm.DETAIL_FILENAME;//拆分文件路径
    public static final String LOGS_FILEPATH = LOG_PATH+Parm.LOGS_FILENAME;//日志文件路径



    public static String summaryFileHead ,detailFileHead;//摘要文件信息头，明细文件信息头

    public static List<String> summaryJoinField = new ArrayList<>();//摘要文件ID信息
    public static List<String> summaryMailField = new ArrayList<>();//摘要文件邮件信息
    public static List<String> detailJoinField = new ArrayList<>();//明细文件ID信息
    public static List<String> detailDetailField = new ArrayList<>();//明细文件明细字段信息
    public static List<String> detailDateField = new ArrayList<>();//明细文件日期信息


    public static List<String> summaryList = new ArrayList<>();//摘要文件信息
    public static List<String> detailList = new ArrayList<>();//明细文件信息

    static List<String[]> summaryListArr = new ArrayList<>();//摘要文件信息数组
    static List<String[]> detailListArr = new ArrayList<>();//明细文件信息数组










}
