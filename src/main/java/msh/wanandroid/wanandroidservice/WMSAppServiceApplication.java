package msh.wanandroid.wanandroidservice;

import msh.wanandroid.wanandroidservice.websocket.LogSocketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
@SpringBootApplication
public class WMSAppServiceApplication {

    private static int PORT = 2017;

    public static void main(String[] args) {

        SpringApplication.run(WMSAppServiceApplication.class, args);
        LogSocketService socketServer = new LogSocketService(PORT);
        socketServer.start();
        try {
            String ip = InetAddress.getLocalHost().getHostAddress();
            int port = socketServer.getPort();
            System.out.println(String.format("服务已启动: %s:%d", ip, port));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        while (true) {
            try {
                String msg = reader.readLine();
                socketServer.sendToAll(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
