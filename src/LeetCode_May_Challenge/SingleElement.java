package LeetCode_May_Challenge;

public class SingleElement {

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = -1;
        while(low<=high){
            mid = low + ((high-low)/2);
            if(mid%2==0) {
                if(mid<nums.length-1 && nums[mid]==nums[mid+1]) {
                    low = mid+1;
                    continue;
                } else if(mid>0 && nums[mid]==nums[mid-1]) {
                    high = mid-1;
                    continue;
                } else 
                    return nums[mid];
            } else {
                if(mid<nums.length-1 && nums[mid]==nums[mid+1]) {
                    high = mid-1;
                    continue;
                } else if(mid>0 && nums[mid]==nums[mid-1]) {
                    low = mid+1;
                    continue;
                } else 
                    return nums[mid];
            }
        }
        return nums[0];
    }
    public static void main(String[] args) {
        SingleElement ob = new SingleElement();
        System.out.println(ob.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4}));
    }
}