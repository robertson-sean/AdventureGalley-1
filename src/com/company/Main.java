package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Room curRoom = addRooms();


        Scanner reader = new Scanner(System.in);
        System.out.println("what is your name?");
        String prompt = reader.next();
        String name = prompt;
        Player user = new Player(name);
        System.out.println(curRoom.getDescription());
        prompt = reader.next();

        while(true) {
            if(curRoom.hasRoom(prompt)){
                curRoom=curRoom.getRoom(prompt);
                System.out.println(curRoom.getDescription());

            }
            else if (prompt.equals("look")) {

                System.out.println(curRoom.getDescription()+"You can go to "+curRoom.getConnectedRooms());
            }
            else if (prompt.equals("quit")) break;
            else{
                System.out.println("You can't do that ");
            }
            prompt = reader.next();
        }

    }
    //This is a utility method to set up all the rooms and their connections.
    //Returns the main Room.
    public static Room addRooms() {
        Room home = new Room("home", "You are in a simple gray room.");
        Room cave = new Room("cave", "This room glitters with jewels.");
        Room arcade = new Room("arcade","This  room is full of skee ball courts");
        Room garage = new Room("garage","this room is full of cardboard boxes");
        arcade.addRoom(home);
        home.addRoom(garage);
        garage.addRoom(home);
        garage.addRoom(arcade);
        arcade.addRoom(cave);
        cave.addRoom(garage);
        home.addRoom(cave);
        home.addRoom(arcade);
        cave.addRoom(home);
        return home;


    }

}
