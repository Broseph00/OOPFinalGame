package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Water.Steamship;
import com.iteration3.utilities.GameLibrary;

public class SteamerFactory extends TransporterFactory {
    public SteamerFactory() {
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
    public Steamship produce(Player player, ResourceList availableResources) {
        boolean canProduce = false;
        Steamship steamship = null;

        for(ResourceRequirement reqs : getNecessaryResources()){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                steamship = (canProduce && (getCapacity() > 0)) ? new Steamship(player) : null;
                decrementCapacity();
                break;
            }
        }

        return steamship;
    }

    @Override
    public String getType() {
        return GameLibrary.STEAMERFACTORY;
    }
}
