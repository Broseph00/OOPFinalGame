package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Tiles.SeaTerrain;
import com.iteration3.model.Tiles.Tile;

public class OilRig extends PrimaryProducer {
    Tile location;
    public OilRig(Tile buildLocation) {
        super(new SeaTerrain());
        location = buildLocation;
    }

    @Override
    public Resource produce() {
        return null;
    }
}
