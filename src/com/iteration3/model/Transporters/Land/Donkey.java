package com.iteration3.model.Transporters.Land;

import com.iteration3.model.Livestock;

public class Donkey extends LandTransporter implements Livestock {


    public Donkey() {
        // TODO: max move 1 if on road
        super(2, 2);
    }
}
