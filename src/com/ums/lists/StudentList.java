package com.ums.lists;

import com.ums.entities.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentList implements List {

    public ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<Student>();
    }

    public void addStudent(String id, String name, String department, String field, String password,
                           int semester, int fee, int attendance,
                           double cgpa, int port) {

        Student temp = new Student(id, name, password, department, field, semester, fee, attendance, cgpa, port);
        students.add(temp);
    }

    @Override
    public String toString() {
        String objectInfo = "\t\tStudent List\t\tNumber of Students: " + students.size();
        for (int i = 0; i < students.size(); i++)
            objectInfo += students.get(i).toString();

        return objectInfo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        StudentList tempList = new StudentList();

        for (int i = 0; i < this.students.size(); i++) {
            tempList.students.get(i).setID(this.students.get(i).getID());
            tempList.students.get(i).setName(this.students.get(i).getName());
            tempList.students.get(i).setDepartment(this.students.get(i).getDepartment());
            tempList.students.get(i).setPassword(this.students.get(i).getDepartment());
            tempList.students.get(i).setSemester(this.students.get(i).getSemester());
            tempList.students.get(i).setFee(this.students.get(i).getFee());
            tempList.students.get(i).setAttendance(this.students.get(i).getAttendance());
            tempList.students.get(i).setCGPA(this.students.get(i).getCGPA());
            tempList.students.get(i).setPort(this.students.get(i).getPort());
        }
        return tempList;
    }

    @Override
    public void deleteFromList(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID().equals(id)) {
                students.remove(i);
                break;
            }
        }
    }

    @Override
    public int find(String criteria) {
        for (int i = 0; i < students.size(); i++)
            if ((students.get(i).getID().equalsIgnoreCase(criteria))
                    || (students.get(i).getName().equalsIgnoreCase(criteria))
                    || (students.get(i).getDepartment().equalsIgnoreCase(criteria)))
                return i;

        return -1;
    }

    @Override
    public int find(int criteria) {
        for (int i = 0; i < students.size(); i++)
            if ((students.get(i).getSemester() == criteria)
                    || (students.get(i).getFee() == criteria)
                    || (students.get(i).getAttendance() == criteria))
                return i;

        return -1;
    }

    @Override
    public int find(double criteria) {
        for (int i = 0; i < students.size(); i++)
            if ((students.get(i).getCGPA() == criteria))
                return i;
        return -1;
    }

    public void sort() {
        StudentNameSort sort = new StudentNameSort();
        Collections.sort(this.students, sort);
    }
}

class StudentNameSort implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
