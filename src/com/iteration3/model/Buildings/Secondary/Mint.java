package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Resource.*;
import com.iteration3.utilities.GameLibrary;

import java.util.ArrayList;

public class Mint extends SecondaryProducer {

    public Mint() {
        super(1);
        initialize();
    }

    public void initialize(){
        addRequirement(new Fuel());
        addRequirement(new Gold());
        addRequirement(new Gold());
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getFuel().size() >= 1 && availableResources.getGold().size() >= 2) {
            availableResources.removeGold();
            availableResources.removeGold();
            availableResources.removeFuel();
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Resource> produce(ResourceList availableResources) {

        boolean canProduce = checkResources(availableResources);
        ArrayList<Resource> coins = new ArrayList<>();

        while(canProduce && getCapacity() > 0) {
            coins.add(new Coin());
            decrementCapacity();
            canProduce = checkResources(availableResources);

        }

        return coins;
    }

    @Override
    public String getType() {
        return GameLibrary.MINT;
    }
}
