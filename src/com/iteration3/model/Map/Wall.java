package com.iteration3.model.Map;

import com.iteration3.model.Players.Player;

public abstract class Wall {

    private int edge;
    private int strength;

    public int getEdge() {
        return edge;
    }

    public int getStrength() {
        return strength;
    }

    public void setEdge(int edge) {
        this.edge = edge;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}


