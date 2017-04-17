package com.iteration3.view;

import com.iteration3.utilities.Assets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

/**
 * Created by LesliesLaptop on 4/16/17.
 */
public class TileView extends StackPane {
    private Assets images;
    private Canvas previewImageCanvas;
    private GraphicsContext gc;

    public TileView() {
        this.images = new Assets();
        this.previewImageCanvas = new Canvas();
        this.gc = previewImageCanvas.getGraphicsContext2D();
    }

    public void drawPreviewImage(String imageURL) {
        Image image = images.getImage(imageURL);
        gc.drawImage(image, 0, 0, 250, 250);
    }

}
