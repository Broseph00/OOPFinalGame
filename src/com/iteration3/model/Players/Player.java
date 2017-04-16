package com.iteration3.model.Players;

import com.iteration3.model.Managers.AbilityManager;
import com.iteration3.model.Managers.MovementManager;
import com.iteration3.model.Managers.ResearchManager;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.TransportList;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

import java.util.ArrayList;

public class Player {
    private int id;
    private TransportList transportersList;
    private AbilityManager abilityManager;
    private ResearchManager researchManager;
    private MovementManager movementManager;

    public Player(Map map, int id, MovementManager movementManager){
        researchManager = new ResearchManager();
        transportersList = new TransportList();
        this.movementManager = movementManager;
        abilityManager = new AbilityManager(map,this.movementManager, researchManager);
        this.id = id;
    }

    public void updateTransporterAbilities(){
        //System.out.println("Step 1");
        updateLandTransportAbilities();
        updateRoadTransporterAbilities();
        updateWaterTransporterAbilties();
    }

    private void updateLandTransportAbilities(){
        //System.out.println("Step 2");
        ArrayList<LandTransporter> landTransporters = this.transportersList.getLandTransports();
        abilityManager.updateLandTransporters(landTransporters);
    }


    private void updateWaterTransporterAbilties(){
        ArrayList<WaterTransporter> waterTransporters = this.transportersList.getWaterTransports();
        abilityManager.updateWaterTransporters(waterTransporters);
    }

    private void updateRoadTransporterAbilities(){
        ArrayList<OnRoadLandTransporter> roadTransporters = this.transportersList.getRoadTransports();
        abilityManager.updateRoadTransporters(roadTransporters);
    }

    public void addTransporter(Transporter transporter){
        transportersList.addTransport(transporter);
    }

    public TransportList getTransportersList(){
        return transportersList;
    }

    public ResearchManager getResearchManager(){
        return researchManager;
    }
}
