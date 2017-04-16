package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Clay on 4/16/2017.
 */
public class WallMode implements DirectionalMode {

    HashMap<KeyCode, Action> keyMap;

    public WallMode(GameModel model, GameWindow window){
        initKeyMap();
        keyMap = new HashMap<>();
    }

    public void initKeyMap(){
        keyMap.put(KeyCode.NUMPAD8,new Action(){
            public void execute() {
                //model.makeWallWithOwner(Player, 1, str);
            }
        });

        keyMap.put(KeyCode.NUMPAD9,new Action(){
            public void execute() {
                //model.makeWallWithOwner(Player, 2, str);
            }
        });

        keyMap.put(KeyCode.NUMPAD3,new Action(){
            public void execute() {
                //model.makeWallWithOwner(Player, 3, str);
            }
        });

        keyMap.put(KeyCode.NUMPAD2,new Action(){
            public void execute() {
                //model.makeWallWithOwner(Player, 4, str);
            }
        });

        keyMap.put(KeyCode.NUMPAD1,new Action(){
            public void execute() {
                //model.makeWallWithOwner(Player, 5, str);
            }
        });

        keyMap.put(KeyCode.NUMPAD7,new Action(){
            public void execute() {
                //model.makeWallWithOwner(Player, 6, str);
            }
        });
    }

    public void execute(KeyCode code){
        keyMap.get(code).execute();
    }
}
