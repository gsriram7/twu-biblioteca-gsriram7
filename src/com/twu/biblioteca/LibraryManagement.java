package com.twu.biblioteca;

import java.util.ArrayList;

public class LibraryManagement {
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private ArrayList<User> registeredUsers = new ArrayList<User>();
    private boolean isValidUser;
    private String currentUser;

    public LibraryManagement() {
        books.add(new Book("C","Dennis","1972",true));
        books.add(new Book("C++","Bjarne","1983",true));
        books.add(new Book("Java","Gosling","1995",true));
        books.add(new Book("Ruby","Matz","1995",true));
        books.add(new Book("Python","Rossum","1990",true));

        movies.add(new Movie("Inception","Nolan","2008","9",true));
        movies.add(new Movie("Terminator","Cameron","1995","N.A",true));
        movies.add(new Movie("Psycho","Hitchcock","1963","8",true));

        registeredUsers.add(new User("Selva","111","aaa","selvarag@tw.com","9487506994"));
        registeredUsers.add(new User("Sri","222","bbb","selvamailz@tce.edu","987654321"));
        registeredUsers.add(new User("Administrator","777","biblio","admin@biblio.com","9999999999"));
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

    public String bookCheckedOutBy(String bookName) {
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

    public String movieCheckedOutBy(String movieName) {
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

    public String viewUserInformation() {
        if (isValidUser) {
            for (User user : registeredUsers) {
                if(user.getName().equals(currentUser)){
                    return user.getInformation();
                }
            }
        }
        return "Please login to view information";
    }
}
