package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Clay;
import com.iteration3.model.Tiles.Tile;

public class Claypit extends PrimaryProducer {
    Tile location;

    public Claypit(/*Tile buildLocation*/) {
//        super(null);
//        location = buildLocation;
    }

    @Override
    public Clay produce() {
        // location verification to be done in a manager class
        Clay clay = decrementCapacity() ? new Clay() : null;
        return clay;
    }

/*
    @Override
    public boolean verifyLocation(Tile tile){
        // location verification to be done in a manager class
        return false;
    }
*/
}
