package com.iteration3.model.Abilities.ExchangeAbility;

import com.iteration3.model.Abilities.Ability;
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
|    DropResourceAbility Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class DropResourceAbility extends Ability {
    private ExchangeManager exchangeManager;
    private Resource resource;

    public DropResourceAbility(Transporter transporter, Resource resource, ExchangeManager exchangeManager, ExecutionManager executionManager){
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
        exchangeManager.dropResource(getTransporter(), resource);
    }

}
