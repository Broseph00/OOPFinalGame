package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Resource.ResourceList;

import java.util.ArrayList;

public class ResourceRequirement {
    ArrayList<Resource> resourceRequirements;

    public ResourceRequirement(Resource... resources){
        resourceRequirements = new ArrayList<>();
        for(Resource resource : resources){
            resourceRequirements.add(resource);
        }
    }

    public boolean consume(ArrayList<Resource> availableResources){
        ArrayList<Resource> matchingResources = getMatchingResources(availableResources);
        boolean verified = verify(matchingResources);
        if(verified){
            matchingResources = null;
        }
        return verified;
    }

    private ArrayList<Resource> getMatchingResources(ArrayList<Resource> availableResources){
        ArrayList<Resource> matchingResources = new ArrayList<>();

        for(Resource resource : resourceRequirements){
            for(Resource suppliedResource : availableResources){
                if(resource.equal(suppliedResource)){
                    matchingResources.add(suppliedResource);
                    availableResources.remove(suppliedResource);
                    break;
                }
            }
        }

        return matchingResources;
    }

    public boolean verify(ArrayList<Resource> suppliedResources){
        ArrayList<Resource> tempList = new ArrayList<>();

        for(Resource supplied : suppliedResources){
            for(Resource required : resourceRequirements){
                if(supplied.equal(required)){
                    tempList.add(required);
                    resourceRequirements.remove(required);
                }
            }
        }

        boolean verified = resourceRequirements.isEmpty();
        for(Resource r : tempList){
            resourceRequirements.add(r);
        }

        return verified;
    }
}
