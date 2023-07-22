package src.org.main;

/**
 * 在这里给出对类 Main 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
import src.org.modle.Log;
import src.org.modle.Settings;
import src.org.modle.motd;
import src.org.server.Rcon;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
public class Main {
   
    public static void main(String[] args) throws IOException{
        Settings.check();
        Log log = new Log("Main");
        motd.run();
        int PORT = 1028;
        if(args.length > 0 && args[0] != null && !args[0].isEmpty()) {
            PORT = Integer.parseInt(args[0]);
            //命令端口号指定
        }
        
        //ServerSocket serverSocket = new ServerSocket(PORT);
        log.debug("rcon start");
        Rcon rcon = new Rcon("223.154.9.25", "123456", 25575);
        
    }
}
