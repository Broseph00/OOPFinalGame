package com.iteration3.model.Managers;


import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.Region;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Resource.*;

import java.io.*;

public class LoadSaveStateManager {

    private String pathToSaveStateFile;
    private Map map;

    public LoadSaveStateManager(Map m, String path)  {
        this.map = m;
        this.pathToSaveStateFile = path;
    }


    public void loadState() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.pathToSaveStateFile));
        String line;

        while ((line = br.readLine()) != null) {
            String[] splitLine = line.split("\\s+");

            // determine what Object is stored per line and add it to the game
            if(splitLine[0].contains("resource")) {
                addResourceToMap(splitLine);
            }
            else if(splitLine[0].contains("transport")) {
                addTransportToMap(splitLine);
            }
            else if(splitLine[0].contains("producer")) {

            }
            else if(splitLine[0].contains("research")) {

            }
            else if(splitLine[0].contains("wall")) {

            }
            else if(splitLine[0].contains("bridge")) {

            }
            else if(splitLine[0].contains("wonder")) {

            }


        }

    }


    public void saveState() throws IOException {
        // clear file
        FileWriter fw = new FileWriter(pathToSaveStateFile, false);

        saveResourcesFromMap(fw);

        fw.close();
    }


    // LOAD HELPER FUNCTIONS *********************************************************************

    private void addResourceToMap(String[] splitLine) {

        // handle location
        int x = Integer.parseInt(splitLine[2]);
        int y = Integer.parseInt(splitLine[3]);
        int z = Integer.parseInt(splitLine[4]);
        int region = Integer.parseInt((splitLine[5]));
        String resourceType = splitLine[6];

        if(resourceType.equals("board")) {
            this.map.addResource(new Board(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("clay")) {
            this.map.addResource(new Clay(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("coin")) {
            this.map.addResource(new Coin(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("fuel")) {
            this.map.addResource(new Fuel(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("gold")) {
            this.map.addResource(new Gold(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("goose")) {
            this.map.addResource(new Goose(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("iron")) {
            this.map.addResource(new Iron(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("paper")) {
            this.map.addResource(new Paper(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("stock")) {
            this.map.addResource(new Stock(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("stone")) {
            this.map.addResource(new Stone(), new RegionLocation(x,y,z,region));
        }
        else if(resourceType.equals("trunk")) {
            this.map.addResource(new Trunk(), new RegionLocation(x,y,z,region));
        }
    }


    private void addTransportToMap(String[] splitLine) {

    }







    // SAVE HELPER FUNCTIONS *********************************************************************


    private void saveResourcesFromMap (FileWriter fw) throws IOException {
        int id = 0;
        for(RegionLocation regionLocation: map.getResources().keySet()) {

            int x = regionLocation.getX();
            int y = regionLocation.getY();
            int z = regionLocation.getZ();
            int region = regionLocation.getRegion();
            ResourceList resourceList = map.getResources().get(regionLocation);

            for(Resource resource: resourceList.getResources()) {
                String line = "resource" + id + " ::= ";
                id++;

                if(resource instanceof Board) {
                    line += x + " " + y + " " + z + " " + region + " " + "board";
                }
                else if(resource instanceof  Clay) {
                    line += x + " " + y + " " + z + " " + region + " " + "clay";
                }
                else if(resource instanceof  Coin) {
                    line += x + " " + y + " " + z + " " + region + " " + "coin";
                }
                else if(resource instanceof  Fuel) {
                    line += x + " " + y + " " + z + " " + region + " " + "fuel";
                }
                else if(resource instanceof  Gold) {
                    line += x + " " + y + " " + z + " " + region + " " + "gold";
                }
                else if(resource instanceof  Goose) {
                    line += x + " " + y + " " + z + " " + region + " " + "goose";
                }
                else if(resource instanceof  Iron) {
                    line += x + " " + y + " " + z + " " + region + " " + "iron";
                }
                else if(resource instanceof  Paper) {
                    line += x + " " + y + " " + z + " " + region + " " + "paper";
                }
                else if(resource instanceof  Stock) {
                    line += x + " " + y + " " + z + " " + region + " " + "stock";
                }
                else if(resource instanceof  Stone) {
                    line += x + " " + y + " " + z + " " + region + " " + "stone";
                }
                else if(resource instanceof  Trunk) {
                    line += x + " " + y + " " + z + " " + region + " " + "trunk";
                }

                fw.write(line + '\n');

            }

        }
    }


}
