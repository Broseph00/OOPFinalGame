package tests;

import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Map.*;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Tiles.PastureTerrain;
import com.iteration3.model.Tiles.SeaTerrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Tiles.WoodTerrain;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MapTests {


    @Test
    public void testContains() {
        Map map = new Map();
        map.getTiles().put(new Location(0, 0, 0), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(1, -1, 1), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(-1, 1, 1), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(-1, 1, -1), new Tile(new SeaTerrain()));
        map.getTiles().put(new Location(1, 1, 1), new Tile(new SeaTerrain()));
        assertEquals(map.getTiles().containsKey(new Location(0, 0, 0)), true);
        assertEquals(map.getTiles().containsKey(new Location(1, -1, 1)), true);
        assertEquals(map.getTiles().containsKey(new Location(-1, 1, 1)), true);
        assertEquals(map.getTiles().containsKey(new Location(-1, 1, -1)), true);
        assertEquals(map.getTiles().containsKey(new Location(1, 1, 1)), true);
        assertEquals(map.getTiles().size(), 5);
        map.printTiles();
    }

    @Test
    public void testValidFileToMap() throws Exception {
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
    public void testMapToFile() throws Exception {
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/tests/mapFileTest.txt");

        // adding from file to avoid dealing with adjacency
        map.addTileFromFile(new Location(0, 0, 0), new Tile(new PastureTerrain()));
        map.addTileFromFile(new Location(0, 0, 1), new Tile(new WoodTerrain()));
        map.addTileFromFile(new Location(0, 1, -1), new Tile(new WoodTerrain()));

        map.addRiverFromFile(new Location(0, 0, 0), new River(1));
        map.addRiverFromFile(new Location(0, 1, -1), new River(4, 1));

        mapManager.fillTextFileFromMap();

    }


    // test adding Bridges to a River
    @Test
    public void testAddBridges() throws Exception {
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");

        mapManager.fillMapFromTextFile();

        ArrayList<Integer> bridgesToAdd = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        Location tileLocation = new Location(0, 0, 0);


        // add Bridges to Rivers w/ edge
        map.addBridges(tileLocation, bridgesToAdd);
        map.addBridges(new Location(-1, 3, -2), bridgesToAdd);
        assertEquals(map.getBridges().size(), 0);

        bridgesToAdd = new ArrayList<Integer>(Arrays.asList(1, 3));

        // add Bridges to Rivers w/ edge
        map.addBridges(tileLocation, bridgesToAdd);
        assertEquals(map.getBridges().size(), 1);
        assertEquals(map.getBridges().get(tileLocation).contains(1), true);


    }

    // TODO: add wall tests
    @Test
    public void testAddWalls() throws Exception {
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        Player player1 = new Player(null,null);
        Player player2 = new Player(null,null);
        Location location = new Location(0,0,0);
        Location waterLocation = new Location(-2,1,1);

        mapManager.fillMapFromTextFile();

        // add valid wall and check corresponding wall appears
        map.addWall(location, player1, 1,1);
        assertEquals(map.getWalls().size(), 2);
        assertEquals(map.getWalls().get(location.getNorth()).get(0).getEdge(), 4);

        // remove that wall and a extra for good measure
        map.removeWall(location.getNorth(), 4);
        map.removeWall(location.getNorth().getNorth(), 4);
        assertEquals(map.getWalls().size(), 0);

        // add valid wall and then try to add wall of invalid player
        map.addWall(location, player1, 2,1);
        map.addWall(location, player2, 2,1);
        assertEquals(map.getWalls().get(location.getNorthEast()).get(0).getEdge(), 5);
        assertEquals(map.getWalls().size(), 2);

        // test adding another wall
        map.addWall(location.getNorthWest(), player2, 4,1);
        assertEquals(map.getWalls().get(location.getNorthWest()).get(0).getEdge(), 4);
        assertEquals(map.getWalls().get(location.getNorthWest().getSouth()).get(0).getEdge(), 1);

        assertEquals(map.getWalls().size(), 4);

        // try to add wall between two sea tiles
        map.addWall(waterLocation, player1, 2,1);
        assertEquals(map.getWalls().size(), 4);

        map.destroyWall(location,2);
        assertTrue(map.getWalls().get(location).get(0) instanceof WallWithoutOwner);
        assertTrue(map.getWalls().get(location.getNorthEast()).get(0) instanceof WallWithoutOwner);

    }
}