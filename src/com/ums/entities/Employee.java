package com.ums.entities;

import com.ums.buildings.AdminBlock;

import java.io.IOException;

public abstract class Employee extends AccountHolder {

    /**
     * Instance variables
     */
    protected String qualification, department;
    protected int salary, attendance;

    /**
     * Parametrized constructor
     */
    public Employee(String id, String name, String qualification, String department, String password,
                    int salary, int attendance, Position position, int port) {
        super(id, name, password, position, port);

        this.qualification = qualification;
        this.department = department;
        this.salary = salary;
        this.attendance = attendance;
        this.position = position;
    }

    /**
     * toString() method
     */
    public String toString() {
        return "\nID: " + this.id + "\nName: " + this.name + "\nQualification: " + this.qualification + "\nDepartment: " + this.department
                + "\nSalary: Rs." + this.salary + "\nAttendance: " + this.attendance + "%" + "\nPosition: " + this.position;
    }

    /**
     * Getters
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * Setters
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public void resign() throws IOException {
        AdminBlock.deleteEmployeeFromFile(this.id);
    }
}
