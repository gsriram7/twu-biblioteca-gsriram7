package com.twu.biblioteca;

public class Movie extends Item{

    private String director;
    private String rating;

    public Movie(String name, String director, String yearReleased, String rating,boolean availability) {
        super(name,yearReleased,availability);
        this.director = director;
        this.rating = rating;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getInformation() {
        return name+"\t"+director+"\t"+yearReleased+"\t"+rating+"\n";
    }

    public boolean isTheSame(String movieName) {
        return movieName.equals(name);
    }

    public boolean isAvailable() {
        return availability;
    }
}
