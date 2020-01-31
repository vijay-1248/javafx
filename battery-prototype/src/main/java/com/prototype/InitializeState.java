package com.prototype;

import java.io.InputStream;
import com.prototype.runner.utils.impl.AcpiRunner;

public abstract class InitializeState {
	
	Runner runner = null;
	
	protected InputStream istream = null;
	

	public void initializer() {
	
		runner = new AcpiRunner();
		istream = runner.execute();
		System.out.println("called");

	}
}
