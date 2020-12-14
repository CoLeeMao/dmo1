package nettest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动，等待连接");
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket accept = serverSocket.accept();
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("松果弹抖闪电鞭".getBytes());
        outputStream.close();
        serverSocket.close();
    }
}
