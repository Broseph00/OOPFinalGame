import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Resource.ResourceList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResourceTests {

    @Test
    public void testGetGold() throws Exception {
        Map map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        RegionLocation location = new RegionLocation(0,0,0,0);
        mapManager.fillMapFromTextFile();

        map.getResources().put(location, new ResourceList());

    }
}
