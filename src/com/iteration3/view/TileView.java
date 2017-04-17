package com.iteration3.view;

import com.iteration3.utilities.Assets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * Created by LesliesLaptop on 4/16/17.
 */
public class TileView extends StackPane {
    private Assets images;
    private Canvas previewImageCanvas;
    private GraphicsContext gc;

    public TileView() {
        this.setWidth(250);
        this.setHeight(250);
        this.images = new Assets();
        this.previewImageCanvas = new Canvas(this.getWidth(), this.getHeight());
        this.getChildren().add(previewImageCanvas);
        this.gc = previewImageCanvas.getGraphicsContext2D();
    }

    public void drawPreviewImage(String imageURL) {
        Image image = images.getImage(imageURL);
        gc.drawImage(image, 0, 0, image.getWidth(), image.getHeight());
    }
    public void clearPreviewImage() {
        gc.setFill(Color.TRANSPARENT);
        gc.fillRect(0,0,previewImageCanvas.getWidth(),previewImageCanvas.getHeight());
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,previewImageCanvas.getWidth(),previewImageCanvas.getHeight());
        gc.setFill(Color.WHITE);
    }

}
