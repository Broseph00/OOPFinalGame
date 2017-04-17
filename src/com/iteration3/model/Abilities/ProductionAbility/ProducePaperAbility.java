package com.iteration3.model.Abilities.ProductionAbility;

import com.iteration3.model.Buildings.Secondary.Papermill;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/17/2017.
 */

/*--------------------------------------------------------------------------------------
|    ProducePaperAbility Module: Created by test on 04/17/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class ProducePaperAbility extends ProductionAbility {

    public ProducePaperAbility(Papermill papermill, Transporter transporter, ExecutionManager executionManager){
        super(papermill, transporter, executionManager, GameLibrary.PRODUCE_PAPER);
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
