package com.iteration3.model.Players;

import com.iteration3.controller.ControlDispatch;
import com.iteration3.controller.PhaseStates.ControlDispatchState;
import com.iteration3.model.Managers.*;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.TransporterIterator;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.TransportList;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;

import java.util.ArrayList;

public class Player {
    private int id;
    private String colorID;
    private TransportList transportersList;
    private AbilityManager abilityManager;
    private ResearchManager researchManager;
    private RegionLocation startingRegionLocation;

    public Player(Map map, int id, RegionLocation startingLocation, String colorID){
        researchManager = new ResearchManager();
        transportersList = new TransportList();
        abilityManager = new AbilityManager(map, new ValidationManager(map), researchManager, new ExecutionManager(map), new ExchangeManager(map));
        this.id = id;
        this.colorID = colorID;
        this.startingRegionLocation = startingLocation;
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
        System.out.println("aa");
        ArrayList<OnRoadLandTransporter> roadTransporters = this.transportersList.getRoadTransports();
        abilityManager.updateRoadTransporters(roadTransporters);
    }

    public void addTransporter(Transporter transporter){
        transportersList.addTransport(transporter);
    }

    public TransportList getTransportersList(){
        return transportersList;
    }

    public TransporterIterator getTransportIterator(){
        return transportersList.makeIterator();
    }

    public ResearchManager getResearchManager(){
        return researchManager;
    }

    public AbilityManager getAbilityManager() {
        return abilityManager;
    }

    public RegionLocation getStartingRegionLocation() {
        return startingRegionLocation;
    }

    public int getId() {
        return id;
    }

    public String getColorID() {
        return colorID;
    }

}
