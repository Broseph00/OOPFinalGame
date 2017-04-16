package com.iteration3.model.Abilities;

import com.iteration3.model.Transporters.Transporter;

/**
 * Created by test on 04/16/2017.
 */

/*--------------------------------------------------------------------------------------
|    DockAbility Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public abstract class DockatSeaAbility extends Ability {
    private int border;

    public DockatSeaAbility(Transporter transporter, int border, String name){
        super(transporter, name);
        this.border = border;
    }

    public int getBorder(){return border;}
}
