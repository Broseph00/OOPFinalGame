package com.iteration3.model.Map;

import java.util.ArrayList;

public class RoadList {
    ArrayList<Location> roads;

    public RoadList(){
        roads = new ArrayList<>();
    }

    public boolean contains(Location location){
        return roads.contains(location);
    }

    public void add(Location location){
        roads.add(location);
    }
}
