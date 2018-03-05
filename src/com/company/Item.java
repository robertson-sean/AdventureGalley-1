package com.company;

public class Item {
    private String name;
    private String description;
    private boolean edible;


    public Item(String name, String description, boolean edible) {
        this.name = name;
        this.description = description;
        this.edible = edible;
    }

    public String getName() {
        return name;
    }

    public void setItem(String name) {
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
