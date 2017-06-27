package com.sda.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        Task task = new Task();


        Executor executor  = Executors.newCachedThreadPool();

        executor.execute(task);
        executor.execute(task);
    }
}
