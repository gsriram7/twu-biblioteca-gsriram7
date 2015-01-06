package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ExampleTest {

    @Test
    public void test() {

        String msg = "Hello user welcome to Biblioteca";
        assertSame(msg,new LibraryManagementSystem().getWelcomeMessage());
    }

    @Test
    public void test2() throws Exception {

    }
}
