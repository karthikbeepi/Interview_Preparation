package LeetCode_May_Challenge;

import java.util.HashSet;
import java.util.Set;

public class JewelStone {
    
    public int numJewelsInStones(String J, String S) {
        
        Set<Character> jewels = new HashSet<>();
        for(char i: J.toCharArray())
            if(jewels.add(i));
        
        int numOfJewels = 0;
        for(char i: S.toCharArray()){
            if(jewels.contains(i))
                numOfJewels++;
        }
        return numOfJewels;
    }
    public static void main(String[] args) {
        JewelStone ob = new JewelStone();
        System.out.println(ob.numJewelsInStones("aA", "aAAbbbb"));
    }

}