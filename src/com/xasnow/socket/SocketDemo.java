package socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author xasnow
 * @Date 2020/4/16
 */
public class SocketDemo {
    public static void main(String[] args) {


        boolean hostConnectable3 = isHostConnectable("localhost", 1521);
        System.out.println(hostConnectable3);

    }

    //判断端口，ip是否可以连接
    public static boolean isHostConnectable(String host, int port) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(host, port), 100);
        } catch (IOException e) {
            System.out.println("P端服务端口访问异常，host为：" + host + "， port为: " + port);
            return false;
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
