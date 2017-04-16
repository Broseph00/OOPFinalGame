package com.iteration3.controller;

/**
 * Created by Clay on 4/16/2017.
 */
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Clay on 4/16/2017.
 */
public class RoadMode implements DirectionalMode {

    HashMap<KeyCode, Action> keyMap;

    public RoadMode(GameModel model, GameWindow window){
        initKeyMap();
        keyMap = new HashMap<>();
    }

    public void initKeyMap(){
        keyMap.put(KeyCode.NUMPAD8,new Action(){
            public void execute() {
                //model.makeRoad(1);
            }
        });

        keyMap.put(KeyCode.NUMPAD9,new Action(){
            public void execute() {
                //model.makeRoad(2);
            }
        });

        keyMap.put(KeyCode.NUMPAD3,new Action(){
            public void execute() {
                //model.makeRoad(3);
            }
        });

        keyMap.put(KeyCode.NUMPAD2,new Action(){
            public void execute() {
                //model.makeRoad(4);
            }
        });

        keyMap.put(KeyCode.NUMPAD1,new Action(){
            public void execute() {
                //model.makeRoad(5);
            }
        });

        keyMap.put(KeyCode.NUMPAD7,new Action(){
            public void execute() {
                //model.makeRoad(6);
            }
        });
    }

    public void execute(KeyCode code){
        keyMap.get(code).execute();
    }
}