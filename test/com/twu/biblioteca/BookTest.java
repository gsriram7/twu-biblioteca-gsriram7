package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void shouldCheckListBooks() {
        String[] authors = {"Dennis", "Bjarne", "Gosling", "Matz", "Rossum"};
        String[] names = {"C", "C++", "Java", "Ruby", "Python"};
        String[] years = {"1972", "1983", "1995", "1995", "1990"};

        String bookNames = "";
        for (int i = 0; i < names.length; i++) {
            bookNames += names[i] + "\t" + authors[i] + "\t" + years[i] + "\n";
        }
        assertEquals(bookNames, new LibraryManagement().listBooks());
    }

    @Test
    public void shouldCheckBookListAfterCheckOut() {
        String[] authors = {"Bjarne", "Matz", "Rossum"};
        String[] names = {"C++", "Ruby", "Python"};
        String[] years = {"1983", "1995", "1990"};

        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        session.checkOutBook("C");
        session.checkOutBook("Java");
        String bookNames = "";
        for (int i = 0; i < names.length; i++) {
            bookNames += names[i] + "\t" + authors[i] + "\t" + years[i] + "\n";
        }
        assertEquals(bookNames, session.listBooks());
    }

    @Test
    public void shouldDisplayBookUnavailableMessage() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        assertEquals("Item is not available", session.checkOutBook("Perl"));
    }

    @Test
    public void shouldCheckBookAvailableMessage() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        assertEquals("Thank you! Enjoy the book", session.checkOutBook("C"));
    }

    @Test
    public void shouldCheckBookUnvailableMessage() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        assertEquals("Thank you! Enjoy the book", session.checkOutBook("C"));
        assertEquals("That book is not available", session.checkOutBook("C"));
    }

    @Test
    public void shouldCheckBookCheckInMessage() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        session.checkOutBook("C");
        assertEquals("Thank you for returning the book", session.checkInBook("C"));
    }

    @Test
    public void shouldCheckBookAlreadyAvailableMessage() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        assertEquals("This book is already available", session.checkInBook("C"));
    }

    @Test
    public void shouldCheckValidityOfBookDuringCheckIn() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        assertEquals("That is not a valid item to return", session.checkInBook("Perl"));
    }

    @Test
    public void shouldCheckOutFromNoStock() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        session.checkOutBook("C");
        session.checkOutBook("C++");
        session.checkOutBook("Java");
        session.checkOutBook("Python");
        session.checkOutBook("Ruby");
        assertEquals("Item is not available", session.checkOutBook("Pascal"));
    }

    @Test
    public void shouldCheckCheckOutUsingInvalidPassword() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "bbb");
        assertEquals("Please login", session.checkOutBook("C"));
    }

    @Test
    public void shouldCheckCheckOutUsingInvalidLibraryNumber() {
        LibraryManagement session = new LibraryManagement();
        session.login("555", "aaa");
        assertEquals("Please login", session.checkOutBook("C"));
    }

    @Test
    public void shouldCheckCheckInUsingInvalidPassword() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "bbb");
        assertEquals("Please login", session.checkInBook("C"));
    }

    @Test
    public void shouldCheckCheckInUsingInvalidLibraryNumber() {
        LibraryManagement session = new LibraryManagement();
        session.login("555", "aaa");
        assertEquals("Please login", session.checkInBook("C"));
    }

    @Test
    public void shouldCheckCheckOutAfterLogout() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        assertEquals("Thank you! Enjoy the book", session.checkOutBook("C"));
        session.logout();
        assertEquals("Please login", session.checkOutBook("C++"));
    }

}
