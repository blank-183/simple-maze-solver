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
		
		if(maze.matrix[maze.start.y][maze.start.x] != PATH) {
			System.out.println("The starting path cannot be a wall!");
			System.exit(1);
		}
		
		maze.path.push(maze.start);
		
		// find the exit
		if(solveMaze()) {
			System.out.println("The path is: ");

	        for (int i = maze.path.size() - 1; i >= 0; i--) {
	        	if(i != 0) {
	        		System.out.print(maze.path.get(i).move + " > ");
	        	} else {
	        		System.out.println(maze.path.get(i).move);
	        	}   
	        }
		} else {
			System.out.println("Sorry! There is no path.");
		}
	}
	
	public static boolean solveMaze() {
		if(maze.matrix[maze.path.peek().y][maze.path.peek().x] == DESTINATION) {
			return true;
		}

		while(true) {
			int y = maze.path.peek().y;
			int x = maze.path.peek().x;
			
			maze.matrix[y][x] = 0;
			
			// move up
			if(moveUp(y, x)) {
				if(maze.matrix[maze.path.peek().y][maze.path.peek().x] == DESTINATION) {
					return true;
				} 
			} else if(moveDown(y, x)) {
				if(maze.matrix[maze.path.peek().y][maze.path.peek().x] == DESTINATION) {
					return true;
				} 
			} else if(moveLeft(y, x)) {
				if(maze.matrix[maze.path.peek().y][maze.path.peek().x] == DESTINATION) {
					return true;
				} 
			} else if(moveRight(y, x)) {
				if(maze.matrix[maze.path.peek().y][maze.path.peek().x] == DESTINATION) {
					return true;
				} 
			} else { 
				maze.path.pop();
			}
			
			if(maze.path.isEmpty()) {
				return false;
			}
		}
	}
	
	public static boolean moveUp(int y, int x) {
		// wait lang
		int newY = y - 1;
		
		if(isPath(newY, x)) {
			maze.path.push(new Point(newY, x, "up"));
			return true;
		} 
		
		return false;
	}
	
	public static boolean moveDown(int y, int x) {
		int newY = y + 1;
		
		if(isPath(newY, x)) {
			maze.path.push(new Point(newY, x, "down"));
			return true;
		} 
		
		return false;
	}
	
	public static boolean moveLeft(int y, int x) {
		int newX = x - 1;
		
		if(isPath(y, newX)) {
			maze.path.push(new Point(y, newX, "left"));
			return true;
		} 
		
		return false;
	}
	
	public static boolean moveRight(int y, int x) {
		int newX = x + 1;
		
		if(isPath(y, newX)) {
			maze.path.push(new Point(y, newX, "right"));
			return true;
		} 
		
		return false;
	}
	
	public static boolean isPath(int y, int x) {
		if(isValid(y, x)) {
			return (maze.matrix[y][x] == PATH || maze.matrix[y][x] == DESTINATION);
		}
		
		return false;
	}
	
	public static boolean isValid(int y, int x) {
		return !(y < 0 || y >= maze.rowSize || x < 0 || x >= maze.colSize);
	}
}
