package Google_Leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class PizzaProblem {

	ArrayList<Integer> pizza;
	ArrayList<Integer> topping;
	ArrayList<Integer> diffTopping;
	int coins;
	
	
	public static void main(String[] args) {
	
		PizzaProblem obj = new PizzaProblem();
		
		obj.pizza = new ArrayList<Integer>();
		obj.pizza.add(800);
		obj.pizza.add(850);
		obj.pizza.add(900);
		
		obj.topping = new ArrayList<Integer>();
		obj.topping.add(200);
		obj.topping.add(250);
		
		obj.coins = 1000;
		
		System.out.println(obj.getBestPizza());
		
	}


	private int getBestPizza() {
		
		// Finds all the different combinations of topping and sorts them on the basis of the price
		findAllToppings();
		
		Collections.sort(pizza);
		
		int low = 0;
		int high = pizza.size()-1;
		int closestPizza = -1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(pizza.get(mid)==coins)
				return coins;
			else {
				closestPizza = pizza.get(mid);
				if(closestPizza-coins<0)
				{
					low = mid+1;
					continue;
				}
				else
				{
					high = mid-1;
					continue;
				}		
			}
		}
		
		low = 0;
		high = diffTopping.size()-1;
		int closestTopping = Math.abs(closestPizza+diffTopping.get(0));
		for(int i=1; i<=high; i++)
			if(Math.abs(closestPizza+diffTopping.get(i)-coins)<Math.abs(closestTopping-coins))
			{
				closestTopping = closestPizza+diffTopping.get(i);
			}
		
		return closestTopping;
	}


	private void findAllToppings() {
		
		diffTopping = new ArrayList<Integer>();
		diffTopping.add(0);
		for(int i: topping)
			diffTopping.add(i);
		for(int i: topping)
			for(int j: topping)
				if(i!=j)
					diffTopping.add(i+j);
	}

}
