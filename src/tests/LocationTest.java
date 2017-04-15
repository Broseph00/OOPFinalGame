import com.iteration3.model.Map.Location;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class LocationTest {

    @Test
    public void testArray(){
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(0,0,0));
        locations.add(new Location(1,1,1));
        assertEquals(locations.contains(new Location(1,1,1)), true);
        locations.remove(new Location(1,1,1));
        assertEquals(locations.contains(new Location(1,1,1)), false);
    }
}
