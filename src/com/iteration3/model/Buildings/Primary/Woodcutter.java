package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Tiles.Terrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Tiles.WoodTerrain;

public class Woodcutter extends PrimaryProducer {
    Tile location;

    public Woodcutter(Tile buildLocation) {
        super(new WoodTerrain());
        location = buildLocation;
    }

    @Override
    public Resource produce() {
        return null;
    }
}
