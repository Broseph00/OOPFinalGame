package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Transporter;

public abstract class TransporterFactory extends Producer {
    public TransporterFactory() {
        super(1);
    }

    public abstract boolean checkResources(ResourceList availableResources);

    public abstract Transporter produce();
}
