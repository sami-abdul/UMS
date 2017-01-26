package com.ums.entities;

import com.ums.buildings.AdminBlock;
import com.ums.buildings.IBA;
import com.ums.buildings.Pharmacy;
import com.ums.buildings.UBIT;
import com.ums.lists.StudentList;

import java.io.IOException;
import java.util.ArrayList;

public class ViceChancellor extends AccountHolder implements Administrative {

    private String qualification;

    public ViceChancellor(String id, String name, String qualification, String password, int port) {
        super(id, name, password, Position.VICE_CHANCELLOR, port);
        this.qualification = "Post Doctorate (Germany)";
    }

    public String toString() {
        return "\nID: " + this.id + "\nName: " + this.name + "\nQualification: " + this.qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setBudget(long budget) {
        AdminBlock.budget = budget;
    }

    public void setCurrentFunds(long currentFunds) {
        AdminBlock.currentFunds = currentFunds;
    }

    public void generateBudgetReport() {

    }

    @Override
    public boolean hireNewEmployee(String name, String qualification, String department,
                                   int salary, Position position) throws IOException {

        if (position == Position.TEACHER) {

            return AdminBlock.registerEmployeeToFile("tr1" + String.valueOf(AdminBlock.employeeList.employees.size() + 5),
                    name, qualification, department, "tr1" + String.valueOf(AdminBlock.employeeList.employees.size() + 5),
                    salary, 0, Position.TEACHER, "20" + String.valueOf(AdminBlock.employeeList.employees.size() + 5));
        } else {

            return AdminBlock.registerEmployeeToFile("dn" + String.valueOf(AdminBlock.deanList.size() + 2 + "00"),
                    name, qualification, department, "dn" + String.valueOf(AdminBlock.deanList.size() + 2 + "00"),
                    salary, 0, Position.DEAN, "30" + String.valueOf(AdminBlock.employeeList.employees.size() + 5));
        }
    }

    @Override
    public boolean fireEmployee(String id) throws IOException {
        return AdminBlock.deleteEmployeeFromFile(id);
    }

    @Override
    public void organizeEvent(String name, int year, int month, int date, int hour, int minutes) {
        AdminBlock.event.setEvent(name, year, month, date, hour, minutes);
    }

    @Override
    public String generateAttendanceReport() {
        String info = "";
        info += ("\n\n\t\t\tDeans\n");
        for (int i = 0; i < AdminBlock.deanList.size(); i++) {
            info += ("ID: " + AdminBlock.deanList.get(i).getID()
                    + "\tName: " + AdminBlock.deanList.get(i).getName()
                    + "\tAttendance: " + AdminBlock.deanList.get(i).getAttendance() + "%"
                    + "\tDepartment: " + AdminBlock.deanList.get(i).getDepartment() + "\n");
        }

        info += ("\n\n\t\t\t\tUBIT");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < UBIT.teacherList.size(); i++) {
            info += ("ID: " + UBIT.teacherList.get(i).getID()
                    + "\tName: " + UBIT.teacherList.get(i).getName()
                    + "\tAttendance: " + UBIT.teacherList.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\tStudents\n");
        for (int i = 0; i < UBIT.studentList.students.size(); i++) {
            info += ("ID: " + UBIT.studentList.students.get(i).getID()
                    + "\tName: " + UBIT.studentList.students.get(i).getName()
                    + "\tAttendance: " + UBIT.studentList.students.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\t\t\tIBA");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < IBA.teacherList.size(); i++) {
            info += ("ID: " + IBA.teacherList.get(i).getID()
                    + "\tName: " + IBA.teacherList.get(i).getName()
                    + "\tAttendance: " + IBA.teacherList.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\tStudents\n");
        for (int i = 0; i < IBA.studentList.students.size(); i++) {
            info += ("ID: " + IBA.studentList.students.get(i).getID()
                    + "\tName: " + IBA.studentList.students.get(i).getName()
                    + "\tAttendance: " + IBA.studentList.students.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\t\t\tPharmacy");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < Pharmacy.teacherList.size(); i++) {
            info += ("ID: " + Pharmacy.teacherList.get(i).getID()
                    + "\tName: " + Pharmacy.teacherList.get(i).getName()
                    + "\tAttendance: " + Pharmacy.teacherList.get(i).getAttendance() + "%" + "\n");
        }

        info += ("\n\n\t\tStudents\n");
        for (int i = 0; i < Pharmacy.studentList.students.size(); i++) {
            info += ("ID: " + Pharmacy.studentList.students.get(i).getID()
                    + "\tName: " + Pharmacy.studentList.students.get(i).getName()
                    + "\tAttendance: " + Pharmacy.studentList.students.get(i).getAttendance() + "%" + "\n");
        }
        return info;
    }

    @Override
    public String generateSalaryReport() {

        String info = "";

        info += ("\n\n\t\tDeans\n");
        for (int i = 0; i < AdminBlock.deanList.size(); i++) {
            info += ("ID: " + AdminBlock.deanList.get(i).getID()
                    + "\tName: " + AdminBlock.deanList.get(i).getName()
                    + "\tSalary: " + AdminBlock.deanList.get(i).getSalary()
                    + "\tDepartment: " + AdminBlock.deanList.get(i).getDepartment() + "\n");

        }
        info += ("\n\n\t\t\t\tUBIT");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < UBIT.teacherList.size(); i++) {
            info += ("ID: " + UBIT.teacherList.get(i).getID()
                    + "\tName: " + UBIT.teacherList.get(i).getName()
                    + "\tSalary: " + UBIT.teacherList.get(i).getSalary() + "\n");
        }

        info += ("\n\n\t\t\t\tIBA");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < IBA.teacherList.size(); i++) {
            info += ("ID: " + IBA.teacherList.get(i).getID()
                    + "\tName: " + IBA.teacherList.get(i).getName()
                    + "\tSalary: " + IBA.teacherList.get(i).getSalary() + "\n");
        }

        info += ("\n\n\t\t\t\tPharmacy");
        info += ("\n\n\t\tTeachers\n");
        for (int i = 0; i < Pharmacy.teacherList.size(); i++) {
            info += ("ID: " + Pharmacy.teacherList.get(i).getID()
                    + "\tName: " + Pharmacy.teacherList.get(i).getName()
                    + "\tSalary: " + Pharmacy.teacherList.get(i).getSalary() + "\n");
        }
        return info;
    }


    public ArrayList<Dean> getDeanList() {
        return AdminBlock.deanList;
    }

    @Override
    public ArrayList<Teacher> getTeacherList() {
        return AdminBlock.teacherList;
    }

    @Override
    public StudentList getStudentList() {
        return AdminBlock.studentList;
    }

    public String viewDeans() {
        String info = "";
        for (int i = 0; i < AdminBlock.deanList.size(); i++) {
            info += ("ID: " + AdminBlock.deanList.get(i).getID()
                    + "\nName: " + AdminBlock.deanList.get(i).getName()
                    + "\tQualification: " + AdminBlock.deanList.get(i).getQualification() + "\n");
        }
        return info;
    }

    @Override
    public String viewTeachers() {
        String info = "";
        for (int i = 0; i < AdminBlock.teacherList.size(); i++) {
            info += ("ID: " + AdminBlock.teacherList.get(i).getID()
                    + "\tName: " + AdminBlock.teacherList.get(i).getName()
                    + "\tQualification" + AdminBlock.teacherList.get(i).getQualification() + "\n");
        }
        return info;
    }

    @Override
    public String viewStudents() {

        String info = "";

        for (int i = 0; i < AdminBlock.studentList.students.size(); i++) {
            info += ("ID: " + AdminBlock.studentList.students.get(i).getID()
                    + "\tName: " + AdminBlock.studentList.students.get(i).getName()
                    + "\tSemester: " + AdminBlock.studentList.students.get(i).getSemester()
                    + "\tField: " + AdminBlock.studentList.students.get(i).getField() + "\n");
        }
        return info;
    }

    public String viewCourses() {
        String info = "";
        for (int i = 0; i < AdminBlock.courseList.courses.size(); i++) {
            info += ("ID: " + AdminBlock.courseList.courses.get(i).getID()
                    + "\tName: " + AdminBlock.courseList.courses.get(i).getName()
                    + "\tCredit hours: " + AdminBlock.courseList.courses.get(i).getCreditHours() + "\n");
        }
        return info;
    }

    @Override
    public void increaseSalary(String id, int salary) throws IOException {
        System.out.println(id);
        for (int i = 0; i < AdminBlock.employeeList.employees.size(); i++) {
            if (AdminBlock.employeeList.employees.get(i).getID().equalsIgnoreCase(id)) {
                System.out.println(AdminBlock.employeeList.employees.get(i).getSalary());
                AdminBlock.employeeList.employees.get(i).setSalary(salary);
                System.out.println(AdminBlock.employeeList.employees.get(i));
                System.out.println(AdminBlock.employeeList.employees.get(i).getSalary());
            }
        }

        AdminBlock.writeToAllFiles();
        AdminBlock.readFromAllFiles();
    }

    @Override
    public boolean login(String id, String password) {
        if ((AdminBlock.viceChancellor.getID().equalsIgnoreCase(id)) && AdminBlock.viceChancellor.getPassword().equals(password))
            return true;
        return false;
    }

    @Override
    public void changePassword(String pass) throws IOException {
        AdminBlock.viceChancellor.setPassword(pass);
        AdminBlock.updateVC();
    }
}
