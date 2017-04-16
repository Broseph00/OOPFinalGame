package com.iteration3.model.Transporters.Water;

import com.iteration3.model.Players.Player;
import com.iteration3.model.Transporters.Transporter;

public class WaterTransporter extends Transporter {
    private boolean docked;
    private int dockedRegion;

    public WaterTransporter(Player player, int maxMove, int cap) {
        super(player, maxMove, cap);
        docked = false;
        //7 means undocked
        dockedRegion=7;
    }

    public boolean isDocked() {
        return docked;
    }

    public void dock(int locator){
        dockedRegion=locator;
        docked=true;
    }

    public void undock(){
        dockedRegion=7;
        docked=false;
    }
}
