package com.iteration3.model.Players;

import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

import java.util.ArrayList;

public class Player {
    private ArrayList<LandTransporter> landTransporters;
    private ArrayList<OnRoadLandTransporter> onRoadLandTransporters;
    private ArrayList<WaterTransporter> waterTransporters;

    public Player(){
        landTransporters = new ArrayList<>();
        onRoadLandTransporters = new ArrayList<>();
        waterTransporters = new ArrayList<>();
    }
}
