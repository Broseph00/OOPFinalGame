package com.iteration3.controller;

import javafx.scene.input.KeyEvent;

/**
 * Created by Clay on 4/13/2017.
 */
public class ProductionPhaseState implements ControlDispatchState {
    private ControlDispatch dispatch;
    private ProductionController productionController;

    public ProductionPhaseState(ControlDispatch dispatch) {
        productionController = new ProductionController();
        this.dispatch = dispatch;
    }

    @Override
    public void handleInput(KeyEvent event) {

    }

    @Override
    public void nextState() {
        dispatch.changeState(new MovementPhaseState(dispatch));
    }
}
