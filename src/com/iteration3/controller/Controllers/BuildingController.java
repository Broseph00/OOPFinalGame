package com.iteration3.controller.Controllers;

import com.iteration3.controller.*;
import com.iteration3.controller.Modes.*;
import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.AbilityIterator;
import com.iteration3.model.GameModel;
import com.iteration3.model.Players.Player;
import com.iteration3.model.TransporterIterator;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.utilities.Observable;
import com.iteration3.utilities.Observer;
import com.iteration3.view.GameWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildingController implements Observable {

    private GameModel model;
    private GameWindow window;
    Player player;
    private ArrayList<Observer> subscribers;
    private boolean lastPlayer;
    private HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> endTurn;
    private ArrayList<PhaseMode> modes;
    private PhaseMode current;
    private int index;

    private Transporter currTrans;
    private Ability currAbility;

    TransporterIterator transIter;
    AbilityIterator abilityIter;

    //TODO: iterator over transporters
    //TODO: building modes (factory, bridge, etc)

    public BuildingController(GameModel model, GameWindow window, HashMap<KeyCode, Action> keyMap) {
        this.model = model;
        this.window = window;
        this.keyMap = keyMap;
        subscribers = new ArrayList<>();
        lastPlayer = false;
        modes = new ArrayList<>();
        index = 0;

        player = model.getCurrentPlayer();
        transIter = player.getTransportIterator();
        currTrans = transIter.first();
        abilityIter = currTrans.makeAbilityIterator();

        initializeKeyMap();
        initializeModes();
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
                abilityIter.next();
                currAbility = abilityIter.current();

            }
        });

        keyMap.put(KeyCode.DOWN, new Action() {
            public void execute() {
                abilityIter.prev();
                currAbility = abilityIter.current();

            }
        });

    }

    private void createHandlers() {
        endTurn = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //model.nextPlayer();

                if (lastPlayer)
                    notifyAllObservers();
                lastPlayer = !lastPlayer;
            }
        };
    }

    private void initializeModes(){
        //modes.add(new StructureMode(model, window));
        //modes.add(new RoadMode(model, window));
        //modes.add(new WallMode(model, window));
        //modes.add(new BridgeMode(model, window));
        //modes.add(new MineShaftMode(model, window));

        //current = modes.get(index);

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
