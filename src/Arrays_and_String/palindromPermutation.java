package Arrays_and_String;

import java.util.ArrayList;
import java.util.HashMap;

public class palindromPermutation {

	public boolean check(String s) {
	
		HashMap<Character, Integer> sHM = new HashMap<Character, Integer>();
		for (char c: s.toLowerCase().toCharArray()) {
			if(c == ' ')
				continue;
			if(sHM.containsKey(c)) {
				int val = sHM.get(c);
				val++;
				sHM.put(c, val);
			} else {
				sHM.put(c, 1);
			}
		}
		
		int oddCharacterCount = 0; 
		for (Character c: sHM.keySet()) {
			if ( sHM.get(c) % 2 != 0) 
				oddCharacterCount++;
		}
		if (oddCharacterCount>1)
			return false;
		
		return true;
		
		
	}
	public static void main(String[] args) {
		palindromPermutation obj = new palindromPermutation();
		System.out.println(obj.check("atco cta"));
		
	}

}
