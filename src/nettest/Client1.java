package nettest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端 发送数据");
        Socket localhost = new Socket("localhost", 7777);
        OutputStream outputStream = localhost.getOutputStream();
        outputStream.write("客户端发送的数据".getBytes());
        outputStream.close();
        outputStream.close();
    }
}
