package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Room curRoom = addRooms();

        Scanner reader = new Scanner(System.in);
        System.out.println(curRoom.getDescription());
        String prompt = reader.next();
        while(true) {
            if(curRoom.hasRoom(prompt)) {
                curRoom = curRoom.getRoom(prompt);
                System.out.println(curRoom.getDescription());
            }
            else if (prompt.equalsIgnoreCase("look")) {
                System.out.println(curRoom.getDescription());
            }
            else if (prompt.equalsIgnoreCase("quit")) break;
            else{
                System.out.println("You can't do that ");
            }
            prompt = reader.next();
        }
    }
    //This is a utility method to set up all the rooms and their connections.
    //Returns the main Room.
    private static Room addRooms() {
        Room home = new Room("home", "You are in a simple gray room.");
        Room cave = new Room("cave", "This room glitters with jewels.");
        Room arcade = new Room("arcade","This  room is full of skee ball courts");
        Room garage = new Room("garage","this room is full of cardboard boxes");

        arcade.addRoom(home);
        arcade.addRoom(cave);

        home.addRoom(garage);
        home.addRoom(cave);
        home.addRoom(arcade);

        garage.addRoom(home);
        garage.addRoom(arcade);

        cave.addRoom(garage);
        cave.addRoom(home);
        return home;

    }
}
