package utils.fileutils;


import utils.internal.LogInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

   

    public static boolean checkFileExists(String filePath){

        File file = new File(filePath);

        if(file.exists()){

            return true;

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
     * 读取文件每行至List
     * @param path 文件路径
     * @return L
     */


    public List<String> read2List (String path) {

       LogInfo.linel4();

       LogInfo.info("读取文件:" + path);

        List<String> list = new ArrayList<>();//返回结果

        File file = new File(path);

        if (!file.exists()) { //如果文件不存在

           LogInfo.info("文件不存在:" + path);

            return list;
        }

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(file));

            String line = null;

            int lineCount = 1;

            // 一次读入一行，直到读入null为文件结束

            while ((line = reader.readLine()) != null) {

                list.add(line);

                lineCount++;

            }

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

        return list;

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



    public static  boolean writeToFile(String str, String path) {

       LogInfo.linel4();

       LogInfo.info("写入文件:" + path);

        try {

            File file = new File(path);
            
            if (!file.exists()) {

                file.createNewFile();

                LogInfo.info("新建文件 :" + path);

            }

            PrintWriter outToFile = new PrintWriter(new BufferedWriter(
                    new FileWriter(file.getPath())));

            outToFile.print(str);

            outToFile.flush();

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

    public  static  boolean strAddToFile(String str,String path ) {

        File file = new File(path);

        try  {

            if (!file.exists()) {

                file.createNewFile();

                LogInfo.info("新建文件 :" + path);

            }

            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new  FileWriter(path,  true );

            writer.write(str);

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

        if (!file.exists()) { //如果文件不存在

            LogInfo.info("目录不存在:" + path);

            return null;
        }


        String filesName [] = file.list();

        LogInfo.info("目录中文件数量 : " + path);

        for(int i = 0 ; i < filesName.length;i++){

            list.add(filesName[i]);

        }

        return list;


    }

    /**
     * 文件名到List
     * @param FilesPath
     * @return
     */

    public static List<String> fileLineToList(String FilesPath) {

        List<String> filesList = new ArrayList<String>();

        File filesNameStr = new File(FilesPath); // 文件所在目录

        String[] files = filesNameStr.list();// 文件

        for (int i = 0; i < files.length; i++) {// 循环读取每个文件

            filesList.add(files[i]);

        }

        System.out.println("--Fiies To List Complate ,Files Path : "
                + FilesPath);

        return filesList;

    }

}
