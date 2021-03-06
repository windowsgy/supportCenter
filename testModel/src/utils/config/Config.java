package utils.config;

import utils.base.LogInfo;

import java.io.InputStream;
import java.util.*;

/**
 * 读取配置文件，返回以Map的形式
 * Created by Administrator on 2017/5/10.
 */
public class Config {

    /**
     * 构建参数集合
     * @param fileName 参数文件名
     * @return 参数集合
     */
    public  Map<String, Map<String, String>> buildConfig(String fileName) {//配置文件名称
        List<String> configKeys = Arrays.asList("localpath", "localfilename");//参数类型列表
        Map<String, Map<String, String>> params = new HashMap<>();//返回参数信息
        Properties props = new Properties();
        try {
            InputStream ins = Config.class.getClassLoader().getResourceAsStream(fileName);
            props.load(ins);
            for (String key : configKeys) { //按参数列表初始化参数类型Map
                params.put(key, new HashMap<String, String>());
            }
            for (Object key : props.keySet()) {
                String keyString = String.valueOf(key);  //Key
                String valString = props.getProperty(keyString);//Value
                if (keyString.contains(".")) { //判断参数Key包含 . ，用于截取typeKey,subKey
                    String keys[] = keyString.split("\\.");
                    if (configKeys.contains(keys[0])) { //如果参数类型列表包含设定参数
                        params.get(keys[0]).put(keys[1], valString);
                    }
                }
            }
        }  catch (Exception e) {
            LogInfo.error(e.getClass().getSimpleName()+""+e.getMessage());
        }
        return params;

    }
}
