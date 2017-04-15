package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Stone;
import com.iteration3.model.Tiles.*;

public class StoneQuarry extends PrimaryProducer {
    Tile location;

    public StoneQuarry(Tile buildLocation) {
        super(new RockTerrain());
        location = buildLocation;
    }

    @Override
    public Stone produce() {
        Stone stone = null;

        if (verifyLocation(location)) {
            // TODO: confirm produces only one stone when Stone class updated
            stone = new Stone();
        }
        return stone;
    }
}
