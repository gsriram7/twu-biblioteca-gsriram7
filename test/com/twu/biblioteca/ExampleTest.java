package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTest {

    String[] authors = {"Dennis", "Bjarne", "Gosling", "Matz", "Rossum"};
    String[] names = {"C", "C++", "Java", "Ruby", "Python"};
    short[] years = {1972, 1983, 1995, 1995, 1990};

    @Test
    public void welcomeMessageTest() {

        String msg = "Hello user welcome to Biblioteca";
        assertSame(msg, new LibraryManagementSystem().getWelcomeMessage());
    }

    @Test
    public void shouldCheckListBooks() {
        String bookNames = "";
        for (int i = 0; i < names.length; i++) {
            bookNames += names[i] + "\t" + authors[i] + "\t" + years[i] + "\n";
        }
        assertEquals(bookNames, new LibraryManagementSystem().list());
    }

    @Test
    public void shouldDisplayBookUnavailableMessage() {
        assertEquals("That book is not available", new LibraryManagementSystem().checkOut("Perl"));
    }

    @Test
    public void shouldCheckBookAvailableMessage() {
        LibraryManagementSystem session1 = new LibraryManagementSystem();
        assertEquals("Thank you! Enjoy the book", session1.checkOut("C"));
    }

    @Test
    public void shouldCheckBookUnvailableMessage() {
        LibraryManagementSystem session1 = new LibraryManagementSystem();
        assertEquals("Thank you! Enjoy the book", session1.checkOut("C"));
        assertEquals("That book is not available", session1.checkOut("C"));
    }

    @Test
    public void shouldCheckBookCheckInMessage(){
        LibraryManagementSystem session1 = new LibraryManagementSystem();
        session1.checkOut("C");
        assertEquals("Thank you for returning the book",session1.checkIn("C"));
    }

    @Test
    public void shouldCheckBookAlreadyAvailableMessage(){
        assertEquals("This book is already available",new LibraryManagementSystem().checkIn("C"));
    }

    @Test
    public void shouldCheckValidityOfBookDuringCheckOut(){
        assertEquals("That is not a valid book to return",new LibraryManagementSystem().checkIn("Perl"));
    }
}
