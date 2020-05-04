package Google_Leetcode;

import java.util.HashMap;

public class DominoSwitch {
    
    public int minDominoRotations(int[] A, int[] B) {
        // int[] countA = new int[7], countB = new int[7], same = new int[7];
        // int n = A.length;
        // for (int i = 0; i < n; ++i) {
        //     countA[A[i]]++;
        //     countB[B[i]]++;
        //     if (A[i] == B[i])
        //         same[A[i]]++;
        // }
        // for (int i  = 1; i < 7; ++i)
        //     if (countA[i] + countB[i] - same[i] == n)
        //         return n - Math.max(countA[i], countB[i]);
        // return -1;    
        

        HashMap<Integer, Integer> aCount = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> bCount = new HashMap<Integer, Integer>();
        int aMax = Integer.MIN_VALUE, valA = -1;
        int bMax = Integer.MIN_VALUE, valB = -1;

        for(int i: A) {
            if(!aCount.containsKey(i))
            {
                aCount.put(i, 1);
                if(aMax<0)
                {
                    aMax=1;
                    valA = i;
                }
            } else {
                int val = aCount.get(i);
                val++;
                aCount.put(i, val);
                if(val>aMax)
                {
                    aMax = val;
                    valA = i;
                }
            }
        }

        for(int i: B) {
            if(!bCount.containsKey(i))
            {
                bCount.put(i, 1);
                if(bMax<0)
                {
                    bMax=1;
                    valB = i;
                }
            } else {
                int val = bCount.get(i);
                val++;
                bCount.put(i, val);
                if(val>bMax)
                {
                    bMax = val;
                    valB = i;
                }
            }
        }

        boolean flag = true;
        if(bMax==B.length || aMax==A.length)
            return 0;
        if(bMax>=aMax){
            if(aCount.containsKey(valB) && aCount.get(valB)>=B.length-bMax){
                for(int i=0;i<B.length; i++){
                    if(B[i]!=valB){
                        if(A[i]==valB)
                        {
                            A[i] = B[i];
                            B[i] = valB;
                        }
                        else
                        {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            else 
            {
                flag = false;
            }
        } else {
            if(bCount.containsKey(valA)&&bCount.get(valA)>=A.length-aMax){
                for(int i=0;i<A.length; i++){
                    if(A[i]!=valA){
                        if(B[i]==valA)
                        {
                            B[i] = A[i];
                            A[i] = valA;
                        }
                        else
                        {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            else 
            {
                flag = false;
            }
        }
        if(!flag) {
            return -1;
        }
        else
        {
            return (bMax>aMax)? (B.length-bMax):(A.length-aMax);
        }
    }

    public static void main(String[] args) {
        DominoSwitch obj = new DominoSwitch();
        int minRot = obj.minDominoRotations(new int[]{2}, new int[]{5});
        System.out.println(minRot);
    }

}