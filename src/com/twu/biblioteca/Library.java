package com.twu.biblioteca;

import java.util.ArrayList;

class Library {

    public String list(ArrayList<? extends Item> items) {
        String bookInformation = "";
        for (Item item : items) {
            bookInformation += item.list();
        }
        return bookInformation;
    }


    public String checkOut(String itemName, ArrayList<? extends Item> items, String currentUser) {
        String messageToUser;
        for (Item item : items) {
            messageToUser = item.checkOut(itemName, currentUser);
            if (messageToUser != null)
                return messageToUser;
        }
        return "Item is not available";
    }


    public String checkIn(String bookName, ArrayList<? extends Item> items) {
        String messageToUser;
        for (Item item : items) {
            messageToUser = item.checkIn(bookName);
            if (messageToUser != null)
                return messageToUser;
        }
        return "That is not a valid item to return";
    }
}