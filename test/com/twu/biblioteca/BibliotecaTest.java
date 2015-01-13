package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaTest {

    @Test
    public void shouldCheckWelcomeMessage() {
        String msg = "Hello user welcome to Biblioteca";
        assertSame(msg, BibliotecaApp.welcomeMessage());
    }

    @Test
    public void shouldCheckListBooks() {
        String[] authors = {"Dennis","Bjarne", "Gosling", "Matz", "Rossum"};
        String[] names = {"C","C++", "Java", "Ruby", "Python"};
        short[] years = {1972,1983, 1995, 1995, 1990};

        String bookNames = "";
        for (int i = 0; i < names.length; i++) {
            bookNames += names[i] + "\t" + authors[i] + "\t" + years[i] + "\n";
        }
        assertEquals(bookNames, new Library().list());
    }

    @Test
    public void shouldDisplayBookUnavailableMessage() {
        assertEquals("That book is not available", new Library().checkOut("Perl"));
    }

    @Test
    public void shouldCheckBookAvailableMessage() {
        Library session = new Library();
        assertEquals("Thank you! Enjoy the book", session.checkOut("C"));
    }

    @Test
    public void shouldCheckBookUnvailableMessage() {
        Library session = new Library();
        assertEquals("Thank you! Enjoy the book", session.checkOut("C"));
        assertEquals("That book is not available", session.checkOut("C"));
    }

    @Test
    public void shouldCheckBookCheckInMessage() {
        Library sesion = new Library();
        sesion.checkOut("C");
        assertEquals("Thank you for returning the book", sesion.checkIn("C"));
    }

    @Test
    public void shouldCheckBookAlreadyAvailableMessage() {
        assertEquals("This book is already available", new Library().checkIn("C"));
    }

    @Test
    public void shouldCheckValidityOfBookDuringCheckOut() {
        assertEquals("That is not a valid book to return", new Library().checkIn("Perl"));
    }

    @Test
    public void shouldCheckOutFromNoStock() {
        Library session = new Library();
        session.checkOut("C");
        session.checkOut("C++");
        session.checkOut("Java");
        session.checkOut("Python");
        session.checkOut("Ruby");
        assertEquals("That book is not available", session.checkOut("Pascal"));
    }

    @Test
    public void shouldCheckQuitMessage() {
        assertEquals("Thank you for using Biblioteca", BibliotecaApp.quit());
    }

    @Test
    public void shouldCheckInvalidOptionMessage() {
        assertEquals("Select a valid option!", BibliotecaApp.invalidOptionMessage());
    }
}
