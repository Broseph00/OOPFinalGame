package com.iteration3.controller.PhaseStates;

import com.iteration3.controller.*;
import com.iteration3.controller.Controllers.BuildingController;
import com.iteration3.controller.Controllers.CursorController;
import com.iteration3.controller.Controllers.TileViewController;
import com.iteration3.model.GameModel;
import com.iteration3.utilities.Observer;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

/**
 * Created by Clay on 4/14/2017.
 */
public class BuildingPhaseState implements ControlDispatchState, Observer {
    private GameModel model;
    private GameWindow window;
    private ControlDispatch dispatch;
    private BuildingController buildingController;
    private HashMap<KeyCode,Action> keyMap;
    private CursorController cursorController;
    private TileViewController tileViewController;


    public BuildingPhaseState(ControlDispatch dispatch, GameModel model, GameWindow window) {
        this.model = model;
        this.window = window;
        this.dispatch = dispatch;
        keyMap = new HashMap<>();
        buildingController = new BuildingController(model, window, keyMap);
        buildingController.addObserver(this);
        tileViewController = new TileViewController(model, window, keyMap);
        cursorController = new CursorController(model, window, keyMap);
        cursorController.addObserver(tileViewController);
    }

    @Override
    public void handleInput(KeyEvent event) {
        if (keyMap.containsKey(event.getCode()))
            keyMap.get(event.getCode()).execute();
    }

    @Override
    public void nextState() {
        dispatch.changeState(new WonderPhaseState(dispatch, model, window));
        window.swapToProductionView();
    }

    @Override
    public void update() {
        nextState();
    }
}