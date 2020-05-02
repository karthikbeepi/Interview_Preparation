package Google_Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class FoodItems {
	
	int noOfItems;
	HashMap<String, ArrayList<Integer>> products;
	HashMap<String, Integer> avgProductPrice;
	public FoodItems(int n) {
		noOfItems = n;
		products = new HashMap<String, ArrayList<Integer>>();
		avgProductPrice = new HashMap<String, Integer>();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfCases = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<noOfCases; i++) {
			FoodItems obj =  new FoodItems(Integer.parseInt(br.readLine()));
			for(int j=0; j<obj.noOfItems; j++)
			{
				obj.getItems(br.readLine());
			}
			sb.append("Case "+(i+1)+"\n");
			sb.append(obj.printDetails());
		}
		
		System.out.println(sb);

	}

	private String printDetails() {
		
		StringBuilder sb = new StringBuilder();
		ArrayList<String> sortedKeys = new ArrayList<String>();
		sortedKeys.addAll(products.keySet());
		Collections.sort(sortedKeys);
		for(String s: sortedKeys)
		{
			sb.append(s+" ");
			for(int i: products.get(s))
				sb.append(i+" ");
			sb.append(avgProductPrice.get(s)+"\n");
		}
		
		return sb.toString();
		
	}

	private void getItems(String line) {
		String productName = line.split(" ")[0];
		int productVal = Integer.parseInt(line.split(" ")[1]);
		ArrayList<Integer> arrVal;
		
		if(!products.containsKey(productName)) {
			arrVal = new ArrayList<Integer>();
		}
		else
		{
			arrVal = products.get(productName);
		}
		
		arrVal.add(productVal);
		products.put(productName, arrVal);
		
		float avg = (float) 0.0;
		
		for(int i: arrVal) {
			avg+= i;
		}
		
		avg/=arrVal.size();
		
		avgProductPrice.put(productName, (int) Math.round(avg));
		
	}

}
