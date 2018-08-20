package utils.build;

import utils.chk.Chk4Str;
import utils.base.Regex;
import utils.base.*;
import utils.stru.StruFieldsRules;

import java.util.*;


/**
 * Created by jlgaoyuan on 2018/6/24.
 * 构建字段规则结构体
 */
public class BuildFieldsRuleStru {

    /**
     * 工厂方法 构建规则结构体
     *
     * @param map 检测规则
     * @return 检测结构体
     */
    public static Map<String, List<StruFieldsRules>> run(Map<String, List<List<String>>> map) {
        Map<String, List<StruFieldsRules>> struMap = new HashMap<>();//返回的规则结构
        LogInfo.info("RulesSet Count :" + map.size());
        //循环规则
        for (String key : map.keySet()) {
            //定义规则数量
            int defineRuleSize = map.get(key).size();//定义规则统计，
          //  LogInfo.info(key + " Rules ,Define Count :" + defineRuleSize);//打印定义规则数量
            List<StruFieldsRules> list = buildStru(map.get(key));//构建规则结构体
            if (list == null) {
                return null;
            }
            //构造规则数量
            int buildRulesSize = list.size();
         //   LogInfo.info(key + " Rules ,Build Rules Count :" + buildRulesSize);//检测规则统计
            if (!(defineRuleSize == buildRulesSize)) {//定义规则等于构建规则数量
                return null;//如果定义规则数量不等于构造的规则数量 返回空;
            } else struMap.put(key, list);
        }
        LogInfo.info("Build RulesSet Count :" + struMap.size());
        if (map.size() != struMap.size()) {//如果定义规则集合数量不等于构造集合数量，返回空
            return null;
        }
        return struMap;//返回集合
    }

    /**
     * 检测规则列表，返回规则结构体
     *
     * @param list 规则列表
     * @return 规则结构体
     */
    private static List<StruFieldsRules> buildStru(List<List<String>> list) {
        List<StruFieldsRules> rulesList = new ArrayList<>();
        //循环规则列表进行构建
        try {
            for (List<String> fieldsList : list) {
                StruFieldsRules stru = new StruFieldsRules();//规则结构体
                stru.setFieldName(fieldsList.get(1)); //第二个字段为名称字段
                stru.setFieldDataType(fieldsList.get(2));
                //判断数据类型，对规则参数检测
                String rule = fieldsList.get(3);
                switch (fieldsList.get(2).trim()) {//根据数据类型构建规则
                    case "Char":
                    case "String":
                        stru.setLenght(Integer.valueOf(fieldsList.get(3)));
                        break;
                    case "Long":
                        String longParms[] = rule.split(";");
                        stru.setStart(Long.parseLong(longParms[0]));
                        stru.setEnd(Long.parseLong(longParms[1]));
                        break;
                    case "Int":
                        String intParms[] = rule.split(";");
                        stru.setStart(Integer.valueOf(intParms[0]));
                        stru.setEnd(Integer.valueOf(intParms[1]));
                        break;
                    case "Double":
                        String doubleParms[] = rule.split(";");
                        if (Chk4Str.includeCharCount(rule) == 1) {//一位分隔符，两个参数 ，起、止
                            stru.setStart(Double.valueOf(doubleParms[0]));
                            stru.setEnd(Double.valueOf(doubleParms[1]));
                        } else if (Chk4Str.includeCharCount(rule) == 2) {//两位分隔符，三个参数 起、止、小数位长度
                            stru.setStart(Double.valueOf(doubleParms[0]));
                            stru.setEnd(Double.valueOf(doubleParms[1]));
                            stru.setLenght(Integer.valueOf(doubleParms[2]));
                        }
                        break;
                    case "SET":
                        Set set = new HashSet<>(Arrays.asList(rule.split(";")));
                        stru.setSet(set);
                        break;
                    case "IPV4":
                        stru.setFormat(Regex.REGEX_IPV4);
                        break;
                    case "IPV6":
                        stru.setFormat(Regex.REGEX_IPV6);
                        break;
                    case "MAC":
                        stru.setFormat(Regex.REGEX_MAC);
                        break;
                    case "DateTime":
                        stru.setFormat(rule);
                        break;
                    default:
                        break;
                }
                String isNull = fieldsList.get(4); //是否允许为空规则
                if ("TRUE".equals(isNull)) {
                    stru.setIsNull(true);
                } else if ("FALSE".equals(isNull)) {
                    stru.setIsNull(false);
                }
                rulesList.add(stru);//添加结构体
            }
        } catch (Exception e) {
            LogInfo.error(e.getClass().getSimpleName() + "," + e.getMessage());
            return null;
        }
        return rulesList;//返回结构体
    }
}
