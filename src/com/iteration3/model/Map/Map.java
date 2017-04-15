package com.iteration3.model.Map;

import java.util.ArrayList;
import java.util.HashMap;

import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Tiles.SeaTerrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.TerrainTypeVisitor;


public class Map {

    private HashMap<Location, Tile> tiles;
    private HashMap<Location, River> rivers;
    private HashMap<Location, ArrayList<Integer>> bridges;
    private HashMap<Location, ArrayList<Wall>> walls;
    private HashMap<Location, Region> regions;
    private HashMap<RegionLocation, Transporter> transports;
    private HashMap<RegionLocation, ResourceList> resources;
    private HashMap<Location, ArrayList<Location>> roads;

    public Map() {
        tiles = new HashMap<>();
        rivers = new HashMap<>();
        bridges = new HashMap<>();
        walls = new HashMap<>();
        regions = new HashMap<>();
        transports = new HashMap<>();
        resources = new HashMap<>();
        roads = new HashMap<>();
    }

    public boolean checkAdjacency(Location loc1, Location loc2){
        if(loc1.getNorth().equals(loc2)){
            return true;
        }
        else if(loc1.getNorthEast().equals(loc2)){
            return true;
        }
        else if(loc1.getSouthEast().equals(loc2)){
            return true;
        }
        else if(loc1.getSouth().equals(loc2)){
            return true;
        }
        else if(loc1.getSouthWest().equals(loc2)){
            return true;
        }
        else if(loc1.getNorthWest().equals(loc2)){
            return true;
        }
        return false;
    }

    //TODO DIFFERENT VALIDATIONS FOR LAND, ROAD RESTRICTED, AND WATER TRANSPORTERS
    public boolean validateLandMove(RegionLocation start, int exitRegion, int exitEdge, Player owner, int moves){
        Location location = start.getLocation();
        Location toLocation = location.getLocationEdge(exitEdge);
        if(!containsRoad(location,toLocation) && moves<2){
            return false;
        }
        Region region = this.regions.get(location);
        Boolean connectedRegion = region.connected(start.getRegion(), exitRegion);
        Boolean passableWall = !wallOwnedByOpposingPlayer(location, owner, exitEdge);
        return connectedRegion && passableWall;
    }

    public boolean validateRoadMove(RegionLocation start, int exitRegion, int exitEdge, Player owner, int moves){
        Location location = start.getLocation();
        Location toLocation = location.getLocationEdge(exitEdge);
        if(!containsRoad(location,toLocation)){
            return false;
        }
        Region region = this.regions.get(location);
        Boolean connectedRegion = region.connected(start.getRegion(), exitRegion);
        Boolean passableWall = !wallOwnedByOpposingPlayer(location, owner, exitEdge);
        return connectedRegion && passableWall;
    }

    public boolean validateWaterMove(RegionLocation start, int exitRegion, int exitEdge, Player owner, int moves){
        return false;
    }

    public void addTileFromFile(Location location, Tile tile) {
        if(validateLocationRange(location)) {
            this.tiles.put(location, tile);
            this.regions.put(location, new Region());
        }
    }

    public void addRiverFromFile(Location location, River river) {
        if(validateLocationRange(location)) {
            this.rivers.put(location, river);
            this.regions.get(location).addRiver(river);
        }
    }

    public void addRoad(Location from, Location to){
        if(this.roads.containsKey(from)){
            ArrayList<Location> roadSet = roads.get(from);
            if(!roadSet.contains(to)){
                roadSet.add(to);
            }
        }
        else{
            ArrayList<Location> roadSet = new ArrayList<>();
            roadSet.add(to);
            this.roads.put(from,roadSet);
        }

        if(this.roads.containsKey(to)){
            ArrayList<Location> roadSet = roads.get(to);
            if(!roadSet.contains(from)){
                roadSet.add(from);
            }
        }
        else{
            ArrayList<Location> roadSet = new ArrayList<>();
            roadSet.add(from);
            this.roads.put(to,roadSet);
        }
    }

