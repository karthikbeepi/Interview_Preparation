package Recursion_DP;

public class RobotGridDriver {

	public static void main(String[] args) {
		
		int[][] grid = new int[][] {
			{1, 0, 0, 0, 0},
			{0, 1, 0, 0, 0},
			{0, 0, 1, 0, 0},
			{0, 0, 0, 1, 0},
			{0, 0, 0, 0, 2}
		};
		Runnable ob1 = new RobotGridRecursion(grid);
		Runnable ob2 = new RobotGridDP(grid);
		
		Thread t1 = new Thread(ob1);
		Thread t2 = new Thread(ob2);
		
		t1.start();
		t2.start();
		
	}

}
