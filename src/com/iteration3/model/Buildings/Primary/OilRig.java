package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Fuel;
import com.iteration3.utilities.GameLibrary;

public class OilRig extends PrimaryProducer {
    public OilRig() {
    }

    @Override
    public Fuel produce() {
        Fuel fuel = decrementCapacity() ? new Fuel() : null;
        return fuel;
    }

    @Override
    public String getType() {
        return GameLibrary.OILRIG;
    }
}
