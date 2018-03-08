package com.company;

public abstract class Item {
    private String name;
    private String description;
    private boolean edible;


    public Item(String name, String description, boolean edible) {
        this.name = name;
        this.description = description;
        this.edible = edible;
    }

    /*
    The handle method accepts a word and figures out the proper reply
    (in the form of a string) to that word.
     */
    public abstract String handle(String s);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEdible() {
        return edible;
    }

    public void setEdible(boolean edible) {
        this.edible = edible;
    }
}
