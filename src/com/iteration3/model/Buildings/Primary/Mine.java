package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Tiles.*;

public class Mine extends PrimaryProducer {
    Tile lcoation;

    public Mine(Tile buildLocation) {
        super(new MountainTerrain());
    }

    @Override
    public Resource produce() {
        return null;
    }
}
