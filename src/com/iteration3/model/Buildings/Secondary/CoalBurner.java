package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Resource.*;
import com.iteration3.utilities.GameLibrary;

import java.util.ArrayList;

public class CoalBurner extends SecondaryProducer {

    public CoalBurner() {
        super(6);
        initialize();
    }

    public void initialize(){

    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getTrunks().size() >= 2) {
            addRequirement(new Trunk());
            addRequirement(new Trunk());
            availableResources.removeTrunk();
            availableResources.removeTrunk();
            return true;
        }
        else if(availableResources.getTrunks().size() >= 1 && availableResources.getBoards().size() >= 1) {
            addRequirement(new Trunk());
            addRequirement(new Board());
            availableResources.removeTrunk();
            availableResources.removeBoard();
            return true;
        }
        else if(availableResources.getBoards().size() >= 2) {
            addRequirement(new Board());
            addRequirement(new Board());
            availableResources.removeBoard();
            availableResources.removeBoard();
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Resource> produce(ResourceList availableResources) {
        boolean canProduce = checkResources(availableResources);
        ArrayList<Resource> fuels = new ArrayList<>();

        while(canProduce && getCapacity() > 0) {
                fuels.add(new Fuel());
                decrementCapacity();
                canProduce = checkResources(availableResources);

        }

        return fuels;
    }

    @Override
    public String getType() {
        return GameLibrary.COALBURNER;
    }
}
