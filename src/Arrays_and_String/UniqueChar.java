package Arrays_and_String;

import java.util.HashMap;

public class UniqueChar {

	public static void main(String[] args) {

		boolean flag = true;
		String a = "avkb";
		
		HashMap<Character, Integer> charCount = new HashMap<>();
		for (char c: a.toCharArray()) {
			if(charCount.containsKey(c)) {
				System.out.println("No");
				flag = false;
				break;
			}
			else
				charCount.put(c, 1);
		}
		
		if(flag)
			System.out.println("Yes");
		
		
	}

}
