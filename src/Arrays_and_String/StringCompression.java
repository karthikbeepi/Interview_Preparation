package Arrays_and_String;

public class StringCompression {

	public static void main(String[] args) {

		StringCompression obj = new StringCompression();
		System.out.println(obj.compress("aaabbbcctafffadecccccaaa"));
		
	}

	private String compress(String string) {
		
		StringBuilder sb = new StringBuilder();
		
		int i=0;
		int start = 0;
		int end = 0;
		while(i<string.length()-1) {
			if ( string.charAt(i) != string.charAt(i+1))
			{
				end = i+1;
				int count = countFromTo(start, end, string);
				sb.append(string.charAt(i)+""+count);
				start = i+1;
			}
			i++;
		}
		int count = countFromTo(start, string.length(), string);
		sb.append(string.charAt(i)+""+count);
		return sb.toString();
	}

	private int countFromTo(int start, int end, String string) {
		return string.substring(start, end).length();
	}

}
