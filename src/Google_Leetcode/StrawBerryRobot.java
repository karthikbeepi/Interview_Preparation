package Google_Leetcode;

public class StrawBerryRobot {

	int maxAmount;
	int bushes[];
	int dp[][];
	
	public StrawBerryRobot(int t, int[] js) {
		maxAmount = t;
		bushes = js;
		dp = new int[bushes.length][maxAmount+1];
		for(int i=0; i<bushes.length; i++)
			for(int j=0; j<maxAmount+1; j++)
				dp[i][j] = -1;
	}

	public static void main(String[] args) {
		StrawBerryRobot obj = new StrawBerryRobot(100, new int[] {50, 10, 20, 30, 40});
		int maxPossible = obj.findMaxPossible();
		System.out.println(maxPossible);
	}

	private int findMaxPossible() {
		return findMaxPossible( bushes.length-1, maxAmount);
	}

	private int findMaxPossible( int included, int max) {
		
		if(included<0)
			return 0;
		if(dp[included][max]!=-1)
			return dp[included][max];
		else
		{
			int toInclude;
			if(bushes[included]>max)
				toInclude = 0;
			else
				toInclude = bushes[included];
			int withInclusion = toInclude + findMaxPossible(included-2, max-bushes[included]);
			int withOutInclusion = findMaxPossible(included-1, max);
			dp[included][max] = (withInclusion>withOutInclusion)? withInclusion: withOutInclusion;
			return dp[included][max];
		}
		
		
	}

}
