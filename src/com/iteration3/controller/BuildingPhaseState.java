package com.iteration3.controller;

import javafx.scene.input.KeyEvent;

/**
 * Created by Clay on 4/14/2017.
 */
public class BuildingPhaseState implements ControlDispatchState {
    private ControlDispatch dispatch;
    private BuildingController buildingController;


    public BuildingPhaseState(ControlDispatch dispatch) {
        buildingController = new BuildingController();
        this.dispatch = dispatch;
    }

    @Override
    public void handleInput(KeyEvent event) {

    }

    @Override
    public void nextState() {
        dispatch.changeState(new WonderPhaseState(dispatch));
    }
}