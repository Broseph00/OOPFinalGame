package com.iteration3.model;

import com.iteration3.controller.ControlDispatch;
import com.iteration3.controller.PhaseStates.ControlDispatchState;
import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Buildings.Secondary.Papermill;
import com.iteration3.model.Managers.*;
import com.iteration3.model.Map.*;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Players.Wonder.Wonder;
import com.iteration3.model.Managers.WonderManager;
import com.iteration3.model.Resource.Board;
import com.iteration3.model.Resource.Goose;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Resource.Stone;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.TransportList;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.Raft;
import com.iteration3.utilities.GameLibrary;

import java.util.ArrayList;
import java.util.HashMap;

public class GameModel {
    private Map map;
    private LoadSaveStateManager loadSaveStateManager;
    private WonderManager wonderManager;
    private ExchangeManager exchangeManager;
    private ProductionManager productionManager;

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public GameModel() throws Exception{
        map = new Map();
        exchangeManager = new ExchangeManager(map);
        productionManager = new ProductionManager(map);
        wonderManager = new WonderManager(this);

        player1 = new Player(map, 1, new RegionLocation(0,0,0,1), GameLibrary.PLAYER1_COLOR);
        player2 = new Player(map, 2, new RegionLocation(0,-3,3,1), GameLibrary.PLAYER2_COLOR);
        currentPlayer = player1;
        loadSaveStateManager = new LoadSaveStateManager(map, "src/com/iteration3/RoadsAndBoatsSavedState.txt", player1, player2, getWonder());
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
    public String getTerrainType(Location location) { return map.getTerrainType(location); }

    public HashMap<Location, River> getRivers() {
        return map.getRivers();
    }

    public River getRiver(Location location) { return map.getRiver(location); }
    public ArrayList<Integer> getRiverEdges(Location location) { return map.getRiverEdges(location); }

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

    public HashMap<RegionLocation, Producer> getProducers(){
        return map.getProducers();
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
        this.map.addTransport(new Raft(player1), new RegionLocation(0, 1, -1, 7));
        this.map.addTransport(new Donkey(player1), new RegionLocation(0,0,0,4));
        this.map.addTransport(new Donkey(player1), new RegionLocation(0,0,0,5));
        this.map.addTransport(new Donkey(player1), new RegionLocation(0,0,0,6 ));
        this.map.addProducer(new Papermill(), new RegionLocation(0,0,0,6));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,1));

        this.map.addResource(new Stone(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Stone(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Stone(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Stone(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Stone(), new RegionLocation(0,0,0,1));
        this.map.addResource(new Stone(), new RegionLocation(0,0,0,1));


        this.map.addResource(new Board(), new RegionLocation(0,0,0,2));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,3));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,4));
        this.map.addResource(new Board(), new RegionLocation(0,0,0,5));
        this.map.addResource(new Stone(), new RegionLocation(0,0,0,6));
        this.map.addResource(new Goose(), player1.getStartingRegionLocation());
        this.map.addResource(new Goose(), player1.getStartingRegionLocation());
       // this.map.addRoad(new Location(0,0,0), new Location(-1,0,1));


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

    public void changeTurn() {
        if(currentPlayer == player1) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }

    public boolean validateWonderTransporter(Player player){
        RegionLocation regionLocation = player.getStartingRegionLocation();
        HashMap<RegionLocation, TransportList> transporterHashMap = map.getTransports();
        TransportList transportList = transporterHashMap.get(regionLocation);
        for(Transporter transporter : transportList.getTransports()){
            if(transporter.getOwner() == player){
                return true;
            }
        }
        return false;
    }

    public void loadState() throws Exception{
        this.loadSaveStateManager.loadState();
    }

    public void saveState() throws Exception{
        this.loadSaveStateManager.saveState();
    }

    public Wonder getWonder() {
        return wonderManager.getWonder();
    }

    public WonderManager getWonderManager() {
        return wonderManager;
    }

    public ExchangeManager getExchangeManager() {
        return exchangeManager;
    }

    public ProductionManager getProductionManager() {
        return productionManager;
    }

}
