package utils.internal;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * Created by jlgaoyuan on 2018/4/2.
 */
public class ToJson {

    public static String run(String arr [], List<JsonStru> list){

        List<String> jsonList = new ArrayList<>();

        for(int i = 0 ; i < arr.length;i++){

            String key = list.get(i).getKey();

            String dataType = list.get(i).getDataType();

            String jsonKey = "\""+key+"\":";

            String jsonValue = arr[i];

            if(dataType.equals("string")){

                jsonValue =  "\""+jsonValue+"\"";

            }

            jsonList.add(jsonKey+jsonValue);

        }

        return runAdd(jsonList);

    }


    public static String runAdd(List<String> list){

        StringBuffer sb = new StringBuffer();

        for(int i = 0 ; i < list.size();i++){

            sb.append(list.get(i));

            if(i!=list.size()-1){

                sb.append(",");

            }

        }

        return "{"+sb.toString()+"}";

    }

}
