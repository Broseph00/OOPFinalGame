package com.iteration3.controller;

import javafx.scene.input.KeyEvent;

/**
 * Created by Clay on 4/13/2017.
 */
public class MovementPhaseState implements ControlDispatchState {
    private ControlDispatch dispatch;
    private MovementController movementController;


    public MovementPhaseState(ControlDispatch dispatch) {
        movementController = new MovementController();
        this.dispatch = dispatch;
    }

    @Override
    public void handleInput(KeyEvent event) {

    }

    @Override
    public void nextState() {
        dispatch.changeState(new BuildingPhaseState(dispatch));
    }
}
