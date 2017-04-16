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
    ValidationManager validationManager;
    ExecutionManager executionManager;
    ResearchManager researchManager;

    public AbilityManager(Map map, ValidationManager validationManager, ResearchManager researchManager, ExecutionManager executionManager){
        this.map = map;
        this.validationManager = validationManager;
        this.executionManager = executionManager;
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
        if (verifyClayPitAbility(transporter)) { abilitiesList.add(new BuildClaypitAbility(transporter, executionManager)); }
        if (verifyCoalBurnerAbility(transporter)) { abilitiesList.add(new BuildCoalBurnerAbility(transporter, executionManager)); }
        if (verifyMineAbility(transporter)) { abilitiesList.add(new BuildMineAbility(transporter, executionManager)); }
        if (verifyMintAbility(transporter)) { abilitiesList.add(new BuildMintAbility(transporter, executionManager)); }
        if (verifyOilRigAbility(transporter)) { abilitiesList.add(new BuildOilRigAbility(transporter, executionManager)); }
        if (verifyPaperMillAbility(transporter)) { abilitiesList.add(new BuildPapermillAbility(transporter, executionManager)); }
        if (verifyRaftFactoryAbility(transporter)) { abilitiesList.add(new BuildRaftFactoryAbility(transporter, executionManager)); }
        if (verifyRowboatFactoryAbility(transporter)) { abilitiesList.add(new BuildRowboatFactoryAbility(transporter, executionManager)); }
        if (verifySteamerFactoryAbility(transporter)) { abilitiesList.add(new BuildSteamerFactoryAbility(transporter, executionManager)); }
        if (verifyStockExchangeAbility(transporter)) { abilitiesList.add(new BuildStockExchangeAbility(transporter, executionManager)); }
        if (verifyStoneFactoryAbility(transporter)) { abilitiesList.add(new BuildStoneFactoryAbility(transporter, executionManager)); }
        if (verifyStoneQuarryAbility(transporter)) { abilitiesList.add(new BuildStoneQuarryAbility(transporter, executionManager)); }
        if (verifyTruckFactoryAbility(transporter)) { abilitiesList.add(new BuildTruckFactoryAbility(transporter, executionManager)); }
        if (verifyWagonFactoryAbility(transporter)) { abilitiesList.add(new BuildWagonFactoryAbility(transporter, executionManager)); }
        if (verifyWoodcutterAbility(transporter)) { abilitiesList.add(new BuildWoodcutterAbility(transporter, executionManager)); }
    }

    public void addMoveAbilities(WaterTransporter transporter, ArrayList<Ability> abilitiesList) {
        //abilities to move
        MoveAbility moveAbility = new MoveEdge1Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge2Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge3Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge4Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge5Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveEdge6Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
    }

    public void addDockAbilities(WaterTransporter transporter, ArrayList<Ability> abilitiesList){
        //abilities to dock
        UndockAbility undockAbility = new UndockAbility(transporter, executionManager);
        addUndockAbility(undockAbility, transporter, abilitiesList);

        DockatRiverAbility dockAbility = new DockatRiver1Ability(transporter, executionManager);
        addRiverDockAbility(dockAbility, transporter, abilitiesList);

        DockatSeaAbility dockatSeaAbility = new DockatSea1Ability(transporter, executionManager);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea2Ability(transporter, executionManager);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea3Ability(transporter, executionManager);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea4Ability(transporter, executionManager);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea5Ability(transporter, executionManager);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
        dockatSeaAbility = new DockatSea6Ability(transporter, executionManager);
        addSeaDockAbility(dockatSeaAbility, transporter, abilitiesList);
    }

    public void addMoveAbilities(LandTransporter transporter, ArrayList<Ability> abilitiesList){

        //abilities to move
        MoveAbility moveAbility = new MoveDegree0Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree30Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree60Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree90Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree120Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree150Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree180Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree210Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree240Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree270Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree300Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree330Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
    }

    public void addMoveAbilities(OnRoadLandTransporter transporter, ArrayList<Ability> abilitiesList){

        //abilities to move
        MoveAbility moveAbility = new MoveDegree0Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree30Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree60Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree90Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree120Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree150Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree180Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree210Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree240Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree270Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree300Ability(transporter, executionManager);
        addMoveAbility(moveAbility, transporter, abilitiesList);
        moveAbility = new MoveDegree330Ability(transporter, executionManager);
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
       return (validationManager.validateResources(transporter, CLAYPIT_BOARD, CLAYPIT_STONE) && validationManager.validateShore(transporter) && !validationManager.existingProducer(transporter));
    }

    private boolean verifyCoalBurnerAbility(Transporter transporter) {
       return validationManager.validateResources(transporter, COALBURNER_BOARD, COALBURNER_STONE) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyMineAbility(Transporter transporter) {
        return ( validationManager.validateResources(transporter, MINE_BOARD, MINE_STONE) && validationManager.validateTerrain(transporter, MOUNTAINS) && !validationManager.existingProducer(transporter));
    }

    private boolean verifyMintAbility(Transporter transporter) {
        return validationManager.validateResources(transporter, MINT_BOARD, MINT_STONE) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyOilRigAbility(Transporter transporter) {
        return (researchManager.isFinishedOilResearch() && validationManager.validateResources(transporter, OILRIG_BOARD, OILRIG_STONE) && validationManager.validateTerrain(transporter, SEA)) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyPaperMillAbility(Transporter transporter) {
        return (validationManager.validateResources(transporter, PAPERMILL_BOARD, PAPERMILL_STONE)) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyRaftFactoryAbility(Transporter transporter){
        return (validationManager.validateResources(transporter, RAFTFACTORY_BOARD, RAFTFACTORY_STONE) && validationManager.validateShore(transporter)) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyRowboatFactoryAbility(Transporter transporter){
        return (validationManager.validateShore(transporter) && researchManager.isFinishedRowingResearch() && validationManager.validateResources(transporter, ROWBOATFACTORY_BOARD, ROWBOATFACTORY_STONE)) && !validationManager.existingProducer(transporter);
    }

    private boolean verifySteamerFactoryAbility(Transporter transporter){
        return (validationManager.validateShore(transporter) && researchManager.isFinishedShipResearch() && validationManager.validateResources(transporter, STEAMER_BOARD, STEAMER_STONE)) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyStockExchangeAbility(Transporter transporter){
        return (validationManager.validateResources(transporter, STOCK_BOARD, STOCK_STONE)) && !validationManager.existingProducer(transporter);
    }

    private  boolean verifyStoneFactoryAbility(Transporter transporter){
        return (validationManager.validateResources(transporter, STONEFACTORY_BOARD, STONEFACTORY_STONE)) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyStoneQuarryAbility(Transporter transporter){
        return (validationManager.validateResources(transporter, QUARRY_BOARD, QUARRY_STONE) && validationManager.validateTerrain(transporter, ROCK)) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyTruckFactoryAbility(Transporter transporter){
        return (validationManager.validateResources(transporter, TRUCKFACTORY_BOARD, TRUCKFACTORY_STONE) && researchManager.isFinishedTruckResearch()) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyWagonFactoryAbility(Transporter transporter){
        return (validationManager.validateResources(transporter, WAGONFACTORY_BOARD, WAGONFACTORY_STONE)) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyWoodcutterAbility(Transporter transporter){
        return (validationManager.validateResources(transporter, WOODCUTTER_BOARD, WOODCUTTER_STONE) && validationManager.validateTerrain(transporter, WOODS)) && !validationManager.existingProducer(transporter);
    }

    private boolean verifyWaterMoveAbility(MoveAbility moveAbility, WaterTransporter transporter){
        return validationManager.validateWaterMove(transporter,moveAbility);
    }

    private boolean verifyLandMoveAbility(MoveAbility moveAbility, LandTransporter transporter){
        return validationManager.validateLandMove(transporter,moveAbility);
    }

    private boolean verifyRoadMoveAbility(MoveAbility moveAbility, OnRoadLandTransporter transporter){
        return validationManager.validateRoadMove(transporter, moveAbility);
    }

    private boolean verifyRiverDockAbility(DockatRiverAbility dockatRiverAbility, WaterTransporter transporter){
        return validationManager.validateRiverDock(transporter);
    }

    private boolean verifySeaDockAbility(DockatSeaAbility dockatSeaAbility, WaterTransporter transporter){
        return validationManager.validateSeaDock(transporter, dockatSeaAbility);
    }

    private boolean verifyUndockAbility(UndockAbility undockAbility, WaterTransporter transporter){
        return validationManager.validateUndock(transporter);
    }

    /*public String getAbilityName(Ability ability){
        return null;
    }*/

}
