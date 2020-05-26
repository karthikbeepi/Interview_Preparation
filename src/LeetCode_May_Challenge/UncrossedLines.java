package LeetCode_May_Challenge;

public class UncrossedLines {
    
    int dp[][];

    public int max(int a, int b) {
        return (a>b)? a:b;
    }

    public int maxUncrossedLines(int[] A, int[] B) {
        
        dp = new int[A.length][B.length];
        if(A[0] == B[0])
            dp[0][0] = 1;
        else 
            dp[0][0] = 0;
        for(int k=1; k<A.length; k++)
            dp[k][0] = (A[k]==B[0])? 1: dp[k-1][0];
        
        for(int k=1; k<B.length; k++)
            dp[0][k] = (A[0]==B[k])? 1: dp[0][k-1];
        
        for(int i=1; i<A.length; i++) {

            for(int j=1; j<B.length; j++) {
                
                if(A[i]==B[j]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
                
            }
        }
        return dp[A.length-1][B.length-1];
    }

    public static void main(String[] args) {
        UncrossedLines ob = new UncrossedLines();
        System.out.println(ob.maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }
}