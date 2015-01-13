package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryManagement {
    private static final int NO_OF_BOOKS = 5;
    private static final int NO_OF_MOVIES = 3;
    private static final int NO_OF_USERS = 3;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private ArrayList<User> registeredUsers = new ArrayList<User>();
    private boolean isValidUser;
    private String currentUser;

    public LibraryManagement() {
        for (int i = 0; i < NO_OF_BOOKS; i++) {
            String[] years = {"1972", "1983", "1995", "1995", "1990"};
            String[] authors = {"Dennis", "Bjarne", "Gosling", "Matz", "Rossum"};
            String[] names = {"C", "C++", "Java", "Ruby", "Python"};
            books.add(new Book(names[i], authors[i], years[i], true));
        }

        for (int i = 0; i < NO_OF_MOVIES; i++) {
            String[] movieName = {"Inception", "Terminator", "Psycho"};
            String[] director = {"Nolan", "Cameron", "Hitchcock"};
            String[] yearReleased = {"2008", "1995", "1963"};
            String[] rating = {"9", "N.A", "8"};
            movies.add(new Movie(movieName[i], director[i], yearReleased[i], rating[i], true));
        }

        for (int i = 0; i < NO_OF_USERS; i++) {
            String[] names = {"Selva", "Sri", "Administrator"};
            String[] libraryNumber = {"111", "222", "777"};
            String[] passwords = {"aaa", "bbb", "biblio"};

            registeredUsers.add(new User(names[i], libraryNumber[i], passwords[i]));
        }
    }

    public String listBooks() {
        return new Library().list(books);
    }

    public String listMovies() {
        return new Library().list(movies);
    }

    public String checkOutBook(String bookName) {
        if (isValidUser) {
            return new Library().checkOut(bookName, books, currentUser);
        } else
            return "Please login";
    }

    public String checkOutMovie(String movieName) {
        if (isValidUser) {
            return new Library().checkOut(movieName, movies, currentUser);
        } else
            return "Please login";
    }

    public String checkInBook(String bookName) {
        if (isValidUser) {
            return new Library().checkIn(bookName, books);
        } else
            return "Please login";
    }

    public String checkInMovie(String movieName) {
        if (isValidUser) {
            return new Library().checkIn(movieName, movies);
        } else
            return "Please login";
    }

    public String login(String libraryNumber, String password) {
        for (User user : registeredUsers) {
            if (user.getLibraryNumber().equals(libraryNumber)) {
                isValidUser = user.validate(password);
                if (isValidUser) {
                    currentUser = user.getName();
                    return "Welcome " + user.getName();
                } else
                    return "Invalid credentials";
            }
        }
        return "Invalid credentials";
    }

    public String logout() {
        isValidUser = false;
        currentUser = null;
        return "You are logged out";
    }

    public boolean getIsValidUser() {
        return isValidUser;
    }

    public String bookPossessedBy(String bookName) {
        if (currentUser.equals("Administrator")) {
            for (Book book : books) {
                if (book.isTheSame(bookName)) {
                    if (book.getUserPossesing() != null) {
                        return book.getUserPossesing();
                    } else
                        return "No user possess the book currently";
                }
            }
            return "Invalid book name";
        } else if (isValidUser) {
            return "You are not privileged";
        } else
            return "Please login";
    }

    public String moviePossessedBy(String movieName) {
        if (currentUser.equals("Administrator")) {
            for (Movie movie : movies) {
                if (movie.isTheSame(movieName)) {
                    if (movie.getUserPossesing() != null) {
                        return movie.getUserPossesing();
                    } else
                        return "No user possess the movie currently";
                }
            }
            return "Invalid movie name";
        } else if (isValidUser) {
            return "You are not privileged";
        } else
            return "Please login";
    }
}
