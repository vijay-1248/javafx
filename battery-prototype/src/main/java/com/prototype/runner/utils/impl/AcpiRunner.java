package com.prototype.runner.utils.impl;

import java.io.IOException;
import java.io.InputStream;

import com.prototype.Runner;
import com.prototype.path.utils.impl.ProjectPath;

public class AcpiRunner implements Runner {
	ProjectPath p = null;
	Process process = null;

	public void initializer() {
		p = new ProjectPath();
	}

	@Override
	public InputStream execute() {
		initializer();
		String path = p.getPath() + "/resources/state.sh";
		System.out.println(path);
		String cmd[] = { "sh", path };
		try {
			process = Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return process.getInputStream();
	}

}
