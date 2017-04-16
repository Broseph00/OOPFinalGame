package com.iteration3.model.Transporters.Land;

import com.iteration3.model.Players.Player;
import com.iteration3.model.Transporters.Transporter;

public abstract class LandTransporter extends Transporter {
    public LandTransporter(Player player, int maxMove, int cap) {
        super(player, maxMove, cap);
    }

    public boolean isDocked(){
        return false;
    }
}
