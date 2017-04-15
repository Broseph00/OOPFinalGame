package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.ResourceProducer;

public abstract class SecondaryProducer extends ResourceProducer {
    public SecondaryProducer(){super(1);}
    public SecondaryProducer(int maxCapacity){
        super(maxCapacity);
    }
}
