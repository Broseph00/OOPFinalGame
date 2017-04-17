package com.iteration3.model.Managers;


import com.iteration3.model.Map.*;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Players.Research.*;
import com.iteration3.model.Resource.*;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.Land.RoadOnly.Truck;
import com.iteration3.model.Transporters.Land.RoadOnly.Wagon;
import com.iteration3.model.Transporters.TransportList;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.Raft;
import com.iteration3.model.Transporters.Water.Rowboat;
import com.iteration3.model.Transporters.Water.Steamship;
import com.iteration3.model.Transporters.Water.WaterTransporter;

import java.io.*;

public class LoadSaveStateManager {

    private String pathToSaveStateFile;
    private Map map;
    private Player player1;
    private Player player2;

    public LoadSaveStateManager(Map m, String path, Player player1, Player player2)  {
        this.map = m;
        this.pathToSaveStateFile = path;
        this.player1 = player1;
        this.player2 = player2;
    }


    public void loadState() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.pathToSaveStateFile));
        String line;

        while ((line = br.readLine()) != null) {
            String[] splitLine = line.split("\\s+");

            // determine what Object is stored per line and add it to the game
            if(splitLine[0].contains("resource")) {
                loadResource(splitLine);
            }
            else if(splitLine[0].contains("transport")) {
                loadTransport(splitLine);
            }
            else if(splitLine[0].contains("producer")) {
                loadProducer(splitLine);
            }
            else if(splitLine[0].contains("research")) {
                loadResearch(splitLine);
            }
            else if(splitLine[0].contains("wall")) {
                loadWalls(splitLine);
            }
            else if(splitLine[0].contains("bridge")) {
                loadBridges(splitLine);
            }
            else if(splitLine[0].contains("wonder")) {

            }


        }

    }


    public void saveState() throws IOException {
        // clear file
        FileWriter fw = new FileWriter(pathToSaveStateFile, false);

        saveResourcesFromMap(fw);
        saveTransportsFromMap(fw);
        saveWallsFromMap(fw);
        saveBridgesFromMap(fw);
        saveResearch(fw);

        fw.close();
    }


    // LOAD HELPER FUNCTIONS *********************************************************************

    private void loadResource(String[] splitLine) {

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


    private void loadTransport(String[] splitLine) {
        // handle location
        int x = Integer.parseInt(splitLine[2]);
        int y = Integer.parseInt(splitLine[3]);
        int z = Integer.parseInt(splitLine[4]);
        int region = Integer.parseInt((splitLine[5]));
        String transportType = splitLine[6];
        Player player;

        // get the correct player and initialize dummy transport
        if(splitLine[7].equals("player1")) {
            player = this.player1;
        } else {
            player = this.player2;
        }
        Transporter transport = new Donkey(player);

        // handle each transport type
        if(transportType.contains("truck")) {
            transport = new Truck(player);
        }
        else if(transportType.contains("wagon")) {
            transport = new Wagon(player);
        }
        else if(transportType.contains("donkey")) {
            transport = new Donkey(player);
        }
        else if(transportType.contains("raft")) {
            transport = new Raft(player);
            if(transportType.contains("docked")) {
                ((WaterTransporter) transport).dock();
            }
        }
        else if(transportType.contains("rowboat")) {
            transport = new Rowboat(player);
            if(transportType.contains("docked")) {
                ((WaterTransporter) transport).dock();
            }
        }
        else if(transportType.contains("steamship")) {
            transport = new Steamship(player);
            if(transportType.contains("docked")) {
                ((WaterTransporter) transport).dock();
            }
        }


        // add resources for each transport
        if(splitLine.length > 8){
            for(int i = 9; i < splitLine.length; i++) {
                String resourceType = splitLine[i];

                if(resourceType.equals("board")) {
                    transport.addResource(new Board());
                }
                else if(resourceType.equals("clay")) {
                    transport.addResource(new Clay());
                }
                else if(resourceType.equals("coin")) {
                    transport.addResource(new Coin());
                }
                else if(resourceType.equals("fuel")) {
                    transport.addResource(new Fuel());
                }
                else if(resourceType.equals("gold")) {
                    transport.addResource(new Gold());
                }
                else if(resourceType.equals("goose")) {
                    transport.addResource(new Goose());
                }
                else if(resourceType.equals("iron")) {
                    transport.addResource(new Iron());
                }
                else if(resourceType.equals("paper")) {
                    transport.addResource(new Paper());
                }
                else if(resourceType.equals("stock")) {
                    transport.addResource(new Stock());
                }
                else if(resourceType.equals("stone")) {
                    transport.addResource(new Stock());
                }
                else if(resourceType.equals("trunk")) {
                    transport.addResource(new Trunk());
                }
            }
        }


        this.map.addTransport(transport, new RegionLocation(x,y,z,region));

    }


    private void loadProducer(String[] splitLine) {

        // handle location
        int x = Integer.parseInt(splitLine[2]);
        int y = Integer.parseInt(splitLine[3]);
        int z = Integer.parseInt(splitLine[4]);
        int region = Integer.parseInt((splitLine[5]));
        String producerType = splitLine[6];



    }


    private void loadBridges(String[] splitLine) {

        // handle location
        int x = Integer.parseInt(splitLine[2]);
        int y = Integer.parseInt(splitLine[3]);
        int z = Integer.parseInt(splitLine[4]);

        if(splitLine.length > 5){
            for(int i = 6; i < splitLine.length; i++){
                this.map.addBridge(new Location(x,y,z), Integer.parseInt(splitLine[i]));
            }
        }

    }



    private void loadWalls(String[] splitLine) {

        // handle location
        int x = Integer.parseInt(splitLine[2]);
        int y = Integer.parseInt(splitLine[3]);
        int z = Integer.parseInt(splitLine[4]);

        if(splitLine.length > 5) {
            for(int i = 6; i < splitLine.length; i++) {
                String wallString = splitLine[i];

                if(wallString.length() > 6) {
                    Player player;
                    if(wallString.charAt(6) == '1') {
                        player = this.player1;
                    } else {
                        player = player2;
                    }

                    int edge = Integer.parseInt(Character.toString(wallString.charAt(8)));
                    int strength = Integer.parseInt(Character.toString(wallString.charAt(10)));

                    map.addWall(new Location(x,y,z),player,edge,strength);
                }
                else {

                    int edge = Integer.parseInt(Character.toString(wallString.charAt(0)));
                    int strength = Integer.parseInt(Character.toString(wallString.charAt(2)));

                    map.addNeutralWall(new Location(x,y,z), edge,strength);
                }
            }
        }


    }

    private void loadResearch(String[] splitLine) {
        String researchName = splitLine[2];
        Player player;
        if(splitLine[3].equals("player1")) {
            player = this.player1;
        } else {
            player = this.player2;
        }

        if(researchName.equals("enlargement")) {
            player.getResearchManager().completeResearch(new EnlargementResearch());
        }
        else if(researchName.equals("newShaft")) {
            player.getResearchManager().completeResearch(new NewShaftResearch());
        }
        else if(researchName.equals("oil")) {
            player.getResearchManager().completeResearch(new OilResearch());
        }
        else if(researchName.equals("rowing")) {
            player.getResearchManager().completeResearch(new RowingResearch());
        }
        else if(researchName.equals("ship")) {
            player.getResearchManager().completeResearch(new ShipResearch());
        }
        else if(researchName.equals("specialization")) {
            player.getResearchManager().completeResearch(new SpecializationResearch());
        }
        else if(researchName.equals("truck")) {
            player.getResearchManager().completeResearch(new TruckResearch());
        }


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


    private void saveTransportsFromMap (FileWriter fw) throws IOException {
        int id = 0;
        for (RegionLocation regionLocation : map.getTransports().keySet()) {
            int x = regionLocation.getX();
            int y = regionLocation.getY();
            int z = regionLocation.getZ();
            int region = regionLocation.getRegion();

            TransportList transportList = map.getTransports().get(regionLocation);

            for(Transporter transport: transportList.getTransports()) {
                String line = "transport" + id + " ::= ";
                id++;

                if(transport instanceof Truck) {
                    line += x + " " + y + " " + z + " " + region + " " + "truck" + " player" + transport.getOwner().getId() + " ";
                }
                else if(transport instanceof Wagon) {
                    line += x + " " + y + " " + z + " " + region + " " + "wagon" + " player" + transport.getOwner().getId() + " ";
                }
                else if(transport instanceof Donkey) {
                    line += x + " " + y + " " + z + " " + region + " " + "wagon" + " player" + transport.getOwner().getId() + " ";
                }
                else if(transport instanceof Raft) {
                    String raftString = "raft";
                    if(((WaterTransporter) transport).isDocked()){
                        raftString += "-docked";
                    }

                    line += x + " " + y + " " + z + " " + region + " " + raftString + " player" + transport.getOwner().getId() + " ";
                }
                else if(transport instanceof Rowboat) {
                    String rowboatString = "rowboat";
                    if(((WaterTransporter) transport).isDocked()){
                        rowboatString += "-docked";
                    }

                    line += x + " " + y + " " + z + " " + region + " " + rowboatString + " player" + transport.getOwner().getId() + " ";
                }
                else if(transport instanceof Steamship) {
                    String steamshipString = "steamship";
                    if(((WaterTransporter) transport).isDocked()){
                        steamshipString += "-docked";
                    }

                    line += x + " " + y + " " + z + " " + region + " " + steamshipString + " player" + transport.getOwner().getId() + " ";
                }

                if(transport.getResourceList().getResources().size() > 0) {
                    line += "::= ";
                    for(Resource resource: transport.getResourceList().getResources()) {
                        if(resource instanceof Board) {
                            line += "board ";
                        }
                        else if(resource instanceof  Clay) {
                            line += "clay ";
                        }
                        else if(resource instanceof  Coin) {
                            line += "coin ";
                        }
                        else if(resource instanceof  Fuel) {
                            line += "fuel ";
                        }
                        else if(resource instanceof  Gold) {
                            line += "gold ";
                        }
                        else if(resource instanceof  Goose) {
                            line += "goose ";
                        }
                        else if(resource instanceof  Iron) {
                            line += "iron ";
                        }
                        else if(resource instanceof  Paper) {
                            line += "paper ";
                        }
                        else if(resource instanceof  Stock) {
                            line += "stock ";
                        }
                        else if(resource instanceof  Stone) {
                            line += "stone ";
                        }
                        else if(resource instanceof  Trunk) {
                            line += "trunk ";
                        }
                    }
                }

                fw.write(line + '\n');
            }
        }
    }

    private void saveBridgesFromMap(FileWriter fw) throws IOException {
        int id = 0;
        for (Location location : map.getBridges().keySet()) {
            int x = location.getX();
            int y = location.getY();
            int z = location.getZ();

            BridgeList bridgeList = map.getBridges().get(location);

            String line = "bridge" + id + " ::= " + Integer.toString(x) + " " + Integer.toString(y) + " " + Integer.toString(z) + " ::= ";
            id++;

            for(int bridge: bridgeList.getBridges()) {
                line += Integer.toString(bridge) + " ";
            }

            fw.write(line + '\n');
        }
    }

    private void saveWallsFromMap(FileWriter fw) throws IOException {
        int id = 0;
        for(Location location: map.getWalls().keySet()) {
            int x = location.getX();
            int y = location.getY();
            int z = location.getZ();

            WallList wallList = this.map.getWalls().get(location);

            String line = "wall" + id + " ::= " + Integer.toString(x) + " " + Integer.toString(y) + " " + Integer.toString(z) + " ::= ";
            id++;

            for(Wall wall: wallList.getWalls()) {
                if(wall instanceof WallWithOwner) {
                    String playerID = "";
                    if(((WallWithOwner) wall).getOwner() == player1) {
                        playerID = "1";
                    } else {
                        playerID = "2";
                    }
                    line += "player" + playerID + ":";
                }

                int edge = wall.getEdge();
                int strength = wall.getStrength();

                line += Integer.toString(edge) + "-" + Integer.toString(strength) + " ";

            }

            fw.write(line + '\n');
        }
    }


    private void saveResearch(FileWriter fw) throws IOException{
        int id = 0;
        ResearchManager player1Research = player1.getResearchManager();
        ResearchManager player2Research = player2.getResearchManager();

        if(player1Research.isFinishedEnlargementResearch()) {
            String line = "research" + id + " ::= enlargement player1";
            id++;
            fw.write(line + '\n');
        }
        if(player1Research.isFinishedNewShaftResearch()) {
            String line = "research" + id + " ::= newShaft player1";
            id++;
            fw.write(line + '\n');
        }
        if(player1Research.isFinishedOilResearch()) {
            String line = "research" + id + " ::= oil player1";
            id++;
            fw.write(line + '\n');
        }
        if(player1Research.isFinishedRowingResearch()) {
            String line = "research" + id + " ::= rowing player1";
            id++;
            fw.write(line + '\n');
        }
        if(player1Research.isFinishedShipResearch()) {
            String line = "research" + id + " ::= ship player1";
            id++;
            fw.write(line + '\n');
        }
        if(player1Research.isFinishedSpecializationResearch()) {
            String line = "research" + id + " ::= specialization player1";
            id++;
            fw.write(line + '\n');
        }
        if(player1Research.isFinishedTruckResearch()) {
            String line = "research" + id + " ::= truck player1";
            id++;
            fw.write(line + '\n');
        }


        if(player2Research.isFinishedEnlargementResearch()) {
            String line = "research" + id + " ::= enlargement player2";
            id++;
            fw.write(line + '\n');
        }
        if(player2Research.isFinishedNewShaftResearch()) {
            String line = "research" + id + " ::= newShaft player2";
            id++;
            fw.write(line + '\n');
        }
        if(player2Research.isFinishedOilResearch()) {
            String line = "research" + id + " ::= oil player2";
            id++;
            fw.write(line + '\n');
        }
        if(player2Research.isFinishedRowingResearch()) {
            String line = "research" + id + " ::= rowing player2";
            id++;
            fw.write(line + '\n');
        }
        if(player2Research.isFinishedShipResearch()) {
            String line = "research" + id + " ::= ship player2";
            id++;
            fw.write(line + '\n');
        }
        if(player2Research.isFinishedSpecializationResearch()) {
            String line = "research" + id + " ::= specialization player2";
            id++;
            fw.write(line + '\n');
        }
        if(player2Research.isFinishedTruckResearch()) {
            String line = "research" + id + " ::= truck player2";
            id++;
            fw.write(line + '\n');
        }


    }



}
