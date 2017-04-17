package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Land.RoadOnly.Wagon;
import com.iteration3.utilities.GameLibrary;

public class WagonFactory extends TransporterFactory {
    public WagonFactory() {
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
    public Wagon produce(Player player, ResourceList availableResources) {
        boolean canProduce = false;
        Wagon wagon = null;

        for(ResourceRequirement reqs : getNecessaryResources()){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                wagon = (canProduce && (getCapacity() > 0)) ? new Wagon(player) : null;
                decrementCapacity();
                break;
            }
        }

        return wagon;
    }

    @Override
    public String getType() {
        return GameLibrary.WAGONFACTORY;
    }
}
