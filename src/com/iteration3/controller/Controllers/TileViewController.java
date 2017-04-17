package com.iteration3.controller.Controllers;
/*--------------------------------------------------------------------------------------
|    TileViewController: Created by Ricardo on 3/28/17.
|---------------------------------------------------------------------------------------
|   Controller responsible for defining actions related to cycling through tiles
|   options and finally submitting a tile for creation
---------------------------------------------------------------------------------------*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.iteration3.controller.Action;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Tiles.Terrain;
import com.iteration3.utilities.Observer;

import javafx.scene.input.KeyCode;

import com.iteration3.model.GameModel;

import com.iteration3.view.GameWindow;

public class TileViewController implements Observer {
    private GameModel model;
    private GameWindow window;
    private HashMap<KeyCode,Action> keyMap;
    private HashMap<String, Terrain> terrainMap;
    private HashMap<String,ArrayList<Integer>> riverMap;
    private ArrayList<String> terrainTypes;
    private ArrayList<String> riverTypes;

    int selectedTerrainIndex;
    int selectedRiverIndex;
    Location cursorLocation;

    public TileViewController(GameModel model, GameWindow window, HashMap<KeyCode,Action> keyMap){
        this.model = model;
        this.keyMap = keyMap;
        this.window = window;

        terrainMap = new HashMap<>();
        riverMap = new HashMap<>();
        terrainTypes = new ArrayList<>();
        riverTypes = new ArrayList<>();

        intializeTerrainOptions();
        intializeRiverOptions();

        selectedTerrainIndex = 0;
        selectedRiverIndex = 0;
        cursorLocation = window.getCursorLocation();

        this.window.clearPreviewImage();
        displayCurrentTerrain();
        displayCurrentRiver();
    }

    public String getSelectedTerrainType() {
        return terrainTypes.get(selectedTerrainIndex);
    }


    public ArrayList<Integer> getCurrentRiverEdges() {
        System.out.println(getSelectedRiverType());
        ArrayList<Integer> newList = new ArrayList<Integer>(riverMap.get(getSelectedRiverType()) );

        return newList;
    }


    public String getSelectedRiverType() {
        return riverTypes.get(selectedRiverIndex);
    }

    public Terrain getSelectedTerrain() {
        return terrainMap.get(terrainTypes.get(selectedTerrainIndex));
    }

    public void displayCurrentTerrain() {
        String terrain = model.getTerrainType(cursorLocation);
        char upperCase = terrain.substring(0).toUpperCase().toCharArray()[0];
        System.out.println(upperCase);
        terrain = terrain.replace(terrain.charAt(0), upperCase);
        terrain = "big" + terrain;
        System.out.println(terrain);
        window.drawPreviewImage(terrain);
    }

    public void displayCurrentRiver() {
        ArrayList<Integer> edges = model.getRiverEdges(cursorLocation);
        displayRiverEdges(edges);

    }

    public void displayRiverEdges(ArrayList<Integer> riverEdges) {

        // handle river sources
        if(riverEdges.size() == 1) {
            if(riverEdges.contains(1)) {
                window.drawPreviewImage("bigSource1");
            }
            else if(riverEdges.contains(2)) {
                window.drawPreviewImage("bigSource2");
            }
            else if(riverEdges.contains(3)) {
                window.drawPreviewImage("bigSource3");
            }
            else if(riverEdges.contains(4)) {
                window.drawPreviewImage("bigSource4");
            }
            else if(riverEdges.contains(5)) {
                window.drawPreviewImage("bigSource5");
            }
            else if(riverEdges.contains(6)) {
                window.drawPreviewImage("bigSource6");
            }
        }
        else if(riverEdges.size() == 2) {
            // handle adjacent rivers
            if(riverEdges.contains(1) && riverEdges.contains(2)) {
                window.drawPreviewImage("bigAdj1");
            }
            else if(riverEdges.contains(2) && riverEdges.contains(3)) {
                window.drawPreviewImage("bigAdj2");
            }
            else if(riverEdges.contains(3) && riverEdges.contains(4)) {
                window.drawPreviewImage("bigAdj3");
            }
            else if(riverEdges.contains(4) && riverEdges.contains(5)) {
                window.drawPreviewImage("bigAdj4");
            }
            else if(riverEdges.contains(5) && riverEdges.contains(6)) {
                window.drawPreviewImage("bigAdj5");
            }
            else if(riverEdges.contains(6) && riverEdges.contains(1)) {
                window.drawPreviewImage("bigAdj6");
            }
            // handle angled
            else if(riverEdges.contains(1) && riverEdges.contains(3)) {
                window.drawPreviewImage("bigAngled1");
            }
            else if(riverEdges.contains(2) && riverEdges.contains(4)) {
                window.drawPreviewImage("bigAngled2");
            }
            else if(riverEdges.contains(3) && riverEdges.contains(5)) {
                window.drawPreviewImage("bigAngled3");
            }
            else if(riverEdges.contains(4) && riverEdges.contains(6)) {
                window.drawPreviewImage("bigAngled4");
            }
            else if(riverEdges.contains(5) && riverEdges.contains(1)) {
                window.drawPreviewImage("bigAngled5");
            }
            else if(riverEdges.contains(6) && riverEdges.contains(2)) {
                window.drawPreviewImage("bigAngled6");
            }
            // handle straight
            else if(riverEdges.contains(1) && riverEdges.contains(4)) {
                window.drawPreviewImage("bigStraight1");
            }
            else if(riverEdges.contains(2) && riverEdges.contains(5)) {
                window.drawPreviewImage("bigStraight2");
            }
            else if(riverEdges.contains(3) && riverEdges.contains(6)) {
                window.drawPreviewImage("bigStraight3");
            }

        }
        // handle triple rivers
        else if(riverEdges.size() == 3) {
            if(riverEdges.contains(1)) {
                window.drawPreviewImage("bigTri1");
            }
            else {
                window.drawPreviewImage("bigTri2");
            }
        }

    }

    public void setCurrentlySelectedRiverEdges(ArrayList<Integer> edges) {
        riverMap.put(getSelectedRiverType(), edges);
    }

    private void intializeTerrainOptions() {

        terrainTypes.add("bigPasture");
        //terrainMap.put("Pasture", new PastureTerrain());

        terrainTypes.add("bigWoods");
        //terrainMap.put("Woods", new WoodsTerrain());

        terrainTypes.add("bigMountain");
        //terrainMap.put("Mountain", new MountainTerrain());

        terrainTypes.add("bigDesert");
        //terrainMap.put("Desert", new DesertTerrain());

        terrainTypes.add("bigRock");
        //terrainMap.put("Rock", new RockTerrain());

        terrainTypes.add("bigSea");
        //terrainMap.put("Sea", new SeaTerrain());

    }

    private void intializeRiverOptions() {

        riverTypes.add("None");

        riverTypes.add("Source River");
        riverMap.put("Source River", new ArrayList<Integer>(Arrays.asList(1)));

        riverTypes.add("Adjacent Edge River");
        riverMap.put("Adjacent Edge River",new ArrayList<Integer>(Arrays.asList(1,2)));

        riverTypes.add("Angled River");
        riverMap.put("Angled River",new ArrayList<Integer>(Arrays.asList(1,3)));

        riverTypes.add("Linear River");
        riverMap.put("Linear River",new ArrayList<Integer>(Arrays.asList(1,4)));

        riverTypes.add("Tri River");
        riverMap.put("Tri River",new ArrayList<Integer>(Arrays.asList(1,3,5)));


    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        cursorLocation = window.getCursorLocation();
        window.clearPreviewImage();
        displayCurrentTerrain();
        displayCurrentRiver();
    }
}