package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Resource.*;

import java.util.ArrayList;

public class Mint extends SecondaryProducer {
    private ArrayList<ResourceRequirement> necessaryResources;

    public Mint() {
        super(1);
        initialize();
    }

    private void initialize(){
        ResourceRequirement req1 = new ResourceRequirement(new Fuel(), new Gold(), new Gold());
        necessaryResources.add(req1);
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
        boolean canProduce;
        ArrayList<Resource> coins = null;

        for(ResourceRequirement reqs : necessaryResources){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                coins.add(new Coin());
                decrementCapacity();
                break;
            }
        }

        return coins;
    }
}
