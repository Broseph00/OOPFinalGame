package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Resource.*;

import java.util.ArrayList;

public class Sawmill extends SecondaryProducer {
    private ArrayList<ResourceRequirement> necessaryResources;

    public Sawmill() {
        super(6);
    }

    private void initialize(){
        ResourceRequirement req1 = new ResourceRequirement(new Trunk());
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
        boolean canProduce = false;
        ArrayList<Resource> boards = new ArrayList<>();

        for(ResourceRequirement reqs : necessaryResources){
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
}
