package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Fuel;
import com.iteration3.model.Tiles.*;

public class OilRig extends PrimaryProducer {
//    Tile location;
    public OilRig(/*Tile buildLocation*/) {
/*
        super(new SeaTerrain());
        location = buildLocation;
*/
    }

    @Override
    public Fuel produce() {
        Fuel fuel = decrementCapacity() ? new Fuel() : null;

/*
        if (verifyLocation(location)) {
            // TODO: confirm produces only one fuel when Stone class updated
            fuel = new Fuel();
        }
*/
        return fuel;
    }
}
