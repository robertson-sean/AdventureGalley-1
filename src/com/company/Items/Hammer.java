package com.company.Items;

import com.company.Interactions.*;
import com.company.Executables.*;

public class Hammer extends Item {

    public Hammer() {
        super("hammer", "a rusty old hammer", false);
        addExecutable("examine", new Examine());
        addExecutable("reverse", new Reverse());
    }

}
