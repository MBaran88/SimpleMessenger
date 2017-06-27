package com.sda.messanger.client;

import java.io.IOException;
import java.net.Socket;

import com.sda.messanger.Connection;

public class Client {

    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 4444;

        Socket socket = new Socket(host, port);

        Connection connection = new Connection(socket);
        connection.start();
    }
}
