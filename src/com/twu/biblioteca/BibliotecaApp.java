package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    LibraryManagement libraryManagement;

    BibliotecaApp() {
        libraryManagement = new LibraryManagement();
    }

    public static void main(String[] args) {

        System.out.println(welcomeMessage());
        BibliotecaApp app = new BibliotecaApp();
        app.utility();

    }

    private void utility() {
        Scanner kb = new Scanner(System.in);
        boolean toContinue = true;
        while (toContinue) {
            if (!libraryManagement.getIsValidUser()) {
                System.out.println("0.Login");
            } else {
                System.out.println("0.Logout\n10.View profile");
            }
            System.out.print("1.List Books\n2.Check out Book\n3.Check in Book\n4.List Movies\n5.Check out Movie\n6.Check in Movie\n7.View book checkout details\n8.View movie checkout details\n9.Quit\nEnter option: ");
            int option = kb.nextInt();
            kb.nextLine();
            switch (option) {
                case 0:
                    if (!libraryManagement.getIsValidUser()) {
                        System.out.print("Enter libraryManagement number: ");
                        String libraryNumber = kb.nextLine();
                        System.out.print("Enter password: ");
                        String password = kb.nextLine();
                        System.out.println(libraryManagement.login(libraryNumber, password));
                    }
                    else {
                        System.out.println(libraryManagement.logout());
                    }
                    break;
                case 1:
                    System.out.println(libraryManagement.listBooks());
                    break;
                case 2:
                    System.out.print("Enter book to checkout: ");
                    System.out.println(libraryManagement.checkOutBook(kb.nextLine()));
                    break;
                case 3:
                    System.out.print("Enter book to check in: ");
                    System.out.println(libraryManagement.checkInBook(kb.nextLine()));
                    break;
                case 4:
                    System.out.println(libraryManagement.listMovies());
                    break;
                case 5:
                    System.out.print("Enter movie to checkout: ");
                    System.out.println(libraryManagement.checkOutMovie(kb.nextLine()));
                    break;
                case 6:
                    System.out.print("Enter movie to check in: ");
                    System.out.println(libraryManagement.checkInMovie(kb.nextLine()));
                    break;
                case 7:
                    System.out.println("Enter book name to view checkout details");
                    System.out.println(libraryManagement.bookCheckedOutBy(kb.nextLine()));
                    break;
                case 8:
                    System.out.println("Enter movie name to view checkout details");
                    System.out.println(libraryManagement.movieCheckedOutBy(kb.nextLine()));
                    break;
                case 9:
                    System.out.println(quit());
                    toContinue = false;
                    break;
                case 10:
                    System.out.println(libraryManagement.viewUserInformation());
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



