package com.company;

public class Player {
    private Inventory inventory;
    private String name;

    public Player(String name) {
        this.name = name;
        inventory = new Inventory();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int health = 100;

    public void youLost() {

        if (health == 0)

        {
            System.out.println("You Died");
            System.exit(0);
        }

    }


}
