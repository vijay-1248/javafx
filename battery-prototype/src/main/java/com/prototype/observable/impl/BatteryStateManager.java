package com.prototype.observable.impl;

import java.util.Vector;

import com.prototype.Observable;
import com.prototype.Observer;
import com.prototype.stateUpdater.StateUpdater;


public class BatteryStateManager implements Observable {
	private  Vector<Object> observerList = new Vector<>();
	private  String state ;
	private  int percentage;
	
	StateUpdater stateUpdater ;
	
	
	public BatteryStateManager() {
		System.out.println("creare");
		stateUpdater = new StateUpdater(this);
		stateUpdater.startUpdater();
	}

	
	public BatteryStateManager getBatteryStateManagerInstance()
	{
		return this;
	}

	
	public String getSize()
	{
		return ("ObserverList size"+observerList.size());
	}
	@Override
	public void notifyObservers() {
		//System.out.println("notify obeservers are called"+ getSize() );
		
		for(int i = 0 ; i < observerList.size() ; i++ )
		{
			//System.out.println("loop");
			Observer observer = (Observer) observerList.get(i);
			observer.refreshData(this);
		}
		
	}

	@Override
	public void register(Observer observer) {
		System.out.println(observer);
		observerList.add(observer);
		//System.out.println("one observer is created"+observerList.get(0));
	}

	@Override
	public void unregister(Observer observer) {
		
		observerList.removeElement(observer);
	
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	public void get()
	{
		//System.out.println(state+""+percentage);
	}
}
