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

        LibraryManagement session = new LibraryManagement();
        session.login("111","aaa");
        session.checkOutMovie("Psycho");
        String movieInformation = "";
        for(int i=0;i<movieName.length;i++){
            movieInformation += movieName[i]+"\t"+director[i]+"\t"+yearReleased[i]+"\t"+rating[i]+"\n";
        }
        assertEquals(movieInformation, session.listMovies());
    }

    @Test
    public void shoudCheckMovieUnavailableMessage(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","aaa");
        assertEquals("Item is not available",session.checkOutMovie("Titanic"));
    }

    @Test
    public void shouldCheckValidMovieCheckOut(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","aaa");
        assertEquals("Thank you! Enjoy the movie",session.checkOutMovie("Inception"));
    }

    @Test
    public void shouldCheckMovieUnavailability(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","aaa");
        assertEquals("Thank you! Enjoy the movie",session.checkOutMovie("Inception"));
        assertEquals("That movie is not available",session.checkOutMovie("Inception"));
    }

    @Test
    public void shouldCheckInMovie(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","aaa");
        session.checkOutMovie("Inception");
        assertEquals("Thank you for returning the movie", session.checkInMovie("Inception"));
    }

    @Test
    public void shouldValidMovieCheckIn(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","aaa");
        assertEquals("That is not a valid item to return",session.checkInMovie("Titanic"));
    }

    @Test
    public void shouldCheckMultipleCheckIn(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","aaa");
        assertEquals("This movie is already available",session.checkInMovie("Inception"));
    }

    @Test
    public void shouldCheckOutUsingInvalidLibraryNumber(){
        LibraryManagement session = new LibraryManagement();
        session.login("555","aaa");
        assertEquals("Please login", session.checkOutMovie("Inception"));
    }

    @Test
    public void shouldCheckOutUsingInvalidPassword(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","bbb");
        assertEquals("Please login", session.checkOutMovie("Inception"));
    }

    @Test
    public void shouldCheckInUsingInvalidLibraryNumber(){
        LibraryManagement session = new LibraryManagement();
        session.login("555","aaa");
        assertEquals("Please login", session.checkInMovie("Inception"));
    }

    @Test
    public void shouldCheckInUsingInvalidPassword(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","bbb");
        assertEquals("Please login", session.checkInMovie("Inception"));
    }

    @Test
    public void shouldCheckCheckOutAfterLogout(){
        LibraryManagement session = new LibraryManagement();
        session.login("111","aaa");
        assertEquals("Thank you! Enjoy the movie",session.checkOutMovie("Inception"));
        session.logout();
        assertEquals("Please login",session.checkOutMovie("Psycho"));
    }

    @Test
    public void checkUserWhoCheckedOutMovie() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        session.checkOutMovie("Inception");
        session.logout();
        session.login("777","biblio");
        assertEquals("Selva", session.moviePossessedBy("Inception"));
    }

    @Test
    public void checkUnprivilegedAccessToViewUserPossessionOfMovie() {
        LibraryManagement session = new LibraryManagement();
        session.login("111", "aaa");
        session.checkOutMovie("Inception");
        session.logout();
        session.login("222","bbb");
        assertEquals("You are not privileged", session.moviePossessedBy("Inception"));
    }
}
