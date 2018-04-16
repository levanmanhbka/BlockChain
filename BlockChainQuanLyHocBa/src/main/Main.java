package main;

import common.FileManager;

public class Main {
	public static void main(String[] args) {
		FileManager fileManager = new FileManager();
		fileManager.WriteStringToFile("Hello", "", "demo.txt");
	}
}
