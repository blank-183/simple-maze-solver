package mazesolver;

import java.util.LinkedList;

/**
 * 
 * @author iveej
 *
 */

public class MazeSolver {
	
	static Maze maze = new Maze("maze.txt");
	static final int WALL = 0;
	static final int PATH = 1;
	static final int DESTINATION = 2;

	public static void main(String[] args) {

		maze.path = new LinkedList<Point>();
		
		// find the exit
		if(solveMaze()) {
			System.out.println("Congratulations. You won!");
		} else {
			System.out.println("Sorry! There is no path.");
		}
	}
	
	public static boolean solveMaze() {
		
		if(maze.matrix[maze.start.y][maze.start.x] != PATH) {
			System.out.println("The starting path cannot be a wall!");
			System.exit(1);
		}
		
		if(maze.matrix[maze.start.y][maze.start.x] == DESTINATION) {
			return true;
		}
		
		
		maze.path.push(maze.start);
		
		while(true) {
			moveUp(maze.start);
			break;
		}
		
		return false;
	}
	
	public static void moveUp(Point p) {
		System.out.println("Up");
	}
	
	public static void moveDown(Point p) {
   // TODO document why this method is empty
 }
	
	public static void moveLeft(Point p) {
   // TODO document why this method is empty
 }
	
	public static void moveRight(Point p) {
   // TODO document why this method is empty
 }
	
	public static boolean isPath(int y, int x) {
		
		return (y >= 0 || x >= 0) ||(y < maze.rowSize || x < maze.colSize) && 
				(maze.matrix[y][x] == 1 || maze.matrix[y][x] == 2);
		
	}
}
