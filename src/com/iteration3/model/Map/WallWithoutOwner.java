package com.iteration3.model.Map;

// NOT IN DESIGN DOC


import com.iteration3.model.Players.Player;

public class WallWithoutOwner extends Wall {

    public WallWithoutOwner(int edge, int strength) {
        this.setEdge(edge);
        this.setStrength(strength);
    }

}
