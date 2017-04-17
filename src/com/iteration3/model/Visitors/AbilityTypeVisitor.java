package com.iteration3.model.Visitors;

import com.iteration3.model.Abilities.BuildAbility.*;
import com.iteration3.model.Abilities.DockAbility.*;
import com.iteration3.model.Abilities.ExchangeAbility.DropResourceAbility;
import com.iteration3.model.Abilities.ExchangeAbility.PickupResourceAbility;
import com.iteration3.model.Abilities.MoveAbility.*;
import com.iteration3.model.Abilities.ProductionAbility.ProduceWoodAbility;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    AbilityTypeVisitor Module: Created by test on 04/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class AbilityTypeVisitor implements iAbilityVisitor{

    @Override
    public String getType(BuildClaypitAbility ability) {
        return GameLibrary.BUILD_CLAYPIT_ABILITY;
    }

    @Override
    public String getType(BuildCoalBurnerAbility ability) {
        return GameLibrary.BUILD_COALBURNER_ABILITY;
    }

    @Override
    public String getType(BuildMineAbility ability) {
        return GameLibrary.BUILD_MINE_ABILITY;
    }

    @Override
    public String getType(BuildMintAbility ability) {
        return GameLibrary.BUILD_MINT_ABILITY;
    }

    @Override
    public String getType(BuildOilRigAbility ability) {
        return GameLibrary.BUILD_OILRIG_ABILITY;
    }

    @Override
    public String getType(BuildPapermillAbility ability) {
        return GameLibrary.BUILD_PAPERMILL_ABILITY;
    }

    @Override
    public String getType(BuildRaftFactoryAbility ability) {
        return GameLibrary.BUILD_RAFTFACTORY_ABILITY;
    }

    @Override
    public String getType(BuildRowboatFactoryAbility ability) {
        return GameLibrary.BUILD_ROWBOAT_ABILITY;
    }

    @Override
    public String getType(BuildSteamerFactoryAbility ability) {
        return GameLibrary.BUILD_STEAMER_ABILITY;
    }

    @Override
    public String getType(BuildStockExchangeAbility ability) {
        return GameLibrary.BUILD_STOCK_ABILITY;
    }

    @Override
    public String getType(BuildStoneFactoryAbility ability) {
        return GameLibrary.BUILD_STONEFACTORY_ABILITY;
    }

    @Override
    public String getType(BuildStoneQuarryAbility ability) {
        return GameLibrary.BUILD_STONEQUARY_ABILITY;
    }

    @Override
    public String getType(BuildTruckFactoryAbility ability) {
        return GameLibrary.BUILD_TRUCK_ABILITY;
    }

    @Override
    public String getType(BuildWagonFactoryAbility ability) {
        return GameLibrary.BUILD_WAGON_ABILITY;
    }

    @Override
    public String getType(BuildWoodcutterAbility ability) {
        return GameLibrary.BUILD_WOODCUTTER_ABILITY;
    }

    @Override
    public String getType(MoveDegree0Ability ability) { return GameLibrary.MOVE_ANGLE0_ABILITY; }

    @Override
    public String getType(MoveDegree30Ability ability) { return GameLibrary.MOVE_ANGLE30_ABILITY; }

    @Override
    public String getType(MoveDegree60Ability ability) {
        return GameLibrary.MOVE_ANGLE60_ABILITY;
    }

    @Override
    public String getType(MoveDegree90Ability ability) {
        return GameLibrary.MOVE_ANGLE90_ABILITY;
    }

    @Override
    public String getType(MoveDegree120Ability ability) {
        return GameLibrary.MOVE_ANGLE120_ABILITY;
    }

    @Override
    public String getType(MoveDegree150Ability ability) {
        return GameLibrary.MOVE_ANGLE150_ABILITY;
    }

    @Override
    public String getType(MoveDegree180Ability ability) {
        return GameLibrary.MOVE_ANGLE180_ABILITY;
    }

    @Override
    public String getType(MoveDegree210Ability ability) {
        return GameLibrary.MOVE_ANGLE210_ABILITY;
    }

    @Override
    public String getType(MoveDegree240Ability ability) {
        return GameLibrary.MOVE_ANGLE240_ABILITY;
    }

    @Override
    public String getType(MoveDegree270Ability ability) {
        return GameLibrary.MOVE_ANGLE270_ABILITY;
    }

    @Override
    public String getType(MoveDegree300Ability ability) {
        return GameLibrary.MOVE_ANGLE300_ABILITY;
    }

    @Override
    public String getType(MoveDegree330Ability ability) {
        return GameLibrary.MOVE_ANGLE330_ABILITY;
    }

    @Override
    public String getType(MoveEdge1Ability ability) {
        return GameLibrary.MOVE_EDGE1_ABILITY;
    }

    @Override
    public String getType(MoveEdge2Ability ability) {
        return GameLibrary.MOVE_EDGE2_ABILITY;
    }

    @Override
    public String getType(MoveEdge3Ability ability) {
        return GameLibrary.MOVE_EDGE3_ABILITY;
    }

    @Override
    public String getType(MoveEdge4Ability ability) {
        return GameLibrary.MOVE_EDGE4_ABILITY;
    }

    @Override
    public String getType(MoveEdge5Ability ability) {
        return GameLibrary.MOVE_EDGE5_ABILITY;
    }

    @Override
    public String getType(MoveEdge6Ability ability) {
        return GameLibrary.MOVE_EDGE6_ABILITY;
    }

    @Override
    public String getType(DockatSea1Ability ability) { return GameLibrary.DOCK_SEA1; }

    @Override
    public String getType(DockatSea2Ability ability) { return GameLibrary.DOCK_SEA2; }

    @Override
    public String getType(DockatSea3Ability ability) { return GameLibrary.DOCK_SEA3; }

    @Override
    public String getType(DockatSea4Ability ability) { return GameLibrary.DOCK_SEA4; }

    @Override
    public String getType(DockatSea5Ability ability) { return GameLibrary.DOCK_SEA5; }

    @Override
    public String getType(DockatSea6Ability ability) { return GameLibrary.DOCK_SEA6; }

    @Override
    public String getType(DockatRiver1Ability ability) { return GameLibrary.DOCK_SEA1; }

    @Override
    public String getType(DockatRiver2Ability ability) { return GameLibrary.DOCK_SEA2; }

    @Override
    public String getType(DockatRiver3Ability ability) { return GameLibrary.DOCK_SEA3; }

    @Override
    public String getType(DockatRiver4Ability ability) { return GameLibrary.DOCK_SEA4; }

    @Override
    public String getType(DockatRiver5Ability ability) { return GameLibrary.DOCK_SEA5; }

    @Override
    public String getType(DockatRiver6Ability ability) { return GameLibrary.DOCK_SEA6; }

    @Override
    public String getType(UndockAbility ability) { return GameLibrary.UNDOCK; }

    @Override
    public String getType(BuildBigMineAbility ability) { return GameLibrary.BUILD_BIGMINE_ABILITY; }

    @Override
    public String getType(BuildIronMineAbility ability) { return GameLibrary.BUILD_IRON_MINE; }

    @Override
    public String getType(BuildGoldMineAbility ability) { return  GameLibrary.BUILD_GOLD_MINE; }

    @Override
    public String getType(BuildWallAbility ability) { return GameLibrary.BUILD_WALL_ABILITY; }

    @Override
    public String getType(BuildRoadAbility ability) { return  GameLibrary.BUILD_ROAD_ABILITY; }

    @Override
    public String getType(DropResourceAbility ability) { return GameLibrary.DROP_RESOURCE; }

    @Override
    public String getType(PickupResourceAbility ability) { return GameLibrary.PICKUP_RESOURCE; }

    @Override
    public String getType(ProduceWoodAbility ability) { return GameLibrary.PRODUCE_WOOD; }
}
