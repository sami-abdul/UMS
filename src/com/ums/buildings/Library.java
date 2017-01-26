package com.ums.buildings;

import com.ums.entities.ChiefLibrarian;
import com.ums.event.Event;

import java.io.IOException;

public class Library extends Building {

    public static final String DEFAULT_TIME;
    public static String time;

    public static ChiefLibrarian chiefLibrarian;
    public static int numOfLibrarians;
    public static int numOfBooks;

    public static Event event;

    static {
        try {
            chiefLibrarian = AdminBlock.makeLB();
        } catch (IOException e) {
            e.printStackTrace();
        }
        numOfLibrarians = 10;
        numOfBooks = 1000;

        DEFAULT_TIME = "8:30";
        time = DEFAULT_TIME;

        event = new Event();
    }

    public Library() {
        super("lb100", "Mehmud Hasan Library");
    }

    public static void setEvent(String name, int year, int month, int date, int hour, int minutes) {
        Library.event.setEvent(name, year, month, date, hour, minutes);
        event.setEventName("Book Fair");
    }

    public int getNumOfLibrarians() {
        return Library.numOfLibrarians;
    }

    public void setNumOfLibrarians(int numOfLibrarians) {
        Library.numOfLibrarians = numOfLibrarians;
    }

    public int getNumOfBooks() {
        return Library.numOfBooks;
    }

    public void setNumOfBooks(int numOfBooks) {
        Library.numOfBooks = numOfBooks;
    }

    public String getDefaultTime() {
        return Library.DEFAULT_TIME;
    }

    public String getTime() {
        return Library.time;
    }
}
