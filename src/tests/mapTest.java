package tests;

import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.River;
import com.iteration3.model.Tiles.PastureTerrain;
import com.iteration3.model.Tiles.SeaTerrain;
import com.iteration3.model.Tiles.Tile;
import com.iteration3.model.Tiles.WoodTerrain;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
//        assertEquals(map.getRivers().size(), 7);

        // need to print edges and tiles to check if they are correct
        map.printRivers();
        map.printTiles();
    }

    @Test
    public void testMapToFile() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/tests/mapFileTest.txt");

        map.addTileFromFile(new Location(0,0,0), new Tile(new PastureTerrain()));
        map.addTileFromFile(new Location(0,0,1), new Tile(new WoodTerrain()));
        map.addTileFromFile(new Location(0,1,-1), new Tile(new WoodTerrain()));

        map.addRiverFromFile(new Location(0,0,0), new River(1));
        map.addRiverFromFile(new Location(0,1,-1), new River(4, 1));

        mapManager.fillTextFileFromMap();

    }


}
