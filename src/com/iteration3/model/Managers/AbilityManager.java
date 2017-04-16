package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.*;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Players.Research.Research;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

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
        return abilitiesList;
    }

    public ArrayList<Ability> populateList(LandTransporter transporter) {
        ArrayList<Ability> abilitiesList = new ArrayList<>();
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
        return true; //TODO: make proper verifier
    }

    private boolean verifyCoalBurnerAbility(Transporter transporter) {
        return true; //TODO: make proper verifier
    }

    private boolean verifyMineAbility(Transporter transporter) { return true; } //TODO: make proper verifier

    private boolean verifyMintAbility(Transporter transporter) { return true; } //TODO: make proper verifier

    private boolean verifyOilRigAbility(Transporter transporter) {
        return researchManager.isFinishedOilResearch();
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

    /*public String getAbilityName(Ability ability){
        return null;
    }*/

}
