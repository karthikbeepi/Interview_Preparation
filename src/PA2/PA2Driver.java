package PA2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PA2Driver {
	
	HashMap<Integer, Integer> cost = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		PA2Driver obj = new PA2Driver();
		obj.getCostIntialized();
		System.out.println(obj.cost.get(5));
		
	}

	private void getCostIntialized() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("/home/beepi/Github/Interview_Preparation/src/PA2/cost.txt"));
			while(br.ready()) {
				String[] temp = br.readLine().split(" ");
				cost.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
