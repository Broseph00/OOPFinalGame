package com.iteration3.model.Managers;

import static com.iteration3.utilities.GameLibrary.*;
import com.iteration3.model.Abilities.*;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Players.Research.Research;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

import javax.xml.crypto.dsig.TransformService;
import java.util.ArrayList;
import java.util.List;

public class AbilityManager {
    Map map;
    MovementManager movementManager;
    ResearchManager researchManager;

    public AbilityManager(Map map, MovementManager movementManager, ResearchManager researchManager){
        this.map = map;
        this.movementManager = movementManager;
        this.researchManager = researchManager;
    }

    public void updateRoadTransporters(ArrayList<OnRoadLandTransporter> roadLandTransporters){
        for(OnRoadLandTransporter transporter : roadLandTransporters){
            giveAbilities(transporter);
        }
    }

    public void updateLandTransporters(ArrayList<LandTransporter> landTransporters){
        //System.out.println("Step 3");
        for(LandTransporter transporter : landTransporters){
            giveAbilities(transporter);
        }
    }

    public void updateWaterTransporters(ArrayList<WaterTransporter> waterTransporters){
        for(WaterTransporter transporter  : waterTransporters){
            giveAbilities(transporter);
        }
    }

    public void giveAbilities(WaterTransporter transporter){
        transporter.clearAbilityList();
        ArrayList<Ability> abilityList = populateList(transporter);
        transporter.setAbilityList(abilityList);
    }

    public void giveAbilities(LandTransporter transporter){
        //System.out.println("Step 4");
        transporter.clearAbilityList();
        ArrayList<Ability> abilityList = populateList(transporter);
        transporter.setAbilityList(abilityList);
    }

    public void giveAbilities(OnRoadLandTransporter transporter){
        transporter.clearAbilityList();
        ArrayList<Ability> abilityList = populateList(transporter);
        transporter.setAbilityList(abilityList);
    }

    public ArrayList<Ability> populateList(WaterTransporter transporter) {
        ArrayList<Ability> abilitiesList = new ArrayList<>();
        addConstructionAbilities(transporter, abilitiesList);
        addMoveAbilities(transporter, abilitiesList);
        addDockAbilities(transporter, abilitiesList);
        return abilitiesList;
    }

    public ArrayList<Ability> populateList(LandTransporter transporter) {
        //System.out.println("Step 5");
        ArrayList<Ability> abilitiesList = new ArrayList<>();
        addConstructionAbilities(transporter, abilitiesList);
        addMoveAbilities(transporter, abilitiesList);
        return abilitiesList;
    }

    public ArrayList<Ability> populateList(OnRoadLandTransporter transporter) {
        ArrayList<Ability> abilitiesList = new ArrayList<>();
        addConstructionAbilities(transporter, abilitiesList);
        addMoveAbilities(transporter, abilitiesList);
        return abilitiesList;
    }

    public void addConstructionAbilities(Transporter transporter, ArrayList<Ability> abilitiesList){
        //construction abilities
        if (verifyClayPitAbility(transporter)) { abilitiesList.add(new BuildClaypitAbility(transporter)); }
        if (verifyCoalBurnerAbility(transporter)) { abilitiesList.add(new BuildCoalBurnerAbility(transporter)); }
        if (verifyMineAbility(transporter)) { abilitiesList.add(new BuildMineAbility(transporter)); }
        if (verifyMintAbility(transporter)) { abilitiesList.add(new BuildMintAbility(transporter)); }
        if (verifyOilRigAbility(transporter)) { abilitiesList.add(new BuildOilRigAbility(transporter)); }
        if (verifyPaperMillAbility(transporter)) { abilitiesList.add(new BuildPapermillAbility(transporter)); }
        if (verifyRaftFactoryAbility(transporter)) { abilitiesList.add(new BuildRaftFactoryAbility(transporter)); }
        if (verifyRowboatFactoryAbility(transporter)) { abilitiesList.add(new BuildRowboatFactoryAbility(transporter)); }
        if (verifySteamerFactoryAbility(transporter)) { abilitiesList.add(new BuildSteamerFactoryAbility(transporter)); }
        if (verifyStockExchangeAbility(transporter)) { abilitiesList.add(new BuildStockExchangeAbility(transporter)); }
        if (verifyStoneFactoryAbility(transporter)) { abilitiesList.add(new BuildStoneFactoryAbility(transporter)); }
        if (verifyStoneQuarryAbility(transporter)) { abilitiesList.add(new BuildStoneQuarryAbility(transporter)); }
        if (verifyTruckFactoryAbility(transporter)) { abilitiesList.add(new BuildTruckFactoryAbility(transporter)); }
        if (verifyWagonFactoryAbility(transporter)) { abilitiesList.add(new BuildWagonFactoryAbility(transporter)); }
        if (verifyWoodcutterAbility(transporter)) { abilitiesList.add(new BuildWoodcutterAbility(transporter)); }
    }

