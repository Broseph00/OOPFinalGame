package com.iteration3.model.Players;

import com.iteration3.model.Managers.AbilityManager;
import com.iteration3.model.Managers.ResearchManager;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

import java.util.ArrayList;

public class Player {
    private ArrayList<Transporter> transportersList;
    private AbilityManager abilityManager;
    private ResearchManager researchManager;

    public Player(AbilityManager abilityManager, ResearchManager researchManager){
        this.abilityManager = abilityManager;
        this.researchManager = researchManager;
        transportersList = new ArrayList<>();
    }

    public void updateTransporterAbilities(){
        updateLandTransportAbilities();
        updateRoadTransportAbilities();
        updateWaterTransporterAbilties();

    }

    public void updateLandTransportAbilities(){
        ArrayList<LandTransporter> landTransporters = new ArrayList<>();
        for(Transporter transporter : transportersList) {
            if(transporter instanceof LandTransporter) {
                landTransporters.add((LandTransporter) transporter );
            }
        }
        abilityManager.updateLandTransporters(landTransporters);
    }

    public void updateWaterTransporterAbilties(){
        ArrayList<WaterTransporter> waterTransporters = new ArrayList<>();
        for(Transporter transporter : transportersList) {
            if(transporter instanceof WaterTransporter) {
                waterTransporters.add((WaterTransporter) transporter );
            }
        }
        abilityManager.updateWaterTransporters(waterTransporters);
    }

    public void updateRoadTransportAbilities(){
        ArrayList<OnRoadLandTransporter> roadTransporters = new ArrayList<>();
        for(Transporter transporter : transportersList) {
            if(transporter instanceof OnRoadLandTransporter) {
                roadTransporters.add((OnRoadLandTransporter) transporter );
            }
        }
        abilityManager.updateRoadTransporters(roadTransporters);
    }
}
