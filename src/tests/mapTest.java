package tests;

import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.River;
import com.iteration3.model.Tiles.PastureTerrain;
import com.iteration3.model.Tiles.SeaTerrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Tiles.WoodTerrain;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;


public class mapTest {

    @Test
    public void testContains(){
        Map map = new Map();
        map.getTiles().put(new Location(0,0,0), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(1,-1,1), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(-1,1,1), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(-1,1,-1), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(1,1,1), new Tile(new SeaTerrain()));
        assertEquals(map.getTiles().containsKey(new Location(0,0,0)), true);
        assertEquals(map.getTiles().containsKey(new Location(1,-1,1)), true);
        assertEquals(map.getTiles().containsKey(new Location(-1,1,1)), true);
        assertEquals(map.getTiles().containsKey(new Location(-1,1,-1)), true);
        assertEquals(map.getTiles().containsKey(new Location(1,1,1)), true);
        assertEquals(map.getTiles().size(),5);
        map.printTiles();
    }

    @Test
    public void testValidFileToMap() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");

        mapManager.fillMapFromTextFile();

        assertEquals(map.getTiles().size(), 37);
        assertEquals(map.getRivers().size(), 7);

        // need to print edges and tiles to check if they are correct
        map.printRivers();
        map.printTiles();
    }

    @Test
    public void testMapToFile() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/tests/mapFileTest.txt");

        // adding from file to avoid dealing with adjacency
        map.addTileFromFile(new Location(0,0,0), new Tile(new PastureTerrain()));
        map.addTileFromFile(new Location(0,0,1), new Tile(new WoodTerrain()));
        map.addTileFromFile(new Location(0,1,-1), new Tile(new WoodTerrain()));

        map.addRiverFromFile(new Location(0,0,0), new River(1));
        map.addRiverFromFile(new Location(0,1,-1), new River(4, 1));

        mapManager.fillTextFileFromMap();

    }


    // test adding Bridges to a River
    @Test
    public void testAddBridges() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");

        mapManager.fillMapFromTextFile();

        assertEquals(map.getTiles().size(), 37);
        assertEquals(map.getRivers().size(), 7);

        ArrayList<Integer> bridgesToAdd = new ArrayList<Integer>(Arrays.asList(1,2,3));
        Location tileLocation = new Location(0,0,0);


        // add Bridges to Rivers w/ edge
        map.addBridges(tileLocation, bridgesToAdd);
        System.out.println(map.getBridges().get(tileLocation));
        map.addBridges(new Location(-1,3,-2), bridgesToAdd);
        assertEquals(map.getBridges().size(), 0);

        bridgesToAdd = new ArrayList<Integer>(Arrays.asList(1,3));

        // add Bridges to Rivers w/ edge
        map.addBridges(tileLocation, bridgesToAdd);
        assertEquals(map.getBridges().size(), 1);
        assertEquals(map.getBridges().get(tileLocation).contains(1), true);

        // removeBridge
        ArrayList<Integer> bridgesToRemove = new ArrayList<Integer>(Arrays.asList(1));
        map.removeBridges(tileLocation, bridgesToRemove);
        assertEquals(map.getBridges().size(), 1);
        assertEquals(map.getBridges().get(tileLocation).contains(1), false);
        assertEquals(map.getBridges().get(tileLocation).contains(3), true);

        // get rid of all bridges and extra and see if size is 0
        map.addBridge(tileLocation, 0);
        map.addBridge(tileLocation, 5);
        map.removeBridge(tileLocation, 3);
        map.removeBridge(tileLocation, 5);
        map.removeBridge(tileLocation, 4);

        assertEquals(map.getBridges().size(), 0);


    }

    // TODO: add wall tests



}
