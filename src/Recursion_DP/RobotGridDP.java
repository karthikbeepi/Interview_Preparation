package Recursion_DP;

import java.util.HashMap;
import java.util.Stack;

public class RobotGridDP implements Runnable {
	
	int [][] grid;
	HashMap<Integer, Boolean> isPath;

	public RobotGridDP(int[][] grid) {
		this.grid = grid;
		isPath = new HashMap<Integer, Boolean>();
	}

	public boolean pathExists(int i, int j, Stack<Integer> path) {
		if(i>=grid.length||j>=grid.length||i<0||j<0)
			return false;
		if(grid[i][j]==2) {
			path.push(i*10+j);
			isPath.put(i*10+j, true);
			return true;
		}
		if(grid[i][j]==0)
			return false;
		
		boolean right, down, diag;
		if (isPath.containsKey(i*10+(j+1)))
			right = isPath.get(i*10+(j+1));
		else
			right = pathExists(i, j+1, path);
		if (isPath.containsKey( (i+1)*10+j) )
			down = isPath.get((i+1)*10+j);
		else
			down = pathExists(i+1, j, path);
		if(isPath.containsKey((i+1)*10+(j+1)))
			diag = isPath.get((i+1)*10+(j+1));
		else
			diag = pathExists(i+1, j+1, path);
		
		if(right || down || diag)
		{
			path.push(i*10+j);
			isPath.put(i*10+j, true);
			return true;
		}
		else
			return false;
			
	}

	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long startTime = System.currentTimeMillis();
		Stack<Integer> path = new Stack<Integer>();
		System.out.println("Exists path (DP):"+pathExists(0, 0, path));
		System.out.print("Path");
		while(!path.isEmpty())
			System.out.print(path.pop()+"->");
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Total time:"+(endTime-startTime));
		
	}
}
