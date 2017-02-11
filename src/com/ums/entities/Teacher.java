package com.ums.entities;


import com.ums.buildings.AdminBlock;
import com.ums.buildings.KUBS;
import com.ums.buildings.Pharmacy;
import com.ums.buildings.UBIT;
import com.ums.chathandler.ChatClient;
import com.ums.chathandler.ChatServer;
import com.ums.driver.Driver;
import com.ums.driver.TeacherStageController;
import com.ums.lists.CourseList;
import com.ums.lists.StudentList;
import javafx.application.Platform;

import java.io.IOException;
import java.util.Scanner;

public class Teacher extends Employee implements Faculty {

    public Server server;
    public Client client;

    public Teacher() {
        super(null, null, null, null, null, 0, 0, Position.TEACHER, 0);
    }

    public Teacher(String id, String name, String qualification, String department, String password,
                   int salary, int attendance, int port) {
        super(id, name, qualification, department, password, salary, attendance, Position.TEACHER, port);
    }

    @Override
    public boolean suspendStudent(String id) throws IOException {
        return AdminBlock.deleteStudentFromFile(id);
    }

    @Override
    public boolean modifyCourse(String id, String name) throws IOException {
        return AdminBlock.modifyCourseInFile(id, name);
    }

    public boolean modifyCourse(String id, int creditHours) throws IOException {
        return AdminBlock.modifyCourseInFile(id, creditHours);
    }

    @Override
    public String generateResultReport() {
        String info = "";

        if (this.getDepartment().equals("UBIT")) {

            for (int i = 0; i < UBIT.studentList.students.size(); i++) {
                info += ("\n\t\tName: " + UBIT.studentList.students.get(i).getName()
                        + "\n\t\tNo. of Subjects: 6\n"
                        + "\nIntroduction to Computer Science: " + UBIT.studentList.students.get(i).getMarks()[0]
                        + "\nIntroduction to Software Engineering: " + UBIT.studentList.students.get(i).getMarks()[1]
                        + "\nComputer Digital Organization and Logic Design: " + UBIT.studentList.students.get(i).getMarks()[2]
                        + "\nEnglish: " + UBIT.studentList.students.get(i).getMarks()[3]
                        + "\nIslamiat: " + UBIT.studentList.students.get(i).getMarks()[4]
                        + "\nCalculus: " + UBIT.studentList.students.get(i).getMarks()[5]
                        + "\n\t\t\tGPA: " + UBIT.studentList.students.get(i).getCGPA());
            }
            return info;
        } else if (this.getDepartment().equals("KUBS")) {

            for (int i = 0; i < KUBS.studentList.students.size(); i++) {
                info += ("\n\t\tName: " + KUBS.studentList.students.get(i).getName()
                        + "\n\t\tNo. of Subjects: 6\n"
                        + "\nIntroduction to Accounting: " + KUBS.studentList.students.get(i).getMarks()[0]
                        + "\nMicroeconomics: " + KUBS.studentList.students.get(i).getMarks()[1]
                        + "\nIslamiat and Pakistan Studies/Humanities: " + KUBS.studentList.students.get(i).getMarks()[2]
                        + "\nEnglish Writing Skills: " + KUBS.studentList.students.get(i).getMarks()[3]
                        + "\nIT in Business: " + KUBS.studentList.students.get(i).getMarks()[4]
                        + "\nFinancial Accounting: " + KUBS.studentList.students.get(i).getMarks()[5]
                        + "\n\t\t\tGPA: " + KUBS.studentList.students.get(i).getCGPA());
            }


            for (int i = 0; i < KUBS.studentList.students.size(); i++) {
                info += ("\n\t\tName: " + KUBS.studentList.students.get(i).getName()
                        + "\n\t\tNo. of Subjects: 6\n"
                        + "\nCalculus and Analytical Geometry: " + KUBS.studentList.students.get(i).getMarks()[0]
                        + "\nPhysics-I: " + KUBS.studentList.students.get(i).getMarks()[1]
                        + "\nEnglish Composition and Comprehension: " + KUBS.studentList.students.get(i).getMarks()[2]
                        + "\nObject Oriented Programming: " + KUBS.studentList.students.get(i).getMarks()[3]
                        + "\nTechnical and Business Writing: " + KUBS.studentList.students.get(i).getMarks()[4]
                        + "\nStatistics and Probability: " + KUBS.studentList.students.get(i).getMarks()[5]
                        + "\n\t\t\tGPA: " + KUBS.studentList.students.get(i).getCGPA());
            }

            return info;
        } else {

            for (int i = 0; i < Pharmacy.studentList.students.size(); i++) {
                info += ("\n\t\tName: " + Pharmacy.studentList.students.get(i).getName()
                        + "\n\t\tNo. of Subjects: 6\n"
                        + "\nIslamic Idealogy-Pakistan Studies: " + Pharmacy.studentList.students.get(i).getMarks()[0]
                        + "\nPhysiology & Histology I: " + Pharmacy.studentList.students.get(i).getMarks()[1]
                        + "\nPhysiology & Histology II: " + Pharmacy.studentList.students.get(i).getMarks()[2]
                        + "\nPharmaceutical Biochemistry I: " + Pharmacy.studentList.students.get(i).getMarks()[3]
                        + "\nPharmaceutical Biochemistry II: " + Pharmacy.studentList.students.get(i).getMarks()[4]
                        + "\nPharmacology - Anatomy: " + Pharmacy.studentList.students.get(i).getMarks()[5]
                        + "\n\t\t\tGPA: " + Pharmacy.studentList.students.get(i).getCGPA());
            }
            return info;
        }
    }

