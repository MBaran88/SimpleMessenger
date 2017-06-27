package com.sda.messanger;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriterTask implements Runnable {

    private final PrintWriter printWriter;
    private final Scanner scanner;

    public WriterTask(final OutputStream outputStream) {
        this.printWriter = new PrintWriter(outputStream, true);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            String line = scanner.nextLine();
            printWriter.println(line);
        }
    }
}
