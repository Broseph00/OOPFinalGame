package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Resource.*;

import java.util.ArrayList;

public class Sawmill extends SecondaryProducer {

    public Sawmill() {
        super(6);
        initialize();
    }

    public void initialize(){
        addRequirement(new Trunk());
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getTrunks().size() >= 1) {
            availableResources.removeTrunk();
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Resource> produce(ResourceList availableResources) {
        boolean canProduce = checkResources(availableResources);
        ArrayList<Resource> boards = new ArrayList<>();

        while(canProduce && getCapacity() > 0) {
            boards.add(new Board());
            decrementCapacity();
            canProduce = checkResources(availableResources);

        }

        return boards;

    }
}
