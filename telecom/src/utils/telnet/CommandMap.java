package utils.telnet;

import utils.base.FileUtils;
import utils.base.ListUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by jlgaoyuan on 2018/5/15.
 *
 */
public class CommandMap {

    public static Map<String,String> run(String path, String splintParm){
        Map<String,String> commandMap = new HashMap<>();
        String code = FileUtils.codeString(path);
        List<String[]> listCmd  = ListUtils.list2ListArray(FileUtils.read2List(path,0,code),splintParm);
        for (String[] arr : listCmd) {
            commandMap.put(arr[0] + arr[1] + arr[2], arr[3]);
        }
        return commandMap;
    }
}
