package com.ums.entities;

import com.ums.lists.StudentList;

import java.io.IOException;
import java.util.ArrayList;

public interface Administrative {
    public boolean hireNewEmployee(String name, String qualification, String department,
                                   int salary, AccountHolder.Position position) throws IOException;

    public boolean fireEmployee(String id) throws IOException;

    public void organizeEvent(String name, int year, int month, int date, int hour, int minutes);

    public String generateAttendanceReport();

    public String generateSalaryReport();

    public ArrayList<Teacher> getTeacherList();

    public StudentList getStudentList();

    public String viewTeachers();

    public String viewStudents();

    public void increaseSalary(String id, int salary) throws IOException;
}
