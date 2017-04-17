package com.iteration3.model;

import com.iteration3.model.Abilities.*;
import com.iteration3.model.Buildings.Primary.*;
import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Buildings.Secondary.*;
import com.iteration3.model.Buildings.Transporter.*;
import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Players.Research.*;
import com.iteration3.model.Resource.*;
import com.iteration3.model.Tiles.*;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.Land.RoadOnly.Truck;
import com.iteration3.model.Transporters.Land.RoadOnly.Wagon;
import com.iteration3.model.Transporters.TransportList;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.Raft;
import com.iteration3.model.Transporters.Water.Rowboat;
import com.iteration3.model.Transporters.Water.Steamship;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.view.GameWindow;
import com.iteration3.view.MainView;


import java.io.IOException;
import java.util.ArrayList;

//TODO: Consider breaking up this class into more manageable chunks?
public class ModelViewAdapter {
    private GameModel gameModel;
    private GameWindow gameWindow;
    private Location currentLocation;


    public ModelViewAdapter(GameModel gm, GameWindow gw) {
        gameModel = gm;
        gameWindow = gw;
    }

    public void update() {
        /*Map map = gameModel.getMap();
        try {
            MapFileManager fileManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
            fileManager.fillMapFromTextFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.printRivers();*/

        drawTiles();
        drawRivers();
        drawBridges();
        drawRoads();
        drawWalls();
        drawProducers();
        drawResources();
        drawTransports();

    }

    private void drawTiles() {
        for(Location location : gameModel.getTiles().keySet()) {
            currentLocation = location;
            gameWindow.drawTile(gameModel.getTile(currentLocation).getTerrainType(), currentLocation.getX(), currentLocation.getZ());
        }
    }

