package utils.fileutils;


import utils.internal.LogInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    /**
     * 判断路径是否为一个文件
     * @param filePath 文件路径
     * @return
     */


    public static boolean isFile(String filePath) {

        File path = new File(filePath);

        return path.exists() && path.isFile();

    }


    /**
     * 判断路径是否为一个目录
     * @param dirPath 目录路径
     * @return
     */

    public static boolean isDir(String dirPath) {

        File path = new File(dirPath);

        return path.exists() && path.isDirectory();

    }


    /**
     * 创建目录
     * @param path 路径
     */

    public static void createDir(String path){

       LogInfo.info("Create Dir:"+path);

        File file =new File(path);

        if(!file.exists()){

            file.mkdir();

            LogInfo.info("Create Succeed:"+path);

        }else {

            LogInfo.info("Dir Is Exists:"+path);

        }

    }

    /**
     * 删除目录
     * @param path 路径
     */

    public static void delDir(String  path){


        LogInfo.info("Dir Path : "+path);

        File file = new File(path);

        if(!file.exists()){//如果目录不存在返回

            LogInfo.info("Dir Not Exists:"+path);

            return ;

        }

        file.delete();

        LogInfo.info("Dir Delete Succeed"+path);

    }

    /**
     * 删除目录中的文件
     * @param path 路径
     */


    public static void  deleteFiles(String path) {

     //   LogInfo.linel4();

       // LogInfo.info("delete Files:" + path);

            File files = new File(path);

            if(!files.exists()){//如果目录不存在返回

                LogInfo.info("Dir Not Exists:"+path);

                return;

            }

            String[] file = files.list();

            if (file.length==0) {

                LogInfo.info("dir is null:"+path);

                return;

            }else {

                for (String aFile : file) {

                    String full_filePath = files.getPath() + "/" + aFile;

                    File f = new File(full_filePath);

                    f.delete();

                }

            }

       // LogInfo.info("delete files succeed:" + path);


        }



    /**
     *
     * @param path 文件路径
     * @param lineNumber 从第几行开始读取
     * @param code 文件编码
     * @return list
     */

    public static  List<String> read2List (String path ,long lineNumber,String code) {

      // LogInfo.linel4();

     //   LogInfo.info("Read File To StringList:" + path);

        List<String> list = new ArrayList<>();//返回结果

        File file = new File(path);

        if (!file.exists()) { //如果文件不存在

           LogInfo.info("File Not Exists:" + path);

            return list;
        }

        BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(new FileInputStream(file),code));

            String line = null;

            int lineCtl = 0; //读取位置控制

            int loadLineCount = 0 ;//读取行数计数

            // 一次读入一行，直到读入null为文件结束

            while ((line = br.readLine()) != null) {

                lineCtl ++;

                if(lineCtl>=lineNumber&&(line.trim()!= "")){//如果当前行号大于指定行号

                    loadLineCount ++;

                    list.add(line.trim());

                }



            }


        //   LogInfo.info("Load :"+loadLineCount+" line");

            br.close();

        } catch (IOException e) {

           LogInfo.error(e.getMessage());


        } finally {

            if (br != null) {

                try {

                    br.close();

                } catch (IOException E) {

                   LogInfo.error(E.getMessage());

                }

            }

        }

    //    LogInfo.linel4();

        return list;

    }




    /**
     * 创建文件
     * @param path Path
     * @return
     */

    public static boolean createFile (String path) {

       LogInfo.linel4();

       LogInfo.info("Create File:" + path);

        File file = new File(path);

        if (!file.exists()) {

            try {

                file.createNewFile();


            } catch (IOException e) {

               LogInfo.error(e.getMessage());

                return false;

            }

        } else {

            LogInfo.info("file exists");

        }

        return true;
    }


    /**
     * 删除文件
     * @param path path
     * @return
     */

    public static boolean delFile (String path) {

       LogInfo.linel4();

       LogInfo.info("delete File :" + path);

        File file = new File(path);

        if (file.exists()) {

            try {

                file.delete();


            } catch (Exception e) {

               LogInfo.error(e.getMessage());

                return false;

            }

        } else {

           LogInfo.info("file exists");

           return true;

        }

   //    LogInfo.info("delete file succeed:" + path);

        return true;
    }

    /**
     * 字符串写入文件方法
     * @param str  字符串
     * @param path  文件路径
     * @return
     */



    public static  boolean wrStrToFile(String str, String path) {

       LogInfo.linel4();

     //  LogInfo.info("Write To File:" + path);

        try {

            File file = new File(path);
            
            if (!file.exists()) {

                file.createNewFile();

          //      LogInfo.info("Create File");

            }

            PrintWriter outToFile = new PrintWriter(new BufferedWriter(new FileWriter(file.getPath())));

            outToFile.print(str);

            outToFile.flush();

         //   LogInfo.info("Write To File Succeed");

            outToFile.close();

        } catch (Exception e) {

           LogInfo.error(e.getMessage());

            return false;

        }

        return true;

    }

    /**
     *
     * @param str 字符串
     * @param path 文件路径
     * @param code 字符编码
     * @return
     */


    public static  boolean wrStrToFile(String str, String path,String code) {

     //   LogInfo.linel4();

     //   LogInfo.info("Write To File:" + path);

        try {

            File file = new File(path);

            if (!file.exists()) {

                file.createNewFile();

           //     LogInfo.info("Create File");

            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), code));
            writer.write(str);
            writer.close();
        //    LogInfo.info("Write To File Succeed");

        } catch (Exception e) {

            LogInfo.error(e.getMessage());

            return false;

        }

        return true;

    }



    /**
     * 追加写入文件
     * @param path 文件路径
     * @param str 追加字符串
     */

    public  static  boolean wrStrAddToFile(String str,String path ) {

        File file = new File(path);

        try  {

            if (!file.exists()) {//如果文件不存在

                file.createNewFile();

           //     LogInfo.info("Create File :" + path);

            }

            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new  FileWriter(path,  true );

            writer.write(str);

           // LogInfo.info("Write To File :" + path);

            writer.close();

        } catch  (IOException e) {

            LogInfo.error(e.getMessage());

            return false;

        }

        return true;

      

    }






    /**
     * 获取文件名称到List
     * @param path 路径
     * @return L
     */


    public static List<String> getFileNameToList(String path){

      //  LogInfo.linel4();

      //  LogInfo.info("读取目录中文件:" + path);

        List<String> list = new ArrayList<>();//返回结果

        File file = new File(path);

        if (!file.exists()) { //如果目录不存在

            LogInfo.info("Dir Not Exists:" + path);

        }


        String filesName [] = file.list();

      //  LogInfo.info("Files Count : " + filesName.length);

        for(int i = 0 ; i < filesName.length;i++){

            list.add(filesName[i]);

        }

        return list;


    }
    /**
     * 判断文件的编码格式
     * @param filePath filePath
     * @return 文件编码格式
     */
    public static String codeString(String filePath){

        String code = null;

        File file = new File(filePath);

        if(!file.exists()){

          //  LogInfo.info("file not exists "+file.getAbsolutePath());

            return code;

        }

        try{

            BufferedInputStream bin = new BufferedInputStream( new FileInputStream(file));
            int p = (bin.read() << 8) + bin.read();

            //其中的 0xefbb、0xfffe、0xfeff、0x5c75这些都是这个文件的前面两个字节的16进制数
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                case 0x5c75:
                    code = "ANSI|ASCII" ;
                    break ;
                default:
                    code = "GBK";
            }





        }catch (Exception e){

            LogInfo.error(e.getMessage());

        }


        return code;

    }

    /**
     * 读取文件第一行
     * @param path 文件路径
     * @return L
     */


    public static String readFirstLine (String path,String code) {

      //  LogInfo.linel4();

     //   LogInfo.info("Read File First Line :" + path);

        String firstLine = "" ;//返回结果

        File file = new File(path);

        if (!file.exists()) { //如果文件不存在

       //     LogInfo.info("File Not Exist:" + path);

            return null;
        }

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),code));

            firstLine = br.readLine().trim();

         //   LogInfo.info("Load First Line");

            br.close();

        } catch (IOException e) {

            LogInfo.error(e.getMessage());

        }

        //LogInfo.linel4();

        return firstLine;

    }

}
