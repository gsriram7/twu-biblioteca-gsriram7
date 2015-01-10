package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    LibraryManagementSystem library;
    BibliotecaApp(){
        library = new LibraryManagementSystem();
    }

    public static void main(String[] args) {

        System.out.println(welcomeMessage());
        BibliotecaApp app = new BibliotecaApp();
        utility(app.library);

    }

    private static void utility(LibraryManagementSystem library) {
        Scanner kb = new Scanner(System.in);
        boolean toContinue = true;
        while(toContinue){
            System.out.print("1.List Books\n2.Check out\n3.Check in\n4.Quit\nEnter option: ");
            int option = kb.nextInt();
            kb.nextLine();
            switch (option){
                case 1:
                    System.out.println(library.list());
                    break;
                case 2:
                    System.out.print("Enter book to checkout: ");
                    System.out.println(library.checkOut(kb.nextLine()));
                    break;
                case 3:
                    System.out.print("Enter book to check in: ");
                    System.out.println(library.checkIn(kb.nextLine()));
                    break;
                case 4:
                    System.out.println(quit());
                    toContinue=false;
                    break;
                default:
                    System.out.println(invalidOptionMessage());
            }
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



