package com.company;

public class Main {

    public static void main(String[] args) {
        Room curRoom = addRooms();

        Reader input = new Reader();
        System.out.println(curRoom.getDescription());

        //prints out items in starter room for the player to see
        System.out.println("In this room, there is:");
        System.out.println(curRoom.listItemsInRoom());

        // offer help, since this is the player's first time playing
        String prompt = input.readLine(curRoom.getDescription()+ " Type your command. If you need help, type 'help.'");

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
            else if (verb.equalsIgnoreCase("look")) {
                System.out.println(curRoom.getDescription());
            }
            else if (verb.equalsIgnoreCase("quit")) {
                System.out.println("Are you sure you want to quit? (y/n)");
                String quitPrompt = input.readLine();
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
            prompt = input.readLine();
        }
    }
    //This is a utility method to set up all the rooms and their connections.
    //Returns the main Room.
    private static Room addRooms() {
        Room home = new Room("home", "You are in a simple gray room.");
        Room cave = new Room("cave", "This room glitters with jewels.");
        Room arcade = new Room("arcade","This  room is full of skee ball courts");
        Room garage = new Room("garage","this room is full of cardboard boxes");

        home.addItem(new Book());
        home.addItem(new Apple());

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
