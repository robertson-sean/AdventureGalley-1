package com.company;

public class Hammer extends Item {

    public Hammer() {
        super("hammer", "a rusty old hammer", false);
    }
    public String handle(String s) {
        if(s.equalsIgnoreCase("examine")) {
            return this.getDescription(); 
        } else {
                return "You can't do that";
            }
    }
}
