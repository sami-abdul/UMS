package com.ums.chathandler;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.out;

public class ChatClient {

    public String serverIP = "127.0.0.1";
    public int port;

    private Socket sock;
    private OutputStream oStream;
    private PrintWriter writer;
    private InputStream iStream;
    private BufferedReader reader;

    public ChatClient(int port) throws IOException {
        this.port = port;
        out.println("Waiting for Server on port " + port);
        this.sock = new Socket(this.serverIP, this.port);
        this.oStream = sock.getOutputStream();
        this.writer = new PrintWriter(oStream, true);
        this.iStream = sock.getInputStream();
        this.reader = new BufferedReader(new InputStreamReader(iStream));

        chat();
    }

    public void chat() throws IOException {
        System.out.println("Start chatting.");
        ReadHandler readHandler = new ReadHandler();
        WriteHandler writeHandler = new WriteHandler();
        readHandler.start();
        writeHandler.start();
    }

    public void close() throws IOException {
        sock.close();
    }

    private class ReadHandler extends Thread {
        @Override
        public void run() {
            String receive;
            while (true) {
                try {
                    if ((receive = reader.readLine()) != null)
                        System.out.println(receive);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class WriteHandler extends Thread {
        @Override
        public void run() {
            Scanner sc = new Scanner(System.in);
            String send;
            while (true) {
                send = sc.nextLine();
                writer.println(send);
                writer.flush();
            }
        }
    }
}


