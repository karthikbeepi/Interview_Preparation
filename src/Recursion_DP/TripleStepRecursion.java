package Recursion_DP;

public class TripleStepRecursion implements Runnable{
	
	int noOfSteps;
	public TripleStepRecursion(int n) {
		noOfSteps = n;
	}
	
	public int tripleStep(int noOfSteps) {
		if(noOfSteps<0)
			return 0;
		if(noOfSteps==0)
			return 1;
		int sum =0;
		for(int i=1; i<noOfSteps+1; i++) {
			sum += tripleStep(noOfSteps-i);
//			System.out.print(i+"\t");
		}
			
		return sum;
	}
	
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		System.out.println("Result from Recursion: "+tripleStep(noOfSteps));
		long endTime = System.currentTimeMillis();
		System.out.println("Total time:"+(endTime-startTime));
	}

}
