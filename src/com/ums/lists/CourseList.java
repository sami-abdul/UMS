package com.ums.lists;

import com.ums.buildings.AdminBlock;
import com.ums.entities.Course;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CourseList implements List {

    public ArrayList<Course> courses;

    public CourseList() {
        courses = new ArrayList<Course>();
    }

    public void addCourse(String id, String name, int creditHours, String field, String department) {
        Course temp = new Course(id, name, creditHours, field, department);
        courses.add(temp);
    }

    public void addCourse(String id) {
        Course temp = new Course(id);

        for (int i = 0; i < AdminBlock.courseList.courses.size(); i++) {
            if (AdminBlock.courseList.courses.get(i).getID().equals(temp.getID())) {
                temp.setName(AdminBlock.courseList.courses.get(i).getName());
                temp.setCreditHours(AdminBlock.courseList.courses.get(i).getCreditHours());
                courses.add(temp);
            }
        }
    }

    public String toString() {
        String objectInfo = "\t\tCourse List\t\tNumber of courses: " + courses.size();
        for (int i = 0; i < courses.size(); i++)
            objectInfo += courses.get(i).toString();
        return objectInfo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CourseList tempList = new CourseList();

        for (int i = 0; i < this.courses.size(); i++) {
            tempList.courses.get(i).setID(this.courses.get(i).getID());
            tempList.courses.get(i).setName(this.courses.get(i).getName());
            tempList.courses.get(i).setCreditHours(this.courses.get(i).getCreditHours());
            tempList.courses.get(i).setField(this.courses.get(i).getField());
            tempList.courses.get(i).setDepartment(this.courses.get(i).getDepartment());
        }
        return tempList;
    }

    @Override
    public void deleteFromList(String id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getID().equalsIgnoreCase(id)) {
                courses.remove(i);
                break;
            }
        }
    }

    @Override
    public int find(String criteria) {
        for (int i = 0; i < courses.size(); i++)
            if ((courses.get(i).getID().equalsIgnoreCase(criteria))
                    || (courses.get(i).getName().equalsIgnoreCase(criteria))
                    || (courses.get(i).getDepartment().equalsIgnoreCase(criteria)))
                return i;

        return -1;
    }

    @Override
    public int find(int criteria) {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public int find(double criteria) {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public void sort() {
        CourseNameSort sort = new CourseNameSort();
        Collections.sort(this.courses, sort);
    }
}


class CourseNameSort implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
