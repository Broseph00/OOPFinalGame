package com.iteration3.model.Transporters.Land.RoadOnly;

import com.iteration3.model.Transporters.Land.LandTransporter;

public abstract class OnRoadLandTransporter extends LandTransporter {
    public OnRoadLandTransporter(int maxMove, int cap) {
        super(maxMove, cap);
    }
}
