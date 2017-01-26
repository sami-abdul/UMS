package com.ums.entities;

public class Course {
    String name;
    private String id;
    private int creditHours;
    private String field;
    private String department;

    public Course(String id, String name, int creditHours, String field, String department) {
        this.id = id;
        this.name = name;
        this.field = field;
        this.creditHours = creditHours;
        this.department = department;
    }

    public Course(String id) {
        this.id = id;
    }

    public String toString() {
        return "\nCourse ID: " + this.id + "\tName: " + this.name
                + "\tCredit Hours: " + this.creditHours + "\tField: " + this.field
                + "\tDepartment: " + this.department;
    }

    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}