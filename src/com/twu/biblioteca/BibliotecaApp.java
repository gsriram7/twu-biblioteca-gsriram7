package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Hello, world!");
    }

    public static void utility(int option,String bookName){
        switch(option){
            case 1:
                new LibraryManagementSystem().list();
                break;
            case 2:
                LibraryManagementSystem library = new LibraryManagementSystem();
                library.checkOut(bookName);
                break;
            case 3:
                LibraryManagementSystem libraryCheckOut = new LibraryManagementSystem();
                libraryCheckOut.checkOut(bookName);
                break;
        }
    }
}



