package utils.internal;

//import utils.Log;

/**
 * 字段监测工具，用于ID,播放类型，统计值检查
 * Created by jlgaoyuan on 2017/8/22.
 */
public class ChkUtils {

    public static boolean isAreaID(String str) {

        //  Log log = new Log();

        //  log.debug(str);

        //    log.debug("areaid error : "+str);
        return IsNumber.isInt(str)
                && str.length() == 6;
//   log.debug("areaid error : "+str);

    }

    public static boolean isNodeID(String str) {

        //Log log = new Log();

        // log.debug("nodeid error : "+str);
        return IsNumber.isInt(str)
                && str.length() == 4;


    }


    public static boolean isServerID(String str) {

        //  Log log = new Log();

        //  log.debug(str);

        //       log.debug("serverid error : "+str);
        return IsNumber.isInt(str)
                && str.length() == 5;


    }

    public static boolean isPlayType(String str) { //播放类型检查

        //Log log = new Log();

        //  log.debug(str);

        //   log.debug("playType error : "+str);

        return  str.equals("0")
                || str.equals("1")
                || str.equals("2")
                || str.equals("3")
                || str.equals("4")
                || str.equals("5")
                || str.equals("6")
                || str.equals("7")
                || str.equals("8")
                || str.equals("9");


    }

    public static boolean isValue(String str) { //统计值必须大于等于0

    //    Log log = new Log();

        // log.debug(str);

        if (IsNumber.isNumeric(str)) {

            double value = Double.parseDouble(str);

            //    log.debug("value error : "+str);
            return value >= 0;

        } else {

            // log.debug("value error : "+str);

            return false;
        }

    }

    public static boolean isSampleSize(String str) { //统计值必须大于等于0

       // Log log = new Log();

        //  log.debug(str);

        if (IsNumber.isInt(str)) {

            int value = Integer.parseInt(str);

            //   log.debug("sampleSize error : "+str);
            return value >= 0;

        } else {

            //  log.debug("sampleSize error : "+str);

            return false;
        }

    }


}
