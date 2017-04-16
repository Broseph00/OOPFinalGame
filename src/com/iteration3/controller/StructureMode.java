package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;

import java.util.ArrayList;

/**
 * Created by Clay on 4/16/2017.
 */
public class StructureMode implements CycleMode {

    ArrayList<Action> buildings;
    int index;

    public StructureMode(GameModel model, GameWindow window){
        initActions();
        index = 0;
    }

    //TODO: add all possible building types
    public void initActions(){
        buildings.add(new Action(){
            public void execute() {
                //model.createSawmill();
            }
        });

        buildings.add(new Action(){
            public void execute() {
                //model.createSawmill();
            }
        });

        buildings.add(new Action(){
            public void execute() {
                //model.createSawmill();
            }
        });
    }

    public void next(){
        index++;
        index %= buildings.size();
    }

    public void prev(){
        index--;
        if (index < 0)
            index = buildings.size()-1;
    }

    public void execute(){
        buildings.get(index).execute();
    }
}
