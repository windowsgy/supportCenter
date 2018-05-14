package utils.internal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

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

      //  LogInfo.linel4();

      //  LogInfo.info("List To ListArray");

        String [] firstArray = list.get(0).split(splitChar); //首行

        int firstArraySize = firstArray.length;

      //  LogInfo.info("First Array Size:"+firstArraySize);

        List<String[]> listArray = new ArrayList<>();

        int lineCount = 0;

        for (String aList : list) {

            lineCount++;

            String [] array = aList.split(splitChar);

            if(array.length!= firstArraySize){

                LogInfo.info(lineCount+" :Line Error : "+aList );

                return null;


            }


            listArray.add(aList.split(splitChar));

        }

        return listArray;

    }

    /**
     *
     * @param listArray List
     * @param index index
     * @return List
     */


    public static  List<String> listArrField (List<String[]> listArray,int index) {

        //LogInfo.linel4();

      //  LogInfo.info("ListArrayFieldIndex:"+index);

        List<String> list = new ArrayList<>();

        for (String[] aListArray : listArray) {

            list.add(aListArray[index]);

        }

      //  LogInfo.info("ListFieldSize:"+list.size());

      //  LogInfo.linel4();

        return list;

    }

    /**
     * List To Set
     * @param list List
     * @return Set
     */


    public  static Set<String> listToSet(List<String> list){

      //  LogInfo.linel4();

      //  LogInfo.info("List To Set Size:"+list.size());

        Set<String> set = new HashSet<>();

        for (String aList : list) {

            set.add(aList);

        }

     //   LogInfo.info("Set Size:"+set.size());

     //   LogInfo.linel4();

        return set;

    }

    /**
     *
     * @param list List
     * @param regex Regex
     * @return List
     */


    public static  List<String> listFilter (List<String> list,String regex) {

        List<String> filterList = new ArrayList<>();

        for(int i = 0 ; i < list.size();i++){

            String line = list.get(i);

            if(Pattern.matches(regex, line)){

                filterList.add(line);

            }

        }

        return filterList;

    }



}
