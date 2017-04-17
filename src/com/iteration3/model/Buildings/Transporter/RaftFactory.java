package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Water.Raft;
import com.iteration3.utilities.GameLibrary;

public class RaftFactory extends TransporterFactory {
    public RaftFactory() {
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
    public Raft produce(Player player, ResourceList availableResources) {
        boolean canProduce = false;
        Raft raft = null;

        for(ResourceRequirement reqs : getNecessaryResources()){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                raft = (canProduce && (getCapacity() > 0)) ? new Raft(player) : null;
                decrementCapacity();
                break;
            }
        }

        return raft;
    }

    @Override
    public String getType() {
        return GameLibrary.RAFTFACTORY;
    }
}
