package com.iteration3.model;

import com.iteration3.model.Buildings.Primary.*;
import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Buildings.Secondary.*;
import com.iteration3.model.Buildings.Transporter.*;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Map.Wall;
import com.iteration3.model.Resource.*;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.Land.RoadOnly.Truck;
import com.iteration3.model.Transporters.Land.RoadOnly.Wagon;
import com.iteration3.model.Transporters.TransportList;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.Raft;
import com.iteration3.model.Transporters.Water.Rowboat;
import com.iteration3.model.Transporters.Water.Steamship;
import com.iteration3.view.GameWindow;


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
        for(Location location: this.gameModel.getMap().getBridges().keySet()) {
//            for(Integer edge: this.gameModel.getMap().getBridges().get(location)) {
//                // check what edge it is, and daw rectangle in middle of that edge to cross river
//            }
        }
    }

    private void drawRoads(){
        for(Location location: this.gameModel.getMap().getRoads().keySet()) {
            for(Location otherLocation: this.gameModel.getMap().getRoads().get(location).getRoads()) {
                // draw line between locations
            }
        }
    }

    private void drawWalls(){
        for(Location location: this.gameModel.getMap().getWalls().keySet()) {
            for(Wall wall: this.gameModel.getWalls().get(location).getWalls()){
                int edge = wall.getEdge();
                // if this is a WallWithOwner, you draw colored line depending on owner
                // if this is neutral, draw white wall
            }
        }
    }

    private void drawProducers(){
        for(RegionLocation regionlocation : gameModel.getProducers().keySet()) {
            currentLocation = regionlocation.getLocation();
            Producer producer = gameModel.getProducers().get(regionlocation);
            gameWindow.drawProducer(producer.getType(), currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
        }
    }

    private void drawResources(){
        for(RegionLocation regionlocation : gameModel.getResources().keySet()) {
            currentLocation = regionlocation.getLocation();
            ResourceList resourceList = gameModel.getResources().get(regionlocation);
            for(Resource resource : resourceList.getResources()){
                gameWindow.drawResource(resource.getType(), currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
        }
    }

    private void drawTransports(){
        for(RegionLocation regionlocation : gameModel.getTransports().keySet()) {
            currentLocation = regionlocation.getLocation();
            TransportList transportList = gameModel.getTransports().get(regionlocation);
            for(Transporter transport : transportList.getTransports()){
                gameWindow.drawTransport(transport.getType(), currentLocation.getX(), currentLocation.getY(), regionlocation.getRegion());
            }
        }
    }

}
