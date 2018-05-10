package main.splitFiles;

import main.parm.BuildParm;
import utils.fileutils.FileUtil;
import utils.internal.LogInfo;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by jlgaoyuan on 2018/5/7.
 *
 */
public class WrMap {

    public static void run(Map<String,List<String>> map){

        LogInfo.info("创建拆分文件目录");

        FileUtil.createDir(BuildParm.SPLIT_SUBPATH);

        StringBuilder sb = new StringBuilder();

        sb.append(BuildParm.detailFileHead).append("\r");

        for (String key : map.keySet()) {

            String fileName = key+".csv";

            String filePath = BuildParm.SPLIT_SUBPATH+fileName;

            List<String> list = map.get(key);

            for (String aList : list) {

                sb.append(aList).append("\r");

            }

            FileUtil.wrStrToFile(sb.toString(),filePath,BuildParm.detailFileCode);

            sb.setLength(0);

            sb.append(BuildParm.detailFileHead).append("\r");

        }


    }


}