    @Override
    public StudentList getStudentList() {
        if (this.getDepartment().equals("UBIT"))
            return UBIT.studentList;
        else if (this.getDepartment().equals("KUBS"))
            return KUBS.studentList;
        else
            return Pharmacy.studentList;
    }

    @Override
    public CourseList getCourseList() {
        if (this.getDepartment().equals("UBIT"))
            return UBIT.courseList;
        else if (this.getDepartment().equals("KUBS"))
            return KUBS.courseList;
        else
            return Pharmacy.courseList;
    }

    @Override
    public String viewStudents() {

        String info = "";

        if (this.getDepartment().equals("UBIT")) {
            for (int i = 0; i < UBIT.studentList.students.size(); i++) {
                info += ("ID: " + UBIT.studentList.students.get(i).getID()
                        + "\tName: " + UBIT.studentList.students.get(i).getName()
                        + "\tSemester: " + UBIT.studentList.students.get(i).getSemester()
                        + "\tField: " + UBIT.studentList.students.get(i).getField() + "\n");
            }
            return info;
        } else if (this.getDepartment().equals("KUBS")) {
            for (int i = 0; i < KUBS.studentList.students.size(); i++) {
                info += ("ID: " + KUBS.studentList.students.get(i).getID()
                        + "\tName: " + KUBS.studentList.students.get(i).getName()
                        + "\tSemester: " + KUBS.studentList.students.get(i).getSemester()
                        + "\tField: " + KUBS.studentList.students.get(i).getField() + "\n");
            }
            return info;
        } else {
            for (int i = 0; i < Pharmacy.studentList.students.size(); i++) {
                info += ("ID: " + Pharmacy.studentList.students.get(i).getID()
                        + "\tName: " + Pharmacy.studentList.students.get(i).getName()
                        + "\tSemester: " + Pharmacy.studentList.students.get(i).getSemester()
                        + "\tField: " + Pharmacy.studentList.students.get(i).getField() + "\n");
            }
            return info;
        }

    }

    @Override
    public String viewCourses() {

        String info = "";

        if (this.getDepartment().equals("UBIT")) {
            for (int i = 0; i < UBIT.courseList.courses.size(); i++) {
                info += ("ID: " + UBIT.courseList.courses.get(i).getID()
                        + "\tName: " + UBIT.courseList.courses.get(i).getName()
                        + "\tCredit hours: " + UBIT.courseList.courses.get(i).getCreditHours()
                        + "\tField: " + UBIT.courseList.courses.get(i).getField() + "\n");
            }
            return info;
        } else if (this.getDepartment().equals("KUBS")) {
            for (int i = 0; i < KUBS.courseList.courses.size(); i++) {
                info += ("ID: " + KUBS.courseList.courses.get(i).getID()
                        + "\tName: " + KUBS.courseList.courses.get(i).getName()
                        + "\tCredit hours: " + KUBS.courseList.courses.get(i).getCreditHours()
                        + "\tField: " + KUBS.courseList.courses.get(i).getField() + "\n");
            }
            return info;
        } else {
            for (int i = 0; i < Pharmacy.courseList.courses.size(); i++) {
                info += ("ID: " + Pharmacy.courseList.courses.get(i).getID()
                        + "\tName: " + Pharmacy.courseList.courses.get(i).getName()
                        + "\tCredit hours: " + Pharmacy.courseList.courses.get(i).getCreditHours()
                        + "\tField: " + Pharmacy.courseList.courses.get(i).getField() + "\n");
            }
            return info;
        }
    }

