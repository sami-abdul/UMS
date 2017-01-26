package com.ums.chathandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

    public static int port;
    private ServerSocket serverSock;
    private Socket sock;
    private OutputStream oStream;
    private PrintWriter writer;
    private InputStream iStream;
    private BufferedReader reader;

    public ChatServer(int port) throws IOException {
        this.port = port;
        this.serverSock = new ServerSocket(port);
        System.out.println("Server ready. Waiting for Client on port " + port);
        this.sock = serverSock.accept();
        this.oStream = sock.getOutputStream();
        this.writer = new PrintWriter(oStream, true);
        this.iStream = sock.getInputStream();
        this.reader = new BufferedReader(new InputStreamReader(iStream));
        System.out.println("Connection established");

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
        serverSock.close();
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
