package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ExampleTest {

    @Test
    public void welcomeMessageTest() {

        String msg = "Hello user welcome to Biblioteca";
        assertSame(msg,new LibraryManagementSystem().getWelcomeMessage());
    }

    @Test
    public void test2() throws Exception {

    }

    @Test
    public void test3() throws Exception {


    }
}
