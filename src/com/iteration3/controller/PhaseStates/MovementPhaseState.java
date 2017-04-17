package com.iteration3.controller.PhaseStates;

import com.iteration3.controller.Action;
import com.iteration3.controller.ControlDispatch;
import com.iteration3.controller.Controllers.CursorController;
import com.iteration3.controller.Controllers.MovementController;
import com.iteration3.controller.Controllers.TileViewController;
import com.iteration3.controller.PhaseStates.BuildingPhaseState;
import com.iteration3.controller.PhaseStates.ControlDispatchState;
import com.iteration3.utilities.Observer;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

/**
 * Created by Clay on 4/13/2017.
 */
public class MovementPhaseState implements ControlDispatchState, Observer {
    private GameModel model;
    private GameWindow window;
    private ControlDispatch dispatch;
    private HashMap<KeyCode,Action> keyMap;
    private MovementController movementController;
    private CursorController cursorController;
    private TileViewController tileViewController;


    public MovementPhaseState(ControlDispatch dispatch, GameModel model, GameWindow window) {

        this.model = model;
        this.window = window;
        this.dispatch = dispatch;
        keyMap = new HashMap<>();
        movementController = new MovementController(model, window, keyMap);
        movementController.addObserver(this);

        tileViewController = new TileViewController(model, window, keyMap);
        cursorController = new CursorController(model, window, keyMap);
        cursorController.addObserver(tileViewController);

        System.out.println("Move Phase");
        System.out.println("after " + dispatch.getCurrentState());
    }

    @Override
    public void handleInput(KeyEvent event) {
        System.out.println("Movement command");
        if (keyMap.containsKey(event.getCode()))
            keyMap.get(event.getCode()).execute();
    }

    @Override
    public void nextState() {
        dispatch.changeState(new BuildingPhaseState(dispatch, model, window));
        window.swapToBuildingView();
    }

    public void update() {
        nextState();
    }
}
