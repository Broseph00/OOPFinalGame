package com.iteration3.model.Map;

import java.util.ArrayList;

public class Region {
    private ArrayList<ArrayList<Integer>> regions;
    public Region(){
        regions = new ArrayList<>();
        ArrayList<Integer> init = new ArrayList<>();
        init.add(1);
        init.add(2);
        init.add(3);
        init.add(4);
        init.add(5);
        init.add(6);
        regions.add(init);
    }

    public void addRiver(River river){
        
    }

    public void addBridge(Integer edge){

    }
}
