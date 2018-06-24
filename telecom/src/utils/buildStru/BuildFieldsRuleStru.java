package utils.buildStru;

import utils.internal.DTUtils;
import utils.internal.LogInfo;
import utils.internal.Regex;
import utils.stru.StruFieldsRules;
import utils.internal.Chk4Str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by jlgaoyuan on 2018/6/24.
 * 构建字段规则结构体
 */
public class BuildFieldsRuleStru {

    /**
     * 工厂方法 检测字段规则后，构建检测结构体
     *
     * @param map 检测规则
     * @return 检测结构体
     */
    public Map<String, List<StruFieldsRules>> run(Map<String, List<List<String>>> map) {
        Map<String, List<StruFieldsRules>> struMap = new HashMap<>();//返回的规则结构
        LogInfo.info("Rules Count :" + map.size());
        //循环规则信息
        for (String key : map.keySet()) {
            LogInfo.info(key + " Rule ,Define FieldsRules Count :" + map.get(key).size());//定义规则统计
            List<List<String>> list = check(map.get(key));//检测后的规则列表
            LogInfo.info(key + " Rule ,Checked FieldsRules Count :" + list.size());//检测规则统计
            if (list.size() > 0) {//如果规则大于0
                List<StruFieldsRules> listStru = build(list);//生成返回数据集
                struMap.put(key, listStru);
                LogInfo.info(key + " Rule ,Build FieldsRules Count :" + map.get(key).size());//生成规则统计
            }
        }
        LogInfo.info(" Build Rules Count: " + struMap.size());
        return struMap;//返回集合
    }

    /**
     * 检测规则列表，返回满足条件的规则
     *
     * @param list 规则列表
     * @return 检测后的规则列表
     */
    private List<List<String>> check(List<List<String>> list) {
        //循环规则列表进行检测
        for (List<String> fieldsList : list) {
            boolean size = fieldsList.size() > 4; //规则字段长度大于 4
            boolean isNumber = Chk4Str.isFormat(fieldsList.get(0), Regex.REGEX_INT);//首字段是否为整数，首字段为规则编号；
            boolean isEmpty = !Chk4Str.isEmpty(fieldsList.get(1)); //第二个字段为名称字段，名称字段不为null 或 不为 ""
            String dataType = fieldsList.get(2);
            boolean isDataType = Chk4Str.isDataType(dataType);//第三个字段为数据类型。
            boolean len = Chk4Str.isFormat(fieldsList.get(3),Regex.REGEX_INT);//第四个字段为长度规则，长度为整数。
            boolean dateFormat = true;
            if (isDataType && "DATETIME".equals(dataType) ) {//如果时间格式进行了定义，则对时间格式进行检查
                dateFormat = DTUtils.dateTimeFormat(fieldsList.get(4));
            }
            if (!(size && isNumber && isEmpty && isDataType && len && dateFormat)) {//如果不符合定义规则，进行删除
                list.remove(fieldsList);//如果不复合定义的规则则删除
            }
        }
        return list;
    }


    /**
     * 构建检测规则结构体
     *
     * @param list 规则列表
     * @return 规则结构体
     */
    private List<StruFieldsRules> build(List<List<String>> list) {
        List<StruFieldsRules> listStru = new ArrayList<>();//生成返回数据集
        for (List<String> fieldsList : list) {
            StruFieldsRules stru = new StruFieldsRules();
            stru.setFieldName(fieldsList.get(1));//字段名称
            stru.setFieldDataType(fieldsList.get(2));//数据类型
            stru.setFieldLenght(Integer.valueOf(fieldsList.get(3)));//长度规则
            stru.setDTFormat(fieldsList.get(4));
            stru.setFieldDesc(fieldsList.get(5));//字段描述
            listStru.add(stru);
        }
        return listStru;
    }
}
