package com.iteration3.controller.PhaseStates;

import com.iteration3.controller.Action;
import com.iteration3.controller.ControlDispatch;
import com.iteration3.utilities.Observer;
import com.iteration3.controller.Controllers.WelcomeViewController;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import com.iteration3.view.MainView;
import com.iteration3.view.WelcomeViewWindow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.HashMap;

/**
     * Created by Clay on 4/13/2017.
     */
    public class WelcomeState implements ControlDispatchState, Observer {
        private GameModel model;
        private GameWindow gameWindow;
        private WelcomeViewWindow welcomeViewWindow;
        private ControlDispatch dispatch;
        private WelcomeViewController welcome;
        private HashMap<KeyCode,Action> keyMap;

        public WelcomeState(ControlDispatch dispatch, GameModel model, GameWindow gameWindow, WelcomeViewWindow welcomeViewWindow){
            this.model = model;
            this.gameWindow = gameWindow;
            this.welcomeViewWindow = welcomeViewWindow;
            this.keyMap = new HashMap<>();
            welcome = new WelcomeViewController(model, gameWindow, welcomeViewWindow, keyMap);
            welcome.addObserver(this);
            this.dispatch = dispatch;
            welcome.addObserver(this);

        }

        //TODO: mixed-instance cohesion here due to mouseclicks only - split hierachy?
        public void handleInput(KeyEvent event){
            if (keyMap.containsKey(event.getCode()))
                keyMap.get(event.getCode()).execute();
        }

        public void nextState(){
            dispatch.changeState(new ProductionPhaseState(dispatch, model, gameWindow));
        }

        public void update() {
            nextState();
        }
    }
