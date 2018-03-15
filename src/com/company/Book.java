package com.company;

/**
 * Created by andy on 3/8/18.
 */
public class Book extends Item {

    public Book() {
        super("book", "Wbat a lovely book of magic spells.", false);
    }

    public Book(String name, String description) {
        super(name, description, false);
    }

    @Override
    public String handle(String s) {
        if (s.equalsIgnoreCase("examine")) {
            return this.getDescription();
        } else if (s.equalsIgnoreCase("vandalize")) {
            this.setDescription("This book's title has been crossed out and now says \"The Communist Manifesto\"");
            return this.getDescription();
        }
        else {
            return "I don't know how to " + s + " a book.";
        }
    }
}
