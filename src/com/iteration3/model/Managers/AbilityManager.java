package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.*;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

import java.util.ArrayList;
import java.util.List;

public class AbilityManager {
    ArrayList<Ability> abilityList;
    Map map;
    MovementManager movementManager;


    public AbilityManager(Map map, MovementManager movementManager){
        ArrayList<Ability> abilityList = new ArrayList<>();
        this.map = map;
        this.movementManager = movementManager;
        //???
    }

    public void giveAbilities(WaterTransporter transporter){
        transporter.clearAbilityList();
        abilityList = populateList(transporter);
        transporter.setAbilityList(abilityList);
    }

    public ArrayList<Ability> populateList(WaterTransporter transporter) {
        ArrayList<Ability> abilitiesList = new ArrayList<>();

        //construction abilities
        if (verifyClaypitAbility(transporter)) {
            abilitiesList.add(new BuildClaypitAbility(transporter));
        }
        if (verifyCoalBurnerAbility(transporter)) {
            abilitiesList.add(new BuildCoalBurnerAbility(transporter));
        }

        return abilitiesList;
    }

    public ArrayList<Ability> populateMoveList(WaterTransporter transporter){
        ArrayList<Ability> abilitiesList = new ArrayList<>();

        //abilities to move
        MoveAbility moveAbility = new MoveDegree0Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree30Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree60Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree90Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree120Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree150Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree180Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree210Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree240Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree270Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree300Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree330Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        return abilitiesList;
        }

    public ArrayList<Ability> populateMoveList(LandTransporter transporter){
        ArrayList<Ability> abilitiesList = new ArrayList<>();

        //abilities to move
        MoveAbility moveAbility = new MoveDegree0Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree30Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree60Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree90Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree120Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree150Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree180Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree210Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree240Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree270Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree300Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree330Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        return abilitiesList;
    }

    public ArrayList<Ability> populateMoveList(OnRoadLandTransporter transporter){
        ArrayList<Ability> abilitiesList = new ArrayList<>();

        //abilities to move
        MoveAbility moveAbility = new MoveDegree0Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree30Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree60Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree90Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree120Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree150Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree180Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree210Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree240Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree270Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree300Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        moveAbility = new MoveDegree330Ability(transporter);
        addMoveAbility(moveAbility, transporter);
        return abilitiesList;
    }


    private boolean verifyClaypitAbility(Transporter transporter) {
        return true; //TODO: make proper verifier
    }

    private boolean verifyCoalBurnerAbility(Transporter transporter) {
        return true; //TODO: make proper verifier
    }

    private void addMoveAbility(MoveAbility moveAbility, WaterTransporter transporter){
        if(verifyWaterMoveAbility(moveAbility, transporter)) { abilityList.add(moveAbility); }
    }

    private void addMoveAbility(MoveAbility moveAbility, LandTransporter transporter){
        if(verifyLandMoveAbility(moveAbility, transporter)) { abilityList.add(moveAbility); }
    }

    private void addMoveAbility(MoveAbility moveAbility, OnRoadLandTransporter transporter){
        if(verifyRoadMoveAbility(moveAbility, transporter)) { abilityList.add(moveAbility); }
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




}
