package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Hello, world!");
    }

    public static void utility(int option,String bookName){
        switch(option){
            case 1:
                System.out.println(welcomeMessage());
                break;
            case 2:
                LibraryManagementSystem library = new LibraryManagementSystem();
                library.checkOut(bookName);
                break;
            case 3:
                LibraryManagementSystem libraryCheckOut = new LibraryManagementSystem();
                libraryCheckOut.checkOut(bookName);
                break;
            case 4:
                System.out.println(quit());
                break;
            default:
                System.out.println(invalidOptionMessage());
        }
    }

    static String invalidOptionMessage() {
        return "Select a valid option!";
    }

    static String welcomeMessage() {
        return "Hello user welcome to Biblioteca";
    }

    static String quit() {
        return "Thank you for using Biblioteca";
    }
}



