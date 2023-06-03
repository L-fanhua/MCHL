package src.org.modle;


/**
 * 
 * @L_fanhua
 * @v0.1.0bate
 */

import src.org.modle.Log;
import src.org.language.Language;

import java.util.Properties;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Settings {
   // 创建 Properties 对象
   private static final Properties config = new Properties();
   private static String Languageinfo = "en-us";
   private static boolean ui = true;
   private static final String time = runtime();
   private static Log log = new Log("settings");
    public static void check() {
       
       File file = new File("config.properties");
       if(file.exists()){
           log.info("Load Settings");
           Load();
       } else {
          log.err("Please set system settings to run!");
           try {
               
               config.setProperty("ui", "false");              
               config.setProperty("language", "en-us");
               
               // 添加注释            
               //config.put("language", "\n# The language used by the application (\"en\" for English, \"es\" for Spanish, etc.)");
               
               OutputStream outputStream = new FileOutputStream("config.properties");
               config.store(outputStream, "System settings file");
               outputStream.write("\n# This is a new comment".getBytes());

            } catch (Exception e) {
               log.info("Settings file generation error!");
               e.printStackTrace();
            
           }
           System.exit(0);
           
       }
       file = null;
    }
    
    private static void Load() {
        try {
            InputStream inputStream = new FileInputStream("config.properties");          
            config.load(inputStream);

            // 获取属性
            Languageinfo = config.getProperty("language");
            ui = transform(config.getProperty("ui"));
            
            log.info("Loaded Language: " + Languageinfo);
            Language.Load();
            log.info("Static time:"+time);
            log.info("GUI:"+config.getProperty("ui"));
            log.info("Settings loaded successfully");
            
        } catch (IOException e) {
            log.err("Failed to load configuration file!");
            e.printStackTrace();
        }
    }
    
    private static String runtime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String runtime = sdf.format(date);
        return runtime;
    }
    
    public static boolean transform(String input) {
        if (input.equals("true")) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String language() {
        return Languageinfo;
    }
    
    public static boolean ui() {
        return ui;
    }
    
    public static String time() {
        return time;
    }
}
