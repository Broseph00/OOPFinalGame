package tests;

import com.iteration3.model.Abilities.*;
import com.iteration3.model.Abilities.MoveAbility.*;
import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Managers.ValidationManager;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.Land.RoadOnly.Wagon;
import com.iteration3.model.Transporters.Water.Raft;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MapValidationTests {
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception{
        Map map = new Map();
        player1 = new Player(map,1);
        player2 = new Player(map, 2);
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
        Donkey donkey = new Donkey(player1);
        map.addTransport(donkey, start);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree0Ability(donkey,null)),false);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree90Ability(donkey,null)),true);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree240Ability(donkey,null)),false);
        map.addBridge(new Location(0,0,0),1);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree240Ability(donkey,null)),true);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree120Ability(donkey,null)),false);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree150Ability(donkey,null)),false);
        map.addBridge(new Location(0,0,0),3);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree120Ability(donkey,null)),true);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree150Ability(donkey,null)),true);
        donkey.decreaseMovePoints(1);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree120Ability(donkey,null)),false);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree150Ability(donkey,null)),false);
        map.addRoad(start.getLocation(),start.getLocation().getSouthEast());
        map.addRoad(start.getLocation(),start.getLocation().getSouth());
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree120Ability(donkey,null)),true);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree150Ability(donkey,null)),true);
        map.addWall(start.getLocation(),player1,3,1);
        map.addWall(start.getLocation(),player2, 4, 1);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree120Ability(donkey,null)),true);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree150Ability(donkey,null)),false);
//        assertEquals(validationManager.validateLandMove(new RegionLocation(1,-1,0,1),6,6,player2,1),false);
//        assertEquals(validationManager.validateLandMove(new RegionLocation(0,-1,1,1),1,1,player2,1),true);
    }

    @Test
    public void LandTest2()throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
        ValidationManager validationManager = new ValidationManager(map);

        RegionLocation start = new RegionLocation(0,-1,1,1);
        Donkey donkey = new Donkey(player1);
        map.addTransport(donkey, start);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree0Ability(donkey,null)),true);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree150Ability(donkey,null)),true);
        assertEquals(validationManager.validateLandMove(donkey, new MoveDegree240Ability(donkey,null)),true);
    }

    @Test
    public void RoadTest1() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
        ValidationManager validationManager = new ValidationManager(map);

        RegionLocation start = new RegionLocation(0,0,0,1);
        Wagon wagon = new Wagon(player1);
        map.addTransport(wagon, start);
        RegionLocation start1 = new RegionLocation(1,-1,0, 6);

        Wagon wagon1 = new Wagon(player1);
        map.addTransport(wagon1, start1);

        assertEquals(validationManager.validateRoadMove(wagon, new MoveDegree90Ability(wagon,null)),false);
        assertEquals(validationManager.validateRoadMove(wagon1, new MoveDegree300Ability(wagon1,null)),false);
        map.addRoad(new Location(0,0,0), new Location(1,-1,0));
        assertEquals(validationManager.validateRoadMove(wagon, new MoveDegree90Ability(wagon,null)),true);
        assertEquals(validationManager.validateRoadMove(wagon1, new MoveDegree300Ability(wagon1,null)),true);
        map.addWall(start.getLocation(),player2, 3, 1);
        assertEquals(validationManager.validateRoadMove(wagon, new MoveDegree90Ability(wagon,null)),false);
        assertEquals(validationManager.validateRoadMove(wagon1, new MoveDegree300Ability(wagon1,null)),false);
    }

    @Test
    public void WaterTest1() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
        ValidationManager validationManager = new ValidationManager(map);

        RegionLocation start = new RegionLocation(0,1,-1,7);
        Raft raft = new Raft(player1);
        Raft raft1 = new Raft(player2);
        map.addTransport(raft, start);
        map.addTransport(raft1, start);

        assertEquals(validationManager.validateSeaDock(raft, new DockatSea1Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea2Ability(raft,null)), true);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea3Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea4Ability(raft,null)), true);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea5Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea6Ability(raft,null)), true);

        assertEquals(validationManager.validateRiverDock(raft), false);

        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge4Ability(raft,null)),true);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge1Ability(raft,null)),true);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge2Ability(raft,null)),false);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge6Ability(raft,null)),false);

        map.addWall(start.getLocation().getSouth(),player2,1,1);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge4Ability(raft,null)),false);
        assertEquals(validationManager.validateWaterMove(raft1, new MoveEdge4Ability(raft1,null)),true);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea4Ability(raft,null)), false);

        raft.dock();

        assertEquals(validationManager.validateSeaDock(raft, new DockatSea1Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea2Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea3Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea4Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea5Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea6Ability(raft,null)), false);

    }

    @Test
    public void WaterTest2() throws Exception{
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
        ValidationManager validationManager = new ValidationManager(map);

        RegionLocation start = new RegionLocation(0,0,0,7);
        Raft raft = new Raft(player1);
        map.addTransport(raft, start);

        assertEquals(validationManager.validateSeaDock(raft, new DockatSea1Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea2Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea3Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea4Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea5Ability(raft,null)), false);
        assertEquals(validationManager.validateSeaDock(raft, new DockatSea6Ability(raft,null)), false);

        assertEquals(validationManager.validateRiverDock(raft), true);

        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge4Ability(raft,null)),false);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge1Ability(raft,null)),true);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge3Ability(raft,null)),true);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge5Ability(raft,null)),true);
        map.addWall(start.getLocation(),player1,1,1);
        map.addWall(start.getLocation(),player2,3,1);
        map.addWall(start.getLocation(),player2,5,1);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge1Ability(raft,null)),true);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge3Ability(raft,null)),false);
        assertEquals(validationManager.validateWaterMove(raft, new MoveEdge5Ability(raft,null)),false);

        raft.dock();

        assertEquals(validationManager.validateRiverDock(raft), false);
    }

}