    @Override
    public void registerStudent(String name, String department, String field) throws IOException {
        AdminBlock.registerStudentToFile("st1" + String.valueOf(AdminBlock.studentList.students.size() + 5),
                name, department, field, "st1" + String.valueOf(AdminBlock.studentList.students.size() + 5),
                0, 0, 0, 0, "10" + String.valueOf(AdminBlock.studentList.students.size() + 5));
    }

    @Override
    public String generateAttendanceReport() {

        String info = "";

        if (this.getDepartment().equals("UBIT")) {
            for (int i = 0; i < UBIT.studentList.students.size(); i++) {
                info += ("ID: " + UBIT.studentList.students.get(i).getID()
                        + "\tName: " + UBIT.studentList.students.get(i).getName()
                        + "\tAttendance: " + UBIT.studentList.students.get(i).getAttendance() + "%\n");
            }
            return info;
        } else if (this.getDepartment().equals("KUBS")) {
            for (int i = 0; i < KUBS.studentList.students.size(); i++) {
                info += ("ID: " + KUBS.studentList.students.get(i).getID()
                        + "Name: " + KUBS.studentList.students.get(i).getName()
                        + "\tAttendance: " + KUBS.studentList.students.get(i).getAttendance() + "%\n");
            }
            return info;
        } else {
            for (int i = 0; i < Pharmacy.studentList.students.size(); i++) {
                info += ("ID: " + Pharmacy.studentList.students.get(i).getID()
                        + "Name: " + Pharmacy.studentList.students.get(i).getName()
                        + "\tAttendance: " + Pharmacy.studentList.students.get(i).getAttendance() + "%\n");
            }
            return info;
        }
    }

    @Override
    public void requestIncreaseInSalary() {
        // TODO Auto-generated method stub

    }

    public boolean getDeanAuthorization() {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean login(String id, String password) {
        for (int i = 0; i < AdminBlock.teacherList.size(); i++) {
            if ((AdminBlock.teacherList.get(i).getID().equalsIgnoreCase(id))
                    && ((AdminBlock.teacherList.get(i).getPassword().equals(password))))
                return true;
        }
        return false;
    }

    @Override
    public void changePassword(String pass) throws IOException {
        for (int i = 0; i < AdminBlock.teacherList.size(); i++) {
            if (AdminBlock.teacherList.get(i).getID().equalsIgnoreCase(this.getID())) {
                AdminBlock.teacherList.get(i).setPassword(pass);
                AdminBlock.writeToAllFiles();
            }
        }
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
            Platform.runLater(() -> TeacherStageController.startServertMessageGUI());
        }

        @Override
        public void chat() throws IOException {
            setSender(Driver.university.tr.getName());

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
                            TeacherStageController.messageArea.appendText(receiver + ": " + receive + "\n");
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
                    TeacherStageController.messageArea.appendText(sender + ": " + send + "\n");
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

            for (int i=0; i<AdminBlock.teacherList.size(); i++) {
                if (port == AdminBlock.teacherList.get(i).getPort()) {
                    System.out.println("Connection established with " + AdminBlock.teacherList.get(i).getName());
                    receiver = AdminBlock.teacherList.get(i).getName();
                }
            }

            for (int i=0; i<AdminBlock.studentList.students.size(); i++) {
                if (port == AdminBlock.studentList.students.get(i).getPort()) {
                    System.out.println("Connection established with " + AdminBlock.studentList.students.get(i).getName());
                    receiver = AdminBlock.studentList.students.get(i).getName();
                }
            }

            sender = Driver.university.tr.getName();

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
                            TeacherStageController.messageArea.appendText(receiver + ": " + receive + "\n");
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
                send = "Connection established with " + Driver.university.tr.getName();
                writer.println(send);
                writer.flush();

                while (true) {
                    send = sc.nextLine();
                    writer.println(send);
                    TeacherStageController.messageArea.appendText(sender + ": " + send + "\n");
                    writer.flush();
                }
            });

            thread.start();
        }
    }
}
