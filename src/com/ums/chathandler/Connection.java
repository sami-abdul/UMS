package com.ums.chathandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class Connection {

    public boolean isConnected = false;

    public String serverIP = "127.0.0.1";
    public int port;

    protected ServerSocket serverSock;
    protected Socket sock;

    protected OutputStream oStream;
    public PrintWriter writer;
    protected InputStream iStream;
    protected BufferedReader reader;

    protected String send, receive;
    protected String receiver, sender;

    public Connection(int port) throws IOException {
        this.port = port;

        if (this instanceof ChatServer) {
            this.serverSock = new ServerSocket(port);

            System.out.println("Server ready. Waiting for Client on port " + port);
            this.sock = serverSock.accept();
        }

        else {
            this.sock = new Socket(this.serverIP, this.port);
            System.out.println("Waiting for Server on port " + port);
        }

        isConnected = true;

        this.oStream = sock.getOutputStream();
        this.writer = new PrintWriter(oStream, true);
        this.iStream = sock.getInputStream();
        this.reader = new BufferedReader(new InputStreamReader(iStream));
    }

    public void setStatus(boolean isConnected) {
        this.isConnected = isConnected;
    }
    public boolean getStatus() {
        return isConnected;
    }
    public void setPort(int port) {
        this.port = port;
    }
    public int getPort() {
        return port;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getSender() {
        return sender;
    }

    public abstract void chat() throws IOException;

    public abstract void startReadThread();

    public abstract void startWriteThread();

    public abstract void close() throws IOException;
}
