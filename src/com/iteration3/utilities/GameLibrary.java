package com.iteration3.utilities;

/**
 * Created by test on 04/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    GameLibrary Module: Created by test on 04/15/2017.
|---------------------------------------------------------------------------------------
|   Description: holds static strings and names
|
---------------------------------------------------------------------------------------*/

public class GameLibrary {

    public static final String ENLARGEMENT_RESEARCH = "ENLARGEMENT RESEARCH", SHAFT_RESEARCH = "NEW SHAFT RESEARCH",
            OIL_RESEARCH = "DRILLING RESEARCH", ROWING_RESEARCH = "ROWING RESEARCH", SHIP_RESEARCH = "SHIP RESEARCH",
            SPECIALIZATION_RESEARCH = "SPECIALIZATION RESEARCH", TRUCK_RESEARCH = "TRUCK RESEARCH";

    public static final String BUILD_CLAYPIT_ABILITY = "BUILD CLAYPIT",
            BUILD_COALBURNER_ABILITY = "BUILD COAL BURNER", BUILD_MINE_ABILITY = "BUILD MINE",
            BUILD_MINT_ABILITY = "BUILD MINT", BUILD_OILRIG_ABILITY = "BUILD OILRIG",
            BUILD_PAPERMILL_ABILITY = "BUILD PAPERMILL", BUILD_RAFTFACTORY_ABILITY = "BUILD RAFT FACTORY",
            BUILD_ROWBOAT_ABILITY = "BUILD ROWBOAT FACTORY", BUILD_STEAMER_ABILITY = "BUILD STEAMER FACTORY",
            BUILD_STOCK_ABILITY = "BUILD STOCK EXCHANGE", BUILD_STONEFACTORY_ABILITY = "BUILD STONE FACTORY",
            BUILD_STONEQUARY_ABILITY = "BUILD STONE QUARRY", BUILD_TRUCK_ABILITY = "BUILD TRUCK FACTORY",
            BUILD_WAGON_ABILITY = "BUILD WAGON FACTORY", BUILD_WOODCUTTER_ABILITY = "BUILD WOODCUTTER",
            BUILD_GOLD_MINE = "BUILD GOLD MINE", BUILD_BIGMINE_ABILITY = "BUILD BIG MINE", BUILD_IRON_MINE = "BUILD IRON MINE";

    public static final String MOVE_ANGLE0_ABILITY = "MOVE NORTH", MOVE_ANGLE30_ABILITY = "MOVE NORTHEAST",
            MOVE_ANGLE60_ABILITY = "MOVE NORTHEAST", MOVE_ANGLE90_ABILITY = "MOVE SOUTHEAST",
            MOVE_ANGLE120_ABILITY = "MOVE SOUTHEAST", MOVE_ANGLE150_ABILITY = "MOVE SOUTH",
            MOVE_ANGLE180_ABILITY = "MOVE SOUTH", MOVE_ANGLE210_ABILITY = "MOVE SOUTHWEST",
            MOVE_ANGLE240_ABILITY = "MOVE SOUTHWEST", MOVE_ANGLE270_ABILITY = "MOVE NORTHWEST",
            MOVE_ANGLE300_ABILITY = "MOVE NORTHWEST", MOVE_ANGLE330_ABILITY = "MOVE NORTH";

    public static final String MOVE_EDGE1_ABILITY = "MOVE NORTH", MOVE_EDGE2_ABILITY = "MOVE NORTHEAST",
            MOVE_EDGE3_ABILITY = "MOVE SOUTHEAST", MOVE_EDGE4_ABILITY = "MOVE SOUTH",
            MOVE_EDGE5_ABILITY = "MOVE SOUTHWEST", MOVE_EDGE6_ABILITY = "MOVE NORTHWEST";

    public static final String DESERT = "desert", MOUNTAINS = "mountains", PASTURE = "pasture", ROCK = "rock",
            SEA = "sea", WOODS = "woods";

    public static final String DOCK_SEA1 = "DOCK NORTH", DOCK_SEA2 = "DOCK NORTHEAST", DOCK_SEA3 = "DOCK SOUTHEAST",
            DOCK_SEA4 = "DOCK SOUTH", DOCK_SEA5 = "DOCK SOUTHWEST", DOCK_SEA6 = "DOCK NORTHWEST", UNDOCK = "UNDOCK";

    public static final String DOCK_RIVER1 = "DOCK NORTHEAST", DOCK_RIVER2 = "DOCK EAST", DOCK_RIVER3 = "DOCK SOUTHEAST",
    DOCK_RIVER4 = "DOCK SOUTHWEST", DOCK_RIVER5 = "DOCK WEST", DOCK_RIVER6 = "DOCK NORTHWEST";

    public static final String DROP_RESOURCE = "DROP RESOURCE", PICKUP_RESOURCE = "PICKUP RESOURCE";

    public static final String BUILD_WALL_ABILITY = "BUILD WALL", BUILD_ROAD_ABILITY = "BUILD ROAD",
            BUILD_BRIDGE_ABILITY = "BUILD BRIDGE", DEMOLISH_WALL = "DEMOLISH WALL";

    public static final String PRODUCE_WOOD = "PRODUE WOOD";

    public static final int WOODCUTTER_BOARD = 1, WOODCUTTER_STONE = 0;

    public static final int QUARRY_BOARD = 2, QUARRY_STONE = 0;

    public static final int CLAYPIT_BOARD = 3, CLAYPIT_STONE = 0;

    public static final int MINE_BOARD = 3, MINE_STONE = 1;

    public static final int OILRIG_BOARD = 3, OILRIG_STONE = 1;

    public static final int SAWMILL_BOARD = 2, SAWMILL_STONE = 1;

    public static final int COALBURNER_BOARD = 3, COALBURNER_STONE = 0;

    public static final int PAPERMILL_BOARD = 1, PAPERMILL_STONE = 1;

    public static final int STONEFACTORY_BOARD = 2, STONEFACTORY_STONE = 1;

    public static final int MINT_BOARD = 2, MINT_STONE = 1;

    public static final int STOCK_BOARD = 2, STOCK_STONE = 1;

    public static final int WAGONFACTORY_BOARD = 2, WAGONFACTORY_STONE = 1;

    public static final int TRUCKFACTORY_BOARD = 2, TRUCKFACTORY_STONE = 2;

    public static final int RAFTFACTORY_BOARD = 1, RAFTFACTORY_STONE = 1;

    public static final int ROWBOATFACTORY_BOARD = 2, ROWBOATFACTORY_STONE = 1;

    public static final int STEAMER_BOARD = 2, STEAMER_STONE = 2;

    public static final int WALL_BOARD = 0, WALL_STONE = 1;

    public static final int ROAD_BOARD = 0, ROAD_STONE = 1;

    public static final int BRIDGE_BOARD = 0, BRIDGE_STONE = 1;
}
