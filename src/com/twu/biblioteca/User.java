package com.twu.biblioteca;

public class User {
    String name;
    String libraryNumber;
    String password;

    public User(String name, String libraryNumber, String password) {
        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean validate(String password) {
        return this.password.equals(password);
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getName() {
        return name;
    }
}
