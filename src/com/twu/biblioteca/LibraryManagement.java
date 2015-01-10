package com.twu.biblioteca;

class LibraryManagementSystem {

    private final int NO_OF_BOOKS=5;
    private Book[] inStock = new Book[NO_OF_BOOKS];
    boolean[] isBookAvailable;
    public static int booksAvailable;

    public LibraryManagementSystem() {
        booksAvailable = NO_OF_BOOKS;
        isBookAvailable = new boolean[NO_OF_BOOKS];
        Book temp;
        for (int i = 0; i < NO_OF_BOOKS; i++) {
            short[] years = {1972, 1983, 1995, 1995, 1990};
            String[] authors = {"Dennis", "Bjarne", "Gosling", "Matz", "Rossum"};
            String[] names = {"C", "C++", "Java", "Ruby", "Python"};
            temp = new Book(names[i], authors[i], years[i]);
            inStock[i] = new Book(temp);
            isBookAvailable[i] = true;
        }
    }

    public String list() {
        String bookNameList="";
        for (int i = 0; i < inStock.length; i++) {
            Book names = inStock[i];
            if(isBookAvailable[i]) {
                bookNameList += names.getBookInformation();
            }
        }
        return bookNameList;
    }

    public String checkOut(String bookName) {
        for(int i=0;i<NO_OF_BOOKS;i++){
            if(inStock[i].isTheSame(bookName)){
                if(isBookAvailable[i]){
                    isBookAvailable[i] = false;
                    booksAvailable--;
                    return  "Thank you! Enjoy the book";
                }
                else{
                    return "That book is not available";
                }
            }
        }
        return "That book is not available";
    }

    public String checkIn(String book) {
        for(int i=0;i<NO_OF_BOOKS;i++){
            if(inStock[i].isTheSame(book)){
                if(!isBookAvailable[i]){
                    isBookAvailable[i] = true;
                    booksAvailable++;
                    return "Thank you for returning the book";
                }
                else{
                    return "This book is already available";
                }
            }
        }
        return "That is not a valid book to return";
    }

}