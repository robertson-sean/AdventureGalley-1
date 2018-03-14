package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Room curRoom = addRooms();

        Scanner reader = new Scanner(System.in);
        Reader input = new Reader();
//        String username = input.readLine("What is your name?");
        System.out.println(curRoom.getDescription());

        //prints out items in starter room for the player to see
        System.out.println("In this room, there is:");
        System.out.println(curRoom.listItemsInRoom());
        // offer help, since this is the player's first time playing
        String prompt = input.readLine(curRoom.getDescription()+ " Type your command. If you need help, type 'help.'");

//        String prompt = reader.next();
//
//        String name = prompt;
//        Player user = new Player(name);
//        System.out.println(curRoom.getDescription());
//        String prompt = reader.nextLine();

        while(true) {
            String[] words = prompt.split(" ");
            String directObject = words[words.length-1];
            String verb = words[0];
            if(curRoom.itemsInRoom.hasItem(directObject)) {
                Item whichItem = curRoom.itemsInRoom.getItem(directObject);
                String response = whichItem.handle(verb);
                System.out.println(response);
            } else if(curRoom.hasRoom(verb)) {
                    curRoom = curRoom.getRoom(verb);
                    System.out.println(curRoom.getDescription());
                    System.out.print("In this room, there is:");
                    System.out.print(curRoom.listItemsInRoom());
            }
            else if (verb.equalsIgnoreCase("look")) {
                System.out.println(curRoom.getDescription());
            }
            else if (verb.equalsIgnoreCase("quit")) {
                System.out.println("Are you sure you want to quit? (y/n)");
                String quitPrompt = reader.next();
                if(quitPrompt.equalsIgnoreCase("y")) {
                    System.out.println("Thanks for playing!");
                    break;
                }
                else {
                    System.out.println(curRoom.getDescription());
                }
            }
            else if (verb.equalsIgnoreCase("help")){
                System.out.println("Type 'look' to explore your surroundings, Type 'quit' to exit the game, Type 'help' for help.");
            }
            else{
                System.out.println("You can't do that ");
            }
            prompt = reader.nextLine();
        }
    }
    //This is a utility method to set up all the rooms and their connections.
    //Returns the main Room.
    private static Room addRooms() {
        Room home = new Room("home", "You are in a simple gray room.");
        Room cave = new Room("cave", "This room glitters with jewels.");
        Room arcade = new Room("arcade","This  room is full of skee ball courts");
        Room garage = new Room("garage","this room is full of cardboard boxes");

        home.itemsInRoom.addItem(new Book());

        arcade.addRoom(home);
        arcade.addRoom(cave);

        home.addRoom(garage);
        home.addRoom(cave);
        home.addRoom(arcade);

//        home.itemsInRoom.addItem(new Banana());
//        home.itemsInRoom.addItem(new Item("note", "Welcome to our game.", false));
//        garage.itemsInRoom.addItem(new Item("Hammer", "A very heavy duty hammer.", false));
//        garage.itemsInRoom.addItem(new Item("Drill","Does not come with a drill bit.", false));
//        arcade.itemsInRoom.addItem(new Item("controller", "This is a video game controller or an unknown game system.", false));
//        arcade.itemsInRoom.addItem(new Item("jacket", " 80's style jacket with teal and purple detailing.", false));
//        cave.itemsInRoom.addItem(new Item("charcoal stick", " A stick of charcoal that looks like it has been on the walls", false));
//        cave.itemsInRoom.addItem(new Item("arrowhead", "An arrowhead make out of what seems to be some sort of bone", false));

        garage.addRoom(home);
        garage.addRoom(arcade);

        cave.addRoom(garage);
        cave.addRoom(home);
        return home;

    }
}
