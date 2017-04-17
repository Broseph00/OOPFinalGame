package com.iteration3.model.Managers;

import com.iteration3.model.GameModel;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Players.Wonder.Wonder;
import com.iteration3.model.Transporters.Transporter;

public class WonderManager {
    private final int IRRIGATION_ROW = 10;
    private final int INCREASED_COST_ROW = 5;

    private Wonder wonder;
    private GameModel gameModel;
    public WonderManager(GameModel gameModel){
        this.gameModel = gameModel;
        wonder = new Wonder();
    }

    public Wonder getWonder(){
        return wonder;
    }

    public void addPlayerBricks(Player owner, int quantity){
        if(wonder.isFull()){
            return;
        }

        int bricksAdded = 0;
        int alreadyPaid = 0;

        for(int i = 1; i <= quantity; ++i){
            int brickCost = calculateTotalBrickCost(i) - alreadyPaid;
            boolean playerPaid = false;
            // TODO: decrement cost from owner

            playerPaid = consumePlayerResources(owner, brickCost);

            if(playerPaid){
                alreadyPaid += brickCost;
                bricksAdded += wonder.addBrick(owner) ? 1 : 0;
                checkIrrigation();
            }
        }
    }

    private int calculateTotalBrickCost(int purchasedQty){
        int brickCost = 0;
        for (int i = 1; i <= purchasedQty; i++) {
            int currentTier = (wonder.getRowCount() < INCREASED_COST_ROW) ? 1 : 2;
            brickCost += (i + currentTier);
        }
        return brickCost;
    }

    private boolean consumePlayerResources(Player player, int qty){
        if(gameModel.validateWonderTransporter(player)){
            RegionLocation regionLocation = player.getStartingRegionLocation();
        }
        return true;
    }

    public void endTurn(){
        wonder.addNeutralBrick();
        checkIrrigation();
    }

    private void checkIrrigation() {
        // TODO: make call to Map to update desert tiles
    }
}
