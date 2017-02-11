package com.ums.entities;

import java.io.IOException;

public abstract class AccountHolder {

    public Position position;
    protected String id, name, password;
    private int port;

    public AccountHolder() {
        this.id = null;
        this.name = null;
        this.password = null;
        this.position = null;
        this.port = 0;
    }

    public AccountHolder(String id, String name, String password, Position position, int port) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.position = position;
        this.port = port;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public abstract boolean login(String id, String password);

    public abstract void changePassword(String pass) throws IOException;

    public abstract void startServer(int port);

    public abstract void communicate(int port);

    public enum Position {VICE_CHANCELLOR, DEAN, TEACHER, STUDENT, CHIEF_LIBRARIAN}
}