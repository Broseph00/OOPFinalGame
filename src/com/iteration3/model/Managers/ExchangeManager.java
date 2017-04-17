package com.iteration3.model.Managers;

import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.Region;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Transporters.Transporter;

public class ExchangeManager {

    Map map;

    public ExchangeManager(Map m) {
        this.map = m;
    }

    // function for dropping a Resource onto the respective Transport's regionLocation
    public void dropResource(Transporter transport, Resource resource) {
        // get Transport RegionLocation
        RegionLocation dropLocation = this.map.getTransportRegionLocation(transport);

        // remove Resource from Transport's list and add to regionLocation's
        transport.removeResource(resource);
        this.map.addResource(resource, dropLocation);
    }

    // function for dropping a Resource onto the respective Transport's regionLocation
    public void pickUpResource(Transporter transport, Resource resource) {
        // get Transport RegionLocation
        RegionLocation dropLocation = this.map.getTransportRegionLocation(transport);

        // remove Resource from Transport's list and add to regionLocation's
        this.map.removeResource(resource, dropLocation);
        transport.addResource(resource);

    }

    // function for dropping a Resource onto the respective Transport's regionLocation
    public void tradeResource(Transporter transport1, Transporter transport2, Resource resource) {
        // get Transport RegionLocation
        RegionLocation dropLocation = this.map.getTransportRegionLocation(transport1);
        RegionLocation validateLocation = this.map.getTransportRegionLocation(transport2);

        if(dropLocation.getLocation() == validateLocation.getLocation()) {
            // remove Resource from Transport1's list and add to Transport2's
            transport1.removeResource(resource);
            transport2.addResource(resource);

        }



    }





}
