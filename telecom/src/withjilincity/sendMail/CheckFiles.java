package withjilincity.sendMail;


import withjilincity.parm.BuildParm;
import utils.base.FileUtil;
import utils.base.LogInfo;




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
            LogInfo.error("Split Dir Not Exist"+BuildParm.SPLIT_SUBPATH);
            return false;
        }
        if(!FileUtil.isFile(BuildParm.SUMMARY_FILEPATH)){//检查摘要文件
            LogInfo.error("Summary Files Not Exist"+BuildParm.SUMMARY_FILEPATH);
            return false;
        }
        LogInfo.info("File Check Succeed");
        return true;
    }
}
