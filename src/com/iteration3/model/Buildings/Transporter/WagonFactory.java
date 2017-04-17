package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Land.RoadOnly.Wagon;

public class WagonFactory extends TransporterFactory {
    public WagonFactory() {
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        return false;
    }

    @Override
    public Wagon produce() {
        return null;
    }
}
