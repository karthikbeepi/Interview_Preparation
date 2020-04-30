package Recursion_DP;

import java.util.HashMap;

public class TripleStepDP implements Runnable{
	
	int noOfSteps;
	HashMap<Integer, Integer> memoization;
	
	public TripleStepDP(int n) {
		noOfSteps = n;
		memoization = new HashMap<Integer, Integer>();
	}
	@Override
	public void run() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long startTime = System.currentTimeMillis();
		for(int i=0; i<noOfSteps; i++)
			memoization.put(i, tripleStep(i));
		System.out.println("Result from DP: "+tripleStep(noOfSteps));
		long endTime = System.currentTimeMillis();
		System.out.println("Total time:"+(endTime-startTime));
		
	}
	
	private int tripleStep(int noOfSteps) {
		if(noOfSteps<0)
			return 0;
		if(noOfSteps==0)
			return 1;
		int totalCombo = 0;
		if(noOfSteps-1>=0)
			totalCombo+= memoization.get(noOfSteps-1);
		if(noOfSteps-2>=0)
			totalCombo+= memoization.get(noOfSteps-2);
		if(noOfSteps-3>=0)
			totalCombo+= memoization.get(noOfSteps-3);
		return totalCombo;
		
	}

	
	
}
