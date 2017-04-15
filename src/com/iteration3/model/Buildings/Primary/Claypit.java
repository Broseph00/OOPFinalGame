package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Clay;
import com.iteration3.model.Tiles.Tile;

public class Claypit extends PrimaryProducer {
    Tile location;

    public Claypit(Tile buildLocation) {
        super(null);
        location = buildLocation;
    }

    @Override
    public Clay produce() {
        Clay clay = null;

        if (verifyLocation(location)) {
            // TODO: confirm produces only one clay when Clay class updated
            clay = new Clay();
        }
        return clay;
    }

    @Override
    public boolean verifyLocation(Tile tile){
        // TODO: determine if water is on tile OR Claypit is next to Sea
        // boolean waterNearby = tile
        return false;
    }
}
