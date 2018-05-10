
import sendMail.RunSendMail;
import splitFiles.RunSplitFile;
import utils.internal.LogInfo;

/**
 *
 * Created by jlgaoyuan on 2018/5/7.
 *
 */
public class Main {

    public static void main( String [] args){

       // String runParm = args[0];

        String runParm = "mail";

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

    }

}
