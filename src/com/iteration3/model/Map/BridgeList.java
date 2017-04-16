package com.iteration3.model.Map;

import java.util.ArrayList;

public class BridgeList {
    private ArrayList<Integer> bridges;

    public BridgeList(){
        bridges = new ArrayList<>();
    }

    public int size(){
        return bridges.size();
    }

    public void add(int edge){
        bridges.add(edge);
    }

    public boolean contains(int edge){
        return bridges.contains(edge);
    }

    public ArrayList<Integer> getBridges() {
        return bridges;
    }
}
