package com.iteration3.model.Map;

import java.util.ArrayList;
import java.util.HashMap;

import com.iteration3.model.Tiles.SeaTerrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Visitors.TerrainTypeVisitor;


public class Map {

    private HashMap<Location, Tile> tiles;
    private HashMap<Location, River> rivers;
    private HashMap<Location, ArrayList<Integer>> bridges;
    private HashMap<Location, ArrayList<Wall>> walls;

    public Map() {
        tiles = new HashMap<>();
        rivers = new HashMap<>();
        bridges = new HashMap<>();
    }

    public void addTileFromFile(Location location, Tile tile) {
        if(validateLocationRange(location)) {
            this.tiles.put(location,tile);
        }
    }

    public void addRiverFromFile(Location location, River river) {
        if(validateLocationRange(location)) {
            this.rivers.put(location, river);
        }
    }

    // add bridge if that bridge isn't already in the list and if size < 3 and there is river there
    public void addBridges(Location location, ArrayList<Integer> bridgesToAdd) {
        boolean allBridgesValid = true;
        // check river is on tile and correct number of bridges
        if(this.rivers.containsKey(location) && bridgesToAdd.size() < 3) {
            // ensures all bridges are valid
            for(int i = 0; i < bridgesToAdd.size(); i++) {
                if (!this.rivers.get(location).containsRiverEdge(bridgesToAdd.get(i))) {
                    allBridgesValid = false;
                } else {
                    System.out.println("Bridge not added!");
                }
            }
            if(allBridgesValid) {
                this.bridges.put(location, bridgesToAdd);
            }
        } else {
            System.out.println("Bridges not added!");
        }
    }

    public void addBridge(Location location, Integer bridgeToAdd) {
        // check river is on tile and correct number of bridges
        if(this.rivers.containsKey(location)) {
            // check bridge isn't there
            ArrayList<Integer> newBridgeSet = this.bridges.get(location);
            if (this.containsRiverEdge(location, bridgeToAdd)) {
                newBridgeSet.add(bridgeToAdd);
                this.bridges.put(location, newBridgeSet);
            } else {
                System.out.println("Bridge not added!");
            }
        } else {
            System.out.println("Bridge not added!");
        }
    }

    public void removeBridges(Location location, ArrayList<Integer> bridgesToRemove) {
        if(this.rivers.containsKey(location) && bridgesToRemove.size() < 3) {
            ArrayList<Integer> newBridgeSet = this.bridges.get(location);
            for(int i = 0; i < bridgesToRemove.size(); i++) {
                newBridgeSet.remove(Integer.valueOf(bridgesToRemove.get(i)));
            }
            // check to see if arraylist is empty
            if(newBridgeSet.size() > 0) {
                this.bridges.put(location, newBridgeSet);
            } else {
                this.bridges.remove(location);
            }

        }
    }

    public void removeBridge(Location location, Integer bridgeToRemove) {
        if(this.containsBridge(location, bridgeToRemove) && bridges.size() < 3) {
            ArrayList<Integer> newBridgeSet = this.bridges.get(location);

            newBridgeSet.remove(Integer.valueOf(bridgeToRemove));

            // check to see if arraylist is empty
            if(newBridgeSet.size() > 0) {
                this.bridges.put(location, newBridgeSet);
            } else {
                this.bridges.remove(location);
            }

        }
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

    private boolean isSeaTile(Location l) {
        if(tiles.get(l).getTerrain(new TerrainTypeVisitor()).equals("sea")) {
            return true;
        }
        return false;
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


}

