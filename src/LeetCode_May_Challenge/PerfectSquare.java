package LeetCode_May_Challenge;

public class PerfectSquare {
    
    public boolean isPerfectSquare(int num) {
        
        if(num ==1)
            return true;
        int low = 1;
        int high = num;
        int mid = (low + (high-low))/2;
        while(low<=high){
            if(mid*mid == num){
                return true;
            } else if(mid * mid < num) {
                low = mid;
            } else {
                high = mid;
            }
            int newMid = (low + (high-low))/2;
            if(newMid == mid)
                return false;
            else 
                mid = newMid;
        }

        return false;
    }

    public static void main(String[] args) {
        PerfectSquare ob = new PerfectSquare();
        System.out.println(ob.isPerfectSquare(16));
    }

}