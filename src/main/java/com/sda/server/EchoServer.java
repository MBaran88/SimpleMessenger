package com.sda.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EchoServer {

    public static void main(String[] args) throws Exception {

        Executor pool = Executors.newCachedThreadPool();
        int port = 4444;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Started server on port " + port);

        while (true) {

            System.out.println("Waiting for client...");
            Socket clientSocket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(clientSocket);

            // Thread thread = new Thread(clientHandler);
            // thread.start();

            pool.execute(clientHandler);
        }
    }
}
