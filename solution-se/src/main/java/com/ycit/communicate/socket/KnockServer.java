package com.ycit.communicate.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * knock server
 *
 * @author xlch
 * @create 2017-09-14 9:44
 */
public class KnockServer {

    public static void main(String[] args) throws IOException {
        try(ServerSocket knockServer = new ServerSocket(39);
            Socket socket = knockServer.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String input, output;
            KnockProtocol protocol = new KnockProtocol();
            output = protocol.processInput(null);
            out.println(output);
            while ((input = in.readLine()) != null) {
                output = protocol.processInput(input);
                out.println(output);
                if ("bye".equals(output)) {
                    break;
                }
            }
        }
    }

}
