package com.company;
import java.util.HashMap;

public class Inventory {

    HashMap<String, Item> inventory = new HashMap<String, Item>();

    public Inventory() {

    }

    //Calling this method will insert this Item into the hashMap with its name as the key.
    public void addItem(Item i) {
        inventory.put(i.getName(), i);
    }

    public void removeItem (Item i) {
        inventory.remove(i.getName());
    }

    public boolean hasItem(String name) {
        return inventory.containsKey(name);
    }

    //Check inventory
    public String toString() {
        return inventory.keySet().toString();
    }
}
