package main.splitFiles;

import main.parm.BuildParm;
import main.parm.InitParm;
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

        LogInfo.info("输入日期............(日期格式:YYYY-MM)");

        String inputDate = input.nextLine().trim();

        if (inputDate.length() != 7) {

            LogInfo.error("输入时间格式错误");

            return false;

        } else if (!DTUtils.dateFormatCheak(inputDate, InitParm.DATE_FORMAT)) {

            LogInfo.error("输入时间格式错误");

            return false;

        }

        BuildParm.inputDate = inputDate;


        return true;

    }

}
