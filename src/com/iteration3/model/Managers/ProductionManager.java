package com.iteration3.model.Managers;

import com.iteration3.model.Buildings.Primary.PrimaryProducer;
import com.iteration3.model.Buildings.Secondary.SecondaryProducer;
import com.iteration3.model.Buildings.Transporter.TransporterFactory;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.Region;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Transporters.Transporter;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductionManager {

    private Map map;
    private ValidationManager validationManager;

    public ProductionManager(Map map) {
        this.map = map;
        this.validationManager = new ValidationManager(map);
    }


    public void producePrimaryProducers() {
        HashMap<RegionLocation, PrimaryProducer> primaryProducers = getPrimaryProducers();
        for(RegionLocation regionLocation: primaryProducers.keySet()) {
            map.addResource(primaryProducers.get(regionLocation).produce(), regionLocation);
        }
    }


    public void produceSecondaryProducers(Transporter transport) {
        RegionLocation transportLocation = this.map.getTransportRegionLocation(transport);
        ResourceList availableResources = validationManager.getAvailableResources(transport);

        HashMap<RegionLocation, SecondaryProducer> secondaryProducers = getSecondaryProducers();
        for(RegionLocation regionLocation: secondaryProducers.keySet()) {
            if(regionLocation.getLocation().equals(transportLocation.getLocation())){
                SecondaryProducer secondaryProducer = secondaryProducers.get(regionLocation);
                ArrayList<Resource> createdResources = secondaryProducer.produce(availableResources);
                ArrayList<Resource> usedResources = secondaryProducer.getNecessaryResources();

                for(Resource resource: createdResources) {
                    for(Resource usedResource: usedResources) {
                        if(transport.removeResource(usedResource)) {

                        } else {
                            // WILL ONLY REMOVE IF IT IS ON SPECIFIC REGION LOCATION
                            map.removeResource(usedResource, regionLocation);
                        }
                    }
                    transport.addResource(resource);
                }
            }
        }
    }

    public void produceSecondaryProducers() {

        HashMap<RegionLocation, SecondaryProducer> secondaryProducers = getSecondaryProducers();
        for(RegionLocation regionLocation: secondaryProducers.keySet()) {
            ResourceList availableResources = validationManager.getAvailableResources(regionLocation);
            SecondaryProducer secondaryProducer = secondaryProducers.get(regionLocation);
            ArrayList<Resource> createdResources = secondaryProducer.produce(availableResources);
            ArrayList<Resource> usedResources = secondaryProducer.getNecessaryResources();

            for(Resource resource: createdResources) {
                for(Resource usedResource: usedResources) {
                        map.removeResource(usedResource, regionLocation);
                }
                this.map.addResource(resource, regionLocation);
            }
        }
    }

    public void produceTransports(Transporter transport) {
        RegionLocation transportLocation = this.map.getTransportRegionLocation(transport);
        ResourceList availableResources = validationManager.getAvailableResources(transport);

        HashMap<RegionLocation, TransporterFactory> transportFactories = getTransporterFactories();
        for(RegionLocation regionLocation: transportFactories.keySet()) {
            if(regionLocation.getLocation().equals(transportLocation.getLocation())){
                TransporterFactory transporterFactory = transportFactories.get(regionLocation);
                Transporter transporter = transporterFactory.produce(transport.getOwner(), availableResources);
                ArrayList<Resource> usedResources = transporterFactory.getNecessaryResources();

                for(Resource usedResource: usedResources) {
                    if(transport.removeResource(usedResource)) {

                    } else {
                        // WILL ONLY REMOVE IF IT IS ON SPECIFIC REGION LOCATION
                        map.removeResource(usedResource, regionLocation);
                    }
                }
                map.addTransport(transporter, regionLocation);

            }
        }
    }


    public void produceTransports() {

        HashMap<RegionLocation, TransporterFactory> transporterFactories = getTransporterFactories();
        for(RegionLocation regionLocation: transporterFactories.keySet()) {
            TransporterFactory transporterFactory = transporterFactories.get(regionLocation);
            ArrayList<Resource> usedResources = transporterFactory.getNecessaryResources();

            for(Resource usedResource: usedResources) {
                map.removeResource(usedResource, regionLocation);
            }

        }
    }


    private HashMap<RegionLocation, PrimaryProducer> getPrimaryProducers() {
        HashMap<RegionLocation, PrimaryProducer> primaryProducers = new HashMap<>();
        for(RegionLocation regionLocation: this.map.getProducers().keySet()) {
            if(this.map.getProducers().get(regionLocation) instanceof PrimaryProducer) {
                primaryProducers.put(regionLocation, (PrimaryProducer) this.map.getProducers().get(regionLocation));
            }
        }
        return primaryProducers;
    }

    private HashMap<RegionLocation, SecondaryProducer> getSecondaryProducers() {
        HashMap<RegionLocation, SecondaryProducer> secondaryProducers = new HashMap<>();

        for(RegionLocation regionLocation: this.map.getProducers().keySet()) {
            if(this.map.getProducers().get(regionLocation) instanceof SecondaryProducer) {
                secondaryProducers.put(regionLocation, (SecondaryProducer) this.map.getProducers().get(regionLocation));
            }
        }

        return secondaryProducers;
    }

    private HashMap<RegionLocation, TransporterFactory> getTransporterFactories() {
        HashMap<RegionLocation, TransporterFactory> transporterFactories = new HashMap<>();
        for(RegionLocation regionLocation: this.map.getProducers().keySet()) {
            if(this.map.getProducers().get(regionLocation) instanceof TransporterFactory) {
                transporterFactories.put(regionLocation, (TransporterFactory) this.map.getProducers().get(regionLocation));
            }
        }
        return transporterFactories;
    }

}
