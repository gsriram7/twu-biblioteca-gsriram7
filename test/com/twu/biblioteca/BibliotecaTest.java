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
    public void shouldCheckQuitMessage() {
        assertEquals("Thank you for using Biblioteca", BibliotecaApp.quit());
    }

    @Test
    public void shouldCheckInvalidOptionMessage() {
        assertEquals("Select a valid option!", BibliotecaApp.invalidOptionMessage());
    }

}
