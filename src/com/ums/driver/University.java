package com.ums.driver;

import com.ums.buildings.*;
import com.ums.entities.Dean;
import com.ums.entities.Student;
import com.ums.entities.Teacher;

import java.io.IOException;

public class University {

    public static Building[] buildingList;

    public AdminBlock adminBlock;
    public Library library;
    public UBIT ubit;
    public KUBS kubs;
    public Pharmacy pharmacy;

    public Student st;
    public Teacher tr;
    public Dean dn;

    static {
        buildingList = new Building[5];
    }

    public University() {
        try {
            adminBlock = new AdminBlock();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        library = new Library();
        ubit = new UBIT();
        kubs = new KUBS();
        pharmacy = new Pharmacy();

        buildingList[0] = adminBlock;
        buildingList[1] = library;
        buildingList[2] = ubit;
        buildingList[3] = kubs;
        buildingList[4] = pharmacy;

        st = new Student();
        tr = new Teacher();
        dn = new Dean();
    }
}