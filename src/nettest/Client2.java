package nettest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端 发送数据");
        Socket localhost = new Socket("localhost", 7777);
        InputStream inputStream = localhost.getInputStream();
        int len;
        byte[] bytes = new byte[1024];
        while ((len= inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        inputStream.close();
        localhost.close();
    }
}
