package com.iteration3.model.Abilities;

import com.iteration3.model.Managers.ExchangeManager;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/16/2017.
 */

/*--------------------------------------------------------------------------------------
|    PickupResourceAbility Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class PickupResourceAbility extends Ability {
    private ExchangeManager exchangeManager;
    private Resource resource;

    public PickupResourceAbility(Transporter transporter,Resource resource, ExecutionManager executionManager, ExchangeManager exchangeManager){
        super(transporter, GameLibrary.DROP_RESOURCE, executionManager);
        this.exchangeManager = exchangeManager;
        this.resource = resource;
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
        exchangeManager.pickUpResource(getTransporter(), resource);
    }

}
