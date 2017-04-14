package com.iteration3.model.Transporters.Land;

import com.iteration3.model.Livestock;

public class Donkey extends LandTransporter implements Livestock {

    public Donkey(){
        setMaxMovePoints(2);    //1 if not on road
        setCapacity(2);
    }
}
