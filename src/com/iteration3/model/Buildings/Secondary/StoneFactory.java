package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Resource.*;
import com.iteration3.utilities.GameLibrary;

import java.util.ArrayList;

public class StoneFactory extends SecondaryProducer {

    public StoneFactory() {
        super(6);
        initialize();
    }

    public void initialize(){
        addRequirement(new Clay());
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getClay().size() >= 1) {
            availableResources.removeClay();
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Resource> produce(ResourceList availableResources) {

        boolean canProduce = checkResources(availableResources);
        ArrayList<Resource> stones = new ArrayList<>();

        while (canProduce && getCapacity() > 0) {
            stones.add(new Stone());
            decrementCapacity();
            canProduce = checkResources(availableResources);

        }

        return stones;
    }

    @Override
    public String getType() {
        return GameLibrary.STONEFACTORY;
    }
}
