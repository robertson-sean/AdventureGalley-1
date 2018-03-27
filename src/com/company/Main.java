package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Room curRoom = World.getWorld("Crazy").getStartingRoom();

        Scanner reader = new Scanner(System.in);

        Reader input = new Reader();
         Player user = new Player(input.readLine("What is your Name?"));
        System.out.println("Hello "+user.getName());
        //String username = input.readLine("What is your name?");
        //prints out items in starter room for the player to see
        System.out.print(curRoom.getDescription()+" In this room, there is: "+curRoom.listItemsInRoom());


        // offer help, since this is the player's first time playing
        System.out.println( " Type your command. If you need help, type 'help.'");

        String prompt = reader.next();

        String name = prompt;

        System.out.println(curRoom.getDescription()+" You can go to "+curRoom.getConnectedRooms());
        prompt = reader.next();

        while(true) {
            String[] words = prompt.split(" ");
            String directObject = words[words.length-1];
            String verb = words[0];
            if(curRoom.hasItem(directObject)) {
                Item whichItem = curRoom.getItem(directObject);
                String response = whichItem.handle(verb);
                System.out.println(response);
            } else if(curRoom.hasRoom(verb)) {
                curRoom = curRoom.getRoom(verb);
                System.out.println(curRoom.getDescription());
                System.out.print("In this room, there is:");
                System.out.print(curRoom.listItemsInRoom());
            }
            else if (prompt.equalsIgnoreCase("look")) {
                System.out.println(curRoom.getDescription());
            }
            else if (prompt.equalsIgnoreCase("quit")) {
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
            else if (prompt.equalsIgnoreCase("help")){
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

}
