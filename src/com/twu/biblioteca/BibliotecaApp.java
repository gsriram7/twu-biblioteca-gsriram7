package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    LibraryManagement library;

    BibliotecaApp() {
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
        while (toContinue) {
            if (!library.getIsValidUser()) {
                System.out.println("0.Login");
            } else {
                System.out.println("0.Logout\n10.View profile");
            }
            System.out.print("1.List Books\n2.Check out Book\n3.Check in Book\n4.List Movies\n5.Check out Movie\n6.Check in Movie\n7.View book checkout details\n8.View movie checkout details\n9.Quit\nEnter option: ");
            int option = kb.nextInt();
            kb.nextLine();
            switch (option) {
                case 0:
                    if (!library.getIsValidUser()) {
                        System.out.print("Enter library number: ");
                        String libraryNumber = kb.nextLine();
                        System.out.print("Enter password: ");
                        String password = kb.nextLine();
                        System.out.println(library.login(libraryNumber, password));
                    }
                    else {
                        System.out.println(library.logout());
                    }
                    break;
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
                case 7:
                    System.out.println("Enter book name to view checkout details");
                    System.out.println(library.bookPossessedBy(kb.nextLine()));
                    break;
                case 8:
                    System.out.println("Enter movie name to view checkout details");
                    System.out.println(library.moviePossessedBy(kb.nextLine()));
                    break;
                case 9:
                    System.out.println(quit());
                    toContinue = false;
                    break;
                case 10:
                    System.out.println(library.viewUserInformation());
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



