package com.application.presentation.main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainSceneController {
	private Stage primaryStage = new Stage();
	@FXML
	private Button statusViewer;

	@FXML
	private Button satatisticsViewer;
	
	@FXML
	private Button close;

	@FXML
	private void initialize() {
		primaryStage.initStyle(StageStyle.TRANSPARENT);
	}

	@FXML
	void onClick(MouseEvent event) {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SceneOne.fxml"));
		loader(fxmlLoader);

	}

	@FXML
	void StatisticsViewerOnClick(MouseEvent event) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SceneTwo.fxml"));
		loader(fxmlLoader);
	}

	@FXML
	void closeOnClick(MouseEvent event) {
		Runtime rt = Runtime.getRuntime();
		rt.exit(0);
		System.exit(0);
	}

	public void loader(FXMLLoader fxmlLoader) {
		try {
			//System.out.println("called");
			Parent root = (Parent) fxmlLoader.load();
			primaryStage.setScene(new Scene(root));
			primaryStage.show();

		} catch (IOException e) {
			System.out.println("scene already running...........");
		}

	}

}
