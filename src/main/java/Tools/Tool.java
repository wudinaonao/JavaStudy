package Tools;

/**
 * @program: study
 * @description: 常用工具
 * @author: Wen lyuzhao
 * @create: 2019-01-22 20:58
 **/


import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Tool {

    public static String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36";

    // 读, 写, 追加文件, 文本模式
    public static String readFileText(String filePath){
        // List<String> lineList = new ArrayList<String>();
        StringBuilder content = new StringBuilder("");
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            // 判断文件是否存在
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    // list.add(lineTxt);
                    content.append(lineTxt+"\n");
                }
                bufferedReader.close();
                read.close();
            }
            else {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return content.toString().substring(0, content.toString().length()-1);
    }
    public static boolean appendFileText(String filePath, String text){

        FileWriter fileWriter = null;

        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            File file = new File(filePath);
            fileWriter = new FileWriter(file, true);
        }
        catch (IOException e) {
            return false;
        }
        PrintWriter PrintWriter = new PrintWriter(fileWriter);
        PrintWriter.println(text);
        PrintWriter.flush();

        try {
            PrintWriter.flush();
            PrintWriter.close();
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    public static boolean writeFileText(String filePath, String text) {
        try {
            //使用这个构造函数时，如果存在kuka.txt文件，
            //则先把这个文件给删除掉，然后创建新的kuka.txt
            // FileWriter writer = new FileWriter(filePath);
            // writer.write(text);
            // writer.close();
            File file = new File(filePath);
            file.delete();
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            writer.write(text);
            writer.close();
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }

}

