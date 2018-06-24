package utils.internal;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by jlgaoyuan on 2018/5/5.
 * List 工具
 */
public class ListUtil {

    /**
     * List To List Array
     *
     * @param list      List
     * @param splitChar SplitChar
     * @return List Array
     */
    public static List<String[]> list2ListArray(List<String> list, String splitChar) {
        String[] firstArray = list.get(0).split(splitChar); //首行
        int firstArraySize = firstArray.length;
        //  LogInfo.info("First Array Size:"+firstArraySize);
        List<String[]> listArray = new ArrayList<>();
        int lineCount = 0;
        for (String aList : list) {
            lineCount++;
            String[] array = aList.split(splitChar);
            if (array.length != firstArraySize) {
                LogInfo.info(lineCount + " :Line Error : " + aList);
                return null;
            }
            listArray.add(aList.split(splitChar));
        }
        return listArray;
    }


    /**
     * List 按分隔符拆分为  行、列 字段模式
     *
     * @param list      List
     * @param splitChar 分隔符
     * @return 行、列 列表
     */
    public static List<List<String>> list2ListFields(List<String> list, String splitChar) {
        String[] firstArray = list.get(0).split(splitChar); //首行
        int firstArraySize = firstArray.length;
        List<List<String>> theList = new ArrayList<>();
        int lineCount = 0;
        for (String lists : list) {
            lineCount++;
            String[] array = lists.split(splitChar);
            if (array.length == firstArraySize) {// 如果此行长度不等于首行字段长度
                theList.add(Arrays.asList(array));
            } else {
                LogInfo.error(lineCount + " :Line Error , Current Line Split Lenght : " + lists);
                return null;
            }
        }
        return theList;
    }


    /**
     * @param listArray List
     * @param index     index
     * @return List
     */
    public static List<String> listArrField(List<String[]> listArray, int index) {
        List<String> list = new ArrayList<>();

        for (String[] aListArray : listArray) {

            list.add(aListArray[index]);

        }
        return list;
    }

    /**
     * List To Set
     *
     * @param list List
     * @return Set
     */
    public static Set<String> listToSet(List<String> list) {
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
     * @param list  List
     * @param regex Regex
     * @return List
     */
    public static List<String> listFilter(List<String> list, String regex) {
        List<String> filterList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            if (Pattern.matches(regex, line)) {
                filterList.add(line);
            }
        }
        return filterList;
    }
}
