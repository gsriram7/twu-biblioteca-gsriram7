package com.twu.biblioteca;

/**
 * Created by selvaram on 1/10/15.
 */
class Book {
    private String name;
    private String author;
    private short yearPublished;

    public Book(String name, String author, short yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public Book(Book b) {
        this.name = b.name;
        this.author = b.author;
        this.yearPublished = b.yearPublished;
    }

    public String getBookInformation() {
        return name+"\t"+author+"\t"+yearPublished+"\n";
    }

    public boolean isTheSame(String book){
        if(name.equals(book))
            return true;
        else
            return false;
    }


}
