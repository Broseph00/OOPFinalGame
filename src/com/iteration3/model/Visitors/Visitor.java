package com.iteration3.model.Visitors;

import com.iteration3.model.Abilities.*;
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
}
