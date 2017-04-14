package com.iteration3.controller;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

public class ProductionPhaseState implements ControlDispatchState {
    private ControlDispatch dispatch;
    private ProductionController productionController;
    private HashMap<KeyCode,Action> keyMap;

    public ProductionPhaseState(ControlDispatch dispatch) {
        this.dispatch = dispatch;
        keyMap = new HashMap<>();
        productionController = new ProductionController(keyMap);
    }

    @Override
    public void handleInput(KeyEvent event) {
        if (keyMap.containsKey(event.getCode()))
            keyMap.get(event.getCode()).execute();
    }

    @Override
    public void nextState() {
        dispatch.changeState(new MovementPhaseState(dispatch));
    }
}
