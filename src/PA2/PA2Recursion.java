package PA2;

import java.util.ArrayList;
import java.util.HashMap;

public class PA2Recursion implements Runnable{
	
	HashMap<Integer, Integer> allCosts;
	ArrayList<Payments> validPmts = new ArrayList<Payments>();
	HashMap<Combination, Integer> bestCost;
	Combination combo;
	
	public PA2Recursion(HashMap<Integer, Integer> c, Combination combo) {
		allCosts = c;
		this.combo = combo;
	}

	@Override
	public void run() {
		
		findAllCombo(combo);
		int minCost=Integer.MIN_VALUE;
		for(Payments p: validPmts) {
			int temp = cost(p);
			if(temp<minCost)
				minCost=temp;
			System.out.println(p+" "+temp);
		}
		System.out.println("Lowest cost:"+minCost);
	}

	private int cost(Payments p) {
		int cost = 0;
		for(int i: p.pmt) {
			cost+= allCosts.get(i);
		}
		return cost;
	}

	private void findAllCombo(Combination c) {
		
		
		
		
	}

}
