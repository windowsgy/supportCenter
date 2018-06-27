package utils.telnet;

import utils.base.FileUtils;
import utils.base.ListUtils;
import utils.base.LogInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by jlgaoyuan on 2018/5/15.
 *
 */
public class TelnetMain {

    public static void main (String [] args){

        String splintParm = "\\|\\|";
        String inputPath = "E:\\TelnetGater\\input\\base.txt";
        String parmPath = "E:\\TelnetGater\\parm\\command.txt";
        Map<String,String> cmdMap = CommandMap.run(parmPath,splintParm);
        String code = FileUtils.codeString(inputPath);
        List<String[]> list  = ListUtils.list2ListArray(FileUtils.read2List(inputPath,0,code),splintParm);
        List<StruTelnetMap> telnetList = new ArrayList<>();

        for(int i = 0 ; i < list.size();i++){
            StruTelnetMap map = new StruTelnetMap();
            map.setTaskNumber(i);
            map.setIpadd(list.get(i)[0]);
            map.setUsername(list.get(i)[1]);
            map.setPassword(list.get(i)[2]);
            if(list.get(i)[3].contains("version")){
                map.setCmd(list.get(i)[3]);
            }else {
                String findStr = list.get(i)[4]+list.get(i)[5]+list.get(i)[3];
                if(cmdMap.containsKey(findStr)){
                   map.setCmd(cmdMap.get(findStr)+"\rexit");
                }else
                    LogInfo.info("Not Find Command");
                    return;
            }
            telnetList.add(map);
        }
        GatTelnet.run(telnetList);
    }
}
