package com.iteration3.utilities;

import javafx.scene.image.Image;

import java.util.HashMap;

/**
 * Created by LesliesLaptop on 3/27/17.
 */
public class Assets {
    private HashMap<String, Image> images;

    public Assets() {
        images = new HashMap<String, Image>();
        initializeImages();
    }

    public void initializeImages() {
        // TODO: Consider making these values enums?
        images.put(GameLibrary.DESERT, new Image("desert.png"));
        images.put(GameLibrary.MOUNTAINS, new Image("mountains.png"));
        images.put(GameLibrary.PASTURE, new Image("pasture.png"));
        images.put(GameLibrary.ROCK, new Image("rock.png"));
        images.put(GameLibrary.SEA, new Image("sea.png"));
        images.put(GameLibrary.WOODS, new Image("woods.png"));
        images.put("empty", new Image("empty.png"));
        images.put("cursor", new Image("cursor.png"));
        images.put("adj1", new Image("adj1.png"));
        images.put("adj2", new Image("adj2.png"));
        images.put("adj3", new Image("adj3.png"));
        images.put("adj4", new Image("adj4.png"));
        images.put("adj5", new Image("adj5.png"));
        images.put("adj6", new Image("adj6.png"));
        images.put("angled1", new Image("angled1.png"));
        images.put("angled2", new Image("angled2.png"));
        images.put("angled3", new Image("angled3.png"));
        images.put("angled4", new Image("angled4.png"));
        images.put("angled5", new Image("angled5.png"));
        images.put("angled6", new Image("angled6.png"));
        images.put("source1", new Image("source1.png"));
        images.put("source2", new Image("source2.png"));
        images.put("source3", new Image("source3.png"));
        images.put("source4", new Image("source4.png"));
        images.put("source5", new Image("source5.png"));
        images.put("source6", new Image("source6.png"));
        images.put("straight1", new Image("straight1.png"));
        images.put("straight2", new Image("straight2.png"));
        images.put("straight3", new Image("straight3.png"));
        images.put("tri1", new Image("tri1.png"));
        images.put("tri2", new Image("tri2.png"));
        images.put("welcomeImage", new Image("welcomeImage.png"));
        images.put("donkey", new Image("donkey.png"));
        images.put("wagon", new Image("wagon.png"));
        images.put("truck", new Image("truck.png"));
        images.put("raft", new Image("raft.png"));
        images.put("rowboat", new Image("rowboat.png"));
        images.put("steamship", new Image("steamship.png"));
        images.put("boards", new Image("boards.png"));
        images.put("clay", new Image("clay.png"));
        images.put("stone", new Image("stone.png"));
        images.put("coins", new Image("coins.png"));
        images.put("fuel", new Image("fuel.png"));
        images.put("gold", new Image("gold.png"));
        images.put("goose", new Image("goose.png"));
        images.put("iron", new Image("iron.png"));
        images.put("paper", new Image("paper.png"));
        images.put("stock", new Image("stock.png"));
        images.put("clayPit", new Image("clayPit.png"));
        images.put("coalBurner", new Image("coalBurner.png"));
        images.put("mine", new Image("mine.png"));
        images.put("mint", new Image("mint.png"));
        images.put("oilRig", new Image("oilRig.png"));
        images.put("papermill", new Image("papermill.png"));
        images.put("quarry", new Image("quarry.png"));
        images.put("raftFactory", new Image("raftFactory.png"));
        images.put("rowboatFactory", new Image("rowboatFactory.png"));
        images.put("sawmill", new Image("sawmill.png"));
        images.put("steamerFactory", new Image("steamerFactory.png"));
        images.put("stockExchange", new Image("stockExchange.png"));
        images.put("stoneFactory", new Image("stoneFactory.png"));
        images.put("truckFactory", new Image("truckFactory.png"));
        images.put("wagonFactory", new Image("wagonFactory.png"));
        images.put("woodcutter", new Image("woodcutter.png"));
        images.put("bigAdj1", new Image("bigAdj1.png"));
        images.put("bigAdj2", new Image("bigAdj2.png"));
        images.put("bigAdj3", new Image("bigAdj3.png"));
        images.put("bigAdj4", new Image("bigAdj4.png"));
        images.put("bigAdj5", new Image("bigAdj5.png"));
        images.put("bigAdj6", new Image("bigAdj6.png"));
        images.put("bigAngled1", new Image("bigAngled1.png"));
        images.put("bigAngled2", new Image("bigAngled2.png"));
        images.put("bigAngled3", new Image("bigAngled3.png"));
        images.put("bigAngled4", new Image("bigAngled4.png"));
        images.put("bigAngled5", new Image("bigAngled5.png"));
        images.put("bigAngled6", new Image("bigAngled6.png"));
        images.put("bigTri1", new Image("bigTri1.png"));
        images.put("bigTri2", new Image("bigTri2.png"));
        images.put("bigSource1", new Image("bigSource1.png"));
        images.put("bigSource2", new Image("bigSource2.png"));
        images.put("bigSource3", new Image("bigSource3.png"));
        images.put("bigSource4", new Image("bigSource4.png"));
        images.put("bigSource5", new Image("bigSource5.png"));
        images.put("bigSource6", new Image("bigSource6.png"));
        images.put("bigStraight1", new Image("bigStraight1.png"));
        images.put("bigStraight2", new Image("bigStraight2.png"));
        images.put("bigStraight3", new Image("bigStraight3.png"));
        images.put("bigDesert", new Image("bigDesert.png"));
        images.put("bigMountains", new Image("bigMountains.png"));
        images.put("bigPasture", new Image("bigPasture.png"));
        images.put("bigRock", new Image("bigRock.png"));
        images.put("bigSea", new Image("bigSea.png"));
        images.put("bigWoods", new Image("bigWoods.png"));
    }

    public Image getImage(String imageName) {
        return images.get(imageName);
    }

}
