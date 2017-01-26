package com.ums.buildings;

import com.ums.entities.AccountHolder.Position;
import com.ums.entities.ChiefLibrarian;
import com.ums.entities.Dean;
import com.ums.entities.Teacher;
import com.ums.entities.ViceChancellor;
import com.ums.event.Event;
import com.ums.filehandler.FileRead;
import com.ums.filehandler.FileWrite;
import com.ums.lists.CourseList;
import com.ums.lists.EmployeeList;
import com.ums.lists.StudentList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AdminBlock extends Building {

    public static ViceChancellor viceChancellor;

    public static EmployeeList employeeList;
    public static ArrayList<Dean> deanList;
    public static ArrayList<Teacher> teacherList;
    public static StudentList studentList;
    public static CourseList courseList;

    public static long budget;
    public static long currentFunds;

    public static Event event;

    static {
        try {
            viceChancellor = makeVC();
        } catch (IOException e) {
            e.printStackTrace();
        }

        employeeList = new EmployeeList();
        deanList = new ArrayList<Dean>();
        teacherList = new ArrayList<Teacher>();
        studentList = new StudentList();
        courseList = new CourseList();

        budget = 4000000000L;
        currentFunds = 50000000;

        event = new Event();
    }

    public AdminBlock() throws IOException {
        super("bd100", "Admin Block");

        readFromAllFiles();

        fetchDeans();
        fetchTeachers();
    }

    public static ViceChancellor makeVC() throws IOException {
        FileRead reader = new FileRead("vc.txt");
        ArrayList<String> file = reader.openFile();

        String[] temp = new String[4];
        for (int i = 0; i < file.size(); i++) {
            String token = file.get(i);
            temp = token.split(",");
        }

        return new ViceChancellor(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]));
    }

    public static void updateVC() throws IOException {
        FileWrite writer = new FileWrite("vc.txt", false);
        writer.writeToFile(AdminBlock.viceChancellor.getID() + "," + AdminBlock.viceChancellor.getName()
                + "," + AdminBlock.viceChancellor.getQualification() + "," + AdminBlock.viceChancellor.getPassword()
                + "," + AdminBlock.viceChancellor.getPort());
    }

    public static ChiefLibrarian makeLB() throws IOException {
        FileRead reader = new FileRead("lb.txt");
        ArrayList<String> file = reader.openFile();

        String[] temp = new String[7];
        for (int i = 0; i < file.size(); i++) {
            String token = file.get(i);
            temp = token.split(",");
        }

        return new ChiefLibrarian(temp[0], temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]),
                Integer.parseInt(temp[6]), Integer.parseInt(temp[7]));
    }

    public static void updateLB() throws IOException {
        FileWrite writer = new FileWrite("lb.txt", false);
        writer.writeToFile(Library.chiefLibrarian.getID() + "," + Library.chiefLibrarian.getName()
                + "," + Library.chiefLibrarian.getQualification() + "," + Library.chiefLibrarian.getDepartment()
                + "," + Library.chiefLibrarian.getPassword() + "," + Library.chiefLibrarian.getSalary()
                + "," + Library.chiefLibrarian.getAttendance() + "," + Library.chiefLibrarian.getPort());
    }

    public static void readFromAllFiles() throws IOException {
        employeeList = new EmployeeList();
        deanList = new ArrayList<Dean>();
        teacherList = new ArrayList<Teacher>();
        studentList = new StudentList();
        courseList = new CourseList();

        FileRead empListReader = new FileRead("employeeList.txt");
        ArrayList<String> file = empListReader.openFile();

        for (int i = 0; i < file.size(); i++) {
            String token = file.get(i);
            String[] temp = token.split(",");

            employeeList.addEmployee(temp[0], temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]),
                    Integer.parseInt(temp[6]), Position.valueOf(temp[7]), Integer.parseInt(temp[8]));
        }

        FileRead stdListReader = new FileRead("studentList.txt");
        file = stdListReader.openFile();

        for (int i = 0; i < file.size(); i++) {
            String token = file.get(i);
            String[] temp = token.split(",");

            studentList.addStudent(temp[0], temp[1], temp[2], temp[3], temp[4], Integer.parseInt(temp[5]),
                    Integer.parseInt(temp[6]), Integer.parseInt(temp[7]), Double.parseDouble(temp[8]), Integer.parseInt(temp[9]));
        }


        for (int j = 0; j < AdminBlock.studentList.students.size(); j++)
            studentList.students.get(j).setMarks((int) (Math.random() * 100), (int) (Math.random() * 100),
                    (int) (Math.random() * 100), (int) (Math.random() * 100), (int) (Math.random() * 100),
                    (int) (Math.random() * 100));

        for (int k = 0; k < AdminBlock.studentList.students.size(); k++) {
            int[] marks = studentList.students.get(k).getMarks();
            double avg = 0;

            for (int m = 0; m < 6; m++) {
                avg += marks[m];
            }

            avg = avg / 6;

            if (avg > 80)
                studentList.students.get(k).setCGPA(4.0);
            else if (avg > 75 && avg < 79)
                studentList.students.get(k).setCGPA(3.67);
            else if (avg > 70 && avg < 74)
                studentList.students.get(k).setCGPA(3.33);
            else if (avg > 65 && avg < 69)
                studentList.students.get(k).setCGPA(3.00);
            else if (avg > 60 && avg < 64)
                studentList.students.get(k).setCGPA(2.67);
            else if (avg > 55 && avg < 59)
                studentList.students.get(k).setCGPA(2.33);
            else if (avg > 50 && avg < 54)
                studentList.students.get(k).setCGPA(2.00);
            else if (avg > 45 && avg < 49)
                studentList.students.get(k).setCGPA(1.67);
            else if (avg > 40 && avg < 44)
                studentList.students.get(k).setCGPA(1.33);
            else if (avg > 30 && avg < 39)
                studentList.students.get(k).setCGPA(1.00);
            else if (avg > 20 && avg < 29)
                studentList.students.get(k).setCGPA(0.67);
            else if (avg > 10 && avg < 19)
                studentList.students.get(k).setCGPA(0.33);
            else if (avg > 0 && avg < 9)
                studentList.students.get(k).setCGPA(0.00);
        }

        FileRead coListReader = new FileRead("courseList.txt");
        file = coListReader.openFile();

        for (int i = 0; i < file.size(); i++) {
            String token = file.get(i);
            String[] temp = token.split(",");

            courseList.addCourse(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], temp[4]);
        }

        readSelectedCourses();
    }

    public static void writeToAllFiles() throws IOException {
        FileWrite employeeWrite = new FileWrite("employeeList.txt", false);
        employeeWrite.writeEmlpoyeeListToFile(AdminBlock.employeeList);

        FileWrite studentWrite = new FileWrite("studentList.txt", false);
        studentWrite.writeStudentListToFile(AdminBlock.studentList);

        FileWrite courseWrite = new FileWrite("courseList.txt", false);
        courseWrite.writeCourseListToFile(AdminBlock.courseList);
    }

    public static boolean registerEmployeeToFile(String id, String name, String qualification, String department,
                                                 String password, int salary, int attendance, Position position,
                                                 String port) throws IOException {

        FileWrite writer = new FileWrite("employeeList.txt");
        for (int i = 0; i < AdminBlock.employeeList.employees.size(); i++)
            if (AdminBlock.employeeList.employees.get(i).getID().equalsIgnoreCase(id))
                return false;

        writer.writeToFile(id + "," + name + "," + qualification + "," + department + "," + password + ","
                + salary + "," + attendance + "," + position.toString() + "," + port + "\n");

        readFromAllFiles();

        UBIT.fetchAll();
        IBA.fetchAll();
        Pharmacy.fetchAll();

        return true;
    }

    public static boolean registerStudentToFile(String id, String name, String department, String field,
                                                String password, int semester, int fee, int attendance, double gpa, String port) throws IOException {

        FileWrite writer = new FileWrite("studentList.txt");
        for (int i = 0; i < AdminBlock.studentList.students.size(); i++)
            if (AdminBlock.studentList.students.get(i).getID().equalsIgnoreCase(id))
                return false;

        writer.writeToFile(id + "," + name + "," + department + "," + field + "," + password + ","
                + semester + "," + fee + "," + attendance + "," + gpa + "," + port + "\n");

        readFromAllFiles();

        UBIT.fetchAll();
        IBA.fetchAll();
        Pharmacy.fetchAll();

        return true;
    }

    public static boolean registerCourseToFile(String id, String name, int creditHours,
                                               String field) throws IOException {
        FileWrite writer = new FileWrite("courseList.txt");
        for (int i = 0; i < AdminBlock.courseList.courses.size(); i++)
            if (AdminBlock.courseList.courses.get(i).getID().equalsIgnoreCase(id))
                return false;

        writer.writeToFile(id + "," + name + "," + creditHours + "," + field + "\n");
        return true;
    }

    public static boolean deleteEmployeeFromFile(String id) throws IOException {
        boolean isSuccessful = false;

        for (int i = 0; i < employeeList.employees.size() && isSuccessful == false; i++) {
            if (employeeList.employees.get(i).getID().equalsIgnoreCase(id)) {
                employeeList.employees.remove(employeeList.employees.get(i));
                isSuccessful = true;
            }
        }

        if (isSuccessful == true) {
            FileWrite writer = new FileWrite("employeeList.txt", false);
            writer.writeEmlpoyeeListToFile(employeeList);
        }

        readFromAllFiles();

        UBIT.fetchAll();
        IBA.fetchAll();
        Pharmacy.fetchAll();

        return isSuccessful;
    }

    public static boolean deleteStudentFromFile(String id) throws IOException {
        boolean isSuccessful = false;

        for (int i = 0; i < studentList.students.size() && isSuccessful == false; i++) {
            if (studentList.students.get(i).getID().equalsIgnoreCase(id)) {
                studentList.students.remove(studentList.students.get(i));
                isSuccessful = true;
            }
        }

        if (isSuccessful == true) {
            FileWrite writer = new FileWrite("studentList.txt", false);
            writer.writeStudentListToFile(studentList);
        }

        readFromAllFiles();

        UBIT.fetchAll();
        IBA.fetchAll();
        Pharmacy.fetchAll();

        return isSuccessful;
    }

    public static boolean deleteCourseFromFile(String id) throws IOException {
        boolean isSuccessful = false;

        for (int i = 0; i < courseList.courses.size() && isSuccessful == false; i++) {
            if (courseList.courses.get(i).getID().equalsIgnoreCase(id)) {
                courseList.courses.remove(courseList.courses.get(i));
                isSuccessful = true;
            }
        }

        if (isSuccessful == true) {
            FileWrite writer = new FileWrite("courseList.txt", false);
            writer.writeCourseListToFile(courseList);
        }

        readFromAllFiles();

        return isSuccessful;
    }

    public static boolean modifyEmployeeInFile(String id, String criteria) throws IOException {
        return false;
    }

    public static boolean modifyStudentInFile(String id, String criteria) throws IOException {
        return false;
    }

    public static boolean modifyCourseInFile(String id, String name) throws IOException {
        boolean isSuccessful = false;

        CourseList tempList = new CourseList();
        for (int i = 0; i < courseList.courses.size() && isSuccessful == false; i++) {
            if (courseList.courses.get(i).getID().equalsIgnoreCase(id)) {
                tempList.courses.add(courseList.courses.get(i));
                tempList.courses.get(i).setName(name);
                isSuccessful = true;
                break;
            }

            tempList.courses.add(courseList.courses.get(i));
        }

        if (isSuccessful == true) {
            FileWrite writer = new FileWrite("courseList.txt", false);
            writer.writeCourseListToFile(courseList);
        }

        readFromAllFiles();

        UBIT.fetchAll();
        IBA.fetchAll();
        Pharmacy.fetchAll();

        return isSuccessful;
    }

    public static boolean modifyCourseInFile(String id, int creditHours) throws IOException {
        boolean isSuccessful = false;

        CourseList tempList = new CourseList();
        for (int i = 0; i < courseList.courses.size() && isSuccessful == false; i++) {
            if (courseList.courses.get(i).getID().equalsIgnoreCase(id)) {
                tempList.courses.add(courseList.courses.get(i));
                tempList.courses.get(i).setCreditHours(creditHours);
                isSuccessful = true;
                break;
            }

            tempList.courses.add(courseList.courses.get(i));
        }

        if (isSuccessful == true) {
            FileWrite writer = new FileWrite("courseList.txt", false);
            writer.writeCourseListToFile(courseList);
        }

        readFromAllFiles();

        UBIT.fetchAll();
        IBA.fetchAll();
        Pharmacy.fetchAll();

        return isSuccessful;
    }

    public static void writeSelectedCoursesToFile(String id, String c1, String c2, String c3,
                                                  String c4, String c5, String c6) throws IOException {
        FileWrite writer = new FileWrite("selectedCourseList.txt");

        writer.writeToFile(id + "," + c1 + "," + c2 + "," + c3 + "," + c4 + "," + c5 + "," + c6 + "\n");
    }

    public static void readSelectedCourses() throws IOException {
        FileRead reader = new FileRead("selectedCourseList.txt");
        ArrayList<String> file = reader.openFile();

        for (int i = 0; i < file.size(); i++) {
            String token = file.get(i);
            String[] temp = token.split(",");

            for (int j = 0; j < AdminBlock.studentList.students.size(); j++) {
                if (temp[0].equals(AdminBlock.studentList.students.get(j).getID())) {

                    AdminBlock.studentList.students.get(j).courseList.addCourse(temp[1]);
                    AdminBlock.studentList.students.get(j).courseList.addCourse(temp[1]);
                    AdminBlock.studentList.students.get(j).courseList.addCourse(temp[3]);
                    AdminBlock.studentList.students.get(j).courseList.addCourse(temp[4]);
                    AdminBlock.studentList.students.get(j).courseList.addCourse(temp[5]);
                    AdminBlock.studentList.students.get(j).courseList.addCourse(temp[6]);
                }
            }
        }
    }

    public static void teacherSort() {
        TeacherNameSort sort = new TeacherNameSort();
        Collections.sort(AdminBlock.teacherList, sort);
    }

    private void fetchDeans() {
        for (int i = 0; i < employeeList.employees.size(); i++) {
            if (employeeList.employees.get(i).getPosition() == Position.DEAN)
                deanList.add((Dean) employeeList.employees.get(i));
        }
    }

    private void fetchTeachers() {
        for (int i = 0; i < employeeList.employees.size(); i++) {
            if (employeeList.employees.get(i).getPosition() == Position.TEACHER)
                teacherList.add((Teacher) employeeList.employees.get(i));
        }
    }
}

class TeacherNameSort implements Comparator<Teacher> {

    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
