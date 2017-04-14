package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

/**
 * Created by Clay on 4/14/2017.
 */
public class BuildingPhaseState implements ControlDispatchState {
    private GameModel model;
    private GameWindow window;
    private ControlDispatch dispatch;
    private BuildingController buildingController;
    private HashMap<KeyCode,Action> keyMap;


    public BuildingPhaseState(ControlDispatch dispatch, GameModel model, GameWindow window) {
        this.model = model;
        this.window = window;
        keyMap = new HashMap<>();
        buildingController = new BuildingController(model, window, keyMap);
        this.dispatch = dispatch;
    }

    @Override
    public void handleInput(KeyEvent event) {

    }

    @Override
    public void nextState() {
        dispatch.changeState(new WonderPhaseState(dispatch, model, window));
    }
}