    public void addMoveAbilities(WaterTransporter transporter, ArrayList<Ability> abilitiesList) {
        //abilities to move
        MoveAbility moveAbility = new MoveEdge1Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge2Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge3Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge4Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge5Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge6Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
    }

    public void addDockAbilities(WaterTransporter transporter, ArrayList<Ability> abilitiesList){
        //abilities to dock
        UndockAbility undockAbility = new UndockAbility(transporter);
        addUndockAbility(undockAbility, transporter, abilitiesList);

        DockatRiverAbility dockAbility = new DockatRiverAbility(transporter);
        addRiverDockAbility(dockAbility, transporter, abilitiesList);

        DockatSeaAbility dockatSeaAbility = new DockatSea1Ability(transporter);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea2Ability(transporter);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea3Ability(transporter);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea4Ability(transporter);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea5Ability(transporter);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea6Ability(transporter);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
    }

    public void addMoveAbilities(LandTransporter transporter, ArrayList<Ability> abilitiesList){

        //abilities to move
        MoveAbility moveAbility = new MoveDegree0Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree30Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree60Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree90Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree120Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree150Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree180Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree210Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree240Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree270Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree300Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree330Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
    }

    public void addMoveAbilities(OnRoadLandTransporter transporter, ArrayList<Ability> abilitiesList){

        //abilities to move
        MoveAbility moveAbility = new MoveDegree0Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree30Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree60Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree90Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree120Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree150Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree180Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree210Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree240Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree270Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree300Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree330Ability(transporter);
        addMoveAbility(moveAbility, transporter, abilitiesList);
    }

    private void addRiverDockAbility(DockatRiverAbility dockAbility, WaterTransporter transporter, ArrayList<Ability> abilitiesList){
        if(verifyRiverDockAbility(dockAbility, transporter)){abilitiesList.add(dockAbility);}
    }

    private void addSeaDockAbility(DockatSeaAbility dockAbility, WaterTransporter transporter, ArrayList<Ability> abilitiesList){
        if(verifySeaDockAbility(dockAbility, transporter)){abilitiesList.add(dockAbility);}
    }

    private void addUndockAbility(UndockAbility undockAbility, WaterTransporter transporter, ArrayList<Ability> abilitiesList){
        if(verifyUndockAbility(undockAbility, transporter)){abilitiesList.add(undockAbility);}
    }

    private void addMoveAbility(MoveAbility moveAbility, WaterTransporter transporter, ArrayList<Ability> abilitiesList){
        if(verifyWaterMoveAbility(moveAbility, transporter)) { abilitiesList.add(moveAbility); }
    }

    private void addMoveAbility(MoveAbility moveAbility, LandTransporter transporter, ArrayList<Ability> abilitiesList){
        if(verifyLandMoveAbility(moveAbility, transporter)) { abilitiesList.add(moveAbility); }
    }

    private void addMoveAbility(MoveAbility moveAbility, OnRoadLandTransporter transporter, ArrayList<Ability> abilitiesList){
        if(verifyRoadMoveAbility(moveAbility, transporter)) { abilitiesList.add(moveAbility); }
    }

    private boolean verifyClayPitAbility(Transporter transporter) {
       return (movementManager.validateResources(transporter, CLAYPIT_BOARD, CLAYPIT_STONE) && movementManager.validateShore(transporter));
    }

    private boolean verifyCoalBurnerAbility(Transporter transporter) {
       return movementManager.validateResources(transporter, COALBURNER_BOARD, COALBURNER_STONE);
    }

