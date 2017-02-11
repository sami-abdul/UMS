package com.ums.buildings;

import com.ums.entities.Dean;
import com.ums.entities.Teacher;
import com.ums.event.Event;
import com.ums.lists.CourseList;
import com.ums.lists.StudentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KUBS extends Department {

    public static Dean dean;

    public static ArrayList<Teacher> teacherList;
    public static StudentList studentList;
    public static CourseList courseList;

    public static Event event;

    static {
        dean = new Dean(AdminBlock.employeeList.employees.get(1).getID(), AdminBlock.employeeList.employees.get(1).getName(),
                AdminBlock.employeeList.employees.get(1).getQualification(), AdminBlock.employeeList.employees.get(1).getDepartment(),
                AdminBlock.employeeList.employees.get(1).getPassword(), AdminBlock.employeeList.employees.get(1).getSalary(),
                AdminBlock.employeeList.employees.get(1).getAttendance(), AdminBlock.employeeList.employees.get(1).getPort());

        teacherList = new ArrayList<Teacher>();
        studentList = new StudentList();
        courseList = new CourseList();

        event = new Event();
    }

    public KUBS() {
        super("bd300", "KUBS", teacherList.size(), studentList.students.size(), courseList.courses.size(),
                1, new String[1], 70000000);

        fetchTeachers();
        fetchStudents();
        fetchCourses();

        numOfTeachers = teacherList.size();
        numOfStudents = studentList.students.size();
        numOfCourses = courseList.courses.size();

        this.fields[0] = "BBA";
    }

    private static void fetchTeachers() {
        for (int i = 0; i < AdminBlock.teacherList.size(); i++) {
            if (AdminBlock.teacherList.get(i).getDepartment().equals("KUBS"))
                KUBS.teacherList.add((Teacher) AdminBlock.employeeList.employees.get(i));
        }
    }

    private static void fetchStudents() {
        for (int i = 0; i < AdminBlock.studentList.students.size(); i++) {
            if (AdminBlock.studentList.students.get(i).getDepartment().equals("KUBS"))
                KUBS.studentList.students.add(AdminBlock.studentList.students.get(i));
        }
    }

    private static void fetchCourses() {
        for (int i = 0; i < AdminBlock.courseList.courses.size(); i++) {
            if (AdminBlock.courseList.courses.get(i).getDepartment().equals("KUBS"))
                KUBS.courseList.courses.add(AdminBlock.courseList.courses.get(i));
        }
    }

    public static void fetchAll() {
        fetchTeachers();
        fetchStudents();
        fetchCourses();
    }

    public static void setEvent(String name, int year, int month, int date, int hour, int minutes) {
        KUBS.event.setEvent(name, year, month, date, hour, minutes);
    }

    public static void teacherSort() {
        KUBSTeacherNameSort sort = new KUBSTeacherNameSort();
        Collections.sort(teacherList, sort);
    }
}

class KUBSTeacherNameSort implements Comparator<Teacher> {

    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
