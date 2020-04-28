package Arrays_and_String;

public class OneEditAway {

	public static void main(String[] args) {

		OneEditAway obj = new OneEditAway();
		System.out.println(obj.check("pale", "bake"));
		
	}

	private boolean check(String s1, String s2) {
		
		if (s1.length()<s2.length()) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}
		
		int noOfEdit = 0;
		int j=0;
		for ( int i=0; i<s1.length(); i++) {
			if (s1.charAt(i)==s2.charAt(j)) {
				if(j<s2.length()-1)
					j++;
			}
			else {
				if (noOfEdit == 1)
					return false;
				else {
					if(i<s1.length()-2 && j<s2.length()-2 && s1.charAt(i+1)==s2.charAt(j+1))
						j++;
					noOfEdit++;
				}
			}
		}
		
		if(noOfEdit <= 1)
			return true;
		
		return false;
	}

}
