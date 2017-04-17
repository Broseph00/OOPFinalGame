import com.iteration3.model.GameModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameModelTest {

    @Test
    public void testStartingResources() throws Exception {
        GameModel gameModel = new GameModel();

        assertEquals(gameModel.getPlayer1().getTransportersList().getTransports().size(), 3);
        assertEquals(gameModel.getPlayer1().getTransportersList().getTransports().size(), 3);

        assertEquals(gameModel.getMap().getResources().get(gameModel.getPlayer1().getStartingRegionLocation()).getResources().size(), 8);
        assertEquals(gameModel.getMap().getResources().get(gameModel.getPlayer2().getStartingRegionLocation()).getResources().size(), 8);

    }

    @Test
    public void WonderManager(){

    }


}
