package utils.fileutils;


import utils.internal.LogInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static boolean checkPath(String pathStr){

        File path = new File(pathStr);

        if(path.exists()){

           return true;

        }

        else return false;

    }

    public static boolean isFile(String pathStr){

        File path = new File(pathStr);

        if(path.exists()){

            if(path.isFile()){

                return true;

            }

            else return false;

        }

        else return false;

    }


    public static boolean isDir(String pathStr){

        File path = new File(pathStr);

        if(path.exists()){

            if(path.isDirectory()){

                return true;

            }

            else return false;


        }

        else return false;

    }


    /**
     * 创建目录
     * @param path 路径
     */

    public static void createDir(String path){

       LogInfo.info("开始创建目录:"+path);

        File file =new File(path);

        if(!file.exists()){

            file.mkdir();

            LogInfo.info("创建目录:"+path);

        }else {

            LogInfo.info("目录已经存在:"+path);

        }

    }

    /**
     * 删除目录
     * @param path 路径
     */

    public static void delDir(String  path){


        LogInfo.info("开始删除目录"+path);

        File file = new File(path);

        if(!file.exists()){//如果目录不存在返回

            LogInfo.info("目录不存在:"+path);

            return;

        }

        file.delete();

        LogInfo.info("删除目录完成"+path);

    }

    /**
     * 删除目录中的文件
     * @param path 路径
     * @return
     */


    public static void  deleteFiles(String path) {

        LogInfo.linel4();

        LogInfo.info("删除目录中的文件:" + path);

            File files = new File(path);

            if(!files.exists()){//如果目录不存在返回

                LogInfo.info("目录不存在:"+path);

                return;

            }

            String[] file = files.list();

            if (file.length==0) {

                LogInfo.info("目录中文件为空:"+path);

                return;

            }else {

                for (int i = 0; i < file.length; i++) {

                    String full_filePath = files.getPath() + "/" + file[i];

                    File f = new File(full_filePath);

                    f.delete();

                }

            }

        LogInfo.info("删除目录的文件完成:" + path);


        }


    /**
     * 读取文件每行至 List
     * @param path 文件路径
     * @param lineNumber  从第几行开始读取 包括指定行号
     * @return
     */

    public static  List<String> read2List (String path ,long lineNumber) {

       LogInfo.linel4();

        LogInfo.info("Read File To StringList:" + path);

        List<String> list = new ArrayList<>();//返回结果

        File file = new File(path);

        if (!file.exists()) { //如果文件不存在

           LogInfo.info("File Not Exists:" + path);

            return list;
        }

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(file));

            String line = null;

            int lineCtl = 0; //读取位置控制

            int loadLineCount = 0 ;//读取行数计数

            // 一次读入一行，直到读入null为文件结束

            while ((line = reader.readLine()) != null) {

                lineCtl ++;

                if(lineCtl>=lineNumber&&(line.trim()!= "")){//如果当前行号大于指定行号

                    loadLineCount ++;

                    list.add(line.trim());

                }



            }


           LogInfo.info("Load :"+loadLineCount+" line");

            reader.close();

        } catch (IOException e) {

           LogInfo.error(e.getMessage());


        } finally {

            if (reader != null) {

                try {

                    reader.close();

                } catch (IOException E) {

                   LogInfo.error(E.getMessage());

                }

            }

        }

        LogInfo.linel4();

        return list;

    }

    /**
     * 读取文件第一行
     * @param path 文件路径
     * @return L
     */


    public static String readFirstLine (String path) {

        LogInfo.linel4();

        LogInfo.info("Read File First Line :" + path);

        String firstLine = "" ;//返回结果

        File file = new File(path);

        if (!file.exists()) { //如果文件不存在

            LogInfo.info("File Not Exist:" + path);

            return null;
        }

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            firstLine = reader.readLine().trim();

            LogInfo.info("Load First Line");

            reader.close();

        } catch (IOException e) {

            LogInfo.error(e.getMessage());

        }

        LogInfo.linel4();

        return firstLine;

    }




    /**
     * 创建文件
     * @param path
     * @return
     */

    public static boolean createFile (String path) {

       LogInfo.linel4();

       LogInfo.info("创建文件:" + path);

        File file = new File(path);

        if (!file.exists()) {

            try {

                file.createNewFile();


            } catch (IOException e) {

               LogInfo.error(e.getMessage());

                return false;

            }

        } else {

           LogInfo.info("文件已经存在");

        }

        return true;
    }


    /**
     * 删除文件
     * @param path
     * @return
     */

    public static boolean delFile (String path) {

       LogInfo.linel4();

       LogInfo.info("删除文件:" + path);

        File file = new File(path);

        if (file.exists()) {

            try {

                file.delete();


            } catch (Exception e) {

               LogInfo.error(e.getMessage());

                return false;

            }

        } else {

           LogInfo.info("文件不存在");

           return true;

        }

       LogInfo.info("删除文件完成:" + path);

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

       LogInfo.info("Write To File:" + path);

        try {

            File file = new File(path);
            
            if (!file.exists()) {

                file.createNewFile();

                LogInfo.info("Create File");

            }

            PrintWriter outToFile = new PrintWriter(new BufferedWriter(
                    new FileWriter(file.getPath())));

            outToFile.print(str);

            outToFile.flush();

            LogInfo.info("Write To File");

            outToFile.close();

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

                LogInfo.info("Create File :" + path);

            }

            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new  FileWriter(path,  true );

            writer.write(str);

            LogInfo.info("Write To File :" + path);

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

        LogInfo.linel4();

        LogInfo.info("读取目录中文件:" + path);

        List<String> list = new ArrayList<>();//返回结果

        File file = new File(path);

        if (!file.exists()) { //如果目录不存在

            LogInfo.info("目录不存在:" + path);

        }


        String filesName [] = file.list();

        LogInfo.info("目录中文件数量 : " + path);

        for(int i = 0 ; i < filesName.length;i++){

            list.add(filesName[i]);

        }

        return list;


    }



}
