package main;


import main.Check.Check;


import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * Created by jlgaoyuan on 2018/5/4.
 *
 */
public class Run {

    public static void run(){

        Scanner input = new Scanner(System.in);
        System.out.println("输入日期............(日期格式:YYYY-MM)");
        Init.inputDate = input.nextLine().trim();

        Check.run(); //检查

        Load.run();//加载文件

        Map<String,List<String>> map =  SplitInfo.run();//拆分文件

        WrMap.run(map);

    }



}
