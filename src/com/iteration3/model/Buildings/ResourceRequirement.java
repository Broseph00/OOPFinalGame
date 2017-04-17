package com.iteration3.model.Buildings;

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

    public ArrayList<Resource> getResourceRequirements() {
        return resourceRequirements;
    }


}
