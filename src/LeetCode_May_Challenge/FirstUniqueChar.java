package LeetCode_May_Challenge;

import java.util.HashMap;

public class FirstUniqueChar {
    
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        for(char c : s.toCharArray()) {
            int val = charCount.getOrDefault(c, 0);
            val++;
            charCount.put(c, val);
        }

        for(int i =0; i<s.length(); i++) {
            if(charCount.get(s.charAt(i))==1)
                return i;
        }

        return -1;
        
    }

    public static void main(String[] args) {
        FirstUniqueChar ob = new FirstUniqueChar();
        System.out.println(ob.firstUniqChar("leetcode"));
    }

}