package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Trunk;
import com.iteration3.model.Tiles.*;

public class Woodcutter extends PrimaryProducer {
    Tile location;

    public Woodcutter(Tile buildLocation) {
        super(new WoodTerrain());
        location = buildLocation;
    }

    @Override
    public Trunk produce() {
        Trunk trunk = null;

        if (verifyLocation(location)) {
            // TODO: confirm produces only one trunk when Trunk class updated
            trunk = new Trunk();
        }
        return trunk;
    }
}
