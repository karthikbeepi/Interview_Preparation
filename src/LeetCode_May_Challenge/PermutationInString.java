package LeetCode_May_Challenge;

import java.util.HashMap;

public class PermutationInString {
    
    public boolean checkInclusion(String p, String s) { 
        if(s.length()<p.length())
            return false;
        HashMap<Character, Integer> pMap = getMap(p);
        HashMap<Character, Integer> sMap = getMap(s.substring(0, p.length()));
        int i = 1;
        if(sMap.equals(pMap))
                return true;
        while(i<s.length()-p.length()+1) {
            int val = sMap.get(s.charAt(i-1));
            val--;
            if(val==0)
                sMap.remove(s.charAt(i-1));
            else 
                sMap.put(s.charAt(i-1), val);
            val = sMap.getOrDefault(s.charAt(i+p.length()-1), 0);
            val++;
            sMap.put(s.charAt(i+p.length()-1), val);
            if(sMap.equals(pMap))
                return true;
            i++;
        }
        return false;
    }

    // Get hashmap for the string character counts
    private HashMap<Character, Integer> getMap(String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: p.toCharArray()) {
            int val = map.getOrDefault(c, 0);
            val++;
            map.put(c, val);
        }
		return map;
	}

    public static void main(String[] args) {
        PermutationInString ob = new PermutationInString();
        System.out.println(ob.checkInclusion("adc", "dcda"));
    }

}