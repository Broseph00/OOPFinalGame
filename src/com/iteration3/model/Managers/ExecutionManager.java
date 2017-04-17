package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.*;
import com.iteration3.model.Buildings.Primary.*;
import com.iteration3.model.Buildings.Secondary.*;
import com.iteration3.model.Buildings.Transporter.*;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.Region;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Transporters.Land.RoadOnly.Wagon;
import com.iteration3.model.Transporters.Transporter;

public class ExecutionManager {
    private Map map;
    public ExecutionManager(Map map){
        this.map = map;
    }

    public void execute(Ability ability){ }
    //execution will be done with out checking - assume checks have been done already

    public void execute(BuildClaypitAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        Claypit producer = new Claypit();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildCoalBurnerAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        CoalBurner producer = new CoalBurner();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildMineAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        Mine producer = new StandardMine();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildMintAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        Mint producer = new Mint();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildOilRigAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        OilRig producer = new OilRig();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildPapermillAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        Papermill producer = new Papermill();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildRaftFactoryAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        RaftFactory producer = new RaftFactory();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildRowboatFactoryAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        RowboatFactory producer = new RowboatFactory();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildSteamerFactoryAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        SteamerFactory producer = new SteamerFactory();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildStockExchangeAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        StockExchange producer = new StockExchange();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildStoneFactoryAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        StoneFactory producer = new StoneFactory();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildStoneQuarryAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        StoneQuarry producer = new StoneQuarry();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildTruckFactoryAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        TruckFactory producer = new TruckFactory();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildWagonFactoryAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        WagonFactory producer = new WagonFactory();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(BuildWoodcutterAbility ability) {
        RegionLocation regionLocation = map.getTransportRegionLocation(ability.getTransporter());
        Woodcutter producer = new Woodcutter();
        map.addProducer(producer, regionLocation);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void executeMoveDegree(MoveAbility ability){
        Transporter transporter = ability.getTransporter();
        RegionLocation start = map.getTransportRegionLocation(transporter);
        Location location = start.getLocation();
        RegionLocation end = new RegionLocation(location, getOppositeRegion(ability.getRegion(), ability.getBorder()));
        map.removeTransport(transporter, start);
        map.addTransport(transporter, end);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(MoveDegree0Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree30Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree60Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree90Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree120Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree150Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree180Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree210Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree240Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree270Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree300Ability ability) {executeMoveDegree(ability);}
    public void execute(MoveDegree330Ability ability) {executeMoveDegree(ability);}

    public void executeMoveEdge(MoveAbility ability){
        Transporter transporter = ability.getTransporter();
        RegionLocation start = map.getTransportRegionLocation(transporter);
        Location location = start.getLocation();
        //Region 7 because boats are restricted to region 7 when moving
        RegionLocation end = new RegionLocation(location.getLocationEdge(ability.getBorder()), 7);
        map.removeTransport(transporter, start);
        map.addTransport(transporter, end);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(MoveEdge1Ability ability) {executeMoveEdge(ability);}
    public void execute(MoveEdge2Ability ability) {executeMoveEdge(ability);}
    public void execute(MoveEdge3Ability ability) {executeMoveEdge(ability);}
    public void execute(MoveEdge4Ability ability) {executeMoveEdge(ability);}
    public void execute(MoveEdge5Ability ability) {executeMoveEdge(ability);}
    public void execute(MoveEdge6Ability ability) {executeMoveEdge(ability);}

    public void executeSeaDock(DockatSeaAbility ability){
        Transporter transporter = ability.getTransporter();
        RegionLocation start = map.getTransportRegionLocation(transporter);
        Location location = start.getLocation();
        RegionLocation end = new RegionLocation(location, ability.getBorder());
        map.removeTransport(transporter, start);
        map.addTransport(transporter, end);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(DockatSea1Ability ability) {executeSeaDock(ability);}
    public void execute(DockatSea2Ability ability) {executeSeaDock(ability);}
    public void execute(DockatSea3Ability ability) {executeSeaDock(ability);}
    public void execute(DockatSea4Ability ability) {executeSeaDock(ability);}
    public void execute(DockatSea5Ability ability) {executeSeaDock(ability);}
    public void execute(DockatSea6Ability ability) {executeSeaDock(ability);}

    public void executeRiverDock(DockatRiverAbility ability) {
        Transporter transporter = ability.getTransporter();
        RegionLocation start = map.getTransportRegionLocation(transporter);
        Location location = start.getLocation();
        RegionLocation end = new RegionLocation(location, ability.getRegion());
        map.removeTransport(transporter, start);
        map.addTransport(transporter, end);
        ability.getTransporter().getOwner().updateTransporterAbilities();
    }

    public void execute(DockatRiver1Ability ability) {executeRiverDock(ability);}
    public void execute(DockatRiver2Ability ability) {executeRiverDock(ability);}
    public void execute(DockatRiver3Ability ability) {executeRiverDock(ability);}
    public void execute(DockatRiver4Ability ability) {executeRiverDock(ability);}
    public void execute(DockatRiver5Ability ability) {executeRiverDock(ability);}
    public void execute(DockatRiver6Ability ability) {executeRiverDock(ability);}
    
    public void execute(UndockAbility ability) {
        Transporter transporter = ability.getTransporter();
        RegionLocation start = map.getTransportRegionLocation(transporter);
        Location location = start.getLocation();
        RegionLocation end = new RegionLocation(location, 7);
        map.removeTransport(transporter, start);
        map.addTransport(transporter, end);
        ability.getTransporter().getOwner().updateTransporterAbilities();
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
}
