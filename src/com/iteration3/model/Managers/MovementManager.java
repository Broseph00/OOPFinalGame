package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.MoveAbility;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

public class MovementManager {
    private Map map;

    public MovementManager(Map map){
        this.map = map;
    }

    public boolean validateWaterMoveAbility(MoveAbility moveAbility, WaterTransporter transporter){
        int region = moveAbility.getRegion();
        int border = moveAbility.getBorder();
        return true;
        //TODO: do this
    }

    public boolean validateRoadMoveAbility(MoveAbility moveAbility, OnRoadLandTransporter transporter){
        int region = moveAbility.getRegion();
        int border = moveAbility.getBorder();
        return true;
        //TODO: finish this
    }

    public boolean validateLandMoveAbility(MoveAbility moveAbility, LandTransporter transporter){
        int region = moveAbility.getRegion();
        int border = moveAbility.getBorder();
        return true;
        //TODO: finish this
    }
}
