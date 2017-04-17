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
        ResourceRequirement req1 = new ResourceRequirement(new Clay());
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
        ArrayList<Resource> stones = new ArrayList<>();

        for(ResourceRequirement reqs : getNecessaryResources()){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                stones.add(new Stone());
                stones.add(new Stone());
                decrementCapacity();
                break;
            }
        }

        return stones;
    }

    @Override
    public String getType() {
        return GameLibrary.STONEFACTORY;
    }
}
