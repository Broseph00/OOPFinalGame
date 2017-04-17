package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.Fuel;
import com.iteration3.model.Resource.Iron;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Land.RoadOnly.Truck;
import com.iteration3.utilities.GameLibrary;
import com.iteration3.model.Transporters.Water.Steamship;


import java.util.ArrayList;

public class TruckFactory extends TransporterFactory {
    public TruckFactory() {
        initialize();
    }

    @Override
    public void initialize() {
        addRequirement(new Fuel());
        addRequirement(new Iron());
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getFuel().size() >= 1 && availableResources.getIron().size() >= 1) {
            availableResources.removeFuel();
            availableResources.removeIron();
            return true;
        }
        return false;
    }


    @Override
    public Truck produce(Player player, ResourceList availableResources) {
        boolean canProduce = checkResources(availableResources);
        Truck truck = null;

        if(canProduce && (getCapacity() > 0)) {
            truck = new Truck(player);
            decrementCapacity();
        }

        return truck;
    }

    @Override
    public String getType() {
        return GameLibrary.TRUCKFACTORY;
    }
}
