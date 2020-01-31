package com.prototype.stateUpdater;

import java.io.InputStream;
import java.util.Scanner;

import com.prototype.Runner;
import com.prototype.observable.impl.BatteryStateManager;
import com.prototype.runner.utils.impl.AcpiRunner;

public class StateUpdater  implements Runnable{
	BatteryStateManager observable ;
	boolean flag = true ;
	InputStream istream ;
	Scanner scanner ;
	Runner runner = null;
	
	
	
	public StateUpdater(BatteryStateManager observable) {
		//System.out.println(Thread.currentThread());
		this.observable = observable;
		runner = new AcpiRunner();
		istream = runner.execute();
		scanner = new Scanner(istream);
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		boolean chargeNotified = false ;
		boolean dischargeNotified = false ;
		while(flag)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String currentState = scanner.nextLine();
			int currentPercentage = scanner.nextInt();
			// get batteryState and setting state . 
			
			if(currentState.equalsIgnoreCase("Charging") )
			{
				if(!chargeNotified)
				{
					chargeNotified = true ;
					dischargeNotified = false ;
					observable.setState(currentState);
					observable.notifyObservers();
					//System.out.println("notified"+currentState);
				}
				
			}
			if(currentState.equalsIgnoreCase("DisCharging") )
			{
				if(!dischargeNotified)
				{
					dischargeNotified = true ;
					chargeNotified = false;
					observable.setState(currentState);
					observable.notifyObservers();
					//System.out.println("notified"+currentState);
				}
				
			}
			
			if(currentPercentage != (observable.getPercentage()))
			{
				observable.setPercentage(currentPercentage);
				observable.notifyObservers();
				//System.out.println("notified"+currentPercentage);
			}
			istream = runner.execute();
			scanner = new Scanner(istream);
		}
		
		
	}
	
	public void startUpdater()
	{
		Thread th = new Thread(this);
		th.start();
	}
	
	
}
