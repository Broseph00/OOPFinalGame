package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Stone;
import com.iteration3.model.Tiles.*;

public class StoneQuarry extends PrimaryProducer {

    public StoneQuarry() {
    }

    @Override
    public Stone produce() {
        Stone stone = decrementCapacity() ? new Stone() : null;
        return stone;
    }
}
