package com.twu.biblioteca;

public class Movie extends Item {

    private String director;
    private String rating;

    public Movie(String name, String director, String yearReleased, String rating, boolean availability) {
        super(name, yearReleased, availability);
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String list() {
        if (availability) {
            return getInformation();
        }
        return "";
    }

    @Override
    public String checkOut(String movieName) {
        if (movieName.equals(name)) {
            if (availability) {
                this.availability = false;
                return "Thank you! Enjoy the movie";
            } else {
                return "That movie is not available";
            }
        }
        return null;
    }

    @Override
    public String checkIn(String itemName) {
        if(itemName.equals(name)){
            if(!availability){
                this.availability = true;
                return "Thank you for returning the movie";
            }
            else {
                return "This movie is already available";
            }
        }
        return null;
    }

    public String getInformation() {
        return name + "\t" + director + "\t" + yearReleased + "\t" + rating + "\n";
    }

}
