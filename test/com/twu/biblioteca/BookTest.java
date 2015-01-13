package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void shouldCheckListBooks() {
        String[] authors = {"Dennis","Bjarne", "Gosling", "Matz", "Rossum"};
        String[] names = {"C","C++", "Java", "Ruby", "Python"};
        String[] years = {"1972","1983", "1995", "1995", "1990"};

        String bookNames = "";
        for (int i = 0; i < names.length; i++) {
            bookNames += names[i] + "\t" + authors[i] + "\t" + years[i] + "\n";
        }
        assertEquals(bookNames,new LibraryManagement().listBooks());
    }

    @Test
    public void shouldCheckBookListAfterCheckOut() {
        String[] authors = {"Bjarne", "Matz", "Rossum"};
        String[] names = {"C++", "Ruby", "Python"};
        String[] years = {"1983","1995", "1990"};

        LibraryManagement libraryManagement = new LibraryManagement();
        libraryManagement.checkOutBook("C");
        libraryManagement.checkOutBook("Java");
        String bookNames = "";
        for (int i = 0; i < names.length; i++) {
            bookNames += names[i] + "\t" + authors[i] + "\t" + years[i] + "\n";
        }
        assertEquals(bookNames,libraryManagement.listBooks());
    }

    @Test
    public void shouldDisplayBookUnavailableMessage() {
        assertEquals("Item is not available", new LibraryManagement().checkOutBook("Perl"));
    }

    @Test
    public void shouldCheckBookAvailableMessage() {
        LibraryManagement session = new LibraryManagement();
        assertEquals("Thank you! Enjoy the book", session.checkOutBook("C"));
    }

    @Test
    public void shouldCheckBookUnvailableMessage() {
        LibraryManagement session = new LibraryManagement();
        assertEquals("Thank you! Enjoy the book", session.checkOutBook("C"));
        assertEquals("That book is not available", session.checkOutBook("C"));
    }

    @Test
    public void shouldCheckBookCheckInMessage() {
        LibraryManagement sesion = new LibraryManagement();
        sesion.checkOutBook("C");
        assertEquals("Thank you for returning the book", sesion.checkInBook("C"));
    }

    @Test
    public void shouldCheckBookAlreadyAvailableMessage() {
        assertEquals("This book is already available", new LibraryManagement().checkInBook("C"));
    }

    @Test
    public void shouldCheckValidityOfBookDuringCheckOut() {
        assertEquals("That is not a valid item to return", new LibraryManagement().checkInBook("Perl"));
    }

    @Test
    public void shouldCheckOutFromNoStock() {
        LibraryManagement session = new LibraryManagement();
        session.checkOutBook("C");
        session.checkOutBook("C++");
        session.checkOutBook("Java");
        session.checkOutBook("Python");
        session.checkOutBook("Ruby");
        assertEquals("Item is not available", session.checkOutBook("Pascal"));
    }

}
