package com.iteration3.model.Visitors;

import com.iteration3.model.Abilities.BuildAbility.*;
import com.iteration3.model.Abilities.ConstructAbility.*;
import com.iteration3.model.Abilities.DockAbility.*;
import com.iteration3.model.Abilities.ExchangeAbility.DropResourceAbility;
import com.iteration3.model.Abilities.ExchangeAbility.PickupResourceAbility;
import com.iteration3.model.Abilities.MoveAbility.*;
import com.iteration3.model.Abilities.ProductionAbility.*;
import com.iteration3.model.Players.Research.*;
import com.iteration3.model.Tiles.*;

public interface Visitor {
    public void visit(WoodTerrain terrain);
    public void visit(MountainTerrain terrain);
    public void visit(DesertTerrain terrain);
    public void visit(PastureTerrain terrain);
    public void visit(RockTerrain terrain);
    public void visit(SeaTerrain terrain);

    public void visit(EnlargementResearch research);
    public void visit(NewShaftResearch research);
    public void visit(OilResearch research);
    public void visit(RowingResearch research);
    public void visit(ShipResearch research);
    public void visit(SpecializationResearch research);
    public void visit(TruckResearch research);

    public void visit(BuildClaypitAbility ability);
    public void visit(BuildCoalBurnerAbility ability);
    public void visit(BuildMineAbility ability);
    public void visit(BuildMintAbility ability);
    public void visit(BuildOilRigAbility ability);
    public void visit(BuildPapermillAbility ability);
    public void visit(BuildRaftFactoryAbility ability);
    public void visit(BuildRowboatFactoryAbility ability);
    public void visit(BuildSteamerFactoryAbility ability);
    public void visit(BuildStockExchangeAbility ability);
    public void visit(BuildStoneFactoryAbility ability);
    public void visit(BuildStoneQuarryAbility ability);
    public void visit(BuildTruckFactoryAbility ability);
    public void visit(BuildWagonFactoryAbility ability);
    public void visit(BuildWoodcutterAbility ability);
    public void visit(BuildIronMineAbility ability);
    public void visit(BuildGoldMineAbility ability);
    public void visit(BuildBigMineAbility ability);
    public void visit(ConstructWall1Ability ability);
    public void visit(ConstructWall2Ability ability);
    public void visit(ConstructWall3Ability ability);
    public void visit(ConstructWall4Ability ability);
    public void visit(ConstructWall5Ability ability);
    public void visit(ConstructWall6Ability ability);
    public void visit(ConstructRoad1Ability ability);
    public void visit(ConstructRoad2Ability ability);
    public void visit(ConstructRoad3Ability ability);
    public void visit(ConstructRoad4Ability ability);
    public void visit(ConstructRoad5Ability ability);
    public void visit(ConstructRoad6Ability ability);
    public void visit(ConstructBridge1Ability ability);
    public void visit(ConstructBridge2Ability ability);
    public void visit(ConstructBridge3Ability ability);
    public void visit(ConstructBridge4Ability ability);
    public void visit(ConstructBridge5Ability ability);
    public void visit(ConstructBridge6Ability ability);

    public void visit(MoveDegree0Ability ability);
    public void visit(MoveDegree30Ability ability);
    public void visit(MoveDegree60Ability ability);
    public void visit(MoveDegree90Ability ability);
    public void visit(MoveDegree120Ability ability);
    public void visit(MoveDegree150Ability ability);
    public void visit(MoveDegree180Ability ability);
    public void visit(MoveDegree210Ability ability);
    public void visit(MoveDegree240Ability ability);
    public void visit(MoveDegree270Ability ability);
    public void visit(MoveDegree300Ability ability);
    public void visit(MoveDegree330Ability ability);
    public void visit(MoveEdge1Ability ability);
    public void visit(MoveEdge2Ability ability);
    public void visit(MoveEdge3Ability ability);
    public void visit(MoveEdge4Ability ability);
    public void visit(MoveEdge5Ability ability);
    public void visit(MoveEdge6Ability ability);

    public void visit(DockatSea1Ability ability);
    public void visit(DockatSea2Ability ability);
    public void visit(DockatSea3Ability ability);
    public void visit(DockatSea4Ability ability);
    public void visit(DockatSea5Ability ability);
    public void visit(DockatSea6Ability ability);
    public void visit(UndockAbility ability);
    public void visit(DockatRiver1Ability ability);
    public void visit(DockatRiver2Ability ability);
    public void visit(DockatRiver3Ability ability);
    public void visit(DockatRiver4Ability ability);
    public void visit(DockatRiver5Ability ability);
    public void visit(DockatRiver6Ability ability);

    public void visit(DropResourceAbility ability);
    public void visit(PickupResourceAbility ability);

    public void visit(ProduceBoardAbility ability);
    public void visit(ProduceFuelAbility ability);
    public void visit(ProducePaperAbility ability);
    public void visit(ProduceBrickAbility ability);
    public void visit(ProduceCoinAbility ability);
    public void visit(ProduceStockAbility ability);
    public void visit(ProduceWagonAbility ability);
    public void visit(ProduceTruckAbility ability);
    public void visit(ProduceRaftAbility ability);
    public void visit(ProduceRowboatAbility ability);
    public void visit(ProduceSteamerAbility ability);

}
