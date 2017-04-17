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
        images.put("bigTri1", new Image("bigTri1.png"));
        images.put("bigPasture", new Image("bigPasture.png"));
    }

    public Image getImage(String imageName) {
        return images.get(imageName);
    }

}
