package Arrays_and_String;

public class URLify {

	public String makeURL(String s) {
		s = s.replaceAll(" ", "%20");
		return s;
	}
	
	public static void main(String[] args) {

		URLify obj = new URLify();
		System.out.println(obj.makeURL("hi hello hmm"));
		
	}

}
