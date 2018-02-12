package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Room> RoomList = new HashMap<String, Room>();
        RoomList.put("garage",new Room("garage", "The garage is full of cardboard boxes."));
        RoomList.put("arcade",new Room("arcade", "The arcade is bright, loud, and full of games."));
        RoomList.put("cave",new Room("cave","The cave is dark and damp"));
        Scanner reader = new Scanner(System.in);
        System.out.println("You have entered a room.");
        String prompt = reader.next();
        while(true) {
            if(RoomList.containsKey(prompt)){
                System.out.println(RoomList.get(prompt).getDescription());
            }
           else if (prompt.equals("look")) {

                System.out.println("The room is dark");
            }
            else if (prompt.equals("quit")) {
                break;
            }
            else{
                System.out.println("I'm sorry, I don't understand. Please try again: ");
            }
            prompt = reader.next();
        }
    }
}
