package com.iteration3.model.Abilities.DockAbility;

import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/16/2017.
 */

/*--------------------------------------------------------------------------------------
|    DockatRiver4Ability Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class DockatRiver4Ability extends DockatRiverAbility {

    public DockatRiver4Ability(Transporter transporter, ExecutionManager executionManager){
        super(transporter, executionManager, GameLibrary.DOCK_RIVER4, 4);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getAbilityType(iAbilityVisitor visitor) {
        return visitor.getType(this);
    }

}
