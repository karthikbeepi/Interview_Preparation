package Arrays_and_String;

public class DupCharsInString {

	public static void main(String[] args) {

		String a = "ehloo";
		StringBuilder b = new StringBuilder();
		boolean flag;
		b.append(a.charAt(0));
		for(int i=1; i<a.length(); i++)
		{
			flag = true;
			char c = a.charAt(i);
			for(int j=0; j<i; j++)
			{
				if(c == a.charAt(j))
				{
					flag = false;
					break;
				}
			}
			if(flag)
				b.append(c);
		}
		System.out.println(b);
		
	}

}
