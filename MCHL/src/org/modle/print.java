package src.org.modle;


/**
 * 在这里给出对类 print 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import src.org.modle.Settings;
import src.org.modle.Log;
public class print {
    private static Log log = new Log("ui");
    static {
        ui = Settings.ui();
        log.info("[ui.print/info] Load");
    }
    
    public static boolean ui;
    
    public static void print(String input) {
        log.info(input);
    }
}
