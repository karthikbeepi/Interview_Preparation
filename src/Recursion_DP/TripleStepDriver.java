package Recursion_DP;

public class TripleStepDriver {

	public static void main(String[] args) {

		int steps = 36;
		Runnable ob1 = new TripleStepRecursion(steps);
		Runnable ob2 = new TripleStepDP(steps);
		
		Thread t1 = new Thread(ob1);
		Thread t2 = new Thread(ob2);
		
		t1.start();
		t2.start();
		
	}

}
