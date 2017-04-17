package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Resource.*;
import com.iteration3.utilities.GameLibrary;

import java.util.ArrayList;

public class Papermill extends SecondaryProducer {

    public Papermill() {
        super(1);
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
            availableResources.removeBoard();
            availableResources.removeBoard();
            availableResources.removeBoard();
            availableResources.removeBoard();
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Resource> produce(ResourceList availableResources) {

        boolean canProduce = checkResources(availableResources);
        ArrayList<Resource> paper = new ArrayList<>();

        while(canProduce && getCapacity() > 0) {
            paper.add(new Paper());
            decrementCapacity();
            canProduce = checkResources(availableResources);

        }

        return paper;

    }

    @Override
    public String getType() {
        return GameLibrary.PAPERMILL;
    }
}
