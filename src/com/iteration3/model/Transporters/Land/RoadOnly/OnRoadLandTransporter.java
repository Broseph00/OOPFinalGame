package com.iteration3.model.Transporters.Land.RoadOnly;

import com.iteration3.model.Players.Player;
import com.iteration3.model.Transporters.Land.LandTransporter;

public abstract class OnRoadLandTransporter extends LandTransporter {
    public OnRoadLandTransporter(Player player, int maxMove, int cap) {
        super(player, maxMove, cap);
    }
}
