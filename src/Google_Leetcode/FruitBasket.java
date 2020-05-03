package Google_Leetcode;

import java.util.HashMap;

public class FruitBasket {
	
	HashMap<Integer, Integer> fruitCount = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) {
		
		FruitBasket obj = new FruitBasket();
		int maxNoFruits = obj.getTotalFruit(new int[] {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});

		System.out.println(maxNoFruits);
		
	}

	private int getTotalFruit(int[] trees) {
		
		int maxFruits = Integer.MIN_VALUE;
		
		for(int i=0; i<trees.length; i++) {
			
			if(i!=0 && trees[i-1]==trees[i])
				continue;
		
			HashMap<Integer, Integer> tempFruitCount = new HashMap<Integer, Integer>();
			tempFruitCount.put(trees[i],1); 
			int j = i+1;
			while(j<trees.length) {
				int val=1;
				
				if(tempFruitCount.containsKey(trees[j]))
				{
					val = tempFruitCount.get(trees[j]);
					val++;
					tempFruitCount.put(trees[j], val);
					j++;
				}
				else if(tempFruitCount.keySet().size()<2)
				{
					tempFruitCount.put(trees[j], val);
					j++;
				}
				
				else
					break;
				
			}
			int tempSum=0;
			for(int k: tempFruitCount.values())
				tempSum+=k;
			if(maxFruits<tempSum)
				maxFruits = tempSum;
		}
		
		return maxFruits;
	}

}
