package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Resource.ResourceList;

import java.util.ArrayList;

public abstract class SecondaryProducer extends Producer {

    private ArrayList<ResourceRequirement> necessaryResources;

    public SecondaryProducer(int maxCapacity){
        super(maxCapacity);
        necessaryResources = new ArrayList<>();
    }

    public abstract boolean checkResources(ResourceList availableResources);

    public abstract ArrayList<Resource> produce(ResourceList availableResources);

    public void addRequirement(ResourceRequirement requirement) {
        this.necessaryResources.add(requirement);
    }

    public ArrayList<ResourceRequirement> getNecessaryResources() {
        return necessaryResources;
    }
}
