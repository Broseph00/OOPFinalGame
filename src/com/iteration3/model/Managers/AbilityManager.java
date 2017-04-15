package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.*;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Transporters.Transporter;

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

    public void giveAbilities(Transporter transporter){
        transporter.clearAbilityList();
        abilityList = populateList(transporter);
        transporter.setAbilityList(abilityList);
    }

    public ArrayList<Ability> populateList(Transporter transporter){
        ArrayList<Ability> abilitiesList = new ArrayList<>();

        if (verifyClaypitAbility(transporter))  { abilitiesList.add(new BuildClaypitAbility(transporter)); }
        if (verifyCoalBurnerAbility(transporter))  {abilitiesList.add(new BuildCoalBurnerAbility(transporter)); }



        //abilities to move
        MoveAbility moveAbility = new MoveDegree0Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree30Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree60Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree90Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree120Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree150Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree180Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree210Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree240Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree270Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree300Ability(transporter);
        addMoveAbility(moveAbility);
        moveAbility = new MoveDegree330Ability(transporter);
        addMoveAbility(moveAbility);
        return abilitiesList;
        }


    private boolean verifyClaypitAbility(Transporter transporter) {
        return true; //TODO: make proper verifier
    }

    private boolean verifyCoalBurnerAbility(Transporter transporter) {
        return true; //TODO: make proper verifier
    }

    private void addMoveAbility(MoveAbility moveAbility){
        if(verifyMoveAbility(moveAbility)) { abilityList.add(moveAbility); }
    }


    private boolean verifyMoveAbility(MoveAbility moveAbility){
        return movementManager.validateMoveAbility(moveAbility);
    }


}
