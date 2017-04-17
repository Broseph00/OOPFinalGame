package com.iteration3.model.Transporters.Land.RoadOnly;

import com.iteration3.model.Players.Player;
import com.iteration3.utilities.GameLibrary;

public class Wagon extends OnRoadLandTransporter {


    public Wagon(Player player) {
        super(player,3, 3);
    }

    @Override
    public String getType() {
        return GameLibrary.WAGON;
    }
}
