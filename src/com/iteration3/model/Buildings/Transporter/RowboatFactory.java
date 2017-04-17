package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Water.Rowboat;

public class RowboatFactory extends TransporterFactory {
    public RowboatFactory() {
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        return false;
    }

    @Override
    public Rowboat produce() {
        return null;
    }
}
