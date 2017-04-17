package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.Fuel;
import com.iteration3.model.Resource.Iron;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Resource.Trunk;
import com.iteration3.model.Transporters.Water.Rowboat;
import com.iteration3.model.Transporters.Water.Steamship;

import java.util.ArrayList;

public class SteamerFactory extends TransporterFactory {
    public SteamerFactory() {
        initialize();
    }

    @Override
    public void initialize() {
        addRequirement(new Fuel());
        addRequirement(new Fuel());
        addRequirement(new Iron());
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getFuel().size() >= 2 && availableResources.getIron().size() >= 1) {
            availableResources.removeFuel();
            availableResources.removeFuel();
            availableResources.removeIron();
            return true;
        }
        return false;
    }

    @Override
    public Steamship produce(Player player, ResourceList availableResources) {
        boolean canProduce = checkResources(availableResources);
        Steamship steamship = null;

        if(canProduce && (getCapacity() > 0)) {
            steamship = new Steamship(player);
            decrementCapacity();
        }

        return steamship;

    }


}
