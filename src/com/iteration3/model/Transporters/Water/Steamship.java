package com.iteration3.model.Transporters.Water;

import com.iteration3.model.Players.Player;
import com.iteration3.utilities.GameLibrary;

public class Steamship extends WaterTransporter {

    public Steamship(Player player){
        super(player, 4, 5);
    }

    @Override
    public String getType() {
        return GameLibrary.STEAMSHIP;
    }
}