    // add bridge if bridge isn't there already and if size < 3 and there is river there
    public void addBridges(Location location, ArrayList<Integer> bridgesToAdd) {
        // check river is on tile and correct number of bridges
        if(this.rivers.containsKey(location) && bridgesToAdd.size() <= 3) {
            // check the whole arraylist of bridges to see if it can be inserted
            for(int i = 0; i < bridgesToAdd.size(); i++) {
                if(!this.rivers.get(location).containsRiverEdge(bridgesToAdd.get(i))) {
                    return;
                }
            }

            // add each bridge from bridges to add
            for(int i = 0; i < bridgesToAdd.size(); i++) {
                    addBridge(location, bridgesToAdd.get(i));
                    this.regions.get(location).addBridge(bridgesToAdd.get(i));
            }

        } else {
            System.out.println("Bridges not added!");
        }
    }

    // add bridge if there isn't already and there is a river there
    public void addBridge(Location location, Integer bridgeToAdd) {
        // check river is on tile and correct number of bridges
        if(this.rivers.containsKey(location)) {
            // get existing bridges
            ArrayList<Integer> newBridgeSet = new ArrayList<>();
            if(this.bridges.containsKey(location)) {
               newBridgeSet = this.bridges.get(location);
            }
            // check bridge isn't there and river is theere
            if (this.containsRiverEdge(location, bridgeToAdd) && !this.containsBridge(location, bridgeToAdd) && newBridgeSet.size() < 3) {
                newBridgeSet.add(bridgeToAdd);
                this.regions.get(location).addBridge(bridgeToAdd);
                this.bridges.put(location, newBridgeSet);
            } else {
                System.out.println("Bridge not added!");
            }
        } else {
            System.out.println("Bridge not added!");
        }
    }

    // add wall to map if it isn't between seaTiles or if there is no other Player's wall
    public void addWall(Location location, Player owner, int edge, int strength) {
        if(!this.betweenTwoSeaTiles(location, edge) && !this.wallOwnedByOpposingPlayer(location, owner, edge)) {

            HashMap<Location, Integer> oppositeWallLocation = getAdjacentWallLocation(location,edge);
            HashMap.Entry<Location,Integer> entry= oppositeWallLocation.entrySet().iterator().next();
            Location oppositeLocation = entry.getKey();
            int oppositeEdge = entry.getValue();

            // check if there are already existing walls
            ArrayList<Wall> newWallSet1 = new ArrayList<>();
            if(this.walls.containsKey(location)) {
                newWallSet1 = this.walls.get(location);
            }
            // check if there are already existing walls
            ArrayList<Wall> newWallSet2 = new ArrayList<>();
            if(this.walls.containsKey(oppositeLocation)) {
                newWallSet2 = this.walls.get(oppositeLocation);
            }

            newWallSet1.add(new WallWithOwner(owner, edge, getWallStrength(location, edge) + strength));
            this.walls.put(location, newWallSet1);

            newWallSet2.add(new WallWithOwner(owner, oppositeEdge, getWallStrength(oppositeLocation, oppositeEdge) + strength));
            this.walls.put(oppositeLocation, newWallSet2);

        } else {
            System.out.println("Wall not added!");
        }
    }

    public void removeWall(Location location, int edge) {
        // check if there are already existing walls
        HashMap<Location, Integer> oppositeWallLocation = getAdjacentWallLocation(location,edge);
        HashMap.Entry<Location,Integer> entry= oppositeWallLocation.entrySet().iterator().next();
        Location oppositeLocation = entry.getKey();
        int oppositeEdge = entry.getValue();


        ArrayList<Wall> newWallSet1 = new ArrayList<>();
        if(this.walls.containsKey(location)) {
            newWallSet1 = this.walls.get(location);
        }

        // check if there are already existing walls
        ArrayList<Wall> newWallSet2 = new ArrayList<>();
        if(this.walls.containsKey(oppositeLocation)) {
            newWallSet2 = this.walls.get(oppositeLocation);
        }

        for(int i = newWallSet1.size() - 1; i >= 0; i--) {
            if(newWallSet1.get(i).getEdge() == edge) {
                newWallSet1.remove(i);
                if(newWallSet1.size() == 0) {
                    this.walls.remove(location);
                } else {
                    this.walls.put(location, newWallSet1);
                }
            }
        }

        for(int i = newWallSet2.size() - 1; i >= 0; i--) {
            if(newWallSet2.get(i).getEdge() == oppositeEdge) {
                newWallSet2.remove(i);
                if(newWallSet2.size() == 0) {
                    this.walls.remove(oppositeLocation);
                }
                else {
                    this.walls.put(oppositeLocation, newWallSet2);
                }
            }
        }

    }

