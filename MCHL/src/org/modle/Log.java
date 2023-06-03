package src.org.modle;



/**
 * 
 * @L_fanhua
 * @v1.0.1
 */

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import src.org.modle.Settings;

public class Log {
    String name;
    String infoname;
    String folderPath;
    String filetime;
    private static final String time = Settings.time();    
    private static String Logtime;
    
    public Log(String name) {       
        this(name,"/Log","MCHL");
    }
        
    public Log(String name,String url) {
        this(name,url,"MCHL");
    }
    
    public Log(String name,String url,String infoname) {
        this.name = name;
        this.infoname = infoname;      
        String currentDir = System.getProperty("user.dir"); // 获取当前目录
        folderPath = currentDir + url; // 指定新文件夹的相对路径
        File folder = new File(folderPath); // 创建File对象
        if (!folder.exists()) { // 判断文件夹是否已经存在
            if (!folder.mkdir()) { // 创建文件夹
                
                info("[MCHL] [Log/ERR] Failed to create folder" + url);
            }
        }        
        this.filetime = filetime();
        this.Logtime =time();
    }
     
    public static String time() {       
        String timelog =        time.substring(0, 4) + ":" +
                               time.substring(4, 6) + ":" +
                               time.substring(6, 8) + ":" +
                               time.substring(8,10) + ":" +
                               time.substring(10,12);
        return timelog;        
    }
    
    public String filetime() {       
        String timelog = "[" + infoname + 
                               time.substring(0, 4) + "-" +
                               time.substring(4, 6) + "-" +
                               time.substring(6, 8) + "-" +
                               time.substring(8,10) + "-" +
                               time.substring(10,12) + "] ";
        return timelog;        
    }
    
    public void writelog(String log) {
        try {
            FileWriter fileWriter = new FileWriter(new File(folderPath + "/" + filetime + ".txt"), true);
                       
            fileWriter.write(log + "\n"); // 添加换行符
            fileWriter.close();
            
        } catch (IOException e) {
            info("[MCHL] [Log/ERR] " +"Error writing file:" + e.getMessage());
        }
    }

    
    public void info(String log) {
                
        String tlog = "["+infoname+"] ["+Logtime+"] ["+name+"/info] " + log;
        System.out.println(tlog);
        writelog(tlog);
    }
    
    public void err(String log) {
        
        String tlog = "["+infoname+"] ["+Logtime+"] ["+name+"/ERR] " + log;
        System.out.println(tlog);
        writelog(tlog);
           
            
    }
    
    public void debug(String log) {
        
        String tlog = "["+infoname+"] ["+Logtime+"] ["+name+"/debug] " + log;
        System.out.println(tlog);
        writelog(tlog);
           
            
    }
}
