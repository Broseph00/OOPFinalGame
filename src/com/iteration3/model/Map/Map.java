package com.iteration3.model.Map;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.HashMap;

import com.iteration3.model.Players.Player;
import com.iteration3.model.Tiles.SeaTerrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Visitors.TerrainTypeVisitor;
import com.sun.javafx.geom.Edge;


public class Map {

    private HashMap<Location, Tile> tiles;
    private HashMap<Location, River> rivers;
    private HashMap<Location, ArrayList<Integer>> bridges;
    private HashMap<Location, ArrayList<Wall>> walls;

    public Map() {
        tiles = new HashMap<>();
        rivers = new HashMap<>();
        bridges = new HashMap<>();
        walls = new HashMap<>();
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
                this.bridges.put(location, newBridgeSet);
            } else {
                System.out.println("Bridge not added!");
            }
        } else {
            System.out.println("Bridge not added!");
        }
    }

    // remove bridges from map if it exists
    public void removeBridges(Location location, ArrayList<Integer> bridgesToRemove) {
        if(this.rivers.containsKey(location) && bridgesToRemove.size() <= 3) {

            for(int i = bridgesToRemove.size() - 1; i >= 0; i--) {
                removeBridge(location, bridgesToRemove.get(i));
            }

        }
    }

    // remove bridge from map if it exists
    public void removeBridge(Location location, Integer bridgeToRemove) {
        if(this.containsBridge(location, bridgeToRemove)) {

            ArrayList<Integer> newBridgeSet = new ArrayList<>();
            if(bridges.containsKey(location)) {
                newBridgeSet = this.bridges.get(location);
            }

            newBridgeSet.remove(Integer.valueOf(bridgeToRemove));

            // check to see if arraylist is empty, if it is remove from list
            if(newBridgeSet.size() > 0) {
                this.bridges.put(location, newBridgeSet);
            } else {
                this.bridges.remove(location);
            }

        }
    }

    // add wall to map if it isn't between seaTiles or if there is no other Player's wall
    public void addWall(Location location, Player owner, int edge, int strength) {
        if(!this.betweenTwoSeaTiles(location, edge) && !this.wallOwnedByOpposingPlayer(location, owner, edge)) {

            // check if there are already existing walls
            ArrayList<Wall> newWallSet = new ArrayList<>();
            if(this.walls.containsKey(location)) {
                newWallSet = this.walls.get(location);
            }

            newWallSet.add(new WallWithOwner(owner, edge, getWallStrength(location, edge) + strength));

            this.walls.put(location, newWallSet);

        } else {
            System.out.println("Wall not added!");
        }
    }

    public void removeWall(Location location, int edge) {
        // check if there are already existing walls
        ArrayList<Wall> newWallSet = new ArrayList<>();
        if(this.walls.containsKey(location)) {
            newWallSet = this.walls.get(location);
        }

        for(int i = newWallSet.size() - 1; i >= 0; i--) {
            if(newWallSet.get(i).getEdge() == edge) {
                newWallSet.remove(i);
            }
        }

        this.walls.put(location, newWallSet);

    }

    public void destroyWall(Location location, int edge) {
        // check if there are already existing walls
        ArrayList<Wall> newWallSet = new ArrayList<>();
        if(this.getAllOwnedWalls().containsKey(location)) {
            newWallSet = this.walls.get(location);
        }

        for(int i = newWallSet.size() - 1; i >= 0; i--) {
            if(newWallSet.get(i).getEdge() == edge) {
                int strength = newWallSet.get(i).getStrength();
                newWallSet.remove(i);
                newWallSet.add(i, new WallWithoutOwner(edge, strength));
            }
        }

        this.walls.put(location, newWallSet);
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
//    private HashMap<Location, ArrayList<Wall>> getOpposingOwnedWalls(Player owner) {
//        HashMap<Location, ArrayList<Wall>> opposingWalls = new HashMap<>();
//        for(Location location : walls.keySet()) {
//            // loop through all walls in wallset
//            for(int i = 0; i < walls.get(location).size(); i++) {
//                // check if wall is owned by opposing player
//                if(walls.get(location).get(i) instanceof WallWithOwner) {
//                    if(((WallWithOwner) walls.get(location).get(i)).getOwner() != owner) {
//                        opposingWalls.put(location, walls.get(location));
//                    }
//                }
//            }
//        }
//        return opposingWalls;
//    }

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

