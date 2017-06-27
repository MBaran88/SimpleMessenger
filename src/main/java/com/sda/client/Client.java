package com.sda.client;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {

        ClientTask clientTask = new ClientTask();

        Thread first = new Thread(clientTask, "John");
        Thread second = new Thread(clientTask, "Mark");
        Thread third = new Thread(clientTask, "Kate");
        Thread fourth = new Thread(clientTask);

        first.start();
        second.start();
        third.start();
        fourth.start();
    }
}
