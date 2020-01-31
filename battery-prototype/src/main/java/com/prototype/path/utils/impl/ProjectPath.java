package com.prototype.path.utils.impl;

import com.prototype.Path;

public class ProjectPath implements Path {

	@Override
	public String getPath() {
		String path = System.getProperty("user.dir");
		return path;
	}
	
}
