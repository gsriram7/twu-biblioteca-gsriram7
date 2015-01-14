package com.twu.biblioteca;

public class User {
    String name;
    String libraryNumber;
    String password;
    String email;
    String phoneNumber;

    public User(String name, String libraryNumber, String password, String email, String phoneNumber) {
        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getInformation() {
        return name+"\t"+phoneNumber+"\t"+email;
    }
}
