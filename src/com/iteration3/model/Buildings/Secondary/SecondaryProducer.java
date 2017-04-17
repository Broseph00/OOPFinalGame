package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.*;
import com.iteration3.model.Resource.*;

import java.util.ArrayList;

public abstract class SecondaryProducer extends Producer {

    private ArrayList<Resource> necessaryResources;

    public SecondaryProducer(int maxCapacity){
        super(maxCapacity);
        necessaryResources = new ArrayList<>();
    }

    public abstract void initialize();

    public abstract boolean checkResources(ResourceList availableResources);

    public abstract ArrayList<Resource> produce(ResourceList availableResources);

    public void addRequirement(Resource requirement) {
        this.necessaryResources.add(requirement);
    }

    public ArrayList<Resource> getNecessaryResources() {
        return necessaryResources;
    }
}
