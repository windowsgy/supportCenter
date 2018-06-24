package utils.internal;

import utils.fileutils.FileUtil;
import utils.stru.StruJson;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by jlgaoyuan on 2018/4/2.
 */
public class JsonMap {

    public static List<StruJson> run(String filePath){

        List<StruJson> jsonList = new ArrayList<>();

        List<String> list = FileUtil.read2List(filePath,1,"UTF-8");

        for (int i = 0 ; i < list.size();i++) {

            String line[] = list.get(i).split(",");

            String key = line[0];

            String value = line[1];

            StruJson struJson = new StruJson();

            struJson.setKey(key);

            struJson.setDataType(value);

            jsonList.add(struJson);

        }

        return jsonList;

    }

}
