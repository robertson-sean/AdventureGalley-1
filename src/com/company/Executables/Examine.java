package com.company.Executables;

import com.company.Interactions.Executable;
import com.company.Interactions.Item;

/**
 * Enroll this command with an Item subclass so that it handles the word
 * "examine." Just returns the description.
 */
public class Examine implements Executable {

    @Override
    public String execute(Item i) {
        return i.getDescription();
    }
}
