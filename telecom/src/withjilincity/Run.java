package withjilincity;

import withjilincity.sendMail.RunSendMail;
import withjilincity.splitFiles.RunSplitFile;
import utils.base.LogInfo;
import java.util.Scanner;

/**
 *
 * Created by jlgaoyuan on 2018/5/7.
 *
 */
public class Run {

    public static void main( String [] args){

        String runParm = args[0];

     //   String runParm = "split";

        switch (runParm) {

            case "split":

                RunSplitFile.run();

                break;

            case "mail":

                RunSendMail.run();

                break;

            default:

                LogInfo.info("runParm Error");

                break;

        }


        Scanner input = new Scanner(System.in);
        LogInfo.info("Press Any Key Exit");
        String end = input.nextLine().trim();
        if(end.length()>0){
            System.exit(0);
        }





    }

}
