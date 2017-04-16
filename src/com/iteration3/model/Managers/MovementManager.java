package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.DockatRiverAbility;
import com.iteration3.model.Abilities.DockatSeaAbility;
import com.iteration3.model.Abilities.MoveAbility;
import com.iteration3.model.Abilities.UndockAbility;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Tiles.Terrain;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

import java.util.HashMap;

public class MovementManager {
    private ValidationManager validationManager;

    public MovementManager(ValidationManager validationManager){
        this.validationManager = validationManager;
    }

    //TODO FINISH WHEN DOCK ABILITIES CREATED
    public boolean validateSeaDockAbility(DockatSeaAbility dockatSeaAbility, WaterTransporter transporter){
        if(transporter.getRemainingMovePoints()<1){
            return false;
        }
        return validationManager.validateSeaDock(transporter, dockatSeaAbility);
    }

    public boolean validateRiverDockAbility(DockatRiverAbility dockatRiverAbility, WaterTransporter transporter){
        if(transporter.getRemainingMovePoints()<1){
            return false;
        }
        return validationManager.validateRiverDock(transporter);
    }

    public boolean validateUndockAbility(UndockAbility undockAbility, WaterTransporter transporter){
        if(transporter.getRemainingMovePoints()<1){
            return false;
        }
        return transporter.isDocked();
    }

    //TODO: CALL FOR MOVEMENT TO BE EXECUTED

    public boolean validateWaterMoveAbility(MoveAbility moveAbility, WaterTransporter waterTransporter){
        int movesLeft = waterTransporter.getRemainingMovePoints();
        if(movesLeft<1 || waterTransporter.isDocked()){
            return false;
        }
        return validationManager.validateWaterMove(waterTransporter, moveAbility);

    }

    public boolean validateRoadMoveAbility(MoveAbility moveAbility, OnRoadLandTransporter onRoadLandTransporter){
        int movesLeft = onRoadLandTransporter.getRemainingMovePoints();
        if(movesLeft<1){
            return false;
        }
        return validationManager.validateRoadMove(onRoadLandTransporter, moveAbility);
    }

    public boolean validateLandMoveAbility(MoveAbility moveAbility, LandTransporter landTransporter){
        int movesLeft = landTransporter.getRemainingMovePoints();
        if(movesLeft<1){
            return false;
        }
        return validationManager.validateLandMove(landTransporter, moveAbility);
    }

    public boolean validateResources(Transporter transporter, int boardCost, int stoneCost){
        return validationManager.validateResourceCost(transporter, boardCost, stoneCost);
    }

    public boolean validateShore(Transporter transporter){
        return true; //TODO
    }

    public boolean validateTerrain(Transporter transporter, String terrainType){
        return true; //TODO
    }
}
