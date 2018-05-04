package main;

import utils.fileutils.FileUtil;
import utils.internal.LogInfo;


/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 */
public class Check {

    /**
     * 文件检查
     * @param filePath 文件路径
     * @return
     */

    public static boolean checkFiles(){

       /* if(!FileUtil.checkFileExists(Init.summaryFilePath)){//检查摘要文件

            LogInfo.error(Init.summaryFilePath+"文件不存在");

            return false;

        }else if(!FileUtil.checkFileExists(Init.datailFilePath)){//检查明细文件

            LogInfo.error(Init.datailFilePath+"文件不存在");

        }

*/
        return true;


    }



}
