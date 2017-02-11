package com.ums.chathandler;

import java.io.*;

public abstract class ChatServer extends Connection {

    public ChatServer(int port) throws IOException {
        super(port);

        startGUIThread();
    }

    public abstract void startGUIThread();

    @Override
    public void close() throws IOException {
        serverSock.close();
        System.out.println("Server closed.");
    }
}
