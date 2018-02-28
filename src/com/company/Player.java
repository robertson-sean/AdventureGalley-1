package com.company;
import java.util.HashMap;
public class Player {
    private String name;
    Inventory playerInventory= new Inventory() ;
    public Player (String name ){
        this.name = name;

    }


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public int health = 100;

}
