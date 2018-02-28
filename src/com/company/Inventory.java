package com.company;
import java.util.HashMap;

public class Inventory {

    HashMap<String, Item> inventoryMap = new HashMap<String, Item>();

    public Inventory() {

    }

    //Calling this method will insert this Item into the hashMap with its name as the key.
    public void addItem(Item item) {
        inventoryMap.put(item.getName(), item);
    }

    public void removeItem (Item item) {
        inventoryMap.remove(item.getName());
    }

    public boolean hasItem(String name) {
        return inventoryMap.containsKey(name);
    }

    //Check inventory
    public String toString() {
        return inventoryMap.keySet().toString();
    }
}
