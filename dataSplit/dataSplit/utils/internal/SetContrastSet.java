package utils.internal;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by jlgaoyuan on 2018/5/7.
 */
public class SetContrastSet {


    public static boolean isSetEqual(Set<String> set1, Set<String> set2){

        if(set1.size() != set2.size()){
            return false;
        }

        Iterator ite1 = set1.iterator();
        Iterator ite2 = set2.iterator();
        while(ite1.hasNext()){
            if(ite1.next() != ite2.next()){
                return false;
            }
        }

        return true;
    }


}
