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

    public Player(Map map, int id){
        researchManager = new ResearchManager();
        transportersList = new TransportList();
        MovementManager movementManager = new MovementManager(map);
        abilityManager = new AbilityManager(map,movementManager, researchManager);
    }

    public void updateTransporterAbilities(){
        updateLandTransportAbilities();
        updateRoadTransportAbilities();
        updateWaterTransporterAbilties();
    }

    public void updateLandTransportAbilities(){
        ArrayList<LandTransporter> landTransporters = this.transportersList.getLandTransports();
        abilityManager.updateLandTransporters(landTransporters);
    }


    public void updateWaterTransporterAbilties(){
        ArrayList<WaterTransporter> waterTransporters = this.transportersList.getWaterTransports();
        abilityManager.updateWaterTransporters(waterTransporters);
    }

    public void updateRoadTransportAbilities(){
        ArrayList<OnRoadLandTransporter> roadTransporters = this.transportersList.getRoadTransports();
        abilityManager.updateRoadTransporters(roadTransporters);
    }
}
