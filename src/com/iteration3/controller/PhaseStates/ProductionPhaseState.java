package com.iteration3.controller.PhaseStates;

import com.iteration3.controller.Action;
import com.iteration3.controller.ControlDispatch;
import com.iteration3.controller.Controllers.CursorController;
import com.iteration3.controller.Controllers.ProductionController;
import com.iteration3.controller.Observer;
import com.iteration3.controller.PhaseStates.ControlDispatchState;
import com.iteration3.controller.PhaseStates.MovementPhaseState;
import com.iteration3.controller.TileViewController;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

public class ProductionPhaseState implements ControlDispatchState, Observer {
    private GameModel model;
    private GameWindow window;
    private ControlDispatch dispatch;
    private ProductionController productionController;
    private CursorController cursorController;
    private TileViewController tileViewController;
    private HashMap<KeyCode,Action> keyMap;

    public ProductionPhaseState(ControlDispatch dispatch, GameModel model, GameWindow window) {
        System.out.println("HI!!!!");
        this.model = model;
        this.window = window;
        this.dispatch = dispatch;
        keyMap = new HashMap<>();
        productionController = new ProductionController(model, window, keyMap);
        productionController.addObserver(this);
        tileViewController = new TileViewController(model, window, keyMap);
//        cursorController = new CursorController(model, window.getMainView(), keyMap);
     //   cursorController.addObserver(tileViewController);
    }

    @Override
    public void handleInput(KeyEvent event) {
        if (keyMap.containsKey(event.getCode()))
            keyMap.get(event.getCode()).execute();
    }

    @Override
    public void nextState() {
        dispatch.changeState(new MovementPhaseState(dispatch, model, window));
    }

    public void update() {
        nextState();
    }
}
