package com.company;
import java.util.HashMap;
import java.util.Set;

public class Room {
    private String name;
    private String description;


    HashMap<String, Room> connectedRooms = new HashMap<String, Room>();
    Inventory roomInventory = new Inventory();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public boolean hasRoom(String name) {
        return connectedRooms.containsKey(name);
    }

    public Room getRoom(String name) {
        return connectedRooms.get(name);
    }


    //This method gets a Room, then uses its name to add it to the list of connected rooms.
    public void addRoom(Room room) {
        connectedRooms.put(room.getName(),room);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public Set<String> getConnectedRooms(){
        return connectedRooms.keySet();
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
