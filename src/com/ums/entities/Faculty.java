package com.ums.entities;

import com.ums.lists.CourseList;
import com.ums.lists.StudentList;

import java.io.IOException;

public interface Faculty {
    public boolean suspendStudent(String id) throws IOException;

    public boolean modifyCourse(String id, String name) throws IOException;

    public boolean modifyCourse(String id, int creditHours) throws IOException;

    public StudentList getStudentList();

    public CourseList getCourseList();

    public String generateAttendanceReport();

    public String generateResultReport();

    public void requestIncreaseInSalary();

    public String viewStudents();

    public String viewCourses();

    public void registerStudent(String name, String department, String field) throws IOException;
}
