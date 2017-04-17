package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Trunk;
import com.iteration3.utilities.GameLibrary;

public class Woodcutter extends PrimaryProducer {

    public Woodcutter() {
    }

    @Override
    public Trunk produce() {
        Trunk trunk = decrementCapacity() ? new Trunk() : null;
        return trunk;
    }

    @Override
    public String getType() {
        return GameLibrary.WOODCUTTER;
    }
}
