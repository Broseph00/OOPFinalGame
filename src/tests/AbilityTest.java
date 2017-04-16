package tests;

import com.iteration3.model.GameModel;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.Land.LandTransporter;
import com.iteration3.model.Transporters.Transporter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by test on 04/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    AbilityTest Module: Created by test on 04/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class AbilityTest {

    @Test
    public void testAbility(){
        GameModel gameModel = new GameModel();
        Player player1 = gameModel.getPlayer1();
        Transporter transporter = new Donkey(player1);
        assertEquals(true, transporter.getAbilityList().isEmpty());

        player1.addTransporter(transporter);
        assertEquals(false, player1.getTransportersList().getLandTransports().isEmpty());

        player1.updateTransporterAbilities();
        assertEquals(true, transporter.getAbilityList().isEmpty());
    }
}
