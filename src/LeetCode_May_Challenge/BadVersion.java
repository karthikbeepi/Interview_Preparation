package LeetCode_May_Challenge;

public class BadVersion {
    
    public boolean isBadVersion(int pos){
        boolean[] versions = new boolean[]{  false, false, true, true,true};
        return versions[pos-1];
    }

    public int firstBadVersion(int n) {
        
        int low = 1;
        int high = n;
        int mid = -1;
        int firstBadVersion = -1;
        while(low<=high) {
            mid = low + (high-low)/2;
            if(isBadVersion(mid)){
                firstBadVersion = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return firstBadVersion;
    }

    public static void main(String[] args) {
        
        BadVersion ob = new BadVersion();
        System.out.println(ob.firstBadVersion(5));

    }



}