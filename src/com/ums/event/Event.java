package com.ums.event;

import java.util.GregorianCalendar;

public class Event {

    private GregorianCalendar event;
    private String name;

    public Event() {
        this.event = new GregorianCalendar();
    }

    public void setEvent(String name, int year, int month, int date, int hour, int minutes) {
        this.event.set(year, month, date, hour, minutes);
        setEventName(name);
    }

    public String getEventName() {
        return name;
    }

    public void setEventName(String name) {
        this.name = name;
    }
}
