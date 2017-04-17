package com.iteration3.model;

import com.iteration3.model.Managers.*;
import com.iteration3.model.Map.*;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Tiles.Terrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Transporters.TransportList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameModel {
    private Map map;
    private ExchangeManager exchangeManager;
    private ProductionManager productionManager;
    private TurnManager turnManager;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public GameModel() throws Exception{
        map = new Map();
        exchangeManager = new ExchangeManager(map);
        productionManager = new ProductionManager();
        turnManager = new TurnManager();
        player1 = new Player(map, 1);
        player2 = new Player(map, 2);
        currentPlayer = player1;

        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
    }


    public Map getMap(){
        return map;
    }

    public void setMap(Map map){
        this.map=map;
    }

    public Player getPlayer1(){
        return player1;
    }

    public  Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public HashMap<Location, Tile> getTiles() {
        return map.getTiles();
    }

    public HashMap<Location, River> getRivers() {
        return map.getRivers();
    }

    public HashMap<Location, BridgeList> getBridges() {
        return map.getBridges();
    }

    public HashMap<Location, WallList> getWalls() {
        return map.getWalls();
    }

    public HashMap<Location, RoadList> getRoads(){
        return map.getRoads();
    }

    public HashMap<Location, Region> getRegions() {
        return map.getRegions();
    }

    public HashMap<RegionLocation, TransportList> getTransports() {
        return map.getTransports();
    }

    public HashMap<RegionLocation, ResourceList> getResources() {
        return map.getResources();
    }

    public Tile getTile(Location location) {
        return getTiles().get(location);
    }
}
