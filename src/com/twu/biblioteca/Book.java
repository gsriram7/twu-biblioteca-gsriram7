package com.twu.biblioteca;

class Book {
    private String name;
    private String author;
    private short yearPublished;
    private boolean isAvailable;

    public Book(String name, String author, short yearPublished, boolean isAvailable) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isAvailable = isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getBookInformation() {
        return name+"\t"+author+"\t"+yearPublished+"\n";
    }

    public boolean isTheSame(String book){
        return name.equals(book);
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

}
