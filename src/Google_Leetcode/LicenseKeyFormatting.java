package Google_Leetcode;

public class LicenseKeyFormatting {
	
	public String licenseKeyFormatting(String S, int K) {
//		return formatter(S.toUpperCase().replaceAll("-", ""), K);
		StringBuilder s = new StringBuilder(S.toUpperCase().replaceAll("-", ""));
		s = s.reverse();
		StringBuilder sb = new StringBuilder();
		int i;
		for(i=0; i<s.length()-K; i+=K) {
			sb.append(s.substring(i, i+K)+"-");
		}
		sb.append(s.substring(i));
		return sb.reverse().toString();
    }
	
//	public String formatter(String S, int K) {
//		if(S.length()<=K)
//			return S;
//		return formatter(S.substring(0, S.length()-K), K) +"-"+ S.substring(S.length()-K); 
//        
//	}

	public static void main(String[] args) {

		LicenseKeyFormatting ob = new LicenseKeyFormatting();
		System.out.println(ob.licenseKeyFormatting("5F3Z-2e-9-w", 4));
		System.out.println(ob.licenseKeyFormatting("2-5g-3-J", 2));
		
		
	}

}
