package com.ycit.communicate.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 * @author xlch
 * @create 2017-09-11 9:42
 */
public class Server {

    public static void main(String[] args)throws IOException {
        try(ServerSocket serverSocket = new ServerSocket(38);
            Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("server write to " + inputLine);
                System.out.println("server echo :" + inputLine);
                if ("bye".equals(inputLine)) {
                    System.exit(1);
                }
            }
        }
    }
}
