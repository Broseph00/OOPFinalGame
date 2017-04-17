package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Resource.*;

import java.util.ArrayList;

public class StoneFactory extends SecondaryProducer {
    private ArrayList<ResourceRequirement> necessaryResources;

    public StoneFactory() {
        super(6);
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        for(ResourceRequirement reqs : necessaryResources){
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

        for(ResourceRequirement reqs : necessaryResources){
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
}
