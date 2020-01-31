package com.application.presentation.main;


import java.awt.MouseInfo;
import java.awt.Point;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppStart extends Application{
	private int sceneX = 5;
	private int sceneY = 155;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
		Scene scene = new Scene(root);
		
		scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent me) {
				
				Point p = MouseInfo.getPointerInfo().getLocation();
				primaryStage.setX((p.x)-40);
				primaryStage.setY((p.y)-40);
			}
		});
		scene.setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				primaryStage.setX(sceneX);
				primaryStage.setY(sceneY);
				
			}
		});
		scene.setFill(Color.TRANSPARENT);
	
		primaryStage.setX(sceneX);
		primaryStage.setY(sceneY);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
