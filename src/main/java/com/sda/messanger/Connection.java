package com.sda.messanger;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Connection {

    private ReaderTask readerTask;
    private WriterTask writerTask;

    private Executor pool;

    public Connection(Socket socket) throws IOException {
        this.readerTask = new ReaderTask(socket.getInputStream());
        this.writerTask = new WriterTask(socket.getOutputStream());
        pool = Executors.newCachedThreadPool();
    }

    public void start() {
        pool.execute(writerTask);
        pool.execute(readerTask);
    }

}
