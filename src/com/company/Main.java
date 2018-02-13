package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Item> items = new HashMap<String, Item>();
        items.put("Banana", new Item("Banana", "There are a bunch of weird spots on the banana"));
        items.put("Button", new Item("Button", "This red button is marked \"self destruct\""));
        items.put("Friend", new Item("Friend", "It's Beckett so its like a bad friend"));


        HashMap<String, Room> rooms = new HashMap<String, Room>();
        rooms.put("Arcade", new Room("Arcade", "There are two consoles and an air hockey table in the back"));
        rooms.put("Cave", new Room("Cave", "It is dark and cold and spiderwebs everywhere"));
        rooms.put("Garage", new Room("Garage", "There is an old bike and a broken car"));

        Scanner reader = new Scanner(System.in);
        System.out.println("You have entered a room");
        String prompt = reader.next();

        while(true) {
            if (prompt.equalsIgnoreCase("look")) {
                System.out.println("The room is dark, there is a banana, a button, and a friend");
            }
            else if(items.containsKey(prompt)) {
                System.out.println(items.get(prompt).getDescription());
            }
            else if(rooms.containsKey(prompt)){
                System.out.println(rooms.get(prompt).getDescription());
            }
            else if (prompt.equalsIgnoreCase("quit")) {
                System.out.println("goodbye...");
                break;
            }
            else{
                System.out.println("I'm sorry, I don't understand. Please try again: ");
            }
            prompt = reader.next();
        }
    }
}
