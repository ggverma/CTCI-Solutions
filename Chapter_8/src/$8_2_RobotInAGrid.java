import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class RIAGHelper{
	HashMap<Point, Boolean> cache;
	
	public ArrayList<Point> getPath(boolean maze[][]){
		if(maze == null || maze.length == 0) return null;
		
		ArrayList<Point> path = new ArrayList<>();
		cache = new HashMap<>();
		if(getPath(maze, maze.length - 1, maze[0].length - 1, path)) return path;
		return null;
	}
	
	private boolean getPath(boolean maze[][], int row, int col, ArrayList<Point> path){
		if(col < 0 || row < 0 || !maze[row][col]) return false;
		
		Point point = new Point(row, col);
		
		if(cache.containsKey(point)) return cache.get(point);
		
		boolean isAtOrigin = (row == 0) && (col == 0), success = false;
		
		if(isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)){
			path.add(point);
			success = true;
		}
		
		cache.put(point, true);
		return success;
	}
}

public class $8_2_RobotInAGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean maze[][] = new boolean[10][10];
		
		for(boolean[] i : maze)
		Arrays.fill(i, true);
		
		Random generator = new Random();
		
		for(int i = 0 ; i < (int)(generator.nextInt(500)) ; i++){
			maze[generator.nextInt(10)][generator.nextInt(10)] = false;
		}
		
		System.out.print("The path in maze: ");
		ArrayList<Point> path = new RIAGHelper().getPath(maze);
		if(path != null){
			System.out.println("Source->");
			for(Point p : path)
				System.out.print("(" + (int)p.getX() + ", " + (int)p.getY() + ")-> ");
			System.out.println("Destination");
		}else{
			System.out.println("Does Not Exist!");
		}
	}

}
