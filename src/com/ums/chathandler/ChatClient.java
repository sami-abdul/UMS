package com.ums.chathandler;

import java.io.*;

public abstract class ChatClient extends Connection {

    public ChatClient(int port) throws IOException {
        super(port);
    }

    @Override
    public void close() throws IOException {
        sock.close();
    }
}


