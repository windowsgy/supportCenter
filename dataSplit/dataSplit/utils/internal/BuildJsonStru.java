package utils.internal;

import utils.fileutils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by jlgaoyuan on 2018/4/3.
 *
 */
public class BuildJsonStru {

    public static List<JsonStru> run (String filePath){

        List<JsonStru> jsonStru = new ArrayList<>();

        List<String> lineList = FileUtil.read2List(filePath,1,"UTF-8");//每行生成LIST

        for(int i = 0 ; i < lineList.size();i++){

            String line = lineList.get(i);

            JsonStru stru = new JsonStru();

            String arr[]  = line.split(",");

            stru.setKey(arr[0]);

            stru.setDataType(arr[1]);

            jsonStru.add(stru);

        }

        return jsonStru;


    }


}
