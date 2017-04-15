import com.iteration3.model.Managers.MapFileManager;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Players.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MapValidationTests {
    private Map map;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() throws Exception{
        player1 = new Player(null,null);
        player2 = new Player(null,null);
        map = new Map();
        MapFileManager mapManager = new MapFileManager(map, "src/com/iteration3/RoadsAndBoatsMap.txt");
        mapManager.fillMapFromTextFile();
    }

    @Test
    public void testFilled(){
        assertEquals(map.getTiles().size(),37);
        assertEquals(map.getRivers().size(),7);
    }

    @Test
    public void test1(){
        
    }


}