    private boolean verifyMineAbility(Transporter transporter) {
        return ( movementManager.validateResources(transporter, MINE_BOARD, MINE_STONE) && movementManager.validateTerrain(transporter, MOUNTAINS));
    }

    private boolean verifyMintAbility(Transporter transporter) {
        return movementManager.validateResources(transporter, MINT_BOARD, MINT_STONE);
    }

    private boolean verifyOilRigAbility(Transporter transporter) {
        return (researchManager.isFinishedOilResearch() && movementManager.validateResources(transporter, OILRIG_BOARD, OILRIG_STONE) && movementManager.validateTerrain(transporter, SEA));
    }

    private boolean verifyPaperMillAbility(Transporter transporter) {
        return (movementManager.validateResources(transporter, PAPERMILL_BOARD, PAPERMILL_STONE));
    }

    private boolean verifyRaftFactoryAbility(Transporter transporter){
        return (movementManager.validateResources(transporter, RAFTFACTORY_BOARD, RAFTFACTORY_STONE) && movementManager.validateShore(transporter));
    }

    private boolean verifyRowboatFactoryAbility(Transporter transporter){
        return (movementManager.validateShore(transporter) && researchManager.isFinishedRowingResearch() && movementManager.validateResources(transporter, ROWBOATFACTORY_BOARD, ROWBOATFACTORY_STONE));
    }

    private boolean verifySteamerFactoryAbility(Transporter transporter){
        return (movementManager.validateShore(transporter) && researchManager.isFinishedShipResearch() && movementManager.validateResources(transporter, STEAMER_BOARD, STEAMER_STONE));
    }

    private boolean verifyStockExchangeAbility(Transporter transporter){
        return (movementManager.validateResources(transporter, STOCK_BOARD, STOCK_STONE));
    }

    private  boolean verifyStoneFactoryAbility(Transporter transporter){
        return (movementManager.validateResources(transporter, STONEFACTORY_BOARD, STONEFACTORY_STONE));
    }

    private boolean verifyStoneQuarryAbility(Transporter transporter){
        return (movementManager.validateResources(transporter, QUARRY_BOARD, QUARRY_STONE) && movementManager.validateTerrain(transporter, ROCK));
    }

    private boolean verifyTruckFactoryAbility(Transporter transporter){
        return (movementManager.validateResources(transporter, TRUCKFACTORY_BOARD, TRUCKFACTORY_STONE) && researchManager.isFinishedTruckResearch());
    }

    private boolean verifyWagonFactoryAbility(Transporter transporter){
        return (movementManager.validateResources(transporter, WAGONFACTORY_BOARD, WAGONFACTORY_STONE));
    }

    private boolean verifyWoodcutterAbility(Transporter transporter){
        return (movementManager.validateResources(transporter, WOODCUTTER_BOARD, WOODCUTTER_STONE) && movementManager.validateTerrain(transporter, WOODS));
    }

    private boolean verifyWaterMoveAbility(MoveAbility moveAbility, WaterTransporter transporter){
        return movementManager.validateWaterMoveAbility(moveAbility, transporter);
    }

    private boolean verifyLandMoveAbility(MoveAbility moveAbility, LandTransporter transporter){
        return movementManager.validateLandMoveAbility(moveAbility, transporter);
    }

    private boolean verifyRoadMoveAbility(MoveAbility moveAbility, OnRoadLandTransporter transporter){
        return movementManager.validateRoadMoveAbility(moveAbility, transporter);
    }

    private boolean verifyRiverDockAbility(DockatRiverAbility dockatRiverAbility, WaterTransporter transporter){
        return movementManager.validateRiverDockAbility(dockatRiverAbility, transporter);
    }

    private boolean verifySeaDockAbility(DockatSeaAbility dockatSeaAbility, WaterTransporter transporter){
        return movementManager.validateSeaDockAbility(dockatSeaAbility, transporter);
    }

    private boolean verifyUndockAbility(UndockAbility undockAbility, WaterTransporter transporter){
        return movementManager.validateUndockAbility(undockAbility, transporter);
    }

    /*public String getAbilityName(Ability ability){
        return null;
    }*/

}
