package com.iteration3.model.Managers;

import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.River;
import com.iteration3.model.Tiles.*;
import com.iteration3.model.Visitors.TerrainTypeVisitor;
import com.iteration3.utilities.GameLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MapFileManager {

    private String pathToTextFile;
    private Map map;

    public MapFileManager(Map m, String path) {
        this.map = m;
        this.pathToTextFile = path;
    }

    // TODO: Methods to move map to text file and text file to map
    // TODO: ADD ADDITION OF WALLS ROADS TRANSPORTERS etc...
    // Reads file line by line, extracts info and creates a map out of it
    public void fillMapFromTextFile() throws IOException{
        map.clearMap();
        BufferedReader br = new BufferedReader(new FileReader(this.pathToTextFile));
        String line;
        // divide line and create Tile/Rivers
        while ((line = br.readLine()) != null) {
            String[] splitLine = line.split("\\s+");

            // handle location
            int x = Integer.parseInt(splitLine[2]);
            int y = Integer.parseInt(splitLine[3]);
            int z = Integer.parseInt(splitLine[4]);

            Location location = new Location(x, y, z);

            // handle terrain
            String terrainString = splitLine[5];
            Terrain terrain = new PastureTerrain();

            if(terrainString.equals(GameLibrary.PASTURE)) {
                terrain = new PastureTerrain();
            }
            else if(terrainString.equals(GameLibrary.WOODS)) {
                terrain = new WoodTerrain();
            }
            else if(terrainString.equals(GameLibrary.ROCK)) {
                terrain = new RockTerrain();
            }
            else if(terrainString.equals(GameLibrary.MOUNTAINS)) {
                terrain = new MountainTerrain();
            }
            else if(terrainString.equals(GameLibrary.DESERT)) {
                terrain = new DesertTerrain();
            }
            else if(terrainString.equals(GameLibrary.SEA)){
                terrain = new SeaTerrain();
            }
            else {
                System.out.println("Invalid terrain type");
                return;
            }

            Tile tile = new Tile(terrain);
            map.addTileFromFile(location, tile);

            // handle rivers if they exist
            if(splitLine.length > 6) {
                River river = new River();
                for(int i = 6; i < splitLine.length; i++) {
                    river.addRiverEdge(Integer.parseInt(splitLine[i]));
                }
                map.addRiverFromFile(location,river);
            }


        }


    }


    public void fillTextFileFromMap() throws IOException{
        // clear file
        FileWriter fw = new FileWriter(pathToTextFile, false);

        int id = 0;
        // go through all locations in the list of the map's tiles
        for(Location location : map.getTiles().keySet()) {
            // add tilename
            String line = "";
            line += "tile" + id + " ::= ";
            id++;


            // add locations and terrain
            String x = Integer.toString(location.getX());
            String y = Integer.toString(location.getY());
            String z = Integer.toString(location.getZ());

            line += x + " " + y + " " + z + " " + map.getTiles().get(location).getTerrain(new TerrainTypeVisitor());

            // add river
            if(map.getRivers().containsKey(location)) {
                River river = map.getRivers().get(location);
                for(int i = 0; i < river.getRiverEdges().size(); i++) {
                    line += " " + river.getRiverEdges().get(i);
                }
            }

            fw.write(line + '\n');

        }

        fw.close();

    }



}

