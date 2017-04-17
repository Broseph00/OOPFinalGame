package com.iteration3.model.Abilities.ProductionAbility;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;

/**
 * Created by test on 04/16/2017.
 */

/*--------------------------------------------------------------------------------------
|    ProductionAbility Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public abstract class ProductionAbility extends Ability{

    public ProductionAbility(Transporter transporter, ExecutionManager executionManager, String name){
        super(transporter, name, executionManager);
    }

}
