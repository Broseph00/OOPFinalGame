package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Buildings.ResourceRequirement;

import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Transporter;

import java.util.ArrayList;

public abstract class TransporterFactory extends Producer {

    private ArrayList<Resource> necessaryResources;

    public TransporterFactory() {
        super(1);
        necessaryResources = new ArrayList<>();
    }

    public abstract void initialize();
    public abstract boolean checkResources(ResourceList availableResources);

    public abstract Transporter produce(Player player, ResourceList availableResources);

    protected void addRequirement(Resource requirement) {
        this.necessaryResources.add(requirement);
    }

    public ArrayList<Resource> getNecessaryResources() {
        return necessaryResources;
    }

}
