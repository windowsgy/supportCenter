package main;

import main.Parm.BuildParm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 *
 */
public class SplitInfo {

    public static  Map<String,List<String>> run (){

        Map<String,List<String>> map = new HashMap<>();

        for(int i = 0; i < BuildParm.summaryListArr.size(); i++){

            String id = BuildParm.summaryListArr.get(i)[0];//ID

            List<String> detailList = findData(id);//明细信息

            map.put(id,detailList);

        }

        return map;

    }


    /**
     *
     * @param findStr 查找字段
     * @return
     */

    public static List<String> findData(String findStr){

        List<String> list = new ArrayList<>();

        for(int i = 0; i < BuildParm.detailListArr.size() ; i ++){

            if(BuildParm.detailListArr.get(i)[0].trim().equals(findStr)){

                list.add(BuildParm.detailList.get(i));

            }


        }

        return list;

    }

}
