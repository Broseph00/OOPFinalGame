package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;

import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.Board;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Water.Rowboat;
import com.iteration3.utilities.GameLibrary;

import java.util.ArrayList;

public class RowboatFactory extends TransporterFactory {
    public RowboatFactory() {
        initialize();
    }

    @Override
    public void initialize() {
        addRequirement(new Board());
        addRequirement(new Board());
        addRequirement(new Board());
        addRequirement(new Board());
        addRequirement(new Board());
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getTrunks().size() >= 5) {
            availableResources.removeBoard();
            availableResources.removeBoard();
            availableResources.removeBoard();
            availableResources.removeBoard();
            availableResources.removeBoard();
            return true;
        }
        return false;
    }

    @Override
    public Rowboat produce(Player player, ResourceList availableResources) {
        boolean canProduce = checkResources(availableResources);
        Rowboat rowboat = null;

        if(canProduce && (getCapacity() > 0)) {
            rowboat = new Rowboat(player);
            decrementCapacity();
        }

        return rowboat;

    }

    @Override
    public String getType() {
        return GameLibrary.ROWBOATFACTORY;
    }
}
