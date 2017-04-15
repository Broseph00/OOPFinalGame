package com.iteration3.model.Transporters;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Resource.ResourceList;

import java.util.ArrayList;
import java.util.List;

public abstract class Transporter {
    private ResourceList resourceList;
    private ArrayList<Ability> abilityList;
    private int remainingMovePoints;
    private int maxMovePoints;
    private int capacity;


    public Transporter(int maxMove, int cap){
        this.resourceList = new ResourceList();
        this.abilityList = new ArrayList<>();
        this.maxMovePoints = maxMove;
        this.capacity = cap;
        this.remainingMovePoints = this.maxMovePoints;
    }

    public ResourceList getResourceList() {
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

    public void setMaxMovePoints(int i){
        maxMovePoints = i;
    }

    public void setCapacity(int i){
        capacity = i;
    }

    public void clearAbilityList(){
        abilityList.clear();
    }

    public void setAbilityList(ArrayList<Ability> abilityList){
        this.abilityList = abilityList;
    }

    public void removeResource(Resource r) {
        this.resourceList.removeResource(r);
    }

    public void addResource(Resource r) {
        this.resourceList.addResource(r);
    }

}
