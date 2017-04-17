package com.iteration3.model.Abilities.DockAbility;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.Managers.ExecutionManager;
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

    public DockatSeaAbility(Transporter transporter, int border, String name, ExecutionManager executionManager){
        super(transporter, name, executionManager);
        this.border = border;
    }

    public int getBorder(){return border;}
}
