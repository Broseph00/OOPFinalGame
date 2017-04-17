package com.iteration3.model.Abilities.ProductionAbility;

import com.iteration3.model.Buildings.Secondary.StockExchange;
import com.iteration3.model.Managers.ExchangeManager;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/17/2017.
 */

/*--------------------------------------------------------------------------------------
|    ProduceStockAbility Module: Created by test on 04/17/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class ProduceStockAbility extends ProductionAbility {

    public ProduceStockAbility(Transporter transporter, ExecutionManager executionManager){
        super(transporter, executionManager, GameLibrary.PRODUCE_STOCK);
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
