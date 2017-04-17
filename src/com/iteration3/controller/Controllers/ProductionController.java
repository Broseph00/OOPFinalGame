package com.iteration3.controller.Controllers;

import com.iteration3.controller.Action;
import com.iteration3.controller.Observable;
import com.iteration3.controller.Observer;
import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.AbilityIterator;
import com.iteration3.model.GameModel;
import com.iteration3.model.Players.Player;
import com.iteration3.model.TransporterIterator;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.view.GameWindow;
import com.iteration3.view.MainView;
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
    }

    private void initializeKeyMap() {
        keyMap.put(KeyCode.RIGHT, new Action() {
            public void execute() {
                transIter.next();
                currTrans = transIter.current();

            }
        });

        keyMap.put(KeyCode.LEFT, new Action() {
            public void execute() {
                transIter.prev();
                currTrans = transIter.current();

            }
        });

        keyMap.put(KeyCode.UP, new Action() {
            public void execute() {
                abilityIter.prev();
                currAbility = abilityIter.current();

            }
        });

        keyMap.put(KeyCode.DOWN, new Action() {
            public void execute() {
                transIter.prev();
                currAbility = abilityIter.current();

            }
        });

        keyMap.put(KeyCode.ENTER, new Action() {
            public void execute() {
                currAbility.execute();
            }
        });

    }

    private void createHandlers() {
        useFactory = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //model.nextPlayer();
                lastPlayer = !lastPlayer;
                if (lastPlayer);
                notifyAllObservers();
            }
        };

        endTurn = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //model.nextPlayer();
                lastPlayer = !lastPlayer;
                if (lastPlayer);
                    notifyAllObservers();
            }
        };
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
}



