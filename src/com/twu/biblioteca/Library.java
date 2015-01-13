package com.twu.biblioteca;

import java.util.ArrayList;

class Library {

    private static final int NO_OF_BOOKS = 5;
    private static final int NO_OF_MOVIES = 3;
    private ArrayList<Item> books = new ArrayList<Item>();
    private ArrayList<Item> movies = new ArrayList<Item>();

    public Library() {
        for (int i = 0; i < NO_OF_BOOKS; i++) {
            String[] years = {"1972", "1983", "1995", "1995", "1990"};
            String[] authors = {"Dennis", "Bjarne", "Gosling", "Matz", "Rossum"};
            String[] names = {"C", "C++", "Java", "Ruby", "Python"};
            books.add(new Book(names[i], authors[i], years[i], true));
        }

        for(int i=0;i< NO_OF_MOVIES;i++){
            String[] movieName = {"Inception","Terminator","Psycho"};
            String[] director = {"Nolan","Cameron","Hitchcock"};
            String[] yearReleased = {"2008","1995","1963"};
            String[] rating = {"9","N.A","8"};
            movies.add(new Movie(movieName[i],director[i],yearReleased[i],rating[i],true));
        }
    }

    public String list() {
        String bookNameList="";
        for (Item book : books) {
            if (book.isAvailable()) {
                bookNameList += book.getInformation();
            }
        }
        return bookNameList;
    }


    public String checkOut(String bookName) {
        for (Item book : books) {
            if (book.isTheSame(bookName)) {
                if (book.isAvailable()) {
                    book.setAvailability(false);
                    return "Thank you! Enjoy the book";
                } else {
                    return "That book is not available";
                }
            }
        }
        return "That book is not available";
    }


    public String checkIn(String bookName) {
        for (Item book : books) {
            if (book.isTheSame(bookName)) {
                if (!book.isAvailable()) {
                    book.setAvailability(true);
                    return "Thank you for returning the book";
                } else {
                    return "This book is already available";
                }
            }
        }
        return "That is not a valid book to return";
    }

    public String listMovies() {
        String moviesInformation="";
        for(Item movie: movies){
            if(movie.isAvailable()) {
                moviesInformation += movie.getInformation();
            }
        }
        return moviesInformation;
    }

    public String checkOutMovie(String movieName) {
        for(Item movie: movies){
            if(movie.isTheSame(movieName)){
                if(movie.isAvailable()){
                    movie.setAvailability(false);
                    return "Thank you! Enjoy the movie";
                }
                return "That movie is not available";
            }
        }
        return "That movie is not available";
    }

    public String checkInMovie(String movieName) {
        for(Item movie: movies){
            if(movie.isTheSame(movieName)){
                if(!movie.isAvailable()){
                    movie.setAvailability(true);
                    return "Thank you for returning the movie";
                }
                return "This movie is already available";
            }
        }
        return "That is not a valid movie to return";
    }
}