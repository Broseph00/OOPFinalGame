package com.iteration3.model.Abilities;

import com.iteration3.model.Transporters.Transporter;

/**
 * Created by test on 04/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    MoveAbility Module: Created by test on 04/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public abstract class MoveAbility extends Ability {
    private int region;
    private int border;

    public MoveAbility(Transporter transporter, int region, int border, String name){
        super(transporter, name);
        this.region = region;
        this.border = border;
    }

    public int getRegion(){ return region; }

    public int getBorder(){ return border; }
}
