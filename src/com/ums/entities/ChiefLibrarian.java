package com.ums.entities;

import com.ums.buildings.AdminBlock;
import com.ums.buildings.Library;
import com.ums.chathandler.ChatClient;
import com.ums.chathandler.ChatServer;
import com.ums.driver.LibrarianStageController;
import com.ums.driver.VCStageController;
import javafx.application.Platform;

import java.io.IOException;
import java.util.Scanner;

public class ChiefLibrarian extends Employee {

    public Server server;
    public Client client;

    public ChiefLibrarian(String id, String name, String qualification, String department, String password, int salary,
                          int attendance, int port) {
        super(id, name, qualification, department, password, salary, attendance, Position.CHIEF_LIBRARIAN, port);
    }

    public void setTimeToDefault() {
        Library.time = Library.DEFAULT_TIME;
    }

    public void setTimeTo(String time) {
        Library.time = time;
    }

    public void hireNewLibrarians(int n) {
        Library.numOfLibrarians += n;
    }

    public void fireLibrarians(int n) {
        Library.numOfLibrarians -= n;
    }

    public void inreaseBooks(int n) {
        Library.numOfBooks += n;
    }

    public void decreaseBooks(int n) {
        Library.numOfBooks -= n;
    }

    public void organizeBookFair(int year, int month, int date, int hour, int minutes) {
        Library.setEvent("Book Fair", year, month, date, hour, minutes);
    }

    @Override
    public boolean login(String id, String password) {
        if (this.getID().equalsIgnoreCase(id) && this.getPassword().equals(password))
            return true;
        return false;
    }

    @Override
    public void changePassword(String pass) throws IOException {
        Library.chiefLibrarian.setPassword(pass);
        AdminBlock.updateLB();
    }

    @Override
    public void startServer(int port) {
        Thread thread = new Thread(() -> {
            try {
                server = new Server(port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    @Override
    public void communicate(int port) {
        Thread thread = new Thread(() -> {
            try {
                client = new Client(port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }

    public class Server extends ChatServer {

        public Server(int port) throws IOException {
            super(port);
            setStatus(true);
            chat();
        }

        @Override
        public void startGUIThread() {
            Platform.runLater(() -> LibrarianStageController.startServerMessageGUI());
        }

        @Override
        public void chat() throws IOException {
            setSender(Library.chiefLibrarian.getName());

            startReadThread();
            startWriteThread();
        }

        @Override
        public void startReadThread() {
            Thread thread = new Thread(() -> {
                try {
                    receive = reader.readLine();
                    System.out.println(receive);
                    receiver = receive.substring(28);
                    System.out.println("Start chatting.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (true) {
                    try {
                        if ((receive = reader.readLine()) != null) {
                            System.out.println(receive);
                            LibrarianStageController.messageArea.appendText(receiver + ": " + receive + "\n");
                        }
                    } catch (IOException e) {
                        System.out.println("Connection closed.");
                        isConnected = false;
                        break;
                    }
                }
            });

            thread.start();
        }

        @Override
        public void startWriteThread() {
            Thread thread = new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                while (true) {
                    send = sc.nextLine();
                    writer.println(send);
                    LibrarianStageController.messageArea.appendText(sender + ": " + send + "\n");
                    writer.flush();
                }
            });

            thread.start();
        }
    }

    public class Client extends ChatClient {

        public Client(int port) throws IOException {
            super(port);
            setStatus(true);
            chat();
        }

        @Override
        public void chat() {
            receiver = AdminBlock.viceChancellor.getName();

            sender = Library.chiefLibrarian.getName();

            System.out.println("Start chatting.");

            startReadThread();
            startWriteThread();

            System.out.println("Start chatting.");
        }

        @Override
        public void startReadThread() {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        if ((receive = reader.readLine()) != null) {
                            System.out.println(receive);
                            LibrarianStageController.messageArea.appendText(receiver + ": " + receive + "\n");
                        }
                    } catch (IOException e) {
                        System.out.println("Connection closed.");
                        isConnected = false;
                        break;
                    }
                }
            });

            thread.start();
        }

        @Override
        public void startWriteThread() {
            Thread thread = new Thread(() -> {
                Scanner sc = new Scanner(System.in);
                send = "Connection established with " + Library.chiefLibrarian.getName();
                writer.println(send);
                writer.flush();

                while (true) {
                    send = sc.nextLine();
                    writer.println(send);
                    VCStageController.messageArea.appendText(sender + ": " + send + "\n");
                    writer.flush();
                }
            });

            thread.start();
        }
    }
}
