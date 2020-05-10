package Google_Leetcode;

import java.util.Arrays;

public class MinimumAmplitude {
    
    public static void main(String[] args) {
        MinimumAmplitude obj = new MinimumAmplitude();
        int res = obj.getMinAmp(new int[]{10, 10, -6, 2, -3, 10});
        System.out.println(res);
    }

	private int getMinAmp(int[] A) {

        Arrays.sort(A);

        int noOfChanges = 3;
        
        if(A.length <= noOfChanges) 
            return 0;

        int smallestDifference = A[A.length-1]-A[0];
        
        int j=(A.length-1)-noOfChanges;

        for(int i=0 ; i < A.length-1-noOfChanges; i++) {
            if (smallestDifference > A[j]-A[i])
                smallestDifference = A[j]-A[i];
            j++;
        }
        
        return smallestDifference;
	}

}