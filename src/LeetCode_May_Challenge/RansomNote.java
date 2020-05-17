package LeetCode_May_Challenge;

import java.util.HashMap;

public class RansomNote {
    
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mChar = new HashMap<>();

        for(char i: magazine.toCharArray()) {
            mChar.put(i, mChar.getOrDefault(i, 0)+1);
        }

        for(char i: ransomNote.toCharArray()){
            if(!mChar.containsKey(i))
                return false;
            else {
                int val = mChar.get(i);
                val--;
                if(val==0){
                    mChar.remove(i);
                } else {
                    mChar.put(i, val);
                }

            }
        }

        return true;

    }

    public static void main(String[] args) {
        RansomNote ob = new RansomNote();
        System.out.println(ob.canConstruct("aa", "aab"));
    }

}