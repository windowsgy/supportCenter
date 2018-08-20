package utils.chk;

import utils.base.DateTimeUtils;
import utils.base.LogInfo;
import utils.base.Regex;
import utils.stru.StruFieldsRules;

import java.util.List;

/**
 * Created by jlgaoyuan on 2018/6/25.
 * 数据字段检测
 */
public class Chk4Fields {

    /**
     * @param fieldsList 字段List
     * @param rulesList  规则List
     * @return boolean
     */
    public boolean run(List<String> fieldsList, List<StruFieldsRules> rulesList) {
        boolean checked = false;
        if (fieldsList.size() != rulesList.size()) {
            LogInfo.warn("Field Not Eq Rules");
            return false;
        } else {
            for (int i = 0; i < fieldsList.size(); i++) {
                String field = fieldsList.get(i);
                StruFieldsRules rule = rulesList.get(i);
                String dataType = rule.getFieldDataType();
                if ("Char".equals(dataType) || "String".equals(dataType)) {
                    checked = forChar(field, rule);
                } else if ("DateTime".equals(field)) {
                    checked = forDateTime(field, rule);
                } else if ("Int".equals(field)) {
                    checked = forInt(field, rule);
                } else if ("Long".equals(field)) {
                    checked = forLong(field, rule);
                } else if ("Double".equals(field)) {
                    checked = forDouble(field, rule);
                } else if ("MAC".equals(field) || "IPV4".equals(field) || "IPV6".equals(field)) {
                    checked = forFormat(field, rule);
                } else if ("SET".equals(field)) {
                    checked = forSet(field, rule);
                } else if ("Boolean".equals(field)) {
                    checked = forBoolean(field, rule);
                }
                if (!checked) {//如果检测失败\返回
                    LogInfo.warn(field + " is error");
                    return false;
                }
            }
        }
        return checked;
    }

    private boolean forChar(String str, StruFieldsRules rule) {
        //如果为空值,并且允许为空，并且小于界定范围
        return Chk4Str.isEmpty(str)
                && rule.isNull()
                && str.length() <= rule.getLenght();
    }

    private boolean forDateTime(String str, StruFieldsRules rule) {
        return Chk4Str.isEmpty(str)
                && rule.isNull()
                && DateTimeUtils.dtFormatCheak(str, rule.getFormat());
    }

    private boolean forInt(String str, StruFieldsRules rule) {//判断为Int在界定范围
        return Chk4Str.isEmpty(str) && rule.isNull()
                && Chk4Str.isFormat(str, Regex.REGEX_INT)
                && Chk4Str.numberScope(rule.getStartInt(), rule.getEndInt(), Integer.valueOf(str));
    }

    private boolean forLong(String str, StruFieldsRules rule) {//判断为Long在界定范围
        return Chk4Str.isEmpty(str) && rule.isNull()
                && Chk4Str.isFormat(str, Regex.REGEX_INT)
                && Chk4Str.numberScope(rule.getStartLong(), rule.getEndLong(), Long.valueOf(str));
    }

    private boolean forDouble(String str, StruFieldsRules rule) { //判断为Double 且 长度小于等于范围
        boolean chk = Chk4Str.isEmpty(str) && rule.isNull()
                && Chk4Str.isFormat(str, Regex.REGEX_DOUBLE)
                && Chk4Str.numberScope(rule.getStartDouble(), rule.getEndDouble(), Double.valueOf(str));
        if (rule.getLenght() > 0) {//小数点后几位判断
            chk = str.substring(str.indexOf('.'), str.length()).length() <= rule.getLenght();
        }
        return chk;
    }


    private boolean forFormat(String str, StruFieldsRules rule) {
        return Chk4Str.isEmpty(str) && rule.isNull()
                && Chk4Str.isFormat(str, Regex.REGEX_MAC);
    }

    private boolean forBoolean(String str, StruFieldsRules rule) {
        return Chk4Str.isEmpty(str) && rule.isNull()
                && ("true".equals(str) || "false".equals(str));
    }

    private boolean forSet(String str, StruFieldsRules rule) {//Set 包含此字段
        return rule.getSet().contains(str);
    }

}
