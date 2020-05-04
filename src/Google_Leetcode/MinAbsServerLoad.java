package Google_Leetcode;

public class MinAbsServerLoad {

    private int getAbsLoadDiff(int[] loads) {

        int sum =0;
        for(int i: loads)
            sum+=i;
        int avg = sum/2;
        return sum-2*choose(loads.length, avg, loads);
    }

    int max(int a, int b) { return (a > b)? a : b; } 
    
    private int choose(int loadItem, int sum, int[] loads) {

        int i, w; 
        int dp[][] = new int[loadItem][sum+1]; 
       
        // Build table K[][] in bottom up manner 
        for (i = 0; i < loadItem; i++) 
        { 
            for (w = 0; w <= sum; w++) 
            { 
                if (i==0 || w==0) 
                    dp[i][w] = 0; 
                else if (loads[i] <= w) 
                    dp[i][w] = max(loads[i] + dp[i-1][w-loads[i]],  dp[i-1][w]); 
                else
                    dp[i][w] = dp[i-1][w]; 
            } 
        } 
        return dp[loadItem-1][sum]; 
    }

    public static void main(String[] args) {
        MinAbsServerLoad obj = new MinAbsServerLoad();
        int min = obj.getAbsLoadDiff(new int[]{1, 2, 3, 4, 5});
        System.out.println(min);
    }
}