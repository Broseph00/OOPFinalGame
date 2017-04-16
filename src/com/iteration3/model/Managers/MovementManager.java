package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.MoveAbility;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

import java.util.HashMap;

public class MovementManager {
    private ValidationManager validateManager;
    private ExecutionManager executionManager;
    private HashMap<Transporter, RegionLocation> transporters;

    public MovementManager(ValidationManager validateManager, ExecutionManager executionManager){
        this.validateManager = validateManager;
        this.executionManager = executionManager;
        transporters = new HashMap<>();

    }

    //TODO FINISH WHEN DOCK ABILITIES CREATED
    public boolean validateSeaDockAbility(){
        return false;
    }

    public boolean validateRiverDockAbility(){
        return false;
    }

    public boolean validateUndockAbility(){
        return false;
    }

    //TODO: CALL FOR MOVEMENT TO BE EXECUTED

    public boolean validateWaterMoveAbility(MoveAbility moveAbility, WaterTransporter waterTransporter){
        int movesLeft = waterTransporter.getRemainingMovePoints();
        if(movesLeft<1 || waterTransporter.isDocked()){
            return false;
        }
        int border = moveAbility.getBorder();
        if(transporters.containsKey(waterTransporter)) {
            RegionLocation rloc = transporters.get(waterTransporter);
            return validateManager.validateWaterMove(rloc, border, waterTransporter.getOwner());
        }
        return false;
    }

    public boolean validateRoadMoveAbility(MoveAbility moveAbility, OnRoadLandTransporter onRoadLandTransporter){
        int movesLeft = onRoadLandTransporter.getRemainingMovePoints();
        if(movesLeft<1){
            return false;
        }
        int region = moveAbility.getRegion();
        int border = moveAbility.getBorder();
        if(transporters.containsKey(onRoadLandTransporter)) {
            RegionLocation rloc = transporters.get(onRoadLandTransporter);
            return validateManager.validateRoadMove(rloc, region, border, onRoadLandTransporter.getOwner());
        }
        return false;
    }

    public boolean validateLandMoveAbility(MoveAbility moveAbility, LandTransporter landTransporter){
        int movesLeft = landTransporter.getRemainingMovePoints();
        if(movesLeft<1){
            return false;
        }
        int region = moveAbility.getRegion();
        int border = moveAbility.getBorder();
        if(transporters.containsKey(landTransporter)) {
            RegionLocation rloc = transporters.get(landTransporter);
            return validateManager.validateLandMove(rloc, region, border, landTransporter.getOwner(), movesLeft);
        }
        return false;
    }
}
