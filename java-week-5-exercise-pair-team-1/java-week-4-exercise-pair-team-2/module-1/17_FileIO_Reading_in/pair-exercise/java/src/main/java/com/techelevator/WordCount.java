package com.techelevator;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		fileChooser();

	}

	private static void fileChooser() {
		int wordCount = 0;
		int sentenceCount = 0;
		File alice = new File("C:\\Users\\Chase Java\\workspace\\java-week-4-exercise-pair-team-2\\module-1\\17_FileIO_Reading_in\\pair-exercise\\java\\alices_adventures_in_wonderland.txt");
		try (Scanner myReader = new Scanner(alice)) {
			while (myReader.hasNext()) {
				String line = myReader.nextLine();
				if (line = != ()) {
					String[] aliceArray = line.trim().split("\\s+");
					wordCount += aliceArray.length;
					if (line.contains(".") || line.contains("!") || line.contains("?")) {
						sentenceCount++;
					}
				}

			}
			//myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Your file does not exist/an error occurred");
			//e.printStackTrace();
		}
		System.out.println(wordCount);
		System.out.println(sentenceCount);

	}
}


