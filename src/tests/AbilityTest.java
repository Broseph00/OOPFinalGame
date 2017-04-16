package tests;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.Abilities.BuildOilRigAbility;
import com.iteration3.model.GameModel;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Players.Research.OilResearch;
import com.iteration3.model.Players.Research.Research;
import com.iteration3.model.Transporters.Land.Donkey;
import com.iteration3.model.Transporters.Transporter;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;



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
        assertEquals(true, player1.getTransportersList().getWaterTransports().isEmpty());
        assertEquals(true, player1.getTransportersList().getRoadTransports().isEmpty());

        player1.updateTransporterAbilities();
        assertEquals(false, transporter.getAbilityList().isEmpty());

        OilResearch oilResearch = (OilResearch) player1.getResearchManager().getResearchList().get(2);
        assertEquals(true, player1.getResearchManager().getResearchList().contains(oilResearch));
        assertEquals(4, transporter.getAbilityList().size());

        //System.out.println("Before finishing research:");
        //printResearchList(player1.getResearchManager().getResearchList());
        //printAbilityList(transporter.getAbilityList());

        player1.getResearchManager().completeResearch(oilResearch);
        player1.updateTransporterAbilities();

        //System.out.println("After finishing research:");
        //printResearchList(player1.getResearchManager().getResearchList());
        //printAbilityList(transporter.getAbilityList());
        
        assertEquals(false, player1.getResearchManager().getResearchList().contains(oilResearch));
        assertEquals(5, transporter.getAbilityList().size());
    }

    public void printResearchList(List<Research> researchList){
        for(Research research : researchList){
            System.out.println(research.getClass());
        }
    }

    public void printAbilityList(List<Ability> abilityList){
        for(Ability ability : abilityList){
            System.out.println(ability.getClass());
        }

    }
}
