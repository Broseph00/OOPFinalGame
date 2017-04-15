package com.iteration3.model.Transporters.Land;

import com.iteration3.model.Livestock;
import com.iteration3.model.Players.Player;

public class Donkey extends LandTransporter implements Livestock {


    public Donkey(Player player) {
        // TODO: max move 1 if on road
        super(player, 2, 2);
    }
}
