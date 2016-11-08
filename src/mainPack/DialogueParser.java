package mainPack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DialogueParser {

	public static void readDialogue(String fileName) {
		// This will reference one line at a time
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// Reads in lines from file
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file " + fileName + " because it was not found or it does not exist...");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}

	public void ReadSpecificLine(String fileName, int lineNumber) {
		// This will reference one line at a time
		String line = null;
		boolean isDone = false;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			int index = 0;
			// Reads in lines from file
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.isEmpty()) {
					int currentNumber = 1;
					boolean nextLine = false;
					try {
						// Stores the line number into a string
						String num = line.substring(0, 3);

						// Converts line number into a int
						currentNumber = Integer.parseInt(num);
					} catch (NumberFormatException ex) {
						if (index > 0) {
							nextLine = true;
						}
					}
					// Checks if current line number is equal to desired line
					// number
					if (currentNumber == lineNumber || (nextLine == true)) {
						// First 5 characters of the desired line are removed
						line = line.substring(5);

						index++;
						char[] newLine = line.toCharArray();
						for (char a : newLine) {
							if (a == ']') {
								isDone = true;
								index = 0;
								break;
							}
							System.out.print(a);
						}
						if (isDone) {
							break;
						}
					}
				}
			}

			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file " + fileName + " because it was not found or it does not exist...");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}
}
