package splitFiles;

import parm.BuildParm;
import utils.fileutils.FileUtil;
import utils.internal.LogInfo;

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
        if(FileUtil.isDir(BuildParm.SPLIT_SUBPATH)){//检查拆分文件
            LogInfo.error(BuildParm.SPLIT_SUBPATH+"Split Files Is Exist");
            Scanner input = new Scanner(System.in);
            LogInfo.info("delete Split Files(Y/N)");
            String deleteFilesOnOff = input.nextLine().trim();
            if(deleteFilesOnOff.equals("Y")||deleteFilesOnOff.equals("y")){
               FileUtil.deleteFiles(BuildParm.SPLIT_SUBPATH);
               FileUtil.delDir(BuildParm.SPLIT_SUBPATH);
            }else{
               return false;
            }
        }

        if(!FileUtil.isFile(BuildParm.SUMMARY_FILEPATH)){//检查摘要文件
            LogInfo.error(BuildParm.SUMMARY_FILEPATH+"summary File Not Exist");
            return false;
        }else if(!FileUtil.isFile(BuildParm.DETAIL_FILEPATH)){//检查明细文件
            LogInfo.error(BuildParm.DETAIL_FILEPATH+"detail File Not Exist");
            return false;
        }
        LogInfo.info("File Check Succeed");
            return true;

    }

}
