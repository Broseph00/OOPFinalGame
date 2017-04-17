package com.iteration3.model.Transporters;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.AbilityIterator;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Resource.ResourceList;

import java.util.ArrayList;
import java.util.List;

public abstract class Transporter {
    private Player owner;
    private ResourceList resourceList;
    private ArrayList<Ability> abilityList;
    private int remainingMovePoints;
    private int maxMovePoints;
    private int capacity;


    public Transporter(Player player, int maxMove, int cap){
        this.owner = player;
        this.resourceList = new ResourceList();
        this.abilityList = new ArrayList<>();
        this.maxMovePoints = maxMove;
        this.capacity = cap;
        this.remainingMovePoints = this.maxMovePoints;
//        this.owner.addTransporter(this);
    }

    public void decreaseMovePoints(int moves){
        this.remainingMovePoints = this.remainingMovePoints-moves;
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

    public ArrayList<Ability> getAbilityList() {
        return abilityList;
    }

    public Player getOwner() {
        return owner;
    }

    public void removeResource(Resource r) {
        this.resourceList.removeResource(r);
    }

    public void addResource(Resource r) {
        this.resourceList.addResource(r);
    }

    public abstract boolean isDocked();

    public AbilityIterator makeAbilityIterator(){
        return new AbilityIterator() {

            private int index = 0;
            private Ability current;

            public Ability first() {
                return abilityList.get(0);
            }

            @Override
            public void next() {
                index++;
                index %= abilityList.size();
                current = abilityList.get(index);
            }

            @Override
            public void prev() {
                index--;
                if (index < 0)
                    index = abilityList.size()-1;
                current = abilityList.get(index);
            }

            @Override
            public Ability current() {
                return current;
            }
        };
    }

}
