package Google_Leetcode;

import java.util.HashMap;

public class SplitString {
    

    public static void main(String[] args) {
        SplitString obj = new SplitString();
        int res = obj.SplitStringUniqChar(new String("abaca"));
        System.out.println(res);
    }

    private int SplitStringUniqChar(String S) {
        
        int count = 0;
        for(int i=1; i<S.length(); i++){
            if(validSplit(S.substring(0, i), S.substring(i)))
                count++;
        }
        return count;
    }

    private boolean validSplit(String substring1, String substring2) {

        HashMap<Character, Integer> lArrCharCount = new HashMap<>();
        HashMap<Character, Integer> rArrCharCount = new HashMap<>();

        for(char c: substring1.toCharArray())
            lArrCharCount.put(c, lArrCharCount.getOrDefault(c, 0)+1);

        for(char c: substring2.toCharArray())
            rArrCharCount.put(c, rArrCharCount.getOrDefault(c, 0)+1);

        if(lArrCharCount.size() == rArrCharCount.size())
            return true;
        else 
            return false;
    }

}