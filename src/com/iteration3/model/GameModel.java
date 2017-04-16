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
    private MovementManager movementManager;
    private ProductionManager productionManager;
    private TurnManager turnManager;
    private Player player1;
    private Player player2;
    private ValidationManager validationManager;
    private ExecutionManager executionManager;

    public GameModel(){
        map = new Map();
        validationManager = new ValidationManager(map);
        executionManager = new ExecutionManager(map);
        exchangeManager = new ExchangeManager(map);
        movementManager = new MovementManager(validationManager, executionManager);
        productionManager = new ProductionManager();
        turnManager = new TurnManager();
        player1 = new Player(map, 1, movementManager);
        player2 = new Player(map, 2, movementManager);
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

}
