package nettest;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetTest {
    @Test
    public void test1() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
//        byte[] address = localHost.getAddress();
//        for (byte b : address) {
//            System.out.println(b);
//        }
        String hostAddress1 = localHost.getHostAddress();
        String hostAddress2 = localHost.getHostName();
        System.out.println(hostAddress1);
        System.out.println(hostAddress2);
        System.out.println(localHost);
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
        String hostName = byName.getHostName();
        String hostAddress = byName.getHostAddress();
        System.out.println(hostName);
        System.out.println(hostAddress);
    }

    @Test
    public void test2() throws UnknownHostException {

    }
}
