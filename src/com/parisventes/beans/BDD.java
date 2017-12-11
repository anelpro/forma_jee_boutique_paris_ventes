package com.parisventes.beans;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List; // java util = bibliothèque de java utilitaire -> List

public class BDD {
	private String fileName;
	private List<String> allLines;
	
	
	public BDD(){
	}
	
	
	public BDD(String filename) {
		this.fileName = filename;
	}
	
	public List<String> readFile() {
		try {
			allLines = Files.readAllLines(Paths.get(this.fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allLines;
	}


	public void splitline() {
		for (String line : allLines) {
			String[] arr = line.split("\\|");
		}
	}
	
}