    private void drawRivers() {

        for(Location location : gameModel.getRivers().keySet()) {
            currentLocation = location;
            ArrayList<Integer> riverEdges = gameModel.getRivers().get(location).getRiverEdges();

            // handle river sources
            if(riverEdges.size() == 1) {
                if(riverEdges.contains(1)) {
                    gameWindow.drawRiver("source1",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(2)) {
                    gameWindow.drawRiver("source2",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(3)) {
                    gameWindow.drawRiver("source3",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(4)) {
                    gameWindow.drawRiver("source4",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(5)) {
                    gameWindow.drawRiver("source5",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(6)) {
                    gameWindow.drawRiver("source6",  currentLocation.getX(), currentLocation.getZ());
                }
            }
            else if(riverEdges.size() == 2) {
                // handle adjacent rivers
                if(riverEdges.contains(1) && riverEdges.contains(2)) {
                    gameWindow.drawRiver("adj1",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(2) && riverEdges.contains(3)) {
                    gameWindow.drawRiver("adj2",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(3) && riverEdges.contains(4)) {
                    gameWindow.drawRiver("adj3",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(4) && riverEdges.contains(5)) {
                    gameWindow.drawRiver("adj4",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(5) && riverEdges.contains(6)) {
                    gameWindow.drawRiver("adj5",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(6) && riverEdges.contains(1)) {
                    gameWindow.drawRiver("adj6",  currentLocation.getX(), currentLocation.getZ());
                }
                // handle angled
                else if(riverEdges.contains(1) && riverEdges.contains(3)) {
                    gameWindow.drawRiver("angled1",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(2) && riverEdges.contains(4)) {
                    gameWindow.drawRiver("angled2",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(3) && riverEdges.contains(5)) {
                    gameWindow.drawRiver("angled3",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(4) && riverEdges.contains(6)) {
                    gameWindow.drawRiver("angled4",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(5) && riverEdges.contains(1)) {
                    gameWindow.drawRiver("angled5",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(6) && riverEdges.contains(2)) {
                    gameWindow.drawRiver("angled6",  currentLocation.getX(), currentLocation.getZ());
                }
                // handle straight
                else if(riverEdges.contains(1) && riverEdges.contains(4)) {
                    gameWindow.drawRiver("straight1",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(2) && riverEdges.contains(5)) {
                    gameWindow.drawRiver("straight2",  currentLocation.getX(), currentLocation.getZ());
                }
                else if(riverEdges.contains(3) && riverEdges.contains(6)) {
                    gameWindow.drawRiver("straight3",  currentLocation.getX(), currentLocation.getZ());
                }

            }
            // handle triple rivers
            else if(riverEdges.size() == 3) {
                if(riverEdges.contains(1)) {
                    gameWindow.drawRiver("tri1",  currentLocation.getX(), currentLocation.getZ());
                }
                else {
                    gameWindow.drawRiver("tri2",  currentLocation.getX(), currentLocation.getZ());
                }
            }
        }
    }

    private void drawBridges(){
        //TODO: Handle Drawing
    }

    private void drawRoads(){
        //TODO: Handle Drawing
    }

    private void drawWalls(){
        //TODO: Handle Drawing
    }

    private void drawProducers(){
        for(RegionLocation regionlocation : gameModel.getProducers().keySet()) {
            currentLocation = regionlocation.getLocation();
            Producer producer = gameModel.getProducers().get(regionlocation);
            if(producer instanceof Claypit) {
                gameWindow.drawProducer("clayPit", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof CoalBurner){
                gameWindow.drawProducer("coalBurner", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof Mine){
                gameWindow.drawProducer("mine", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof Mint){
                gameWindow.drawProducer("mint", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof OilRig){
                gameWindow.drawProducer("oilRig", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof Papermill){
                gameWindow.drawProducer("papermill", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof StoneQuarry){
                gameWindow.drawProducer("quarry", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof RaftFactory){
                gameWindow.drawProducer("raftFactory", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof RowboatFactory){
                gameWindow.drawProducer("rowboatFactory", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof Sawmill){
                gameWindow.drawProducer("sawmill", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof SteamerFactory){
                gameWindow.drawProducer("steamerFactory", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof StockExchange){
                gameWindow.drawProducer("stockExchange", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof StoneFactory){
                gameWindow.drawProducer("stoneFactory", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof TruckFactory){
                gameWindow.drawProducer("truckFactory", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof WagonFactory){
                gameWindow.drawProducer("wagonFactory", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
            else if(producer instanceof Woodcutter){
                gameWindow.drawProducer("woodcutter", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
        }
    }

    private void drawResources(){
        for(RegionLocation regionlocation : gameModel.getResources().keySet()) {
            currentLocation = regionlocation.getLocation();
            ResourceList resourceList = gameModel.getResources().get(regionlocation);
            for(Resource resource : resourceList.getResources()){
                if(resource instanceof Board) {
                    gameWindow.drawResource("boards", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(resource instanceof Stone){
                    gameWindow.drawResource("stone", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(resource instanceof Clay){
                    gameWindow.drawResource("clay", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(resource instanceof Coin){
                    gameWindow.drawResource("coins", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(resource instanceof Fuel){
                    gameWindow.drawResource("fuel", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(resource instanceof Gold){
                    gameWindow.drawResource("gold", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(resource instanceof Goose){
                    gameWindow.drawResource("goose", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(resource instanceof Iron){
                    gameWindow.drawResource("iron", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(resource instanceof Paper){
                    gameWindow.drawResource("paper", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(resource instanceof Stock){
                    gameWindow.drawResource("stock", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
            }
        }
    }

    private void drawTransports(){
        for(RegionLocation regionlocation : gameModel.getTransports().keySet()) {
            currentLocation = regionlocation.getLocation();
            TransportList transportList = gameModel.getTransports().get(regionlocation);
            for(Transporter transport : transportList.getTransports()){
                if(transport instanceof Donkey) {
                    gameWindow.drawTransport("donkey", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(transport instanceof Wagon){
                    gameWindow.drawTransport("Wagon", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(transport instanceof Truck){
                    gameWindow.drawTransport("Truck", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(transport instanceof Raft){
                    gameWindow.drawTransport("Raft", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(transport instanceof Rowboat){
                    gameWindow.drawTransport("Rowboat", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
                else if(transport instanceof Steamship){
                    gameWindow.drawTransport("Steamship", currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
                }
            }
        }
    }

}
