package com.iteration3.model.Abilities.ConstructAbility;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/16/2017.
 */

/*--------------------------------------------------------------------------------------
|    ConstructWallAbility Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public abstract class ConstructWallAbility extends Ability {
    private int border;

    public ConstructWallAbility(Transporter transporter, ExecutionManager executionManager, String name, int border){
        super(transporter, name, executionManager);
        this.border = border;
    }
}
