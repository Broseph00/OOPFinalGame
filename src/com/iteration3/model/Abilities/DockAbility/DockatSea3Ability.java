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
|    DockatSea3 Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class DockatSea3Ability extends DockatSeaAbility {

    public DockatSea3Ability(Transporter transporter, ExecutionManager executionManager){
        super(transporter, 3, GameLibrary.DOCK_SEA3, executionManager);
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
