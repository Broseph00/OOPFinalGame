package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Resource.ResourceList;

import java.util.ArrayList;

public abstract class SecondaryProducer extends Producer {
    public SecondaryProducer(int maxCapacity){
        super(maxCapacity);
    }

    public abstract boolean checkResources(ResourceList availableResources);

    public abstract ArrayList<Resource> produce(ResourceList availableResources);
}
