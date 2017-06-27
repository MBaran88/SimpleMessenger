package com.sda.server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);


            String line = reader.readLine();
            System.out.println("client from ["+socket.getInetAddress()+"]");
            System.out.println("Received: " + line);
            printWriter.println("Response from server: " + line);

            printWriter.close();
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
    }
}
