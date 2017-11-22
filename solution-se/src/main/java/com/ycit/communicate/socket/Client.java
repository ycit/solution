package com.ycit.communicate.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * socket 客户端
 *
 * @author xlch
 * @create 2017-09-07 9:35
 */
public class Client {

    public static void main(String[] args) throws IOException {
        try(Socket clientSocket = new Socket("127.0.0.1", 38);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println("client write to " + userInput);
                System.out.println("client echo :" + in.readLine());
                if ("bye".equals(userInput)) {
                    System.exit(1);
                }
            }
        }
    }
}
