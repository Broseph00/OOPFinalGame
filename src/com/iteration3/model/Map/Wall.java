package com.iteration3.model.Map;

import com.iteration3.model.Players.Player;

public abstract class Wall {

    private int edge;
    private int strength;
    private String wallColor;

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

    public abstract boolean oppositeOwner(Player player);

    public String getWallColor() {
        return wallColor;
    };
    public void setWallColor(String wallColor) {
        this.wallColor = wallColor;
    }

}


