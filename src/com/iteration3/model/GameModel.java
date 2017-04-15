package com.iteration3.model;

import com.iteration3.model.Managers.*;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.River;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Tiles.Terrain;
import com.iteration3.model.Tiles.Tile;

import java.io.IOException;
import java.util.ArrayList;

public class GameModel {
    private Map map;
    private ExchangeManager exchangeManager;
    private MapFileManager mapFileManager;
    private MovementManager movementManager;
    private ProductionManager productionManager;
    private TurnManager turnManager;
    private String path;
    private Player player1;
    private Player player2;

    public GameModel(){
        map = new Map();
        exchangeManager = new ExchangeManager();
        movementManager = new MovementManager(map);
        productionManager = new ProductionManager();
        turnManager = new TurnManager();
        player1 = new Player(new AbilityManager(map,movementManager),new ResearchManager());
        player2 = new Player(new AbilityManager(map,movementManager),new ResearchManager());
    }

    public void setPath(String path){
        this.path=path;
        this.mapFileManager = new MapFileManager(this.map, path);
    }

    public Map getMap(){
        return map;
    }

    public void setMap(Map map){
        this.map=map;
    }

    public void fillMapFromTextFile() throws IOException {
        mapFileManager.fillMapFromTextFile();
    }

    public void fillTextFileFromMap() throws IOException{
        mapFileManager.fillTextFileFromMap();
    }

}
