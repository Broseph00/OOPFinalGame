package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.*;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Transporters.Transporter;

public class ExecutionManager {
    private Map map;
    public ExecutionManager(Map map){
        this.map = map;
    }


    public void transportMove(Transporter transporter, int exitRegion, int exitEdge){
        RegionLocation startRegionLocation = map.getTransportRegionLocation(transporter);
        Location startLocation = startRegionLocation.getLocation();
        Location endLocation = startLocation.getLocationEdge(exitEdge);
        int enterRegion;
        //Boat
        if(startRegionLocation.getRegion()==7){
            enterRegion=7;
            transporter.decreaseMovePoints(1);
        }
        //NotBoat
        else {
            enterRegion = getOppositeRegion(exitRegion, exitEdge);
            if(map.containsRoad(startLocation,endLocation)){
                transporter.decreaseMovePoints(1);
            }
            else{
                transporter.decreaseMovePoints(2);
            }
        }
        RegionLocation endRegionLocation = new RegionLocation(startLocation, enterRegion);
        map.removeTransport(transporter,startRegionLocation);
        map.addTransport(transporter,endRegionLocation);
    }

    private int getOppositeRegion(int exitRegion, int exitEdge){
        if(exitEdge==1){
            if(exitRegion==1){
                return 3;
            }
            else if(exitRegion==6){
                return 4;
            }
        }
        else if(exitEdge==2){
            if(exitRegion==1){
                return 5;
            }
            else if(exitRegion==2){
                return 4;
            }
        }
        else if(exitEdge==3){
            if(exitRegion==2){
                return 6;
            }
            else if(exitRegion==3){
                return 5;
            }
        }
        else if(exitEdge==4){
            if(exitRegion==3){
                return 1;
            }
            else if(exitRegion==4){
                return 6;
            }
        }
        else if(exitEdge==5){
            if(exitRegion==4){
                return 2;
            }
            else if(exitRegion==5){
                return 1;
            }
        }
        else if(exitEdge==6){
            if(exitRegion==5){
                return 3;
            }
            else if(exitRegion==6){
                return 2;
            }
        }
        return 0;
    }


    public void execute(BuildClaypitAbility ability) { }
    public void execute(BuildCoalBurnerAbility ability) { }
    public void execute(BuildMineAbility ability) { }
    public void execute(BuildMintAbility ability) { }
    public void execute(BuildOilRigAbility ability) { }
    public void execute(BuildPapermillAbility ability) { }
    public void execute(BuildRaftFactoryAbility ability) { }
    public void execute(BuildRowboatFactoryAbility ability) { }
    public void execute(BuildSteamerFactoryAbility ability) { }
    public void execute(BuildStockExchangeAbility ability) { }
    public void execute(BuildStoneFactoryAbility ability) { }
    public void execute(BuildStoneQuarryAbility ability) { }
    public void execute(BuildTruckFactoryAbility ability) { }
    public void execute(BuildWagonFactoryAbility ability) { }
    public void execute(BuildWoodcutterAbility ability) { }

    public void execute(MoveDegree0Ability ability) { }
    public void execute(MoveDegree30Ability ability) { }
    public void execute(MoveDegree60Ability ability) { }
    public void execute(MoveDegree90Ability ability) { }
    public void execute(MoveDegree120Ability ability) { }
    public void execute(MoveDegree150Ability ability) { }
    public void execute(MoveDegree180Ability ability) { }
    public void execute(MoveDegree210Ability ability) { }
    public void execute(MoveDegree240Ability ability) { }
    public void execute(MoveDegree270Ability ability) { }
    public void execute(MoveDegree300Ability ability) { }
    public void execute(MoveDegree330Ability ability) { }
    public void execute(MoveEdge1Ability ability) { }
    public void execute(MoveEdge2Ability ability) { }
    public void execute(MoveEdge3Ability ability) { }
    public void execute(MoveEdge4Ability ability) { }
    public void execute(MoveEdge5Ability ability) { }
    public void execute(MoveEdge6Ability ability) { }

    public void execute(DockatSea1Ability ability) { }
    public void execute(DockatSea2Ability ability) { }
    public void execute(DockatSea3Ability ability) { }
    public void execute(DockatSea4Ability ability) { }
    public void execute(DockatSea5Ability ability) { }
    public void execute(DockatSea6Ability ability) { }
    public void execute(DockatRiverAbility ability) { }
    public void execute(UndockAbility ability) { }

}
