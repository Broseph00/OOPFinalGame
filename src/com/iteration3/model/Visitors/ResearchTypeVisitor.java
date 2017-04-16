package com.iteration3.model.Visitors;

import com.iteration3.model.Players.Research.*;
import com.iteration3.model.Transporters.Land.RoadOnly.Truck;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    ResearchTypeVisitor Module: Created by test on 04/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class ResearchTypeVisitor implements iResearchVisitor {
    @Override
    public String getType(EnlargementResearch research) {
        return GameLibrary.ENLARGEMENT_RESEARCH;
    }

    @Override
    public String getType(NewShaftResearch research) {
        return GameLibrary.SHAFT_RESEARCH;
    }

    @Override
    public String getType(OilResearch research) {
        return GameLibrary.OIL_RESEARCH;
    }

    @Override
    public String getType(RowingResearch research) {
        return GameLibrary.ROWING_RESEARCH;
    }

    @Override
    public String getType(ShipResearch research) {
        return GameLibrary.SHIP_RESEARCH;
    }

    @Override
    public String getType(SpecializationResearch research) {
        return GameLibrary.SPECIALIZATION_RESEARCH;
    }

    @Override
    public String getType(TruckResearch research) {
        return GameLibrary.TRUCK_RESEARCH;
    }

}
