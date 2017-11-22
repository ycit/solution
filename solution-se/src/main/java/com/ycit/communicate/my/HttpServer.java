package com.ycit.communicate.my;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟服务器处理请求
 *
 * @author xlch
 * @create 2017-09-25 11:01
 */
public class HttpServer {

    private static final String SHUTDOWN_COMMAND = "shutdown";

    public static void main(String[] args){
        boolean shutdown = false;
        try(ServerSocket server = new ServerSocket(8080);

        ) {
            while (!shutdown) {
                Socket socket = server.accept();
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                MyRequest request = new MyRequest(in);
                request.parse();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
