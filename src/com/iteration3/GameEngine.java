package com.iteration3;

import com.iteration3.controller.ControlDispatch;
import com.iteration3.model.GameModel;
import com.iteration3.model.ModelViewAdapter;
import com.iteration3.view.GameWindow;
import com.iteration3.view.MainView;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameEngine {
    private int frameCounter = 0;
    private GameWindow gameWindow;
    private GameModel gameModel;
    private ModelViewAdapter MVA;

    public GameEngine (Stage primaryStage, GameModel gameModel, GameWindow gameWindow) throws Exception {
        this.gameWindow = gameWindow;
        this.gameModel = gameModel;
        MVA = new ModelViewAdapter(gameModel, gameWindow);
        //ControlDispatch controller = new ControlDispatch(gameModel, gameWindow);


        new AnimationTimer() {
            @Override
            public void handle(long currentPulse) {
                frameCounter++;
                if (frameCounter == 2) { //30 FPS
                    frameCounter = 0;
                    //TODO ADD CONTROLLER UPDATES AND VIEW RENDER UPDATES
                    gameWindow.update();
                    MVA.update();
                }

            }
        }.start();

        //TODO: Make size equal to screen resolution
        Scene scene = new Scene(this.gameWindow, 1221, 726);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Roads & Boats");
        primaryStage.show();
    }
}
