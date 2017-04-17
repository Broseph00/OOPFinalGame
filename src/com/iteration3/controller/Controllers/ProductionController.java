package com.iteration3.controller.Controllers;

import com.iteration3.controller.Action;
import com.iteration3.utilities.Observable;
import com.iteration3.utilities.Observer;
import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.AbilityIterator;
import com.iteration3.model.GameModel;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.TransporterIterator;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.view.GameWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductionController implements Observable {

    GameModel model;
    GameWindow window;
    Player player;
    ArrayList<Observer> subscribers;
    boolean lastPlayer;
    HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> endTurn, useFactory;
    private Transporter currTrans;
    private Ability currAbility;

    TransporterIterator transIter;
    AbilityIterator abilityIter;
    ResourceList tileResourceList;
    ResourceList transporterResourceList;

    public ProductionController(GameModel model, GameWindow window, HashMap<KeyCode, Action> keyMap) {
        this.model = model;
        this.window = window;
        this.keyMap = keyMap;
        lastPlayer = false;
        subscribers = new ArrayList<>();

        player = model.getCurrentPlayer();
        transIter = player.getTransportIterator();
        currTrans = transIter.first();
        abilityIter = currTrans.makeAbilityIterator();

        initializeKeyMap();
        createHandlers();
        player.updateTransporterAbilities();
    }

    private void initializeKeyMap() {
        keyMap.put(KeyCode.D, new Action() {
            public void execute() {
                transIter.next();
                currTrans = transIter.current();
                tileResourceList = model.getAvailableResources(currTrans);
                transporterResourceList = currTrans.getResourceList();
                updateResourcesList();
                window.setCurrentTransporter(currTrans.getType());
            }
        });

        keyMap.put(KeyCode.A, new Action() {
            public void execute() {
                transIter.prev();
                currTrans = transIter.current();
                tileResourceList = model.getAvailableResources(currTrans);
                transporterResourceList = currTrans.getResourceList();
                updateResourcesList();
                window.setCurrentTransporter(currTrans.getType());
            }
        });

        keyMap.put(KeyCode.W, new Action() {
            public void execute() {
                abilityIter.next();
                currAbility = abilityIter.current();
                System.out.println("Ability: " + currAbility.getName());

            }
        });

        keyMap.put(KeyCode.S, new Action() {
            public void execute() {
                abilityIter.prev();
                currAbility = abilityIter.current();
                System.out.println("Ability: " + currAbility.getName());

            }
        });

        keyMap.put(KeyCode.ENTER, new Action() {
            public void execute() {
                currAbility.execute();
                player.updateTransporterAbilities();
            }
        });

    }

    private void createHandlers() {
        useFactory = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //model.nextPlayer();
                if (lastPlayer)
                    notifyAllObservers();
                lastPlayer = !lastPlayer;
            }
        };

        window.setOnClickFactoryButton(useFactory);

        endTurn = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //model.nextPlayer();
                if (lastPlayer)
                    notifyAllObservers();
                lastPlayer = !lastPlayer;
            }
        };

        window.setOnClickEndProductionTurn(endTurn);
    }

    public void addObserver(Observer obs) {
        subscribers.add(obs);
    }

    public void removeObserver(Observer obs) {
        subscribers.remove(obs);
    }

    public void notifyAllObservers() {
        for (Observer o: subscribers)
            o.update();
    }

    public void updateResourcesList(){
        String tile = "";
        tile += "Trunks: " + tileResourceList.getTrunks().size() + "\n";
        tile += "Boards: " + tileResourceList.getBoards().size() + "\n";
        tile += "Paper: " + tileResourceList.getPaper().size() + "\n";
        tile += "Goose: " + tileResourceList.getGeese().size() + "\n";
        tile += "Clay: " + tileResourceList.getClay().size() + "\n";
        tile += "Stone: " + tileResourceList.getStones().size() + "\n";
        tile += "Fuel: " + tileResourceList.getFuel().size() + "\n";
        tile += "Iron: " + tileResourceList.getIron().size() + "\n";
        tile += "Gold: " + tileResourceList.getGold().size() + "\n";
        tile += "Coins: " + tileResourceList.getCoins().size() + "\n";
        tile += "Stock: " + tileResourceList.getStock().size() + "\n";
        window.setTileResourceList(tile);

        String transporter = "";
        transporter += "Trunks: " + transporterResourceList.getTrunks() + "\n";
        transporter += "Boards: " + transporterResourceList.getBoards() + "\n";
        transporter += "Paper: " + transporterResourceList.getPaper() + "\n";
        transporter += "Goose: " + transporterResourceList.getGeese() + "\n";
        transporter += "Clay: " + transporterResourceList.getClay() + "\n";
        transporter += "Stone: " + transporterResourceList.getStones() + "\n";
        transporter += "Fuel: " + transporterResourceList.getFuel() + "\n";
        transporter += "Iron: " + transporterResourceList.getIron() + "\n";
        transporter += "Gold: " + transporterResourceList.getGold() + "\n";
        transporter += "Coins: " + transporterResourceList.getCoins() + "\n";
        transporter += "Stock: " + transporterResourceList.getStock() + "\n";
        window.setTransportResourceList(transporter);

    }
}



