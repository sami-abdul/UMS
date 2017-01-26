package com.ums.buildings;

public abstract class Building {
    protected String id;
    protected String name;

    public Building(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nBuilding ID: " + this.id + "Name: " + this.name;
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
}