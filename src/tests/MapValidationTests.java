import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Managers.ValidationManager;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Players.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MapValidationTests {
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception{
        Map map = new Map();
        player1 = new Player(map,1, null);
        player2 = new Player(map, 2,null);
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
    }

    @Test
    public void LandTest1() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
        ValidationManager validationManager = new ValidationManager(map);

        RegionLocation start = new RegionLocation(0,0,0,1);
        assertEquals(validationManager.validateLandMove(start,1,1,player1,2),false);
        assertEquals(validationManager.validateLandMove(start,2,3,player1,2),true);
        assertEquals(validationManager.validateLandMove(start,5,5,player1,2),false);
        map.addBridge(new Location(0,0,0),1);
        assertEquals(validationManager.validateLandMove(start,5,5,player1,2),true);
        assertEquals(validationManager.validateLandMove(start,3,3,player1,2),false);
        assertEquals(validationManager.validateLandMove(start,3,4,player1,2),false);
        map.addBridge(new Location(0,0,0),3);
        assertEquals(validationManager.validateLandMove(start,3,3,player1,2),true);
        assertEquals(validationManager.validateLandMove(start,3,4,player1,2),true);
        assertEquals(validationManager.validateLandMove(start,3,3,player1,1),false);
        assertEquals(validationManager.validateLandMove(start,3,4,player1,1),false);
        map.addRoad(start.getLocation(),start.getLocation().getSouthEast());
        map.addRoad(start.getLocation(),start.getLocation().getSouth());
        assertEquals(validationManager.validateLandMove(start,3,3,player1,1),true);
        assertEquals(validationManager.validateLandMove(start,3,4,player1,1),true);
        map.addWall(start.getLocation(),player1,3,1);
        map.addWall(start.getLocation(),player2, 4, 1);
        assertEquals(validationManager.validateLandMove(start,3,3,player1,1),true);
        assertEquals(validationManager.validateLandMove(start,3,4,player1,1),false);
        assertEquals(validationManager.validateLandMove(new RegionLocation(1,-1,0,1),6,6,player2,1),false);
        assertEquals(validationManager.validateLandMove(new RegionLocation(0,-1,1,1),1,1,player2,1),true);
    }

    @Test
    public void LandTest2()throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
        ValidationManager validationManager = new ValidationManager(map);

        RegionLocation start = new RegionLocation(0,-1,1,1);
        assertEquals(validationManager.validateLandMove(start,1,1,player1,2),true);
        assertEquals(validationManager.validateLandMove(start,3,4,player1,2),true);
        assertEquals(validationManager.validateLandMove(start,5,5,player1,2),true);
    }

    @Test
    public void RoadTest1() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
        ValidationManager validationManager = new ValidationManager(map);

        RegionLocation start = new RegionLocation(0,0,0,1);
        assertEquals(validationManager.validateRoadMove(start,2,3,player1),false);
        assertEquals(validationManager.validateRoadMove(new RegionLocation(1,-1,0,6),6,6,player1),false);
        map.addRoad(new Location(0,0,0), new Location(1,-1,0));
        assertEquals(validationManager.validateRoadMove(start,2,3,player1),true);
        assertEquals(validationManager.validateRoadMove(new RegionLocation(1,-1,0,6),6,6,player1),true);
        map.addWall(start.getLocation(),player2, 3, 1);
        assertEquals(validationManager.validateRoadMove(start,2,3,player1),false);
        assertEquals(validationManager.validateRoadMove(new RegionLocation(1,-1,0,6),6,6,player1),false);
    }

    @Test
    public void WaterTest1() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
        ValidationManager validationManager = new ValidationManager(map);

        RegionLocation start = new RegionLocation(0,1,-1,7);
        assertEquals(validationManager.validateWaterMove(start,4,player1),true);
        assertEquals(validationManager.validateWaterMove(start,1,player1),true);
        assertEquals(validationManager.validateWaterMove(start,2,player1),false);
        assertEquals(validationManager.validateWaterMove(start,6,player1),false);

        map.addWall(start.getLocation().getSouth(),player2,1,1);
        assertEquals(validationManager.validateWaterMove(start,4,player1),false);
        assertEquals(validationManager.validateWaterMove(start,4,player2),true);
    }

    @Test
    public void WaterTest2() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
        ValidationManager validationManager = new ValidationManager(map);

        RegionLocation start = new RegionLocation(0,0,0,7);
        assertEquals(validationManager.validateWaterMove(start,4,player1),false);
        assertEquals(validationManager.validateWaterMove(start,1,player1),true);
        assertEquals(validationManager.validateWaterMove(start,3,player1),true);
        assertEquals(validationManager.validateWaterMove(start,5,player1),true);
        map.addWall(start.getLocation(),player1,1,1);
        map.addWall(start.getLocation(),player2,3,1);
        map.addWall(start.getLocation(),player2,5,1);
        assertEquals(validationManager.validateWaterMove(start,1,player1),true);
        assertEquals(validationManager.validateWaterMove(start,3,player1),false);
        assertEquals(validationManager.validateWaterMove(start,5,player1),false);
    }

}
