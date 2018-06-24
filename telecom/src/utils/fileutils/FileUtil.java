package utils.fileutils;


import utils.internal.LogInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    /**
     * 判断路径是否为一个文件
     *
     * @param filePath 文件路径
     * @return boolean
     */
    public static boolean isFile(String filePath) {
        File path = new File(filePath);
        return path.exists() && path.isFile();
    }


    /**
     * 判断路径是否为一个目录
     * @param dirPath 目录路径
     * @return boolean
     */
    public static boolean isDir(String dirPath) {
        File path = new File(dirPath);
        return path.exists() && path.isDirectory();
    }

    /**
     * 创建目录
     * @param path 路径
     */
    public static boolean createDir(String path) {
        LogInfo.info("Create Dir:" + path);
        boolean createDir = false ;
        File file = new File(path);
        if (!file.exists()) {
            createDir = file.mkdir();
            LogInfo.info("Create Succeed:" + path);
        } else {
            LogInfo.info("Dir Is Exists:" + path);
        }
        return createDir;
    }

    /**
     * 删除目录
     *
     * @param path 路径
     */
    public static boolean delDir(String path) {
        LogInfo.info("Dir Path : " + path);
        File file = new File(path);
        boolean delDir ;
        if (!file.exists()) {//如果目录不存在返回
            LogInfo.info("Dir Not Exists:" + path);
            return true;
        }
        delDir = file.delete();
        LogInfo.info("Dir Delete Succeed" + path);
        return delDir;
    }

    /**
     * 删除目录中的文件
     * @param path 路径
     */
    public static boolean deleteFiles(String path) {
        boolean delFiles = false;
        File files = new File(path);
        if (!files.exists()) {//如果目录不存在返回
            LogInfo.info("Dir Not Exists:" + path);
            return true;
        }
        String[] file = files.list();
        if (file.length == 0) {
            LogInfo.info("dir is null:" + path);
            return true;
        } else {
            for (String aFile : file) {
                String full_filePath = files.getPath() + "/" + aFile;
                File f = new File(full_filePath);
                delFiles = f.delete();
            }
        }
        return delFiles;
    }

    /**
     * @param path       文件路径
     * @param lineNumber 从第几行开始读取
     * @param code       文件编码
     * @return list
     */
    public static List<String> read2List(String path, long lineNumber, String code) {
        List<String> list = new ArrayList<>();//返回结果
        File file = new File(path);
        if (!file.exists()) { //如果文件不存在
            LogInfo.info("File Not Exists:" + path);
            return list;
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), code));
            String line = null;
            int lineCtl = 0; //读取位置控制
            int loadLineCount = 0;//读取行数计数
            // 一次读入一行，直到读入null为文件结束
            while ((line = br.readLine()) != null) {
                lineCtl++;
                if (lineCtl >= lineNumber && (line.trim() != "")) {//如果当前行号大于指定行号
                    loadLineCount++;
                    list.add(line.trim());
                }
            }
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
        return list;
    }


    /**
     * 创建文件
     * @param path Path
     * @return boolean
     */
    public static boolean createFile(String path) {
        LogInfo.linel4();
        LogInfo.info("Create File:" + path);
        boolean newFile  ;
        File file = new File(path);
        if (!file.exists()) {
            try {
                 newFile = file.createNewFile();
            } catch (IOException e) {
                LogInfo.error(e.getMessage());
                return false;
            }
        } else {
            newFile = true;
            LogInfo.info("file exists");
        }
        return newFile;
    }


    /**
     * 删除文件
     * @param path path
     * @return boolean
     */
    public static boolean delFile(String path) {
        LogInfo.linel4();
        LogInfo.info("delete File :" + path);
        File file = new File(path);
        boolean delFile;
        if (file.exists()) {
            try {
               delFile =  file.delete();
            } catch (Exception e) {
                LogInfo.error(e.getMessage());
                return false;
            }
        } else {
            delFile = true;
            LogInfo.info("file not exists");
        }
        return delFile;
    }

    /**
     * 字符串写入文件方法
     *
     * @param str  字符串
     * @param path 文件路径
     * @return boolean
     */
    public static boolean wrStrToFile(String str, String path) {
        LogInfo.linel4();
        boolean wr = false;
        try {
            File file = new File(path);
            if (!file.exists()) {
                wr = file.createNewFile();
            }
            PrintWriter outToFile = new PrintWriter(new BufferedWriter(new FileWriter(file.getPath())));
            outToFile.print(str);
            outToFile.flush();
            outToFile.close();
        } catch (Exception e) {
            LogInfo.error(e.getMessage());
            return false;
        }
        return wr;
    }

    /**
     * @param str  字符串
     * @param path 文件路径
     * @param code 字符编码
     * @return boolean
     */
    public static boolean wrStrToFile(String str, String path, String code) {
        boolean wr = false;
        try {
            File file = new File(path);
            if (!file.exists()) {
                wr = file.createNewFile();
            }
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file), code));
            writer.write(str);
            writer.close();
        } catch (Exception e) {
            LogInfo.error(e.getMessage());
            return false;
        }
        return wr;
    }


    /**
     * 追加写入文件
     *
     * @param path 文件路径
     * @param str  追加字符串
     */
    public static boolean wrStrAddToFile(String str, String path) {
        File file = new File(path);
        boolean wr = false;
        try {
            if (!file.exists()) {//如果文件不存在
              wr =  file.createNewFile() ;
            }
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(path, true);
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            LogInfo.error(e.getMessage());
            return false;
        }
        return wr;
    }

    /**
     * 获取文件名称到List
     *
     * @param path 路径
     * @return L
     */
    public static List<String> getFileNameToList(String path) {
        List<String> list = new ArrayList<>();//返回结果
        File file = new File(path);
        if (!file.exists()) { //如果目录不存在
            LogInfo.info("Dir Not Exists:" + path);
        }
        String filesName[] = file.list();
        for (int i = 0; i < filesName.length; i++) {
            list.add(filesName[i]);
        }
        return list;
    }

    /**
     * 判断文件的编码格式
     *
     * @param filePath filePath
     * @return 文件编码格式
     */
    public static String codeString(String filePath) {
        String code = null;
        File file = new File(filePath);
        if (!file.exists()) {
            return code;
        }
        try {
            BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
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
                    code = "ANSI|ASCII";
                    break;
                default:
                    code = "GBK";
            }
        } catch (Exception e) {
            LogInfo.error(e.getMessage());
        }
        return code;
    }

    /**
     * 读取文件第一行
     *
     * @param path 文件路径
     * @return L
     */
    public static String readFirstLine(String path, String code) {
        String firstLine = "";//返回结果
        File file = new File(path);
        if (!file.exists()) { //如果文件不存在
            return null;
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), code));
            firstLine = br.readLine().trim();
            br.close();
        } catch (IOException e) {
            LogInfo.error(e.getMessage());
        }
        return firstLine;
    }
}
