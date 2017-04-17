package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.Clay;
import com.iteration3.utilities.GameLibrary;

public class Claypit extends PrimaryProducer {
    public Claypit() {
    }

    @Override
    public Clay produce() {
        Clay clay = decrementCapacity() ? new Clay() : null;
        return clay;
    }

    @Override
    public String getType() {
        return GameLibrary.CLAYPIT;
    }
}
