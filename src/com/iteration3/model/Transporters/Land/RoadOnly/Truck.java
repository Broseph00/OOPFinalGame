package com.iteration3.model.Transporters.Land.RoadOnly;

import com.iteration3.model.Players.Player;
import com.iteration3.utilities.GameLibrary;

public class Truck extends OnRoadLandTransporter {


    public Truck(Player player){
        super(player, 6,4);
    }

    @Override
    public String getType() {
        return GameLibrary.TRUCK;
    }
}
