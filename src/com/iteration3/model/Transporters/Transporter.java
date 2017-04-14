package com.iteration3.model.Transporters;

import com.iteration3.model.Resource.Resource;

import java.util.List;

public abstract class Transporter {
    private List<Resource> resourceList;
    private int remainingMovePoints;
    private int maxMovePoints;
    private int capacity;


    public Transporter(){

    }

    public List<Resource> getResourceList() {
        return resourceList;
    }

    public int getRemainingMovePoints() {
        return remainingMovePoints;
    }

    public int getMaxMovePoints() {
        return maxMovePoints;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resetMovePoints(){
        remainingMovePoints = maxMovePoints;
    }


}
