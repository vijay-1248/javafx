package com.prototype.observer.impl;

import com.application.presentation.main.SceneOneController;
import com.prototype.Observable;
import com.prototype.Observer;
import com.prototype.observable.impl.BatteryStateManager;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.util.Duration;




public class SomeXSubject implements Observer{
	
	int per ;
	String status ;
	SceneOneController soc ;
	public SomeXSubject(SceneOneController soc)
	{
		this.soc = soc ;
		this.registerEntry();
	}
	
	
	public int getPer() {
		return per;
	}

	public void setPer(int per) {
		this.per = per;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public void refreshData(Observable subject) {
		BatteryStateManager bsm = (BatteryStateManager) subject;
		
		setPer(bsm.getPercentage());
		setStatus(bsm.getState());
		System.out.println("from secene one "+this.status);
		System.out.println("from secene one "+this.per);
		setData();
	}

	public void registerEntry()
	{
		BatteryStateManager bsm = new BatteryStateManager();
		bsm.register(this);
	}
	
	public void setData()
	{
		Platform.runLater(()->{
			soc.percentage.setText(getPer()+"%");
			soc.statusMode.setText(getStatus());
			
			if((getStatus()).equalsIgnoreCase("charging"))
			{
				System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
				transitionStatus().play();
			}
			if((getStatus()).equalsIgnoreCase("discharging"))
			{
				System.out.println("__------------------------------__________________-------------------------------");
				soc.statusTrans.setHeight(82-(((double)getPer()/100)*82.0));
				System.out.println((((double)getPer()/100)*82.0));
			
			}
		});
		
	}
	public Timeline transitionStatus() {
		Timeline timeline = new Timeline();
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.setAutoReverse(true);
		KeyValue kv = new KeyValue(soc.statusTrans.heightProperty(), 0);
		KeyFrame kf = new KeyFrame(Duration.millis(5000), kv);
		timeline.getKeyFrames().add(kf);
		return timeline;
	}

	
}
