package Google_Leetcode;

import java.util.Arrays;

public class CompareStrings {
    
    private int[] compare(String[] string1, String[] string2) {
        
        int[] compareVal = new int[string2.length];

        for(int j=0; j<string2.length; j++){
            int i = 0;
            for(String t: string1)
                if(strictlyCompare(t, string2[j])){
                    i++;
                }
            compareVal[j] = i;
        }

        return compareVal;
    }
    
    private boolean strictlyCompare(String string1, String string2) {
        char[] a = string1.toCharArray();
        Arrays.sort(a);

        char[] b = string2.toCharArray();
        Arrays.sort(b);

        int count1= 0, count2 = 0;

        for(int i=0; i<a.length-1; i++)
            if(a[i]==a[i+1])
                count1++;
        for(int i=0; i<b.length-1; i++)
            if(b[i]==b[i+1])
                count2++;
        
        return (count1<count2)? true:false;
    }

    public static void main(String[] args) {
        CompareStrings obj = new CompareStrings();
        int[] res = obj.compare(new String[]{"abcd", "aabc", "bd"}, new String[]{"aaa", "aa"});
        for(int i: res)
            System.out.print(i+" ");
        System.out.println();
    }
}