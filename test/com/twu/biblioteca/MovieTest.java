package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldCheckListMovies(){
        String[] movieName = {"Inception","Terminator","Psycho"};
        String[] director = {"Nolan","Cameron","Hitchcock"};
        String[] yearReleased = {"2008","1995","1963"};
        String[] rating = {"9","N.A","8"};

        String movieInformation = "";
        for(int i=0;i<movieName.length;i++){
            movieInformation += movieName[i]+"\t"+director[i]+"\t"+yearReleased[i]+"\t"+rating[i]+"\n";
        }
        assertEquals(movieInformation,new LibraryManagement().listMovies());
    }

    @Test
    public void shouldCheckMovieListAfterCheckOut(){
        String[] movieName = {"Inception","Terminator"};
        String[] director = {"Nolan","Cameron"};
        String[] yearReleased = {"2008","1995"};
        String[] rating = {"9","N.A"};

        LibraryManagement libraryManagement = new LibraryManagement();
        libraryManagement.checkOutMovie("Psycho");
        String movieInformation = "";
        for(int i=0;i<movieName.length;i++){
            movieInformation += movieName[i]+"\t"+director[i]+"\t"+yearReleased[i]+"\t"+rating[i]+"\n";
        }
        assertEquals(movieInformation,libraryManagement.listMovies());
    }

    @Test
    public void shoudCheckMovieUnavailableMessage(){
        LibraryManagement session = new LibraryManagement();
        assertEquals("Item is not available",session.checkOutMovie("Titanic"));
    }

    @Test
    public void shouldCheckValidMovieCheckOut(){
        LibraryManagement session = new LibraryManagement();
        assertEquals("Thank you! Enjoy the movie",session.checkOutMovie("Inception"));
    }

    @Test
    public void shouldCheckMovieUnavailability(){
        LibraryManagement session = new LibraryManagement();
        assertEquals("Thank you! Enjoy the movie",session.checkOutMovie("Inception"));
        assertEquals("That movie is not available",session.checkOutMovie("Inception"));
    }

    @Test
    public void shouldCheckInMovie(){
        LibraryManagement session = new LibraryManagement();
        session.checkOutMovie("Inception");
        assertEquals("Thank you for returning the movie", session.checkInMovie("Inception"));
    }

    @Test
    public void shouldValidMovieCheckIn(){
        LibraryManagement session = new LibraryManagement();
        assertEquals("That is not a valid item to return",session.checkInMovie("Titanic"));
    }

    @Test
    public void shouldCheckMultipleCheckIn(){
        LibraryManagement session = new LibraryManagement();
        assertEquals("This movie is already available",session.checkInMovie("Inception"));
    }
}
