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
        gc.setFill(Color.WHITE);
    }

    public void drawResource(String url, int region) {

        if(region == 1) {
            Image image = images.getImage(url);
            gc.drawImage(image, 145,25);
        }
        else if(region == 2) {
            Image image = images.getImage(url);
            gc.drawImage(image, 195,90);
        }
        else if(region == 3) {
            Image image = images.getImage(url);
            gc.drawImage(image, 145,205);
        }
        else if(region == 4) {
            Image image = images.getImage(url);
            gc.drawImage(image, 75,205);
        }
        else if(region == 5) {
            Image image = images.getImage(url);
            gc.drawImage(image, 20,90);
        }
        else if(region == 6) {
            Image image = images.getImage(url);
            gc.drawImage(image, 75,25);
        }
    }

    public void drawTransport(String url, int region) {

        if(region == 1) {
            Image image = images.getImage(url);
            gc.drawImage(image, 145,60);
        }
        else if(region == 2) {
            Image image = images.getImage(url);
            gc.drawImage(image, 210,125);
        }
        else if(region == 3) {
            Image image = images.getImage(url);
            gc.drawImage(image, 145,165);
        }
        else if(region == 4) {
            Image image = images.getImage(url);
            gc.drawImage(image, 75,170);
        }
        else if(region == 5) {
            Image image = images.getImage(url);
            gc.drawImage(image, 40,95);
        }
        else if(region == 6) {
            Image image = images.getImage(url);
            gc.drawImage(image, 75,65);
        }
    }

    public void drawProducer(String url, int region) {

        if(region == 1) {
            Image image = images.getImage(url);
            gc.drawImage(image, 145,80);
        }
        else if(region == 2) {
            Image image = images.getImage(url);
            gc.drawImage(image, 170,115);
        }
        else if(region == 3) {
            Image image = images.getImage(url);
            gc.drawImage(image, 165,165);
        }
        else if(region == 4) {
            Image image = images.getImage(url);
            gc.drawImage(image, 85,140);
        }
        else if(region == 5) {
            Image image = images.getImage(url);
            gc.drawImage(image, 55,105);
        }
        else if(region == 6) {
            Image image = images.getImage(url);
            gc.drawImage(image, 40,35);
        }
    }


}
