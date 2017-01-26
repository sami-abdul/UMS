package com.ums.buildings;

import com.ums.entities.AccountHolder.Position;
import com.ums.entities.Dean;
import com.ums.entities.Teacher;
import com.ums.event.Event;
import com.ums.lists.CourseList;
import com.ums.lists.StudentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UBIT extends Department {

    public static Dean dean;

    public static ArrayList<Teacher> teacherList;
    public static StudentList studentList;
    public static CourseList courseList;

    public static Event event;

    static {
        dean = new Dean(AdminBlock.employeeList.employees.get(0).getID(), AdminBlock.employeeList.employees.get(0).getName(),
                AdminBlock.employeeList.employees.get(0).getQualification(), AdminBlock.employeeList.employees.get(0).getDepartment(),
                AdminBlock.employeeList.employees.get(0).getPassword(), AdminBlock.employeeList.employees.get(0).getSalary(),
                AdminBlock.employeeList.employees.get(0).getAttendance(), AdminBlock.employeeList.employees.get(0).getPort());

        teacherList = new ArrayList<Teacher>();
        studentList = new StudentList();
        courseList = new CourseList();

        event = new Event();
    }

    public UBIT() {
        super("bd200", "UBIT", teacherList.size(), studentList.students.size(), courseList.courses.size(),
                2, new String[2], 50000000);

        fetchTeachers();
        fetchStudents();
        fetchCourses();

        numOfTeachers = teacherList.size();
        numOfStudents = studentList.students.size();
        numOfCourses = courseList.courses.size();

        this.fields[0] = "BS (Software Engineering)";
        this.fields[1] = "BS (Computer Science)";
    }

    private static void fetchTeachers() {
        for (int i = 0; i < AdminBlock.teacherList.size(); i++) {
            if ((AdminBlock.teacherList.get(i).getDepartment().equals("UBIT")) && (AdminBlock.employeeList.employees.get(i).position.equals(Position.TEACHER)))
                UBIT.teacherList.add((Teacher) AdminBlock.employeeList.employees.get(i));
        }
    }

    private static void fetchStudents() {
        for (int i = 0; i < AdminBlock.studentList.students.size(); i++) {
            if (AdminBlock.studentList.students.get(i).getDepartment().equalsIgnoreCase("UBIT")) {
                UBIT.studentList.students.add(AdminBlock.studentList.students.get(i));
            }
        }
    }

    private static void fetchCourses() {
        for (int i = 0; i < AdminBlock.courseList.courses.size(); i++) {
            if (AdminBlock.courseList.courses.get(i).getDepartment().equals("UBIT"))
                UBIT.courseList.courses.add(AdminBlock.courseList.courses.get(i));
        }
    }

    public static void fetchAll() {
        teacherList = new ArrayList<Teacher>();
        studentList = new StudentList();
        courseList = new CourseList();

        fetchTeachers();
        fetchStudents();
        fetchCourses();
    }

    public static void setEvent(String name, int year, int month, int date, int hour, int minutes) {
        UBIT.event.setEvent(name, year, month, date, hour, minutes);
    }

    public static void teacherSort() {
        UBITTeacherNameSort sort = new UBITTeacherNameSort();
        Collections.sort(teacherList, sort);
    }
}

class UBITTeacherNameSort implements Comparator<Teacher> {

    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
