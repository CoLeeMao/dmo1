package nettest.pictureupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerP {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动。。。");
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket accept = serverSocket.accept();
            new Thread(()->{
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(accept.getInputStream());
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\1\\"+System.currentTimeMillis() + ".jpg"));

                    int len;
                    byte[] bytes = new byte[1024];
                    while ((len= bufferedInputStream.read(bytes))!=-1){
                        bufferedOutputStream.write(bytes,0,len);
                    }
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
