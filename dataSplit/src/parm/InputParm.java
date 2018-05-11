package parm;



import utils.internal.DTUtils;
import utils.internal.LogInfo;

import java.util.Scanner;

/**
 *
 * Created by jlgaoyuan on 2018/5/7.
 */
public class InputParm {

    public static boolean run() {

        Scanner input = new Scanner(System.in);

        LogInfo.info("InputDate............"+ InitParm.DATE_FORMAT);

        String inputDate = input.nextLine().trim();

        if (inputDate.length() != 6) {

            LogInfo.error("Date Format Error");

            return false;

        } else if (!DTUtils.dateFormatCheak(inputDate, InitParm.DATE_FORMAT)) {

            LogInfo.error("Date Format Error");

            return false;

        }

        BuildParm.inputDate = inputDate;


        return true;

    }

}
