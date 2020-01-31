package com.application.presentation.main;


import com.prototype.observer.impl.SomeXSubject;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class SceneOneController{

	
	@FXML
	public Label statusMode;

	@FXML
	public Label percentage;

	@FXML
	public Rectangle statusTrans;

	@FXML
	public Text text;
	
	
	SomeXSubject s ;
	@FXML
	public void initialize() {
		s = new SomeXSubject(this);
		updateState();
		
	}

	public SceneOneController() {
		//s = new SomeXSubject();
		//transitionStatus();
	}

	
	public void updateState()
	{
		
		
		
	}
	
	
}
