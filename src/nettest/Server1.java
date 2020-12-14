package nettest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动，等待连接");
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        inputStream.close();
        serverSocket.close();
    }
}
