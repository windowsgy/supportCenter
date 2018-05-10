package utils.internal;

import utils.fileutils.FileUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by jlgaoyuan on 2018/4/2.
 */
public class JsonMap {

    public static List<JsonStru> run(String filePath){

        List<JsonStru> jsonList = new ArrayList<>();

        List<String> list = FileUtil.read2List(filePath,1,"UTF-8");

        for (int i = 0 ; i < list.size();i++) {

            String line[] = list.get(i).split(",");

            String key = line[0];

            String value = line[1];

            JsonStru jsonStru = new JsonStru();

            jsonStru.setKey(key);

            jsonStru.setDataType(value);

            jsonList.add(jsonStru);

        }

        return jsonList;

    }

}
