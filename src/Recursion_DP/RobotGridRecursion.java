package Recursion_DP;

import java.util.Stack;

public class RobotGridRecursion implements Runnable{

	int[][] grid;
	
	public RobotGridRecursion(int[][] grid) {
		this.grid = grid;
	}
	
	public boolean pathExists(int i, int j, Stack<Integer> path) {
		if(i>=grid.length||j>=grid.length||i<0||j<0)
			return false;
		if(grid[i][j]==2) {
			path.push(i*10+j);
			return true;
		}
		if(grid[i][j]==0)
			return false;
		if( pathExists(i, j+1, path) || pathExists(i+1, j, path) || pathExists(i+1, j+1, path))
		{
			path.push(i*10+j);
			return true;
		}
		else
			return false;
			
	}

	@Override
	public void run() {

		long startTime = System.currentTimeMillis();
		Stack<Integer> path = new Stack<Integer>();
		System.out.println("Exists path (Recursion):"+pathExists(0, 0, path));
		System.out.print("Path");
		while(!path.isEmpty())
			System.out.print(path.pop()+"->");
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Total time:"+(endTime-startTime));
		
	}

}
