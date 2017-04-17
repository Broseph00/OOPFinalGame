package tests;

import com.iteration3.view.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;


public class ViewTests extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		TabPane tabPane = new TabPane();
		
		Tab statusViewTab = new Tab();
		statusViewTab.setText("MainView");
		statusViewTab.setContent(new MainView(500,500));
		
		
		Tab mapViewTab = new Tab();
		mapViewTab.setText("MapView");
		mapViewTab.setContent(new MapView(500,500));
		
		Tab productionViewTab = new Tab();
		productionViewTab.setText("ProductionView");
		productionViewTab.setContent(new ProductionView(500,500));
		
		Tab movementViewTab = new Tab();
		movementViewTab.setText("Movement View");
		movementViewTab.setContent(new MovementView(500,500));
		
		Tab buildingViewTab = new Tab();
		buildingViewTab.setText("Building View");
		buildingViewTab.setContent(new BuildingView(500,500));
		
		tabPane.getTabs().add(statusViewTab);
		tabPane.getTabs().add(mapViewTab);
		tabPane.getTabs().add(productionViewTab);
		tabPane.getTabs().add(movementViewTab);
		tabPane.getTabs().add(buildingViewTab);
		
		Scene scene = new Scene(tabPane,500,500);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("View Tests");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
