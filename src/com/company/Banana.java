package com.company;

/**
 * Created by andy on 3/5/18.
 */
public class Banana extends Item {

    public Banana() {
        super("banana", "a delicious yellow banana.", true);
    }

    @Override
    public String handle(String s) {
        if (s.equalsIgnoreCase("examine")) {
            return this.getDescription();
        } else {
            return "derp.";
        }
    }
}
