package com.iteration3.model.Players;

import com.iteration3.model.Managers.AbilityManager;
import com.iteration3.model.Managers.ResearchManager;
import com.iteration3.model.Transporters.Transporter;

import java.util.ArrayList;

public class Player {
    private ArrayList<Transporter> transporters;
    private AbilityManager abilityManager;
    private ResearchManager researchManager;

    public Player(AbilityManager abilityManager, ResearchManager researchManager){
        this.abilityManager = abilityManager;
        this.researchManager = researchManager;
        transporters = new ArrayList<>();
    }
}
