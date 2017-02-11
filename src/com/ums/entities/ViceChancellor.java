package com.ums.entities;

import com.ums.buildings.AdminBlock;
import com.ums.buildings.KUBS;
import com.ums.buildings.Pharmacy;
import com.ums.buildings.UBIT;
import com.ums.chathandler.ChatClient;
import com.ums.chathandler.ChatServer;
import com.ums.driver.VCStageController;
import com.ums.lists.StudentList;
import javafx.application.Platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ViceChancellor extends AccountHolder implements Administrative {

    public Server server;
    public Client client;

    private String qualification;

    public ViceChancellor(String id, String name, String qualification, String password, int port) {
        super(id, name, password, Position.VICE_CHANCELLOR, port);
        this.qualification = "Post Doctorate (Germany)";
    }

    public String toString() {
        return "\nID: " + this.id + "\nName: " + this.name + "\nQualification: " + this.qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setBudget(long budget) {
        AdminBlock.budget = budget;
    }

    public void setCurrentFunds(long currentFunds) {
        AdminBlock.currentFunds = currentFunds;
    }

    public void generateBudgetReport() {

    }

    @Override
    public boolean hireNewEmployee(String name, String qualification, String department,
                                   int salary, Position position) throws IOException {

        if (position == Position.TEACHER) {

            return AdminBlock.registerEmployeeToFile("tr1" + String.valueOf(AdminBlock.employeeList.employees.size() + 5),
                    name, qualification, department, "tr1" + String.valueOf(AdminBlock.employeeList.employees.size() + 5),
                    salary, 0, Position.TEACHER, "20" + String.valueOf(AdminBlock.employeeList.employees.size() + 5));
        } else {

            return AdminBlock.registerEmployeeToFile("dn" + String.valueOf(AdminBlock.deanList.size() + 2 + "00"),
                    name, qualification, department, "dn" + String.valueOf(AdminBlock.deanList.size() + 2 + "00"),
                    salary, 0, Position.DEAN, "30" + String.valueOf(AdminBlock.employeeList.employees.size() + 5));
        }
    }

    @Override
    public boolean fireEmployee(String id) throws IOException {
        return AdminBlock.deleteEmployeeFromFile(id);
    }

    @Override
    public void organizeEvent(String name, int year, int month, int date, int hour, int minutes) {
        AdminBlock.event.setEvent(name, year, month, date, hour, minutes);
    }

    @Override
    public String generateAttendanceReport() {
        String info = "";
        info += ("\n\n\t\t\tDeans\n");
        for (int i = 0; i < AdminBlock.deanList.size(); i++) {
            info += ("ID: " + AdminBlock.deanList.get(i).getID()
                    + "\tName: " + AdminBlock.deanList.get(i).getName()
                    + "\tAttendance: " + AdminBlock.deanList.get(i).getAttendance() + "%"
                    + "\tDepartment: " + AdminBlock.deanList.get(i).getDepartment() + "\n");
        }

        info += ("\n\n\t\t\t\tUBIT");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < UBIT.teacherList.size(); i++) {
            info += ("ID: " + UBIT.teacherList.get(i).getID()
                    + "\tName: " + UBIT.teacherList.get(i).getName()
                    + "\tAttendance: " + UBIT.teacherList.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\tStudents\n");
        for (int i = 0; i < UBIT.studentList.students.size(); i++) {
            info += ("ID: " + UBIT.studentList.students.get(i).getID()
                    + "\tName: " + UBIT.studentList.students.get(i).getName()
                    + "\tAttendance: " + UBIT.studentList.students.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\t\t\tKUBS");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < KUBS.teacherList.size(); i++) {
            info += ("ID: " + KUBS.teacherList.get(i).getID()
                    + "\tName: " + KUBS.teacherList.get(i).getName()
                    + "\tAttendance: " + KUBS.teacherList.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\tStudents\n");
        for (int i = 0; i < KUBS.studentList.students.size(); i++) {
            info += ("ID: " + KUBS.studentList.students.get(i).getID()
                    + "\tName: " + KUBS.studentList.students.get(i).getName()
                    + "\tAttendance: " + KUBS.studentList.students.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\t\t\tPharmacy");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < Pharmacy.teacherList.size(); i++) {
            info += ("ID: " + Pharmacy.teacherList.get(i).getID()
                    + "\tName: " + Pharmacy.teacherList.get(i).getName()
                    + "\tAttendance: " + Pharmacy.teacherList.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\tStudents\n");
        for (int i = 0; i < Pharmacy.studentList.students.size(); i++) {
            info += ("ID: " + Pharmacy.studentList.students.get(i).getID()
                    + "\tName: " + Pharmacy.studentList.students.get(i).getName()
                    + "\tAttendance: " + Pharmacy.studentList.students.get(i).getAttendance() + "%" + "\n");
        }
        return info;
    }

    @Override
    public String generateSalaryReport() {

        String info = "";

        info += ("\n\n\t\tDeans\n");
        for (int i = 0; i < AdminBlock.deanList.size(); i++) {
            info += ("ID: " + AdminBlock.deanList.get(i).getID()
                    + "\tName: " + AdminBlock.deanList.get(i).getName()
                    + "\tSalary: " + AdminBlock.deanList.get(i).getSalary()
                    + "\tDepartment: " + AdminBlock.deanList.get(i).getDepartment() + "\n");

        }
        info += ("\n\n\t\t\t\tUBIT");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < UBIT.teacherList.size(); i++) {
            info += ("ID: " + UBIT.teacherList.get(i).getID()
                    + "\tName: " + UBIT.teacherList.get(i).getName()
                    + "\tSalary: " + UBIT.teacherList.get(i).getSalary() + "\n");
        }

        info += ("\n\n\t\t\t\tKUBS");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < KUBS.teacherList.size(); i++) {
            info += ("ID: " + KUBS.teacherList.get(i).getID()
                    + "\tName: " + KUBS.teacherList.get(i).getName()
                    + "\tSalary: " + KUBS.teacherList.get(i).getSalary() + "\n");
        }

        info += ("\n\n\t\t\t\tPharmacy");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < Pharmacy.teacherList.size(); i++) {
            info += ("ID: " + Pharmacy.teacherList.get(i).getID()
                    + "\tName: " + Pharmacy.teacherList.get(i).getName()
                    + "\tSalary: " + Pharmacy.teacherList.get(i).getSalary() + "\n");
        }
        return info;
    }


    public ArrayList<Dean> getDeanList() {
        return AdminBlock.deanList;
    }

    @Override
    public ArrayList<Teacher> getTeacherList() {
        return AdminBlock.teacherList;
    }

    @Override
    public StudentList getStudentList() {
        return AdminBlock.studentList;
    }

    public String viewDeans() {
        String info = "";
        for (int i = 0; i < AdminBlock.deanList.size(); i++) {
            info += ("ID: " + AdminBlock.deanList.get(i).getID()
                    + "\nName: " + AdminBlock.deanList.get(i).getName()
                    + "\tQualification: " + AdminBlock.deanList.get(i).getQualification() + "\n");
        }
        return info;
    }

    @Override
    public String viewTeachers() {
        String info = "";
        for (int i = 0; i < AdminBlock.teacherList.size(); i++) {
            info += ("ID: " + AdminBlock.teacherList.get(i).getID()
                    + "\tName: " + AdminBlock.teacherList.get(i).getName()
                    + "\tQualification" + AdminBlock.teacherList.get(i).getQualification() + "\n");
        }
        return info;
    }

    @Override
    public String viewStudents() {

        String info = "";

        for (int i = 0; i < AdminBlock.studentList.students.size(); i++) {
            info += ("ID: " + AdminBlock.studentList.students.get(i).getID()
                    + "\tName: " + AdminBlock.studentList.students.get(i).getName()
                    + "\tSemester: " + AdminBlock.studentList.students.get(i).getSemester()
                    + "\tField: " + AdminBlock.studentList.students.get(i).getField() + "\n");
        }
        return info;
    }

    public String viewCourses() {
        String info = "";
        for (int i = 0; i < AdminBlock.courseList.courses.size(); i++) {
            info += ("ID: " + AdminBlock.courseList.courses.get(i).getID()
                    + "\tName: " + AdminBlock.courseList.courses.get(i).getName()
                    + "\tCredit hours: " + AdminBlock.courseList.courses.get(i).getCreditHours() + "\n");
        }
        return info;
    }

    @Override
    public void increaseSalary(String id, int salary) throws IOException {
        System.out.println(id);
        for (int i = 0; i < AdminBlock.employeeList.employees.size(); i++) {
            if (AdminBlock.employeeList.employees.get(i).getID().equalsIgnoreCase(id)) {
                System.out.println(AdminBlock.employeeList.employees.get(i).getSalary());
                AdminBlock.employeeList.employees.get(i).setSalary(salary);
                System.out.println(AdminBlock.employeeList.employees.get(i));
                System.out.println(AdminBlock.employeeList.employees.get(i).getSalary());
            }
        }

        AdminBlock.writeToAllFiles();
        AdminBlock.readFromAllFiles();
    }

    @Override
    public boolean login(String id, String password) {
        if ((AdminBlock.viceChancellor.getID().equalsIgnoreCase(id)) && AdminBlock.viceChancellor.getPassword().equals(password))
            return true;
        return false;
    }

    @Override
    public void changePassword(String pass) throws IOException {
        AdminBlock.viceChancellor.setPassword(pass);
        AdminBlock.updateVC();
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
            Platform.runLater(() -> VCStageController.startServertMessageGUI());
        }

        @Override
        public void chat() throws IOException {
            setSender(AdminBlock.viceChancellor.getName());

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
                            VCStageController.messageArea.appendText(receiver + ": " + receive + "\n");
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
                    VCStageController.messageArea.appendText(sender + ": " + send + "\n");
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
            for (int i=0; i<AdminBlock.deanList.size(); i++) {
                if (port == AdminBlock.deanList.get(i).getPort()) {
                    System.out.println("Connection established with " + AdminBlock.deanList.get(i).getName());
                    receiver = AdminBlock.deanList.get(i).getName();
                }
            }

            sender = AdminBlock.viceChancellor.getName();

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
                            VCStageController.messageArea.appendText(receiver + ": " + receive + "\n");
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
                send = "Connection established with " + AdminBlock.viceChancellor.getName();
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
