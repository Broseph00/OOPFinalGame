package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Tiles.*;
import com.iteration3.model.Visitors.TerrainTypeVisitor;

public abstract class PrimaryProducer extends Producer {
    public PrimaryProducer(){
        super(1);
    }

    public abstract Resource produce();
}
