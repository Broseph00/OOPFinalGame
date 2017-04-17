package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Resource.*;

import java.util.ArrayList;

public class CoalBurner extends SecondaryProducer {
    private ArrayList<ResourceRequirement> necessaryResources;

    public CoalBurner() {
        super(6);
        initialize();
    }

    private void initialize(){
        ResourceRequirement req1 = new ResourceRequirement(new Trunk(), new Trunk());
        necessaryResources.add(req1);

        ResourceRequirement req2 = new ResourceRequirement(new Trunk(), new Board());
        necessaryResources.add(req2);

        ResourceRequirement req3 = new ResourceRequirement(new Board(), new Board());
        necessaryResources.add(req3);
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
        ArrayList<Resource> fuels = new ArrayList<>();

        for(ResourceRequirement reqs : necessaryResources){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                fuels.add(new Fuel());
                decrementCapacity();
                break;
            }
        }

        return fuels;
    }
}
