package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.Abilities.BuildClaypitAbility;
import com.iteration3.model.Abilities.BuildCoalBurnerAbility;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Transporters.Transporter;

import java.util.ArrayList;
import java.util.List;

public class AbilityManager {
    ArrayList<Ability> abilityList;
    Map map;

    public AbilityManager(Map map){
        ArrayList<Ability> abilityList = new ArrayList<>();
        this.map = map;
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
        //TODO: REST OF THE ABILITIES
        return abilitiesList;
        }


    public boolean verifyClaypitAbility(Transporter transporter) {
        return true; //TODO: make proper verifier
    }

    public boolean verifyCoalBurnerAbility(Transporter transporter) {
        return true; //TODO: make proper verifier
    }



}
