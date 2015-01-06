package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Hello, world!");
    }
}

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

}

class LibraryManagementSystem {

    private final int NO_OF_BOOKS = 5;
    private Book[] inStock = new Book[NO_OF_BOOKS];
    private String[] names = {"C prog", "C++ prog", "Java prog", "Ruby prog", "Python prog"};
    private String[] authors = {"Dennis Ritchie", "Bjarne Stroustrup", "James Gosling", "Matz", "Guido van Rossum"};
    private short[] years = {1972, 1983, 1995, 1995, 1990};
    boolean[] index;
    public static int booksAvailable;

    public LibraryManagementSystem() {
        booksAvailable = NO_OF_BOOKS;
        index = new boolean[NO_OF_BOOKS];
        Book temp;
        for (int i = 0; i < NO_OF_BOOKS; i++) {
            temp = new Book(names[i], authors[i], years[i]);
            inStock[i] = new Book(temp);
            index[i] = true;
            temp = null;
        }
    }

    public int getNO_OF_BOOKS() {
        return NO_OF_BOOKS;
    }

    public static int getBooksAvailable() {
        return booksAvailable;
    }

    public String getWelcomeMessage() {
        return "Hello user welcome to Biblioteca";
    }
}