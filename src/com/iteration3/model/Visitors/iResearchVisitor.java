package com.iteration3.model.Visitors;

import com.iteration3.model.Players.Research.*;

/**
 * Created by test on 04/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    iResearchVisitor Module: Created by test on 04/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public interface iResearchVisitor {
    String getType(EnlargementResearch research);
    String getType(NewShaftResearch research);
    String getType(OilResearch research);
    String getType(RowingResearch research);
    String getType(ShipResearch research);
    String getType(SpecializationResearch research);
    String getType(TruckResearch research);
}
