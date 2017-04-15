package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.Producer;

public abstract class SecondaryProducer extends Producer {
    public SecondaryProducer(){super(1);}
    public SecondaryProducer(int maxCapacity){
        super(maxCapacity);
    }
}
