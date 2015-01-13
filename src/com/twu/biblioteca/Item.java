package com.twu.biblioteca;

public abstract class Item {
    protected String name;
    protected boolean availability;
    protected String yearReleased;

    public Item(String name, String yearReleased, boolean availability) {
        this.name = name;
        this.availability = availability;
        this.yearReleased = yearReleased;
    }

    abstract public String getInformation();

    abstract public String list();

    abstract public String checkOut(String itemName);

    abstract public String checkIn(String itemName);

}
