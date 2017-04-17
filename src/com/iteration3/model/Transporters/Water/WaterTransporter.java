package com.iteration3.model.Transporters.Water;

import com.iteration3.model.Players.Player;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.utilities.GameLibrary;

public class WaterTransporter extends Transporter {
    private boolean docked;

    public WaterTransporter(Player player, int maxMove, int cap) {
        super(player, maxMove, cap);
        docked = false;
    }

    public boolean isDocked() {
        return docked;
    }

    @Override
    public String getType() {
        return GameLibrary.WATERTRANSPORTER;
    }

    public void dock(){
        docked=true;
    }

    public void undock(){
        docked=false;
    }
}
