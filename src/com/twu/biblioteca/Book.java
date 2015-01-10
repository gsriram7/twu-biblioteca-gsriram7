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
        this.name = b.getName();
        this.author = b.getAuthor();
        this.yearPublished = b.getYearPublished();
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public short getYearPublished() {
        return yearPublished;
    }

    public String getBookInforrmation() {
        return name+"\t"+author+"\t"+yearPublished+"\n";
    }


}
