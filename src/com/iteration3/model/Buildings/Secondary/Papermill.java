package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Resource.*;

import java.util.ArrayList;

public class Papermill extends SecondaryProducer {
    private ArrayList<ResourceRequirement> necessaryResources;

    public Papermill() {
        super(1);
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
        boolean canProduce;
        ArrayList<Resource> papers = new ArrayList<>();

        for(ResourceRequirement reqs : necessaryResources){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                papers.add(new Paper());
                decrementCapacity();
                break;
            }
        }

        return papers;
    }
}
