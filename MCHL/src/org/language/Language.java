package src.org.language;


/**
 * 在这里给出对类 language 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */

import src.org.modle.Settings;
import src.org.modle.Log;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class Language {
    private static ResourceBundle bundle;
    private static Log log = new Log("Language");
    public static void Load() {
        String language = Settings.language();
       
        Locale locale = new Locale(language.substring(0, 2), language.substring(3,5)); 
        
        bundle = ResourceBundle.getBundle("messages", locale); // 加载资源包文件
        
        log.info(info("languageinfo") + info("language"));
    }
    public static String info(String Info) {
        //return "fixbug";
         return bundle.getString(Info); // 获取对应键值的字符串;
       
        //try {
         //    return bundle.getString(Info); // 获取对应键值的字符串;
        //} catch(MissingResourceException e) {
          //   return "noinfo";

        //}
    }
}