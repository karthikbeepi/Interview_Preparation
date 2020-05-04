package Google_Leetcode;

public class LargestSubArrayK {
    
    public static void main(String[] args) {
        LargestSubArrayK obj = new LargestSubArrayK();
        int[] arr = obj.getLargestSubArray(new int[]{28,24,30,42,5,15}, 3);
        for(int i: arr)
            System.out.print(i+" ");
        System.out.println();
    }

    private int[] getLargestSubArray(int[] arr, int k) {

        int maxVal = Integer.MIN_VALUE;
        int[] maxContiguosArr = new int[k];

        for(int i=0; i<arr.length-k+1; i++){
            int tempVal = 0;
            int[] tempContArr = new int[k];
            for(int j=0; j<k; j++)
            {
                tempContArr[j] = arr[i+j];
                tempVal+=arr[j+i];
            }
            if(tempVal>maxVal)
            {
                maxVal = tempVal;
                maxContiguosArr = tempContArr;
            }
        }
        return maxContiguosArr;
    }

}