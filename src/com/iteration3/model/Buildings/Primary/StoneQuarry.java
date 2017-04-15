package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Tiles.RockTerrain;
import com.iteration3.model.Tiles.Tile;

public class StoneQuarry extends PrimaryProducer {
    Tile location;

    public StoneQuarry(Tile buildLocation) {
        super(new RockTerrain());
        location = buildLocation;
    }

    @Override
    public Resource produce() {
        return null;
    }
}
