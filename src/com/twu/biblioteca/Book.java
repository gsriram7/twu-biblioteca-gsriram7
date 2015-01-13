package com.twu.biblioteca;

class Book extends Item {

    private String author;

    public Book(String name, String author, String yearPublished, boolean availability) {
        super(name, yearPublished, availability);
        this.author = author;
    }

    @Override
    public String list() {
        if (availability) {
            return getInformation();
        }
        return "";
    }

    @Override
    public String checkOut(String bookName, String currentUser) {
        if (isTheSame(bookName)) {
            if (availability) {
                this.availability = false;
                super.setUserPossesing(currentUser);
                return "Thank you! Enjoy the book";
            } else {
                return "That book is not available";
            }
        }
        return null;
    }

    @Override
    public String checkIn(String itemName) {
        if(isTheSame(itemName)){
            if(!availability){
                this.availability = true;
                super.setUserPossesing(null);
                return "Thank you for returning the book";
            }
            else {
                return "This book is already available";
            }
        }
        return null;
    }

    public boolean isTheSame(String itemName) {
        return name.equals(itemName);
    }

    public String getInformation() {
        return name + "\t" + author + "\t" + yearReleased + "\n";
    }

}
