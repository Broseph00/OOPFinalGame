package com.iteration3.controller.Controllers;

import com.iteration3.controller.*;
import com.iteration3.controller.Modes.*;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Clay on 4/14/2017.
 */
public class BuildingController implements Observable {

    private GameModel model;
    private GameWindow window;
    private ArrayList<Observer> subscribers;
    private boolean lastPlayer;
    private HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> endTurn;
    private ArrayList<PhaseMode> modes;
    private PhaseMode current;
    private int index;

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

        initializeKeyMap();
        initializeModes();
        createHandlers();

    }

    private void initializeKeyMap() {
        keyMap.put(KeyCode.RIGHT, new Action() {
            public void execute() {
                //iter.next();

            }
        });

        keyMap.put(KeyCode.LEFT, new Action() {
            public void execute() {
                //iter.prev();

            }
        });

        keyMap.put(KeyCode.UP, new Action() {
            public void execute() {
                index++;
                index %= modes.size();
                current = modes.get(index);

            }
        });

        keyMap.put(KeyCode.DOWN, new Action() {
            public void execute() {
                index--;
                if (index < 0)
                    index = modes.size()-1;
                current = modes.get(index);

            }
        });

        keyMap.put(KeyCode.NUMPAD6, new Action() {
            public void execute() {
                if (current instanceof CycleMode)
                    ((CycleMode) current).next();

            }
        });

        keyMap.put(KeyCode.NUMPAD4, new Action() {
            public void execute() {
                if (current instanceof CycleMode)
                    ((CycleMode) current).next();

            }
        });

        keyMap.put(KeyCode.NUMPAD8, new Action() {
            public void execute() {
                if (current instanceof DirectionalMode)
                    ((DirectionalMode) current).execute(KeyCode.NUMPAD8);
            }
        });

        keyMap.put(KeyCode.NUMPAD9, new Action() {
            public void execute() {
                if (current instanceof DirectionalMode)
                    ((DirectionalMode) current).execute(KeyCode.NUMPAD9);
            }
        });

        keyMap.put(KeyCode.NUMPAD3, new Action() {
            public void execute() {
                if (current instanceof DirectionalMode)
                    ((DirectionalMode) current).execute(KeyCode.NUMPAD3);
            }
        });

        keyMap.put(KeyCode.NUMPAD2, new Action() {
            public void execute() {
                if (current instanceof DirectionalMode)
                    ((DirectionalMode) current).execute(KeyCode.NUMPAD2);
            }
        });

        keyMap.put(KeyCode.NUMPAD1, new Action() {
            public void execute() {
                if (current instanceof DirectionalMode)
                    ((DirectionalMode) current).execute(KeyCode.NUMPAD1);
            }
        });

        keyMap.put(KeyCode.NUMPAD7, new Action() {
            public void execute() {
                if (current instanceof DirectionalMode)
                    ((DirectionalMode) current).execute(KeyCode.NUMPAD7);
            }
        });

    }

    private void createHandlers() {
        endTurn = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                //model.nextPlayer();
            }
        };
    }

    private void initializeModes(){
        modes.add(new StructureMode(model, window));
        modes.add(new RoadMode(model, window));
        modes.add(new WallMode(model, window));
        //modes.add(new BridgeMode(model, window));
        //modes.add(new MineShaftMode(model, window));

        current = modes.get(index);

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
