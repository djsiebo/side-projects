package com.techelevator.application;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger implements Closeable {

    private File logFile;
    private PrintWriter writer;

    public Logger (String pathName) {
        this.logFile = new File (pathName);
        if (!logFile.exists()) {
            try {
                this.writer = new PrintWriter(this.logFile);
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void write(String logMessage) {
        this.writer.println(logMessage);
    }

    public String getDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }
    @Override
    public void close() throws IOException {
        this.writer.close();
    }
}
