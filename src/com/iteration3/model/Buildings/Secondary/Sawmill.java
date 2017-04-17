package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Resource.*;
import com.iteration3.utilities.GameLibrary;

import java.util.ArrayList;

public class Sawmill extends SecondaryProducer {

    public Sawmill() {
        super(6);
        initialize();
    }

    private void initialize(){
        ResourceRequirement req1 = new ResourceRequirement(new Trunk());
        addRequirement(req1);
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        for(ResourceRequirement reqs : getNecessaryResources()){
            if(reqs.verify(availableResources.getResources())){
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<Resource> produce(ResourceList availableResources) {
        boolean canProduce = false;
        ArrayList<Resource> boards = new ArrayList<>();

        for(ResourceRequirement reqs : getNecessaryResources()){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                boards.add(new Board());
                boards.add(new Board());
                decrementCapacity();
                break;
            }
        }

        return boards;
    }

    @Override
    public String getType() {
        return GameLibrary.SAWMILL;
    }
}
