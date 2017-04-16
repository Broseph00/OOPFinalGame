package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.DockatSeaAbility;
import com.iteration3.model.Abilities.MoveAbility;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.Region;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;
import com.iteration3.model.Visitors.TerrainTypeVisitor;

import java.util.ArrayList;
import java.util.Iterator;

public class ValidationManager {
    private Map map;
    public ValidationManager(Map map){
        this.map = map;
    }

    public boolean validateUndock(WaterTransporter transporter){
        return !transporter.isDocked();
    }

    public boolean validateSeaDock(WaterTransporter transporter, DockatSeaAbility dockatSeaAbility){
        if(transporter.getRemainingMovePoints()<1 || transporter.isDocked()){
            return false;
        }
        Player owner = transporter.getOwner();
        RegionLocation start = map.getTransportRegionLocation(transporter);
        int edge = dockatSeaAbility.getBorder();
        Location location = start.getLocation();
        Location toLocation = location.getLocationEdge(edge);
        Boolean onSea = getTerrain(location).equals("sea");
        Boolean toLand = !getTerrain(toLocation).equals("sea");
        Boolean passableWall = !map.wallOwnedByOpposingPlayer(location, owner, edge);
        return onSea && toLand && passableWall;
    }

    public boolean validateRiverDock(WaterTransporter transporter){
        if(transporter.getRemainingMovePoints()<1 || transporter.isDocked()){
            return false;
        }
        RegionLocation start = map.getTransportRegionLocation(transporter);
        Location location = start.getLocation();
        return map.getRivers().containsKey(location);
    }

    public boolean validateLandMove(LandTransporter transporter, MoveAbility moveAbility){
        if(transporter.getRemainingMovePoints()<1){
            return false;
        }
        Player owner = transporter.getOwner();
        int moves = transporter.getRemainingMovePoints();
        int exitRegion = moveAbility.getRegion();
        int exitEdge = moveAbility.getBorder();
        RegionLocation start = map.getTransportRegionLocation(transporter);
        Location location = start.getLocation();
        Location toLocation = location.getLocationEdge(exitEdge);
        if(!map.containsRoad(location,toLocation) && moves<2){
            return false;
        }
        Region region = map.getRegions().get(location);
        Boolean connectedRegion = region.connected(start.getRegion(), exitRegion);
        Boolean passableWall = !map.wallOwnedByOpposingPlayer(location, owner, exitEdge);
        Boolean terrainMatch = !getTerrain(toLocation).equals("sea");
        return connectedRegion && passableWall && terrainMatch;
    }

    public boolean validateRoadMove(OnRoadLandTransporter transporter, MoveAbility moveAbility){
        if(transporter.getRemainingMovePoints()<1){
            return false;
        }
        Player owner = transporter.getOwner();
        int exitRegion = moveAbility.getRegion();
        int exitEdge = moveAbility.getBorder();
        RegionLocation start = map.getTransportRegionLocation(transporter);
        Location location = start.getLocation();
        Location toLocation = location.getLocationEdge(exitEdge);
        if(!map.containsRoad(location,toLocation)){
            return false;
        }
        Region region = map.getRegions().get(location);
        Boolean connectedRegion = region.connected(start.getRegion(), exitRegion);
        Boolean passableWall = !map.wallOwnedByOpposingPlayer(location, owner, exitEdge);
        Boolean terrainMatch = !getTerrain(toLocation).equals("sea");
        return connectedRegion && passableWall && terrainMatch;
    }

    public boolean validateWaterMove(WaterTransporter transporter, MoveAbility moveAbility){
        if(transporter.getRemainingMovePoints()<1 || transporter.isDocked()){
            return false;
        }
        Player owner = transporter.getOwner();
        int exitEdge = moveAbility.getBorder();
        RegionLocation start = map.getTransportRegionLocation(transporter);
        Location location = start.getLocation();
        Location toLocation = location.getLocationEdge(exitEdge);
        //Know Transport is on river if location has a river
        if(map.getRivers().containsKey(location)){
            Boolean validRiver = map.getRivers().get(location).containsRiverEdge(exitEdge);
            Boolean passableWall = !map.wallOwnedByOpposingPlayer(location, owner, exitEdge);
            Boolean terrainMatch = !getTerrain(toLocation).equals("sea");
            //Traveling to another river
            if(terrainMatch){
                //If river exits on traveling to tile it must already be validated as a connected river
                Boolean connectedRiver = map.getRivers().containsKey(toLocation);
                return connectedRiver && validRiver && passableWall;
            }
            //Traveling to sea
            else{
                return validRiver && passableWall;
            }
        }
        //On sea tile
        else{
            Boolean terrainMatch = getTerrain(location).matches(getTerrain(toLocation));
            //If moving to sea tile its good
            if(terrainMatch){
                return true;
            }
            //If moving to land tile
            else{
                //Check it has rivers
                if(map.getRivers().containsKey(toLocation)){
                    Boolean passableWall = !map.wallOwnedByOpposingPlayer(location, owner, exitEdge);
                    //check it it has the correct river edge
                    return map.getRivers().get(toLocation).containsRiverEdge(oppositeEdge(exitEdge)) && passableWall;
                }
                //false if it doesn't have river
                else{
                    return false;
                }
            }
        }
    }

    public boolean validateResources(Transporter transporter, int boardCost, int stoneCost){
        ResourceList resourceList = getAvailableResources(transporter);
        return resourceList.getBoards().size()>=boardCost && resourceList.getStones().size()>=stoneCost;
    }

    public ResourceList getAvailableResources(Transporter transporter){
        RegionLocation regionLocation = map.getTransportRegionLocation(transporter);
        int region = regionLocation.getRegion();
        Location location = regionLocation.getLocation();
        Region regions = map.getRegions().get(location);
        ArrayList<Integer> connected = regions.getRegion(region);
        ResourceList resourceList = new ResourceList();
        Iterator<Integer> iterator = connected.iterator();
        while(iterator.hasNext()){
            int hold = iterator.next();
            RegionLocation newReg = new RegionLocation(location, hold);
            if(map.getResources().containsKey(newReg)){
                resourceList.addAll(map.getResources().get(newReg));
            }
        }
        return resourceList;
    }

    public boolean validateShore(Transporter transporter){
        RegionLocation regionLocation = map.getTransportRegionLocation(transporter);
        int region = regionLocation.getRegion();
        Location location = regionLocation.getLocation();
        Boolean river = map.getRivers().containsKey(regionLocation);
        Boolean adjacentSea = map.adjacentSea(location);
        return river || adjacentSea;
    }

    public boolean validateTerrain(Transporter transporter, String terrainType){
        RegionLocation regionLocation = map.getTransportRegionLocation(transporter);
        Location location = regionLocation.getLocation();
        return getTerrain(location).equals(terrainType);
    }

    private String getTerrain(Location location){
        if(map.getTiles().containsKey(location)){
            return map.getTiles().get(location).getTerrain(new TerrainTypeVisitor());
        }
        return "";
    }

    public boolean existingProducer(Transporter transporter){
        RegionLocation regionLocation = map.getTransportRegionLocation(transporter);
        return map.existingProducer(regionLocation);
    }

    private int oppositeEdge(int edge){
        switch (edge){
            case 1:
                return 4;
            case 2:
                return 5;
            case 3:
                return 6;
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            default:
                return edge;
        }
    }
}
