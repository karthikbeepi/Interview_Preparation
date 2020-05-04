package Google_Leetcode;

class OddEvenJump {

    int dp[];
    public int oddEvenJumps(int[] A) {
        
        dp = new int[A.length];

        for(int i=0; i<A.length-1; i++)
            dp[i] = -1;
        dp[A.length-1] = 1;

        for(int i=A.length-2; i>=0; i--){
            boolean jumpPossFlag = false;
            for(int j=1; i+j<=A.length-1; j+=2){
                if(A[i]<=A[i+j] && jumpPossible(i+j, A))
                {
                    dp[i] = 1;
                    jumpPossFlag = true;
                    break;
                }
            }
            if(!jumpPossFlag){
                for(int j=2; i+j<=A.length-1; j+=2){
                    if(A[i]>=A[i+j] && jumpPossible(i+j, A))
                    {
                        dp[i] = 1;
                        jumpPossFlag = true;
                        break;
                    }
                }
                if(!jumpPossFlag){
                    dp[i] = 0;
                }
            }
        }

        int count = 0;
        for(int i=0; i<A.length; i++)
            if(dp[i]==1)
                count++;
        return count;
    }

    private boolean jumpPossible(int i, int[] A) {

        if(dp[i]==-1) {
            for(int j=1; i+j<=A.length-1; j+=2){
                if(A[i]<=A[i+j] && jumpPossible(i+j, A))
                {
                    dp[i] = 1;
                }
            }

            for(int j=2; i+j<=A.length-1; j+=2){
                if(A[i]>=A[i+j] && jumpPossible(i+j, A))
                {
                    dp[i] = 1;
                }
            }
            return false;

        } 
        else {
            return (i==A.length-1)? true: false;
        }
    }

    public static void main(String[] args) {
        
        OddEvenJump obj = new OddEvenJump();
        int val = obj.oddEvenJumps(new int[]{5,1,3,4,2});
        System.out.println(val);
    }
}