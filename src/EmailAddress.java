import java.util.ArrayList;

public class EmailAddress {

	ArrayList<String> validEmails = new ArrayList<String>();
	
	public int numUniqueEmails(String[] emails) {
        
		for(String s: emails) {
			String add = getValidEmail(s);
			if(!validEmails.contains(add))
				validEmails.add(add);
		}
		return validEmails.size();
    }
	
	private String getValidEmail(String s) {
		String localName = getLocalName(s);
		String domainName = getDomainName(s);
		return localName+domainName;
	}

	private String getDomainName(String s) {
		
		int firstAtTheRate = s.indexOf('@');
		return s.substring(firstAtTheRate);
	}

	private String getLocalName(String s) {
		
		int firstAtTheRate = s.indexOf('@');
		String localName = s.substring(0, firstAtTheRate-1);
		localName = localName.replaceAll("\\.","");
		int firstPlus = (localName.indexOf('+')==-1)? localName.length():localName.indexOf('+');
		return localName.substring(0, firstPlus);
	}

	public static void main(String[] args) {
	
		EmailAddress obj = new EmailAddress();
		int noAddress = obj.numUniqueEmails(new String[]{"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"});
		System.out.println(noAddress);
	}

}
