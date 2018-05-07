package main.Check;

import main.Init;
import utils.fileutils.FileUtil;
import utils.internal.LogInfo;

import java.util.List;


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

        if(FileUtil.isDir(Init.SPLIT_PATH)){//检查拆分文件
            
            List<String> filesNamelist = FileUtil.getFileNameToList(Init.SPLIT_PATH);

            if (filesNamelist.size()!= 0) {

                LogInfo.error(Init.SPLIT_PATH+"拆分的文件已经存在，删除后再执行。");

                return false;

            }


        }

        //检查文件是否存在

        else if(!FileUtil.isFile(Init.SUMMARY_FILEPATH)){//检查摘要文件

            LogInfo.error(Init.SUMMARY_FILEPATH+"摘要文件不存在");

            return false;

        }else if(!FileUtil.isFile(Init.DETAIL_FILEPATH)){//检查明细文件

            LogInfo.error(Init.DETAIL_FILEPATH+"明细文件不存在");

            return false;

        }

            LogInfo.info("File Check Succeed");

            return true;

    }

}
