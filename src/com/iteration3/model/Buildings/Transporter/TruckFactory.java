package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Land.RoadOnly.Truck;
import com.iteration3.utilities.GameLibrary;

import java.util.ArrayList;

public class TruckFactory extends TransporterFactory {
    public TruckFactory() {
        initialize();
    }

    @Override
    public void initialize() {

    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        for(ResourceRequirement reqs : getNecessaryResources()){
            if(reqs.verify(availableResources.getResources())){
                return true;
            }
        }
        return false;
    }


    @Override
    public Truck produce(Player player, ResourceList availableResources) {
        boolean canProduce = false;
        Truck truck = null;

        for(ResourceRequirement reqs : getNecessaryResources()){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                truck = (canProduce && (getCapacity() > 0)) ? new Truck(player) : null;
                decrementCapacity();
                break;
            }
        }

        return truck;
    }

    @Override
    public String getType() {
        return GameLibrary.TRUCKFACTORY;
    }
}
