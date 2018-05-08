package utils.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Created by jlgaoyuan on 2018/5/5.
 * 
 */
public class ListUtil {

    /**
     * List To List Array
     * @param list List
     * @param splitChar SplitChar
     * @return List Array
     */

    public static List<String[]> list2ListArray (List<String> list, String splitChar) {

        LogInfo.linel4();

        LogInfo.info("List To List Array  Size:"+list.size());

        List<String[]> listArray = new ArrayList<>();

        for (String aList : list) {

            listArray.add(aList.split(splitChar));

        }
        LogInfo.linel4();

        return listArray;

    }

    /**
     *
     * @param listArray List
     * @param index index
     * @return List
     */


    public static  List<String> listArrField (List<String[]> listArray,int index) {

        LogInfo.linel4();

        LogInfo.info("ListArrayField:");

        List<String> list = new ArrayList<>();

        for (String[] aListArray : listArray) {

            list.add(aListArray[index]);

        }
        LogInfo.linel4();

        return list;

    }

    /**
     * List To Set
     * @param list List
     * @return Set
     */


    public  static Set<String> listToSet(List<String> list){

        LogInfo.linel4();

        LogInfo.info("List To Set Size:"+list.size());

        Set<String> set = new HashSet<>();

        for (String aList : list) {

            set.add(aList);

        }

        LogInfo.linel4();

        return set;

    }



}
