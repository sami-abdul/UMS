package com.ums.buildings;

import com.ums.entities.Dean;
import com.ums.entities.Teacher;
import com.ums.event.Event;
import com.ums.lists.CourseList;
import com.ums.lists.StudentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IBA extends Department {

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

    public IBA() {
        super("bd300", "IBA", teacherList.size(), studentList.students.size(), courseList.courses.size(),
                2, new String[2], 70000000);

        fetchTeachers();
        fetchStudents();
        fetchCourses();

        numOfTeachers = teacherList.size();
        numOfStudents = studentList.students.size();
        numOfCourses = courseList.courses.size();

        this.fields[0] = "BBA";
        this.fields[1] = "BS (Computer Science)";
    }

    private static void fetchTeachers() {
        for (int i = 0; i < AdminBlock.teacherList.size(); i++) {
            if (AdminBlock.teacherList.get(i).getDepartment().equals("IBA"))
                IBA.teacherList.add((Teacher) AdminBlock.employeeList.employees.get(i));
        }
    }

    private static void fetchStudents() {
        for (int i = 0; i < AdminBlock.studentList.students.size(); i++) {
            if (AdminBlock.studentList.students.get(i).getDepartment().equals("IBA"))
                IBA.studentList.students.add(AdminBlock.studentList.students.get(i));
        }
    }

    private static void fetchCourses() {
        for (int i = 0; i < AdminBlock.courseList.courses.size(); i++) {
            if (AdminBlock.courseList.courses.get(i).getDepartment().equals("IBA"))
                IBA.courseList.courses.add(AdminBlock.courseList.courses.get(i));
        }
    }

    public static void fetchAll() {
        fetchTeachers();
        fetchStudents();
        fetchCourses();
    }

    public static void setEvent(String name, int year, int month, int date, int hour, int minutes) {
        IBA.event.setEvent(name, year, month, date, hour, minutes);
    }

    public static void teacherSort() {
        IBATeacherNameSort sort = new IBATeacherNameSort();
        Collections.sort(teacherList, sort);
    }
}

class IBATeacherNameSort implements Comparator<Teacher> {

    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
