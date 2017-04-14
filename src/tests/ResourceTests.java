import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Resource.Board;
import com.iteration3.model.Resource.ResourceList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResourceTests {

    @Test
    public void testAddRemoveFromResourceList() throws Exception {
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        RegionLocation location = new RegionLocation(0,0,0,0);
        mapManager.fillMapFromTextFile();

        map.getResources().put(location, new ResourceList());

        map.getResources().get(location).addBoard();
        assertEquals(map.getResources().get(location).getBoards().size(), 1);
        map.getResources().get(location).removeBoard();
        assertEquals(map.getResources().get(location).getBoards().size(), 0);
        map.getResources().get(location).removeBoard();
        assertEquals(map.getResources().get(location).getBoards().size(), 0);

        map.getResources().get(location).addGoose();
        map.getResources().get(location).addGold();
        assertEquals(map.getResources().get(location).getResources().size(), 2);



    }
}
