package com.iteration3.model.Abilities.ProductionAbility;

import com.iteration3.model.Buildings.Primary.Woodcutter;
import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/16/2017.
 */

/*--------------------------------------------------------------------------------------
|    ProduceBoardAbility Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class ProduceBoardAbility extends ProductionAbility {

    public ProduceBoardAbility(Transporter transporter, ExecutionManager executionManager){
        super(transporter, executionManager, GameLibrary.PRODUCE_BOARD);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getAbilityType(iAbilityVisitor visitor) {
        return visitor.getType(this);
    }

    public void execute(){
        executionManager.execute(this);
    }
}