    public void destroyWall(Location location, int edge) {
        // check if there are already existing walls
        HashMap<Location, Integer> oppositeWallLocation = getAdjacentWallLocation(location,edge);
        HashMap.Entry<Location,Integer> entry= oppositeWallLocation.entrySet().iterator().next();
        Location oppositeLocation = entry.getKey();
        int oppositeEdge = entry.getValue();


        ArrayList<Wall> newWallSet1 = new ArrayList<>();
        if(this.walls.containsKey(location)) {
            newWallSet1 = this.walls.get(location);
        }

        // check if there are already existing walls
        ArrayList<Wall> newWallSet2 = new ArrayList<>();
        if(this.walls.containsKey(oppositeLocation)) {
            newWallSet2 = this.walls.get(oppositeLocation);
        }

        for(int i = newWallSet1.size() - 1; i >= 0; i--) {
            if(newWallSet1.get(i).getEdge() == edge) {
                int strength = newWallSet1.get(i).getStrength();
                newWallSet1.remove(i);
                newWallSet1.add(i, new WallWithoutOwner(edge, strength));
                this.walls.put(location, newWallSet1);
            }
        }

        for(int i = newWallSet2.size() - 1; i >= 0; i--) {
            if(newWallSet2.get(i).getEdge() == oppositeEdge) {
                int strength = newWallSet2.get(i).getStrength();
                newWallSet2.remove(i);
                newWallSet2.add(i, new WallWithoutOwner(oppositeEdge, strength));
                this.walls.put(oppositeLocation, newWallSet2);
            }
        }


    }

    private HashMap<Location, Integer> getAdjacentWallLocation(Location location, int edge) {
        HashMap<Location, Integer> oppositeWallLocation = new HashMap<>();

        if(edge == 1) {
            oppositeWallLocation.put(location.getNorth(), 4);
        }
        else if(edge == 2) {
            oppositeWallLocation.put(location.getNorthEast(), 5);
        }
        else if(edge == 3) {
            oppositeWallLocation.put(location.getSouthEast(), 6);
        }
        else if(edge == 4) {
            oppositeWallLocation.put(location.getSouth(), 1);
        }
        else if(edge == 5) {
            oppositeWallLocation.put(location.getSouthWest(), 2);
        }
        else if(edge == 6) {
            oppositeWallLocation.put(location.getNorthWest(), 3);
        }

        return oppositeWallLocation;
    }



    // gets the strength of a wall at a location for building on top of old walls
    private int getWallStrength(Location location, int edge) {
        if(this.walls.containsKey(location)) {
            // if there is wall in location, get strength
            ArrayList<Wall> existingWallSet = this.walls.get(location);

            // if there is neutral wall or wall of current player, add to the strength
            int strengthToAdd = 0;
            for(int i = 0; i < existingWallSet.size(); i++) {
                if(existingWallSet.get(i).getEdge() == edge) {
                    strengthToAdd = existingWallSet.get(i).getStrength();
                }
            }
            return strengthToAdd;

        }
        return 0;
    }


    // private method to see if a wall is going to be between two sea tiles
    private boolean betweenTwoSeaTiles(Location location, int edge) {
        HashMap<Location, Tile> seaTiles = this.getSeaTiles();

        // if this location isn't a seaTile
        if(!seaTiles.containsKey(location)) {
            return false;
        }

        if(edge == 1 && seaTiles.containsKey(location.getNorth())) {
            return true;
        }
        else if(edge == 2 && seaTiles.containsKey(location.getNorthEast())) {
            return true;
        }
        else if(edge == 3 && seaTiles.containsKey(location.getSouthEast())) {
            return true;
        }
        else if(edge == 4 && seaTiles.containsKey(location.getSouth())) {
            return true;
        }
        else if(edge == 5 && seaTiles.containsKey(location.getSouthWest())) {
            return true;
        }
        else if(edge == 6 && seaTiles.containsKey(location.getNorthWest())) {
            return true;
        }
        else {
            return false;
        }
    }

