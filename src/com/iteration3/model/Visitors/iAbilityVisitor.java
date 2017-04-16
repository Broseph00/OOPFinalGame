package com.iteration3.model.Visitors;

import com.iteration3.model.Abilities.*;

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
}