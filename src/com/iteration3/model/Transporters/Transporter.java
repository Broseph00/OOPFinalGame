package com.iteration3.model.Transporters;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.Resource.Resource;

import java.util.ArrayList;
import java.util.List;

public abstract class Transporter {
    private List<Resource> resourceList;
    private ArrayList<Ability> abilityList;
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

}
