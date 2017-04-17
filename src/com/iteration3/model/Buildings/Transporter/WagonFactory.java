package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.Board;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Land.RoadOnly.Wagon;
import com.iteration3.utilities.GameLibrary;

import java.util.ArrayList;

public class WagonFactory extends TransporterFactory {
    public WagonFactory() {
        initialize();
    }

    @Override
    public void initialize() {
        addRequirement(new Board());
        addRequirement(new Board());
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getTrunks().size() >= 2) {
            availableResources.removeBoard();
            availableResources.removeBoard();
            return true;
        }
        return false;
    }


    @Override
    public Wagon produce(Player player, ResourceList availableResources) {
        boolean canProduce = checkResources(availableResources);
        Wagon wagon = null;

        if(canProduce && (getCapacity() > 0)) {
            wagon = new Wagon(player);
            decrementCapacity();
        }

        return wagon;
    }

    @Override
    public String getType() {
        return GameLibrary.WAGONFACTORY;
    }
}
