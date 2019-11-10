package Arrays_and_String;

public class RevString {

	public static void main(String[] args) {

		StringBuilder a = new StringBuilder("jvsebfjfvbs");
		
		for(int i=0; i<a.length()/2; i++)
		{
			char temp = a.charAt(i);
			a.replace(i, i+1, ""+a.charAt(a.length()-i-1));
			a.replace(a.length()-i-1,a.length()-i , ""+temp);
		}
		
		System.out.println(a);
		
	}

}
