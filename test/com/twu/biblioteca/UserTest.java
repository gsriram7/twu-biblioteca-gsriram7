package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void checkUserDetails(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","aaa");
        assertEquals("Selva\t9487506994\tselvarag@tw.com", session.viewUserInformation());
    }
}
