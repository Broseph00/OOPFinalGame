package com.iteration3.model.Map;

// NOT IN DESIGN DOC


import com.iteration3.model.Players.Player;

public class WallWithOwner extends Wall {

    private Player owner;

    public WallWithOwner(Player player, int edge, int strength) {
        this.owner = player;
        this.setEdge(edge);
        this.setStrength(strength);
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
