package com.ums.entities;

import com.ums.buildings.AdminBlock;
import com.ums.buildings.Library;

import java.io.IOException;

public class ChiefLibrarian extends Employee {

    public ChiefLibrarian(String id, String name, String qualification, String department, String password, int salary,
                          int attendance, int port) {
        super(id, name, qualification, department, password, salary, attendance, Position.CHIEF_LIBRARIAN, port);
    }

    public void setTimeToDefault() {
        Library.time = Library.DEFAULT_TIME;
    }

    public void setTimeTo(String time) {
        Library.time = time;
    }

    public void hireNewLibrarians(int n) {
        Library.numOfLibrarians += n;
    }

    public void fireLibrarians(int n) {
        Library.numOfLibrarians -= n;
    }

    public void inreaseBooks(int n) {
        Library.numOfBooks += n;
    }

    public void decreaseBooks(int n) {
        Library.numOfBooks -= n;
    }

    public void organizeBookFair(int year, int month, int date, int hour, int minutes) {
        Library.setEvent("Book Fair", year, month, date, hour, minutes);
    }

    @Override
    public boolean login(String id, String password) {
        if (this.getID().equalsIgnoreCase(id) && this.getPassword().equals(password))
            return true;
        return false;
    }

    @Override
    public void changePassword(String pass) throws IOException {
        Library.chiefLibrarian.setPassword(pass);
        AdminBlock.updateLB();
    }
}
