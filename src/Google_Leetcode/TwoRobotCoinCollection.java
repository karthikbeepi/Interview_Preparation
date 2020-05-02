package Google_Leetcode;

import java.util.HashMap;

class Point{
	int x, y;
	
	
	public Point(int i, int j) {
		x = i;
		y = j;
	}
	
	public boolean equals(Point a) {
		
		if(a.x == this.x && a.y == this.y)
			return true;
		else
			return false;
		
	}
}

class Robot{
	HashMap<Point, Boolean> hasPath = new HashMap<Point, Boolean>();
	Point endPoint;
	Point curPoint;
	int coinCollected;
	public Robot(Point endPoint, Point startPoint) {
		this.endPoint = endPoint;
		curPoint = startPoint;
		coinCollected = 0;
	}
	public boolean canMove(int[][] grid) {
		if (endPoint.equals(curPoint))
			return false;
		if(hasPath(curPoint, grid))
			return true;
		return false;
	}
	private boolean hasPath(Point p, int[][] grid) {
		if(p==null)
			return false;
		if(endPoint.equals(p))
			return true;
		if(hasPath.containsKey(p))
		{
			if(hasPath.get(p))
				return true;
			else
				return false;
		}
		Point downPoint, downLeftPoint, downRightPoint;
		downPoint = (p.x+1 < grid.length) ? new Point(p.x+1,p.y): null;
		downLeftPoint = ((p.x+1 < grid.length) && (p.y-1 >=0)) ? new Point(p.x+1, p.y-1): null;
		downRightPoint = ((p.x+1 < grid.length) && (p.y+1 <grid[0].length)) ? new Point(p.x+1, p.y+1): null;
		if(hasPath(downPoint, grid)|| hasPath(downLeftPoint, grid)|| hasPath(downRightPoint, grid))
			return true;
		
		return false;
	}
	
	
	public void move(int[][] grid) {
		
		
		
		
	}

}

public class TwoRobotCoinCollection {

	int[][] grid;
	
	public static void main(String[] args) {
		
		TwoRobotCoinCollection obj = new TwoRobotCoinCollection();
		obj.grid = new int[][] {
			{0, 1, 0},
			{0, 0, 1},
			{0, 1, 0}
		};

		System.out.println(obj.maxCoinCollected());
	}

	private int maxCoinCollected() {
		
		Robot r1 = new Robot(new Point(grid.length-1, 0), new Point(0, 0));
		Robot r2 = new Robot(new Point(grid.length-1, grid[0].length-1), new Point(grid.length-1, 0));
		
		while(r1.canMove(grid) || r2.canMove(grid)) {
			r1.move(grid);
			r2.move(grid);
		}
		
		return r1.coinCollected+r2.coinCollected;
	}

}
