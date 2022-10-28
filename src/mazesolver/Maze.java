package mazesolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Maze {
	int[][] matrix;
	int colSize;
	int rowSize;
	Point start;
	LinkedList<Point> path;
	
	Maze(String file) {
		readFile(file);
	}
	
	private void readFile(String file) {
		File tf = new File(file);
		Scanner sc = null;
		
		int lineCount = 0;
		
		// checks if file exists
		try {
			sc = new Scanner(tf);
		} catch (FileNotFoundException e) {
			System.out.println("The file " + tf.toString() + " is not available.");
			System.exit(1);
		}
		
		String[] sizeStr = sc.nextLine().split(" ");
		
		// checks if the size is correct
		if(sizeStr.length == 2) {
			colSize = Integer.parseInt(sizeStr[0]);
			rowSize = Integer.parseInt(sizeStr[1]);
			
		} else {
			System.out.println("The maze size provided in the text file is incorrect!");
			sc.close();
			System.exit(1);
		}
		
		matrix = new int[rowSize][colSize];
		
		String[] startStr = sc.nextLine().split(" ");
		
		// checks if the size is correct
		if(startStr.length == 2) {
			 start = new Point(Integer.parseInt(startStr[0]), Integer.parseInt(startStr[1]), "start");
		} else {
			System.out.println("The maze size provided in the text file is incorrect!");
			sc.close();
			System.exit(1);
		}
		
		while(sc.hasNextLine()) {
			if(lineCount > rowSize) {
				System.out.println("The line count does not match the given row size.");
				sc.close();
				System.exit(1);
			}
			String[] rowStr = sc.nextLine().split(" ");
			if(rowStr.length != colSize) {
				System.out.println("The column size of the current row does not match the given column size.");
				sc.close();
				System.exit(1);
			}
			
			for(int i = 0; i < colSize; i++) {
				matrix[lineCount][i] = Integer.parseInt(rowStr[i]);
			}
			
			lineCount++;
		}
		
		if (lineCount != rowSize) {
			System.out.println("Hello");
			System.out.println("The line count does not match the given row size.");
			sc.close();
			System.exit(1);
		}
		
		sc.close();
	}
}
