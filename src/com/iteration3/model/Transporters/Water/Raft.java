package com.iteration3.model.Transporters.Water;

import com.iteration3.model.Players.Player;
import com.iteration3.utilities.GameLibrary;

public class Raft extends WaterTransporter {


    public Raft(Player player) {
        super(player, 3, 3);
    }

    @Override
    public String getType() {
        return GameLibrary.RAFT;
    }
}
