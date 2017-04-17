package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Water.Raft;
import com.iteration3.model.Transporters.Water.Rowboat;

public class RowboatFactory extends TransporterFactory {
    public RowboatFactory() {
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
    public Rowboat produce(Player player, ResourceList availableResources) {
        boolean canProduce = false;
        Rowboat rowboat = null;

        for(ResourceRequirement reqs : getNecessaryResources()){
            canProduce = reqs.consume(availableResources.getResources());
            if(canProduce && (getCapacity() > 0)) {
                rowboat = (canProduce && (getCapacity() > 0)) ? new Rowboat(player) : null;
                decrementCapacity();
                break;
            }
        }

        return rowboat;
    }
}
