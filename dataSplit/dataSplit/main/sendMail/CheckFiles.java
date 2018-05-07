package main.sendMail;

import main.parm.BuildParm;
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
        if(!FileUtil.isDir(BuildParm.SPLIT_SUBPATH)){//检查拆分文件
            LogInfo.error(BuildParm.SPLIT_SUBPATH+"拆分文件目录不存在");
            return false;
        }
        if(!FileUtil.isFile(BuildParm.SUMMARY_FILEPATH)){//检查摘要文件
            LogInfo.error(BuildParm.SUMMARY_FILEPATH+"摘要文件不存在");
            return false;
        }
        LogInfo.info("File Check Succeed");
        return true;

    }

}
