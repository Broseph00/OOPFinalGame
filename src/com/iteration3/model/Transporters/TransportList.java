package com.iteration3.model.Transporters;


import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Land.RoadOnly.OnRoadLandTransporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;
import sun.plugin2.message.transport.Transport;

import java.util.ArrayList;

public class TransportList {

    private ArrayList<Transporter> transports;

    public TransportList() {
        this.transports = new ArrayList<>();
    }

    public TransportList(ArrayList<Transporter> transports) {
        this.transports = transports;
    }

    public ArrayList<Transporter> getTransports() {
        return transports;
    }

    public boolean isEmpty(){
        return transports.isEmpty();
    }

    public ArrayList<WaterTransporter> getWaterTransports() {
        ArrayList<WaterTransporter> waterTransporters = new ArrayList<>();
        for(int i = 0; i < this.transports.size(); i++) {
            if(this.transports.get(i) instanceof WaterTransporter) {
                waterTransporters.add((WaterTransporter) this.transports.get(i));
            }
        }
        return waterTransporters;
    }

    public ArrayList<LandTransporter> getLandTransports() {
        ArrayList<LandTransporter> landTransporters = new ArrayList<>();
        for(int i = 0; i < this.transports.size(); i++) {
            if(this.transports.get(i) instanceof LandTransporter) {
                landTransporters.add((LandTransporter) this.transports.get(i));
            }
        }
        return landTransporters;
    }

    public ArrayList<OnRoadLandTransporter> getRoadTransports() {
        ArrayList<OnRoadLandTransporter> roadTransporters = new ArrayList<>();
        for(int i = 0; i < this.transports.size(); i++) {
            if(this.transports.get(i) instanceof OnRoadLandTransporter) {
                roadTransporters.add((OnRoadLandTransporter) this.transports.get(i));
            }
        }
        return roadTransporters;
    }

    public void removeTransport(Transporter t) {
        this.transports.remove(t);
    }

    public void addTransport(Transporter t) {
        this.transports.add(t);
    }


}
