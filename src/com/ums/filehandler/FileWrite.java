package com.ums.filehandler;

import com.ums.lists.CourseList;
import com.ums.lists.EmployeeList;
import com.ums.lists.StudentList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {

    FileWriter fw;
    PrintWriter pw;
    boolean appendValue = true;

    public FileWrite(String path, boolean appendValue) throws IOException {
        fw = new FileWriter(path, appendValue);
        pw = new PrintWriter(fw);
        this.appendValue = appendValue;
    }

    public FileWrite(String path) throws IOException {
        fw = new FileWriter(path, appendValue);
        pw = new PrintWriter(fw);
    }

    public void writeToFile(String text) throws IOException {
        this.pw.print(text);
        this.pw.close();
    }

    public void writeEmlpoyeeListToFile(EmployeeList list) {
        for (int i = 0; i < list.employees.size(); i++) {
            this.pw.print(list.employees.get(i).getID() + "," + list.employees.get(i).getName() + ","
                    + list.employees.get(i).getQualification() + "," + list.employees.get(i).getDepartment() + ","
                    + list.employees.get(i).getPassword() + "," + list.employees.get(i).getSalary() + ","
                    + list.employees.get(i).getAttendance() + "," + list.employees.get(i).getPosition().toString() + ","
                    + list.employees.get(i).getPort() + "\n");
        }

        this.pw.close();
    }

    public void writeStudentListToFile(StudentList list) {
        for (int i = 0; i < list.students.size(); i++) {
            this.pw.print(list.students.get(i).getID() + "," + list.students.get(i).getName() + ","
                    + list.students.get(i).getDepartment() + "," + list.students.get(i).getField() + ","
                    + list.students.get(i).getPassword() + "," + list.students.get(i).getSemester() + ","
                    + list.students.get(i).getFee() + "," + list.students.get(i).getAttendance() + ","
                    + list.students.get(i).getCGPA() + "," + list.students.get(i).getPort() + "\n");
        }

        this.pw.close();
    }

    public void writeCourseListToFile(CourseList list) {
        for (int i = 0; i < list.courses.size(); i++) {
            this.pw.print(list.courses.get(i).getID() + "," + list.courses.get(i).getName() + ","
                    + list.courses.get(i).getCreditHours() + "," + list.courses.get(i).getField() + ","
                    + list.courses.get(i).getDepartment() + "\n");
        }

        this.pw.close();
    }
}
