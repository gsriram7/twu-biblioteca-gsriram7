package com.twu.biblioteca;

public class Item {
    protected String name;
    protected boolean availability;
    protected String yearReleased;

    public Item(String name, String yearReleased, boolean availability) {
        this.name = name;
        this.availability = availability;
        this.yearReleased = yearReleased;
    }

    protected boolean isAvailable(){
        return true;
    }

    public String getInformation() {
        return null;
    }

    public boolean isTheSame(String bookName) {
        return false;
    }

    public void setAvailability(boolean b) {
    }

}
