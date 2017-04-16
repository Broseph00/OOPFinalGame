package com.iteration3.model.Map;

import java.util.ArrayList;
import java.util.HashMap;

import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Tiles.SeaTerrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Transporters.TransportList;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.TerrainTypeVisitor;


public class Map {

    private HashMap<Location, Tile> tiles;
    private HashMap<Location, River> rivers;
    private HashMap<Location, ArrayList<Integer>> bridges;
    private HashMap<Location, WallList> walls;
    private HashMap<Location, Region> regions;
    private HashMap<RegionLocation, TransportList> transports;
    private HashMap<RegionLocation, ResourceList> resources;
    private HashMap<Location, ArrayList<Location>> roads;
    private HashMap<Location, Producer> producers;

    public Map() {
        tiles = new HashMap<>();
        rivers = new HashMap<>();
        bridges = new HashMap<>();
        walls = new HashMap<>();
        regions = new HashMap<>();
        transports = new HashMap<>();
        resources = new HashMap<>();
        roads = new HashMap<>();
        producers = new HashMap<>();
    }


    public void addTileFromFile(Location location, Tile tile) {
        if(validateLocationRange(location)) {
            this.tiles.put(location, tile);
            this.regions.put(location, new Region());
            this.intializeResourceList(location);
            this.intializeTansportList(location);
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

            Location oppositeLocation = location.getLocationEdge(edge);
            int oppositeEdge = oppositeEdge(edge);

            // check if there are already existing walls
            WallList newWallSet1 = new WallList();
            if(this.walls.containsKey(location)) {
                newWallSet1 = this.walls.get(location);
            }
            else{
                this.walls.put(location, newWallSet1);
            }
            // check if there are already existing walls
            WallList newWallSet2 = new WallList();
            if(this.walls.containsKey(oppositeLocation)) {
                newWallSet2 = this.walls.get(oppositeLocation);
            }
            else{
                this.walls.put(oppositeLocation, newWallSet2);
            }

            newWallSet1.add(new WallWithOwner(owner, edge, getWallStrength(location, edge) + strength));
            newWallSet2.add(new WallWithOwner(owner, oppositeEdge, getWallStrength(oppositeLocation, oppositeEdge) + strength));

        } else {
            System.out.println("Wall not added!");
        }
    }

    public void removeWall(Location location, int edge) {
        // check if there are already existing walls
        Location oppositeLocation = location.getLocationEdge(edge);
        int oppositeEdge = oppositeEdge(edge);

        WallList newWallSet1 = new WallList();
        if(this.walls.containsKey(location)) {
            newWallSet1 = this.walls.get(location);
        }

        // check if there are already existing walls
        WallList newWallSet2 = new WallList();
        if(this.walls.containsKey(oppositeLocation)) {
            newWallSet2 = this.walls.get(oppositeLocation);
        }
        newWallSet1.remove(edge);
        newWallSet2.remove(oppositeEdge);
        if(newWallSet1.isEmpty()){
            walls.remove(location);
        }
        if(newWallSet2.isEmpty()){
            walls.remove(oppositeLocation);
        }
    }

    public void destroyWall(Location location, int edge) {
        // check if there are already existing walls
        Location oppositeLocation = location.getLocationEdge(edge);
        int oppositeEdge = oppositeEdge(edge);

        WallList newWallSet1 = new WallList();
        if(this.walls.containsKey(location)) {
            newWallSet1 = this.walls.get(location);
        }
        // check if there are already existing walls
        WallList newWallSet2 = new WallList();
        if(this.walls.containsKey(oppositeLocation)) {
            newWallSet2 = this.walls.get(oppositeLocation);
        }


        newWallSet1.remove(edge);
        newWallSet1.add(new WallWithoutOwner(edge, 1));
        newWallSet2.remove(edge);
        newWallSet2.add(new WallWithoutOwner(oppositeEdge, 1));
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
            return this.rivers.get(location).containsRiverEdge(i);
        }
        return false;
    }

    // check if there is bridge at certain location
    public boolean containsBridge(Location location, Integer i){
        if(bridges.containsKey(location)) {
            return bridges.get(location).contains(Integer.valueOf(i));
        }
        return false;
    }

    // check if there is bridge at certain location
    public boolean containsWall(Location location, Integer i){
        if(walls.containsKey(location)) {
            return walls.get(location).contains(Integer.valueOf(i));
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

    public HashMap<Location, WallList> getWalls() {
        return walls;
    }

    public HashMap<Location, ArrayList<Location>> getRoads(){
        return roads;
    }

    public HashMap<Location, Region> getRegions() {
        return regions;
    }

    public HashMap<RegionLocation, TransportList> getTransports() {
        return transports;
    }

    public HashMap<RegionLocation, ResourceList> getResources() {
        return resources;
    }

    public RegionLocation getTransportRegionLocation(Transporter transport) {
        for(RegionLocation regionLocation: this.transports.keySet()) {
            TransportList transportList = this.transports.get(regionLocation);
            for(Transporter t: transportList.getTransports()){
                if(t == transport) {
                    return regionLocation;
                }
            }
        }
        System.out.println("RegionLocation for Transport not found.");
        return null;
    }

    public void removeResource(Resource r, RegionLocation regionLocation) {
        this.resources.get(regionLocation).removeResource(r);
    }

    public void addResource(Resource r, RegionLocation regionLocation) {
        this.resources.get(regionLocation).addResource(r);
    }

    public void addTransport(Transporter t, RegionLocation regionLocation) {
        this.transports.get(regionLocation).addTransport(t);
    }

    public void removeTransport(Transporter t, RegionLocation regionLocation) {
        this.transports.get(regionLocation).removeTransport(t);
    }



    /**HELPER FUNCTIONS***********************************************************************************************/
    /*****************************************************************************************************************/
    /*****************************************************************************************************************/
    /*****************************************************************************************************************/

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

    private void intializeResourceList(Location location) {
        for(int i = 1; i < 7; i++) {
            RegionLocation regionLocation = new RegionLocation(location.getX(), location.getY(), location.getZ(), i);
            this.resources.put(regionLocation, new ResourceList());
        }
    }

    private void intializeTansportList(Location location) {
        for(int i = 1; i < 7; i++) {
            RegionLocation regionLocation = new RegionLocation(location.getX(), location.getY(), location.getZ(), i);
            this.transports.put(regionLocation, new TransportList());
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

    // gets the strength of a wall at a location for building on top of old walls
    private int getWallStrength(Location location, int edge) {
        if(this.walls.containsKey(location)) {
            return walls.get(location).wallStrength(edge);
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
        return seaTiles.containsKey(location.getLocationEdge(edge));
    }

    // check if a wall is owned by another Player
    public boolean wallOwnedByOpposingPlayer(Location location, Player owner, int edge) {
        if(walls.containsKey(location)){
            return walls.get(location).oppositeOwner(owner,edge);
        }
        return false;
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