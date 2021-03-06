package com.iteration3.model.Visitors;

import com.iteration3.model.Abilities.BuildAbility.*;
import com.iteration3.model.Abilities.ConstructAbility.*;
import com.iteration3.model.Abilities.DockAbility.*;
import com.iteration3.model.Abilities.ExchangeAbility.DropResourceAbility;
import com.iteration3.model.Abilities.ExchangeAbility.PickupResourceAbility;
import com.iteration3.model.Abilities.MoveAbility.*;
import com.iteration3.model.Abilities.ProductionAbility.*;

/**
 * Created by test on 04/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    iAbilityVisitor Module: Created by test on 04/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public interface iAbilityVisitor {
    String getType(BuildClaypitAbility ability);
    String getType(BuildCoalBurnerAbility ability);
    String getType(BuildMineAbility ability);
    String getType(BuildMintAbility ability);
    String getType(BuildOilRigAbility ability);
    String getType(BuildPapermillAbility ability);
    String getType(BuildRaftFactoryAbility ability);
    String getType(BuildRowboatFactoryAbility ability);
    String getType(BuildSteamerFactoryAbility ability);
    String getType(BuildStockExchangeAbility ability);
    String getType(BuildStoneFactoryAbility ability);
    String getType(BuildStoneQuarryAbility ability);
    String getType(BuildTruckFactoryAbility ability);
    String getType(BuildWagonFactoryAbility ability);
    String getType(BuildWoodcutterAbility ability);
    String getType(BuildIronMineAbility ability);
    String getType(BuildBigMineAbility ability);
    String getType(BuildGoldMineAbility ability);
    String getType(ConstructWall1Ability ability);
    String getType(ConstructWall2Ability ability);
    String getType(ConstructWall3Ability ability);
    String getType(ConstructWall4Ability ability);
    String getType(ConstructWall5Ability ability);
    String getType(ConstructWall6Ability ability);
    String getType(ConstructRoad1Ability ability);
    String getType(ConstructRoad2Ability ability);
    String getType(ConstructRoad3Ability ability);
    String getType(ConstructRoad4Ability ability);
    String getType(ConstructRoad5Ability ability);
    String getType(ConstructRoad6Ability ability);
    String getType(ConstructBridge1Ability ability);
    String getType(ConstructBridge2Ability ability);
    String getType(ConstructBridge3Ability ability);
    String getType(ConstructBridge4Ability ability);
    String getType(ConstructBridge5Ability ability);
    String getType(ConstructBridge6Ability ability);

    String getType(MoveDegree0Ability ability);
    String getType(MoveDegree30Ability ability);
    String getType(MoveDegree60Ability ability);
    String getType(MoveDegree90Ability ability);
    String getType(MoveDegree120Ability ability);
    String getType(MoveDegree150Ability ability);
    String getType(MoveDegree180Ability ability);
    String getType(MoveDegree210Ability ability);
    String getType(MoveDegree240Ability ability);
    String getType(MoveDegree270Ability ability);
    String getType(MoveDegree300Ability ability);
    String getType(MoveDegree330Ability ability);
    String getType(MoveEdge1Ability ability);
    String getType(MoveEdge2Ability ability);
    String getType(MoveEdge3Ability ability);
    String getType(MoveEdge4Ability ability);
    String getType(MoveEdge5Ability ability);
    String getType(MoveEdge6Ability ability);

    String getType(DockatSea1Ability ability);
    String getType(DockatSea2Ability ability);
    String getType(DockatSea3Ability ability);
    String getType(DockatSea4Ability ability);
    String getType(DockatSea5Ability ability);
    String getType(DockatSea6Ability ability);
    String getType(DockatRiver1Ability ability);
    String getType(DockatRiver2Ability ability);
    String getType(DockatRiver3Ability ability);
    String getType(DockatRiver4Ability ability);
    String getType(DockatRiver5Ability ability);
    String getType(DockatRiver6Ability ability);
    String getType(UndockAbility ability);

    String getType(DropResourceAbility ability);
    String getType(PickupResourceAbility ability);

    String getType(ProduceBoardAbility ability);
    String getType(ProduceFuelAbility ability);
    String getType(ProducePaperAbility ability);
    String getType(ProduceBrickAbility ability);
    String getType(ProduceCoinAbility ability);
    String getType(ProduceStockAbility ability);
    String getType(ProduceWagonAbility ability);
    String getType(ProduceRaftAbility ability);
    String getType(ProduceRowboatAbility ability);
    String getType(ProduceSteamerAbility ability);
    String getType(ProduceTruckAbility ability);
}
