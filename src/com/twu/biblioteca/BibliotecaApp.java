package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    LibraryManagement library;
    BibliotecaApp(){
        library = new LibraryManagement();
    }

    public static void main(String[] args) {

        System.out.println(welcomeMessage());
        BibliotecaApp app = new BibliotecaApp();
        utility(app.library);

    }

    private static void utility(LibraryManagement library) {
        Scanner kb = new Scanner(System.in);
        boolean toContinue = true;
        while(toContinue){
            System.out.print("1.List Books\n2.Check out Book\n3.Check in Book\n4.List Movies\n5.Check out Movie\n6.Check in Movie\n9.Quit\nEnter option: ");
            int option = kb.nextInt();
            kb.nextLine();
            switch (option){
                case 1:
                    System.out.println(library.listBooks());
                    break;
                case 2:
                    System.out.print("Enter book to checkout: ");
                    System.out.println(library.checkOutBook(kb.nextLine()));
                    break;
                case 3:
                    System.out.print("Enter book to check in: ");
                    System.out.println(library.checkInBook(kb.nextLine()));
                    break;
                case 4:
                    System.out.println(library.listMovies());
                    break;
                case 5:
                    System.out.print("Enter movie to checkout: ");
                    System.out.println(library.checkOutMovie(kb.nextLine()));
                    break;
                case 6:
                    System.out.print("Enter movie to check in: ");
                    System.out.println(library.checkInMovie(kb.nextLine()));
                    break;
                case 9:
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



