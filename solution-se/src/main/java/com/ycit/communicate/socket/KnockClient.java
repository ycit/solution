package com.ycit.communicate.socket;

import java.io.*;
import java.net.Socket;

/**
 * knock
 *
 * @author xlch
 * @create 2017-09-14 9:43
 */
public class KnockClient {

    public static void main(String[] args) throws IOException {
        try(Socket knockClient = new Socket("127.0.0.1", 39);
            PrintWriter out = new PrintWriter(knockClient.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(knockClient.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String fromUser = null;
            String fromServer = null;
            while ((fromServer = in.readLine()) != null) {
                System.out.println("server :" + fromServer);
                if ("bye".equals(fromServer)) {
                    break;
                }
                if ((fromUser = stdIn.readLine()) != null) {
                    System.out.println("client : " + fromUser);
                    out.println(fromUser);
                }
            }
        }
    }

}
