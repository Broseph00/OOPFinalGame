package com.iteration3.controller.Controllers;

import com.iteration3.controller.Action;
import com.iteration3.utilities.Observer;
import com.iteration3.model.GameModel;
import com.iteration3.model.Players.Player;
import com.iteration3.view.GameWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Clay on 4/14/2017.
 */
public class WonderController{

    private GameModel model;
    private GameWindow window;
    ArrayList<Observer> subscribers;
    boolean lastPlayer;
    HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> endTurn;
    int numBricks;
    Player player;

    public WonderController(GameModel model, GameWindow window, HashMap<KeyCode, Action> keyMap) {
        this.model = model;
        this.window = window;
        this.keyMap = keyMap;
        subscribers = new ArrayList<>();
        lastPlayer = false;
        numBricks = 0;

        initializeKeyMap();
        createHandlers();
    }

    private void initializeKeyMap() {
        keyMap.put(KeyCode.W, new Action() {
            public void execute() {
                numBricks++;

            }
        });

        keyMap.put(KeyCode.S, new Action() {
            public void execute() {
                numBricks--;

            }
        });

        keyMap.put(KeyCode.ENTER, new Action() {
            public void execute() {
                //model.buildBricks(player, numBricks);

            }
        });

    }

    private void createHandlers() {
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
