package com.prototype.writer.utils.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import com.prototype.InitializeState;
import com.prototype.Path;
import com.prototype.Runner;
import com.prototype.Writer;
import com.prototype.path.utils.impl.ProjectPath;
import com.prototype.runner.utils.impl.AcpiRunner;

public class FileWriter extends InitializeState implements Writer {
	OutputStream oStream = null;
	Path path = null;
	InputStream istream =  null ;
	public void initializer() {
		super.initializer();
		istream = super.istream;
		path = new ProjectPath();
		try {
			oStream = new FileOutputStream(new File(path.getPath() + "/resources/state.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void fileWriter() {
		initializer();
		int charVal = 0;
		String info = "";
		try {
			while ((charVal = istream.read()) != -1) {
				oStream.write((char) charVal);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		FileWriter fw = new FileWriter();
		fw.fileWriter();
	}
}
