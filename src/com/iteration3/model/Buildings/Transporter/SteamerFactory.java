package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Water.Steamship;

public class SteamerFactory extends TransporterFactory {
    public SteamerFactory() {
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        return false;
    }

    @Override
    public Steamship produce() {
        return null;
    }
}
