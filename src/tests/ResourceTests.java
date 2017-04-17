//package tests;

import com.iteration3.model.Buildings.Primary.Claypit;
import com.iteration3.model.Buildings.Primary.GoldMine;
import com.iteration3.model.Buildings.Secondary.CoalBurner;
import com.iteration3.model.Buildings.Secondary.Mint;
import com.iteration3.model.Buildings.Transporter.RaftFactory;
import com.iteration3.model.Buildings.Transporter.SteamerFactory;
import com.iteration3.model.Managers.*;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.*;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.Land.RoadOnly.Truck;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.Raft;
import com.iteration3.model.Transporters.Water.Steamship;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResourceTests {

    @Test
    public void testPickUpDropAndExchangeResource() throws Exception {
        Map map = new Map();
        ExchangeManager exchangeManager = new ExchangeManager(map);
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        RegionLocation location = new RegionLocation(0, 0, 0, 1);

        Player player1 = new Player(map, 1, new RegionLocation(0, 3, -3, 1));
        Player player2 = new Player(map, 2, new RegionLocation(0, 3, -3, 1));

        mapManager.fillMapFromTextFile();

        // initialize everything
        Board board = new Board();
        Donkey donkey = new Donkey(player1);
        Truck truck = new Truck(player2);
        map.addResource(board, location);
        map.addTransport(donkey, location);
        map.addTransport(truck, location);

        // check resource and transports are there
        assertEquals(map.getResources().get(location).getResources().size(), 1);
        assertEquals(map.getTransports().get(location).getTransports().size(), 2);
        exchangeManager.pickUpResource(donkey, board);
        assertEquals(map.getResources().containsKey(location), false);
        assertEquals(map.getTransports().get(location).getTransports().get(0).getResourceList().getResources().size(), 1);

        // trade from donkey to truck
        exchangeManager.tradeResource(donkey, truck, board);
        assertEquals(map.getTransports().get(location).getTransports().get(1).getResourceList().getResources().size(), 1);

        // drop resource
        exchangeManager.dropResource(truck, board);
        assertEquals(map.getResources().get(location).getResources().size(), 1);
    }


    @Test
    public void testPrimaryProducer() throws Exception {
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        ProductionManager productionManager = new ProductionManager(map);
        RegionLocation regionLocation = new RegionLocation(0, 0, 0, 1);
        Location location = new Location(0,0,0);

        Player player1 = new Player(map, 1, new RegionLocation(0, 3, -3, 1));
        Player player2 = new Player(map, 2, new RegionLocation(0, 3, -3, 1));

        mapManager.fillMapFromTextFile();


        map.addProducer(new Claypit(), regionLocation);

        map.addProducer(new GoldMine(), new RegionLocation(1,1,1,1));

        productionManager.producePrimaryProducers();

        assertTrue(map.getResources().get(regionLocation).getResources().get(0) instanceof Clay);
        assertTrue(map.getResources().get(new RegionLocation(1,1,1,1)).getResources().get(0) instanceof Gold);

    }


    @Test
    public void testSecondaryProducers() throws Exception {
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        ProductionManager productionManager = new ProductionManager(map);
        RegionLocation regionLocation = new RegionLocation(0, 0, 0, 1);
        Location location = new Location(0,0,0);

        Player player1 = new Player(map, 1, new RegionLocation(0, 3, -3, 1));
        Player player2 = new Player(map, 2, new RegionLocation(0, 3, -3, 1));

        mapManager.fillMapFromTextFile();


        map.addProducer(new CoalBurner(), regionLocation);
        map.addResource(new Trunk(), regionLocation);


        Donkey donkey = new Donkey(player1);
        donkey.addResource(new Trunk());

        map.addTransport(donkey, regionLocation);


        productionManager.produceSecondaryProducers(donkey);

        assertEquals(map.getTransports().get(regionLocation).getTransports().get(0).getResourceList().getFuel().size(),1);
        assertEquals(map.getResources().size(), 0);
        assertEquals(map.getTransports().get(regionLocation).getTransports().get(0).getResourceList().getResources().size(),1);

        map.addProducer(new Mint(), regionLocation);
        map.addResource(new Fuel(), regionLocation);
        map.addResource(new Gold(), regionLocation);
        map.addResource(new Gold(), regionLocation);
        productionManager.produceSecondaryProducers();
        assertEquals(map.getResources().get(regionLocation).getResources().size(), 1);
        assertEquals(map.getResources().get(regionLocation).getCoins().size(), 1);


    }

    @Test
    public void testTransportProducers() throws Exception {
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        ProductionManager productionManager = new ProductionManager(map);
        RegionLocation regionLocation = new RegionLocation(0, 0, 0, 1);
        RegionLocation regionLocation2 = new RegionLocation(0, -1, 1, 1);
        Location location = new Location(0,0,0);

        Player player1 = new Player(map, 1, new RegionLocation(0, 3, -3, 1));
        Player player2 = new Player(map, 2, new RegionLocation(0, 3, -3, 1));

        mapManager.fillMapFromTextFile();

        // create a raft for player1
        map.addProducer(new RaftFactory(), regionLocation);
        map.addResource(new Trunk(), regionLocation);


        Donkey donkey = new Donkey(player1);
        donkey.addResource(new Trunk());

        map.addTransport(donkey, regionLocation);

        productionManager.produceTransports(donkey);

        assertEquals(player1.getTransportersList().getTransports().size(),2);
        assertTrue(player1.getTransportersList().getTransports().get(1) instanceof Raft);
        assertEquals(map.getResources().size(), 0);

        // add transport without player present
        map.addProducer(new SteamerFactory(), regionLocation2);
        map.addResource(new Fuel(), regionLocation2);
        map.addResource(new Fuel(), regionLocation2);
        map.addResource(new Iron(), regionLocation2);

        productionManager.produceTransports();
        System.out.println(player1.getTransportersList().getTransports().get(0));
        assertEquals(player1.getTransportersList().getTransports().size(),2);
        assertEquals(map.getResources().size(), 0);



    }


}
