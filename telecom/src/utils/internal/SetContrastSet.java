package utils.internal;


import java.util.Set;

/**
 *
 * Created by jlgaoyuan on 2018/5/7.
 *
 */
public class SetContrastSet {


    /**
     * 判断两个集合是否相等
     * @param set1 集合1
     * @param set2 集合2
     * @return boolean
     */
    public static boolean isSetEqual(Set<String> set1, Set<String> set2) {
        boolean isEqual = true;
        if (set1 == null && set2 == null) {
            LogInfo.info("All Set Is Null");
            isEqual = true;
        } else if (set1 == null || set2 == null) {
            LogInfo.info("a Set Is Null");
            isEqual = false;

        } else if (set1.size() != set2.size()) {
            LogInfo.info("Size Inconformity ");
            isEqual = false;
        } else if (!set1.containsAll(set2)) {
            LogInfo.info("Info Inconformity ");
        }
        return isEqual;
    }


}
