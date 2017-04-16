package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.*;
import com.iteration3.model.Tiles.*;

public class Mine extends PrimaryProducer {
    // TODO: need specialized mines
    Tile location;

    public Mine(Tile buildLocation) {
        super(new MountainTerrain());
    }

    @Override
    public Resource produce() {
        Resource ore = null;

        if (verifyLocation(location)) {
            // TODO: confirm produces only one ore when ore class updated
        }
        return ore;
    }

    private Iron produceIron(){
        return null;
    }

    private Gold produceGold(){
        return null;
    }
}
