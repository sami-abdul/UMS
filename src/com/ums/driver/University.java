package com.ums.driver;

import com.ums.buildings.*;
import com.ums.entities.Dean;
import com.ums.entities.Student;
import com.ums.entities.Teacher;

import java.io.IOException;

public class University {
    public AdminBlock adminBlock;
    public Library library;
    public UBIT ubit;
    public IBA iba;
    public Pharmacy pharmacy;

    public Student st;
    public Teacher tr;
    public Dean dn;

    public University() {
        try {
            adminBlock = new AdminBlock();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        library = new Library();
        ubit = new UBIT();
        iba = new IBA();
        pharmacy = new Pharmacy();

        st = new Student();
        tr = new Teacher();
        dn = new Dean();
    }
}