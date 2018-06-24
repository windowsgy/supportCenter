package utils.internal;

import utils.stru.StruFieldsRules;

import java.util.List;

/**
 * Created by jlgaoyuan on 2018/6/25.
 * 数据字段检测
 */
public class Chk4Fields {

    /**
     *
     * @param fieldsList 字段List
     * @param rulesList 规则List
     * @return boolean
     */
    public boolean run(List<String> fieldsList ,List<StruFieldsRules> rulesList){
        boolean checked = false;
        if(fieldsList.size()!= rulesList.size()){
            LogInfo.warn("Field Not Eq Rules");
            return false;
        }else {
            for(int i = 0 ; i < fieldsList.size(); i ++){
                String field = fieldsList.get(i);
                StruFieldsRules rule = rulesList.get(i);
                String dataType = rule.getFieldDataType();
                if("Char".equals(dataType)||"String".equals(dataType)){
                    checked =  forChar(field,rule);
                }else if ("DateTime".equals(field)){
                    checked = forDateTime(field,rule);
                }else if ("Int".equals(field)){
                    checked = forInt(field,rule);
                }else if ("Double".equals(field)){
                    checked = forDouble(field,rule);
                }else if ("Mac".equals(field)){
                    checked = forMac(field);
                }else if ("IPV4".equals(field)){
                    checked = forIpv4(field);
                }else if ("IPV6".equals(field)){
                    checked = forIpv6(field);
                }else if ("Boolean".equals(field)){
                    checked = forBoolean(field);
                }
                if(!checked){//如果检测失败立即返回
                    LogInfo.warn(field+" is error");
                    return false;
                }

            }


        }

        return checked;


    }

    private boolean forChar(String str, StruFieldsRules rule){
        return !(0 > str.length() && str.length() > rule.getFieldLenght());
    }

    private boolean forDateTime(String str, StruFieldsRules rule){
        return DTUtils.dtFormatCheak(str,rule.getFormat());
    }

    private boolean forInt(String str, StruFieldsRules rule){//判断为Int 且 长度小于等于范围
        return Chk4Str.isFormat(str, Regex.REGEX_INT) && Integer.valueOf(str) <= rule.getFieldLenght();
    }

    private boolean forDouble(String str, StruFieldsRules rule) { //判断为Double 且 长度小于等于范围
        return Chk4Str.isFormat(str, Regex.REGEX_DOUBLE) && Double.valueOf(str) <= rule.getFieldLenght();
    }

    private boolean forIpv4(String str){
        return Chk4Str.isFormat(str,Regex.REGEX_IPV4);
    }

    private boolean forIpv6(String str){
        return Chk4Str.isFormat(str,Regex.REGEX_IPV6);
    }

    private boolean forMac(String str){
        return Chk4Str.isFormat(str,Regex.REGEX_MAC);
    }

    private boolean forBoolean(String str){
        return ("true".equals(str) || "false".equals(str));
    }

}
