package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.*;
import com.iteration3.model.Resource.*;

import java.util.ArrayList;

public abstract class SecondaryProducer extends Producer {

    private ArrayList<ResourceRequirement> necessaryResources;

    public SecondaryProducer(int maxCapacity){
        super(maxCapacity);
        necessaryResources = new ArrayList<>();
    }

    public abstract boolean checkResources(ResourceList availableResources);

    public abstract ArrayList<Resource> produce(ResourceList availableResources);

    protected void addRequirement(ResourceRequirement requirement) {
        this.necessaryResources.add(requirement);
    }

    protected ArrayList<ResourceRequirement> getNecessaryResources() {
        return necessaryResources;
    }
}
