package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Land.RoadOnly.Truck;

public class TruckFactory extends TransporterFactory {
    public TruckFactory() {
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        return false;
    }

    @Override
    public Truck produce() {
        return null;
    }
}
