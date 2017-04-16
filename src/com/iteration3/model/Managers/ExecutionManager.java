package com.iteration3.model.Managers;

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

}
