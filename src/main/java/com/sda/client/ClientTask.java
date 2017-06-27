package com.sda.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientTask implements Runnable {


    @Override
    public void run() {

        try {
            String host = "127.0.0.1";
            int port = 4444;

            Socket socket = new Socket(host, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            printWriter.println("Hello from client!");

            String response = reader.readLine();
            String name = Thread.currentThread().getName();
            System.out.printf("%s ,response: %s\n", name, response);

            printWriter.close();
            reader.close();

        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }

}
