package main.parm;



import java.util.ArrayList;
import java.util.List;


/**
 *
 * Created by jlgaoyuan on 2018/5/5.
 *
 */
public class BuildParm {


    public static String inputDate ; //输入时间
    public static String inputDatePath ; //输入时间路径

    public static String INPUT_PATH ;//输入路径
    public static String SPLIT_PATH ;//拆分路径
    public static String SPLIT_SUBPATH ;//拆分文件子路径
    public static String LOG_PATH ;//日志路径

    public static  String SUMMARY_FILENAME; //摘要文件名
    public static  String DETAIL_FILENAME;  //明细文件名

    public static String SUMMARY_FILEPATH;//输入文件路径
    public static String DETAIL_FILEPATH;//拆分文件路径
    public static String LOGS_FILEPATH;//日志文件路径

    public static List<String> SPLITFILELIST;//拆分文件明细

    public static String summaryFileHead,detailFileHead;//摘要文件信息头，明细文件信息头

    public static List<String> summaryJoinField = new ArrayList<>();//摘要文件ID信息
    public static List<String> summaryMailField = new ArrayList<>();//摘要文件邮件信息
    public static List<String> detailJoinField = new ArrayList<>();//明细文件ID信息
    public static List<String> detailDetailField = new ArrayList<>();//明细文件明细字段信息
    public static List<String> detailDateField = new ArrayList<>();//明细文件日期信息


    public static List<String> summaryList = new ArrayList<>();//摘要文件信息
    public static List<String> detailList = new ArrayList<>();//明细文件信息

    public static List<String[]> summaryListArr = new ArrayList<>();//摘要文件信息数组
    public static List<String[]> detailListArr = new ArrayList<>();//明细文件信息数组


}
