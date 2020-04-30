package PA2;

public class Combination {
	
	int noOfPeriods;
	int constantAmount;
	int intialBalance;
	public Combination(int n, int a, int b) {
		noOfPeriods = n;
		constantAmount = a;
		intialBalance = b;
	}
	
	@Override
	public String toString() {
		return "No of periods:"+noOfPeriods+"\tConstant amount:"+constantAmount+"\tInitial balance:"+intialBalance;
	}

}
