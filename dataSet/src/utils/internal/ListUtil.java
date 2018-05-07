package utils.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jlgaoyuan on 2018/5/5.
 */
public class ListUtil {

    /**
     * List 拆分每行至数组
     * @param path 文件路径
     * @return L
     */


    public static List<String[]> list2ListArray (List<String> list, String splitChar) {

        LogInfo.linel4();

        LogInfo.info("List Line To List Array :");

        List<String[]> listArray = new ArrayList<>();

        for (String aList : list) {

            listArray.add(aList.split(splitChar));

        }

        return listArray;

    }

    /**
     *
     * @param listArray List数组
     * @param index 字段
     * @return
     */


    public static  List<String> listArrField (List<String[]> listArray,int index) {

        LogInfo.linel4();

        LogInfo.info("ListArrayField:");

        List<String> list = new ArrayList<>();

        for (String[] aListArray : listArray) {

            list.add(aListArray[index]);

        }

        return list;

    }

    /**
     * List To Set
     * @param list List
     * @return
     */


    public  static Set<String> listToSet(List<String> list){

        Set<String> set = new HashSet<>();

        for(int i = 0 ; i < list.size();i++){

            set.add(list.get(i));

        }

        return set;

    }



}
