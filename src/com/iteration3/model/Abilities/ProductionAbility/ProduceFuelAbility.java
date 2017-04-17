package com.iteration3.model.Abilities.ProductionAbility;

import com.iteration3.model.Buildings.Secondary.CoalBurner;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/16/2017.
 */

/*--------------------------------------------------------------------------------------
|    ProduceFuelAbility Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class ProduceFuelAbility extends ProductionAbility {

    public ProduceFuelAbility(Transporter transporter, ExecutionManager executionManager){
        super(transporter, executionManager, GameLibrary.PRODUCE_FUEL);
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
