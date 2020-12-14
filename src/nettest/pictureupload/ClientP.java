package nettest.pictureupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientP {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端 启动。。。");
        Socket localhost = new Socket("localhost", 8888);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\1\\1_copy.jpg"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(localhost.getOutputStream());

        int len;
        byte[] bytes = new byte[1024];
        while ((len= bufferedInputStream.read(bytes))!=-1){
            bufferedOutputStream.write(bytes,0,len);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
        localhost.close();
    }
}
