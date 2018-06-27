package withjilincity.splitFiles;

import withjilincity.parm.BuildParm;
import utils.base.FileUtils;
import utils.base.LogInfo;

import java.util.Scanner;


/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 */
public class CheckFiles {


    /**
     * 文件检查
     * @return 检查是否通过
     */
    public static boolean run(){
        //检查拆分文件是否存在
        LogInfo.info("File Check");
        if(FileUtils.isDir(BuildParm.SPLIT_SUBPATH)){//检查拆分文件
            LogInfo.warn("Split Files Is Exist "+BuildParm.SPLIT_SUBPATH);
            Scanner input = new Scanner(System.in);
            LogInfo.info("delete Split Files(Y/N)");
            String deleteFilesOnOff = input.nextLine().trim();
            if(deleteFilesOnOff.equals("Y")||deleteFilesOnOff.equals("y")){
               FileUtils.deleteFiles(BuildParm.SPLIT_SUBPATH);
               FileUtils.delDir(BuildParm.SPLIT_SUBPATH);
            }else{
               return false;
            }
        }
        if(!FileUtils.isFile(BuildParm.SUMMARY_FILEPATH)){//检查摘要文件
            LogInfo.error("summary File Not Exist "+BuildParm.SUMMARY_FILEPATH);
            return false;
        }else if(!FileUtils.isFile(BuildParm.DETAIL_FILEPATH)){//检查明细文件
            LogInfo.error("detail File Not Exist "+BuildParm.DETAIL_FILEPATH);
            return false;
        }
        LogInfo.info("File Check Succeed");
            return true;
    }
}
