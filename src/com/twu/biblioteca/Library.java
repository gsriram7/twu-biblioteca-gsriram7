package com.twu.biblioteca;

import java.util.ArrayList;

class Library {

    private static final int NO_OF_BOOKS = 5;
    private ArrayList<Book> inStock2 = new ArrayList<Book>();

    public Library() {
        for (int i = 0; i < NO_OF_BOOKS; i++) {
            short[] years = {1972, 1983, 1995, 1995, 1990};
            String[] authors = {"Dennis", "Bjarne", "Gosling", "Matz", "Rossum"};
            String[] names = {"C", "C++", "Java", "Ruby", "Python"};
            inStock2.add(new Book(names[i],authors[i],years[i],true));
        }
    }

    public String list() {
        String bookNameList="";
        for (Book anInStock2 : inStock2) {
            if (anInStock2.getIsAvailable()) {
                bookNameList += anInStock2.getBookInformation();
            }
        }
        return bookNameList;
    }


    public String checkOut(String bookName) {
        for (Book anInStock2 : inStock2) {
            if (anInStock2.isTheSame(bookName)) {
                if (anInStock2.getIsAvailable()) {
                    anInStock2.setAvailable(false);
                    return "Thank you! Enjoy the book";
                } else {
                    return "That book is not available";
                }
            }
        }
        return "That book is not available";
    }


    public String checkIn(String book) {
        for (Book anInStock2 : inStock2) {
            if (anInStock2.isTheSame(book)) {
                if (!anInStock2.getIsAvailable()) {
                    anInStock2.setAvailable(true);
                    return "Thank you for returning the book";
                } else {
                    return "This book is already available";
                }
            }
        }
        return "That is not a valid book to return";
    }

}