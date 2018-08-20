package utils.build;

import utils.base.FileUtils;
import utils.stru.StruJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jlgaoyuan on 2018/4/3.
 *
 */
public class BuildJsonStru {

    public static List<StruJson> run(String filePath) {
        List<StruJson> struJson = new ArrayList<>();
        List<String> lineList = FileUtils.read2List(filePath, 1, "UTF-8");//每行生成LIST
        for (String line : lineList) {
            StruJson stru = new StruJson();
            String arr[] = line.split(",");
            stru.setKey(arr[0]);
            stru.setDataType(arr[1]);
            struJson.add(stru);
        }
        return struJson;
    }
}
