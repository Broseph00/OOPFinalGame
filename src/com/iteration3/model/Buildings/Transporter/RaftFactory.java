package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Water.Raft;

public class RaftFactory extends TransporterFactory {
    public RaftFactory() {
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        return false;
    }

    @Override
    public Raft produce() {
        return null;
    }
}
