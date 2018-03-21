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
            String arr[] = prompt.split(" ", 2);
            String verb = arr[0];  //This is the throwaway word
            String directObject = arr[1];
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
                System.out.println(listOfCommands());
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
        home.addItem(new BigGreenMagicBook());

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
    public static String listOfCommands() {
            return ("Here's a list of useful commands: \nThe 'Look' command will " +
                    "give you a description of your surroundings. \nThe 'Examine' command will give you a description of an" +
                    "object. \nThe 'Inventory' command will give you a list of the items in your inventory and a description of" +
                    " them. \nThe 'Restart' command will restart the game \nThe 'Quit' command will quit the game for you. Make " +
                    "sure you save before you quit!");


    }
}
