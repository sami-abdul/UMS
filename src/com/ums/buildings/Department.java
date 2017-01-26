package com.ums.buildings;

public abstract class Department extends Building {

    public int numOfTeachers;
    public int numOfStudents;
    public int numOfCourses;
    public int numOfFields;

    public String[] fields;
    protected long budget;

    public Department(String id, String name, int numOfTeachers, int numOfStudents, int numOfCourses, int numOfFields,
                      String[] fields, long budget) {

        super(id, name);
        this.numOfTeachers = numOfTeachers;
        this.numOfStudents = numOfStudents;
        this.numOfCourses = numOfCourses;
        this.fields = fields;
        this.budget = budget;
    }

    @Override
    public String toString() {
        String info = "Department Name: " + this.name + "\n" + "Number of Teachers teaching: " + this.numOfTeachers + "\n" + "Number of Students studying: " + this.numOfStudents
                + "\n" + "Number of Courses taught: " + this.numOfCourses;

        return info;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public int getNumOfTeachers() {
        return numOfTeachers;
    }

    public void setNumOfTeachers(int numOfTeachers) {
        this.numOfTeachers = numOfTeachers;
    }

    public int getNumOfStudents() {
        return numOfTeachers;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public int getNumOfCourses() {
        return numOfCourses;
    }

    public void setNumOfCourses(int numOfCourses) {
        this.numOfCourses = numOfCourses;
    }

    public int getNumOfFields() {
        return numOfFields;
    }

    public void setNumOfFields(int numOfFields) {
        this.numOfFields = numOfFields;
    }

    public String[] fields() {
        return fields;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }


}
