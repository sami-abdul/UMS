package com.ums.lists;

import com.ums.entities.AccountHolder.Position;
import com.ums.entities.Dean;
import com.ums.entities.Employee;
import com.ums.entities.Teacher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeList implements List {

    public ArrayList<Employee> employees;

    public EmployeeList() {
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(String id, String name, String qualification, String department, String password,
                            int salary, int attendance, Position position, int port) {

        Employee temp = makeEmployee(id, name, qualification, department, password, salary, attendance, position, port);
        employees.add(temp);
    }

    public Employee makeEmployee(String id, String name, String qualification, String department, String password,
                                 int salary, int attendance, Position position, int port) {
        Employee tempEmployee = new Teacher(id, name, qualification, department, password, salary, attendance, port);

        if (position == Position.DEAN)
            tempEmployee = new Dean(id, name, qualification, department, password, salary, attendance, port);

        return tempEmployee;
    }

    @Override
    public String toString() {
        String objectInfo = "\t\tEmployee List\t\tNumber of Employees: " + employees.size();
        for (int i = 0; i < employees.size(); i++)
            objectInfo += employees.get(i).toString();

        return objectInfo;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        EmployeeList tempList = new EmployeeList();

        for (int i = 0; i < this.employees.size(); i++) {
            tempList.employees.get(i).setID(this.employees.get(i).getID());
            tempList.employees.get(i).setName(this.employees.get(i).getName());
            tempList.employees.get(i).setQualification(this.employees.get(i).getQualification());
            tempList.employees.get(i).setDepartment(this.employees.get(i).getDepartment());
            tempList.employees.get(i).setPassword(this.employees.get(i).getPassword());
            tempList.employees.get(i).setSalary(this.employees.get(i).getSalary());
            tempList.employees.get(i).setAttendance(this.employees.get(i).getAttendance());
            tempList.employees.get(i).setPosition(this.employees.get(i).getPosition());
            tempList.employees.get(i).setPort(this.employees.get(i).getPort());
        }
        return tempList;
    }

    @Override
    public void deleteFromList(String id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID().equalsIgnoreCase(id)) {
                employees.remove(i);
                break;
            }
        }
    }

    @Override
    public int find(String criteria) {
        for (int i = 0; i < employees.size(); i++)
            if ((employees.get(i).getID().equalsIgnoreCase(criteria))
                    || (employees.get(i).getName().equalsIgnoreCase(criteria))
                    || (employees.get(i).getQualification().equalsIgnoreCase(criteria))
                    || (employees.get(i).getDepartment().equalsIgnoreCase(criteria)))
                return i;

        return -1;
    }

    @Override
    public int find(int criteria) {
        for (int i = 0; i < employees.size(); i++)
            if ((employees.get(i).getSalary() == criteria)
                    || (employees.get(i).getAttendance() == criteria))
                return i;

        return -1;
    }

    @Override
    public int find(double criteria) {
        return -1;
    }

    @Override
    public void sort() {
        EmployeeNameSort sort = new EmployeeNameSort();
        Collections.sort(this.employees, sort);
    }
}

class EmployeeNameSort implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

