package tests;

import com.iteration3.model.Managers.*;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Resource.Board;
import com.iteration3.model.Resource.ResourceList;
import com.iteration3.model.Resource.Trunk;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.Land.RoadOnly.Truck;
import com.iteration3.model.Transporters.Transporter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResourceTests {

    @Test
    public void testAddRemoveFromResourceList() throws Exception {
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        RegionLocation location = new RegionLocation(0,0,0,1);
        mapManager.fillMapFromTextFile();

//        map.getResources().get(location).addBoard();
//        assertEquals(map.getResources().get(location).getBoards().size(), 1);
//        map.getResources().get(location).removeBoard();
//        assertEquals(map.getResources().get(location).getBoards().size(), 0);
//        map.getResources().get(location).removeBoard();
//        assertEquals(map.getResources().get(location).getBoards().size(), 0);
//
//        map.getResources().get(location).addGoose();
//        map.getResources().get(location).addGold();
//        assertEquals(map.getResources().get(location).getResources().size(), 2);

    }



    @Test
    public void testPickUpDropAndExchangeResource() throws Exception {
        Map map = new Map();
        ExchangeManager exchangeManager = new ExchangeManager(map);
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        RegionLocation location = new RegionLocation(0,0,0,1);

        Player player1 = new Player(map, 1, null);
        Player player2 = new Player(map, 2, null);

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

}