    // check if a wall is owned by another Player
    private boolean wallOwnedByOpposingPlayer(Location location, Player owner, int edge) {
        HashMap<Location, ArrayList<WallWithOwner>> ownedWalls = this.getAllOwnedWalls();

        // check if this Location has any opposing walls at all
        if(!ownedWalls.containsKey(location)) {
            return false;
        }
        else {
            // check if that edge is owned by other player
            for(int i = 0; i < ownedWalls.get(location).size(); i++) {
                if(ownedWalls.get(location).get(i).getEdge() == edge && ownedWalls.get(location).get(i).getOwner() != owner) {
                    return true;
                }
            }
        }

        return false;

    }

    //check if there is a road connecting two locations
    public boolean containsRoad(Location from, Location to){
        if(roads.containsKey(from)){
            return roads.get(from).contains(to);
        }
        return false;
    }

    // check if there is a river at a certain location
    public boolean containsRiverEdge(Location location, Integer i){
        if(rivers.containsKey(location)){
            if(this.rivers.get(location).getRiverEdges().contains(Integer.valueOf(i))){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    // check if there is bridge at certain location
    public boolean containsBridge(Location location, Integer i){
        if(bridges.containsKey(location)) {
            if(bridges.get(location).contains(Integer.valueOf(i))){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    // check if there is bridge at certain location
    public boolean containsWall(Location location, Integer i){
        if(walls.containsKey(location)) {
            if(walls.get(location).contains(Integer.valueOf(i))){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }


    public void clearMap() {
        rivers.clear();
        tiles.clear();
    }


    public boolean validateLocationRange(Location location) {
        if(location.getX() > Math.abs(10) || location.getY() > Math.abs(10) || location.getZ() > Math.abs(10)) {
            System.out.println("Invalid location type");
            return false;
        } else {
            return true;
        }
    }



    // getters setters and methods for debugging
    public HashMap<Location, Tile> getTiles() {
        return tiles;
    }

    public HashMap<Location, River> getRivers() {
        return rivers;
    }

    public HashMap<Location, ArrayList<Integer>> getBridges() {
        return bridges;
    }

    public HashMap<Location, ArrayList<Wall>> getWalls() {
        return walls;
    }

    public HashMap<Location, ArrayList<Location>> getRoads(){
        return roads;
    }

    public HashMap<Location, Region> getRegions() {
        return regions;
    }

    public HashMap<RegionLocation, Transporter> getTransports() {
        return transports;
    }

    public HashMap<RegionLocation, ResourceList> getResources() {
        return resources;
    }

    public void printRivers() {
        for(Location location : rivers.keySet()) {
            System.out.println(rivers.get(location) + " " + Integer.toString(location.getX()) + " " +  Integer.toString(location.getY()) + " " + Integer.toString(location.getZ()));
            rivers.get(location).printRiverEdges();
        }
    }

    public void printTiles() {
        for(Location location : tiles.keySet()) {
            System.out.println(tiles.get(location) + " " + Integer.toString(location.getX()) + " " +  Integer.toString(location.getY()) + " " + Integer.toString(location.getZ()));
            System.out.println("Terrain: " + tiles.get(location).getTerrain(new TerrainTypeVisitor()));
        }
    }

    // return list of all sea tiles
    private HashMap<Location, Tile> getSeaTiles() {
        HashMap<Location, Tile> seaTiles = new HashMap<>();
        for(Location location : tiles.keySet()) {
            if(tiles.get(location).getTerrain() instanceof SeaTerrain) {
                seaTiles.put(location, tiles.get(location));
            }
        }
        return seaTiles;
    }

    // return list of all walls not owned by the owner
    private HashMap<Location, ArrayList<WallWithOwner>> getAllOwnedWalls() {
        HashMap<Location, ArrayList<WallWithOwner>> ownedWalls = new HashMap<>();
        for(Location location : walls.keySet()) {
            // loop through all walls in wallset
            ArrayList<WallWithOwner> wallsWithOwners= new ArrayList<WallWithOwner>();
            for(int i = 0; i < walls.get(location).size(); i++) {
                // check if wall is owned by opposing player
                if(walls.get(location).get(i) instanceof WallWithOwner) {
                    wallsWithOwners.add(((WallWithOwner) walls.get(location).get(i)));
                }
            }
            if(wallsWithOwners.size() > 0) {
                ownedWalls.put(location, wallsWithOwners);
            }

        }
        return ownedWalls;
    }



}

