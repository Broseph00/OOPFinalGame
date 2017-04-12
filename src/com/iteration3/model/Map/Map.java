package com.iteration3.model.Map;

import java.util.HashMap;

import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Visitors.TerrainTypeVisitor;


public class Map {

    private HashMap<Location, Tile> tiles;
    private HashMap<Location, River> rivers;

    public Map() {
        tiles = new HashMap<>();
        rivers = new HashMap<>();
    }

    public void addTileFromFile(Location l, Tile t) {
        if(validateLocationRange(l)) {
            tiles.put(l,t);
        }
    }

    public void addRiverFromFile(Location l, River r) {
        if(validateLocationRange(l)) {
            rivers.put(l, r);
        }
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


    public HashMap<Location, Tile> getTiles() {
        return tiles;
    }

    public HashMap<Location, River> getRivers() {
        return rivers;
    }

    public void printRivers() {
        for(Location location : rivers.keySet()) {
            System.out.println(rivers.get(location) + " " + Integer.toString(location.getX()) + " " +  Integer.toString(location.getY()) + " " + Integer.toString(location.getZ()));
            rivers.get(location).printRiverEdgesandBridges();
        }
    }

    public void printTiles() {
        for(Location location : tiles.keySet()) {
            System.out.println(tiles.get(location) + " " + Integer.toString(location.getX()) + " " +  Integer.toString(location.getY()) + " " + Integer.toString(location.getZ()));
            System.out.println("Terrain: " + tiles.get(location).getTerrain(new TerrainTypeVisitor()));
        }
    }




}

