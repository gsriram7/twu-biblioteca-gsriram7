package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryManagement {
    private static final int NO_OF_BOOKS = 5;
    private static final int NO_OF_MOVIES = 3;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();

    public LibraryManagement() {
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

    public String listBooks(){
       return new Library().list(books);
    }

    public String listMovies(){
        return new Library().list(movies);
    }

    public String checkOutBook(String bookName){
        return new Library().checkOut(bookName,books);
    }

    public String checkOutMovie(String movieName){
        return new Library().checkOut(movieName, movies);
    }

    public String checkInBook(String bookName){
        return new Library().checkIn(bookName, books);
    }

    public String checkInMovie(String movieName){
        return new Library().checkIn(movieName, movies);
    }
}
