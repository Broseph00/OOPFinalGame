package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Tiles.Tile;

public class Claypit extends PrimaryProducer {
    Tile location;

    public Claypit(Tile buildLocation) {
        super(null);
        location = buildLocation;
    }

    @Override
    public Resource produce() {
        return null;
    }

    @Override
    public boolean verifyLocation(Tile tile){
        return false;
    }
}
