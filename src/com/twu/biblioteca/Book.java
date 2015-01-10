package com.twu.biblioteca;

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
        return name.equals(book);
    }


}
