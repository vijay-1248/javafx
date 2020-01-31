package com.application.presentation.main;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MainSceneController {

	@FXML
	private Pane pane;

	@FXML
	private Rectangle status;

	@FXML
	private Rectangle statusTrans;
	
	@FXML
	private Label statusMode;
	
	@FXML
    private Label percentage;
	
	private static boolean visible = false;

	@FXML
	public void initialize() {
		DropShadow dropShadow = new DropShadow();
		dropShadow.setBlurType(BlurType.GAUSSIAN);
		dropShadow.setColor(Color.BLUE);
		// rootCircle.setEffect(dropShadow);
		// backgroundCircle.setVisible(false);

		transitionStatus();
	}

	@FXML
	void circleOneOnClick(MouseEvent event) {
		if (visible) {
			visible = false;
		} else {
			visible = true;
		}
		// circleTwoHbox.setVisible(false);
		// circleOneHbox.setVisible(visible);
	}

	@FXML
	void circleTwoOnClick(MouseEvent event) {
		if (visible) {
			visible = false;
		} else {
			visible = true;
		}
		// circleOneHbox.setVisible(false);
		// circleTwoHbox.setVisible(visible);
	}

	@FXML
	void circleThreeOnClick(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	void hboxOnClick(MouseEvent event) {
		System.out.println("hbox called");
	}

	@FXML
	void circleTwoHboxOnClick(MouseEvent event) {

	}

	@FXML
	void rootMouseEntered() {

	}

	/*
	 * @FXML void rootCircleOnClick(MouseEvent event) { circleTransition(circleOne,
	 * -40, 44, 0, -10); circleTransition(circleTwo, -50, 0, 18, 0);
	 * circleTransition(circleThree, -40, -40, 10, 10); }
	 */

	public void circleTransition(Circle circle, int mX, int mY, int lX, int lY) {
		Path path = new Path();
		path.getElements().add(new MoveTo(mX, mY));
		path.getElements().add(new LineTo(lX, lY));
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(1000));
		circle.setOpacity(1);
		pathTransition.setNode(circle);

		pathTransition.setPath(path);
		pathTransition.play();

	}

	/*
	 * public void circleBgTransition() { backgroundCircle.setVisible(true);
	 * System.out.println("entered"); FadeTransition fade = new FadeTransition();
	 * fade.setFromValue(3); fade.setToValue(0);
	 * fade.setDuration(Duration.millis(6000)); ScaleTransition scaleTransition =
	 * new ScaleTransition(); scaleTransition.setFromX(1);
	 * scaleTransition.setFromY(1); scaleTransition.setToX(3);
	 * scaleTransition.setToY(3);
	 * scaleTransition.setDuration(Duration.millis(6000)); ParallelTransition pt =
	 * new ParallelTransition(); pt.setNode(backgroundCircle);
	 * pt.setAutoReverse(false); pt.getChildren().addAll(fade, scaleTransition);
	 * pt.setOnFinished(e -> { backgroundCircle.setVisible(false); }); pt.play();
	 * 
	 * }
	 */

	public void transitionStatus() {
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.setAutoReverse(true);
		KeyValue kv = new KeyValue(statusTrans.heightProperty(), 0);
		KeyFrame kf = new KeyFrame(Duration.millis(5000), kv);
		timeline.getKeyFrames().add(kf);
		timeline.play();
	}
}
