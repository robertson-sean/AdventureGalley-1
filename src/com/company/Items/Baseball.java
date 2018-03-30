package com.company.Items;

import com.company.Interactions.Item;

public class Baseball extends Item {

    Baseball() {
        super("baseball", "It is a pearly white baseball.", false);
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
