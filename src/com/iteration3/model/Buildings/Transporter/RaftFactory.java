package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Resource.*;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.Raft;

import java.util.ArrayList;

public class RaftFactory extends TransporterFactory {
    public RaftFactory() {
        initialize();
    }

    @Override
    public void initialize() {
        addRequirement(new Trunk());
    }

    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getTrunks().size() >= 2) {
            availableResources.removeTrunk();
            availableResources.removeTrunk();
            return true;
        }
        return false;
    }



    @Override
    public Raft produce(Player player, ResourceList availableResources) {


        boolean canProduce = checkResources(availableResources);
        Raft raft = null;

        if(canProduce && (getCapacity() > 0)) {
            raft = new Raft(player);
            decrementCapacity();
        }

        return raft;

    }
}
