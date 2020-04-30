package PA2;

import java.util.ArrayList;
import java.util.HashMap;

public class PA2Recursion implements Runnable{
	
	HashMap<Integer, Integer> allCosts;
	HashMap<Combination, ArrayList<Payments>> allCombo; 
	HashMap<Combination, Integer> bestCost;
	Combination combo;
	
	public PA2Recursion(HashMap<Integer, Integer> c, Combination combo) {
		allCosts = c;
		this.combo = combo;
		ArrayList<Payments> pmt = new ArrayList<Payments>();
		allCombo = new HashMap<Combination, ArrayList<Payments>>();
		allCombo.put(combo, pmt);
	}

	@Override
	public void run() {
		
		findAllCombo(combo);
		int minCost=Integer.MIN_VALUE;
		for(Combination c: allCombo.keySet()) {
			for(Payments p: allCombo.get(c)) {
				int temp = cost(p);
				if(temp<minCost)
					minCost=temp;
				System.out.println(p+" "+temp);
			}
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
