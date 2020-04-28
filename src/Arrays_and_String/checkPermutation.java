package Arrays_and_String;

import java.util.HashMap;

public class checkPermutation {

	
	public boolean isPermutation(String s1, String s2) {
		
		HashMap<Character, Integer> s1HM = new HashMap<Character, Integer>();
		HashMap<Character, Integer> s2HM = new HashMap<Character, Integer>();
		
		for (char c: s1.toCharArray()) {
			if(s1HM.containsKey(c))
			{
				int val = s1HM.get(c);
				val++;
				s1HM.put(c, val);
			}
			else
				s1HM.put(c, 1);
		}
		for (char c: s2.toCharArray()) {
			if(s2HM.containsKey(c))
			{
				int val = s2HM.get(c);
				val++;
				s2HM.put(c, val);
			}
			else
				s2HM.put(c, 1);
		}
		
		if(s1HM.keySet().size() != s2HM.keySet().size())
			return false;
		
		for(char c: s1HM.keySet()) {
			if (s2HM.containsKey(c)) {
				int v1 = s1HM.get(c);
				if (v1 == s2HM.get(c))
					continue;
				else
					return false;
			}
			else
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {

		checkPermutation obj = new checkPermutation();
		System.out.println(obj.isPermutation("hello", "hlleot"));
	}

}
