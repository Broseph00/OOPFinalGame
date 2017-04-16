package com.iteration3.model.Managers;

import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.Region;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.TerrainTypeVisitor;

public class ValidationManager {
    private Map map;
    public ValidationManager(Map map){
        this.map = map;
    }

    public boolean validateLandMove(RegionLocation start, int exitRegion, int exitEdge, Player owner, int moves){
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

    public boolean validateRoadMove(RegionLocation start, int exitRegion, int exitEdge, Player owner){
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

    public boolean validateWaterMove(RegionLocation start, int exitEdge, Player owner){
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
    private String getTerrain(Location location){
        if(map.getTiles().containsKey(location)){
            return map.getTiles().get(location).getTerrain(new TerrainTypeVisitor());
        }
        return "";
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

    public boolean validateResourceCost(Transporter transporter, int boardCost, int stoneCost){
        return true;
    }
}
