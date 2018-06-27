package utils.chk;

import utils.internal.Chk4Str;
import utils.internal.DTUtils;
import utils.internal.LogInfo;
import utils.internal.Regex;


import java.util.List;
import java.util.Map;

/**
 * Created by jlgaoyuan on 2018/6/26.
 *
 */
public class ChkRules {

    /**
     * 定义规则检查
     *
     * @param map 定义规则字段
     * @return boolean
     */
    public static boolean run(Map<String, List<List<String>>> map) {
        LogInfo.info("Rules Count :" + map.size());

        //循环规则
        for (String key : map.keySet()) {
            boolean ruleChk; //规则判断
            List<List<String>> ruleList = map.get(key);
            int defineRuleSize = ruleList.size() ;//定义规则统计,行数-1，去表头统计规则行数
            LogInfo.info(key + " Rules ,Define Count :" + defineRuleSize);//打印定义规则数量
            //循环规则列表进行检测
            for (int i = 0; i < ruleList.size(); i++) {
                List<String> list = ruleList.get(i);
                // System.out.println(list.toString());
                boolean isNumber = Chk4Str.isFormat(list.get(0), Regex.REGEX_INT);//首字段是否为整数，首字段为规则编号；
                if (!isNumber) {//如果不是定义规则的行
                    return false;
                }
                ruleChk = list.size() > 4; //规则字段长度大于 4
                if (!ruleChk) { //如果规则不大于4个，规则数量不足，返回失败
                    LogInfo.error(key + " Rules ,RulesCountError: " + i + "Line");
                    return false;
                }
                ruleChk = !Chk4Str.isEmpty(list.get(1)); //第二个字段为名称字段，名称字段不为null 或 不为 ""
                if (!ruleChk) {//如果字段为空，规则存在无效字段，返回失败
                    LogInfo.error(key + " Rules ,RulesError: " + i + "Line,名称字段为空");
                    return false;
                }
                String dataType = list.get(2);
                ruleChk = Chk4Str.isDataType(dataType);//第三个字段为数据类型。
                if (!ruleChk) {//如果不是定义的数据类型,规则存在无效字段
                    LogInfo.error(key + " Rules ,RulesError: " + i + "Line,数据类型无效:" + dataType);
                    return false;
                }
                String rule = list.get(3);//规则字段
                //判断数据类型，对规则参数检测
                switch (dataType) {
                    case "Char":
                        ruleChk = Chk4Str.isFormat(rule, Regex.REGEX_INT);
                        break;
                    case "String":
                        ruleChk = Chk4Str.isFormat(rule, Regex.REGEX_INT);
                        break;
                    case "Long":
                        ruleChk = Chk4Str.includeCharCount(rule) == 1;//分隔符数量
                        if (ruleChk) {
                            String parms[] = rule.split(";");
                            ruleChk = Chk4Str.isFormat(parms[0], Regex.REGEX_INT) && Chk4Str.isFormat(parms[1], Regex.REGEX_INT);
                            if (ruleChk) {
                                ruleChk = parms[0].length() < 19 && parms[1].length() < 19;
                            }
                        }
                        break;
                    case "Int":
                        ruleChk = Chk4Str.includeCharCount(rule) == 1;
                        if (ruleChk) {
                            String parms[] = rule.split(";");
                            ruleChk = Chk4Str.isFormat(parms[0], Regex.REGEX_INT) && Chk4Str.isFormat(parms[1], Regex.REGEX_INT);
                            if (ruleChk) {
                                ruleChk = parms[0].length() < 10 && parms[1].length() < 10;
                            }
                        }
                        break;
                    case "Double":
                        int charCount = Chk4Str.includeCharCount(rule);
                        ruleChk = charCount == 1 || charCount == 2;
                        if (ruleChk) {
                            if (charCount == 1) {//一位分隔符，两个参数 ，起、止
                                String parms[] = rule.split(";");
                                ruleChk = Chk4Str.isFormat(parms[0], Regex.REGEX_INT) && Chk4Str.isFormat(parms[1], Regex.REGEX_INT);
                            } else {//两位分隔符，三个参数 起、止、小数位长度
                                String parms[] = rule.split(";");
                                ruleChk = Chk4Str.isFormat(parms[0], Regex.REGEX_INT)
                                        && Chk4Str.isFormat(parms[1], Regex.REGEX_INT)
                                        && Chk4Str.isFormat(parms[2], Regex.REGEX_INT)
                                        && Integer.valueOf(parms[2]) > 0;//小数点后位数规则必须大于0
                            }
                        }
                        break;

                    case "SET":
                        ruleChk = Chk4Str.includeCharCount(rule)>0;//分隔符号大于0
                        break;
                    case "IPV4":
                        ruleChk = true;
                        break;
                    case "IPV6":
                        ruleChk = true;
                        break;
                    case "MAC":
                        ruleChk = true;
                        break;
                    case "DateTime":
                        ruleChk = DTUtils.dateTimeFormat(rule);
                        break;
                    default:
                        ruleChk = false;
                }
                //如果检测失败，返回。
                if (!ruleChk) {
                    LogInfo.error(key + " Rules ,RulesError: " + i + " Line,数据规则无效 :" + rule);
                    return false;
                }
                String isNull = list.get(4); //是否允许为空
                if (!(("true".equals(isNull)) || ("false".equals(isNull)))) {
                    LogInfo.error(key + " Rule ,RulesError: " + i + " Line,是否为空规则无效" + isNull);
                    return false;
                }

            }
        }
        return true;
    }
}
