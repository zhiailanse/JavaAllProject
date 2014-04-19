package com.zmm.java.stream;

import java.io.File;
import java.io.FilenameFilter;

public class ExtensionFiler implements FilenameFilter {
	
	private String extension;
	
	public ExtensionFiler(String ext) {
		this.extension = "."+ext;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extension);
	}

}
