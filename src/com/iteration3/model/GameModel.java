package com.iteration3.model;

import com.iteration3.model.Managers.*;
import com.iteration3.model.Map.*;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Players.Wonder;
import com.iteration3.model.Players.WonderManager;
import com.iteration3.model.Resource.Board;
import com.iteration3.model.Resource.Goose;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Resource.Stone;
import com.iteration3.model.Tiles.Terrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.TransportList;
import com.iteration3.model.Transporters.Transporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class GameModel {
    private Map map;
    private LoadSaveStateManager loadSaveStateManager;
    private Wonder wonder;
    private WonderManager wonderManager;
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
        wonder = new Wonder();
        wonderManager = new WonderManager(wonder);
        turnManager = new TurnManager();
        player1 = new Player(map, 1, new RegionLocation(0,3,-3,1));
        player2 = new Player(map, 2, new RegionLocation(0,-3,3,1));
        currentPlayer = player1;
        loadSaveStateManager = new LoadSaveStateManager(map, "src/com/iteration3/RoadsAndBoatsSavedState.txt", player1, player2, wonder);
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();

        this.intializePlayers();
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

    public ResourceList getAvailableResources(Transporter transporter){
        return map.getAvailableResources(transporter);
    }
    public void intializePlayers() {
        // initialize player1
        this.map.addTransport(new Donkey(player1), player1.getStartingRegionLocation());
        this.map.addTransport(new Donkey(player1), player1.getStartingRegionLocation());
        this.map.addTransport(new Donkey(player1), player1.getStartingRegionLocation());
        this.map.addResource(new Board(), player1.getStartingRegionLocation());
        this.map.addResource(new Board(), player1.getStartingRegionLocation());
        this.map.addResource(new Board(), player1.getStartingRegionLocation());
        this.map.addResource(new Board(), player1.getStartingRegionLocation());
        this.map.addResource(new Board(), player1.getStartingRegionLocation());
        this.map.addResource(new Stone(), player1.getStartingRegionLocation());
        this.map.addResource(new Goose(), player1.getStartingRegionLocation());
        this.map.addResource(new Goose(), player1.getStartingRegionLocation());

        // initialize player2
        this.map.addTransport(new Donkey(player2), player2.getStartingRegionLocation());
        this.map.addTransport(new Donkey(player2), player2.getStartingRegionLocation());
        this.map.addTransport(new Donkey(player2), player2.getStartingRegionLocation());
        this.map.addResource(new Board(), player2.getStartingRegionLocation());
        this.map.addResource(new Board(), player2.getStartingRegionLocation());
        this.map.addResource(new Board(), player2.getStartingRegionLocation());
        this.map.addResource(new Board(), player2.getStartingRegionLocation());
        this.map.addResource(new Board(), player2.getStartingRegionLocation());
        this.map.addResource(new Stone(), player2.getStartingRegionLocation());
        this.map.addResource(new Goose(), player2.getStartingRegionLocation());
        this.map.addResource(new Goose(), player2.getStartingRegionLocation());
    }

}
