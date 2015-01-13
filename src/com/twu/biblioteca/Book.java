package com.twu.biblioteca;

class Book extends Item{

    private String author;

    public Book(String name, String author, String yearPublished, boolean availability) {
        super(name,yearPublished,availability);
        this.author = author;
    }

    public void setAvailability(boolean isAvailable) {
        this.availability = isAvailable;
    }

    public String getInformation() {
        return name+"\t"+author+"\t"+yearReleased+"\n";
    }

    public boolean isTheSame(String book){
        return name.equals(book);
    }

    public boolean isAvailable(){
        return availability;
    }

}
