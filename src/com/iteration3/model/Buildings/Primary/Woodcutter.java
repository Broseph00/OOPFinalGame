package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Trunk;
import com.iteration3.model.Tiles.*;

public class Woodcutter extends PrimaryProducer {

    public Woodcutter() {
    }

    @Override
    public Trunk produce() {
        Trunk trunk = decrementCapacity() ? new Trunk() : null;
        return trunk;
    }
}
