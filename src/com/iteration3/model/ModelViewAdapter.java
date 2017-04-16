package com.iteration3.model;

import com.iteration3.model.Abilities.*;
import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Players.Research.*;
import com.iteration3.model.Tiles.*;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.view.GameWindow;
import com.iteration3.view.MainView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by LesliesLaptop on 4/11/17.
 */
//TODO: Consider breaking up this class into more manageable chunks?
public class ModelViewAdapter implements Visitor {
    private GameModel gameModel;
    private GameWindow gameWindow;
    private Location currentLocation;


    public ModelViewAdapter(GameModel gm, GameWindow gw) {
        gameModel = gm;
        gameWindow = gw;
    }

    public void update() {
        Map map = gameModel.getMap();
        try {
            MapFileManager fileManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
            fileManager.fillMapFromTextFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        map.printRivers();
        drawTiles(map);
        drawRivers(map);
    }

    private void drawTiles(Map map) {
        for(Location location : map.getTiles().keySet()) {
            currentLocation = location;
            map.getTiles().get(location).getTerrain().acceptVisitor(this);
        }


    }

    private void drawRivers(Map map) {

        for(Location location : map.getRivers().keySet()) {
            currentLocation = location;
            ArrayList<Integer> riverEdges = map.getRivers().get(location).getRiverEdges();

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
    
}
