package LeetCode_May_Challenge;

import java.util.HashMap;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for(int i: nums){
            int val = numCount.getOrDefault(i, 0);
            val++;
            numCount.put(i, val);
        }
        for(int i: numCount.keySet())
            if(numCount.get(i)>(nums.length)/2)
                return i;
        return -1;
    }
    public static void main(String[] args) {
        MajorityElement ob = new MajorityElement();
        System.out.println(ob.majorityElement(new int[]{1, 2, 3, 4, 5, 2, 3, 2, 2, 2, 2, 2, 2 ,2, 2, 2, 2}));
    }
}