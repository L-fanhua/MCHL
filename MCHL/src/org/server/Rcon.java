package src.org.server;

import src.org.modle.Log;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

public class Rcon {

    private static Log log = new Log("rcon");
    

    public Rcon(String RCON_IP,String RCON_PSD,int RCON_PORT) {
        try {
            log.debug("Rcon Auth");
            Socket socket = new Socket(RCON_IP, RCON_PORT);
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            // 发送RCON认证数据包
            out.write(encoder(RCON_PSD,3));
            byte[] lengthBytes = new byte[4];
            // 读取返回数据
            in.read(lengthBytes);
            System.out.println(lengthBytes);
            //发送指令
            //out.write(encoder("difficult",2));
            //读取服务器返回数据
            //in.read(lengthBytes);
            //System.out.println(lengthBytes);
            //断开连接
            log.debug("Rcon stop");
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //encodern是对指令进行编译的模块
    private byte[] encoder(String command,int commandtype) {
        // RCON命令数据包格式：4字节长度 + 4字节请求ID + 4字节类型 + 命令 + 2字节结束符
        byte[] commandPacket = (command + "\0").getBytes();
        int packetLength = 4 + 4 + 4 + commandPacket.length ;//计算长度
        System.out.println(packetLength);
        ByteBuffer buffer = ByteBuffer.allocate(packetLength);;
        buffer.putInt(6);//输入长度
        buffer.putInt(0);//请求ID
        buffer.putInt(commandtype);//指令类型
        buffer.put(commandPacket);//指控内容
        System.out.println(buffer.array());
        return buffer.array();
    }


}