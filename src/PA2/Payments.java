package PA2;

public class Payments {
	
	int[] pmt;
	public Payments(int n) {
		pmt = new int[n+1];
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Payments: ");
		for(int i=0; i<pmt.length; i++)
			sb.append(pmt[i]+" ");
		return sb.toString();
	}
}
